package com.netapp.hhcc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.CombinedActiveExports;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.ShowmountImportData;
import com.netapp.ads.hhcc.vo.StorageVolume;

public class ShowmountDataImporterToDWH {

	JSONUtils jsonUtils = new JSONUtils();

	public static void main(String[] args) {

		new ShowmountDataImporterToDWH().importData("", 1,
				"C:/netapp/host-connections/PowerShell To Java/ShowmountExport.json");
	}

	public void importData(String dataWarehouseHostName, int port, String filePath) {

		Timestamp currentTimeStamp=NaDBUtils.getCurrentTimeStamp();
		
		CombinedActiveExports combinedActiveExports = (CombinedActiveExports) jsonUtils.readFile(filePath,
				CombinedActiveExports.class);

		if (combinedActiveExports != null) {

			String netAppSystemName = combinedActiveExports.getSystemName();
			String netAppSerialNumber = combinedActiveExports.getSystemSerialNumber();

			List<ExportsAndHost> dwhNfsExportList = NaDBUtils
					.getCurrentExportsAndHostInfoFromWareHouse(netAppSystemName, netAppSerialNumber);
			List<StorageVolume> storageVolumes = NaDBUtils.getStorageVolumes(netAppSystemName, netAppSerialNumber);

			if (storageVolumes == null || storageVolumes.size() == 0) {
				System.out.println("There are no volumes on " + netAppSystemName);
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

				if (thisExportDetail != null) {

					ShowmountImportData showmountImportData = new ShowmountImportData();

					showmountImportData.setShareId(thisExportDetail.getId());
					showmountImportData.setInternalVolId(thisExportDetail.getInternalVolumeId());
					showmountImportData.setStorageId(thisExportDetail.getStorageid());
					showmountImportData.setName(thisExportDetail.getName());
					showmountImportData.setProtocol("NFS");
					showmountImportData.setHostIp(exportEntry.getIp());
					bulkImport.add(showmountImportData);
					// importDataFromExportsAndHosts(exportDataForCurrentHost,exportData,hostId);
				} else {

					StorageVolume storageObject = null;

					for (int i = 0; i < storageVolumes.size(); i++) {

						StorageVolume dwhStorageVolume = storageVolumes.get(i);
						if (dwhStorageVolume.getVolumeName().equalsIgnoreCase(volumeName)) {
							storageObject = dwhStorageVolume;
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

						bulkImport.add(showmountImportData);
					} else {

						System.out.println("Skipping entry: " + exportLocation
								+ "is not in the DataWarehouse. We also failed to find the Volume (" + volumePath
								+ ")");
					}
				}
			}

            System.out.println("Bulk Insert or Update of (" + bulkImport.size()+ ") rows... Starting");

			// Insert showmount data into database
			for (ShowmountImportData showmountImportData : bulkImport) {
				NaDBUtils.insertIntoHostShowmount(showmountImportData,currentTimeStamp);
			}
            System.out.println("Bulk Insert or Update of (" + bulkImport.size()+ ") rows... Completed");

		} else {
			
		    System.out.println("We received no export information from the previous command.  This command requires that the command 'Collect the current NFS connected hosts and statistics' be run beforehand."); 
		}

        System.out.println("== JOB COMPLETE: Showmount Import ==");
	}

}
