package com.netapp.hhcc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.hhcc.jaxb.VfilerInfo;
import com.netapp.ads.hhcc.jdbc.NaDBUtils;
import com.netapp.ads.hhcc.utils.NetAppAPIUtils;
import com.netapp.ads.hhcc.vo.CIFSSession;
import com.netapp.ads.hhcc.vo.CIFSSessionsDataTableRow;
import com.netapp.ads.hhcc.vo.CIFSShare;
import com.netapp.ads.hhcc.vo.Controller;
import com.netapp.ads.hhcc.vo.DataSource;
import com.netapp.ads.hhcc.vo.DataSourceAttribute;
import com.netapp.ads.hhcc.vo.DataSourcePackage;
import com.netapp.ads.hhcc.vo.NaLicense;
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

public class CIFSSessionCollector {

/*	
 * 1) what is OCI Server?
 * 2) what is CIFS Session?
 * 3) what is NetApp Controller?
 * 4) What is Data Source?
Data ONTAP 7-Mode
Clustered Data ONTAP
*
*
*/		

	NetAppAPIUtils netAppAPIUtils = new NetAppAPIUtils("10.216.15.31", 443, "root", "P@ssw0rd");

	public static void main(String[] args) {
		
		String oCIServerName="";
		String dataSrcModelName="";
		boolean forceHttps=false;
		boolean disableSrvrCertiCheck=false;
		boolean disablePingCheck=false;
		
		new CIFSSessionCollector().collectCFSSessions(oCIServerName, dataSrcModelName, forceHttps, disableSrvrCertiCheck, disablePingCheck);
	}
	public void collectCFSSessions(String oCIServerName,String dataSrcModelName,boolean forceHttps,boolean disableSrvrCertiCheck,
			boolean disablePingCheck
			) {

		List<DataSource> dataSources = netAppAPIUtils.getOciNtapDataSources(dataSrcModelName);
		List<CIFSSessionsDataTableRow> cIFSSessionsDataTable=new ArrayList<>();

		for (DataSource dataSource : dataSources) {

			List<Controller> dsControllers=new ArrayList<>();
			List<DataSourcePackage>packages=dataSource.getPackages();
			for (DataSourcePackage dataSourcePackage : packages) {
				
				if("Foundation".equalsIgnoreCase(dataSourcePackage.getId())) {
					
					List<DataSourceAttribute> attributes=dataSourcePackage.getAttributes();
					for (DataSourceAttribute attribute : attributes) {
						
						String name=attribute.getName();
						if("ip".equalsIgnoreCase(attribute.getName())) {
							Controller dsController=new Controller();
							dsController.setName(attribute.getValue());
				            
							//Credential = Get-OciDataSourceCredential -DataSource $dataSource -HaPartner
							dsController.setCredential(netAppAPIUtils.getOciDataSourceCredential(dataSource,null));
						}
						
						if("partner.ip".equalsIgnoreCase(attribute.getName())) {
							Controller dsController=new Controller();
							dsController.setName(attribute.getValue());
				            
							//Credential = Get-OciDataSourceCredential -DataSource $dataSource -HaPartner
							dsController.setCredential(netAppAPIUtils.getOciDataSourceCredential(dataSource,"-HaPartner"));
						}
					}
				}
				for (Controller dsController: dsControllers) {
					
					System.out.println("Gathering data from controller:"+ dsController.getName());
					Controller controller=netAppAPIUtils.connectNaController(dsController.getName(), dsController.getCredential());
					
					NaSystemInfo systemInfo = netAppAPIUtils.getNASystemInfo(controller);
					Timestamp timestamp=netAppAPIUtils.getNATimeStamp(controller);
					List<NaLicense> license=netAppAPIUtils.getNALicense(controller);
					
					//TODO:: is vFiler anme and controller name both are same?
					VfilerInfo[] vfilers=netAppAPIUtils.getVFilerListByController(controller.getName());
					
					if(vfilers==null && vfilers.length==0) {

						VfilerInfo vFilerInfo=new VfilerInfo();
						vFilerInfo.setName("vfiler0");
						vFilerInfo.setStatus("running");
						vFilerInfo.setUuid("00000000-0000-0000-0000-000000000000");
						vfilers=new VfilerInfo[1];
						vfilers[0]=vFilerInfo;
					}

					for (VfilerInfo vfilerInfo : vfilers) {
					
						if(!"DR backup".equalsIgnoreCase(vfilerInfo.getStatus())) {
							
							controller.setvFilerName(vfilerInfo.getName());
							
							//TODO This logic and data manipulation has to be double verified
							for (NaLicense licenseObj : license) {
								if("cifs".equalsIgnoreCase(licenseObj.getService()) && licenseObj.isLicensed() && "started".equalsIgnoreCase(netAppAPIUtils.testNaCifs(controller.getName())))  {
									

									System.out.println("Gathering CIFS information from vFiler: "+vfilerInfo.getName());
									System.out.println("Calling Get-NaCifsShare");
									List<CIFSShare> cifsShares=netAppAPIUtils.getCifsShares(controller);
									List<CIFSSession> cifsSessions=netAppAPIUtils.getNaCifsSessions(controller);
									
									
									for (CIFSShare cifsShare : cifsShares) {
										for (CIFSSession cifsSession: cifsSessions) {
											String shareMount=cifsShare.getMountPoint().replace( "/vol/", "");
											shareMount=shareMount.replace("[/].*$","");
											
											
											if(cifsSession.getVolumeList().contains(shareMount)) {
												CIFSSessionsDataTableRow row=new CIFSSessionsDataTableRow();

												//$unixUserName = [regex]::Matches($sessionUser, '\((.+?)\s+[-]\s+(.+?)\)').Groups[1, 2].Value
												Timestamp dateTime=NaDBUtils.getCurrentTimeStamp();
												row.setControllerName(systemInfo.getSystemName());
												row.setSerialNumber(systemInfo.getSystemSerialNumber());
												row.setvFileName(vfilerInfo.getName());
												row.setvFilerUuid(vfilerInfo.getUuid());
												row.setVolumeName(shareMount);
												row.setShareName(cifsShare.getShareName());
												row.setMountPoint(cifsShare.getMountPoint());
												row.setHostIp(""); //TODO
												row.setHostName("");//TODO
												row.setWindowUser("");//TODO
												row.setUnixUser("");//TODO
												
												
	/*											String controllerName=systemInfo.getSystemName();
												String serialNumber=systemInfo.getSystemSerialNumber();
												String vFileName=vfilerInfo.getName();
												String vFilerUuid=vfilerInfo.getUuid();
												String volumeName=shareMount;
												String shareName=cifsShare.getShareName();
												String mountPoint=cifsShare.getMountPoint();
												String hostIp="";//$sessionHostIp TODO
												String hostName="";//sessionHostName TODO
												String windowsUser="";//$($windowsUser -replace '\\', '\\') TODO
												String unixUser="";//$unixUserName TODO
	*/
												cIFSSessionsDataTable.add(row);
											}
										}
									}		
								
									break;
								}
							}
						}
						 controller.setvFilerName(null);
					}
				}
			}
			
			if (cIFSSessionsDataTable.size() ==0) {
			    System.out.println("No DataTable entries found to upload");
			} else {
				for (CIFSSessionsDataTableRow row : cIFSSessionsDataTable) {
					
					NaDBUtils.insertIntoWCRCifsTemp(row);
				}
			}
		}
		
/*		//Database connection using Rest
	    $dataSources = Get-OciNtapDataSource -DataSourceModel $DataSourceModel -Verbose:([bool]$PSCmdlet.MyInvocation.BoundParameters['Verbose'].IsPresent) -ErrorAction Stop

	    		foreach ($dataSource in $dataSources) {
	        Write-Verbose -Message "Gathering controller information from DataSource: $($dataSource.Name)"

	        $dsControllers = @()

	        $dsControllers += [pscustomobject]@{
	            Name = (($dataSource.config.packages | Where-Object { $_.Id -eq 'Foundation' }).Attributes | Where-Object { $_.Name -eq 'ip' }).value
	            Credential = Get-OciDataSourceCredential -DataSource $dataSource
	        }

	        if ((($dataSource.config.packages | Where-Object { $_.Id -eq 'Foundation' }).Attributes | Where-Object { $_.Name -eq 'partner.ip' }).value) {
	            $dsControllers += [pscustomobject]@{
	                Name = (($dataSource.config.packages | Where-Object { $_.Id -eq 'Foundation' }).Attributes | Where-Object { $_.Name -eq 'partner.ip' }).value
	                Credential = Get-OciDataSourceCredential -DataSource $dataSource -HaPartner
	            }
	        }

	        foreach ($dsController in $dsControllers) {
	            Write-Verbose -Message "Gathering data from controller: $($dsController.Name)"

	            try {
	                $controller = Connect-NaController -Name $dsController.Name -Credential $dsController.Credential -Transient -ErrorAction Stop
	            }
	            catch {
	                Write-Error -Message "Unable to connect to controller ($($dsController.Name)). Reason: $($_.Exception.Message)"
	                continue
	            }

	            Write-Verbose -Message 'Calling Get-NaSystemInfo'
	            $systemInfo = Get-NaSystemInfo -Controller $controller

	            Write-Verbose -Message 'Calling Get-NaTime'
	            $timestamp = Get-NaTime -Controller $controller

	            Write-Verbose -Message 'Calling Get-NaLicense'
	            $license = Get-NaLicense -Controller $Controller

	            try {
	                Write-Verbose -Message 'Calling Get-NaVfiler'
	                $vfilers = Get-NaVfiler -Controller $controller -ErrorAction Stop
	            }
	            catch {
	                if ($_.Exception.ErrorName -eq 'EAPILICENSE') {
	                    $global:Error.RemoveAt(0)
	                }
	            }

	            if (-not $vfilers) {
	                $vfilers = @(
	                    [pscustomobject]@{
	                        Name = 'vfiler0'
	                        Status = 'running'
	    	            Uuid = '00000000-0000-0000-0000-000000000000'
	                    }
	                )
	            }

	            foreach ($vfiler in ($vfilers | Where-Object { $_.Status -ne 'DR backup' })) {
	                $controller.Vfiler = $vfiler.Name

	                if (($license | Where-Object { $_.Service -eq 'cifs' }).IsLicensed -and (Test-NaCifs -Controller $Controller -ErrorAction Ignore) -eq 'started') {
	                    Write-Verbose -Message "Gathering CIFS information from vFiler: $($vfiler.Name)"

	                    Write-Verbose -Message 'Calling Get-NaCifsShare'
	                    $cifsShares = Get-NaCifsShare -Controller $controller

	                    if (($cifsShares | Measure-Object).Count -eq 0) {
	                        Write-Warning -Message 'No CIFS shares found to process'
	                        continue
	                    }

	                    Write-Verbose -Message 'Calling Get-NaCifsSession'
	                    $cifsSessions = Get-NaCifsSession -Controller $controller

	                    if (($cifsSessions | Measure-Object).Count -eq 0) {
	                        Write-Warning -Message 'No CIFS sessions found to process'
	                        continue
	                    }

	                    $dataTable.Merge(($(
	                        foreach ($share in $cifsShares) {
	                            foreach ($cifsSession in ($cifsSessions | Where-Object { $_.VolumesList.Volume -ccontains ($share.MountPoint -replace '/vol/' -replace '[/].*$') } | Group-Object -Property User, HostIp, HostName -NoElement)) {
	                                $sessionUser, $sessionHostIp, $sessionHostName = $cifsSession.Name -split '\s*,\s*', 3
	    			    $windowsUser, $unixUserName = [regex]::Matches($sessionUser, '\((.+?)\s+[-]\s+(.+?)\)').Groups[1, 2].Value

	                                [pscustomobject][ordered]@{
	                                    DateTime = $timestamp.UtcTimeDT.ToString('s')
	                                    ControllerName = $systemInfo.SystemName
	                                    SerialNumber = $systemInfo.SystemSerialNumber
	                                    VfilerName = $vfiler.Name
	                                    VfilerUuid = $vfiler.Uuid
	    				VolumeName = $share.MountPoint -replace '[/]vol[/]' -replace '[/].*$'
	                                    ShareName = $share.ShareName
	                                    MountPoint = $share.MountPoint
	                                    HostIp = $sessionHostIp
	                                    HostName = $sessionHostName
	                                    WindowsUser = $($windowsUser -replace '\\', '\\')
	                                    UnixUser = $unixUserName
	                                }
	                            }
	                        }
	                    ) | Out-DataTable -TableName 'CifsSessions'), $true)

	                    Write-Verbose -Message 'Setting DataTable PrimaryKey'
	                    Set-TablePrimaryKey -DataTable $datatable -PrimaryKey DateTime, SerialNumber, VfilerUuid, ShareName, HostIp, HostName, WindowsUser

	                    $controller.Vfiler = $null
	                }
	            }
	        }
	    }

	    #region Upload to MySql Database

	    if ($dataTable.Rows.Count -eq 0) {
	        Write-Warning -Message 'No DataTable entries found to upload'
	        return
	    }
*/ 		
		
	}
	
	
}
