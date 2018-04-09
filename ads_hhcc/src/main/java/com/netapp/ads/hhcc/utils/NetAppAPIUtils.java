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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netapp.ads.hhcc.converters.HHCCConstants;
import com.netapp.ads.hhcc.jaxb.CIFSSessionInfo;
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
import com.netapp.ads.hhcc.jaxb.VolumeListInfo;
import com.netapp.ads.hhcc.vo.ADSNfsStat;
import com.netapp.ads.hhcc.vo.Controller;
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

@Service
public class NetAppAPIUtils {
	
	private static final Logger log = LoggerFactory.getLogger(NetAppAPIUtils.class);
	
	@Value("${oci.server.name}")
	String ociServerName;
	
	@Value("${oci.server.data_model}")
	String ociServerDataModel;
	
	@Value("${oci.server.port}")
	Integer ociServerPort;
	
	@Value("${oci.server.user}")
	String ociServerUser;
	
	@Value("${oci.server.password}")
	String ociServerPassword;

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

	@PostConstruct
	private void initNAServerLocal() {

		try {
			naServerLocal = new NaServer(ociServerName, 1, 21);
			naServerLocal.setServerType(NaServer.SERVER_TYPE_FILER);
			naServerLocal.setTransportType(NaServer.TRANSPORT_TYPE_HTTPS);
			naServerLocal.setPort(ociServerPort);
			naServerLocal.setStyle(NaServer.STYLE_LOGIN_PASSWORD);
			naServerLocal.setAdminUser(ociServerUser, ociServerPassword);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public NaSystemInfo getNASystemInfo() {

		NaElement api = new NaElement(HHCCConstants.NA_API_SYSTEM_GET_INFO);
		Results netAppResults = executeNaApi(api);

		NaSystemInfo naSystemInfo = new NaSystemInfo();
		SystemInfo systemInfo = netAppResults.getSystemInfo();
		if (systemInfo != null) {

			naSystemInfo.setSystemName(netAppResults.getSystemInfo().getSystemName());
			naSystemInfo.setSystemSerialNumber(netAppResults.getSystemInfo().getSystemSerialNumber());
			naSystemInfo.setSystemId(netAppResults.getSystemInfo().getSystemId());
			
			log.debug("getNASystemInfo: {}, {}, {}", naSystemInfo.getSystemName(), naSystemInfo.getSystemSerialNumber(), naSystemInfo.getSystemId());

		}
		return naSystemInfo;
	}

	public Results executeNaApi(NaElement api) {

		Results netAppResults = null;
		try {
			NaElement xo = naServerLocal.invokeElem(api);

			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			log.error("executeNaApi: Exception: ", e);
		} 


		return netAppResults;
	}

	public Results executeNaApi(NaElement api, NaServer naServer) {

		Results netAppResults = null;
		try {
			NaElement xo = naServer.invokeElem(api);
			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			log.error("executeNaApi: Exception: ", e);
		} 

		return netAppResults;
	}

	public Results executeNaApiForAController(NaElement api, NaServer naServerLocal) {

		Results netAppResults = null;
		try {
			NaElement xo = naServerLocal.invokeElem(api);
			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException | NaAPIFailedException| NaProtocolException | IOException e) {
			log.error("executeNaApi: Exception: ", e);
		} finally {
		}
		return netAppResults;
	}

	public List<String> getNaNetInterface() {

		// executeNaApi();
		NaElement api = new NaElement(HHCCConstants.NA_API_NET_IFCONFIG_GET);
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
		NaElement api = new NaElement(HHCCConstants.NA_API_VFILER_LIST_INFO);
		api.addNewChild(HHCCConstants.STR_VFILER, vfilerName);
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

		NaElement api = new NaElement(HHCCConstants.NA_API_VFILER_LIST_INFO);
		api.addNewChild(HHCCConstants.STR_VFILER, controller.getvFilerName());

		Results netAppResults = executeNaApi(api, naServer);

		Vfilers vFilers = new Vfilers();
		VfilerInfo[] arrVfilerInfo = vFilers.getVfilerInfo();

		return arrVfilerInfo;
	}

	public NfsStatStartInfo getNfsStatStart(int maxClient) {

		NaElement api = new NaElement(HHCCConstants.NA_API_NFS_STAT_START);
		api.addNewChild(HHCCConstants.MAX_CLIENTS, String.valueOf(maxClient));
		Results netAppResults = executeNaApi(api);

		NfsStatStartInfo nfsStatStartInfo = new NfsStatStartInfo();
		if (netAppResults != null) {

			nfsStatStartInfo.setCollectorTag(netAppResults.getTag());
			nfsStatStartInfo.setRecordCount(netAppResults.getRecords());

		}

		return nfsStatStartInfo;
	}

	public NfsStatClientsInfo getNfsStatClients(int totalRecordsCount, String collectorTag) {

		NaElement api = new NaElement(HHCCConstants.NA_API_NFS_STAT_CLIENTS);
		api.addNewChild(HHCCConstants.MAXIMUM, String.valueOf(totalRecordsCount));
		api.addNewChild(HHCCConstants.TAG, collectorTag);

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

		NaElement api = new NaElement(HHCCConstants.NA_API_NFS_STATS_ZERO_STATS);
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

	//FIXME
	public NaServer getNaServer(String serverName, int port, String userName, String password) {
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

	//FIXME
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
/*	public List<DataSource> getOciNtapDataSources(String dataSourceModelName) {

		List<DataSource> dataSources = new ArrayList<>();
		
		
		return dataSources;
	}*/

	// TODO implementation pending. This would be implemented as JDBC Calls to OCI
	// Database
/*	public Credential getOciDataSourceCredential(DataSource dataSource, String haPartner) {

		Credential credential = new Credential();
		return credential;
	}

	public Controller connectNaController(String name, Credential credential) {

		Controller controller = new Controller();
		return controller;
	}
*/
	public List<CIFShareInfo> getNaCifsShares(Controller controller) {

		List<CIFShareInfo> lstCIFShares = new ArrayList<>();
		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement("cifs-share-list-iter-start");

		Results netAppResults = executeNaApi(api, naServer);
		String tag = netAppResults.getTag();
		int recordCount = netAppResults.getRecords();

		NaElement apiNext = new NaElement("cifs-share-list-iter-next");
		apiNext.addNewChild(HHCCConstants.TAG, tag);
		apiNext.addNewChild(HHCCConstants.MAXIMUM, String.valueOf(recordCount));

		netAppResults = executeNaApi(apiNext, naServer);
		CIFShareInfo[] cifsShares = netAppResults.getcIFSShares().getcIFShareInfo();
		for (CIFShareInfo cifShareInfo : cifsShares) {
			lstCIFShares.add(cifShareInfo);
		}

		return lstCIFShares;
	}

	public NaSystemInfo getNASystemInfo(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);

		NaElement api = new NaElement(HHCCConstants.NA_API_SYSTEM_GET_INFO);
		Results netAppResults = executeNaApi(api, naServer);

		NaSystemInfo naSystemInfo = new NaSystemInfo();
		SystemInfo systemInfo = netAppResults.getSystemInfo();
		if (systemInfo != null) {

			naSystemInfo.setSystemName(netAppResults.getSystemInfo().getSystemName());
			naSystemInfo.setSystemSerialNumber(netAppResults.getSystemInfo().getSystemSerialNumber());
			naSystemInfo.setSystemId(netAppResults.getSystemInfo().getSystemId());
		}
		return naSystemInfo;
	}

	public long getNATimeStamp(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement(HHCCConstants.NA_API_CLOCK_GET_CLOCK);
		Results netAppResults = executeNaApi(api, naServer);
		return netAppResults.getUtcTime();
	}

	public List<NaLicense> getNALicense(Controller controller) {

		return null;
	}

	// TODO No cifs-session-list-iter-next not returning any data, so CIFSSession
	// Fetching logic and its jaxb implementation still pending
	public List<CIFSSessionInfo> getNaCifsSessions(Controller controller) {

		List<CIFSSessionInfo> cifsSessions = new ArrayList<>();
		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement(HHCCConstants.NA_API_CIFS_SESSION_LIST_ITER_START);

		Results netAppResults = executeNaApi(api, naServer);
		String tag = netAppResults.getTag();
		int recordCount = netAppResults.getRecords();

		NaElement apiNext = new NaElement(HHCCConstants.NA_API_CIFS_SESSION_LIST_ITER_NEXT);
		apiNext.addNewChild(HHCCConstants.TAG, tag);
		apiNext.addNewChild(HHCCConstants.MAXIMUM, String.valueOf(recordCount));
		netAppResults = executeNaApi(apiNext, naServer);

		CIFSSessionInfo arrayCIFSessionInfo[]=netAppResults.getcIFSSessions().getCifsSessionInfo();
		for (CIFSSessionInfo cifsSessionInfo : arrayCIFSessionInfo) {
			cifsSessions.add(cifsSessionInfo);
		}
		return cifsSessions;
	}

	public String testNaCifs(Controller controller) {

		NaServer naServer = getNaServerForAControler(controller);
		NaElement api = new NaElement(HHCCConstants.NA_API_CIFS_STATUS);
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
			process = Runtime.getRuntime().exec(HHCCConstants.NW_API_SHOWMOUNT + nfsServerName);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while ((line = br.readLine()) != null) {
				showMountData.add(line);
			}
			process.waitFor();
			process.destroy();
		} catch (Exception e) {

		}

		return showMountData;
	}

	public List<String> getVolumes(CIFSSessionInfo cifsSession) {
		
		List<String> volumes=new ArrayList<>();
		VolumeListInfo[] volumeList = cifsSession.getVolumeList().getVolumesListInfo();
		for (VolumeListInfo volumeListInfo : volumeList) {
			volumes.add(volumeListInfo.getVolume());
		}
	
		return volumes;
	}
	
	public List<String> getUsers(String sessionUser) {
		
		Pattern regex = Pattern.compile("\\((.+?)\\s+[-]\\s+(.+?)\\)");
		Matcher m = regex.matcher(sessionUser);
		
		List<String> users=new ArrayList<>();
		String windowsUser = "";
		String unixUser = "";
		while(m.find()) {
			
			windowsUser=m.group(1);
			unixUser=m.group(2);
		}
		users.add(windowsUser);
		users.add(unixUser);
		
		return users;

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
