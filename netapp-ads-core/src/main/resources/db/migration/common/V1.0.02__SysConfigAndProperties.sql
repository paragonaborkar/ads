LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.signing-key', 'MaYzkSjmkzPC57L', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.encoding-strength', '256', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.security-realm', 'NetApp ADS', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.client-id', 'adsClient', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.client-secret', 'sdjlh380231funej01382','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.grant-type', 'password','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.scope-read', 'read','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.scope-write', 'write','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.resource-ids', 'testjwtresourceid','1',0,'Security');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.sso.bypass_mode_on', 'true','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.sp.entityId', 'com:paragon:ads:sp','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.success.redirect.url', 'http://localhost:4200/','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.idp.url', 'http://localhost:8080/saml/login?disco=true','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.token.endpoint.url', 'http://localhost:8080/oauth/token','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.entity.base.url', 'http://localhost:8080','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.sso.backend.url', 'http://localhost:8080/sso','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.sso.idp.metadata.url', 'http://idp.ssocircle.com/idp-meta.xml','1',0,'Security - SSO');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.rules.rules_path', 'file:C:/Projects/NetApp/ADS/github/discovery_rules/','1',0,'Rules');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.rules.discovery_rule.disposition', 'DiscoverOwner','1',0,'Rules');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.logoUrl', 'http://localhost:4200/index','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.viewAllTasks', 'http://localhost:4200/index','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.adsQtreeOwnerUrl', 'http://localhost:4200/owner','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.adsSupportUrl', 'http://support.netapp.com','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.from', 'szemanick@consultparagon.com','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.from.alias', 'Automated Data Services','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.sendowner.first', '0 0 10 * * *','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.sendowner.reminder', '0 0 11 * * *','1',0,'Email');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.talendjobs.loc', 'C:/Projects/NetApp/ADS/talendjobs/','1',0,'Talend');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.talend.cmdb.url', 'http://localhost:8088/','1',0,'Talend');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.server.name', '10.216.15.31','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.server.user', 'root','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.server.password', 'P@ssw0rd','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.server.port', '443','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.server.data_model', 'UNKNOWN','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('vfiler.default_name', 'vfiler0','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('vfiler.default_uuid', '00000000-0000-0000-0000-000000000000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('vfiler.status.dr_backup', 'DR backup','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('wfa.rest.url', 'https://10.216.15.37/rest/v1/admin/datasources','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('wfa.rest.user', 'admin','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('wfa.rest.password', 'admin123','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('cifs.schedule', '86400000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('cifs.schedule.initial_delay', '300000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('nfs.schedule', '86400000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('nfs.schedule.initial_delay', '300000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('showmount.schedule', '86400000','1',0,'HHCC');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('showmount.schedule.initial_delay', '300000','1',0,'HHCC');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('oci.schedule', '86400000','1',0,'Discover');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ociAndActivityProcessing.schedule', '86400000','1',0,'Discover');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ociAndActivityProcessing.initial_delay', '100000','1',0,'Discover');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.discover.jobs.user', 'jdoe@corp.com','1',0,'Discover');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.discover.jobs.password', '123','1',0,'Discover');


/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `sys_config_property_type` WRITE;
/*!40000 ALTER TABLE `sys_config_property_type` DISABLE KEYS */;
INSERT INTO `sys_config_property_type` VALUES (1,'String','2017-09-27 16:52:26',NULL),(2,'Int','2017-09-27 16:52:26',NULL),(3,'Boolean','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `sys_config_property_type` ENABLE KEYS */;
UNLOCK TABLES;
