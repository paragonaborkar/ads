package com.netapp.ads.hhcc.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.converters.PowerShellToJavaConstants;
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
import com.netapp.ads.hhcc.vo.CIFSShare;
import com.netapp.ads.hhcc.vo.Controller;
import com.netapp.ads.hhcc.vo.Credential;
import com.netapp.ads.hhcc.vo.DataSource;
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

	NaServer naServer = null;

	public static void main(String[] args) {

		NetAppAPIUtils netAppAPIUtils = new NetAppAPIUtils("10.216.15.31",443,"root","P@ssw0rd");
		//netAppAPIUtils.getNASystemInfo();
		
		/*List<String> lstInterfaceAddr=netAppAPIUtils.getNaNetInterface();
		for (String ipAddr : lstInterfaceAddr) {
			
			System.out.println(ipAddr);
		}*/
		
/*		List<String> lstIps=netAppAPIUtils.getVFilerListIps("vfiler0");
		for (String string : lstIps) {
			System.out.println(string);
		}*/
		
		netAppAPIUtils.getNfsStatStart(1000);
	}

	private NetAppAPIUtils() {
	}

	public NetAppAPIUtils(String naServerInetAddr,int port,String adminUserName,String adminPassword ) {

		try {
			naServer = new NaServer(naServerInetAddr, 1, 21);
			naServer.setServerType(NaServer.SERVER_TYPE_FILER);
			naServer.setTransportType(NaServer.TRANSPORT_TYPE_HTTPS);
			naServer.setPort(port);
			naServer.setStyle(NaServer.STYLE_LOGIN_PASSWORD);
			naServer.setAdminUser(adminUserName, adminPassword);
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public NaSystemInfo getNASystemInfo() {

		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_SYSTEM_GET_INFO);
		Results netAppResults=executeNaApi(api);

		NaSystemInfo naSystemInfo=new NaSystemInfo();
		SystemInfo systemInfo=netAppResults.getSystemInfo();
		if(systemInfo!=null) {

			naSystemInfo.setSystemName(netAppResults.getSystemInfo().getSystemName());
			naSystemInfo.setSystemSerialNumber(netAppResults.getSystemInfo().getSystemSerialNumber());
			naSystemInfo.setSystemId(netAppResults.getSystemInfo().getSystemId());
			
			System.out.println(naSystemInfo.getSystemName());
			System.out.println(naSystemInfo.getSystemSerialNumber());
			System.out.println(naSystemInfo.getSystemId());

		}
		return naSystemInfo; 
	}

	public NaSystemInfo getNASystemInfo(Controller controller) {

		return null;
	}
	
	public Timestamp getNATimeStamp(Controller controller) {

		return null;		
	}	
	
	public List<NaLicense> getNALicense(Controller controller) {

		return null;		
	}	
	
	public List<CIFSSession> getNaCifsSessions(Controller controller) {
		
		List<CIFSSession> cifsSessions=null;
		return cifsSessions;
	}
	public String testNaCifs(String controllerName) {

		//(Test-NaCifs -Controller $Controller -ErrorAction Ignore) 
		String nsCiffsStatus="started";
		return nsCiffsStatus;
	}
	
	

	
	public Results executeNaApi(NaElement api)
			 {

		Results netAppResults = null;
		try {
			NaElement xo = naServer.invokeElem(api);
			System.out.println(xo.toPrettyString(""));

			InputStream targetStream = new ByteArrayInputStream(xo.toPrettyString("").getBytes());
			netAppResults = (Results) JAXBUtils.getNetAppObjectForXML(targetStream, Results.class);

		} catch (NaAuthenticationException e) {
			e.printStackTrace();
		} catch (NaAPIFailedException e) {
			e.printStackTrace();
		} catch (NaProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return netAppResults;
	}

	public List<String> getNaNetInterface() {

		//executeNaApi();
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NET_IFCONFIG_GET);
		Results netAppResults=executeNaApi(api);
		List<String> lstIpAddress=new ArrayList<>();
		
		InterfaceConfigInfo interfaceConfigInfo=netAppResults.getInterfaceConfigInfo();
		if(interfaceConfigInfo!=null) {

			InterfaceConfigInfoChild[] interfaceConfigInfoChild=interfaceConfigInfo.getInterfaceConfigInfoChild();
			for (InterfaceConfigInfoChild interfaceConfigInfo2 : interfaceConfigInfoChild) {
				
				V4PrimaryAddress v4PrimaryAddress= interfaceConfigInfo2.getV4PrimaryAddress();
				if(v4PrimaryAddress!=null) {

					IpAddressInfo ipAddressInfo=v4PrimaryAddress.getIpAddressInfo();
					if(ipAddressInfo!=null) {

						String ipAddress=ipAddressInfo.getAddress();
						lstIpAddress.add(ipAddress);
					}
				}
			}
		}
		
		return lstIpAddress;
		
		}

	public List<String> getVFilerListIps(String vfilerName) {

		List<String> lstIps= new ArrayList<>();
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_VFILER_LIST_INFO);
		api.addNewChild(PowerShellToJavaConstants.STR_VFILER, vfilerName);
		Results netAppResults=executeNaApi(api);
		
		VfilerInfo[] arrVFilerInfo=netAppResults.getVfilers().getVfilerInfo();
		for (VfilerInfo vfilerInfo2 : arrVFilerInfo) {
			
			Vfnets vfNets=vfilerInfo2.getVfnets();
			if(vfNets!=null) {
				VfnetInfo[] arrVfNetInfo=vfNets.getVfnetInfo();
				for (VfnetInfo vfnetInfo2 : arrVfNetInfo) {
					lstIps.add(vfnetInfo2.getIpaddress());
				}
			}
		}
		return lstIps;
	}

	public VfilerInfo[] getVFilerListByController(String controllerName) {

		Vfilers vFilers=new Vfilers();
		VfilerInfo[] arrVfilerInfo=vFilers.getVfilerInfo();
		
		return arrVfilerInfo;
	}

	
	//TODO Missing real Implementation
	public NfsStatStartInfo getNfsStatStart(int maxClient) {

/*		$request.LoadXml("<nfs-stats-top-clients-list-iter-start><maxclients>100000</maxclients></nfs-stats-top-clients-list-iter-start>")
		#Invoke-NaSystemApi NetApp Api retrieve	
		$response = Invoke-NaSystemApi $request -ErrorVar NfsStatStart -ErrorAction SilentlyContinue
    	$TotalCount = $response.results.records
    	$CollectorTag = $Response.results.tag		    
		    *
		    */
		/*
		NaElement api = new NaElement("nfs-stats-top-clients-list-iter-start");
		api.addNewChild("maxclients","1000");
		api.addNewChild("tag","2086190157844225");
		*/
		
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NFS_STAT_START);
		api.addNewChild(PowerShellToJavaConstants.MAX_CLIENTS, String.valueOf(maxClient));
		Results netAppResults=executeNaApi(api);

		NfsStatStartInfo nfsStatStartInfo=new NfsStatStartInfo();
		if(netAppResults!=null) {

			nfsStatStartInfo.setCollectorTag(netAppResults.getTag());
			nfsStatStartInfo.setRecordCount(netAppResults.getRecords());
			
		}
		
		return nfsStatStartInfo;
	}
	
	//TODO Missing real Implementation
	public NfsStatClientsInfo getNfsStatClients(int totalRecordsCount,String collectorTag) {

/*		  $request.LoadXml("<nfs-stats-top-clients-list-iter-next><tag>"+$CollectorTag+"</tag><maximum>"+$TotalCount+"</maximum></nfs-stats-top-clients-list-iter-next>")
		  $output = Invoke-NaSystemApi $request -ErrorVar NfsStatClients -ErrorAction SilentlyContinue
		  $nfs_stats = $output.results."nfs-top"."nfs-top-info"	
*/
		
		NaElement api = new NaElement(PowerShellToJavaConstants.NA_API_NFS_STAT_CLIENTS);
		api.addNewChild(PowerShellToJavaConstants.MAXIMUM, String.valueOf(totalRecordsCount));
		api.addNewChild(PowerShellToJavaConstants.TAG, collectorTag);
		
		Results netAppResults=executeNaApi(api);
		NfsStatClientsInfo nfsStatClientsInfo=new NfsStatClientsInfo();
		
		if(netAppResults!=null) {
			
			//TODO Get Data
			NfsTop nfsTop=netAppResults.getNfsTop();
			if(nfsTop!=null) {
				NfsTopInfo[] arrNfsTopInfo=nfsTop.getNfsTopInfo();
				List<ADSNfsStat> clientInfo=new ArrayList<>();
				for (NfsTopInfo nfsTopInfo : arrNfsTopInfo) {

					clientInfo.add(new ADSNfsStat(nfsTopInfo.getClientInfo(),nfsTopInfo.getTotalOps()));
				}
				nfsStatClientsInfo.setClientInfo(clientInfo);
			}
		}
		
		return nfsStatClientsInfo;
	}

	public String getHostNameByIp(String ipAddress) {
	
		String hostName = null;
		/*
		 * $Result = [System.Net.Dns]::gethostentry($IPAddress) $Hostname =
		 * [string]$Result.HostName
		 */
		// Search DNS for the IP address of the host.
		// pull DNS Name of the host
	
		byte[] ipAddr = StorageUtils.asBytes(ipAddress);
		InetAddress inetAddressA;
		try {
			inetAddressA = InetAddress.getByAddress(ipAddr);
			if(inetAddressA!=null) {
				hostName=inetAddressA.getHostName();
				System.out.println("----inetAddressA" + inetAddressA.getHostName());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	
		return hostName;
	}
	
	public boolean isIPAccessible(String ipAddress) {
		
		boolean ipAccessible=false;
		String hostName=getHostNameByIp(ipAddress);
		if(hostName!=null) {
			ipAccessible=true;
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
		
		if(arrExportFldrs!=null && arrExportFldrs.length>=3)
			return arrExportFldrs[2];	
		else 
			return "";
	}
	
	public static String getFilePath(String[] arrExportFldrs,int folderCount) {
		
		if(folderCount>(arrExportFldrs.length))
			return null;
		else {
			StringBuilder builder=new StringBuilder();
			for (int i = 0; i < folderCount; i++) {
				
				String folderName=arrExportFldrs[i];
				builder.append("/"+folderName);
			}
		}
		return null;
	}
	
	public List<DataSource> getOciNtapDataSources(String dataSourceModelName) {
		
		///
		List<DataSource> dataSources=new ArrayList<>();
		return dataSources;
	}

	public Credential getOciDataSourceCredential(DataSource dataSource,String haPartner) {
		
		Credential credential=new Credential();
		return credential;
	}
	
	public Controller connectNaController(String name,Credential credential) {
		
		Controller controller=new Controller();
		return controller;
	}

	public List<CIFSShare> getCifsShares(Controller controller) {

		return null;
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
	  //getVFilerListInfo();
<results status='passed'>
	<vfilers>
		<vfiler-info>
			<name>vfiler0</name>
			<ipspace>default-ipspace</ipspace>
			<uuid>00000000-0000-0000-0000-000000000000</uuid>
			<vfnets>
				<vfnet-info>
					<ipaddress>10.216.15.31</ipaddress>
					<netmask>255.255.255.0</netmask>
					<interface>e0a</interface>
				</vfnet-info>
			</vfnets>
			<dns-info>
				<dns-domain-name>services-eng.local</dns-domain-name>
				<dns-servers>
					<server>10.216.15.2</server>
				</dns-servers>
			</dns-info>
			<admin-host/>
			<vfstores>
				<vfstore-info>
					<path>/</path>
					<status>online</status>
					<is-etc>true</is-etc>
				</vfstore-info>
			</vfstores>
		</vfiler-info>
	</vfilers>
</results>
	 */
	
	
}
