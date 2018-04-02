package com.netapp.hhcc;

public class HHCCEntry {

	public static void main(String[] args) {
		
		
		//NFSDataCollector
		String exportFilePath = "C:/netapp/host-connections/PowerShell To Java/NFSExports.json";
		String array = "10.216.15.31";
		String vFilerName="vfiler0";
		NFSDataCollector nfsDataCollector=new NFSDataCollector();
		//These two are added for Authentication
		String adminUser = "root";
		String adminPassword = "P@ssw0rd";
		boolean clearNFSStats=false;
		nfsDataCollector.collectCurrentNFSConnectedHostsAndStatistics(array, vFilerName, exportFilePath,adminUser,adminPassword,clearNFSStats);

	
	
	
	}
}
