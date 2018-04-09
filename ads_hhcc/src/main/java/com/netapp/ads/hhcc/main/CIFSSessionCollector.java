package com.netapp.ads.hhcc.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
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

	public void collectCFSSessions(boolean forceHttps, boolean disableSrvrCertiCheck, boolean disablePingCheck) {
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
		

		/*
		 * //Database connection using Rest $dataSources = Get-OciNtapDataSource
		 * -DataSourceModel $DataSourceModel
		 * -Verbose:([bool]$PSCmdlet.MyInvocation.BoundParameters['Verbose'].IsPresent)
		 * -ErrorAction Stop
		 * 
		 * foreach ($dataSource in $dataSources) { Write-Verbose -Message
		 * "Gathering controller information from DataSource: $($dataSource.Name)"
		 * 
		 * $dsControllers = @()
		 * 
		 * $dsControllers += [pscustomobject]@{ Name = (($dataSource.config.packages |
		 * Where-Object { $_.Id -eq 'Foundation' }).Attributes | Where-Object { $_.Name
		 * -eq 'ip' }).value Credential = Get-OciDataSourceCredential -DataSource
		 * $dataSource }
		 * 
		 * if ((($dataSource.config.packages | Where-Object { $_.Id -eq 'Foundation'
		 * }).Attributes | Where-Object { $_.Name -eq 'partner.ip' }).value) {
		 * $dsControllers += [pscustomobject]@{ Name = (($dataSource.config.packages |
		 * Where-Object { $_.Id -eq 'Foundation' }).Attributes | Where-Object { $_.Name
		 * -eq 'partner.ip' }).value Credential = Get-OciDataSourceCredential
		 * -DataSource $dataSource -HaPartner } }
		 * 
		 * foreach ($dsController in $dsControllers) { Write-Verbose -Message
		 * "Gathering data from controller: $($dsController.Name)"
		 * 
		 * try { $controller = Connect-NaController -Name $dsController.Name -Credential
		 * $dsController.Credential -Transient -ErrorAction Stop } catch { Write-Error
		 * -Message
		 * "Unable to connect to controller ($($dsController.Name)). Reason: $($_.Exception.Message)"
		 * continue }
		 * 
		 * Write-Verbose -Message 'Calling Get-NaSystemInfo' $systemInfo =
		 * Get-NaSystemInfo -Controller $controller
		 * 
		 * Write-Verbose -Message 'Calling Get-NaTime' $timestamp = Get-NaTime
		 * -Controller $controller
		 * 
		 * Write-Verbose -Message 'Calling Get-NaLicense' $license = Get-NaLicense
		 * -Controller $Controller
		 * 
		 * try { Write-Verbose -Message 'Calling Get-NaVfiler' $vfilers = Get-NaVfiler
		 * -Controller $controller -ErrorAction Stop } catch { if
		 * ($_.Exception.ErrorName -eq 'EAPILICENSE') { $global:Error.RemoveAt(0) } }
		 * 
		 * if (-not $vfilers) { $vfilers = @( [pscustomobject]@{ Name = 'vfiler0' Status
		 * = 'running' Uuid = '00000000-0000-0000-0000-000000000000' } ) }
		 * 
		 * foreach ($vfiler in ($vfilers | Where-Object { $_.Status -ne 'DR backup' }))
		 * { $controller.Vfiler = $vfiler.Name
		 * 
		 * if (($license | Where-Object { $_.Service -eq 'cifs' }).IsLicensed -and
		 * (Test-NaCifs -Controller $Controller -ErrorAction Ignore) -eq 'started') {
		 * Write-Verbose -Message
		 * "Gathering CIFS information from vFiler: $($vfiler.Name)"
		 * 
		 * Write-Verbose -Message 'Calling Get-NaCifsShare' $cifsShares =
		 * Get-NaCifsShare -Controller $controller
		 * 
		 * if (($cifsShares | Measure-Object).Count -eq 0) { Write-Warning -Message 'No
		 * CIFS shares found to process' continue }
		 * 
		 * Write-Verbose -Message 'Calling Get-NaCifsSession' $cifsSessions =
		 * Get-NaCifsSession -Controller $controller
		 * 
		 * if (($cifsSessions | Measure-Object).Count -eq 0) { Write-Warning -Message
		 * 'No CIFS sessions found to process' continue }
		 * 
		 * $dataTable.Merge(($( foreach ($share in $cifsShares) { foreach ($cifsSession
		 * in ($cifsSessions | Where-Object { $_.VolumesList.Volume -ccontains
		 * ($share.MountPoint -replace '/vol/' -replace '[/].*$') } | Group-Object
		 * -Property User, HostIp, HostName -NoElement)) { $sessionUser, $sessionHostIp,
		 * $sessionHostName = $cifsSession.Name -split '\s*,\s*', 3 $windowsUser,
		 * $unixUserName = [regex]::Matches($sessionUser,
		 * '\((.+?)\s+[-]\s+(.+?)\)').Groups[1, 2].Value
		 * 
		 * [pscustomobject][ordered]@{ DateTime = $timestamp.UtcTimeDT.ToString('s')
		 * ControllerName = $systemInfo.SystemName SerialNumber =
		 * $systemInfo.SystemSerialNumber VfilerName = $vfiler.Name VfilerUuid =
		 * $vfiler.Uuid VolumeName = $share.MountPoint -replace '[/]vol[/]' -replace
		 * '[/].*$' ShareName = $share.ShareName MountPoint = $share.MountPoint HostIp =
		 * $sessionHostIp HostName = $sessionHostName WindowsUser = $($windowsUser
		 * -replace '\\', '\\') UnixUser = $unixUserName } } } ) | Out-DataTable
		 * -TableName 'CifsSessions'), $true)
		 * 
		 * Write-Verbose -Message 'Setting DataTable PrimaryKey' Set-TablePrimaryKey
		 * -DataTable $datatable -PrimaryKey DateTime, SerialNumber, VfilerUuid,
		 * ShareName, HostIp, HostName, WindowsUser
		 * 
		 * $controller.Vfiler = $null } } } }
		 * 
		 * #region Upload to MySql Database
		 * 
		 * if ($dataTable.Rows.Count -eq 0) { Write-Warning -Message 'No DataTable
		 * entries found to upload' return }
		 */

	}

}
