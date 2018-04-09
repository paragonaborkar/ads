package com.netapp.ads.hhcc.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.CurrentNFSMountedHosts;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.Host;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NaSystemInfo;
import com.netapp.ads.hhcc.vo.ShowmountImportData;
import com.netapp.ads.hhcc.vo.StorageVolume;

@Service
public class ShowmountDataCollectorAndImporter {

	@Value("${oci.server.name}")
	String ociServerName;
	
	@Value("${oci.server.data_model}")
	String ociServerDataModel;
	
	@Value("${oci.server.port}")
	int ociServerPort;
	
	@Value("${oci.server.user}")
	String ociServerUser;
	
	@Value("${oci.server.password}")
	String ociServerPassword;
	
	@Value("${vfiler.default_name}")
	String vFilerDefaultName;
	
	private static final Logger log = LoggerFactory.getLogger(ShowmountDataCollectorAndImporter.class);
	
	@Autowired
	NetAppAPIUtils netAppAPIUtils;
	
	@Autowired
	NaDBUtils naDBUtils;
	
	JSONUtils jsonUtils = new JSONUtils();

	public void collectShowmountData() {
		String currentTimeStamp=NaDBUtils.getCurrentTimeStamp();

		String context = ociServerName;
		List<String> testNetworks = new ArrayList<>();
		if (vFilerDefaultName != null) {
			context=context+"=>"+vFilerDefaultName;
			List<String> lstVFilerIps = netAppAPIUtils.getVFilerListIps(vFilerDefaultName);
			testNetworks.addAll(lstVFilerIps);
		} else {

			// if vFilerName not provided. This is still Pending waiting for Torrey Input
			// Get-NaNetInterface
			List<String> interfaceIpList = netAppAPIUtils.getNaNetInterface();
			testNetworks.addAll(interfaceIpList);
		}

		CurrentNFSMountedHosts currentNFSMountedHosts = new CurrentNFSMountedHosts();

		if (testNetworks.size() == 0) {
			log.warn("Something bad has happened and we have no interfaces on the target array: {} ", ociServerName);
		} else {

			NaSystemInfo netAppSystemInfo = netAppAPIUtils.getNASystemInfo();

			List<HostExportData> showMountExportList = new ArrayList<>();
			for (String testIpAddress : testNetworks) {
				if (netAppAPIUtils.isIPAccessible(testIpAddress)) {
					List<HostExportData> showMountExportListSub = searchShowMount(testIpAddress);
					showMountExportList.addAll(showMountExportListSub);
				} else {
					log.info("IP not reachable: {}", testIpAddress);
				}
			}

			if(showMountExportList.size()>0) {
				currentNFSMountedHosts.setNetAppSystemName(netAppSystemInfo.getSystemName());
				currentNFSMountedHosts.setNetAppSystemId(netAppSystemInfo.getSystemId());
				currentNFSMountedHosts.setNetAppSystemSerialNumber(netAppSystemInfo.getSystemSerialNumber());
				currentNFSMountedHosts.setLastSeen(currentTimeStamp);
				currentNFSMountedHosts.setExportList(showMountExportList);
				log.info("Found a total of {} active exports for {} ", currentNFSMountedHosts.getExportList().size(), context);
				importData(currentNFSMountedHosts);
				//jsonUtils.writeToFile(exportFilePath, currentNFSMountedHosts);
			} else {
				log.info("No active exports found for  {} ", context);
			}
		}
	}

	// TODO Pending implementation
	// Collect all mounted host details using Showmount -a NFSServer
	public List<HostExportData> searchShowMount(String nfsServer) {

		// $mounted_hosts = $(showmount -a $NfsServer)
		// Call showmount -a nfsServer based on OS

		List<HostExportData> currentMountedHosts = new ArrayList<>();
		log.info("Execute showmount -a {} to see the current hosts.", nfsServer);
		List<String> mountedHosts = netAppAPIUtils.getShowMounts(nfsServer);
		for (String mountedHostLine : mountedHosts) {
			String mounted_host_array[] = mountedHostLine.trim().split(":");
			if (mounted_host_array.length == 2 && mounted_host_array[0].length() > 0
					&& mounted_host_array[1].length() > 0) {
				String address = mounted_host_array[0];
				Host host = netAppAPIUtils.getHostByAddress(address);
				HostExportData thisHost = new HostExportData();
				thisHost.setHostName(host.getName());
				thisHost.setIp(host.getIpAddress());
				thisHost.setExport(mounted_host_array[1]);
				currentMountedHosts.add(thisHost);
			}
		}
		return currentMountedHosts;
	}
	public void importData(CurrentNFSMountedHosts combinedActiveExports) {
		String currentTimeStamp=NaDBUtils.getCurrentTimeStamp();
		if (combinedActiveExports != null) {
			String netAppSystemName = combinedActiveExports.getNetAppSystemName();
			String netAppSerialNumber = combinedActiveExports.getNetAppSystemSerialNumber();
			List<ExportsAndHost> dwhNfsExportList = naDBUtils.getCurrentExportsAndHostInfoFromWareHouse(netAppSystemName, netAppSerialNumber);
			List<StorageVolume> storageVolumes = naDBUtils.getStorageVolumes(netAppSystemName, netAppSerialNumber);
			if (storageVolumes == null || storageVolumes.size() == 0) {
				log.info("There are no volumes on {}", netAppSystemName);
			}

			List<HostExportData> exportList = combinedActiveExports.getExportList();
			List<ShowmountImportData> bulkImport = new ArrayList<>();
			for (HostExportData exportEntry : exportList) {

				String exportLocation = exportEntry.getExport();
				String[] arrExportFldrs = exportLocation.split("/");
				String qTreePath = NetAppAPIUtils.getQtreePath(arrExportFldrs);
				String volumePath = NetAppAPIUtils.getVolumePath(arrExportFldrs);
				String volumeName = NetAppAPIUtils.getVolumeName(arrExportFldrs);

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
							break;
						}
					}
				}

				if (thisExportDetail != null) {
					ShowmountImportData showmountImportData = new ShowmountImportData();
					showmountImportData.setShareId(thisExportDetail.getId());
					showmountImportData.setInternalVolId(thisExportDetail.getInternalVolumeId());
					showmountImportData.setStorageId(thisExportDetail.getStorageid());
					showmountImportData.setName(thisExportDetail.getName());
					showmountImportData.setProtocol("NFS");
					showmountImportData.setHostIp(exportEntry.getIp());
					bulkImport.add(showmountImportData);
				} else {
					StorageVolume storageObject = null;
					for (int i = 0; i < storageVolumes.size(); i++) {
						StorageVolume dwhStorageVolume = storageVolumes.get(i);
						if (dwhStorageVolume.getVolumeName().equalsIgnoreCase(volumeName)) {
							storageObject = dwhStorageVolume;
							break;
						}
					}

					if (storageObject != null && volumeName.length() > 0) {
						ShowmountImportData showmountImportData = new ShowmountImportData();
						showmountImportData.setShareId("-1");
						showmountImportData.setInternalVolId(storageObject.getStorageVolumeId());
						showmountImportData.setStorageId(storageObject.getId());
						showmountImportData.setName(exportLocation);
						showmountImportData.setProtocol("NFS");
						showmountImportData.setHostIp(exportEntry.getIp());
						naDBUtils.insertIntoHostShowmount(showmountImportData,currentTimeStamp);
					} else {
						log.info("Skipping entry: {} is not in the DataWarehouse. We also failed to find the Volume {}", exportLocation, volumePath);
					}
				}
			}
		} else {
			log.info("We received no export information from the previous command.  This command requires that the command 'Collect the current NFS connected hosts and statistics' be run beforehand."); 
		}

		log.info("== JOB COMPLETE: Showmount Import ==");
	}
	
}
