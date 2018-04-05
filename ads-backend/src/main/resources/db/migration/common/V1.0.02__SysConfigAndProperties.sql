LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.signing-key', 'MaYzkSjmkzPC57L', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.encoding-strength', '256', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.security-realm', 'NetApp ADS', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.client-id', 'testjwtclientid', '1', 0, 'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.client-secret', 'XY7kmzoNzl100','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.grant-type', 'password','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.scope-read', 'read','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.scope-write', 'write','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('security.jwt.resource-ids', 'testjwtresourceid','1',0,'Security');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.rules.rules_path', 'file:C:/Projects/NetApp/Temp/myrules/','1',0,'Rules');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.rules.discovery_rule.disposition', 'DiscoverOwner','1',0,'Rules');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.logoUrl', 'http://localhost:4200/index','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.viewAllTasks', 'http://localhost:4200/index','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.adsQtreeOwnerUrl', 'http://localhost:4200/owner','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.adsSupportUrl', 'http://support.netapp.com','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.from', 'szemanick@consultparagon.com','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.email.from.alias', 'Automated Data Services','1',0,'Email');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.talendjobs.loc', 'C:/netapp/talendjobs/','1',0,'Talend');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('ads.sso.bypass_mode_on', 'true','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.idp.url', 'http://192.168.1.103:8080/saml/login?disco=true','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.sp.entityId', 'com:paragon:ads:sp','1',0,'Security - SSO');

INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.success.redirect.url', 'http://192.168.1.103:4200/','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.token.endpoint.url', 'http://192.168.1.103:8080/oauth/token','1',0,'Security - SSO');
INSERT INTO `sys_config` (`property_name`, `property_value`, `property_type_id`, `encrypted`, `grouping`) VALUES('sso.entity.base.url', 'http://192.168.1.103:8080','1',0,'Security - SSO');

/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `sys_config_property_type` WRITE;
/*!40000 ALTER TABLE `sys_config_property_type` DISABLE KEYS */;
INSERT INTO `sys_config_property_type` VALUES (1,'String','2017-09-27 16:52:26',NULL),(2,'Int','2017-09-27 16:52:26',NULL),(3,'Boolean','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `sys_config_property_type` ENABLE KEYS */;
UNLOCK TABLES;
