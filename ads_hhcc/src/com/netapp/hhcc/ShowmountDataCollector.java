package com.netapp.hhcc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.converters.PowerShellToJavaConstants;
import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.JSONUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.CurrentNFSMountedHosts;
import com.netapp.ads.hhcc.vo.Host;
import com.netapp.ads.hhcc.vo.HostExportData;
import com.netapp.ads.hhcc.vo.NaSystemInfo;

public class ShowmountDataCollector {

	NetAppAPIUtils netAppAPIUtils = null;
	NaDBUtils naDBUtils = new NaDBUtils();
	JSONUtils jsonUtils = new JSONUtils();

	public static void main(String[] args) {

		ShowmountDataCollector dataCollector = new ShowmountDataCollector();
		String exportFilePath = "C:/netapp/host-connections/PowerShell To Java/ShowmountExport.json";
		String array = "10.216.15.31";
		dataCollector.collectShowmountData(array, "vfiler0", exportFilePath);
	}

	public void collectShowmountData(String array, String vFilerName, String strExportFile) {

		netAppAPIUtils = new NetAppAPIUtils(array, 443, "root", "P@ssw0rd");
		
		Timestamp currentTimeStamp=naDBUtils.getCurrentTimeStamp();
		String context=array;
		
		List<String> testNetworks = new ArrayList<>();
		if (vFilerName != null) {
			context=context+"=>"+vFilerName;
			
			List<String> lstVFilerIps = netAppAPIUtils.getVFilerListIps(vFilerName);
			testNetworks.addAll(lstVFilerIps);

		} else {

			// if vFilerName not provided. This is still Pending waiting for Torrey Input
			// Get-NaNetInterface
			List<String> interfaceIpList = netAppAPIUtils.getNaNetInterface();
			testNetworks.addAll(interfaceIpList);
		}

		CurrentNFSMountedHosts currentNFSMountedHosts = new CurrentNFSMountedHosts();

		if (testNetworks.size() == 0) {

			System.out.println("Something bad has happened and we have no interfaces on the target array " + array);

		} else {

			NaSystemInfo netAppSystemInfo = netAppAPIUtils.getNASystemInfo();

			List<HostExportData> showMountExportList = new ArrayList<>();
			for (String testIpAddress : testNetworks) {
				if (netAppAPIUtils.isIPAccessible(testIpAddress)) {

					List<HostExportData> showMountExportListSub = searchShowMount(testIpAddress);
					showMountExportList.addAll(showMountExportListSub);
				} else {
					System.out.println("IP not reachable:" + testIpAddress);
				}
			}

			if(showMountExportList.size()>0) {
				currentNFSMountedHosts.setSystemName(netAppSystemInfo.getSystemName());
				currentNFSMountedHosts.setSystemId(netAppSystemInfo.getSystemId());
				currentNFSMountedHosts.setSystemSerialNumber(netAppSystemInfo.getSystemSerialNumber());
				currentNFSMountedHosts.setLastSeen(naDBUtils.getCurrentTimeStamp());
				currentNFSMountedHosts.setExportList(showMountExportList);
				
		        System.out.println("Found a total of " + currentNFSMountedHosts.getExportList().size() + " active exports for ("+context+")");
				jsonUtils.writeToFile(strExportFile, currentNFSMountedHosts);
			} else {
		        System.out.println("No active exports found for ("+context+")");
			}
		}
	}

	// TODO Pending implementation
	// Collect all mounted host details using Showmount -a NFSServer
	public List<HostExportData> searchShowMount(String nfsServer) {

		// $mounted_hosts = $(showmount -a $NfsServer)
		// Call showmount -a nfsServer based on OS

		List<HostExportData> currentMountedHosts = new ArrayList<>();

		 System.out.println("Execute {showmount -a " + nfsServer + "} to see the current hosts.");

		List<String> mountedHosts = netAppAPIUtils.getShowMounts(nfsServer);

		if (mountedHosts.size()==0 && PowerShellToJavaConstants.TESTING == true) {

			mountedHosts.add("All mount points on 10.216.15.31:");
			mountedHosts.add("10.216.15.106                      : /vol/uat_nfs1_multiqtree");
			mountedHosts.add("10.216.49.26                       : /vol/uat_multiowner/uatapp2");
			mountedHosts.add("10.216.49.26                       : /vol/uat_nfs1_multiqtree/nfs1q2");
			mountedHosts.add("10.216.49.38                       : /vol/uat_nfs1_multiqtree/nfs1q1");
			mountedHosts.add("");
		}
		for (String mountedHostLine : mountedHosts) {

			String mounted_host_array[] = mountedHostLine.trim().split(":");

			if (mounted_host_array.length == 2 && mounted_host_array[0].length() > 0
					&& mounted_host_array[1].length() > 0) {

				String address = mounted_host_array[0];
				Host host = netAppAPIUtils.getHostByAddress(address);

				HostExportData thisHost = new HostExportData();
				thisHost.setHostname(host.getName());
				thisHost.setIp(host.getIpAddress());
				thisHost.setExport(mounted_host_array[1]);

				currentMountedHosts.add(thisHost);
			}
		}

		/*
		 * HostExportData thisHost=new
		 * HostExportData("","10.216.15.106","/vol/uat_nfs1_multiqtree","");
		 * HostExportData thisHost1=new
		 * HostExportData("","10.216.49.26","/vol/uat_multiowner/uatapp2","");
		 * HostExportData thisHost2=new
		 * HostExportData("","10.216.49.26","/vol/uat_nfs1_multiqtree/nfs1q2","");
		 * HostExportData thisHost3=new
		 * HostExportData("","10.216.49.38","/vol/uat_multiowner/uatapp2","");
		 * HostExportData thisHost4=new
		 * HostExportData("","10.216.49.38","/vol/uat_nfs1_multiqtree/nfs1q1","");
		 * currentMountedHosts.add(thisHost); currentMountedHosts.add(thisHost1);
		 * currentMountedHosts.add(thisHost2); currentMountedHosts.add(thisHost3);
		 * currentMountedHosts.add(thisHost4);
		 */
		return currentMountedHosts;
	}
}
