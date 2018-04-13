package com.netapp.ads.hhcc.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.ADSNfsStat;
import com.netapp.ads.hhcc.vo.ActiveHostBulkImport;
import com.netapp.ads.hhcc.vo.CombinedActiveExports;
import com.netapp.ads.hhcc.vo.DWHNFSShowMount;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NFSImportData;
import com.netapp.ads.hhcc.vo.NaSystemInfo;
import com.netapp.ads.hhcc.vo.NfsStatClientsInfo;
import com.netapp.ads.hhcc.vo.NfsStatStartInfo;
import com.netapp.ads.hhcc.vo.StorageVolume;

/**
 * This script will gather all hosts in the showmount table and compare those
 * against the nfs statistics. A new object is created and saved to a JSON file
 * containing the active host information.
 *
 * Existing Script Name:
 * Collect-the-current-NFS-connected-hosts-and-statistics.ps1 Existing script
 * Examples # Collect NFS statistics for Array (netapp1). Save output to default
 * location. Collect-the-current-NFS-connected-hosts-and-statistics.ps1 -Array
 * netapp1 -DataWarehouseAddress dwh_ip
 * 
 * .Example # Collect NFS mounts and exports for Array (netapp1). Save output to
 * custom location. Collect-the-current-NFS-connected-hosts-and-statistics.ps1
 * -Array netapp1 -DataWarehouseAddress dwh_ip -ExportFileLocation C:\output
 * 
 * .Example # Collect NFS mounts and exports for Array (netapp1) and vFiler
 * (vfiler1). Save output to default location
 * Collect-the-current-NFS-connected-hosts-and-statistics.ps1 -Array netapp1
 * -VfilerName vfiler1 -DataWarehouseAddress dwh_ip
 * 
 * .Example # Collect NFS statistics for Array (netapp1). Save output to default
 * location. Collect-the-current-NFS-connected-hosts-and-statistics.ps1 -Array
 * netapp1 -DataWarehouseAddress dwh_ip -ClearStats $True -Debugger $True
 */
@Service
public class NFSDataCollectorAndImporter {

	private static final Logger log = LoggerFactory.getLogger(NFSDataCollectorAndImporter.class);
	
	@Value("#{sysConfigRepository.findByPropertyName('oci.server.name').getPropertyValue()}")
	String ociServerName;
	
	@Value("#{sysConfigRepository.findByPropertyName('oci.server.data_model').getPropertyValue()}")
	String ociServerDataModel;
	
	@Value("#{sysConfigRepository.findByPropertyName('oci.server.port').getPropertyValue()}")
	int ociServerPort;
	
	@Value("#{sysConfigRepository.findByPropertyName('oci.server.user').getPropertyValue()}")
	String ociServerUser;
	
	@Value("#{sysConfigRepository.findByPropertyName('oci.server.password').getPropertyValue()}")
	String ociServerPassword;
	
	@Value("#{sysConfigRepository.findByPropertyName('vfiler.default_name').getPropertyValue()}")
	String vFilerDefaultName;
	
	@Autowired
	NetAppAPIUtils netAppAPIUtils;

	@Autowired
	NaDBUtils naDBUtils;
	
	JSONUtils jsonUtils = new JSONUtils();

	
	/*
	 * -Array netapp1 -DataWarehouseAddress dwh_ip -Port = "3306" -VfilerName
	 * vfiler1 -ClearStats $True -Debugger $True
	 */
	@Scheduled(fixedDelayString = "#{sysConfigRepository.findByPropertyName('nfs.schedule').getPropertyValue()}", initialDelayString = "#{sysConfigRepository.findByPropertyName('nfs.schedule.initial_delay').getPropertyValue()}")
	public void collectCurrentNFSConnectedHostsAndStatistics() {
		boolean clearNFSStats = false;
		log.info("NFS Collector and Importer Job started");
		String currentTimeStamp = NaDBUtils.getCurrentTimeStamp();
		
		// # Get-NaSystemInfo NetAPP API
		// get System Info from 7-Mode
		NaSystemInfo netAppSystemInfo = netAppAPIUtils.getNASystemInfo();
		log.info("Collecting the current stored showmount information from the Warehouse");

		// get Showmount info based on System Info
		ArrayList<DWHNFSShowMount> dWHShowmountList = naDBUtils.getDWHNFSShowMountsList(netAppSystemInfo.getSystemName(), netAppSystemInfo.getSystemSerialNumber());
		log.info("Total of shares on this NetApp Array: {} is {}", netAppSystemInfo.getSystemName(), dWHShowmountList.size());

		String context = null;
		List<String> testNetworks = new ArrayList<>();
		if (vFilerDefaultName != null) {
			log.debug("Getting a list of IPs on the target vFiler: {}", vFilerDefaultName);
			List<String> lstVFilerIps = netAppAPIUtils.getVFilerListIps(vFilerDefaultName);
			testNetworks.addAll(lstVFilerIps);
		} else {
			// if vFilerName not provided. This is still Pending waiting for Torrey Input
			// Get-NaNetInterface
			log.debug("Getting a list of interfaces");
			List<String> interfaceIpList = netAppAPIUtils.getNaNetInterface();
			testNetworks.addAll(interfaceIpList);
		}

		CombinedActiveExports combinedActiveExports = new CombinedActiveExports();
		if (testNetworks.size() == 0) {
			log.warn("Failed to Connect: Something bad has happened and we have no interfaces on the target array");
			log.warn("== JOB SKIPPED: Collect NFSSTATS ==");
		} else {
			// Collect the Showmount and NFS Statistics
			// CombinedActiveExports(SystemName,SystemId,SystemSerialNumber,CurrentTimeStamp,export_list,inactive_hosts
			for (String TestIpAddress : testNetworks) {
				CombinedActiveExports combinedActiveExportsByIp = compareCollectedNFSData(TestIpAddress, vFilerDefaultName, dWHShowmountList, context);
				if (combinedActiveExportsByIp != null) {
					combinedActiveExports.getExportList().addAll(combinedActiveExportsByIp.getExportList());
					combinedActiveExports.getInactiveHosts().addAll(combinedActiveExportsByIp.getInactiveHosts());
				}
			}

			if(combinedActiveExports.getExportList().size() > 0 || combinedActiveExports.getInactiveHosts().size() > 0) {
				combinedActiveExports.setNetAppSystemName(netAppSystemInfo.getSystemName());
				combinedActiveExports.setNetAppSystemSerial(netAppSystemInfo.getSystemSerialNumber());
				combinedActiveExports.setNetAppSystemId(netAppSystemInfo.getSystemId());
				combinedActiveExports.setLastSeen(currentTimeStamp);
				//jsonUtils.writeToFile(exportFilePath, combinedActiveExports);
				importData(combinedActiveExports);
				if(clearNFSStats) {
					netAppAPIUtils.clearNfsStats();
				}
			} else {
				log.info("No active exports found for {}", netAppSystemInfo.getSystemName());
			}
		}
		log.info("NFS Collector and Importer Job completed");
	}

	// Clear-NfsStats
	public void clearNFSStats() {
	}

	/*
	 * // Compare-CollectedNfsData This method is populating active and inactive
	 * host information. ActiveHost=if the DWH Host is existed in the NFS Host found
	 * on NetApp network, then the host is Active InactiveHost=if the DWH Host is
	 * not existed in the NFS Host found on NetApp network, then the host is Active
	 */
	public CombinedActiveExports compareCollectedNFSData(String netAppArray, String vFilerName, ArrayList<DWHNFSShowMount> currentMountedHosts, String context) {
		CombinedActiveExports combinedActiveExports = new CombinedActiveExports();
		if (currentMountedHosts.size() > 0) {
			log.info("compareCollectedNFSData(): Current mounted hosts: {}", currentMountedHosts.size());
			List<HostExportData> currentActiveNFSExports = new ArrayList<>();
			if (vFilerName != null && vFilerName.trim().length() != 0) {
				// $CurrentActiveNFSExports = Search-NetAppNfsStat -NetAppArray $NetAppArray
				// -Vfiler $Vfiler -Context $Context -ErrorAction SilentlyContinue -ErrorVar
				// SearchNetAppNfsStat
				currentActiveNFSExports = searchNetAppNfsStat(netAppArray, vFilerName);
			} else {
				// $CurrentActiveNFSExports = Search-NetAppNfsStat -NetAppArray $NetAppArray
				// -Context $Context -ErrorAction SilentlyContinue -ErrorVar SearchNetAppNfsStat
				currentActiveNFSExports = searchNetAppNfsStat(netAppArray, null);
			}

			if (currentActiveNFSExports.size() > 0) {
				log.info("compareCollectedNFSData(): Found {} count of hosts performing NFSOps on this Array: {}", currentActiveNFSExports.size(), context);
				for (DWHNFSShowMount currentHost : currentMountedHosts) {
					HostExportData thisExport = new HostExportData();
					for (HostExportData exportDetails : currentActiveNFSExports) {
						if (exportDetails.getHostName().equalsIgnoreCase(currentHost.getIp())
								|| exportDetails.getIp().equalsIgnoreCase(currentHost.getIp())) {
							thisExport.setHostName(exportDetails.getHostName());
							thisExport.setIp(exportDetails.getIp());
							thisExport.setExport(currentHost.getExport());
							thisExport.setOperations(exportDetails.getOperations());
							break;
						}
					}

					if (thisExport != null && (thisExport.getHostName().length()>0|| thisExport.getIp().length()>0)) {
							combinedActiveExports.getExportList().add(thisExport);
					} else
						log.info("compareCollectedNFSData(): No match found for host: {}", currentHost.getIp());
				}

				
				for (HostExportData activeClientNFS : currentActiveNFSExports) {
					boolean clientIdentifiedAsActive=false;
					for (HostExportData hostExportData : combinedActiveExports.getExportList()) {
						if(hostExportData.getIp().equalsIgnoreCase(activeClientNFS.getIp())) {
							clientIdentifiedAsActive=true;
						}
					}
					if(!clientIdentifiedAsActive) {
						HostExportData thisExport=new HostExportData();
						thisExport.setHostName(activeClientNFS.getHostName());
						thisExport.setIp(activeClientNFS.getIp());
						thisExport.setExport("-1");
						thisExport.setOperations(activeClientNFS.getOperations());
						//add data to inactive client list
						combinedActiveExports.getInactiveHosts().add(thisExport);
					}
				}
			}
		}
		log.info("Found Active clients {}. Inactive Clients: {}", combinedActiveExports.getExportList().size(), combinedActiveExports.getInactiveHosts().size());
		return combinedActiveExports;
	}

	// TODO Why vFiler notused??
	public List<HostExportData> searchNetAppNfsStat(String netAppArray, String vFilerName) {

		// $response = Invoke-NaSystemApi $request -ErrorVar NfsStatStart -ErrorAction
		// SilentlyContinue

		/*
		 * XMLUtils xmlUtils = new XMLUtils(); Document requestNFSStatStart =
		 * xmlUtils.newXML(); Element rootElement =
		 * xmlUtils.addRootElement(requestNFSStatStart,
		 * "nfs-stats-top-clients-list-iter-start");
		 * xmlUtils.addChildElement(requestNFSStatStart, rootElement, "maxClient",
		 * "1000000");
		 */
		// xmlUtils.saveXMLToFile(requestNFSStatStart, "C:/temp/file.xml");

		int maxClients = 10000;
		NfsStatStartInfo nfsStatStartInfo = netAppAPIUtils.getNfsStatStart(maxClients);

		int totalRecordCount = nfsStatStartInfo.getRecordCount();
		String collectorTag = nfsStatStartInfo.getCollectorTag();

		/*
		 * Document requestNFSStatClient = xmlUtils.newXML(); Element rootElement1 =
		 * xmlUtils.addRootElement(requestNFSStatClient,
		 * "nfs-stats-top-clients-list-iter-next");
		 * xmlUtils.addChildElement(requestNFSStatClient, rootElement1, "tag",
		 * collectorTag); xmlUtils.addChildElement(requestNFSStatClient, rootElement1,
		 * "maximum", String.valueOf(totalRecordCount));
		 */

		NfsStatClientsInfo nfsStatClientsInfo = netAppAPIUtils.getNfsStatClients(totalRecordCount, collectorTag);
		List<ADSNfsStat> nfsStats = nfsStatClientsInfo.getClientInfo();

		List<HostExportData> currentActiveExports = new ArrayList<>();
		for (ADSNfsStat nfsStat : nfsStats) {

			HostExportData thisExport = new HostExportData();
			String ipAddress = nfsStat.getClientInfo().replaceAll("::ffff:", "");
			String hostName = netAppAPIUtils.getHostNameByIp(ipAddress);

			thisExport.setIp(ipAddress);
			if (hostName != null)
				thisExport.setHostName(hostName);
			else
				thisExport.setHostName("-1");

			thisExport.setOperations(String.valueOf(nfsStat.getTotalOps()));
			currentActiveExports.add(thisExport);
		}
		return currentActiveExports;
	}

	public void importData(CombinedActiveExports combinedActiveExports) {
		String currentTimeStamp=NaDBUtils.getCurrentTimeStamp();
		if (combinedActiveExports != null) {
			// read csv file
			String netAppSystemName = combinedActiveExports.getNetAppSystemName();
			String netAppSerialNumber = combinedActiveExports.getNetAppSystemSerial();

			List<ExportsAndHost> dwhNfsExportList = naDBUtils.getCurrentExportsAndHostInfoFromWareHouse(netAppSystemName, netAppSerialNumber);
			List<StorageVolume> storageVolumes = naDBUtils.getStorageVolumes(netAppSystemName, netAppSerialNumber);

			String storageId;
			if (storageVolumes == null || storageVolumes.size() == 0) {
				log.info("There are no volumes on {}", netAppSystemName);
				storageId = "-1";
			} else {
				storageId = storageVolumes.get(0).getId();
			}

			List<HostExportData> exportList = combinedActiveExports.getExportList();
			Map<String, String> hostIpIdMap = naDBUtils.getHostIds();

			// TODO the below for loop not tested, as the exportList is empty.
			for (HostExportData exportEntry : exportList) {
				String exportLocation = exportEntry.getExport();
				String[] testExportLocationArr = exportLocation.split("/");
				String qTreePath = NetAppAPIUtils.getQtreePath(testExportLocationArr);
				String volumePath = NetAppAPIUtils.getVolumePath(testExportLocationArr);
				String volumeName = NetAppAPIUtils.getVolumeName(testExportLocationArr);

				ExportsAndHost thisExportDetail = null;
				for (ExportsAndHost exportAndHost : dwhNfsExportList) {
					String exportName = exportAndHost.getName();
					if (exportName != null && exportName.equalsIgnoreCase(qTreePath)) {
						thisExportDetail = exportAndHost;
						break;
					}
				}

				if (thisExportDetail == null) {
					for (ExportsAndHost exportAndHost : dwhNfsExportList) {
						String exportName = exportAndHost.getName();
						if (exportName != null && exportName.equalsIgnoreCase(volumePath)) {
							thisExportDetail = exportAndHost;
						}
					}
				}
				String thisHostId = hostIpIdMap.get(exportEntry.getIp());

				if(thisHostId==null)
					thisHostId="-1";
				
				// ExportsAndHost
				// exportDataForCurrentHost=getExportDataForGivenQtreeOrVolume(dwhNfsExportList,qTreePath,volumePath);
				if (thisExportDetail != null) {

					NFSImportData nfsImportData = new NFSImportData();

					nfsImportData.setShareId(thisExportDetail.getId());
					nfsImportData.setInternalVolId(thisExportDetail.getInternalVolumeId());
					nfsImportData.setName(thisExportDetail.getName());
					nfsImportData.setProtocol(thisExportDetail.getProtocol());
					nfsImportData.setHostId(thisHostId);
					nfsImportData.setIp(exportEntry.getIp());
					nfsImportData.setOperation(exportEntry.getOperations());

					naDBUtils.importNFSActiveHostInformation(nfsImportData, currentTimeStamp);
					// importDataFromExportsAndHosts(exportDataForCurrentHost,exportData,hostId);
				} else {

					if (volumeName != null && volumeName.length() > 0) {

						StorageVolume storageObject = null;
						for (int i = 0; i < storageVolumes.size(); i++) {

							StorageVolume dwhStorageVolume = storageVolumes.get(i);
							if (dwhStorageVolume.getVolumeName().equalsIgnoreCase(volumeName)) {
								storageObject = dwhStorageVolume;
								break;
							}
						}

						if (storageObject != null) {
							NFSImportData nfsImportData = new NFSImportData();

							nfsImportData.setShareId("-1");
							nfsImportData.setInternalVolId(storageObject.getStorageVolumeId());
							nfsImportData.setName(exportLocation);
							nfsImportData.setProtocol("NFS");
							nfsImportData.setHostId(thisHostId);
							nfsImportData.setIp(exportEntry.getIp());
							nfsImportData.setOperation(exportEntry.getOperations());
							naDBUtils.importNFSActiveHostInformation(nfsImportData, currentTimeStamp);
						} else {
							log.debug("Skipping entry: {} is not in the DataWarehouse. We also failed to find the Volume: {}", exportLocation, volumePath);
						}
					}
				}
			}

			for (HostExportData exportEntry : combinedActiveExports.getInactiveHosts()) {

				String thisHostId = hostIpIdMap.get(exportEntry.getIp());
				if (thisHostId == null)
					thisHostId = "-1";

				ActiveHostBulkImport newObject = new ActiveHostBulkImport();

				newObject.setProtocol("NFS");
				newObject.setHostId(thisHostId);
				newObject.setHostIp(exportEntry.getIp());
				newObject.setStorageId(storageId);
				newObject.setNfsOps(exportEntry.getOperations());
				naDBUtils.importInactiveHostInformation(newObject, currentTimeStamp);
			}
			log.debug("JOB COMPLETE: NFS Import ==");

			/// #Completed

			/*
			 * for (HostExportData inActiveHostExportData: inActiveHosts) {
			 * 
			 * String protocol="NFS"; String
			 * hostId=hostIpIdMap.get(inActiveHostExportData.getIp()); String
			 * hostIp=inActiveHostExportData.getIp(); //storageId; String
			 * nfsOps=inActiveHostExportData.getOperations();
			 * 
			 * //insert into nfs_host_conn_nomount
			 * NaDBUtils.importInactiveHostInformation(storageId,protocol,hostId,hostIp,
			 * nfsOps); }
			 */

		}
	} 
}
