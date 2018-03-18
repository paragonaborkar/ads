-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vitae_data_refactor
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--
DROP TABLE IF EXISTS `job_data`;
CREATE TABLE `job_data` (
	`job_id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NULL,
	`input_file` LONGBLOB NULL,
	`submitted_by` VARCHAR(255) NULL,
	`submission_time` DATETIME NULL,
	`start_time` DATETIME NULL,
	`end_time` DATETIME NULL,
	`status` VARCHAR(50) NULL,
	`additional_details` VARCHAR(255) NULL,
	PRIMARY KEY (`job_id`)
);

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Activity.',
  `qtree_id` int(11) DEFAULT NULL COMMENT 'ID of the QTree which is associated with the Activity',
  `vserver` varchar(255) DEFAULT NULL COMMENT 'vServer of the Activity',
  `mailing_date` date DEFAULT NULL COMMENT 'Date email was send to the Owner(s) of the Activity?',
  `will_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) will delete the QTree.',
  `delete_date` date DEFAULT NULL COMMENT 'Date on which the QTree can be deleted.',
  `will_migrate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) will migrate the QTree.',
  `migrate_week` date DEFAULT NULL COMMENT 'Week selected for migration of the QTree.',
  `migrate_day` int(11) DEFAULT '6' COMMENT 'Day of Week selected for migration of the QTree.',
  `archive_candidate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the QTree is a canidiate for archiving',
  `is_latest` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'DEV TBD -  Boolean indicating if the Activity is the latest. We may be able to get this from the create time. So this may not be needed. Could save us time/code to set this column.',
  `admin_override` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the an Admin overrode an Owner',
  `note` varchar(1024) DEFAULT NULL COMMENT 'Note for the Activity',
  `mail_count` int(1) DEFAULT '0' COMMENT 'Count of emails sent',
  `migration_time_id` int(11) DEFAULT NULL COMMENT 'Time selected for this Activity',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `Activity_has_a _Migration_Time_idx` (`migration_time_id`),
  KEY `fk_activity_qtree1_idx` (`qtree_id`),
  CONSTRAINT `Activity_has_a _Migration_Time` FOREIGN KEY (`migration_time_id`) REFERENCES `migration_time` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_qtree1` FOREIGN KEY (`qtree_id`) REFERENCES `qtree` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `activity_lob_x_ref`
--

DROP TABLE IF EXISTS `activity_lob_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_lob_x_ref` (
  `activity_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`lob_id`),
  UNIQUE KEY `activity_id_and_lob_id` (`activity_id`,`lob_id`),
  KEY `lob_id_idx` (`lob_id`),
  CONSTRAINT `fk_actvitiy_lob_xref_line_of_business1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_lob_xref_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_lob_x_ref`
--

LOCK TABLES `activity_lob_x_ref` WRITE;
/*!40000 ALTER TABLE `activity_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_lob_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_migration_key_x_ref`
--

DROP TABLE IF EXISTS `activity_migration_key_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_migration_key_x_ref` (
  `activity_id` int(11) NOT NULL,
  `migration_key_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`migration_key_id`),
  KEY `migration_key_idx` (`migration_key_id`),
  CONSTRAINT `fk_activity_migration_key_x_ref_migration_key1` FOREIGN KEY (`migration_key_id`) REFERENCES `migration_key` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_migration_key_x_ref_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_migration_key_x_ref`
--

LOCK TABLES `activity_migration_key_x_ref` WRITE;
/*!40000 ALTER TABLE `activity_migration_key_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_migration_key_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_presumed_lob_x_ref`
--

DROP TABLE IF EXISTS `activity_presumed_lob_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_presumed_lob_x_ref` (
  `activity_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`lob_id`),
  KEY `activity_id_and_lob_id` (`lob_id`,`activity_id`),
  CONSTRAINT `fk_activity_presumed_lob_x_ref_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_presumed_lob_x_ref_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_presumed_lob_x_ref`
--

LOCK TABLES `activity_presumed_lob_x_ref` WRITE;
/*!40000 ALTER TABLE `activity_presumed_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_presumed_lob_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_response`
--

DROP TABLE IF EXISTS `activity_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Activity Response',
  `activity_id` int(11) NOT NULL,
  `owner_user_corporate_id` int(11) NOT NULL,
  `is_owner` tinyint(1) NOT NULL,
  `is_presumed` tinyint(1) NOT NULL,
  `suggested_owner_user_corporate_id` int(11) DEFAULT NULL,
  `call_me` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) want to be contacted by a Migration Specialist.',
  `best_number` varchar(100) DEFAULT NULL COMMENT 'Contact number for the Owner if they want to speak to a Migration Specialist.',
  `call_reason` varchar(2048) DEFAULT NULL COMMENT 'Primary reason why the Owner wants to be contacted by the Migration Specialist',  
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`),
  UNIQUE KEY `candidate_fk_key` (`activity_id`,`owner_user_corporate_id`),
  CONSTRAINT `fk_activity_response_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `aggregate`
--

DROP TABLE IF EXISTS `aggregate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aggregate` (
  `id` int(11) NOT NULL COMMENT 'Surrogate ID of the aggregate',
  `aggregate_name` varchar(255) NOT NULL,
  `aggregate_size_gb` float NOT NULL DEFAULT '0',
  `is_hybrid` tinyint(1) NOT NULL DEFAULT '0',
  `aggregate_type` varchar(45) NOT NULL,
  `controller_id` int(11) NOT NULL,
  `pool_allocated_capacity_gb` float DEFAULT NULL,
  `pool_used_capacity_gb` float DEFAULT NULL,
  `pool_iops_capability` int(11) DEFAULT NULL,
  `avg_iops` int(11) DEFAULT NULL,
  `peak_iops` int(11) DEFAULT NULL,
  `assigned_iops` int(11) DEFAULT NULL,
  `assigned_capacity_gb` float(10,1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`controller_id`),
  KEY `fk_aggregate_controller1_idx` (`controller_id`),
  KEY `controller_id_idx` (`id`,`controller_id`),
  CONSTRAINT `fk_aggregate_controller1` FOREIGN KEY (`controller_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `aggregate_purpose`
--

DROP TABLE IF EXISTS `aggregate_purpose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aggregate_purpose` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Aggregate Purpose',
  `aggregate_id` int(11) NOT NULL,
  `storage_type` varchar(16) DEFAULT NULL,
  `service_level` varchar(16) DEFAULT NULL,
  `aggregate_function` varchar(16) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `aggregate_id_idx` (`aggregate_id`),
  CONSTRAINT `fk_aggregate_to_aggregate_purpose` FOREIGN KEY (`aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Application',
  `application_code` varchar(255) NOT NULL,
  `application_name` varchar(255) NOT NULL,
  `archtype` varchar(255) DEFAULT NULL,
  `owner_user_corporate_id` int(11) NOT NULL,
  `information_owner` varchar(60) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_application_user_corporate` FOREIGN KEY (`owner_user_corporate_id`) REFERENCES `user_corporate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `application_lob_x_ref`
--

DROP TABLE IF EXISTS `application_lob_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_lob_x_ref` (
  `application_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`application_id`,`lob_id`),
  KEY `application_id_and_lob_id` (`lob_id`,`application_id`),
  CONSTRAINT `fk_application_lob_x_ref_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_lob_x_ref_application1` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_lob_x_ref`
--

LOCK TABLES `application_lob_x_ref` WRITE;
/*!40000 ALTER TABLE `application_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_lob_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_event`
--

DROP TABLE IF EXISTS `audit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Audit Event',
  `event_name` varchar(45) NOT NULL,
  `resource_pattern` varchar(255) NOT NULL,
  `http_method` enum('CONNECT','DELETE','GET','HEAD','OPTIONS','PATCH','POST','PUT') NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_event`
--

LOCK TABLES `audit_event` WRITE;
/*!40000 ALTER TABLE `audit_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_reason_code`
--

DROP TABLE IF EXISTS `audit_reason_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_reason_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Audit Reason Code',
  `audit_event_id` int(11) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_audit_reason_code_audit_event1_idx` (`audit_event_id`),
  CONSTRAINT `fk_audit_reason_code_audit_event1` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `audit_trail_api`
--

DROP TABLE IF EXISTS `audit_trail_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_trail_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Audit Trail API',
  `audit_event_id` int(11) NOT NULL,
  `user_api_id` int(11) NOT NULL,
  `old_values` text,
  `audit_comment` varchar(1024) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_audit_trail_corporate_audit_event1_idx` (`audit_event_id`),
  CONSTRAINT `fk_audit_trail_corporate_audit_event100` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trail_api`
--

LOCK TABLES `audit_trail_api` WRITE;
/*!40000 ALTER TABLE `audit_trail_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_api` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_trail_corporate_user`
--

DROP TABLE IF EXISTS `audit_trail_corporate_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_trail_corporate_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Audit Trail Corporate User',
  `audit_event_id` int(11) NOT NULL,
  `user_corporate_id` int(11) NOT NULL,
  `old_values` text,
  `audit_comment` varchar(1024) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_audit_trail_corporate_audit_event1_idx` (`audit_event_id`),
  CONSTRAINT `fk_audit_trail_corporate_audit_event1` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trail_corporate_user`
--

LOCK TABLES `audit_trail_corporate_user` WRITE;
/*!40000 ALTER TABLE `audit_trail_corporate_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_corporate_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_trail_native_user`
--

DROP TABLE IF EXISTS `audit_trail_native_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_trail_native_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Audit Trail Native User',
  `audit_event_id` int(11) NOT NULL,
  `user_native_id` int(11) NOT NULL,
  `old_values` text,
  `audit_comment` varchar(1024) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_audit_trail_corporate_audit_event1_idx` (`audit_event_id`),
  CONSTRAINT `fk_audit_trail_corporate_audit_event10` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trail_native_user`
--

LOCK TABLES `audit_trail_native_user` WRITE;
/*!40000 ALTER TABLE `audit_trail_native_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_native_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `change_management`
--

DROP TABLE IF EXISTS `change_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `change_management` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Change Management',
  `migration_cutover_event_id` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `change_management_number` varchar(60) DEFAULT NULL,
  `note` mediumtext,
  `assets_impacted` mediumtext,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migrationId` (`migration_cutover_event_id`),
  UNIQUE KEY `itsmNum` (`change_management_number`),
  CONSTRAINT `fk_change_management_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `change_management`
--

LOCK TABLES `change_management` WRITE;
/*!40000 ALTER TABLE `change_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `change_management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controller`
--

DROP TABLE IF EXISTS `controller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controller` (
  `id` int(11) NOT NULL COMMENT 'Not a Surrogate. ID of the Controller',
  `controller_name` varchar(255) NOT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `storage_id` int(11) NOT NULL,
  `date_available` date DEFAULT '2050-12-31',
  `volume_tally` int(11) DEFAULT NULL,
  `data_center_id` int(11) NOT NULL,
  `exports_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`storage_id`,`data_center_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_con_dc_id` (`data_center_id`),
  KEY `fk_con_storage_id` (`storage_id`),
  CONSTRAINT `fk_con_dc_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`),
  CONSTRAINT `fk_con_storage_id` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`id`),
  CONSTRAINT `fk_exports_id` FOREIGN KEY (`exports_id`) REFERENCES `exports` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cutover`
--

DROP TABLE IF EXISTS `cutover`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutover` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover',
  `schedule_id` int(11) NOT NULL,
  `cutover_name` varchar(60) NOT NULL,
  `day_of_week` int(11) NOT NULL,
  `migrate_time` varchar(36) NOT NULL,
  `mig_spec_user_native_id` int(11) DEFAULT NULL,
  `change_management_id` int(11) DEFAULT NULL,
  `cutover_ical_id` int(11) DEFAULT NULL,
  `prep_meeting_ical_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`cutover_name`),
  KEY `cutoverical_fk` (`cutover_ical_id`),
  KEY `itsm_fk` (`change_management_id`),
  KEY `migspecId_fk` (`mig_spec_user_native_id`),
  KEY `premeeticalid_fk` (`prep_meeting_ical_id`),
  KEY `fk_cutover_schedule1_idx` (`schedule_id`),
  CONSTRAINT `cutoverical_fk` FOREIGN KEY (`cutover_ical_id`) REFERENCES `ical` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_cutover_schedule1` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `itsm_fk` FOREIGN KEY (`change_management_id`) REFERENCES `change_management` (`id`) ON DELETE CASCADE,
  CONSTRAINT `migspecId_fk` FOREIGN KEY (`mig_spec_user_native_id`) REFERENCES `user_native` (`id`) ON DELETE CASCADE,
  CONSTRAINT `premeeticalid_fk` FOREIGN KEY (`prep_meeting_ical_id`) REFERENCES `ical` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutover`
--

LOCK TABLES `cutover` WRITE;
/*!40000 ALTER TABLE `cutover` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cutover_assembly`
--

DROP TABLE IF EXISTS `cutover_assembly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutover_assembly` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover Assembly',
  `cutover_id` int(11) NOT NULL,
  `migration_cutover_event_id` int(11) DEFAULT NULL,
  `cutover_mount_point_id` int(11) DEFAULT NULL,
  `stopped_app` tinyint(1) DEFAULT '0',
  `stopped_db` tinyint(1) DEFAULT '0',
  `unmount_volume` tinyint(1) DEFAULT '0',
  `completed_replication` tinyint(1) DEFAULT '0',
  `changed_mount` tinyint(1) DEFAULT '0',
  `started_database` tinyint(1) DEFAULT '0',
  `validated_database` tinyint(1) DEFAULT '0',
  `started_app` tinyint(1) DEFAULT '0',
  `validation_complete` tinyint(1) DEFAULT '0',
  `cutover_complete` tinyint(1) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cutover_mount_point_id_UNIQUE` (`cutover_mount_point_id`),
  KEY `fk_migrationId_coa` (`migration_cutover_event_id`),
  KEY `fk_itPAMiD_coa` (`cutover_mount_point_id`),
  KEY `fk_cutoverNameId_coa` (`cutover_id`),
  CONSTRAINT `fk_cutoverNameId_coa` FOREIGN KEY (`cutover_id`) REFERENCES `cutover` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_cutover_assembly_point_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_itPAMiD_coa` FOREIGN KEY (`cutover_mount_point_id`) REFERENCES `cutover_mount_point` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutover_assembly`
--

LOCK TABLES `cutover_assembly` WRITE;
/*!40000 ALTER TABLE `cutover_assembly` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_assembly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cutover_mount_point`
--

DROP TABLE IF EXISTS `cutover_mount_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutover_mount_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover Mount Point',
  `migration_cutover_event_id` int(11) DEFAULT NULL,
  `fwd_unmount_label` varchar(1024) NOT NULL DEFAULT 'UNKNOWN',
  `rev_unmount_label` varchar(1024) NOT NULL DEFAULT 'UNKNOWN',
  `fwd_mount_label` varchar(1024) DEFAULT NULL,
  `rev_mount_label` varchar(1024) DEFAULT NULL,
  `host_list` mediumtext,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migrationId_idx` (`migration_cutover_event_id`),
  CONSTRAINT `fk_cutover_mount_point_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutover_mount_point`
--

LOCK TABLES `cutover_mount_point` WRITE;
/*!40000 ALTER TABLE `cutover_mount_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_mount_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cutover_time`
--

DROP TABLE IF EXISTS `cutover_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutover_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover Time',
  `cutover_assembly_id` int(11) NOT NULL,
  `stop_app_begin_time` datetime DEFAULT NULL,
  `stop_app_end_time` datetime DEFAULT NULL,
  `stop_db_begin_time` datetime DEFAULT NULL,
  `stop_db_end_time` datetime DEFAULT NULL,
  `validate_db_end_time` datetime DEFAULT NULL,
  `unmount_volume_begin_time` datetime DEFAULT NULL,
  `unmount_volume_end_time` datetime DEFAULT NULL,
  `complete_replication_begin_time` datetime DEFAULT NULL,
  `complete_replication_end_time` datetime DEFAULT NULL,
  `change_mount_begin_time` datetime DEFAULT NULL,
  `change_mount_end_time` datetime DEFAULT NULL,
  `start_db_begin_time` datetime DEFAULT NULL,
  `start_db_end_time` datetime DEFAULT NULL,
  `validate_db_begin_time` datetime DEFAULT NULL,
  `validate_complete_end_time` datetime DEFAULT NULL,
  `start_app_begin_time` datetime DEFAULT NULL,
  `start_app_end_time` datetime DEFAULT NULL,
  `validate_complete_begin_time` datetime DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `cutoverAssemblyId_idx` (`cutover_assembly_id`),
  CONSTRAINT `cutoverAssemblyId` FOREIGN KEY (`cutover_assembly_id`) REFERENCES `cutover_assembly` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutover_time`
--

LOCK TABLES `cutover_time` WRITE;
/*!40000 ALTER TABLE `cutover_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_center`
--

DROP TABLE IF EXISTS `data_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Data Center',
  `data_center_name` varchar(24) NOT NULL DEFAULT 'UNKNOWN',
  `data_center_full_name` varchar(1024) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `region` varchar(60) NOT NULL DEFAULT 'UNKNOWN',
  `data_geo_location` point DEFAULT NULL COMMENT 'For future use: Compliance and Rules Engine.',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `datacenter_name_idx` (`data_center_name`, `region`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_protection_policy`
--

DROP TABLE IF EXISTS `data_protection_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_protection_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Data Protection Policy',
  `data_protection_policy_name` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_protection_policy`
--

LOCK TABLES `data_protection_policy` WRITE;
/*!40000 ALTER TABLE `data_protection_policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_protection_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_template`
--

DROP TABLE IF EXISTS `email_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the e-mail Template',
  `template_name` varchar(32) NOT NULL,
  `template_location` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_name` (`template_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exports`
--

DROP TABLE IF EXISTS `exports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exports` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Exports',
  `controller_name` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `volume_path` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `access_type` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `reason` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `user_corporate_id` int(11) DEFAULT NULL,
  `lob_id` int(11) NOT NULL,
  `impact_status` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `peregrine_queue` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `contact` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `line_of_business_exports1_idx` (`lob_id`),
  CONSTRAINT `fk_exports_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exports`
--

LOCK TABLES `exports` WRITE;
/*!40000 ALTER TABLE `exports` DISABLE KEYS */;
/*!40000 ALTER TABLE `exports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exports_host_x_ref`
--

DROP TABLE IF EXISTS `exports_host_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exports_host_x_ref` (
  `exports_id` int(11) NOT NULL,
  `host_id` int(11) NOT NULL,
  PRIMARY KEY (`host_id`,`exports_id`),
  KEY `exports_id_host_id` (`exports_id`,`host_id`),
  CONSTRAINT `fk_export_host_x_ref_exports1` FOREIGN KEY (`exports_id`) REFERENCES `exports` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT, 
  CONSTRAINT `fk_export_host_x_ref_host1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exports_host_x_ref`
--

LOCK TABLES `exports_host_x_ref` WRITE;
/*!40000 ALTER TABLE `exports_host_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `exports_host_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extended_info_varchar`
--

DROP TABLE IF EXISTS `extended_info_varchar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extended_info_varchar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(45) DEFAULT NULL,
  `row_id` int(11) DEFAULT NULL,
  `field_id` int(11) DEFAULT NULL,
  `field_value` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_extended_info_varchar_extended_info_varchar_settings1_idx` (`field_id`),
  CONSTRAINT `fk_extended_info_varchar_extended_info_varchar_settings1` FOREIGN KEY (`field_id`) REFERENCES `extended_info_varchar_settings` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extended_info_varchar`
--

LOCK TABLES `extended_info_varchar` WRITE;
/*!40000 ALTER TABLE `extended_info_varchar` DISABLE KEYS */;
/*!40000 ALTER TABLE `extended_info_varchar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extended_info_varchar_settings`
--

DROP TABLE IF EXISTS `extended_info_varchar_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extended_info_varchar_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `field_name` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extended_info_varchar_settings`
--

LOCK TABLES `extended_info_varchar_settings` WRITE;
/*!40000 ALTER TABLE `extended_info_varchar_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `extended_info_varchar_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host` (
  `id` int(11) NOT NULL COMMENT 'ID of the Host. This is not a Surrogate!',
  `host_name` varchar(255) DEFAULT 'UNKNOWN',
  `ip_addr` varchar(255) DEFAULT '0.0.0.0',
  `host_owner_user_corporate_id` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `system_admin_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `host_ip_idx` (`ip_addr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `host_application_x_ref`
--

DROP TABLE IF EXISTS `host_application_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host_application_x_ref` (
  `host_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  PRIMARY KEY (`host_id`,`application_id`),
  KEY `host_id_application_id` (`application_id`,`host_id`),
  CONSTRAINT `fk_host_application_x_ref_host1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_host_application_x_ref_application1` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host_application_x_ref`
--

LOCK TABLES `host_application_x_ref` WRITE;
/*!40000 ALTER TABLE `host_application_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `host_application_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ical`
--

DROP TABLE IF EXISTS `ical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ical` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the iCal',
  `migration_cutover_event_id` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `sender_email` varchar(255) NOT NULL,
  `date_of_meeting` date NOT NULL,
  `time_of_meeting` time NOT NULL,
  `bridge` varchar(120) DEFAULT NULL,
  `meeting_url` varchar(255) DEFAULT NULL,
  `change_mgmt_url` varchar(255) DEFAULT NULL,
  `attendees` text,
  `notes` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migration_id` (`migration_cutover_event_id`),
  KEY `date_idx` (`date_of_meeting`),
  CONSTRAINT `fk_ical_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ical`
--

LOCK TABLES `ical` WRITE;
/*!40000 ALTER TABLE `ical` DISABLE KEYS */;
/*!40000 ALTER TABLE `ical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line_of_business`
--

DROP TABLE IF EXISTS `line_of_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `line_of_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Line of Business',
  `lob_name` varchar(255) NOT NULL,
  `liason_first_name` varchar(255) NOT NULL,
  `liason_last_name` varchar(255) NOT NULL,
  `liason_user_name` varchar(255) NOT NULL,
  `liason_contact_number` varchar(255) NOT NULL,
  `liason_email` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line_of_business`
--

LOCK TABLES `line_of_business` WRITE;
/*!40000 ALTER TABLE `line_of_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `line_of_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration_cutover_event`
--

DROP TABLE IF EXISTS `migration_cutover_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_cutover_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Event',
  `migrate_week` date NOT NULL DEFAULT '1900-01-01',
  `migrate_day` int(4) NOT NULL DEFAULT '0',
  `migrate_time` varchar(60) NOT NULL DEFAULT '0',
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `application_id` int(11) NOT NULL DEFAULT '0',
  `migration_approved` tinyint(1) DEFAULT '0',
  `high_over_write` tinyint(4) DEFAULT NULL,
  `lob_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration_cutover_event`
--

LOCK TABLES `migration_cutover_event` WRITE;
/*!40000 ALTER TABLE `migration_cutover_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration_cutover_src_to_tgt`
--

DROP TABLE IF EXISTS `migration_cutover_src_to_tgt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_cutover_src_to_tgt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Source to Target',
  `migration_cutover_event_id` int(11) NOT NULL,
  `data_protection_policy_id` int(11) NOT NULL,
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `application_id` int(11) NOT NULL DEFAULT '0',
  `host_id_list` varchar(1024) DEFAULT NULL COMMENT 'DEV TBD - We should be able to get this from the src and tgt IDs.',
  `processed` tinyint(1) NOT NULL DEFAULT '0',
  `provisioned` tinyint(4) DEFAULT '0',
  `replication` tinyint(4) DEFAULT '0',
  `completed` tinyint(4) DEFAULT '0',
  `src_data_center_id` int(11) NOT NULL DEFAULT '0',
  `src_aggregate_id` int(11) NOT NULL,
  `src_controller_id` int(11) NOT NULL,
  `src_volume_id` int(11) NOT NULL DEFAULT '0',
  `src_qtree_id` int(11) NOT NULL DEFAULT '0',
  `tgt_data_center_id` int(11) NOT NULL DEFAULT '0',
  `tgt_aggregate_id` int(11) NOT NULL,
  `tgt_controller_id` int(11) NOT NULL,
  `tgt_volume_id` int(11) NOT NULL DEFAULT '0',
  `tgt_qtree_id` int(11) NOT NULL DEFAULT '0',
  `tgt_capacity` tinyint(4) DEFAULT '0',
  `tgt_status` enum('Red','Amber','Green') DEFAULT 'Red',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_migration_cutover_src_to_tgt_migration_cutover_event1_idx` (`migration_cutover_event_id`),
  KEY `fk_migration_cutover_src_to_tgt_data_protection_policy1_idx` (`data_protection_policy_id`),
  CONSTRAINT `fk_migration_cutover_src_to_tgt_data_protection_policy1` FOREIGN KEY (`data_protection_policy_id`) REFERENCES `data_protection_policy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_migration_cutover_src_to_tgt_migration_cutover_event1` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration_cutover_src_to_tgt`
--

LOCK TABLES `migration_cutover_src_to_tgt` WRITE;
/*!40000 ALTER TABLE `migration_cutover_src_to_tgt` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_src_to_tgt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration_cutover_team`
--

DROP TABLE IF EXISTS `migration_cutover_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_cutover_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Team',
  `migration_cutover_src_to_tgt_id` int(11) NOT NULL,
  `team_member_role` enum('system_admin','app_stop','app_start','db_stop','db_start','validate_data','validate_app') NOT NULL,
  `user_corporate_id` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `migration_cutover_src_to_tgt_id_idx` (`migration_cutover_src_to_tgt_id`),
  CONSTRAINT `fk_migration_cutover_team_migration_cutover_src_to_tgt` FOREIGN KEY (`migration_cutover_src_to_tgt_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration_cutover_team`
--

LOCK TABLES `migration_cutover_team` WRITE;
/*!40000 ALTER TABLE `migration_cutover_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration_key`
--

DROP TABLE IF EXISTS `migration_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_key` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Key',
  `migration_key` varchar(100) NOT NULL,
  `user_corporate_id` int(11) NOT NULL,
  `run_no` INT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migration_key_UNIQUE` (`migration_key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `migration_time`
--

DROP TABLE IF EXISTS `migration_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Time',
  `time_slot` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(255) NOT NULL,
  `property_value` varchar(255) NOT NULL,
  `property_type_id` int(11) DEFAULT NULL,
  `encrypted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `grouping` varchar(48) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_property_type` (`property_type_id`),
  CONSTRAINT `fk_property_type` FOREIGN KEY (`property_type_id`) REFERENCES `sys_config_property_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2054 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `sys_config_property_type`
--

DROP TABLE IF EXISTS `sys_config_property_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config_property_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `property_type` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mount_point`
--

DROP TABLE IF EXISTS `mount_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mount_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Mount Point',
  `host_id` int(11) NOT NULL,
  `mount_location` varchar(255) NOT NULL DEFAULT 'UNKNOWN',
  `inventory_number` varchar(45) NOT NULL DEFAULT 'UNKNOWN',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `host_mount_idx` (`host_id`,`mount_location`),
  CONSTRAINT `mount_point_host_fk_1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `mst_email_type`
--

DROP TABLE IF EXISTS `mst_email_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_email_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the MST e-mail Type',
  `email_type` varchar(45) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mst_emailing_date`
--

DROP TABLE IF EXISTS `mst_emailing_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_emailing_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the MST e-mailing Date',
  `migrate_week` date NOT NULL,
  `mailing_date_time` datetime NOT NULL,
  `email_type_id` int(11) NOT NULL,
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `system_admin_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_email_type_idx` (`email_type_id`),
  CONSTRAINT `fk_email_type` FOREIGN KEY (`email_type_id`) REFERENCES `mst_email_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_emailing_date`
--

LOCK TABLES `mst_emailing_date` WRITE;
/*!40000 ALTER TABLE `mst_emailing_date` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_emailing_date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nas_volume`
--

DROP TABLE IF EXISTS `nas_volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nas_volume` (
  `id` int(11) NOT NULL COMMENT 'ID of the NAS Volume. This is not a Surrogate!',
  `controlled_id` int(11) NOT NULL,
  `aggregate_id` int(11) NOT NULL,
  `vserver` varchar(255) DEFAULT 'Not Defined',
  `volume_name` varchar(255) NOT NULL,
  `allocated_capacity_gb` int(11) DEFAULT NULL,
  `used_capacity_gb` int(11) DEFAULT NULL,
  `snap_type` varchar(255) DEFAULT NULL,
  `snap_src_volume_id` int(11) DEFAULT NULL,
  `snap_tgt_volume_id` int(11) DEFAULT NULL,
  `snap_destination_volume` varchar(255) DEFAULT NULL,
  `volume_status` varchar(255) DEFAULT 'UNKNOWN',
  `volume_last_accessed` datetime DEFAULT '1980-01-01 00:00:01',
  `disposition` varchar(1024) DEFAULT NULL,
  `justification` varchar(1024) DEFAULT NULL,
  `avg_iops` int(11) DEFAULT NULL,
  `peak_iops` int(11) DEFAULT NULL,
  `qtree_tally` int(11) DEFAULT NULL,
  `snap_tally` int(11) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `vol_name_idx` (`vserver`,`volume_name`),
  KEY `volume_controller_idx` (`controlled_id`),
  KEY `volume_aggregate` (`aggregate_id`),
  CONSTRAINT `fk_volume_aggregate1` FOREIGN KEY (`aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_volume_controller1` FOREIGN KEY (`controlled_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `qtree`
--

DROP TABLE IF EXISTS `qtree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qtree` (
  `id` int(11) NOT NULL COMMENT 'ID of the QTree. This is not a Surrogate!',
  `nas_volume_id` int(11) NOT NULL,
  `qtree_name` varchar(225) DEFAULT NULL,
  `quota_hard_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `quota_soft_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `quota_used_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `qtree_type` enum('DEFAULT','EXPLICIT') DEFAULT NULL,
  `security_style` enum('UNIX','NTFS','MIXED') DEFAULT NULL,
  `last_accessed` datetime DEFAULT '1980-01-01 00:00:01',
  `qtree_status` varchar(225) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `qtreedata_internalVolumeId_idx` (`nas_volume_id`),
  CONSTRAINT `Volume_verb_QTree_fk` FOREIGN KEY (`nas_volume_id`) REFERENCES `nas_volume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `replication`
--

DROP TABLE IF EXISTS `replication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `replication` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Replication',
  `migration_cutover_src_to_tgt_id` int(11) NOT NULL,
  `tgt_vault_data_center_id` int(11) DEFAULT NULL,
  `tgt_vault_storage_id` int(11) DEFAULT NULL,
  `tgt_vault_aggregate_id` int(11) DEFAULT NULL,
  `tgt_mirror_data_center_id` int(11) DEFAULT NULL,
  `tgt_mirror_storage_id` int(11) DEFAULT NULL,
  `tgt_mirror_aggregate_id` int(11) DEFAULT NULL,
  `src_prod_data_center_name` varchar(60) DEFAULT NULL,
  `src_mirror_data_center_name` varchar(60) DEFAULT NULL,
  `src_mirror_controller_name` varchar(225) DEFAULT NULL,
  `src_mirror_aggregate_name` varchar(225) DEFAULT NULL,
  `src_mirror_volume_name` varchar(225) DEFAULT NULL,
  `src_mirror_qtree_name` varchar(225) DEFAULT NULL,
  `src_vault_data_center_name` varchar(60) DEFAULT NULL,
  `src_vault_controller_name` varchar(225) DEFAULT NULL,
  `src_vault_aggregate_name` varchar(225) DEFAULT NULL,
  `src_vault_volume_name` varchar(225) DEFAULT NULL,
  `src_vault_qtree_name` varchar(225) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migration_cutover_src_to_tgt_id_UNIQUE` (`migration_cutover_src_to_tgt_id`),
  KEY `fk_crTgtDatacenterId` (`tgt_vault_data_center_id`),
  KEY `fk_crTgtClusterId` (`tgt_vault_storage_id`),
  KEY `fk_crTgtAggr` (`tgt_vault_aggregate_id`),
  KEY `fk_drTgtDatacenterId` (`tgt_mirror_data_center_id`),
  KEY `fk_drTgtClusterId` (`tgt_mirror_storage_id`),
  KEY `fk_drTgtAggr` (`tgt_mirror_aggregate_id`),
  CONSTRAINT `fk_crTgtAggr` FOREIGN KEY (`tgt_vault_aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crTgtClusterId` FOREIGN KEY (`tgt_vault_storage_id`) REFERENCES `storage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crTgtDatacenterId` FOREIGN KEY (`tgt_vault_data_center_id`) REFERENCES `data_center` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_drTgtAggr` FOREIGN KEY (`tgt_mirror_aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_drTgtClusterId` FOREIGN KEY (`tgt_mirror_storage_id`) REFERENCES `storage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_drTgtDatacenterId` FOREIGN KEY (`tgt_mirror_data_center_id`) REFERENCES `data_center` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_replication_migration_cutover_src_to_tgt1` FOREIGN KEY (`migration_cutover_src_to_tgt_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `replication`
--

LOCK TABLES `replication` WRITE;
/*!40000 ALTER TABLE `replication` DISABLE KEYS */;
/*!40000 ALTER TABLE `replication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Schedule',
  `week_date` date NOT NULL DEFAULT '1900-01-01',
  `schedule_status` varchar(45) DEFAULT 'Open',
  `migration_limit` int(11) DEFAULT NULL,
  `migration_pending` int(11) DEFAULT NULL,
  `migration_booked` int(11) DEFAULT NULL,
  `host_connection_limit` int(11) DEFAULT '0',
  `host_connection_booked` int(11) NOT NULL DEFAULT '0',
  `host_connection_pending` int(11) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `schedule_reset`
--

DROP TABLE IF EXISTS `schedule_reset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_reset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Schedule Reset',
  `jsession_id` varchar(100) DEFAULT NULL,
  `user_corporate_id` int(11) DEFAULT NULL,
  `host_count` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_schedule_reset_schedule1_idx` (`schedule_id`),
  CONSTRAINT `fk_schedule_reset_schedule1` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_reset`
--

LOCK TABLES `schedule_reset` WRITE;
/*!40000 ALTER TABLE `schedule_reset` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_reset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `share` (
  `id` int(11) NOT NULL COMMENT 'ID of the Share. This is not a Surrogate!',
  `qtree_id` int(11) NOT NULL,
  `share_name` varchar(255) NOT NULL,
  `share_type` varchar(20) NOT NULL DEFAULT 'N/A',
  `host_id` int(11) NOT NULL DEFAULT '0',
  `owner_user_corporate_id` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shareId` (`id`,`host_id`),
  KEY `share_user_idx` (`owner_user_corporate_id`),
  KEY `share_host_appOwner_idx` (`host_id`),
  KEY `fk_share_qtree1_idx` (`qtree_id`),
  CONSTRAINT `fk_share_host_app_owner1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_share_qtree1` FOREIGN KEY (`qtree_id`) REFERENCES `qtree` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `id` int(11) NOT NULL COMMENT 'ID of the Storage. This is not a Surrogate!',
  `storage_name` varchar(255) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `microcode_version` varchar(255) DEFAULT NULL,
  `raw_capacity_mb` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `storage_name_idx` (`storage_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `storagex`
--

DROP TABLE IF EXISTS `storagex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storagex` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the StorageX',
  `migration_cutover_event_id` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `source_path` varchar(1024) DEFAULT NULL,
  `target_path` varchar(1024) DEFAULT NULL,
  `submitted` tinyint(4) DEFAULT '0',
  `completed` tinyint(4) DEFAULT '0',
  `policy_name` varchar(1024) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migration_id_UNIQUE` (`migration_cutover_event_id`),
  KEY `migration_id` (`migration_cutover_event_id`),
  CONSTRAINT `fk_storagex_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storagex`
--

LOCK TABLES `storagex` WRITE;
/*!40000 ALTER TABLE `storagex` DISABLE KEYS */;
/*!40000 ALTER TABLE `storagex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_admin`
--

DROP TABLE IF EXISTS `system_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the System Admin',
  `user_corporate_id` int(11) NOT NULL,
  `system_admin` varchar(100) NOT NULL DEFAULT 'UNKNOWN',
  `contact_type` enum('Group','STDID') NOT NULL DEFAULT 'Group',
  `mailing_list` varchar(255) DEFAULT NULL,
  `note` varchar(512) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolver_UNIQUE` (`system_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_admin`
--

LOCK TABLES `system_admin` WRITE;
/*!40000 ALTER TABLE `system_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_api`
--

DROP TABLE IF EXISTS `user_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User API',
  `client_secret` varchar(100) DEFAULT NULL,
  `client_id` varchar(100) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_api`
--

LOCK TABLES `user_api` WRITE;
/*!40000 ALTER TABLE `user_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_api` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_corporate`
--

DROP TABLE IF EXISTS `user_corporate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_corporate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User - Corporate',
  `user_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `title` varchar(255) DEFAULT 'UNKNOWN',
  `email` varchar(255) NOT NULL,
  `work_phone` varchar(45) DEFAULT NULL,
  `mobile_phone` varchar(45) DEFAULT NULL,
  `best_phone` varchar(45) DEFAULT NULL,
  `cost_center` varchar(100) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `timezone` varchar(45) DEFAULT NULL,
  `manager_user_corporate_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stdId_UNIQUE` (`user_name`),
  KEY `mgrStdId_idx` (`manager_user_corporate_id`),
  CONSTRAINT `fk_user_corporate_user_corporate1` FOREIGN KEY (`manager_user_corporate_id`) REFERENCES `user_corporate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_native`
--

DROP TABLE IF EXISTS `user_native`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_native` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User - Native.',
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `user_name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  `user_role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_idx` (`user_name`),
  KEY `user_role_id_idx` (`user_role_id`),
  CONSTRAINT `fk_user_native_user_role1` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User Role.',
  `user_role` varchar(30) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_users_roles1` (`user_role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `wfa_data`
--

DROP TABLE IF EXISTS `wfa_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wfa_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the WFA Data',
  `workflow_id` int(11) NOT NULL,
  `region` varchar(24) DEFAULT NULL,
  `protocol` varchar(20) DEFAULT NULL,
  `purpose` varchar(24) DEFAULT NULL,
  `nfs_export_rules` varchar(10) DEFAULT NULL,
  `dominant_protocol` varchar(10) DEFAULT NULL,
  `migration_target` tinyint(1) DEFAULT '1',
  `volume_size` float DEFAULT NULL,
  `high_overwrite` tinyint(1) DEFAULT NULL,
  `prod_datacenter` varchar(128) DEFAULT NULL,
  `prod_vserver` varchar(128) DEFAULT NULL,
  `prod_aggregate` varchar(128) DEFAULT NULL,
  `lob` varchar(255) DEFAULT NULL,
  `sub_lob` varchar(128) DEFAULT '-',
  `lob_information_owner` varchar(60) DEFAULT NULL,
  `app` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `env` varchar(10) DEFAULT NULL,
  `qos` int(11) DEFAULT NULL,
  `protection` varchar(128) DEFAULT NULL,
  `protection_topology` varchar(60) DEFAULT NULL,
  `mirror_data_center` varchar(128) DEFAULT NULL,
  `mirror_storage` varchar(255) DEFAULT NULL,
  `mirror_controller` varchar(128) DEFAULT NULL,
  `mirror_aggregate` varchar(128) DEFAULT NULL,
  `vault_data_center` varchar(128) DEFAULT NULL,
  `vault_storage` varchar(255) DEFAULT NULL,
  `vault_controller` varchar(128) DEFAULT NULL,
  `vault_aggregate` varchar(128) DEFAULT NULL,
  `prod_new_volume` varchar(255) DEFAULT NULL,
  `prod_storage` varchar(255) DEFAULT NULL,
  `prod_source_controller` varchar(255) DEFAULT NULL,
  `prod_source_volume` varchar(255) DEFAULT NULL,
  `prod_source_qtree` varchar(255) DEFAULT NULL,
  `mirror_source_controller` varchar(255) DEFAULT NULL,
  `mirror_source_volume` varchar(255) DEFAULT NULL,
  `mirror_source_qtree` varchar(255) DEFAULT NULL,
  `vault_source_controller` varchar(255) DEFAULT NULL,
  `vault_source_volume` varchar(255) DEFAULT NULL,
  `vault_source_qtree` varchar(255) DEFAULT NULL,
  `storagex_netgroup` varchar(128) DEFAULT NULL,
  `change_management` varchar(60) DEFAULT NULL,
  `change_number` int(11) DEFAULT NULL,
  `keep_global_ro` tinyint(1) DEFAULT NULL,
  `shared_netgroup` tinyint(1) DEFAULT NULL,
  `user_corporate_id` int(11) DEFAULT NULL,
  `description` varchar(60) DEFAULT '1000',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `workflowId_idx` (`workflow_id`),
  CONSTRAINT `workflowId` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wfa_data`
--

LOCK TABLES `wfa_data` WRITE;
/*!40000 ALTER TABLE `wfa_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wfa_message`
--

DROP TABLE IF EXISTS `wfa_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wfa_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the WFA Message',
  `workflow_id` int(11) NOT NULL,
  `code` varchar(16) DEFAULT NULL,
  `meaning` varchar(1024) DEFAULT NULL,
  `message` varchar(1024) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `wfa_message_workflow_idx` (`workflow_id`),
  CONSTRAINT `workflowId_fk` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wfa_message`
--

LOCK TABLES `wfa_message` WRITE;
/*!40000 ALTER TABLE `wfa_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wfa_ocum_controller_data`
--

DROP TABLE IF EXISTS `wfa_ocum_controller_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wfa_ocum_controller_data` (
  `id` int(11) NOT NULL COMMENT 'Surrogate ID of the WFA OCUM Controller Data.',
  `ocum_controller_serial_number` varchar(225) NOT NULL,
  `ocum_controller_name` varchar(225) NOT NULL,
  `controller_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `controller_id_UNIQUE` (`controller_id`),
  CONSTRAINT `fk_wfa_ocum_controller_data_controller1` FOREIGN KEY (`controller_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wfa_ocum_controller_data`
--

LOCK TABLES `wfa_ocum_controller_data` WRITE;
/*!40000 ALTER TABLE `wfa_ocum_controller_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_ocum_controller_data` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Workflow',
	`migration_cutover_src_to_tgt_id` INT(11) NOT NULL,
	`migration_cutover_src_to_tgt_migration_cutover_event_id` INT(11) NOT NULL,
	`wfa_uuid` VARCHAR(255) NULL DEFAULT NULL,
	`wfa_job_id` VARCHAR(255) NULL DEFAULT NULL,
	`start_time` DATETIME NULL DEFAULT NULL,
	`error_code` VARCHAR(60) NULL DEFAULT NULL,
	`error_description` VARCHAR(128) NULL DEFAULT NULL,
	`job_type` VARCHAR(255) NULL DEFAULT NULL,
	`workflow_status` VARCHAR(60) NOT NULL DEFAULT 'Submitting',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `wfa_job_id_idx` (`wfa_job_id`),
	UNIQUE INDEX (`migration_cutover_src_to_tgt_id`, `migration_cutover_src_to_tgt_migration_cutover_event_id`),
	CONSTRAINT `fk_workflow_migration_cutover_src_to_tgt1` FOREIGN KEY (`migration_cutover_src_to_tgt_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fk_workflow_migration_cutover_src_to_tgt2` FOREIGN KEY (`migration_cutover_src_to_tgt_migration_cutover_event_id`) REFERENCES `migration_cutover_src_to_tgt` (`migration_cutover_event_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `preference`;
CREATE TABLE `preference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_name` varchar(255) DEFAULT NULL,
  `preference_type` varchar(255) DEFAULT NULL,
  `corp_user_id` int(11) DEFAULT NULL,
  `native_user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `preference_detail`;
CREATE TABLE IF NOT EXISTS `preference_detail` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`preference_id` INT(11) NULL DEFAULT NULL,
	`field_name` VARCHAR(255) NULL DEFAULT NULL,
	`field_prop` VARCHAR(50) NULL DEFAULT NULL,
	`field_order` INT(11) NULL DEFAULT NULL,
	`field_template` VARCHAR(50) NULL DEFAULT NULL,
	`field_visible` TINYINT(1) NULL DEFAULT '1',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	INDEX `fk_preference_detail_preference` (`preference_id`),
	CONSTRAINT `fk_preference_detail_preference` FOREIGN KEY (`preference_id`) REFERENCES `preference` (`id`)
);

DROP TABLE IF EXISTS `controller_release`;
CREATE TABLE `controller_release` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`src_controller_id` INT(11) NOT NULL,
	`tgt_controller_id` INT(11) NULL DEFAULT NULL,
	`processed` TINYINT(1) NULL DEFAULT '0',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`, `src_controller_id`),
	UNIQUE INDEX `fk_controller_id_src` (`src_controller_id`),
	INDEX `fk_controller_release_controller2_idx` (`tgt_controller_id`),
	CONSTRAINT `fk_controller_id_src` FOREIGN KEY (`src_controller_id`) REFERENCES `controller` (`id`)
);


-- REFACTOR work_package to controller_targets_available


CREATE TABLE IF NOT EXISTS `controller_work_package` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Work Package',
	`controller_id` INT(11) NOT NULL,
	`work_package_name` VARCHAR(255) NOT NULL,
	`asset_number` VARCHAR(60) NULL DEFAULT NULL,
	`controller_installed_date` DATE NULL DEFAULT NULL,
	`priority` INT(11) NULL DEFAULT NULL,
	`processed` TINYINT(1) NULL DEFAULT '0',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`, `controller_id`),
	UNIQUE INDEX `controller_id_unique` (`controller_id`),
	INDEX `fk_controller_targets_available_controller1_idx` (`controller_id`),
	CONSTRAINT `fk_controller_targets_available_controller1` FOREIGN KEY (`controller_id`) REFERENCES `controller` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);


DROP TABLE IF EXISTS `ads_report`;
CREATE TABLE `ads_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_name` varchar(45) NOT NULL,
  `report_title` varchar(45) NOT NULL,
  `report_description` varchar(1000) NOT NULL,
  `ads_module` varchar(45) NOT NULL,
  `view_or_table_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `report_name_and_ads_module` (`report_name`,`ads_module`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ads_report_detail`;
CREATE TABLE `ads_report_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ads_report_id` int(11) NOT NULL,
  `column_name` varchar(45) NOT NULL,
  `column_type` varchar(45) NOT NULL,
  `column_label` varchar(45) NOT NULL,
  `column_sequence` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ads_report_fk_idx` (`ads_report_id`),
  CONSTRAINT `ads_report_fk` FOREIGN KEY (`ads_report_id`) REFERENCES `ads_report` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `qtree_disposition`;
CREATE TABLE `qtree_disposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qtree_id` int(11) NOT NULL,
  `disposition` varchar(1024) NOT NULL,
  `justification` varchar(1024) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `qtree_disposition_qtree_fk` FOREIGN KEY (`qtree_id`) REFERENCES `qtree` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8; 

CREATE VIEW `call_me_report` AS
    SELECT 
        `ar`.`id` AS `id`,
        `ar`.`activity_id` AS `activity_id`,
        (SELECT 
                `uc`.`user_name`
            FROM
                `user_corporate` `uc`
            WHERE
                (`ar`.`owner_user_corporate_id` = `uc`.`id`)) AS `user_name`,
        `ar`.`is_owner` AS `is_owner`,
        `ar`.`is_presumed` AS `is_presumed`,
        (SELECT 
                `uc`.`user_name`
            FROM
                `user_corporate` `uc`
            WHERE
                (`ar`.`suggested_owner_user_corporate_id` = `uc`.`id`)) AS `suggested_user_name`
    FROM
        (`activity_response` `ar`
        JOIN `activity` `a`)
    WHERE
        (`a`.`id` = `ar`.`activity_id`);
			
			
			

            
			
CREATE 
VIEW `user_native_report` AS
    SELECT 
        `un`.`id` AS `id`,
        `un`.`first_name` AS `first_name`,
        `un`.`last_name` AS `last_name`,
        `un`.`email` AS `email`,
        `un`.`user_name` AS `user_name`,
        `un`.`enabled` AS `enabled`,
        `ur`.`user_role` AS `user_role`
    FROM
        (`user_native` `un`
        JOIN `user_roles` `ur`)
    WHERE
        (`un`.`user_role_id` = `ur`.`id`);
		
		
		



--
-- Dumping events for database 'vitae_data_refactor'
--

--
-- Dumping routines for database 'vitae_data_refactor'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_activity_migrate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_activity_migrate`(IN migrateWeek datetime)
BEGIN
		INSERT INTO vitae_data.migration
		(migrate_week, migrate_day, migrate_time, ao_stdid, applicationName, lob, src_contId, src_vFilerName, src_aggrId, src_volName, 
			src_volId, src_qtreeId, src_datacenterId, tgt_storageId, tgt_volName, tgt_vol_size)
		SELECT
			vitae_data.activity.migrate_week,
			vitae_data.activity.migrate_day,
			vitae_data.activity.migrate_time,
			IFNULL(vitae_data.activity.owner_actual_stdid, 'Z999998') as owner_actual_stdid,
			IFNULL(vitae_data.activity.app_name_list, 'unknown') as app_name_list,
            IFNULL(vitae_data.activity.lob_presumed,'orphan'),
			vitae_data.controller.id as srcContId, 
			vitae_data.activity.vServer,
			vitae_data.activity.aggrId,
			vitae_data.activity.vol_name as src_volName,
			vitae_data.activity.intVolId,
			vitae_data.qtree.id qtreeId,
			vitae_data.datacenter.id as datacenterId,
            vitae_data.cycle.targetClusterId,
            CONCAT(vitae_data.storage.name, 'p_',LCASE(vitae_data.activity.lob_presumed), '_sub_',LCASE(REPLACE(vitae_data.activity.app_name_list,' ','')),'_prd'),
            CASE
				WHEN vitae_data.qtree.quotaHardCapacityLimitMB IS NULL AND vitae_data.qtree.quotaSoftCapacityLimitMB IS NULL AND vitae_data.qtree.quotaUsedCapacityMB IS NULL
					THEN IF(vitae_data.volume.allocCap > 10,vitae_data.volume.allocCap,10)
                WHEN vitae_data.qtree.quotaHardCapacityLimitMB IS NULL AND vitae_data.qtree.quotaSoftCapacityLimitMB IS NULL 
					THEN IF(vitae_data.qtree.quotaUsedCapacityMB > 10,vitae_data.qtree.quotaUsedCapacityMB,10)
				WHEN vitae_data.qtree.quotaHardCapacityLimitMB > vitae_data.qtree.quotaSoftCapacityLimitMB 
					THEN IF(vitae_data.qtree.quotaHardCapacityLimitMB/1024 > 10, CEIL(vitae_data.qtree.quotaHardCapacityLimitMB/1024), 10)
				WHEN vitae_data.qtree.quotaSoftCapacityLimitMB > vitae_data.qtree.quotaHardCapacityLimitMB 
					THEN IF(vitae_data.qtree.quotaSoftCapacityLimitMB/1024 > 10, CEIL(vitae_data.qtree.quotaSoftCapacityLimitMB/1024), 10)
				ELSE 10
            END 

		FROM vitae_data.activity 
		
        LEFT JOIN vitae_data.qtree 
			ON vitae_data.activity.intVolId = vitae_data.qtree.internalVolumeId
		
        JOIN vitae_data.volume
			ON vitae_data.activity.intVolId = vitae_data.volume.intVolId

		LEFT JOIN vitae_data.controller 
			ON vitae_data.activity.ctrl_name = vitae_data.controller.controllerName

		LEFT JOIN vitae_data.datacenter 
			ON vitae_data.controller.datacenter = vitae_data.datacenter.name
		
        JOIN vitae_data.cycle
			ON vitae_data.controller.controllerName = vitae_data.cycle.controllerName
		JOIN vitae_data.storage
			ON vitae_data.cycle.targetClusterId = vitae_data.storage.id

		WHERE activity.migrate_week = migrateWeek AND 
			vitae_data.qtree.id NOT IN 
				(SELECT id from vitae_data.qtree 
				GROUP BY vitae_data.qtree.internalVolumeId
				HAVING COUNT(vitae_data.qtree.internalVolumeId) > 1 AND vitae_data.qtree.name = '-')
;

END ;;
DELIMITER ;