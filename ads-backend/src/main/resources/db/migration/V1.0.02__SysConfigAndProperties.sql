LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1851,'base.url','http://vitae.corp.netapp.com:8008/discover',1,0,'2017-04-17 14:42:07','2017-09-27 16:52:26', 'Core'),(1852,'wfa.provision.name','',1,0,'2017-04-17 14:42:07','2017-09-27 16:52:26', 'WFA'),(1853,'Aged.Limit1','3',1,0,'2017-04-17 14:42:07','2017-09-27 16:52:26','Rules'),(1854,'wfa.ldap.name','',1,0,'2017-04-17 14:42:07','2017-09-27 16:52:26', 'WFA'),(1855,'HostMountPointsJob.cron.expression','0 0 17 * * MON-FRI',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Jobs'),(1856,'rest.verum.app.host','verum.jpmchase.net',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Verum'),(1857,'rest.verum.authorize.token','https://verum.jpmchase.net/verum/4.0/authorize/getToken',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Verum'),(1858,'resource.url','http://phone.jpmchase.net',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Verum'),(1859,'WFA_PORT','',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26', 'WFA'),(1860,'WFA_SERVER','',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26', 'WFA'),(1861,'rest.verum.filesystem.uri.test','http://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP={primaryIP}&status=Installed/FileSystem?fileSystemType=nfs,nfs3/OSI,FileSystem',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Verum'),(1862,'rest.verum.resolver.uri.test','http://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP={primaryIP}/Contact?contactType=PRIMARYRESOLVER/OSI,Contact?format=json/',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Verum'),(1863,'password','Thr33Sp!res',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Core'),(1864,'WFA_LDAP_NAME','JPMC_STORAGEX_MMS_LDAP_CREATE_V1.0 - PRD',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26', 'WFA'),(1865,'Test','on',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Test'),(1866,'CreateMigrationKeyJob.cron.multi.expression','0 0 1 * * MON',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Jobs'),(1867,'login.sso.principalRequestHeader','SM_USER',1,0,'2017-04-17 14:42:08','2017-09-27 16:52:26','Core'),(1868,'schedule.migrate.close.weeks','6',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26', 'Jobs'),(1869,'rest.GetInfoByZIP.uri','http://www.webservicex.net/uszip.asmx/GetInfoByZIP?USZip={zipCode}',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26', 'REST'),(1870,'demo.email.to','Scott.Wipperman@netapp.com',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26', 'Demo'),(1871,'StartEngineJob.cron.expression','0 0 1 * * MON',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Jobs'),(1872,'rest.verum.resolver.uri','/Verum/4.0/api/OSI?iprimaryIp={primaryIP}/Contact?contactType=PRIMARYRESOLVER/OSI,Contact?format=json/',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26', 'Verum'),(1873,'GenerateMigrationWeekJob.cron.expression','0 0 0 1 1 ?',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Jobs'),(1874,'serverAdminEmail','/mstsa',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Email'),(1875,'Demo','on',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Demo'),(1876,'demo.email.host','mailhost.netapp.com',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Demo'),(1877,'wfa.server','10.216.49.36',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','WFA'),(1878,'WFA_PROVISION_NAME','JPMC_cDOT_Provisioning _v0.18 - Phase 2 - RD',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','WFA'),(1879,'wfa.netgroup.name','JPMC_MMS_CDOT_Provisioning%20_v1',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','WFA'),(1880,'rest.verum.url.scheme','https',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Verum'),(1881,'WFA_PRE_CUTOVER_NAME','JPMC_ MMS_MIGRATION_PRE-CUTOVER_V1.0 - PRD',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','WFA'),(1882,'rest.verum.filesystem.uri','/Verum/4.0/api/OSI?primaryIP={primaryIP}&status=Installed/FileSystem?fileSystemType=nfs,nfs3/OSI,FileSystem',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Verum'),(1883,'CloseScheduleJob.cron.expression1','0 30 14 21 4 ?',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','Jobs'),(1884,'rest.esource.user.uri.test','http://10.216.49.32:8090/peoplelkp/PDXMLService2?sid=',1,0,'2017-04-17 14:42:09','2017-09-27 16:52:26','REST'),(1885,'rest.verum.app.host.test','10.216.49.32:8090',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Verum'),(1886,'rest.verum.person.uri','https://verum.jpmchase.net/Verum/4.0/api/Person?SID={standardID}/Person?format=json',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Verum'),(1887,'nas_engineering_lead','',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Core'),(1888,'wfa.preview','on',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','WFA'),(1889,'reminder.days','3',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Jobs'),(1890,'wfa.api.uri','',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','WFA'),(1891,'rest.esource.user.uri','https://phone.jpmchase.net/peoplelkp/PDXMLService2?sid={standardID}',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','REST'),(1892,'CUTOVER_PREFIX','MMS-QA',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Cutover'),(1893,'Aged.Limit2','6',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Rules'),(1894,'Aged.Limit3','13',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Rules'),(1895,'rest.verum.person.uri.test','http://10.216.49.32:8090/Verum/4.0/api/Person?SID={standardID}/Person',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Verum'),(1896,'email.subject','NAS Refresh and Volume Migration',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Email'),(1897,'customerServiceAO','/mst',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','Core'),(1898,'WFA_PASSWORD','',1,0,'2017-04-17 14:42:10','2017-09-27 16:52:26','WFA'),(1899,'wfa.password','HB7qA4ovs2fQ15A1WZANTw==',1,1,'2017-04-17 14:42:11','2017-09-27 16:52:26','WFA'),(1900,'customerServiceNas','/mstnas',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Core'),(1901,'schedule.migrate.filter.weeks','6',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Jobs'),(1902,'EmailNotificationJob.cron.single','0 0 1 * * MON',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1903,'EmailNotificationJob.cron.single.reminder','0 0 1 * * MON-FRI',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1904,'mst_application_owner.subject','Migration Support Contact Request',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1905,'rest.verum.app.uri.test','https://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP=192.168.10.200/Application/Contact?contactType=Ap...',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Verum'),(1906,'WFA_USER','',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','WFA'),(1907,'wfa.port','',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','WFA'),(1908,'email.subject.prefix','Action Required: ',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1909,'demo.email.from','DO_NOT_REPLY@netapp.com',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1910,'email.host','mailhost.jpmchase.com',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Email'),(1911,'CreateMigrationKeyJob.cron.single.expression','0 0 1 * * MON',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Jobs'),(1912,'rule.Aggr_Oversubscribe_Pct','60',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','Rules'),(1913,'WFA_CLEAN_UP_NAME','JPMC_ MMS_POST-MIGRATION_CLEAN-UP_V1.0 - PRD',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','WFA'),(1914,'password_test','87i3AbN9Fzc=',1,1,'2017-04-17 14:42:11','2017-09-27 16:52:26','Core'),(1915,'rest.iso2code.uri','http://services.groupkt.com/country/get/iso2code/{state}',1,0,'2017-04-17 14:42:11','2017-09-27 16:52:26','REST'),(1916,'email.from','DO_NOT_REPLY@jpmchase.com',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1917,'EmailNotificationJob.cron.multi','0 0 1 * * MON',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1918,'WFA_CIFS_COPY_NAME','JPMC_STORAGEX_MMS_COPY_CIFS_SHARES_V1.0 - PRD',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','WFA'),(1919,'schedule.hostConnectionLimit','1000',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Schedule'),(1920,'rest.random.uri','http://gturnquist-quoters.cfapps.io/api/random',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','REST'),(1921,'EmailNotificationJob.cron.expression1','0 0 1 * * MON',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1922,'vitae.runMode','DEV',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Core'),(1923,'EmailNotificationJob.cron.expression2','0 0 1 * * MON-FRI',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1924,'wfa.user','Vitae',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','WFA'),(1925,'EmailNotificationJob.cron.multi.reminder','0 0 1 * * MON-FRI',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1926,'rest.fundraising.uri','http://api.kivaws.org/v1/loans/search.json?status=fundraising',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','REST'),(1927,'HostResolverJob.cron.expression','0 0 17 * * MON-FRI',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Jobs'),(1928,'WFA_NETGROUP_NAME','JPMC_STORAGEX_MMS_LDAP_FINAL_PRECHECK_V1.0 - PRD',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','WFA'),(1929,'schedule.volumeLimit','30',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Jobs'),(1930,'wfa.netgroup.jobtype','NETGROUP',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','WFA'),(1931,'username_test','bill',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Core'),(1932,'rest.verum.app.uri','https://verum.jpmchase.net/Verum/4.0/api/OSI?primaryIP={primaryIP}/Application/Contact?contactType={contactType}/OSI,Applicaiton/Contact?format=json/',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Verum'),(1933,'email.port','587',1,0,'2017-04-17 14:42:12','2017-09-27 16:52:26','Email'),(1934,'rule.capacity_overhead_pct','80',1,0,'2017-04-17 14:42:13','2017-09-27 16:52:26','Rules'),(1935,'WFA_API_URI','',1,0,'2017-04-17 14:42:13','2017-09-27 16:52:26','WFA'),(1936,'username','F591154',1,0,'2017-04-17 14:42:13','2017-09-27 16:52:26','Core'),(1937,'ControllerReleaseJob.cron.expression1','0 0 1 * * MON',1,0,'2017-04-17 14:42:13','2017-09-27 16:52:26','Jobs'),(1947,'PROCESS_DOCUMENTATION_URL','\"http://www.netapp.com\" ',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Documentation'),(1959,'email.subject.single','Action Required: NAS Refresh and Volume Migration',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1960,'email.subject.multi','Action Required: NAS Refresh and Volume Migration',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1961,'email.subject.appowner','Action Required: Migration Support Contact Request',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1962,'email.subject.sysadmin','Action Required: NAS Refresh and Volume Migration',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1963,'email.subject.nasengineer','Action Required: NAS Refresh and Volume Migration',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1964,'email.subject.default','Action Required: NAS Refresh and Volume Migration',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1965,'schedule.email.owner.weeks','6',2,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1966,'schedule.email.sysadmin.weeks','4',2,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1967,'schedule.email.NAS.weeks','4',2,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1968,'schedule.email.NAS.leademail','sofia.zhang@netapp.com',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(1969,'schedule.email.NAS.leadname','Lew Newby',1,0,'2017-04-23 13:00:07','2017-09-27 16:52:26','Email'),(2040,'email.template.appowner','mstApplicationOwnerTemplate.vm',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','Email'),(2041,'email.template.serveradmin','serverAdminTemplate.vm',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','Email'),(2042,'clusterVserverPrefix','p',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','VServer'),(2043,'email.template.single','ownerDiscoverTemplete.vm',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','Email'),(2044,'wfa.starting.uid','1006',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','WFA'),(2045,'email.template.nasengineer','nasLeadEngineerEmailTemplate.vm',1,0,'2017-07-18 19:17:42','2017-09-27 16:52:26','Email'),(2046,'email.template.multi','multiOwnerDiscoverTemplete.vm',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2047,'schedule.email.cutover.days','7',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Schedule'),(2048,'email.subject.appowner.reminder','Action Required: NAS Refresh and Volume Migration',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2049,'email.subject.sysadmin.reminder','Action Required: NAS Refresh and Volume Migration',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2050,'email.subject.nasengineer.reminder','Action Required: NAS Refresh and Volume Migration',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2051,'email.template.appowner.reminder','mstApplicationOwnerReminderTemplate.vm',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2052,'email.template.serveradmin.reminder','mstServerAdminReminderTemplate.vm',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email'),(2053,'email.template.nasengineer.reminder','mstNasLeadEngineerReminderTemplate.vm',1,0,'2017-07-25 19:17:42','2017-09-27 16:52:26','Email');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `sys_config_property_type` WRITE;
/*!40000 ALTER TABLE `sys_config_property_type` DISABLE KEYS */;
INSERT INTO `sys_config_property_type` VALUES (1,'String','2017-09-27 16:52:26',NULL),(2,'Int','2017-09-27 16:52:26',NULL),(3,'Boolean','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `sys_config_property_type` ENABLE KEYS */;
UNLOCK TABLES;