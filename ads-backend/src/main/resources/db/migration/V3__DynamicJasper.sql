-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ads_dev
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `ads_report`
--

DROP TABLE IF EXISTS `ads_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ads_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_name` varchar(45) NOT NULL,
  `report_title` varchar(45) NOT NULL,
  `ads_module` varchar(45) NOT NULL,
  `view_or_table_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `ads_report` WRITE;
/*!40000 ALTER TABLE `ads_report` DISABLE KEYS */;
INSERT INTO `ads_report` VALUES (1,'call_me','Call Me Report','discover','call_me_report'),(2,'user_native','User Native Report','admin','user_native_report'),(3,'unknown_owner','Unknown Owner Report','discover','unknown_owner_report'),(4,'volume_decommission','Volume Decommission Report','discover','volume_decommission_report');
/*!40000 ALTER TABLE `ads_report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `ads_report_detail`
--

DROP TABLE IF EXISTS `ads_report_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ads_report_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ads_report_id` int(11) NOT NULL,
  `column_name` varchar(45) DEFAULT NULL,
  `column_type` varchar(45) DEFAULT NULL,
  `column_label` varchar(45) DEFAULT NULL,
  `column_sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ads_report_fk_idx` (`ads_report_id`),
  CONSTRAINT `ads_report_fk` FOREIGN KEY (`ads_report_id`) REFERENCES `ads_report` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ads_report_detail`
--

LOCK TABLES `ads_report_detail` WRITE;
/*!40000 ALTER TABLE `ads_report_detail` DISABLE KEYS */;
INSERT INTO `ads_report_detail` VALUES (1,1,'user_name','java.lang.String','First Name',1),(2,1,'is_owner','java.lang.Boolean','Owner',3),(3,1,'is_presumed','java.lang.Boolean','Presumed',2),(4,1,'suggested_user_name','java.lang.String','Suggested User Name',4),(5,2,'first_name','java.lang.String','First Name',1),(6,2,'last_name','java.lang.String','Last Name',2),(7,2,'email','java.lang.String','Email',4),(8,2,'user_name','java.lang.String','User Name',3),(9,2,'enabled','java.lang.Boolean','Enabled',6),(10,2,'user_role','java.lang.String','User Role',5),(11,3,'qtree_name','java.lang.String','QTree Name',1),(12,3,'volume_name','java.lang.String','Volume Name',2),(13,3,'disposition','java.lang.String','Disposition',3),(14,3,'migrate_week','java.util.Date','Migrate Week',5),(15,3,'will_delete','java.lang.Boolean','Delete',4),(16,3,'archive_candidate','java.lang.Boolean','Archive Candidate',6),(17,4,'qtree_name','java.lang.String','QTree Name',1),(18,4,'volume_name','java.lang.String','Volume Name',2),(19,4,'disposition','java.lang.String','Disposition',3),(20,4,'migrate_week','java.util.Date','Migrate Week',5),(21,4,'will_delete','java.lang.Boolean','Delete',6),(22,4,'will_migrate','java.lang.Boolean','Migrate',4);
/*!40000 ALTER TABLE `ads_report_detail` ENABLE KEYS */;
UNLOCK TABLES;



CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `ads_dev`.`call_me_report` AS
    SELECT 
        `ar`.`id` AS `id`,
        `ar`.`activity_id` AS `activity_id`,
        (SELECT 
                `uc`.`user_name`
            FROM
                `ads_dev`.`user_corporate` `uc`
            WHERE
                (`ar`.`owner_user_corporate_id` = `uc`.`id`)) AS `user_name`,
        `ar`.`is_owner` AS `is_owner`,
        `ar`.`is_presumed` AS `is_presumed`,
        (SELECT 
                `uc`.`user_name`
            FROM
                `ads_dev`.`user_corporate` `uc`
            WHERE
                (`ar`.`suggested_owner_user_corporate_id` = `uc`.`id`)) AS `suggested_user_name`
    FROM
        (`ads_dev`.`activity_response` `ar`
        JOIN `ads_dev`.`activity` `a`)
    WHERE
        (`a`.`id` = `ar`.`activity_id`);
			
			
			
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `ads_dev`.`unknown_owner_report` AS
    SELECT 
        `qt`.`qtree_name` AS `qtree_name`,
        `nv`.`volume_name` AS `volume_name`,
        `a`.`vserver` AS `vserver`,
        `a`.`disposition` AS `disposition`,
        `a`.`mailing_date` AS `mailing_date`,
        `a`.`will_delete` AS `will_delete`,
        `a`.`delete_date` AS `delete_date`,
        `a`.`will_migrate` AS `will_migrate`,
        `a`.`migrate_week` AS `migrate_week`,
        `a`.`migrate_day` AS `migrate_day`,
        `a`.`call_me` AS `call_me`,
        `a`.`best_number` AS `best_number`,
        `a`.`call_reason` AS `call_reason`,
        `a`.`archive_candidate` AS `archive_candidate`,
        `a`.`is_latest` AS `is_latest`,
        `a`.`admin_override` AS `admin_override`,
        `a`.`note` AS `note`,
        `a`.`app_name_list` AS `app_name_list`,
        `a`.`mail_count` AS `mail_count`,
        `a`.`migration_time_id` AS `migration_time_id`,
        `a`.`create_time` AS `create_time`,
        `a`.`update_time` AS `update_time`
    FROM
        ((`ads_dev`.`activity` `a`
        JOIN `ads_dev`.`qtree` `qt`)
        JOIN `ads_dev`.`nas_volume` `nv`)
    WHERE
        ((`a`.`qtree_id` = `qt`.`id`)
            AND (`qt`.`nas_volume_id` = `nv`.`id`)
            AND (`a`.`disposition` IN ('NFS-Orphan' , 'NFS-Orphan w/CIFS')));
			
			
			
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `ads_dev`.`user_native_report` AS
    SELECT 
        `un`.`id` AS `id`,
        `un`.`first_name` AS `first_name`,
        `un`.`last_name` AS `last_name`,
        `un`.`email` AS `email`,
        `un`.`user_name` AS `user_name`,
        `un`.`enabled` AS `enabled`,
        `ur`.`user_role` AS `user_role`
    FROM
        (`ads_dev`.`user_native` `un`
        JOIN `ads_dev`.`user_roles` `ur`)
    WHERE
        (`un`.`user_role_id` = `ur`.`id`);
		
		
		
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `ads_dev`.`volume_decommission_report` AS
    SELECT 
        `qt`.`qtree_name` AS `qtree_name`,
        `nv`.`volume_name` AS `volume_name`,
        `a`.`vserver` AS `vserver`,
        `a`.`disposition` AS `disposition`,
        `a`.`mailing_date` AS `mailing_date`,
        `a`.`will_delete` AS `will_delete`,
        `a`.`delete_date` AS `delete_date`,
        `a`.`will_migrate` AS `will_migrate`,
        `a`.`migrate_week` AS `migrate_week`,
        `a`.`migrate_day` AS `migrate_day`,
        `a`.`call_me` AS `call_me`,
        `a`.`best_number` AS `best_number`,
        `a`.`call_reason` AS `call_reason`,
        `a`.`archive_candidate` AS `archive_candidate`,
        `a`.`is_latest` AS `is_latest`,
        `a`.`admin_override` AS `admin_override`,
        `a`.`note` AS `note`,
        `a`.`app_name_list` AS `app_name_list`,
        `a`.`mail_count` AS `mail_count`,
        `a`.`migration_time_id` AS `migration_time_id`,
        `a`.`create_time` AS `create_time`,
        `a`.`update_time` AS `update_time`
    FROM
        ((`ads_dev`.`activity` `a`
        JOIN `ads_dev`.`qtree` `qt`)
        JOIN `ads_dev`.`nas_volume` `nv`)
    WHERE
        ((`a`.`qtree_id` = `qt`.`id`)
            AND (`qt`.`nas_volume_id` = `nv`.`id`)
            AND (`a`.`archive_candidate` = 1));






