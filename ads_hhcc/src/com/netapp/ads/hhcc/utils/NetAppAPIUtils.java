package com.netapp.ads.hhcc.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.converters.PowerShellToJavaConstants;
import com.netapp.ads.hhcc.jaxb.CIFShareInfo;
import com.netapp.ads.hhcc.jaxb.InterfaceConfigInfo;
import com.netapp.ads.hhcc.jaxb.InterfaceConfigInfoChild;
import com.netapp.ads.hhcc.jaxb.IpAddressInfo;
import com.netapp.ads.hhcc.jaxb.NfsTop;
import com.netapp.ads.hhcc.jaxb.NfsTopInfo;
import com.netapp.ads.hhcc.jaxb.Results;
import com.netapp.ads.hhcc.jaxb.SystemInfo;
import com.netapp.ads.hhcc.jaxb.V4PrimaryAddress;
import com.netapp.ads.hhcc.jaxb.VfilerInfo;
import com.netapp.ads.hhcc.jaxb.Vfilers;
import com.netapp.ads.hhcc.jaxb.VfnetInfo;
import com.netapp.ads.hhcc.jaxb.Vfnets;
import com.netapp.ads.hhcc.vo.ADSNfsStat;
import com.netapp.ads.hhcc.vo.CIFSSession;
import com.netapp.ads.hhcc.vo.Controller;
import com.netapp.ads.hhcc.vo.Credential;
import com.netapp.ads.hhcc.vo.DataSource;
import com.netapp.ads.hhcc.vo.Host;
import com.netapp.ads.hhcc.vo.NaLicense;
import com.netapp.ads.hhcc.vo.NaSystemInfo;
import com.netapp.ads.hhcc.vo.NfsStatClientsInfo;
import com.netapp.ads.hhcc.vo.NfsStatStartInfo;

import netapp.manage.NaAPIFailedException;
import netapp.manage.NaAuthenticationException;
import netapp.manage.NaElement;
import netapp.manage.NaProtocolException;
import netapp.manage.NaServer;

public class NetAppAPIUtils {

	NaServer naServerLocal = null;

	public static void main(String[] args) {

		
/*		NetAppAPIUtils netAppAPIUtils = new
		 NetAppAPIUtils("10.216.15.31",443,"root","P@ssw0rd");
		netAppAPIUtils.getNASystemInfo();*/

		/*
		 * List<String> lstInterfaceAddr=netAppAPIUtils.getNaNetInterface(); for (String
		 * ipAddr : lstInterfaceAddr) {
		 * 
		 * System.out.println(ipAddr); }
		 */

		/*
		 * List<String> lstIps=netAppAPIUtils.getVFilerListIps("vfiler0"); for (String
		 * string : lstIps) { System.out.println(string); }
		 */

		/*
		 * netAppAPIUtils.getNfsStatStart(1000);
		 */

		// CIFS Related testing
		/*Controller controller = new Controller();
		controller.setName("10.216.15.31");
		controller.setPort(443);
		controller.setCredential(new Credential("root", "P@ssw0rd"));

		// new NetAppAPIUtils().getNaCifsShares(controller);
		new NetAppAPIUtils().getNaCifsSessions(controller);*/

	}

	public NetAppAPIUtils() {
	}

	public NetAppAPIUtils(String naServerInetAddr, int port, String adminUserName, String adminPassword) {

		try {
			naServerLocal = new NaServer(naServerInetAddr, 1, 21);
			naServerLocal.setServerType(NaServer.SERVER_TYPE_FILER);
			naServerLocal.setTransportType(NaServer.TRANSPORT_TYPE_HTTPS);
			naServerLocal.setPort(port);
			naServerLocal.setStyle(NaServer.STYLE_LOGIN_PASSWORD);
			naServerLocal.setAdminUser(adminUserName, adminPassword);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public NaSystemInfo getNASystemInfo() {

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_SYSTEM_GET_INFO);
		Results netAppResults = executeNaApi(api);

		NaSystemInfo naSystemInfo = new NaSystemInfo();
		SystemInfo systemInfo = netAppResults.getSystemInfo();
		if (systemInfo != null) {

			naSystemInfo.setSystemName(netAppResults.getSystemInfo().getSystemName());
			naSystemInfo.setSystemSerialNumber(netAppResults.getSystemInfo().getSystemSerialNumber());
			naSystemInfo.setSystemId(netAppResults.getSystemInfo().getSystemId());

			System.out.println(naSystemInfo.getSystemName());
			System.out.println(naSystemInfo.getSystemSerialNumber());
			System.out.println(naSystemInfo.getSystemId());

		}
		return naSystemInfo;
	}

	public Results executeNaApi(NaElement api) {

		Results netAppResults = null;
		try {
			NaElement xo = naServerLocal.invokeElem(api);
			// System.out.println("systemName"+xo.getChildByName("system-info").getChildByName("system-name").getContent());
			System.out.println(xo.toPrettyString(""));

			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 

		return netAppResults;
	}

	public Results executeNaApi(NaElement api, NaServer naServer) {

		Results netAppResults = null;
		try {
			NaElement xo = naServer.invokeElem(api);
			// System.out.println("systemName"+xo.getChildByName("system-info").getChildByName("system-name").getContent());
			System.out.println(xo.toPrettyString(""));

			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Error Occured During execution of NetApp System API");
		}

		return netAppResults;
	}

	public Results executeNaApiForAController(NaElement api, NaServer naServerLocal) {

		Results netAppResults = null;
		try {
			NaElement xo = naServerLocal.invokeElem(api);
			System.out.println(xo.toPrettyString(""));

			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Error Occured During execution of NetApp System API");
		}
		return netAppResults;
	}

	public List<String> getNaNetInterface() {

		// executeNaApi();
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NET_IFCONFIG_GET);
		Results netAppResults = executeNaApi(api);
		List<String> lstIpAddress = new ArrayList<>();

		InterfaceConfigInfo interfaceConfigInfo = netAppResults.getInterfaceConfigInfo();
		if (interfaceConfigInfo != null) {

			InterfaceConfigInfoChild[] interfaceConfigInfoChild = interfaceConfigInfo.getInterfaceConfigInfoChild();
			for (InterfaceConfigInfoChild interfaceConfigInfo2 : interfaceConfigInfoChild) {

				V4PrimaryAddress v4PrimaryAddress = interfaceConfigInfo2.getV4PrimaryAddress();
				if (v4PrimaryAddress != null) {

					IpAddressInfo ipAddressInfo = v4PrimaryAddress.getIpAddressInfo();
					if (ipAddressInfo != null) {

						String ipAddress = ipAddressInfo.getAddress();
						lstIpAddress.add(ipAddress);
					}
				}
			}
		}

		return lstIpAddress;

	}

	public List<String> getVFilerListIps(String vfilerName) {

		List<String> lstIps = new ArrayList<>();
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_VFILER_LIST_INFO);
		api.addNewChild(PowerShellToJavaConstants.STR_VFILER, vfilerName);
		Results netAppResults = executeNaApi(api);

		VfilerInfo[] arrVFilerInfo = netAppResults.getVfilers().getVfilerInfo();
		for (VfilerInfo vfilerInfo2 : arrVFilerInfo) {

			Vfnets vfNets = vfilerInfo2.getVfnets();
			if (vfNets != null) {
				VfnetInfo[] arrVfNetInfo = vfNets.getVfnetInfo();
				for (VfnetInfo vfnetInfo2 : arrVfNetInfo) {
					lstIps.add(vfnetInfo2.getIpaddress());
				}
			}
		}
		return lstIps;
	}

	public VfilerInfo[] getVFilerListByController(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_VFILER_LIST_INFO);
		api.addNewChild(PowerShellToJavaConstants.STR_VFILER, controller.getvFilerName());

		Results netAppResults = executeNaApi(api, naServer);

		Vfilers vFilers = new Vfilers();
		VfilerInfo[] arrVfilerInfo = vFilers.getVfilerInfo();

		return arrVfilerInfo;
	}

	public NfsStatStartInfo getNfsStatStart(int maxClient) {

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NFS_STAT_START);
		api.addNewChild(PowerShellToJavaConstants.MAX_CLIENTS, String.valueOf(maxClient));
		Results netAppResults = executeNaApi(api);

		NfsStatStartInfo nfsStatStartInfo = new NfsStatStartInfo();
		if (netAppResults != null) {

			nfsStatStartInfo.setCollectorTag(netAppResults.getTag());
			nfsStatStartInfo.setRecordCount(netAppResults.getRecords());

		}

		return nfsStatStartInfo;
	}

	public NfsStatClientsInfo getNfsStatClients(int totalRecordsCount, String collectorTag) {

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NFS_STAT_CLIENTS);
		api.addNewChild(PowerShellToJavaConstants.MAXIMUM, String.valueOf(totalRecordsCount));
		api.addNewChild(PowerShellToJavaConstants.TAG, collectorTag);

		Results netAppResults = executeNaApi(api);
		NfsStatClientsInfo nfsStatClientsInfo = new NfsStatClientsInfo();

		if (netAppResults != null) {

			NfsTop nfsTop = netAppResults.getNfsTop();
			if (nfsTop != null) {
				NfsTopInfo[] arrNfsTopInfo = nfsTop.getNfsTopInfo();
				List<ADSNfsStat> clientInfo = new ArrayList<>();
				for (NfsTopInfo nfsTopInfo : arrNfsTopInfo) {

					clientInfo.add(new ADSNfsStat(nfsTopInfo.getClientInfo(), nfsTopInfo.getTotalOps()));
				}
				nfsStatClientsInfo.setClientInfo(clientInfo);
			}
		}

		return nfsStatClientsInfo;
	}

	public boolean clearNfsStats() {

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NFS_STATS_ZERO_STATS);
		Results netAppResults = executeNaApi(api);
		String status=netAppResults.getStatus();
		if("passed".equalsIgnoreCase(status)) {
			return true;
		} else
			return false;
	}
	
	public String getHostNameByIp(String ipAddress) {

		String hostName = null;
		try {
			InetAddress ip = InetAddress.getByName(ipAddress);
			hostName = ip.getHostName();
		} catch (UnknownHostException e1) {
		}

		return hostName;
	}

	public Host getHostByAddress(String hostAddress) {

		hostAddress=hostAddress.trim();
		
		Host host = new Host();

		try {
			InetAddress ip = InetAddress.getByName(hostAddress);
			String ipAddress=ip.getHostAddress();
			String hostName=ip.getHostName();
			host.setIpAddress(ipAddress);

			if(ipAddress.equalsIgnoreCase(hostName)) {
				host.setName("not resolved");
			} else {
				host.setName(hostName);
			}
			
		} catch (UnknownHostException e1) {
			host.setIpAddress(hostAddress);
			// e1.printStackTrace();
		}

		/*
		 * byte[] ipAddr = StorageUtils.asBytes(ipAddress); InetAddress inetAddressA;
		 * try { inetAddressA = InetAddress.getByAddress(ipAddr); if(inetAddressA!=null)
		 * { hostName=inetAddressA.getHostName(); System.out.println("----inetAddressA"
		 * + inetAddressA.getHostName()); } } catch (UnknownHostException e) {
		 * e.printStackTrace(); }
		 */

		return host;
	}

	public boolean isIPAccessible(String ipAddress) {

		boolean ipAccessible = true;
/*		Host hostName = getHostByAddress(ipAddress);
		if (hostName != null && hostName.getName() != null) {
			ipAccessible = true;
		}
		*/
		try {
			InetAddress ip = InetAddress.getByName(ipAddress);
			String hostName=ip.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			ipAccessible =false;
		}
		
		
		return ipAccessible;
	}

	public static String getQtreePath(String[] arrExportFldrs) {

		return getFilePath(arrExportFldrs, 4);

	}

	public static String getVolumePath(String[] arrExportFldrs) {

		return getFilePath(arrExportFldrs, 3);

	}

	public static String getVolumeName(String[] arrExportFldrs) {

		if (arrExportFldrs != null && arrExportFldrs.length > 2)
			return arrExportFldrs[2];
		else
			return "";
	}

	public static String getFilePath(String[] arrExportFldrs, int folderCount) {

		StringBuilder builder = new StringBuilder();

		if (arrExportFldrs.length<folderCount ) {
			folderCount = arrExportFldrs.length;
		}

		for (int i = 0; i < folderCount; i++) {

			String folderName = arrExportFldrs[i];
			builder.append(folderName + "/");
		}

		return builder.toString();
	}

	public NaServer getNaServer(String serverName, int port, String userName, String password) {

		NetAppAPIUtils netAppAPIUtils = new NetAppAPIUtils(serverName, port, userName, password);

		try {
			naServerLocal = new NaServer(serverName, 1, 21);
			naServerLocal.setServerType(NaServer.SERVER_TYPE_FILER);
			naServerLocal.setTransportType(NaServer.TRANSPORT_TYPE_HTTPS);
			naServerLocal.setPort(port);
			naServerLocal.setStyle(NaServer.STYLE_LOGIN_PASSWORD);
			naServerLocal.setAdminUser(userName, password);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return naServerLocal;
	}

	public NaServer getNaServerForAControler(Controller controller) {

		String controllerName = controller.getName();
		int port = controller.getPort();
		String adminName = controller.getCredential().getAdminName();
		String adminPassword = controller.getCredential().getAdminPassword();

		NaServer naServer = getNaServer(controllerName, port, adminName, adminPassword);
		return naServer;

	}

	// TODO implementation pending. This would be implemented as JDBC Calls to OCI
	// Database
	public List<DataSource> getOciNtapDataSources(String dataSourceModelName) {

		List<DataSource> dataSources = new ArrayList<>();
		
		
		return dataSources;
	}

	// TODO implementation pending. This would be implemented as JDBC Calls to OCI
	// Database
	public Credential getOciDataSourceCredential(DataSource dataSource, String haPartner) {

		Credential credential = new Credential();
		return credential;
	}

	public Controller connectNaController(String name, Credential credential) {

		Controller controller = new Controller();
		return controller;
	}

	public List<CIFShareInfo> getNaCifsShares(Controller controller) {

		List<CIFShareInfo> lstCIFShares = new ArrayList<>();
		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement("cifs-share-list-iter-start");

		Results netAppResults = executeNaApi(api, naServer);
		String tag = netAppResults.getTag();
		int recordCount = netAppResults.getRecords();

		NaElement apiNext = new NaElement("cifs-share-list-iter-next");
		apiNext.addNewChild(PowerShellToJavaConstants.TAG, tag);
		apiNext.addNewChild(PowerShellToJavaConstants.MAXIMUM, String.valueOf(recordCount));

		netAppResults = executeNaApi(apiNext, naServer);
		CIFShareInfo[] cifsShares = netAppResults.getcIFSShares().getcIFShareInfo();
		for (CIFShareInfo cifShareInfo : cifsShares) {
			lstCIFShares.add(cifShareInfo);
		}
		System.out.println("ShareName:" + netAppResults.getcIFSShares().getcIFShareInfo()[0].getShareName());
		System.out.println("Mount:" + netAppResults.getcIFSShares().getcIFShareInfo()[0].getMountPoint());

		return lstCIFShares;
	}

	public NaSystemInfo getNASystemInfo(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_SYSTEM_GET_INFO);
		Results netAppResults = executeNaApi(api, naServer);

		NaSystemInfo naSystemInfo = new NaSystemInfo();
		SystemInfo systemInfo = netAppResults.getSystemInfo();
		if (systemInfo != null) {

			naSystemInfo.setSystemName(netAppResults.getSystemInfo().getSystemName());
			naSystemInfo.setSystemSerialNumber(netAppResults.getSystemInfo().getSystemSerialNumber());
			naSystemInfo.setSystemId(netAppResults.getSystemInfo().getSystemId());

			System.out.println(naSystemInfo.getSystemName());
			System.out.println(naSystemInfo.getSystemSerialNumber());
			System.out.println(naSystemInfo.getSystemId());

		}
		return naSystemInfo;
	}

	public long getNATimeStamp(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement("clock-get-clock");
		Results netAppResults = executeNaApi(api, naServer);

		/*
		 * NaElement xo = s.invokeElem(api); System.out.println(xo.toPrettyString(""));
		 */
		return netAppResults.getUtcTime();
	}

	public List<NaLicense> getNALicense(Controller controller) {

		return null;
	}

	// TODO No cifs-session-list-iter-next not returning any data, so CIFSSession
	// Fetching logic and its jaxb implementation still pending
	public List<CIFSSession> getNaCifsSessions(Controller controller) {

		List<CIFSSession> cifsSessions = null;
		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement("cifs-session-list-iter-start");

		Results netAppResults = executeNaApi(api, naServer);
		String tag = netAppResults.getTag();
		int recordCount = netAppResults.getRecords();

		NaElement apiNext = new NaElement("cifs-session-list-iter-next");
		apiNext.addNewChild(PowerShellToJavaConstants.TAG, tag);
		apiNext.addNewChild(PowerShellToJavaConstants.MAXIMUM, String.valueOf(recordCount));
		netAppResults = executeNaApi(apiNext, naServer);

		// Fetch Sessions from Results object
		/*
		 * CIFShareInfo[] cifsShares=netAppResults.getcIFSShares().getcIFShareInfo();
		 * for (CIFShareInfo cifShareInfo : cifsShares) {
		 * lstCIFShares.add(cifShareInfo); }
		 * System.out.println("ShareName:"+netAppResults.getcIFSShares().getcIFShareInfo
		 * ()[0].getShareName());
		 * System.out.println("Mount:"+netAppResults.getcIFSShares().getcIFShareInfo()[0
		 * ].getMountPoint());
		 */

		return cifsSessions;
	}

	public String testNaCifs(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement("cifs-status");
		Results netAppResults = executeNaApi(api, naServer);

		// (Test-NaCifs -Controller $Controller -ErrorAction Ignore)
		String nsCiffsStatus = netAppResults.getStatus();

		return nsCiffsStatus;
	}

	public List<String> getShowMounts(String nfsServerName) {

		List<String> showMountData = new ArrayList<>();
		String line;
		Process process;

		try {
			process = Runtime.getRuntime().exec(PowerShellToJavaConstants.NW_API_SHOWMOUNT + nfsServerName);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while ((line = br.readLine()) != null) {
				showMountData.add(line);
			}
			process.waitFor();
			// System.out.println("exit: " + p.exitValue());
			process.destroy();
		} catch (Exception e) {

		}

		return showMountData;
	}

	/*
	 * getSystemInfo()
	 * 
	 * <results status='passed'> <system-info>
	 * <system-name>ads-dev-7dot1</system-name> <system-id>4225919154</system-id>
	 * <system-model>SIMBOX</system-model>
	 * <system-machine-type>SIMBOX</system-machine-type>
	 * <vendor-id>NetApp</vendor-id>
	 * <system-serial-number>1810000050</system-serial-number>
	 * <board-speed>2100</board-speed> <board-type>NetApp VSim</board-type>
	 * <cpu-serial-number>999999</cpu-serial-number>
	 * <number-of-processors>2</number-of-processors>
	 * <memory-size>4096</memory-size> <cpu-processor-id>0x206d2</cpu-processor-id>
	 * <cpu-microcode-version>1063</cpu-microcode-version>
	 * <maximum-aggregate-size>2199023255552</maximum-aggregate-size>
	 * <maximum-flexible-volume-size>17592186044416</maximum-flexible-volume-size>
	 * <maximum-flexible-volume-count>500</maximum-flexible-volume-count>
	 * <supports-raid-array>true</supports-raid-array> <prod-type>FAS</prod-type>
	 * </system-info> </results>
	 */

	/*
	 *
	 * //getVFilerListInfo(); <results status='passed'> <vfilers> <vfiler-info>
	 * <name>vfiler0</name> <ipspace>default-ipspace</ipspace>
	 * <uuid>00000000-0000-0000-0000-000000000000</uuid> <vfnets> <vfnet-info>
	 * <ipaddress>10.216.15.31</ipaddress> <netmask>255.255.255.0</netmask>
	 * <interface>e0a</interface> </vfnet-info> </vfnets> <dns-info>
	 * <dns-domain-name>services-eng.local</dns-domain-name> <dns-servers>
	 * <server>10.216.15.2</server> </dns-servers> </dns-info> <admin-host/>
	 * <vfstores> <vfstore-info> <path>/</path> <status>online</status>
	 * <is-etc>true</is-etc> </vfstore-info> </vfstores> </vfiler-info> </vfilers>
	 * </results>
	 */

}
