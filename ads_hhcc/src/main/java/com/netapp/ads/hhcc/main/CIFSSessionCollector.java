package com.netapp.ads.hhcc.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.netapp.ads.hhcc.jaxb.CIFSSessionInfo;
import com.netapp.ads.hhcc.jaxb.CIFShareInfo;
import com.netapp.ads.hhcc.jaxb.VfilerInfo;
import com.netapp.ads.hhcc.utils.ADSRestUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.Controller;
import com.netapp.ads.hhcc.vo.Credential;
import com.netapp.ads.hhcc.vo.NADataSource;
import com.netapp.ads.hhcc.vo.NaSystemInfo;

/***
 * Gathers a list of current CIFS sessions on all NetApp controllers present as
 * DataSources from an OCI server and uploads the information to a MySQL
 * database.
 * 
 * Get CIFS sessions on an OCI Server & load them to MySQL
 * 
 * @author bondmoha
 *
 */
@Service
public class CIFSSessionCollector {

	private static final Logger log = LoggerFactory.getLogger(CIFSSessionCollector.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${oci.server.name}")
	String ociServerName;
	
	@Value("${oci.server.data_model")
	String ociServerDataModel;
	
	@Value("${oci.server.port}")
	int ociServerPort;
	
	@Value("${oci.server.user}")
	String ociServerUser;
	
	@Value("${oci.server.password}")
	String ociServerPassword;
	
	@Value("${vfiler.default_name}")
	String vFilerDefaultName;
	
	@Value("${vfiler.default_uuid}")
	String vFilerDefaultUUID;
	
	@Value("${vfiler.status.dr_backup}")
	String vFilerDefaultDRBackup;

	@Autowired
	NetAppAPIUtils netAppAPIUtils;
	
	@Autowired
	ADSRestUtils adsRestUtils;
	
	//private static final String QUERY = "insert into  dwh_inventory.wcr_cifs_temp(DateTime,ControllerName, SerialNumber,VfilerName,VfilerUuid,VolumeName,ShareName,MountPoint,HostIp,HostName,WindowsUser,UnixUser) " + 
	//		" Values (:dateTime,:controllerName,:serialNumber,:vFilerName,:vFilerUUID,:volumeName,:shareName,:mountPoint,:hostIP,:hostName,:windowsUser,:unixUser)  ON DUPLICATE KEY UPDATE DateTime=NOW()";

	private static final String QUERY = "insert into  dwh_inventory.wcr_cifs_temp(DateTime,ControllerName, SerialNumber,VfilerName,VfilerUuid,VolumeName,ShareName,MountPoint,HostIp,HostName,WindowsUser,UnixUser) " + 
			" Values (?,?,?,?,?,?,?,?,?,?,?,?)  ON DUPLICATE KEY UPDATE DateTime=NOW()";

	public static void main(String[] args) {
		boolean forceHttps = false;
		boolean disableSrvrCertiCheck = false;
		boolean disablePingCheck = false;
		new CIFSSessionCollector().collectCFSSessions(forceHttps, disableSrvrCertiCheck, disablePingCheck);
	}

	//@Scheduled(fixedDelayString = "${cifs.schedule}")
	public void collectCFSSessions(boolean forceHttps, boolean disableSrvrCertiCheck, boolean disablePingCheck) {
		log.info("CIFS Session Collector and Importer Job started");
		log.info("Connecting to OCI server: {}", ociServerName);
		NADataSource[] dataSources = adsRestUtils.getNetAppDataSources();
		if(dataSources!=null) {
			log.info("Data Sources: {}", dataSources.length);
			for (NADataSource dataSource : dataSources) {

				List<Controller> dsControllers = new ArrayList<>();
				//List<DataSourcePackage> packages = dataSource.getPackages();
				
				String foundationIp=dataSource.getFoundationIp();
				Controller dsController=new Controller();

				dsController.setName(foundationIp);
				dsController.setPort(ociServerPort);
				dsController.setCredential(new Credential(ociServerUser, ociServerPassword));
				
				dsControllers.add(dsController);
				
				for (Controller dsController1 : dsControllers) {
					
					log.debug("Gathering data for controller: {}", dsController1.getName());

					NaSystemInfo systemInfo = netAppAPIUtils.getNASystemInfo(dsController1);
					long timestamp = netAppAPIUtils.getNATimeStamp(dsController1);
					//List<NaLicense> license = netAppAPIUtils.getNALicense(dsController1);

					// TODO:: is vFiler anme and controller name both are same?
					VfilerInfo[] vfilers = netAppAPIUtils.getVFilerListByController(dsController1);

					if (vfilers == null || vfilers.length == 0) {
						log.info("No VFilers found for the controller: {}. Trying default vFiler", dsController.getName());

						VfilerInfo vFilerInfo = new VfilerInfo();
						vFilerInfo.setName(vFilerDefaultName);
						vFilerInfo.setStatus("running");
						vFilerInfo.setUuid(vFilerDefaultUUID);
						vfilers = new VfilerInfo[1];
						vfilers[0] = vFilerInfo;
					} 

					for (VfilerInfo vfilerInfo : vfilers) {

						if (!vFilerDefaultDRBackup.equalsIgnoreCase(vfilerInfo.getStatus())) {
							dsController1.setvFilerName(vfilerInfo.getName());

							log.debug("Gathering CIFS information from vFiler: {}", vfilerInfo.getName());
							List<CIFShareInfo> cifsShares = netAppAPIUtils.getNaCifsShares(dsController1);
							List<CIFSSessionInfo> cifsSessions = netAppAPIUtils.getNaCifsSessions(dsController1);
							for (CIFShareInfo cifsShare : cifsShares) {
								for (CIFSSessionInfo cifsSession : cifsSessions) {
									List<String> cifsVolumens=netAppAPIUtils.getVolumes(cifsSession);
									String shareMount = cifsShare.getMountPoint().replace("/vol/", "");
									String[] arrShareMount=shareMount.split("/");
									if(arrShareMount.length>0)
										shareMount=arrShareMount[0];
									if (cifsVolumens.contains(shareMount)) {
										List<String> users=netAppAPIUtils.getUsers(cifsSession.getUser());
										Object[] params = {new Timestamp(timestamp), systemInfo.getSystemName(), systemInfo.getSystemSerialNumber(), vfilerInfo.getName()
										,vfilerInfo.getUuid(), shareMount, cifsShare.getShareName(),cifsShare.getMountPoint(), cifsSession.getHostIp(),cifsSession.getHostName()
										,users.get(0).trim(),users.get(1).trim() 
										};
										jdbcTemplate.update(QUERY, params);
									}
								}
							}
						}
						dsController1.setvFilerName(null);
					}
				}
			}
		} else {
			log.info("No Data Sources found!!!");
		}
		log.info("CIFS Session Collector and Importer Job completed");
	}

}
