
LOCK TABLES `ads_report` WRITE;
/*!40000 ALTER TABLE `ads_report` DISABLE KEYS */;
INSERT INTO `ads_report` VALUES (1,'call_me','Call Me Report','Add Report Description here..,','discover','call_me_report'),
(2,'user_native','User Admin Report','Add Report Description here..,','admin','user_native_report'),
(3,'unknown_owner','Unknown Owner Report','Add Report Description here..,','discover','unknown_owner_report'),
(4,'volume_decommission','Volume Decommission Report','Add Report Description here..,','discover','volume_decommission_report'),
(5,'multi_owner','Multi Owner Report','Add Report Description here..,','discover','multi_owner_report'),
(6,'activity','Activity Report','Add Report Description here..,','discover','activity_report'),
(7,'application_detail','Application Detail Report','Add Report Description here..,','discover','application_detail_report');
/*!40000 ALTER TABLE `ads_report` ENABLE KEYS */;
UNLOCK TABLES;


-- Dumping data for table `ads_report_detail`

LOCK TABLES `ads_report_detail` WRITE;
/*!40000 ALTER TABLE `ads_report_detail` DISABLE KEYS */;
INSERT INTO `ads_report_detail` VALUES (1,1,'user_name','java.lang.String','First Name',1),(2,1,'is_owner','java.lang.Boolean','Owner',3),
(3,1,'is_presumed','java.lang.Boolean','Presumed',2),
(4,1,'suggested_user_name','java.lang.String','Suggested User Name',4),
(5,2,'first_name','java.lang.String','First Name',1),
(6,2,'last_name','java.lang.String','Last Name',2),
(7,2,'email','java.lang.String','Email',4),
(8,2,'user_name','java.lang.String','User Name',3),
(9,2,'enabled','java.lang.Boolean','Enabled',6),
(10,2,'user_role','java.lang.String','User Role',5),
(11,3,'qtree_name','java.lang.String','QTree Name',1),
(12,3,'volume_name','java.lang.String','Volume Name',2),
(13,3,'disposition','java.lang.String','Disposition',3),
(14,3,'migrate_week','java.util.Date','Migrate Week',5),
(15,3,'will_delete','java.lang.Boolean','Delete',4),
(16,3,'archive_candidate','java.lang.Boolean','Archive Candidate',6),
(17,4,'qtree_name','java.lang.String','QTree Name',1),
(18,4,'volume_name','java.lang.String','Volume Name',2),(19,4,'disposition','java.lang.String','Disposition',3),(20,4,'migrate_week','java.util.Date','Migrate Week',5),(21,4,'will_delete','java.lang.Boolean','Delete',6),(22,4,'will_migrate','java.lang.Boolean','Migrate',4),(23,5,'qtree_name','java.lang.String','QTree Name',1),(24,5,'volume_name','java.lang.String','Volume Name',2),(25,5,'disposition','java.lang.String','Disposition',3),(26,5,'will_delete','java.lang.Boolean','Delete',5),(27,5,'will_migrate','java.lang.Boolean','Migrate',4),(28,6,'qtree_name','java.lang.String','QTree Name',1),(29,6,'volume_name','java.lang.String','Volume Name',2),(30,6,'disposition','java.lang.String','Disposition',3),(31,6,'will_delete','java.lang.Boolean','Delete',4),(32,6,'will_migrate','java.lang.Boolean','Migrate',5),(33,7,'application_code','java.lang.String','Application Code',1),(34,7,'application_name','java.lang.String','Application Name',2),(35,7,'user_name','java.lang.String','User Name',3),(36,7,'information_owner','java.lang.String','Information Owner',4);
/*!40000 ALTER TABLE `ads_report_detail` ENABLE KEYS */;
UNLOCK TABLES;