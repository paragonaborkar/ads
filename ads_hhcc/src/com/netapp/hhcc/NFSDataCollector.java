package com.netapp.hhcc;

import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.ADSNfsStat;
import com.netapp.ads.hhcc.vo.CombinedActiveExports;
import com.netapp.ads.hhcc.vo.DWHNFSShowMount;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NaSystemInfo;
import com.netapp.ads.hhcc.vo.NfsStatClientsInfo;
import com.netapp.ads.hhcc.vo.NfsStatStartInfo;

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
public class NFSDataCollector {

	NetAppAPIUtils netAppAPIUtils = new NetAppAPIUtils("10.216.15.31", 443, "root", "P@ssw0rd");
	
	NaDBUtils naDBUtils = new NaDBUtils();
	JSONUtils jsonUtils=new JSONUtils();

	/*
	 * -Array netapp1 -DataWarehouseAddress dwh_ip -Port = "3306" -VfilerName
	 * vfiler1 -ClearStats $True -Debugger $True
	 */

	public void collectCurrentNFSConnectedHostsAndStatistics(String array, String vFilerName, String exportFilePath)
			 {

		

		// # Get-NaSystemInfo NetAPP API
		// get System Info from 7-Mode
		NaSystemInfo netAppSystemInfo = netAppAPIUtils.getNASystemInfo();

		// get Showmount info based on System Info
		ArrayList<DWHNFSShowMount> dWHShowmountList = naDBUtils.getDWHNFSShowMountsList(netAppSystemInfo.getSystemName(),
				netAppSystemInfo.getSystemSerialNumber());

		String context=null;
		/*
		 * naSystemInfo dWHShowmountList testNetworks
		 * 
		 */
		// get vFileInfo

		List<String> testNetworks = new ArrayList<>();

		if (vFilerName != null) {
			List<String> lstVFilerIps = netAppAPIUtils.getVFilerListIps(vFilerName);
			testNetworks.addAll(lstVFilerIps);

		} else {

			// if vFilerName not provided. This is still Pending waiting for Torrey Input
			// Get-NaNetInterface
			List<String> interfaceIpList = netAppAPIUtils.getNaNetInterface();
			testNetworks.addAll(interfaceIpList);
		}

		CombinedActiveExports combinedActiveExports =new CombinedActiveExports();

		if (testNetworks.size() == 0) {
			
			System.out.println("Something bad has happened and we have no interfaces on the target array");

		} else 	{

			// Collect the Showmount and NFS Statistics
			// CombinedActiveExports(SystemName,SystemId,SystemSerialNumber,CurrentTimeStamp,export_list,inactive_hosts
			for (String TestIpAddress : testNetworks) {
				CombinedActiveExports combinedActiveExportsByIp = compareCollectedNFSData(testNetworks, vFilerName,
						dWHShowmountList,context);
				
				if(combinedActiveExportsByIp!=null) {
					combinedActiveExports.getExportList().addAll(combinedActiveExportsByIp.getExportList());
					combinedActiveExports.getInactiveHosts().addAll(combinedActiveExportsByIp.getInactiveHosts());
				}
			}
			
			combinedActiveExports.setSystemName(netAppSystemInfo.getSystemName());
			combinedActiveExports.setSystemSerialNumber(netAppSystemInfo.getSystemSerialNumber());
			combinedActiveExports.setSystemId(netAppSystemInfo.getSystemId());
			combinedActiveExports.setLastSeen(naDBUtils.getCurrentTimeStamp());
			
		}
		jsonUtils.writeToFile(exportFilePath, combinedActiveExports);
	}

	public static void main(String[] args) {

		NFSDataCollector dataCollector = new NFSDataCollector();
		String exportFile = "C:/netapp/host-connections/PowerShell To Java/NFSExports.json";
		String array = "10.216.15.31";
		dataCollector.collectCurrentNFSConnectedHostsAndStatistics(array, "vfiler0", exportFile);

	}
	// Clear-NfsStats
	public void clearNFSStats() {

	}

	/*// Compare-CollectedNfsData
	This method is populating active and inactive host information.
	ActiveHost=if the DWH Host is existed in the NFS Host found on NetApp network, then the host is Active
	InactiveHost=if the DWH Host is not existed in the NFS Host found on NetApp network, then the host is Active*/			
	public CombinedActiveExports compareCollectedNFSData(List<String> netAppArrayIps, String vFilerName,
			ArrayList<DWHNFSShowMount> currentMountedHosts,String context) {

		CombinedActiveExports combinedActiveExports = new CombinedActiveExports();

		if (currentMountedHosts.size() > 0) {

			System.out
					.println("Found " + currentMountedHosts.size() + " count of hosts performing NFSOps on this Array");
			
			List<HostExportData> currentActiveNFSExports=new ArrayList<>();
		
			if (vFilerName != null || vFilerName.trim().length() != 0) {

				// $CurrentActiveNFSExports = Search-NetAppNfsStat -NetAppArray $NetAppArray -Vfiler $Vfiler -Context $Context -ErrorAction SilentlyContinue -ErrorVar SearchNetAppNfsStat

				currentActiveNFSExports=searchNetAppNfsStat(netAppArrayIps, vFilerName);
			} else {
				// $CurrentActiveNFSExports = Search-NetAppNfsStat -NetAppArray $NetAppArray -Context $Context -ErrorAction SilentlyContinue -ErrorVar SearchNetAppNfsStat

				currentActiveNFSExports=searchNetAppNfsStat(netAppArrayIps, null);
			}
			
			if(currentActiveNFSExports.size()>0) {
			     System.out.println("Found " + currentActiveNFSExports.size()+  " count of hosts performing NFSOps on this Array ("+context +")");
	
			     for (DWHNFSShowMount currentHost : currentMountedHosts){
			    	 
			    	 HostExportData thisExport=null;
			    	 for (HostExportData exportDetails : currentActiveNFSExports) {
			    		 
			    		 if(exportDetails.getHostname().equalsIgnoreCase(currentHost.getStorageNodeName()) ||
			    				 exportDetails.getIp().equalsIgnoreCase(currentHost.getIp())) {
			    			 
			    			 thisExport.setHostname(exportDetails.getHostname());
			    			 thisExport.setIp(exportDetails.getIp());
			    			 thisExport.setExport(currentHost.getExport());
			    			 thisExport.setOperations(exportDetails.getOperations());
			    			 break;
			    		 }
					}
			    	 
			    	 if(thisExport!=null) {
			    		 combinedActiveExports.getExportList().add(thisExport);
			    	 } else {
			    		 System.out.println("No match found for host: " + currentHost.getIp());
			    	 }
			     }		
			     
			     List<HostExportData> activeHosts=combinedActiveExports.getExportList();
			     
			     List<HostExportData> inActiveHosts=new ArrayList<>();
			     for (HostExportData hostExportData : currentActiveNFSExports) {
			    	 if(!activeHosts.contains(hostExportData)) {
			    		 combinedActiveExports.getInactiveHosts().add(hostExportData);
			    	 }
				}
			}
		}
		
		System.out.println("Found Active clients:"+combinedActiveExports.getExportList().size()+"  Inactive Clients:"+combinedActiveExports.getInactiveHosts().size());
		return combinedActiveExports;
	}

	//TODO Why vFiler notused??
	public List<HostExportData> searchNetAppNfsStat(List<String> netAppArray, String vFilerName) {

		// $response = Invoke-NaSystemApi $request -ErrorVar NfsStatStart -ErrorAction
		// SilentlyContinue

		/*XMLUtils xmlUtils = new XMLUtils();
		Document requestNFSStatStart = xmlUtils.newXML();
		Element rootElement = xmlUtils.addRootElement(requestNFSStatStart, "nfs-stats-top-clients-list-iter-start");
		xmlUtils.addChildElement(requestNFSStatStart, rootElement, "maxClient", "1000000");*/
		// xmlUtils.saveXMLToFile(requestNFSStatStart, "C:/temp/file.xml");

		int maxClients=10000;
		NfsStatStartInfo nfsStatStartInfo = netAppAPIUtils.getNfsStatStart(maxClients);

		int totalRecordCount = nfsStatStartInfo.getRecordCount();
		String collectorTag = nfsStatStartInfo.getCollectorTag();

/*		Document requestNFSStatClient = xmlUtils.newXML();
		Element rootElement1 = xmlUtils.addRootElement(requestNFSStatClient, "nfs-stats-top-clients-list-iter-next");
		xmlUtils.addChildElement(requestNFSStatClient, rootElement1, "tag", collectorTag);
		xmlUtils.addChildElement(requestNFSStatClient, rootElement1, "maximum", String.valueOf(totalRecordCount));
*/
		
		NfsStatClientsInfo nfsStatClientsInfo = netAppAPIUtils.getNfsStatClients(totalRecordCount,collectorTag);
		List<ADSNfsStat> nfsStats = nfsStatClientsInfo.getClientInfo();

		List<HostExportData> currentActiveExports = new ArrayList<>();
		for (ADSNfsStat nfsStat : nfsStats) {

			HostExportData thisExport = new HostExportData();
			String ipAddress = nfsStat.getClientInfo().replaceAll("::ffff:", "");
			String hostName = netAppAPIUtils.getHostNameByIp(ipAddress);

			thisExport.setIp(ipAddress);
			thisExport.setHostname(hostName);

			thisExport.setOperations(String.valueOf(nfsStat.getTotalOps()));
		}
		return currentActiveExports;
	}

}
