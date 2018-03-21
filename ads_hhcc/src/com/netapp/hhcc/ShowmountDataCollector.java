package com.netapp.hhcc;

import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.CurrentNFSMountedHosts;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NaSystemInfo;

public class ShowmountDataCollector {
	
	NetAppAPIUtils netAppAPIUtils = new NetAppAPIUtils("10.216.15.31", 443, "root", "P@ssw0rd");
	NaDBUtils naDBUtils=new NaDBUtils();
	JSONUtils jsonUtils=new JSONUtils();
	
	public static void main(String[] args) {

		ShowmountDataCollector dataCollector = new ShowmountDataCollector();
		String exportFilePath = "C:/netapp/host-connections/PowerShell To Java/ShowmountExport.json";
		String array = "10.216.15.31";
		dataCollector.collectShowmountData(array, "vfiler0", exportFilePath);

	}
	
	public void collectShowmountData(String array, String vFilerName, String strExportFile) {
		
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

		CurrentNFSMountedHosts currentNFSMountedHosts=new CurrentNFSMountedHosts(); 

		if(testNetworks.size()==0) {
			
			System.out.println("Something bad has happened and we have no interfaces on the target array "+array);
					
		} else {
			
			NaSystemInfo netAppSystemInfo = netAppAPIUtils.getNASystemInfo();
			
			List<HostExportData> showMountExportList=new ArrayList<>();
			for (String testIpAddress : testNetworks) {
				if(netAppAPIUtils.isIPAccessible(testIpAddress)) {
					
					 List<HostExportData> showMountExportListSub=searchShowMount(testIpAddress);
					 showMountExportList.addAll(showMountExportListSub);
				} else {
					System.out.println("IP not reachable:"+testIpAddress);
				}
			}
			
			currentNFSMountedHosts.setSystemName(netAppSystemInfo.getSystemName());
			currentNFSMountedHosts.setSystemId(netAppSystemInfo.getSystemId());
			currentNFSMountedHosts.setSystemSerialNumber(netAppSystemInfo.getSystemSerialNumber());
			currentNFSMountedHosts.setLastSeen(naDBUtils.getCurrentTimeStamp());
			currentNFSMountedHosts.setExportList(showMountExportList);
		}
		jsonUtils.writeToFile(strExportFile, currentNFSMountedHosts);
	}
	
	// Collect all mounted host details using Showmount -a NFSServer
	public List<HostExportData> searchShowMount(String nfsServer) {
		
		//$mounted_hosts = $(showmount -a $NfsServer)
		
		List<HostExportData> currentMountedHosts=new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			
			HostExportData thisHost=new HostExportData();
			thisHost.setHostname("host1");
			thisHost.setIp("ip");
			thisHost.setExport("export");
		}
		return currentMountedHosts;
	}
}
