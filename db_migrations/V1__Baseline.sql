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

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Activity.',
  `qtree_id` int(11) DEFAULT NULL COMMENT 'ID of the QTree which is associated with the Activity',
  `vserver` varchar(255) DEFAULT NULL COMMENT 'vServer of the Activity',
  `disposition` varchar(255) DEFAULT NULL COMMENT 'Disposition of the Activity',
  `mailing_date` date DEFAULT NULL COMMENT 'Date email was send to the Owner(s) of the Activity?',
  `will_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) will delete the QTree.',
  `delete_date` date DEFAULT NULL COMMENT 'Date on which the QTree can be deleted.',
  `will_migrate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) will migrate the QTree.',
  `migrate_week` date DEFAULT NULL COMMENT 'Week selected for migration of the QTree.',
  `migrate_day` int(11) DEFAULT '6' COMMENT 'Day of Week selected for migration of the QTree.',
  `call_me` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the Owner(s) want to be contacted by a Migration Specialist.',
  `best_number` varchar(100) DEFAULT NULL COMMENT 'Contact number for the Owner if they want to speak to a Migration Specialist.',
  `call_reason` varchar(2048) DEFAULT NULL COMMENT 'Primary reason why the Owner wants to be contacted by the Migration Specialist',
  `archive_candidate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the QTree is a canidiate for archiving',
  `is_latest` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'DEV TBD -  Boolean indicating if the Activity is the latest. We may be able to get this from the create time. So this may not be needed. Could save us time/code to set this column.',
  `admin_override` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Boolean indicating if the an Admin overrode an Owner',
  `note` varchar(1024) DEFAULT NULL COMMENT 'Note for the Activity',
  `app_name_list` varchar(1024) DEFAULT NULL COMMENT 'DEV TBD - We should be able to get the app from the Qtree to host to app relations.',
  `mail_count` int(1) DEFAULT '0' COMMENT 'Count of emails sent',
  `migration_time_id` int(11) DEFAULT NULL COMMENT 'Time selected for this Activity',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `Activity_has_a _Migration_Time_idx` (`migration_time_id`),
  KEY `fk_activity_qtree1_idx` (`qtree_id`),
  CONSTRAINT `Activity_has_a _Migration_Time` FOREIGN KEY (`migration_time_id`) REFERENCES `migration_time` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_activity_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_lob_x_ref` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_activity_migration_key_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_migration_key_x_ref` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_activity_presumed_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_presumed_lob_x_ref` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_qtree1` FOREIGN KEY (`qtree_id`) REFERENCES `qtree` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',3,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(2,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(3,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(4,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',2,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(5,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',5,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(6,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(7,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',3,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(8,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(9,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(10,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(11,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(12,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(13,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',2,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(14,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(15,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',4,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(16,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',6,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(17,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',6,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(18,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(19,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',7,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(20,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',2,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(21,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(22,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',5,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(23,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',2,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(24,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(25,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',6,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(26,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',6,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(27,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(28,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(29,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,1,'2017-06-26',3,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(30,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(31,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(32,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(33,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(34,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(35,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(36,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(37,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(38,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(39,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(40,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(41,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(42,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(43,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(44,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(45,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(46,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,'Multi','delgoods,delpeeps,codem',0,NULL,'2017-09-27 16:52:25',NULL),(47,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(48,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,'Multi','delgoods',0,NULL,'2017-09-27 16:52:25',NULL),(49,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(50,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,'Multi','delgoods,delpeeps,codem',0,NULL,'2017-09-27 16:52:25',NULL),(51,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(52,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,0,NULL,0,1,NULL,NULL,0,0,0,'Multi','delgoods,codem',0,NULL,'2017-09-27 16:52:25',NULL),(53,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(54,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,1,'2017-06-26',2,1,'1234567890',NULL,0,0,0,'Single','delgoods',0,NULL,'2017-09-27 16:52:25',NULL),(55,NULL,NULL,'DiscoverOwner','2017-05-13',0,NULL,1,'2017-06-26',1,0,NULL,NULL,0,0,0,'Single','delgoods',0,NULL,'2017-09-27 16:52:25',NULL),(56,NULL,NULL,'DiscoverOwner','2017-07-19',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,'Single','delpeeps',0,NULL,'2017-09-27 16:52:25',NULL),(57,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(58,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(59,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(60,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(61,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(62,NULL,NULL,'DiscoverOwner','2017-05-13',1,'2017-05-29',0,NULL,0,1,'1234567890',NULL,0,0,0,'Single','delgoods',0,NULL,'2017-09-27 16:52:25',NULL),(63,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(64,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(65,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(66,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(67,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(68,NULL,NULL,'NetApp','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(69,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(70,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(71,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(72,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(73,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(74,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(75,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(76,NULL,NULL,'DiscoverOwner','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(77,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(78,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(79,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(80,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(81,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(82,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(83,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(84,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(85,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(86,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(87,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(88,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(89,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(90,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(91,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(92,NULL,NULL,'NFS-Orphan','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(93,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(94,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(95,NULL,NULL,'CIFS-Only','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(96,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(97,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(98,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(99,NULL,NULL,'NFS-Orphan w/CIFS','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL),(100,NULL,NULL,'NetApp','1000-01-01',0,NULL,0,NULL,0,0,NULL,NULL,0,0,0,NULL,NULL,0,NULL,'2017-09-27 16:52:25',NULL);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `lob_id_idx` (`lob_id`)
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
  KEY `migration_key_idx` (`migration_key_id`)
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
  KEY `activity_id_and_lob_id` (`lob_id`,`activity_id`)
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
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`activity_id`),
  UNIQUE KEY `candidate_fk_key` (`activity_id`,`owner_user_corporate_id`),
  CONSTRAINT `fk_activity_response_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_response`
--

LOCK TABLES `activity_response` WRITE;
/*!40000 ALTER TABLE `activity_response` DISABLE KEYS */;
INSERT INTO `activity_response` VALUES (1,46,0,1,0,NULL,'2017-09-27 16:52:25',NULL),(2,48,0,0,0,1,'2017-09-27 16:52:25',NULL),(3,50,0,1,0,NULL,'2017-09-27 16:52:25',NULL),(4,52,0,1,0,NULL,'2017-09-27 16:52:25',NULL);
/*!40000 ALTER TABLE `activity_response` ENABLE KEYS */;
UNLOCK TABLES;

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
  `assigned_iops` int(11) NOT NULL DEFAULT '0',
  `assigned_capacity_gb` float(10,1) NOT NULL DEFAULT '0.0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`controller_id`),
  KEY `fk_aggregate_controller1_idx` (`controller_id`),
  KEY `controller_id_idx` (`id`,`controller_id`),
  CONSTRAINT `fk_aggregate_controller1` FOREIGN KEY (`controller_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggregate`
--

LOCK TABLES `aggregate` WRITE;
/*!40000 ALTER TABLE `aggregate` DISABLE KEYS */;
INSERT INTO `aggregate` VALUES (23,'fspodrtp03_n01_aggr0',503981,0,'AGGREGATE',1,503981,480501,510,4,5,0,0.0,'2017-09-27 16:52:25',NULL),(24,'fspodrtp03_n01_aggr1',7055740,0,'AGGREGATE',1,7055740,1035,2720,0,0,0,600000.0,'2017-09-27 16:52:25',NULL),(25,'fspodrtp03_n01_aggr2',7055740,0,'AGGREGATE',1,7055740,1035,2720,0,3,0,0.0,'2017-09-27 16:52:25',NULL),(26,'fspodrtp03_n02_aggr0',376181,0,'AGGREGATE',2,376181,358655,510,4,5,0,0.0,'2017-09-27 16:52:25',NULL),(27,'fspodrtp03_n02_aggr1',5266540,0,'AGGREGATE',2,5266540,0,2720,0,0,0,0.0,'2017-09-27 16:52:25',NULL),(28,'fspodrtp03_n02_aggr2',7055740,0,'AGGREGATE',2,7055740,0,2720,0,0,0,0.0,'2017-09-27 16:52:25',NULL),(29,'fspodrtp04_n01_aggr0',976693,0,'AGGREGATE',3,976693,929340,510,5,5,0,0.0,'2017-09-27 16:52:25',NULL),(30,'fspodrtp04_n01_aggr1',14393400,0,'AGGREGATE',3,14393400,1035,2720,0,0,0,0.0,'2017-09-27 16:52:25',NULL),(31,'fspodrtp04_n01_aggr2',14393400,0,'AGGREGATE',3,14393400,1035,2720,0,3,0,0.0,'2017-09-27 16:52:25',NULL),(32,'fspodrtp04_n02_aggr0',732717,0,'AGGREGATE',4,732717,697193,510,4,5,0,0.0,'2017-09-27 16:52:25',NULL),(33,'fspodrtp04_n02_aggr1',14393400,0,'AGGREGATE',4,14393400,0,2720,0,0,0,0.0,'2017-09-27 16:52:25',NULL),(34,'fspodrtp04_n02_aggr2',10797900,0,'AGGREGATE',4,10797900,0,2720,0,0,0,0.0,'2017-09-27 16:52:25',NULL),(413,'aggr0',1481650,0,'AGGREGATE',409,1481650,246752,600,7,12,0,0.0,'2017-09-27 16:52:25',NULL),(414,'aggr1',6092500,0,'AGGREGATE',409,6092500,219324,1500,0,28,0,0.0,'2017-09-27 16:52:25',NULL),(415,'aggr0',380781,0,'AGGREGATE',410,380781,363039,225,4,5,0,0.0,'2017-09-27 16:52:25',NULL),(416,'aggr1',3046250,0,'AGGREGATE',410,3046250,8608,750,0,3,0,0.0,'2017-09-27 16:52:25',NULL);
/*!40000 ALTER TABLE `aggregate` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`aggregate_id`),
  UNIQUE KEY `aggregate_id_idx` (`aggregate_id`),
  CONSTRAINT `fk_aggregate_to_aggregate_purpose` FOREIGN KEY (`aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggregate_purpose`
--

LOCK TABLES `aggregate_purpose` WRITE;
/*!40000 ALTER TABLE `aggregate_purpose` DISABLE KEYS */;
INSERT INTO `aggregate_purpose` VALUES (1,1,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(2,2,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(602,602,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(603,603,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(604,604,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(605,605,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(606,606,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(607,607,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(608,608,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(609,609,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(610,610,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(611,611,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(612,612,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(613,613,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(614,614,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(615,615,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(616,616,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(617,617,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(618,618,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(619,619,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(620,620,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(621,621,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL),(622,622,NULL,NULL,NULL,'2017-09-27 16:52:25',NULL);
/*!40000 ALTER TABLE `aggregate_purpose` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_application_application_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `application_lob_x_ref` (`application_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_application_host_application_x_ref1` FOREIGN KEY (`id`) REFERENCES `host_application_x_ref` (`application_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,'78912','delgoods',NULL,1,NULL,'2017-09-27 16:52:25',NULL),(2,'78912','delgoods',NULL,1,NULL,'2017-09-27 16:52:25',NULL),(3,'45623','delpeeps',NULL,1,NULL,'2017-09-27 16:52:25',NULL),(4,'45623','delpeeps',NULL,1,NULL,'2017-09-27 16:52:25',NULL),(5,'45623','delpeeps',NULL,1,NULL,'2017-09-27 16:52:25',NULL),(6,'91234','codem',NULL,1,NULL,'2017-09-27 16:52:25','2017-09-27 16:56:11');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `application_id_and_lob_id` (`lob_id`,`application_id`)
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
  PRIMARY KEY (`id`,`audit_event_id`),
  KEY `fk_audit_reason_code_audit_event1_idx` (`audit_event_id`),
  CONSTRAINT `fk_audit_reason_code_audit_event1` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_reason_code`
--

LOCK TABLES `audit_reason_code` WRITE;
/*!40000 ALTER TABLE `audit_reason_code` DISABLE KEYS */;
INSERT INTO `audit_reason_code` VALUES (1,272,'Other','2017-09-27 16:52:26',NULL),(2,2,'WPIE-Reason','2017-09-27 16:52:26',NULL),(3,3,'WPID-Reason','2017-09-27 16:52:26',NULL),(4,5,'OOME-Reason','2017-09-27 16:52:26',NULL),(5,14,'SARA-Reason','2017-09-27 16:52:26',NULL),(6,15,'SARE-Reason','2017-09-27 16:52:26',NULL),(7,16,'SARD-Reason','2017-09-27 16:52:26',NULL),(8,11,'OOUE-Reason','2017-09-27 16:52:26',NULL),(9,8,'OODE-Reason','2017-09-27 16:52:26',NULL),(10,17,'MERS-Reason','2017-09-27 16:52:26',NULL),(11,18,'MERC-Reason','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `audit_reason_code` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`audit_event_id`),
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
  PRIMARY KEY (`id`,`audit_event_id`),
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
  PRIMARY KEY (`id`,`audit_event_id`),
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
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
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
  `id` int(11) NOT NULL,
  `controller_name` varchar(255) NOT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `storage_id` int(11) NOT NULL,
  `date_available` date DEFAULT '2050-12-31',
  `volume_tally` int(11) DEFAULT NULL,
  `data_center_id` int(11) NOT NULL,
  `exports_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`storage_id`,`data_center_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_con_dc_id` (`data_center_id`),
  KEY `fk_con_storage_id` (`storage_id`),
  KEY `fk_exports_id` (`exports_id`),
  CONSTRAINT `fk_con_dc_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`),
  CONSTRAINT `fk_con_storage_id` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controller`
--

LOCK TABLES `controller` WRITE;
/*!40000 ALTER TABLE `controller` DISABLE KEYS */;
INSERT INTO `controller` VALUES (1,'fspodrtp03-n01','100000000817',17,'2017-05-07',23,0,0,'2017-09-27 16:52:26',NULL),(2,'fspodrtp03-n02','100000000816',17,'2017-05-07',27,0,0,'2017-09-27 16:52:26',NULL),(3,'fspodrtp04-n01','100000000814',18,'2017-05-07',69,0,0,'2017-09-27 16:52:26',NULL),(4,'fspodrtp04-n02','100000000813',18,'2017-05-07',1,0,0,'2017-09-27 16:52:26',NULL),(409,'7GN1-RTPRDC.hop.lab','30004713',41,'2017-05-07',86,0,0,'2017-09-27 16:52:26',NULL),(410,'7GN2-RTPRDC.rdc.lab','30004714',41,'2017-05-07',14,0,0,'2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `controller` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`schedule_id`),
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
  PRIMARY KEY (`id`,`cutover_id`),
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
  PRIMARY KEY (`id`,`cutover_assembly_id`),
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
  UNIQUE KEY `datacenter_name_idx` (`data_center_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_center`
--

LOCK TABLES `data_center` WRITE;
/*!40000 ALTER TABLE `data_center` DISABLE KEYS */;
INSERT INTO `data_center` VALUES (1,'MMS1','MMS DC 1','RTP','USA','NA',NULL,'2017-09-27 16:52:26',NULL),(2,'MMS2','MMS DC 2','NYC','USA','NA',NULL,'2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `data_center` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `email_template`
--

LOCK TABLES `email_template` WRITE;
/*!40000 ALTER TABLE `email_template` DISABLE KEYS */;
INSERT INTO `email_template` VALUES (1,'ownerDiscoverTemplete.vm',NULL,'2017-09-27 16:52:26',NULL),(2,'multiOwnerDiscoverTemplete.vm',NULL,'2017-09-27 16:52:26',NULL),(3,'mstApplicationOwnerTemplate.vm',NULL,'2017-09-27 16:52:26',NULL),(4,'serverAdminTemplate.vm',NULL,'2017-09-27 16:52:26',NULL),(5,'nasLeadEngineerEmailTemplate.vm',NULL,'2017-09-27 16:52:26',NULL),(6,'mstApplicationOwnerReminderTempl',NULL,'2017-09-27 16:52:26',NULL),(7,'mstServerAdminReminderTemplate.v',NULL,'2017-09-27 16:52:26',NULL),(8,'mstNasLeadEngineerReminderTempla',NULL,'2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `email_template` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_exports_controller1` FOREIGN KEY (`id`) REFERENCES `controller` (`exports_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exports_exports_host_x_ref1` FOREIGN KEY (`id`) REFERENCES `exports_host_x_ref` (`exports_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  KEY `exports_id_host_id` (`exports_id`,`host_id`)
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
  UNIQUE KEY `host_ip_idx` (`ip_addr`),
  CONSTRAINT `fk_host_exports_host_x_ref1` FOREIGN KEY (`id`) REFERENCES `exports_host_x_ref` (`host_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_host_host_application_x_ref1` FOREIGN KEY (`id`) REFERENCES `host_application_x_ref` (`host_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,NULL,'10.216.50.86',0,NULL,NULL,'2017-09-27 16:52:26',NULL),(2,NULL,'10.216.49.28',0,'Single',NULL,'2017-09-27 16:52:26',NULL),(3,NULL,'10.216.49.38',0,'Single',NULL,'2017-09-27 16:52:26',NULL),(4,'DESKTOP-K2PD29D','10.216.49.27',0,'Single',NULL,'2017-09-27 16:52:26',NULL),(5,'WIN2012-R2-TEMP','10.216.49.91',0,NULL,NULL,'2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `host_id_application_id` (`application_id`,`host_id`)
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
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
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
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_line_of_business_activity_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_lob_x_ref` (`lob_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_line_of_business_activity_presumed_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_presumed_lob_x_ref` (`lob_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_line_of_business_application_lob_x_ref1` FOREIGN KEY (`id`) REFERENCES `application_lob_x_ref` (`lob_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_line_of_business_exports1` FOREIGN KEY (`id`) REFERENCES `exports` (`lob_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
  KEY `fk_migration_cutover_src_to_tgt_migration_cutover_event1_idx` (`migration_cutover_event_id`),
  KEY `fk_migration_cutover_src_to_tgt_data_protection_policy1_idx` (`data_protection_policy_id`),
  CONSTRAINT `fk_migration_cutover_src_to_tgt_data_protection_policy1` FOREIGN KEY (`data_protection_policy_id`) REFERENCES `data_protection_policy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_migration_cutover_src_to_tgt_migration_cutover_event1` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_migration_cutover_src_to_tgt_migration_cutover_team` FOREIGN KEY (`id`) REFERENCES `migration_cutover_team` (`migration_cutover_src_to_tgt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  KEY `migration_cutover_src_to_tgt_id_idx` (`migration_cutover_src_to_tgt_id`)
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
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `migration_key_UNIQUE` (`migration_key`),
  UNIQUE KEY `user_corporate_id_UNIQUE` (`user_corporate_id`),
  CONSTRAINT `fk_migration_key_activity_migration_key_x_ref1` FOREIGN KEY (`id`) REFERENCES `activity_migration_key_x_ref` (`migration_key_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration_key`
--

LOCK TABLES `migration_key` WRITE;
/*!40000 ALTER TABLE `migration_key` DISABLE KEYS */;
INSERT INTO `migration_key` VALUES (1,'JWs2OOpz',1,'2017-09-27 16:52:26',NULL),(2,'2yTuQmJz',2,'2017-09-27 16:52:26',NULL),(3,'hlo3jLiQ',3,'2017-09-27 16:52:26',NULL),(4,'BfX8LHcq',4,'2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `migration_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migration_time`
--

DROP TABLE IF EXISTS `migration_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migration_time` (
  `id` int(11) NOT NULL COMMENT 'Surrogate ID of the Migration Time',
  `time_slot` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migration_time`
--

LOCK TABLES `migration_time` WRITE;
/*!40000 ALTER TABLE `migration_time` DISABLE KEYS */;
INSERT INTO `migration_time` VALUES (1,'0100','2017-09-27 16:52:26',NULL),(2,'0300','2017-09-27 16:52:26',NULL),(3,'0600','2017-09-27 16:52:26',NULL),(4,'0900','2017-09-27 16:52:26',NULL),(5,'1200','2017-09-27 16:52:26',NULL),(6,'1500','2017-09-27 16:52:26',NULL),(7,'1800','2017-09-27 16:52:26',NULL),(8,'2100','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `migration_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mms_config`
--

DROP TABLE IF EXISTS `mms_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mms_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `environment_name` varchar(8) NOT NULL,
  `component_name` varchar(255) DEFAULT NULL,
  `subcomponent_name` varchar(255) DEFAULT NULL,
  `property_name` varchar(255) NOT NULL,
  `property_value` varchar(255) NOT NULL,
  `property_type_id` int(11) DEFAULT NULL,
  `encrypted` tinyint(1) NOT NULL DEFAULT '0',
  `expiration` date DEFAULT NULL,
  `last_update_user` varchar(255) NOT NULL,
  `last_updated_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `prop_env_id` (`property_name`,`environment_name`),
  KEY `fk_property_type` (`property_type_id`),
  CONSTRAINT `fk_property_type` FOREIGN KEY (`property_type_id`) REFERENCES `mms_property_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2054 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mms_config`
--

LOCK TABLES `mms_config` WRITE;
/*!40000 ALTER TABLE `mms_config` DISABLE KEYS */;
INSERT INTO `mms_config` VALUES (1851,'PROD',NULL,NULL,'base.url','http://vitae.corp.netapp.com:8008/discover',1,0,NULL,'ADMIN','2017-04-17 14:42:07','2017-09-27 16:52:26',NULL),(1852,'PROD',NULL,NULL,'wfa.provision.name','',1,0,NULL,'ADMIN','2017-04-17 14:42:07','2017-09-27 16:52:26',NULL),(1853,'PROD',NULL,NULL,'Aged.Limit1','3',1,0,NULL,'ADMIN','2017-04-17 14:42:07','2017-09-27 16:52:26',NULL),(1854,'PROD',NULL,NULL,'wfa.ldap.name','',1,0,NULL,'ADMIN','2017-04-17 14:42:07','2017-09-27 16:52:26',NULL),(1855,'PROD',NULL,NULL,'HostMountPointsJob.cron.expression','0 0 17 * * MON-FRI',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1856,'PROD',NULL,NULL,'rest.verum.app.host','verum.jpmchase.net',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1857,'PROD',NULL,NULL,'rest.verum.authorize.token','https://verum.jpmchase.net/verum/4.0/authorize/getToken',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1858,'PROD',NULL,NULL,'resource.url','http://phone.jpmchase.net',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1859,'PROD',NULL,NULL,'WFA_PORT','',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1860,'PROD',NULL,NULL,'WFA_SERVER','',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1861,'PROD',NULL,NULL,'rest.verum.filesystem.uri.test','http://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP={primaryIP}&status=Installed/FileSystem?fileSystemType=nfs,nfs3/OSI,FileSystem',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1862,'PROD',NULL,NULL,'rest.verum.resolver.uri.test','http://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP={primaryIP}/Contact?contactType=PRIMARYRESOLVER/OSI,Contact?format=json/',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1863,'PROD',NULL,NULL,'password','Thr33Sp!res',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1864,'PROD',NULL,NULL,'WFA_LDAP_NAME','JPMC_STORAGEX_MMS_LDAP_CREATE_V1.0 - PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1865,'PROD',NULL,NULL,'Test','on',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1866,'PROD',NULL,NULL,'CreateMigrationKeyJob.cron.multi.expression','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1867,'PROD',NULL,NULL,'login.sso.principalRequestHeader','SM_USER',1,0,NULL,'ADMIN','2017-04-17 14:42:08','2017-09-27 16:52:26',NULL),(1868,'PROD',NULL,NULL,'schedule.migrate.close.weeks','6',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1869,'PROD',NULL,NULL,'rest.GetInfoByZIP.uri','http://www.webservicex.net/uszip.asmx/GetInfoByZIP?USZip={zipCode}',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1870,'PROD',NULL,NULL,'demo.email.to','Scott.Wipperman@netapp.com',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1871,'PROD',NULL,NULL,'StartEngineJob.cron.expression','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1872,'PROD',NULL,NULL,'rest.verum.resolver.uri','/Verum/4.0/api/OSI?iprimaryIp={primaryIP}/Contact?contactType=PRIMARYRESOLVER/OSI,Contact?format=json/',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1873,'PROD',NULL,NULL,'GenerateMigrationWeekJob.cron.expression','0 0 0 1 1 ?',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1874,'PROD',NULL,NULL,'serverAdminEmail','/mstsa',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1875,'PROD',NULL,NULL,'Demo','on',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1876,'PROD',NULL,NULL,'demo.email.host','mailhost.netapp.com',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1877,'PROD',NULL,NULL,'wfa.server','10.216.49.36',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1878,'PROD',NULL,NULL,'WFA_PROVISION_NAME','JPMC_cDOT_Provisioning _v0.18 – Phase 2 – PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1879,'PROD',NULL,NULL,'wfa.netgroup.name','JPMC_MMS_CDOT_Provisioning%20_v1',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1880,'PROD',NULL,NULL,'rest.verum.url.scheme','https',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1881,'PROD',NULL,NULL,'WFA_PRE_CUTOVER_NAME','JPMC_ MMS_MIGRATION_PRE-CUTOVER_V1.0 - PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1882,'PROD',NULL,NULL,'rest.verum.filesystem.uri','/Verum/4.0/api/OSI?primaryIP={primaryIP}&status=Installed/FileSystem?fileSystemType=nfs,nfs3/OSI,FileSystem',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1883,'PROD',NULL,NULL,'CloseScheduleJob.cron.expression1','0 30 14 21 4 ?',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1884,'PROD',NULL,NULL,'rest.esource.user.uri.test','http://10.216.49.32:8090/peoplelkp/PDXMLService2?sid=',1,0,NULL,'ADMIN','2017-04-17 14:42:09','2017-09-27 16:52:26',NULL),(1885,'PROD',NULL,NULL,'rest.verum.app.host.test','10.216.49.32:8090',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1886,'PROD',NULL,NULL,'rest.verum.person.uri','https://verum.jpmchase.net/Verum/4.0/api/Person?SID={standardID}/Person?format=json',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1887,'PROD',NULL,NULL,'nas_engineering_lead','',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1888,'PROD',NULL,NULL,'wfa.preview','on',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1889,'PROD',NULL,NULL,'reminder.days','3',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1890,'PROD',NULL,NULL,'wfa.api.uri','',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1891,'PROD',NULL,NULL,'rest.esource.user.uri','https://phone.jpmchase.net/peoplelkp/PDXMLService2?sid={standardID}',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1892,'PROD',NULL,NULL,'CUTOVER_PREFIX','MMS-QA',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1893,'PROD',NULL,NULL,'Aged.Limit2','6',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1894,'PROD',NULL,NULL,'Aged.Limit3','13',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1895,'PROD',NULL,NULL,'rest.verum.person.uri.test','http://10.216.49.32:8090/Verum/4.0/api/Person?SID={standardID}/Person',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1896,'PROD',NULL,NULL,'email.subject','NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1897,'PROD',NULL,NULL,'customerServiceAO','/mst',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1898,'PROD',NULL,NULL,'WFA_PASSWORD','',1,0,NULL,'ADMIN','2017-04-17 14:42:10','2017-09-27 16:52:26',NULL),(1899,'PROD',NULL,NULL,'wfa.password','HB7qA4ovs2fQ15A1WZANTw==',1,1,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1900,'PROD',NULL,NULL,'customerServiceNas','/mstnas',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1901,'PROD',NULL,NULL,'schedule.migrate.filter.weeks','6',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1902,'PROD',NULL,NULL,'EmailNotificationJob.cron.single','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1903,'PROD',NULL,NULL,'EmailNotificationJob.cron.single.reminder','0 0 1 * * MON-FRI',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1904,'PROD',NULL,NULL,'mst_application_owner.subject','Migration Support Contact Request',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1905,'PROD',NULL,NULL,'rest.verum.app.uri.test','https://10.216.49.32:8090/Verum/4.0/api/OSI?primaryIP=192.168.10.200/Application/Contact?contactType=Ap...',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1906,'PROD',NULL,NULL,'WFA_USER','',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1907,'PROD',NULL,NULL,'wfa.port','',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1908,'PROD',NULL,NULL,'email.subject.prefix','Action Required: ',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1909,'PROD',NULL,NULL,'demo.email.from','DO_NOT_REPLY@netapp.com',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1910,'PROD',NULL,NULL,'email.host','mailhost.jpmchase.com',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1911,'PROD',NULL,NULL,'CreateMigrationKeyJob.cron.single.expression','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1912,'PROD',NULL,NULL,'rule.Aggr_Oversubscribe_Pct','60',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1913,'PROD',NULL,NULL,'WFA_CLEAN_UP_NAME','JPMC_ MMS_POST-MIGRATION_CLEAN-UP_V1.0 - PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1914,'PROD',NULL,NULL,'password_test','87i3AbN9Fzc=',1,1,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1915,'PROD',NULL,NULL,'rest.iso2code.uri','http://services.groupkt.com/country/get/iso2code/{state}',1,0,NULL,'ADMIN','2017-04-17 14:42:11','2017-09-27 16:52:26',NULL),(1916,'PROD',NULL,NULL,'email.from','DO_NOT_REPLY@jpmchase.com',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1917,'PROD',NULL,NULL,'EmailNotificationJob.cron.multi','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1918,'PROD',NULL,NULL,'WFA_CIFS_COPY_NAME','JPMC_STORAGEX_MMS_COPY_CIFS_SHARES_V1.0 - PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1919,'PROD',NULL,NULL,'schedule.hostConnectionLimit','1000',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1920,'PROD',NULL,NULL,'rest.random.uri','http://gturnquist-quoters.cfapps.io/api/random',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1921,'PROD',NULL,NULL,'EmailNotificationJob.cron.expression1','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1922,'PROD',NULL,NULL,'vitae.runMode','DEV',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1923,'PROD',NULL,NULL,'EmailNotificationJob.cron.expression2','0 0 1 * * MON-FRI',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1924,'PROD',NULL,NULL,'wfa.user','Vitae',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1925,'PROD',NULL,NULL,'EmailNotificationJob.cron.multi.reminder','0 0 1 * * MON-FRI',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1926,'PROD',NULL,NULL,'rest.fundraising.uri','http://api.kivaws.org/v1/loans/search.json?status=fundraising',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1927,'PROD',NULL,NULL,'HostResolverJob.cron.expression','0 0 17 * * MON-FRI',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1928,'PROD',NULL,NULL,'WFA_NETGROUP_NAME','JPMC_STORAGEX_MMS_LDAP_FINAL_PRECHECK_V1.0 - PRD',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1929,'PROD',NULL,NULL,'schedule.volumeLimit','30',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1930,'PROD',NULL,NULL,'wfa.netgroup.jobtype','NETGROUP',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1931,'PROD',NULL,NULL,'username_test','bill',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1932,'PROD',NULL,NULL,'rest.verum.app.uri','https://verum.jpmchase.net/Verum/4.0/api/OSI?primaryIP={primaryIP}/Application/Contact?contactType={contactType}/OSI,Applicaiton/Contact?format=json/',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1933,'PROD',NULL,NULL,'email.port','587',1,0,NULL,'ADMIN','2017-04-17 14:42:12','2017-09-27 16:52:26',NULL),(1934,'PROD',NULL,NULL,'rule.capacity_overhead_pct','80',1,0,NULL,'ADMIN','2017-04-17 14:42:13','2017-09-27 16:52:26',NULL),(1935,'PROD',NULL,NULL,'WFA_API_URI','',1,0,NULL,'ADMIN','2017-04-17 14:42:13','2017-09-27 16:52:26',NULL),(1936,'PROD',NULL,NULL,'username','F591154',1,0,NULL,'ADMIN','2017-04-17 14:42:13','2017-09-27 16:52:26',NULL),(1937,'PROD',NULL,NULL,'ControllerReleaseJob.cron.expression1','0 0 1 * * MON',1,0,NULL,'ADMIN','2017-04-17 14:42:13','2017-09-27 16:52:26',NULL),(1947,'PROD',NULL,NULL,'PROCESS_DOCUMENTATION_URL','\"http://www.netapp.com\" ',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1959,'PROD',NULL,NULL,'email.subject.single','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1960,'PROD',NULL,NULL,'email.subject.multi','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1961,'PROD',NULL,NULL,'email.subject.appowner','Action Required: Migration Support Contact Request',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1962,'PROD',NULL,NULL,'email.subject.sysadmin','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1963,'PROD',NULL,NULL,'email.subject.nasengineer','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1964,'PROD',NULL,NULL,'email.subject.default','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1965,'PROD',NULL,NULL,'schedule.email.owner.weeks','6',2,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1966,'PROD',NULL,NULL,'schedule.email.sysadmin.weeks','4',2,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1967,'PROD',NULL,NULL,'schedule.email.NAS.weeks','4',2,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1968,'PROD',NULL,NULL,'schedule.email.NAS.leademail','sofia.zhang@netapp.com',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(1969,'PROD',NULL,NULL,'schedule.email.NAS.leadname','Lew Newby',1,0,NULL,'ADMIN','2017-04-23 13:00:07','2017-09-27 16:52:26',NULL),(2040,'PROD',NULL,NULL,'email.template.appowner','mstApplicationOwnerTemplate.vm',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2041,'PROD',NULL,NULL,'email.template.serveradmin','serverAdminTemplate.vm',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2042,'PROD',NULL,NULL,'clusterVserverPrefix','p',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2043,'PROD',NULL,NULL,'email.template.single','ownerDiscoverTemplete.vm',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2044,'PROD',NULL,NULL,'wfa.starting.uid','1006',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2045,'PROD',NULL,NULL,'email.template.nasengineer','nasLeadEngineerEmailTemplate.vm',1,0,NULL,'ADMIN','2017-07-18 19:17:42','2017-09-27 16:52:26',NULL),(2046,'PROD',NULL,NULL,'email.template.multi','multiOwnerDiscoverTemplete.vm',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2047,'PROD',NULL,NULL,'schedule.email.cutover.days','7',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2048,'PROD',NULL,NULL,'email.subject.appowner.reminder','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2049,'PROD',NULL,NULL,'email.subject.sysadmin.reminder','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2050,'PROD',NULL,NULL,'email.subject.nasengineer.reminder','Action Required: NAS Refresh and Volume Migration',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2051,'PROD',NULL,NULL,'email.template.appowner.reminder','mstApplicationOwnerReminderTemplate.vm',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2052,'PROD',NULL,NULL,'email.template.serveradmin.reminder','mstServerAdminReminderTemplate.vm',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL),(2053,'PROD',NULL,NULL,'email.template.nasengineer.reminder','mstNasLeadEngineerReminderTemplate.vm',1,0,NULL,'ADMIN','2017-07-25 19:17:42','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `mms_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mms_property_type`
--

DROP TABLE IF EXISTS `mms_property_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mms_property_type` (
  `id` int(11) NOT NULL DEFAULT '0',
  `property_type` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mms_property_type`
--

LOCK TABLES `mms_property_type` WRITE;
/*!40000 ALTER TABLE `mms_property_type` DISABLE KEYS */;
INSERT INTO `mms_property_type` VALUES (1,'String','2017-09-27 16:52:26',NULL),(2,'Int','2017-09-27 16:52:26',NULL),(3,'Boolean','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `mms_property_type` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`host_id`),
  UNIQUE KEY `host_mount_idx` (`host_id`,`mount_location`),
  CONSTRAINT `mount_point_host_fk_1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount_point`
--

LOCK TABLES `mount_point` WRITE;
/*!40000 ALTER TABLE `mount_point` DISABLE KEYS */;
INSERT INTO `mount_point` VALUES (1,3,'/mounts/mms_nfs2_q1','927335','2017-09-27 16:52:26',NULL),(2,3,'/mounts/mms_nfs1_q3','927334','2017-09-27 16:52:26',NULL),(3,3,'/mounts/mms_nfs1_q2','927333','2017-09-27 16:52:26',NULL),(4,3,'/mounts/mms_nfs1_q1','927332','2017-09-27 16:52:26',NULL),(5,3,'/mounts/mms_nfs1_multiqtree','927331','2017-09-27 16:52:26',NULL),(6,3,'/mounts/mms_nfs2_multiowner','927330','2017-09-27 16:52:26',NULL),(7,3,'/mounts/pr_drqsm_pr_crqsv_one_qtree','927329','2017-09-27 16:52:26',NULL),(8,3,'/mounts/mms_pr_drvsm_crqsv_no_qtree','927328','2017-09-27 16:52:26',NULL),(9,3,'/mounts/pr_crqsv_multi_qtree','927327','2017-09-27 16:52:26',NULL),(10,3,'/mounts/pr_drvsm_one_qtree','927326','2017-09-27 16:52:26',NULL),(11,3,'/mounts/pr_only_multi_qtree','927325','2017-09-27 16:52:26',NULL),(12,3,'/mounts/pr_only_one_qtree','927324','2017-09-27 16:52:26',NULL),(13,3,'/mounts/mms_pr_only_no_qtree','927323','2017-09-27 16:52:26',NULL);
/*!40000 ALTER TABLE `mount_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_email_type`
--

DROP TABLE IF EXISTS `mst_email_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_email_type` (
  `id` int(11) NOT NULL COMMENT 'Surrogate ID of the MST e-mail Type',
  `email_type` varchar(45) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_email_type`
--

LOCK TABLES `mst_email_type` WRITE;
/*!40000 ALTER TABLE `mst_email_type` DISABLE KEYS */;
INSERT INTO `mst_email_type` VALUES (1,'AppOwner','2017-09-27 16:52:27',NULL),(2,'ServerAdmin','2017-09-27 16:52:27',NULL),(3,'NAS Engineer','2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `mst_email_type` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`email_type_id`),
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
  `qtree_tally` int(11) NOT NULL DEFAULT '0',
  `snap_tally` int(11) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`aggregate_id`,`controlled_id`),
  KEY `vol_name_idx` (`vserver`,`volume_name`),
  KEY `volume_controller_idx` (`controlled_id`),
  KEY `volume_aggregate` (`aggregate_id`),
  CONSTRAINT `fk_volume_aggregate1` FOREIGN KEY (`aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_volume_controller1` FOREIGN KEY (`controlled_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nas_volume`
--

LOCK TABLES `nas_volume` WRITE;
/*!40000 ALTER TABLE `nas_volume` DISABLE KEYS */;
INSERT INTO `nas_volume` VALUES (311,1,23,'fspodrtp03-n01','vol0',467,467,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,25,127,1,8,'2017-09-27 16:52:27',NULL),(312,2,26,'fspodrtp03-n02','vol0',348,348,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,21,73,1,8,'2017-09-27 16:52:27',NULL),(313,1,25,'fspodrtp03d','fspodrtp03d_root',1,1,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,1,10,'2017-09-27 16:52:27',NULL),(314,1,24,'fspodrtp03p','fspodrtp03p_root',1,1,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,1,10,'2017-09-27 16:52:27',NULL),(315,3,29,'fspodrtp04-n01','vol0',903,903,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,27,165,1,8,'2017-09-27 16:52:27',NULL),(316,4,32,'fspodrtp04-n02','vol0',677,677,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,19,136,1,8,'2017-09-27 16:52:27',NULL),(317,3,31,'fspodrtp04d','fspodrtp04d_root',1,1,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,1,10,'2017-09-27 16:52:27',NULL),(318,3,30,'fspodrtp04p','fspodrtp04p_root',1,1,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,1,10,'2017-09-27 16:52:27',NULL),(569,409,414,'vfiler0','Dan_test',0,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(570,409,414,'vfiler0','ExelonPSVol1',2,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(571,409,414,'vfiler0','ExelonPSVol2',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(572,409,414,'vfiler0','ExelonPSVol3',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(573,409,414,'vfiler0','Julie_online_stg1',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,2,2,'2017-09-27 16:52:27',NULL),(574,409,414,'vfiler0','WFA_Chris1',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,10,'2017-09-27 16:52:27',NULL),(575,409,414,'vfiler0','WFA_Chris2',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(576,409,414,'vfiler0','WFA_Chris3',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(577,409,414,'vfiler0','WFA_Drew1',1,1,'FlexClone',577,658,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(578,409,414,'vfiler0','WFA_Drew2',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(579,409,414,'vfiler0','WFA_Drew3',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(580,409,414,'vfiler0','WFA_Julie1',1,1,'FlexClone',580,659,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,10,'2017-09-27 16:52:27',NULL),(581,409,414,'vfiler0','WFA_Julie2',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(582,409,414,'vfiler0','WFA_Julie3',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(583,409,414,'vfiler0','WFA_Ron1',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(584,409,414,'vfiler0','WFA_Ron2',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(585,409,414,'vfiler0','WFA_Ron2_stg1',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,2,2,'2017-09-27 16:52:27',NULL),(586,409,414,'vfiler0','WFA_Ron3',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(587,409,414,'vfiler0','WFA_Zach1',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(588,409,414,'vfiler0','WFA_Zach2',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(589,409,414,'vfiler0','WFA_Zach3',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(590,409,414,'vfiler0','WFA_vol_Chris_Multi',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,4,8,'2017-09-27 16:52:27',NULL),(591,409,414,'vfiler0','WFA_vol_Drew_Multi',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,5,8,'2017-09-27 16:52:27',NULL),(592,409,414,'vfiler0','WFA_vol_Julie_Multi',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,4,8,'2017-09-27 16:52:27',NULL),(593,409,414,'vfiler0','WFA_vol_Ron_Multi',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,4,8,'2017-09-27 16:52:27',NULL),(594,409,414,'vfiler0','WFA_vol_Zach_Multi',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,4,8,'2017-09-27 16:52:27',NULL),(595,409,414,'amgen','amgen',10,10,NULL,NULL,NULL,NULL,'online','2017-04-15 13:08:41','DiscoverOwner','No Rules Matched',0,1,1,10,'2017-09-27 16:52:27',NULL),(596,409,414,'vfiler0','amgenSM3',2,2,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,10,'2017-09-27 16:52:27',NULL),(597,409,413,'amgen','amgentest2',2,2,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,4,12,'2017-09-27 16:52:27',NULL),(598,409,414,'amgen','amgentestSM',4,4,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,4,14,'2017-09-27 16:52:27',NULL),(599,409,414,'amgen','amgentestSV',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,52,'2017-09-27 16:52:27',NULL),(600,409,414,'vfiler0','av_test',25,12,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(601,409,414,'vfiler0','cbauernf_sv_dst',0,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,2,9,'2017-09-27 16:52:27',NULL),(602,409,414,'vfiler0','cbauernf_sv_src',0,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,3,17,'2017-09-27 16:52:27',NULL),(603,409,414,'cbauernf_vf','cbauernf_vf',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(604,409,414,'cbauernf_vf','cbauernf_xcp',10,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(605,409,414,'vfiler0','cbquota',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(606,409,414,'vfiler0','change_aggr',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,10,'2017-09-27 16:52:27',NULL),(607,409,414,'vfiler0','charlie',0,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(608,409,414,'vfiler0','cifstest',22,13,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,1,8,'2017-09-27 16:52:27',NULL),(609,409,414,'vfiler0','drew',12,12,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,0,'2017-09-27 16:52:27',NULL),(610,409,414,'vfiler0','drew4_stg1',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,2,2,'2017-09-27 16:52:27',NULL),(611,409,414,'vf_drew_lab','drew_NFS',5,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,0,'2017-09-27 16:52:27',NULL),(612,409,414,'vf_drew_lab','drew_iscsi',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(613,409,414,'vfiler0','mackenzi_testr',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(614,409,414,'vfiler0','mms_pr_crqsv_multi_qtree',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',2,5,3,15,'2017-09-27 16:52:27',NULL),(615,409,414,'vfiler0','mms_pr_drqsm_pr_crqsv_one_qtree',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,1,2,16,'2017-09-27 16:52:27',NULL),(616,409,414,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro',1,0,'SnapMirror',616,644,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',1,3,2,17,'2017-09-27 16:52:27',NULL),(617,409,414,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw',1,0,'SnapMirror',617,646,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',1,3,2,17,'2017-09-27 16:52:27',NULL),(618,409,414,'vfiler0','mms_pr_drvsm_crqsv_no_qtree',1,0,'SnapMirror',618,648,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',1,3,1,17,'2017-09-27 16:52:27',NULL),(619,409,414,'vfiler0','mms_pr_drvsm_one_qtree',1,0,'SnapMirror',619,650,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,2,9,'2017-09-27 16:52:27',NULL),(620,409,414,'vfiler0','mms_pr_drvsm_pr_crqsv_multi_qtree',1,0,'SnapMirror',620,651,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,3,16,'2017-09-27 16:52:27',NULL),(621,409,414,'vFilerMMS','mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms',1,1,'SnapMirror',621,653,NULL,'online','2017-04-26 08:20:19','DiscoverOwner','No Rules Matched',0,178,2,19,'2017-09-27 16:52:27',NULL),(622,409,414,'vfiler0','mms_pr_only_multi_qtree',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,3,9,'2017-09-27 16:52:27',NULL),(623,409,414,'vfiler0','mms_pr_only_no_qtree',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',1,2,1,8,'2017-09-27 16:52:27',NULL),(624,409,414,'vfiler0','mms_pr_only_one_qtree',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,2,8,'2017-09-27 16:52:27',NULL),(625,409,413,'amgen','nocifs',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(626,409,414,'vfiler0','robocopy',10,10,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,3,8,'2017-09-27 16:52:27',NULL),(627,409,413,'vfiler0','shahul_cdot_wfa_stg1',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,2,2,'2017-09-27 16:52:27',NULL),(628,409,414,'vfiler0','shahul_wfa2_stg1',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,2,2,'2017-09-27 16:52:27',NULL),(629,409,414,'vfiler0','shahul_wfavol',7,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,11,'2017-09-27 16:52:27',NULL),(630,409,414,'vfiler0','sxvoltest',10,8,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,1,8,'2017-09-27 16:52:27',NULL),(631,409,414,'vFilerMMS','vFilerMMS_root',2,2,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,2,1,8,'2017-09-27 16:52:27',NULL),(632,409,414,'vf_drew_lab','vf_drew_lab_ISCSI_Linux1',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(633,409,414,'vf_drew_lab','vf_drew_lab_ISCSI_Linux2',10,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(634,409,414,'vf_drew_lab','vf_drew_lab_NFS',30,18,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,16,'2017-09-27 16:52:27',NULL),(635,409,414,'vf_drew_lab','vf_drew_lab_root',0,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(636,409,413,'vfiler0','vol0',229,229,NULL,NULL,NULL,NULL,'online','2017-04-15 13:08:41','NetApp','Netapp System Volume',60,197,1,9,'2017-09-27 16:52:27',NULL),(637,409,414,'vfiler0','vol_07012014_102754',20,20,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(638,409,414,'vfiler0','vol_07012014_130705',15,15,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(639,409,414,'vfiler0','volume1',10,10,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,8,'2017-09-27 16:52:27',NULL),(640,409,414,'vf_zach_lab','zach_lab_vol',10,10,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,2,8,'2017-09-27 16:52:27',NULL),(641,410,416,'vfiler0','mms_pr_crqsv_multi_qtree_cr',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,4,3,31,'2017-09-27 16:52:27',NULL),(642,410,416,'vfiler0','mms_pr_drqsm_pr_crqsv_one_qtree',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,1,2,9,'2017-09-27 16:52:27',NULL),(643,410,416,'vfiler0','mms_pr_drqsm_pr_crqsv_one_qtree_cr',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,3,2,31,'2017-09-27 16:52:27',NULL),(644,410,416,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',1,3,2,18,'2017-09-27 16:52:27',NULL),(646,410,416,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',1,3,2,18,'2017-09-27 16:52:27',NULL),(648,410,416,'vfiler0','mms_pr_drvsm_crqsv_no_qtree',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',1,3,1,18,'2017-09-27 16:52:27',NULL),(650,410,416,'vfiler0','mms_pr_drvsm_one_qtree',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,0,2,10,'2017-09-27 16:52:27',NULL),(651,410,416,'vfiler0','mms_pr_drvsm_pr_crqsv_multi_qtree',1,1,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,0,3,17,'2017-09-27 16:52:27',NULL),(652,410,416,'vfiler0','mms_pr_drvsm_pr_crqsv_multi_qtree_cr',1,0,NULL,NULL,NULL,NULL,'online',NULL,'CIFS-Only','CIFS Only- Orphan identify not defined',0,0,3,31,'2017-09-27 16:52:27',NULL),(653,410,416,'vfiler1','mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,178,2,20,'2017-09-27 16:52:27',NULL),(654,410,416,'vFiler2','mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms_cr',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,3,40,'2017-09-27 16:52:27',NULL),(655,410,416,'vfiler1','vfiler1_root',2,2,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,2,1,8,'2017-09-27 16:52:27',NULL),(656,410,416,'vFiler2','vfiler2_root',2,2,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,2,1,8,'2017-09-27 16:52:27',NULL),(657,410,415,'vfiler0','vol0',353,353,NULL,NULL,NULL,NULL,'online',NULL,'NetApp','Netapp System Volume',60,197,1,8,'2017-09-27 16:52:27',NULL),(658,409,414,'vfiler0','WFA_Drew1_clone1',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(659,409,414,'vfiler0','WFA_Julie1_clone1',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(660,409,414,'vfiler0','WFA_Julie1_clone2',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan','ACL- Meets customer\'s NFS ACL Orphan rule',0,0,1,9,'2017-09-27 16:52:27',NULL),(1702,409,414,'vfiler0','win2k12NFS',1,0,NULL,NULL,NULL,NULL,'online','2017-05-04 15:03:05','DiscoverOwner','No Rules Matched',0,0,1,8,'2017-09-27 16:52:27',NULL),(1749,409,414,'vFilerMMS','vfilerMMS_vol',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,1,8,'2017-09-27 16:52:27',NULL),(1750,409,414,'vfiler0','vol_parker_mms_1qtree_novfiler',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,2,8,'2017-09-27 16:52:27',NULL),(1751,409,414,'vFilerMMS','vol_parker_mms_1qtree_vfiler',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,2,8,'2017-09-27 16:52:27',NULL),(1752,409,414,'vfiler0','vol_parker_mms_2qtree_novfiler',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,3,8,'2017-09-27 16:52:27',NULL),(1753,409,414,'vfiler0','vol_parker_mms_noqtree_novfiler',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,1,8,'2017-09-27 16:52:27',NULL),(1754,409,414,'vFilerMMS','vol_parker_mms_noqtree_vfiler',1,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,1,8,'2017-09-27 16:52:27',NULL),(1836,1,25,'fspodrtp03p','fspodrtp03p_a_b_b_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,0,'2017-09-27 16:52:27',NULL),(1887,1,25,'fspodrtp03p','fspodrtp03p_mms_parker_b100_prd',2,0,'SnapMirror',1887,1888,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,26,'2017-09-27 16:52:27',NULL),(1888,3,31,'fspodrtp04p','fspodrtp03p_mms_parker_b100_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1889,3,30,'fspodrtp04p','fspodrtp03p_mms_sample_prcr001_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1890,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prcr001_prd',2,0,'SnapVault',1890,1889,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,26,'2017-09-27 16:52:27',NULL),(1891,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr001_prd',2,0,'SnapVault',1891,1892,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1892,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr001_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1893,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr001_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1894,409,414,'vfiler0','mms_parker_nfs_100',1,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,0,2,0,'2017-09-27 16:52:27',NULL),(1895,1,25,'fspodrtp03p','fspodrtp03p_mms_parker_nfs101_prd',1,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,0,'2017-09-27 16:52:27',NULL),(1896,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_pr001_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,0,'2017-09-27 16:52:27',NULL),(1897,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr006_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1898,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr006_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1899,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr006_prd',2,0,'SnapVault',1899,1897,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1900,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr108_prd',2,0,'SnapVault',1900,1904,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1901,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr110_prd',2,0,'SnapVault',1901,1905,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1902,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr111_prd',2,0,'SnapVault',1902,1906,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1903,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr112_prd',2,0,'SnapVault',1903,1907,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,27,'2017-09-27 16:52:27',NULL),(1904,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr108_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1905,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr110_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1906,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr111_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1907,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr112_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1908,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr108_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1909,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr110_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1910,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr111_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1911,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr112_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,28,'2017-09-27 16:52:27',NULL),(1912,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr113_prd',2,0,'SnapVault',1912,1916,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,26,'2017-09-27 16:52:27',NULL),(1913,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr114_prd',2,0,'SnapVault',1913,1917,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,26,'2017-09-27 16:52:27',NULL),(1914,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr115_prd',2,0,'SnapVault',1914,1918,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,26,'2017-09-27 16:52:27',NULL),(1915,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr118_prd',2,0,'SnapVault',1915,1919,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,25,'2017-09-27 16:52:27',NULL),(1916,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr113_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1917,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr114_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1918,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr115_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1919,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr118_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(1920,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr120_prd',2,0,'SnapVault',1920,1921,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,25,'2017-09-27 16:52:27',NULL),(1921,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr120_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2280,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr124_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2281,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr124_prd',2,0,'SnapVault',2281,2280,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,25,'2017-09-27 16:52:27',NULL),(2282,1,25,'fspodrtp03p','fspodrtp03p_mmstest_parker_pronly_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,0,'2017-09-27 16:52:27',NULL),(2498,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr206_prd',2,0,'SnapMirror',2498,2499,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2499,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr206_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,17,'2017-09-27 16:52:27',NULL),(2500,1,25,'fspodrtp03p','fspodrtp03p_mms_sample_parker0r01_prd',2,0,'SnapVault',2500,2501,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2501,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_parker0r01_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2502,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr206_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2503,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_parker0r01_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,17,'2017-09-27 16:52:27',NULL),(2504,2,28,'fspodrtp03p','fspodrtp03p_mms_sample_prdrcr207_prd',2,0,'SnapVault',2504,2505,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2505,3,30,'fspodrtp04d','fspodrtp03p_mms_sample_prdrcr207_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2506,3,31,'fspodrtp04p','fspodrtp03p_mms_sample_prdrcr207_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,17,'2017-09-27 16:52:27',NULL),(2609,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr212_prd',2,0,'SnapMirror',2609,2615,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2610,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_prdrcr218_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2611,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr213_prd',2,0,'SnapMirror',2611,2616,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2612,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr214_prd',2,0,'SnapMirror',2612,2617,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2613,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr215_prd',2,0,'SnapMirror',2613,2618,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2614,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr218_prd',2,0,'SnapVault',2614,2610,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2615,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr212_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2616,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr213_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2617,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr214_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2618,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr215_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2619,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr218_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2722,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr239_prd',2,0,'SnapVault',2722,2723,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2723,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_prdrcr239_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2724,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr239_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2725,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_prdrcr243_prd',2,0,'SnapVault',2725,2726,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2726,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_prdrcr243_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2727,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_prdrcr243_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,16,'2017-09-27 16:52:27',NULL),(2728,409,414,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro_cr',5,0,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,1,2,31,'2017-09-27 16:52:27',NULL),(2729,409,414,'vfiler0','mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw_cr',5,1,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,1,2,28,'2017-09-27 16:52:27',NULL),(2730,409,414,'vfiler0','mms_pr_drvsm_crqsv_no_qtree_cr',5,5,NULL,NULL,NULL,NULL,'online',NULL,'NFS-Orphan w/CIFS','ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares',0,1,2,28,'2017-09-27 16:52:27',NULL),(2842,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_payr107_prd',2,0,'SnapVault',2842,2843,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2843,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_payr107_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2844,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_payr107_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2845,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_payr101_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2846,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_payr101_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2847,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_payr101_prd',2,0,'SnapVault',2847,2845,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2848,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay201_prd',2,0,'SnapVault',2848,2849,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2849,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay201_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2850,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay201_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,15,'2017-09-27 16:52:27',NULL),(2953,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay209_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2954,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay209_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2955,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay209_prd',2,0,'SnapVault',2955,2953,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,13,'2017-09-27 16:52:27',NULL),(2956,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay210_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2957,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay210_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2958,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay210_prd',2,0,'SnapVault',2958,2956,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,13,'2017-09-27 16:52:27',NULL),(2959,2,27,'fspodrtp03p','fspodrtp03p_parker_sub_test222_prd',1,0,'SnapVault',2959,2960,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,13,'2017-09-27 16:52:27',NULL),(2960,3,30,'fspodrtp04d','fspodrtp03p_parker_sub_test222_prd',1,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2961,3,31,'fspodrtp04p','fspodrtp03p_parker_sub_test222_prd',1,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2962,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay302_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(2963,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay302_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,14,'2017-09-27 16:52:27',NULL),(2964,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay302_prd',2,0,'SnapVault',2964,2962,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,13,'2017-09-27 16:52:27',NULL),(3102,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay312_prd',2,0,'SnapVault',3102,3103,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,12,'2017-09-27 16:52:27',NULL),(3103,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay312_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3104,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay312_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,13,'2017-09-27 16:52:27',NULL),(3105,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay323_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3106,3,30,'fspodrtp04p','fspodrtp03p_mms_sub_pay322_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3107,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay323_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,12,'2017-09-27 16:52:27',NULL),(3108,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay322_prd',2,0,'SnapVault',3108,3106,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,10,'2017-09-27 16:52:27',NULL),(3109,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay323_prd',2,0,'SnapVault',3109,3105,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,11,'2017-09-27 16:52:27',NULL),(3110,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay325_prd',2,0,'SnapVault',3110,3113,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,11,'2017-09-27 16:52:27',NULL),(3111,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay326_prd',2,0,'SnapVault',3111,3112,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,11,'2017-09-27 16:52:27',NULL),(3112,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay326_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3113,3,30,'fspodrtp04p','fspodrtp03p_mms_sub_pay325_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3114,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay326_prd',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,12,'2017-09-27 16:52:27',NULL),(3280,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay333_prd',2,0,'SnapVault',3280,3281,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,7,'2017-09-27 16:52:27',NULL),(3281,3,30,'fspodrtp04p','fspodrtp03p_mms_sub_pay333_prd',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3313,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay335_prd_pay335',2,0,'SnapVault',3313,3314,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,6,'2017-09-27 16:52:27',NULL),(3314,3,30,'fspodrtp04p','fspodrtp03p_mms_sub_pay335_prd_pay335',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3348,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay3351001_prd_pay3351001',2,0,'SnapVault',3348,3350,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,6,'2017-09-27 16:52:27',NULL),(3349,2,28,'fspodrtp03p','fspodrtp03p_mms_sub_pay335null_prd_pay335null',2,0,'SnapVault',3349,3352,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,5,'2017-09-27 16:52:27',NULL),(3350,3,30,'fspodrtp04d','fspodrtp03p_mms_sub_pay3351001_prd_pay3351001',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3351,3,31,'fspodrtp04p','fspodrtp03p_mms_sub_pay3351001_prd_pay3351001',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,7,'2017-09-27 16:52:27',NULL),(3352,3,30,'fspodrtp04p','fspodrtp03p_mms_sub_pay335null_prd_pay335null',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,0,0,2,1,'2017-09-27 16:52:27',NULL),(3411,3,30,'fspodrtp04d','fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,NULL,NULL,2,1,'2017-09-27 16:52:27',NULL),(3412,3,30,'fspodrtp04p','fspodrtp03p_mouse_sub_delipeeps1004_prd_delipeeps1004',3,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,NULL,NULL,2,1,'2017-09-27 16:52:27',NULL),(3413,3,31,'fspodrtp04p','fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull',2,0,NULL,NULL,NULL,NULL,'ONLINE',NULL,NULL,NULL,NULL,NULL,2,4,'2017-09-27 16:52:27',NULL),(3414,2,28,'fspodrtp03p','fspodrtp03p_mouse_sub_delipeeps1004_prd_delipeeps1004',2,0,'SnapVault',3414,3412,NULL,'ONLINE',NULL,NULL,NULL,NULL,NULL,2,2,'2017-09-27 16:52:27',NULL),(3415,2,28,'fspodrtp03p','fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull',2,0,'SnapVault',3415,3411,NULL,'ONLINE',NULL,NULL,NULL,NULL,NULL,2,3,'2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `nas_volume` ENABLE KEYS */;
UNLOCK TABLES;

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
  `qtree_status` varchar(225) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`nas_volume_id`),
  KEY `qtreedata_internalVolumeId_idx` (`nas_volume_id`),
  CONSTRAINT `Volume_verb_QTree_fk` FOREIGN KEY (`nas_volume_id`) REFERENCES `nas_volume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qtree`
--

LOCK TABLES `qtree` WRITE;
/*!40000 ALTER TABLE `qtree` DISABLE KEYS */;
INSERT INTO `qtree` VALUES (328,313,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(329,314,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(332,317,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(333,318,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(696,569,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(697,570,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(698,571,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(699,572,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(700,573,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(702,574,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(703,575,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(704,576,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(705,577,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(706,578,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(707,579,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(708,580,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(709,581,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(710,582,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(711,583,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(712,584,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(713,585,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(715,586,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(716,587,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(717,588,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(718,589,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(719,590,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(723,591,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(728,592,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(732,593,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(736,594,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(740,595,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(741,596,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(742,597,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(744,597,'tree1',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(745,597,'tree2',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(746,598,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(750,599,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(751,600,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(752,601,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(754,602,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(757,603,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(758,604,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(759,605,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(760,606,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(762,608,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(764,610,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(768,613,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(770,614,'pr_crqsv_multi_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(771,614,'pr_crqsv_multi_qtree2',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(773,615,'pr_drqsm_pr_crqsv_one_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(775,616,'pr_drvsm_cr_qsv_one_qtree_anon_glob_ro',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(777,617,'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(778,618,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(780,619,'pr_drvsm_one_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(782,620,'pr_drvsm_pr_crqsv_multi_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(783,620,'pr_drvsm_pr_crqsv_multi_qtree2',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(785,621,'pr_drvsm_pr_crqsv_one_qtree_vfilermms',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(787,622,'pr_only_multi_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(788,622,'pr_only_multi_qtree2',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(789,623,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(791,624,'pr_only_one_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(792,625,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(793,626,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(796,627,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(798,628,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(800,629,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(801,630,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(802,631,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(803,632,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(804,633,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(807,636,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(809,638,'-',NULL,NULL,NULL,'DEFAULT','NTFS','normal','2017-09-27 16:52:27',NULL),(811,640,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(812,640,'share1',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(814,641,'pr_crqsv_multi_qtree2_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(815,641,'pr_crqsv_multi_qtree_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(817,642,'pr_drqsm_pr_crqsv_one_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','snapmirrored','2017-09-27 16:52:27',NULL),(819,643,'pr_drqsm_pr_crqsv_one_qtree_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(825,646,'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(832,650,'pr_drvsm_one_qtree',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(835,651,'pr_drvsm_pr_crqsv_multi_qtree2',NULL,NULL,NULL,'EXPLICIT','NTFS','normal','2017-09-27 16:52:27',NULL),(837,652,'pr_drvsm_pr_crqsv_multi_qtree2_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(838,652,'pr_drvsm_pr_crqsv_multi_qtree_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(840,653,'pr_drvsm_pr_crqsv_one_qtree_vfilermms',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(843,654,'pr_drvsm_pr_crqsv_one_qtree_vfilermms_sv',NULL,NULL,NULL,'EXPLICIT','UNIX','snapvaulted','2017-09-27 16:52:27',NULL),(844,655,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(845,656,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(846,657,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(847,658,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(848,659,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(849,660,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1703,1702,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1756,1749,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1757,1750,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1758,1750,'q1',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(1759,1751,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1760,1751,'q1',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(1761,1752,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1762,1752,'q1_vfilerMMS',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(1763,1752,'q2_vfiler0',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(1764,1753,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1765,1754,'-',NULL,NULL,NULL,'DEFAULT','UNIX','normal','2017-09-27 16:52:27',NULL),(1837,1836,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1952,1888,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1954,1889,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1956,1890,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1958,1891,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1960,1892,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1962,1893,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1965,1894,'parker_nfs_100',NULL,NULL,NULL,'EXPLICIT','UNIX','normal','2017-09-27 16:52:27',NULL),(1966,1895,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1968,1896,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1970,1897,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1972,1898,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1974,1899,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1976,1900,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1978,1901,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1980,1902,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1982,1903,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(1984,1904,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1986,1905,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1988,1906,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1990,1907,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1992,1908,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1994,1909,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1996,1910,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(1998,1911,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2000,1912,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2002,1913,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2004,1914,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2006,1915,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2008,1916,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2010,1917,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2012,1918,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2014,1919,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2016,1920,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2018,1921,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2283,2280,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2285,2281,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2287,2282,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2288,2282,'mmstest_parker_pronly_prd',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2513,2498,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2515,2499,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2516,2500,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2518,2501,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2520,2502,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2522,2503,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2525,2504,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2527,2505,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2529,2506,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2624,2610,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2625,2609,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2628,2611,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2630,2612,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2632,2613,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2634,2614,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2636,2615,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2638,2616,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2640,2617,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2642,2618,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2644,2619,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2737,2722,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2739,2723,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2741,2724,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2743,2725,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2745,2726,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2747,2727,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2750,2728,'pr_drvsm_cr_qsv_one_qtree_anon_glob_ro_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(2752,2729,'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(2754,2730,'pr_drvsm_crqsv_no_qtree_sv',NULL,NULL,NULL,'EXPLICIT','NTFS','snapvaulted','2017-09-27 16:52:27',NULL),(2857,2842,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2858,2842,'mms_sub_payr107_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2859,2843,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2861,2844,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2863,2845,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2865,2846,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2867,2847,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2868,2847,'mms_sub_payr101_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2968,2953,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2970,2954,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2972,2955,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2973,2955,'mms_sub_pay209_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2974,2956,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2976,2957,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2978,2958,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2979,2958,'mms_sub_pay210_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2980,2959,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2981,2959,'parker_sub_test222_prd',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(2982,2960,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2984,2961,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(2986,2962,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2988,2963,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(2990,2964,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(2991,2964,'mms_sub_pay302_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3117,3102,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3118,3102,'mms_sub_pay312_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3119,3103,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3121,3104,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3123,3105,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3125,3106,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3127,3107,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3129,3108,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3130,3108,'mms_sub_pay322_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3131,3109,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3132,3109,'mms_sub_pay323_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3133,3110,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3134,3110,'mms_sub_pay325_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3135,3111,'-',NULL,NULL,NULL,'DEFAULT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3136,3111,'mms_sub_pay326_prd',NULL,NULL,NULL,'EXPLICIT','NTFS','NORMAL','2017-09-27 16:52:27',NULL),(3137,3112,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3139,3113,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3141,3114,'-',NULL,NULL,NULL,'DEFAULT','NTFS','READONLY','2017-09-27 16:52:27',NULL),(3283,3280,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3284,3280,'mms_sub_pay333_prd',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3285,3281,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(3316,3313,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3317,3313,'mms_sub_pay335_prd_pay335',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3318,3314,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(3357,3349,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3358,3349,'mms_sub_pay335null_prd_pay335null',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3363,3352,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(3420,3412,'-',NULL,NULL,NULL,'DEFAULT','UNIX','READONLY','2017-09-27 16:52:27',NULL),(3424,3414,'-',NULL,NULL,NULL,'DEFAULT','UNIX','NORMAL','2017-09-27 16:52:27',NULL),(3425,3414,'mouse_sub_delipeeps1004_prd_delipeeps1004',NULL,NULL,NULL,'EXPLICIT','UNIX','NORMAL','2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `qtree` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`migration_cutover_src_to_tgt_id`),
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
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2017-01-02','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(2,'2017-01-09','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(3,'2017-01-16','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(4,'2017-01-23','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(5,'2017-01-30','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(6,'2017-02-06','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(7,'2017-02-13','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(8,'2017-02-20','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(9,'2017-02-27','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(10,'2017-03-06','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(11,'2017-03-13','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(12,'2017-03-20','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(13,'2017-03-27','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(14,'2017-04-03','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(15,'2017-04-10','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(16,'2017-04-17','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(17,'2017-04-24','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(18,'2017-05-01','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(19,'2017-05-08','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(20,'2017-05-15','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(21,'2017-05-22','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(22,'2017-05-29','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(23,'2017-06-05','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(24,'2017-06-12','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(25,'2017-06-19','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(26,'2017-06-26','Closed',30,0,30,1000,4,0,'2017-09-27 16:52:27',NULL),(27,'2017-07-03','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(28,'2017-07-10','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(29,'2017-07-17','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(30,'2017-07-24','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(31,'2017-07-31','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(32,'2017-08-07','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(33,'2017-08-14','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(34,'2017-08-21','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(35,'2017-08-28','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(36,'2017-09-04','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(37,'2017-09-11','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(38,'2017-09-18','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(39,'2017-09-25','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(40,'2017-10-02','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(41,'2017-10-09','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(42,'2017-10-16','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(43,'2017-10-23','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(44,'2017-10-30','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(45,'2017-11-06','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(46,'2017-11-13','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(47,'2017-11-20','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(48,'2017-11-27','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(49,'2017-12-04','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(50,'2017-12-11','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(51,'2017-12-18','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(52,'2017-12-25','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL),(53,'2018-01-01','Open',30,0,0,1000,0,0,'2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`host_id`,`id`),
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
  `work_package_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `storage_name_idx` (`storage_name`),
  KEY `fk_storage_work_package1_idx` (`work_package_id`),
  CONSTRAINT `fk_storage_work_package1` FOREIGN KEY (`work_package_id`) REFERENCES `work_package` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (17,'fspodrtp03.rdc.lab','FAS3270','FAS3200','NetApp','8.2.4P1 clustered Data ONTAP',48535982,0,'2017-09-27 16:52:27',NULL),(18,'fspodrtp04.rdc.lab','FAS3270','FAS3200','NetApp','8.3.1P1 clustered Data ONTAP',102302404,0,'2017-09-27 16:52:27',NULL),(41,'7GN1-RTPRDC,7GN2-RTPRDC','FAS3140','FAS3100','NetApp','8.2.4P6 7-Mode',17782053,0,'2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
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
  PRIMARY KEY (`id`,`user_corporate_id`),
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
  `id` int(11) NOT NULL COMMENT 'Surrogate ID of the User API',
  `secret` varchar(45) DEFAULT NULL,
  `key` varchar(45) DEFAULT NULL,
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
  `costCenter` varchar(100) DEFAULT NULL,
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
-- Dumping data for table `user_corporate`
--

LOCK TABLES `user_corporate` WRITE;
/*!40000 ALTER TABLE `user_corporate` DISABLE KEYS */;
INSERT INTO `user_corporate` VALUES (1,'Z999998','Unknown','Orphan',NULL,'UNKNOWN','unknown@example.com','0',NULL,NULL,NULL,NULL,NULL,2,'2017-09-27 16:52:27',NULL),(2,'A011234','Scooter','Wipperman','','Supreme Ruler','Scooter.Wipperman@jpmchase.com','9193457892','9192224567',NULL,'123456',NULL,NULL,2,'2017-09-27 16:52:27',NULL),(6,'F591154','Lew','Newby','','King of Prussia','lew.newby@jpmchase.com','9192341782','9191111234',NULL,'123456',NULL,NULL,2,'2017-09-27 16:52:27',NULL),(7,'Z000000','TestLiqibase','TestLiqibase','','','TestLiqibase\n@jpmc.com','888-888-8888','888-888-8889','','999999','','',2,'2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `user_corporate` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `user_role_id_idx` (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_native`
--

LOCK TABLES `user_native` WRITE;
/*!40000 ALTER TABLE `user_native` DISABLE KEYS */;
INSERT INTO `user_native` VALUES (1,NULL,NULL,'user','Lewis.Newby@netapp.com','0b0ca20ecc3ccf30182fce9ffbd46df6',NULL,1,1,'2017-09-27 16:52:27',NULL),(2,NULL,NULL,'admin','Lewis.Newby@netapp.com','0b0ca20ecc3ccf30182fce9ffbd46df6',NULL,1,2,'2017-09-27 16:52:27',NULL),(3,NULL,NULL,'ruser','Lewis.Newby@netapp.com','0b0ca20ecc3ccf30182fce9ffbd46df6',NULL,1,3,'2017-09-27 16:52:27',NULL),(4,NULL,NULL,'superuser','Lewis.Newby@netapp.com','0b0ca20ecc3ccf30182fce9ffbd46df6',NULL,1,4,'2017-09-27 16:52:27',NULL),(5,NULL,NULL,'mslead','Lewis.Newby@netapp.com','0b0ca20ecc3ccf30182fce9ffbd46df6',NULL,1,5,'2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `user_native` ENABLE KEYS */;
UNLOCK TABLES;

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
  UNIQUE KEY `id_UNIQUE` (`id`),
  CONSTRAINT `fk_user_roles_user_native1` FOREIGN KEY (`id`) REFERENCES `user_native` (`user_role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'ROLE_USER','2017-09-27 16:52:27',NULL),(2,'ROLE_ADMIN','2017-09-27 16:52:27',NULL),(3,'ROLE_RUSER','2017-09-27 16:52:27',NULL),(4,'ROLE_SUPERUSER','2017-09-27 16:52:27',NULL),(5,'ROLE_MSLEAD','2017-09-27 16:52:27',NULL);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

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
  `migrationTarget` tinyint(1) DEFAULT '1',
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
  PRIMARY KEY (`id`,`workflow_id`),
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
  PRIMARY KEY (`id`,`workflow_id`),
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
-- Table structure for table `work_package`
--

DROP TABLE IF EXISTS `work_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Work Package',
  `work_package_name` varchar(255) NOT NULL,
  `asset_number` varchar(60) DEFAULT NULL,
  `controller_installed_date` date NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `processed` tinyint(1) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_package`
--

LOCK TABLES `work_package` WRITE;
/*!40000 ALTER TABLE `work_package` DISABLE KEYS */;
INSERT INTO `work_package` VALUES (1,'QA1','Z00000','1999-01-24',1,1,'2017-09-27 16:52:28',NULL),(2,'QA1','Z00000','1999-01-24',1,1,'2017-09-27 16:52:28',NULL);
/*!40000 ALTER TABLE `work_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Workflow',
  `migration_cutover_src_to_tgt_id` int(11) NOT NULL,
  `migration_cutover_src_to_tgt_migration_cutover_event_id` int(11) NOT NULL,
  `wfa_uuid` varchar(255) DEFAULT NULL,
  `wfa_job_id` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `error_code` varchar(60) DEFAULT NULL,
  `error_description` varchar(128) DEFAULT NULL,
  `job_type` varchar(255) DEFAULT NULL,
  `workflow_status` varchar(60) NOT NULL DEFAULT 'Submitting',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`migration_cutover_src_to_tgt_id`,`migration_cutover_src_to_tgt_migration_cutover_event_id`),
  UNIQUE KEY `wfa_job_id_idx` (`wfa_job_id`),
  KEY `fk_workflow_migration_cutover_src_to_tgt1_idx` (`migration_cutover_src_to_tgt_id`,`migration_cutover_src_to_tgt_migration_cutover_event_id`),
  CONSTRAINT `fk_workflow_migration_cutover_src_to_tgt1` FOREIGN KEY (`migration_cutover_src_to_tgt_id`, `migration_cutover_src_to_tgt_migration_cutover_event_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`, `migration_cutover_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vitae_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `vitae_update`()
BEGIN
INSERT INTO vitae_data.datacenter
	(name,region,create_date,creation_user)
	SELECT DISTINCT 
		dwh_inventory.storage.datacenter,
		dwh_inventory.storage.Region,
		NOW(),
		'system'
		
	FROM dwh_inventory.storage
	
	ON DUPLICATE KEY UPDATE 
        last_upd_dt=NOW(),
        last_upd_user='system';

INSERT INTO vitae_data.storage 
	(id,name,model,family,manufacturer,serialNumber,microcodeVersion,rawCapacityMB,datacenter,region,create_date,creation_user)
	
    SELECT 
		dwh_inventory.storage.id,
		dwh_inventory.storage.name,
		dwh_inventory.storage.model,
		dwh_inventory.storage.family,
		dwh_inventory.storage.manufacturer,
		dwh_inventory.storage.serialNumber,
		dwh_inventory.storage.microcodeVersion,
		dwh_inventory.storage.rawCapacityMB,
		dwh_inventory.storage.datacenter,
		dwh_inventory.storage.region,
		NOW(),
		'system'
    
    FROM dwh_inventory.storage
    
    ON DUPLICATE KEY UPDATE 
    	name=VALUES(name),
    	model=VALUES(model),
    	family=VALUES(family),
    	manufacturer = VALUES(manufacturer),
    	serialNumber= VALUES(serialNumber),
    	microcodeVersion = VALUES(microcodeVersion),
    	rawCapacityMB =VALUES(rawCapacityMB),
    	datacenter = VALUES(datacenter),
    	region = VALUES(region),
        last_upd_dt=NOW(),
        last_upd_user='system'
;	
	
INSERT INTO `vitae_data`.`controller` 
	(id, controllerName,serialNumber, storageId, storageName, model, datacenter, dateAvail, volumeCount,create_date,creation_user)
    SELECT 
		dwh_inventory.storage_node.id,
        dwh_inventory.storage_node.name,
        dwh_inventory.storage_node.serialNumber,
        dwh_inventory.storage_node.storageId,
        dwh_inventory.storage.name,        
        dwh_inventory.storage_node.model,
        dwh_inventory.storage.dataCenter,
        DATE(NOW()),
        COUNT(DISTINCT dwh_inventory.internal_volume.id),
        NOW(),
        'system'
	FROM dwh_inventory.storage_node
    
    JOIN dwh_inventory.storage
		ON dwh_inventory.storage.id = dwh_inventory.storage_node.storageId
        
	JOIN dwh_inventory.storage_node_to_internal_volume
		ON dwh_inventory.storage_node.id = dwh_inventory.storage_node_to_internal_volume.storageNodeId
	
    JOIN dwh_inventory.internal_volume
		ON dwh_inventory.storage_node_to_internal_volume.internalVolumeId = dwh_inventory.internal_volume.id
	
    
    GROUP BY dwh_inventory.storage_node.id
    
    ON DUPLICATE KEY UPDATE 
    	controllerName = VALUES(controllerName),
        serialNumber = VALUES(serialNumber),
        storageId = VALUES(storageId),
        storageName = VALUES(storageName),
        model = VALUES(model),
        datacenter = VALUES(datacenter),
        last_upd_dt=NOW(),
        last_upd_user='system'
 ;
 
 INSERT INTO vitae_data.aggregate
	(id, name, storage_id, size, isHybrid, type, controller_id, poolAllocatedCapMB, poolUsedCapMB, poolIopsCapability, avgIOpS, peakIOpS, create_date,creation_user)
    SELECT 
		dwh_inventory.storage_pool.id,
		IF (dwh_inventory.storage_pool.name LIKE '%:%',
			SUBSTRING_INDEX(dwh_inventory.storage_pool.name,':',-1),
			dwh_inventory.storage_pool.name),
		dwh_inventory.storage_pool.storageId,
		dwh_inventory.storage_pool.totalAllocatedCapacityMB,
		dwh_inventory.storage_pool.usesFlashPools,
		dwh_inventory.storage_pool.type,
		dwh_inventory.storage_node_to_storage_pool.storageNodeId,
        dwh_inventory.wcr_pool_combined_data.poolAllocatedCapMB,
        dwh_inventory.wcr_pool_combined_data.poolUsedCapMB,
        dwh_inventory.wcr_pool_combined_data.poolIopsCapability,
        dwh_inventory.wcr_pool_combined_data.avgIOpS,
        dwh_inventory.wcr_pool_combined_data.maxIOpS,
        NOW(),
        'system'
    
	FROM dwh_inventory.storage_pool

	JOIN dwh_inventory.storage_node_to_storage_pool
		ON dwh_inventory.storage_pool.id = dwh_inventory.storage_node_to_storage_pool.storagePoolId
        
	LEFT JOIN dwh_inventory.wcr_pool_combined_data
		ON dwh_inventory.storage_pool.id = dwh_inventory.wcr_pool_combined_data.storagePoolId
	
	ON DUPLICATE KEY UPDATE 
		name = VALUES(name),
		storage_id = VALUES(storage_id),
		size = VALUES(size),
		poolAllocatedCapMB = VALUES(poolAllocatedCapMB), 
        poolUsedCapMB = VALUES(poolUsedCapMB), 
        poolIopsCapability = VALUES(poolIopsCapability), 
        avgIOpS = VALUES(avgIOpS), 
        peakIOpS = VALUES(peakIOpS),
        last_upd_dt=NOW(),
        last_upd_user='system'
;

INSERT INTO vitae_data.volume
	(intVolId, contId, aggrId, vServer,volName, allocCap, usedCap, snapType, snapSrcVolId, snapTgtVolId, snap_count,
		status, lastAccess, avgIOpS, peakIOpS, create_date,creation_user)
    SELECT
		volSel.intVolId, 
		volSel.contId, 
		volSel.aggrId, 
		volSel.vServer,
        volSel.volName, 
        volSel.allocCap, 
        volSel.usedCap, 
        volSel.snapType, 
        volSel.snapSrcVolId, 
        volSel.snapTgtVolId, 
        volSel.snap_count,
		volSel.status, 
        volSel.lastAccess, 
        volSel.avgIOpS, 
        volSel.peakIOpS, 
        volSel.create_date,
        volSel.creation_user
    FROM 
    (SELECT DISTINCT
		dwh_inventory.internal_volume.id AS 'intVolId',
        dwh_inventory.storage_node_to_storage_pool.storageNodeId AS 'contId',
        dwh_inventory.internal_volume.storagePoolId AS 'aggrId',
        IF (dwh_inventory.internal_volume.virtualStorage IS NULL, 'vFiler0',
			dwh_inventory.internal_volume.virtualStorage) AS 'vServer',
        IF (dwh_inventory.internal_volume.name LIKE '%:%',
			SUBSTRING_INDEX(dwh_inventory.internal_volume.name,':',-1),
			dwh_inventory.internal_volume.name) AS 'volName',
		dwh_inventory.internal_volume.totalAllocatedCapacityMB/1024 AS 'allocCap',
        dwh_inventory.internal_volume.totalUsedCapacityMB/1024 AS 'usedCap',
        dwh_inventory.dr_internal_volume_replica.technology AS 'snapType',
        dwh_inventory.dr_internal_volume_replica.sourceInternalVolumeId AS 'snapSrcVolId',
        dwh_inventory.dr_internal_volume_replica.targetInternalVolumeId AS 'snapTgtVolId',
        dwh_inventory.internal_volume.snapshotCount AS 'snap_count',
        dwh_inventory.internal_volume.status AS 'status',
        MAX(dwh_inventory.wcr_host_conn_view.lastSeen) AS 'lastAccess',
        dwh_inventory.wcr_vol_combined_data.avgIOpS AS 'avgIOpS',
        dwh_inventory.wcr_vol_combined_data.peakIOpS AS 'peakIOpS',
        NOW() AS 'create_date',
        'system' AS 'creation_user'
        
	FROM dwh_inventory.internal_volume
    
	JOIN dwh_inventory.storage_node_to_storage_pool
		ON dwh_inventory.internal_volume.storagePoolId = dwh_inventory.storage_node_to_storage_pool.storagePoolId
        
	LEFT JOIN dwh_inventory.dr_internal_volume_replica
		ON dwh_inventory.internal_volume.id = dwh_inventory.dr_internal_volume_replica.sourceInternalVolumeId
	
    LEFT JOIN dwh_inventory.wcr_host_conn_view
		ON dwh_inventory.internal_volume.id = dwh_inventory.wcr_host_conn_view.intVolId
        
	LEFT JOIN dwh_inventory.wcr_volume_dimension
		ON dwh_inventory.internal_volume.id = dwh_inventory.wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data
		ON dwh_inventory.wcr_volume_dimension.id = dwh_inventory.wcr_vol_combined_data.volDimId
	
    WHERE dwh_inventory.internal_volume.id NOT IN (SELECT targetInternalVolumeId FROM dwh_inventory.dr_internal_volume_replica) 
    
	GROUP BY dwh_inventory.internal_volume.id  ) AS volSel
	
    ON DUPLICATE KEY UPDATE 
		allocCap = VALUES(allocCap),
        usedCap = VALUES(usedCap),
        lastAccess = VALUES(lastAccess),
        avgIOpS = VALUES(avgIOpS),
        peakIOpS = VALUES(peakIOpS),
        last_upd_dt=NOW(),
        last_upd_user='system'
;
         

INSERT INTO vitae_data.host
	(hostname,ipAddress,create_date,creation_user)
	SELECT
        dwh_inventory.wcr_host_conn_view.hostname,
        dwh_inventory.wcr_host_conn_view.ip,
        NOW(),
        'system'
	FROM dwh_inventory.wcr_host_conn_view
    
    ON DUPLICATE KEY UPDATE 
        last_upd_dt=NOW(),
        last_upd_user='system'
;


INSERT INTO vitae_data.share
	(shareId, name, volumeId, shareType, hostId,qtreeId,create_date,creation_user)
    SELECT 
		dwh_inventory.nas_share.id,
		dwh_inventory.nas_share.name,
		dwh_inventory.nas_file_share.internalVolumeId,
		dwh_inventory.nas_share.protocol,
		vitae_data.host.id,
		dwh_inventory.nas_file_share.qtreeId,
        NOW(),
        'system'
    
	FROM dwh_inventory.nas_share
    
	JOIN dwh_inventory.nas_file_share
		ON dwh_inventory.nas_share.fileShareId = dwh_inventory.nas_file_share.id
        
	LEFT JOIN dwh_inventory.wcr_host_conn_view whcv
		ON dwh_inventory.nas_share.id = whcv.shareId 
            
	LEFT JOIN vitae_data.host
		ON whcv.ip = vitae_data.host.ipAddress
        
	ON DUPLICATE KEY UPDATE 
        last_upd_dt=NOW(),
        last_upd_user='system'
;

INSERT INTO vitae_data.qtree
	(id,internalVolumeId,name,quotaHardCapacityLimitMB,quotaSoftCapacityLimitMB,quotaUsedCapacityMB,type,securityStyle,status,create_date,creation_user) 
	
    SELECT dwh_inventory.qtree.id,
		dwh_inventory.qtree.internalVolumeId,
		dwh_inventory.qtree.name,
		dwh_inventory.qtree.quotaHardCapacityLimitMB,
		dwh_inventory.qtree.quotaSoftCapacityLimitMB,
		dwh_inventory.qtree.quotaUsedCapacityMB,
		dwh_inventory.qtree.type,
		dwh_inventory.qtree.securityStyle,
		dwh_inventory.qtree.status,
        NOW(),
        'system'
	FROM dwh_inventory.qtree
	
	JOIN dwh_inventory.nas_file_share
	ON dwh_inventory.nas_file_share.qtreeid = dwh_inventory.qtree.id
    
    JOIN dwh_inventory.nas_share
	ON dwh_inventory.nas_share.fileshareid = dwh_inventory.nas_file_share.id
    
    ON DUPLICATE KEY UPDATE
		quotaHardCapacityLimitMB = VALUES(quotaHardCapacityLimitMB),
        quotaSoftCapacityLimitMB = VALUES(quotaSoftCapacityLimitMB),
		quotaUsedCapacityMB = VALUES(quotaUsedCapacityMB),
        last_upd_dt=NOW(),
        last_upd_user='system'
	;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-21 10:07:29
