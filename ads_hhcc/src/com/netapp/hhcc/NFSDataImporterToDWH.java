package com.netapp.hhcc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.ActiveHostBulkImport;
import com.netapp.ads.hhcc.vo.CombinedActiveExports;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NFSImportData;
import com.netapp.ads.hhcc.vo.StorageVolume;

/**
 * 
 * Import statistics on NFS connected hosts. This script will import a JSON file
 * into the specific MySQL table.
 * 
 * @author bondmoha
 *
 */
public class NFSDataImporterToDWH {

	JSONUtils jsonUtils = new JSONUtils();
	
	public static void main(String[] args) {

		new NFSDataImporterToDWH().importData("C:/netapp/host-connections/PowerShell To Java/NFSExports.json");
	}

	public void importData(String filePath) {

		
		String currentTimeStamp=NaDBUtils.getCurrentTimeStamp();

		CombinedActiveExports combinedActiveExports = (CombinedActiveExports) jsonUtils.readFile(filePath,
				CombinedActiveExports.class);

		if (combinedActiveExports != null) {
			// read csv file
			String netAppSystemName = combinedActiveExports.getSystemName();
			String netAppSerialNumber = combinedActiveExports.getSystemSerialNumber();

			List<ExportsAndHost> dwhNfsExportList = NaDBUtils
					.getCurrentExportsAndHostInfoFromWareHouse(netAppSystemName, netAppSerialNumber);
			List<StorageVolume> storageVolumes = NaDBUtils.getStorageVolumes(netAppSystemName, netAppSerialNumber);

			String storageId;

			if (storageVolumes == null || storageVolumes.size() == 0) {
				System.out.println("There are no volumes on " + netAppSystemName);
				storageId = "-1";
			} else {
				storageId = storageVolumes.get(0).getId();
			}

			List<HostExportData> exportList = combinedActiveExports.getExportList();
			List<HostExportData> inActiveHosts = combinedActiveExports.getInactiveHosts();

			//HashMap<String, String> exportHostIpIds = new HashMap();

			Map<String, String> hostIpIdMap = NaDBUtils.getHostIds();

			// TODO the below for loop not tested, as the exportList is empty.
			List<NFSImportData> bulkImport = new ArrayList<>();
			for (HostExportData exportEntry : exportList) {

				//String hostId = hostIpIdMap.get(exportEntry.getIp());
				//exportHostIpIds.put(exportEntry.getIp(), hostId);

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

					bulkImport.add(nfsImportData);
					// importDataFromExportsAndHosts(exportDataForCurrentHost,exportData,hostId);
				} else {

					if (volumeName != null || volumeName.length() > 0) {

						StorageVolume storageObject = null;
						for (int i = 0; i < storageVolumes.size(); i++) {

							StorageVolume dwhStorageVolume = storageVolumes.get(i);
							if (dwhStorageVolume.getVolumeName().equalsIgnoreCase(volumeName)) {
								storageObject = dwhStorageVolume;
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

							bulkImport.add(nfsImportData);
						} else {

							System.out.println("Skipping entry: " + exportLocation
									+ "is not in the DataWarehouse. We also failed to find the Volume (" + volumePath
									+ ")");
						}
					}
				}
			}

			List<ActiveHostBulkImport> activeHostsBulkImportLst = new ArrayList<>();
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

				activeHostsBulkImportLst.add(newObject);
			}

			if (bulkImport.size() > 0) {

				// insert lstNFSBulkImportData into nfs_host_conn
				for (NFSImportData nfsImportData : bulkImport) {

					NaDBUtils.importNFSActiveHostInformation(nfsImportData,currentTimeStamp);
	                System.out.println("Bulk Insert or Update of (" + bulkImport.size()+ ") rows... complete");
				}
			}

			if (activeHostsBulkImportLst.size() > 0) {

				for (ActiveHostBulkImport activeHostBulkImport : activeHostsBulkImportLst) {

					NaDBUtils.importInactiveHostInformation(activeHostBulkImport,currentTimeStamp);
	                System.out.println("Bulk Insert or Update of (" + activeHostsBulkImportLst.size()+ ") rows... complete");

				}
			}
			System.out.println("== JOB COMPLETE: NFS Import ==");

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

		} else {
			System.out.println("Export File Missing:" + filePath);
		}

		NaDBUtils.releaseDBConnections();

	}

	/*
	 * public void importDataFromExportsAndHosts(ExportsAndHost
	 * exportDataForCurrentHost, HostExportData exportData, String hostId) {
	 * 
	 * 
	 * String shareId=exportDataForCurrentHost.getId(); String
	 * internalVolId=exportDataForCurrentHost.getInternalVolumeId(); String
	 * name=exportDataForCurrentHost.getName(); String
	 * protocol=exportDataForCurrentHost.getProtocol();
	 * 
	 * String ip=exportData.getIp(); String operation=exportData.getOperations();
	 * 
	 * 
	 * }
	 */

	public ExportsAndHost getExportDataForGivenQtreeOrVolume(List<ExportsAndHost> lstDWHExportsAndHosts,
			String qTreePath, String volumePath) {

		ExportsAndHost exportsData = null;
		;
		if (qTreePath != null) {
			exportsData = getExportDataByFilePath(lstDWHExportsAndHosts, qTreePath);
			if (exportsData == null) {
				exportsData = getExportDataByFilePath(lstDWHExportsAndHosts, volumePath);
			}
		}
		return exportsData;
	}

	public ExportsAndHost getExportDataByFilePath(List<ExportsAndHost> lstDWHExportsAndHosts, String filePath) {

		ExportsAndHost exportsData = null;
		for (ExportsAndHost exportsAndHost : lstDWHExportsAndHosts) {
			String exportName = exportsAndHost.getName();
			if (filePath.equalsIgnoreCase(exportName)) {

				exportsData = exportsAndHost;
			}
		}
		return exportsData;

	}
}
