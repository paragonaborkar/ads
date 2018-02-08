-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table vitae_data_refactor.activity
DROP TABLE IF EXISTS `activity`;
CREATE TABLE IF NOT EXISTS `activity` (
  `id` int(11) NOT NULL,
  `admin_override` tinyint(4) NOT NULL,
  `app_name_list` varchar(1024) DEFAULT NULL,
  `archive_candidate` tinyint(4) NOT NULL,
  `best_number` varchar(100) DEFAULT NULL,
  `call_me` tinyint(4) NOT NULL,
  `call_reason` varchar(2048) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delete_date` date DEFAULT NULL,
  `disposition` varchar(255) DEFAULT NULL,
  `is_latest` tinyint(4) NOT NULL,
  `mail_count` int(11) DEFAULT NULL,
  `mailing_date` date DEFAULT NULL,
  `migrate_day` int(11) DEFAULT NULL,
  `migrate_week` date DEFAULT NULL,
  `migration_time_id` int(11) DEFAULT NULL,
  `note` varchar(1024) DEFAULT NULL,
  `qtree_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `vserver` varchar(255) DEFAULT NULL,
  `will_delete` tinyint(4) NOT NULL,
  `will_migrate` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.activity: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.activity_lob_x_ref
DROP TABLE IF EXISTS `activity_lob_x_ref`;
CREATE TABLE IF NOT EXISTS `activity_lob_x_ref` (
  `activity_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`lob_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.activity_lob_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_lob_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.activity_migration_key_x_ref
DROP TABLE IF EXISTS `activity_migration_key_x_ref`;
CREATE TABLE IF NOT EXISTS `activity_migration_key_x_ref` (
  `activity_id` int(11) NOT NULL,
  `migration_key_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`migration_key_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.activity_migration_key_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity_migration_key_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_migration_key_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.activity_presumed_lob_x_ref
DROP TABLE IF EXISTS `activity_presumed_lob_x_ref`;
CREATE TABLE IF NOT EXISTS `activity_presumed_lob_x_ref` (
  `activity_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`,`lob_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.activity_presumed_lob_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity_presumed_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_presumed_lob_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.activity_response
DROP TABLE IF EXISTS `activity_response`;
CREATE TABLE IF NOT EXISTS `activity_response` (
  `activity_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_owner` tinyint(4) DEFAULT NULL,
  `is_presumed` tinyint(4) DEFAULT NULL,
  `owner_user_corporate_id` int(11) DEFAULT NULL,
  `suggested_owner_user_corporate_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`activity_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.activity_response: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity_response` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.aggregate
DROP TABLE IF EXISTS `aggregate`;
CREATE TABLE IF NOT EXISTS `aggregate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the aggregate',
  `aggregate_name` varchar(255) NOT NULL,
  `aggregate_size_gb` float NOT NULL DEFAULT 0,
  `is_hybrid` tinyint(1) NOT NULL DEFAULT 0,
  `aggregate_type` varchar(45) NOT NULL,
  `controller_id` int(11) NOT NULL,
  `pool_allocated_capacity_gb` float DEFAULT NULL,
  `pool_used_capacity_gb` float DEFAULT NULL,
  `pool_iops_capability` int(11) DEFAULT NULL,
  `avg_iops` int(11) DEFAULT NULL,
  `peak_iops` int(11) DEFAULT NULL,
  `assigned_iops` int(11) NOT NULL DEFAULT 0,
  `assigned_capacity_gb` float(10,1) NOT NULL DEFAULT 0.0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`controller_id`),
  KEY `fk_aggregate_controller1_idx` (`controller_id`),
  KEY `controller_id_idx` (`id`,`controller_id`),
  CONSTRAINT `fk_aggregate_controller1` FOREIGN KEY (`controller_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  AUTO_INCREMENT=417 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.aggregate: ~16 rows (approximately)
/*!40000 ALTER TABLE `aggregate` DISABLE KEYS */;
INSERT INTO `aggregate` (`id`, `aggregate_name`, `aggregate_size_gb`, `is_hybrid`, `aggregate_type`, `controller_id`, `pool_allocated_capacity_gb`, `pool_used_capacity_gb`, `pool_iops_capability`, `avg_iops`, `peak_iops`, `assigned_iops`, `assigned_capacity_gb`, `create_time`, `update_time`) VALUES
	(23, 'fspodrtp03_n01_aggr0', 503981, 0, 'AGGREGATE', 1, 503981, 480501, 510, 4, 5, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(24, 'fspodrtp03_n01_aggr1', 7055740, 0, 'AGGREGATE', 1, 7055740, 1035, 2720, 0, 0, 0, 600000.0, '2017-09-27 12:52:25', NULL),
	(25, 'fspodrtp03_n01_aggr2', 7055740, 0, 'AGGREGATE', 1, 7055740, 1035, 2720, 0, 3, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(26, 'fspodrtp03_n02_aggr0', 376181, 0, 'AGGREGATE', 2, 376181, 358655, 510, 4, 5, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(27, 'fspodrtp03_n02_aggr1', 5266540, 0, 'AGGREGATE', 2, 5266540, 0, 2720, 0, 0, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(28, 'fspodrtp03_n02_aggr2', 7055740, 0, 'AGGREGATE', 2, 7055740, 0, 2720, 0, 0, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(29, 'fspodrtp04_n01_aggr0', 976693, 0, 'AGGREGATE', 3, 976693, 929340, 510, 5, 5, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(30, 'fspodrtp04_n01_aggr1', 14393400, 0, 'AGGREGATE', 3, 14393400, 1035, 2720, 0, 0, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(31, 'fspodrtp04_n01_aggr2', 14393400, 0, 'AGGREGATE', 3, 14393400, 1035, 2720, 0, 3, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(32, 'fspodrtp04_n02_aggr0', 732717, 0, 'AGGREGATE', 4, 732717, 697193, 510, 4, 5, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(33, 'fspodrtp04_n02_aggr1', 14393400, 0, 'AGGREGATE', 4, 14393400, 0, 2720, 0, 0, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(34, 'fspodrtp04_n02_aggr2', 10797900, 0, 'AGGREGATE', 4, 10797900, 0, 2720, 0, 0, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(413, 'aggr0', 1481650, 0, 'AGGREGATE', 409, 1481650, 246752, 600, 7, 12, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(414, 'aggr1', 6092500, 0, 'AGGREGATE', 409, 6092500, 219324, 1500, 0, 28, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(415, 'aggr0', 380781, 0, 'AGGREGATE', 410, 380781, 363039, 225, 4, 5, 0, 0.0, '2017-09-27 12:52:25', NULL),
	(416, 'aggr1', 3046250, 0, 'AGGREGATE', 410, 3046250, 8608, 750, 0, 3, 0, 0.0, '2017-09-27 12:52:25', NULL);
/*!40000 ALTER TABLE `aggregate` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.aggregate_purpose
DROP TABLE IF EXISTS `aggregate_purpose`;
CREATE TABLE IF NOT EXISTS `aggregate_purpose` (
  `aggregate_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `aggregate_function` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `service_level` varchar(255) DEFAULT NULL,
  `storage_type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`aggregate_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.aggregate_purpose: ~0 rows (approximately)
/*!40000 ALTER TABLE `aggregate_purpose` DISABLE KEYS */;
/*!40000 ALTER TABLE `aggregate_purpose` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.application
DROP TABLE IF EXISTS `application`;
CREATE TABLE IF NOT EXISTS `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_code` varchar(255) DEFAULT NULL,
  `application_name` varchar(255) DEFAULT NULL,
  `archtype` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `information_owner` varchar(255) DEFAULT NULL,
  `owner_user_corporate_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.application: ~0 rows (approximately)
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.application_lob_x_ref
DROP TABLE IF EXISTS `application_lob_x_ref`;
CREATE TABLE IF NOT EXISTS `application_lob_x_ref` (
  `application_id` int(11) NOT NULL,
  `lob_id` int(11) NOT NULL,
  PRIMARY KEY (`application_id`,`lob_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.application_lob_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `application_lob_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_lob_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.audit_event
DROP TABLE IF EXISTS `audit_event`;
CREATE TABLE IF NOT EXISTS `audit_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `http_method` varchar(255) DEFAULT NULL,
  `resource_pattern` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.audit_event: ~0 rows (approximately)
/*!40000 ALTER TABLE `audit_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_event` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.audit_reason_code
DROP TABLE IF EXISTS `audit_reason_code`;
CREATE TABLE IF NOT EXISTS `audit_reason_code` (
  `audit_event_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`audit_event_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.audit_reason_code: ~0 rows (approximately)
/*!40000 ALTER TABLE `audit_reason_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_reason_code` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.audit_trail_api
DROP TABLE IF EXISTS `audit_trail_api`;
CREATE TABLE IF NOT EXISTS `audit_trail_api` (
  `audit_event_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `audit_comment` varchar(255) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `old_values` longtext DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_api_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_event_id`,`id`),
  CONSTRAINT `FKpjjoo53gnxcodqvfw4358sfdu` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.audit_trail_api: ~0 rows (approximately)
/*!40000 ALTER TABLE `audit_trail_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_api` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.audit_trail_corporate_user
DROP TABLE IF EXISTS `audit_trail_corporate_user`;
CREATE TABLE IF NOT EXISTS `audit_trail_corporate_user` (
  `audit_event_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `audit_comment` varchar(255) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `old_values` longtext DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_corporate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_event_id`,`id`),
  CONSTRAINT `FK3nw4y0lq6y1ghwit5fka8qb2b` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.audit_trail_corporate_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `audit_trail_corporate_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_corporate_user` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.audit_trail_native_user
DROP TABLE IF EXISTS `audit_trail_native_user`;
CREATE TABLE IF NOT EXISTS `audit_trail_native_user` (
  `audit_event_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `audit_comment` varchar(255) DEFAULT NULL,
  `audited_resource` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `old_values` longtext DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_native_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`audit_event_id`,`id`),
  CONSTRAINT `FKm6anh4imy10i8gvyq2ckiujp3` FOREIGN KEY (`audit_event_id`) REFERENCES `audit_event` (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.audit_trail_native_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `audit_trail_native_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_trail_native_user` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.change_management
DROP TABLE IF EXISTS `change_management`;
CREATE TABLE IF NOT EXISTS `change_management` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Change Management',
  `migration_cutover_event_id` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `change_management_number` varchar(60) DEFAULT NULL,
  `note` mediumtext DEFAULT NULL,
  `assets_impacted` mediumtext DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
  UNIQUE KEY `migrationId` (`migration_cutover_event_id`),
  UNIQUE KEY `itsmNum` (`change_management_number`),
  CONSTRAINT `FKas3n2mou5b4mn9lou6427s8ox` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`),
  CONSTRAINT `fk_change_management_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.change_management: ~0 rows (approximately)
/*!40000 ALTER TABLE `change_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `change_management` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.controller
DROP TABLE IF EXISTS `controller`;
CREATE TABLE IF NOT EXISTS `controller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `controller_name` varchar(255) NOT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `storage_id` int(11) NOT NULL,
  `date_available` date DEFAULT '2050-12-31',
  `volume_tally` int(11) DEFAULT NULL,
  `data_center_id` int(11) NOT NULL,
  `exports_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`storage_id`,`data_center_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_con_dc_id` (`data_center_id`),
  KEY `fk_con_storage_id` (`storage_id`),
  KEY `fk_exports_id` (`exports_id`),
  CONSTRAINT `FKp7krcwvboicux59xqehe50t6b` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`id`),
  CONSTRAINT `fk_con_dc_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`),
  CONSTRAINT `fk_con_storage_id` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`id`)
)  AUTO_INCREMENT=411 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.controller: ~6 rows (approximately)
/*!40000 ALTER TABLE `controller` DISABLE KEYS */;
INSERT INTO `controller` (`id`, `controller_name`, `serial_number`, `storage_id`, `date_available`, `volume_tally`, `data_center_id`, `exports_id`, `create_time`, `update_time`) VALUES
	(1, 'fspodrtp03-n01', '100000000817', 17, '2017-05-07', 23, 11, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:21'),
	(2, 'fspodrtp03-n02', '100000000816', 17, '2017-05-07', 27, 9, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:24'),
	(3, 'fspodrtp04-n01', '100000000814', 18, '2017-05-07', 69, 17, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:28'),
	(4, 'fspodrtp04-n02', '100000000813', 18, '2017-05-07', 1, 7, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:31'),
	(409, '7GN1-RTPRDC.hop.lab', '30004713', 41, '2017-05-07', 86, 7, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:34'),
	(410, '7GN2-RTPRDC.rdc.lab', '30004714', 41, '2017-05-07', 14, 16, 0, '2017-09-27 12:52:26', '2018-01-19 12:13:39');
/*!40000 ALTER TABLE `controller` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.cutover
DROP TABLE IF EXISTS `cutover`;
CREATE TABLE IF NOT EXISTS `cutover` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover',
  `schedule_id` int(11) NOT NULL,
  `cutover_name` varchar(60) NOT NULL,
  `day_of_week` int(11) NOT NULL,
  `migrate_time` varchar(36) NOT NULL,
  `mig_spec_user_native_id` int(11) DEFAULT NULL,
  `change_management_id` int(11) DEFAULT NULL,
  `cutover_ical_id` int(11) DEFAULT NULL,
  `prep_meeting_ical_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
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
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.cutover: ~0 rows (approximately)
/*!40000 ALTER TABLE `cutover` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.cutover_assembly
DROP TABLE IF EXISTS `cutover_assembly`;
CREATE TABLE IF NOT EXISTS `cutover_assembly` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover Assembly',
  `cutover_id` int(11) NOT NULL,
  `migration_cutover_event_id` int(11) DEFAULT NULL,
  `cutover_mount_point_id` int(11) DEFAULT NULL,
  `stopped_app` tinyint(1) DEFAULT 0,
  `stopped_db` tinyint(1) DEFAULT 0,
  `unmount_volume` tinyint(1) DEFAULT 0,
  `completed_replication` tinyint(1) DEFAULT 0,
  `changed_mount` tinyint(1) DEFAULT 0,
  `started_database` tinyint(1) DEFAULT 0,
  `validated_database` tinyint(1) DEFAULT 0,
  `started_app` tinyint(1) DEFAULT 0,
  `validation_complete` tinyint(1) DEFAULT 0,
  `cutover_complete` tinyint(1) DEFAULT 0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`cutover_id`),
  UNIQUE KEY `cutover_mount_point_id_UNIQUE` (`cutover_mount_point_id`),
  KEY `fk_migrationId_coa` (`migration_cutover_event_id`),
  KEY `fk_itPAMiD_coa` (`cutover_mount_point_id`),
  KEY `fk_cutoverNameId_coa` (`cutover_id`),
  CONSTRAINT `fk_cutoverNameId_coa` FOREIGN KEY (`cutover_id`) REFERENCES `cutover` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_cutover_assembly_point_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_itPAMiD_coa` FOREIGN KEY (`cutover_mount_point_id`) REFERENCES `cutover_mount_point` (`id`) ON DELETE CASCADE
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.cutover_assembly: ~0 rows (approximately)
/*!40000 ALTER TABLE `cutover_assembly` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_assembly` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.cutover_mount_point
DROP TABLE IF EXISTS `cutover_mount_point`;
CREATE TABLE IF NOT EXISTS `cutover_mount_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Cutover Mount Point',
  `migration_cutover_event_id` int(11) DEFAULT NULL,
  `fwd_unmount_label` varchar(1024) NOT NULL DEFAULT 'UNKNOWN',
  `rev_unmount_label` varchar(1024) NOT NULL DEFAULT 'UNKNOWN',
  `fwd_mount_label` varchar(1024) DEFAULT NULL,
  `rev_mount_label` varchar(1024) DEFAULT NULL,
  `host_list` mediumtext DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `migrationId_idx` (`migration_cutover_event_id`),
  CONSTRAINT `FKhtwejhik3oklvcxcpgek4rnfh` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`),
  CONSTRAINT `fk_cutover_mount_point_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.cutover_mount_point: ~0 rows (approximately)
/*!40000 ALTER TABLE `cutover_mount_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_mount_point` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.cutover_time
DROP TABLE IF EXISTS `cutover_time`;
CREATE TABLE IF NOT EXISTS `cutover_time` (
  `cutover_assembly_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `change_mount_begin_time` datetime DEFAULT NULL,
  `change_mount_end_time` datetime DEFAULT NULL,
  `complete_replication_begin_time` datetime DEFAULT NULL,
  `complete_replication_end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `start_app_begin_time` datetime DEFAULT NULL,
  `start_app_end_time` datetime DEFAULT NULL,
  `start_db_begin_time` datetime DEFAULT NULL,
  `start_db_end_time` datetime DEFAULT NULL,
  `stop_app_begin_time` datetime DEFAULT NULL,
  `stop_app_end_time` datetime DEFAULT NULL,
  `stop_db_begin_time` datetime DEFAULT NULL,
  `stop_db_end_time` datetime DEFAULT NULL,
  `unmount_volume_begin_time` datetime DEFAULT NULL,
  `unmount_volume_end_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `validate_complete_begin_time` datetime DEFAULT NULL,
  `validate_complete_end_time` datetime DEFAULT NULL,
  `validate_db_begin_time` datetime DEFAULT NULL,
  `validate_db_end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cutover_assembly_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.cutover_time: ~0 rows (approximately)
/*!40000 ALTER TABLE `cutover_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `cutover_time` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.data_center
DROP TABLE IF EXISTS `data_center`;
CREATE TABLE IF NOT EXISTS `data_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Data Center',
  `data_center_name` varchar(24) NOT NULL DEFAULT 'UNKNOWN',
  `data_center_full_name` varchar(1024) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `region` varchar(60) NOT NULL DEFAULT 'UNKNOWN',
  `data_geo_location` point DEFAULT NULL COMMENT 'For future use: Compliance and Rules Engine.',
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `datacenter_name_idx` (`data_center_name`)
)  AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.data_center: ~13 rows (approximately)
/*!40000 ALTER TABLE `data_center` DISABLE KEYS */;
INSERT INTO `data_center` (`id`, `data_center_name`, `data_center_full_name`, `city`, `country`, `region`, `data_geo_location`, `create_time`, `update_time`) VALUES
	(1, 'MMS1', 'MMS DC 1', 'RTP', 'USA', 'NA', NULL, '2017-09-27 12:52:26', NULL),
	(2, 'MMS2', 'MMS DC 2', 'NYC', 'USA', 'NA', NULL, '2017-09-27 12:52:26', NULL),
	(3, 'DC56', NULL, NULL, NULL, 'N/A', NULL, '2018-01-18 18:20:13', NULL),
	(4, 'DC14', NULL, NULL, NULL, 'America', NULL, '2018-01-18 18:26:29', NULL),
	(6, 'DC06', NULL, NULL, NULL, 'America', NULL, '2018-01-18 19:23:00', NULL),
	(7, 'DC05', NULL, NULL, NULL, 'N/A', NULL, '2018-01-18 19:23:00', NULL),
	(9, 'DC04', NULL, NULL, NULL, 'Europe', NULL, '2018-01-18 19:23:00', NULL),
	(10, 'DC02', NULL, NULL, NULL, 'America', NULL, '2018-01-18 19:23:00', NULL),
	(11, 'DC01', NULL, NULL, NULL, 'America', NULL, '2018-01-18 19:23:00', NULL),
	(13, 'N/A', NULL, NULL, NULL, 'America', NULL, '2018-01-18 19:23:00', NULL),
	(16, 'DC10', NULL, NULL, NULL, 'N/A', NULL, '2018-01-18 19:23:00', NULL),
	(17, 'DC08', NULL, NULL, NULL, 'N/A', NULL, '2018-01-18 19:23:00', NULL),
	(20, 'DC03', NULL, NULL, NULL, 'N/A', NULL, '2018-01-18 19:23:00', NULL);
/*!40000 ALTER TABLE `data_center` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.data_protection_policy
DROP TABLE IF EXISTS `data_protection_policy`;
CREATE TABLE IF NOT EXISTS `data_protection_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Data Protection Policy',
  `data_protection_policy_name` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.data_protection_policy: ~0 rows (approximately)
/*!40000 ALTER TABLE `data_protection_policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_protection_policy` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.email_template
DROP TABLE IF EXISTS `email_template`;
CREATE TABLE IF NOT EXISTS `email_template` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `template_location` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.email_template: ~0 rows (approximately)
/*!40000 ALTER TABLE `email_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_template` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.exports
DROP TABLE IF EXISTS `exports`;
CREATE TABLE IF NOT EXISTS `exports` (
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
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `line_of_business_exports1_idx` (`lob_id`),
  CONSTRAINT `fk_exports_controller1` FOREIGN KEY (`id`) REFERENCES `controller` (`exports_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exports_exports_host_x_ref1` FOREIGN KEY (`id`) REFERENCES `exports_host_x_ref` (`exports_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.exports: ~0 rows (approximately)
/*!40000 ALTER TABLE `exports` DISABLE KEYS */;
/*!40000 ALTER TABLE `exports` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.exports_host_x_ref
DROP TABLE IF EXISTS `exports_host_x_ref`;
CREATE TABLE IF NOT EXISTS `exports_host_x_ref` (
  `exports_id` int(11) NOT NULL,
  `host_id` int(11) NOT NULL,
  PRIMARY KEY (`host_id`,`exports_id`),
  KEY `exports_id_host_id` (`exports_id`,`host_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.exports_host_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `exports_host_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `exports_host_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.extended_info_varchar
DROP TABLE IF EXISTS `extended_info_varchar`;
CREATE TABLE IF NOT EXISTS `extended_info_varchar` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `field_id` int(11) DEFAULT NULL,
  `field_value` varchar(255) DEFAULT NULL,
  `row_id` int(11) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.extended_info_varchar: ~0 rows (approximately)
/*!40000 ALTER TABLE `extended_info_varchar` DISABLE KEYS */;
/*!40000 ALTER TABLE `extended_info_varchar` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.extended_info_varchar_settings
DROP TABLE IF EXISTS `extended_info_varchar_settings`;
CREATE TABLE IF NOT EXISTS `extended_info_varchar_settings` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `field_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.extended_info_varchar_settings: ~0 rows (approximately)
/*!40000 ALTER TABLE `extended_info_varchar_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `extended_info_varchar_settings` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.host
DROP TABLE IF EXISTS `host`;
CREATE TABLE IF NOT EXISTS `host` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `host_name` varchar(255) DEFAULT NULL,
  `host_owner_user_corporate_id` int(11) DEFAULT NULL,
  `ip_addr` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `system_admin_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.host: ~2 rows (approximately)
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` (`id`, `create_time`, `host_name`, `host_owner_user_corporate_id`, `ip_addr`, `note`, `system_admin_id`, `update_time`) VALUES
	(1, NULL, 'dv2-ls-cts-001', NULL, '1111.222.333.222', 'Test', NULL, NULL),
	(2, NULL, 'dv2-ls-cts-002', NULL, '198.222.333.222', 'Test', NULL, NULL);
/*!40000 ALTER TABLE `host` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.host_application_x_ref
DROP TABLE IF EXISTS `host_application_x_ref`;
CREATE TABLE IF NOT EXISTS `host_application_x_ref` (
  `application_id` int(11) NOT NULL,
  `host_id` int(11) NOT NULL,
  PRIMARY KEY (`application_id`,`host_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.host_application_x_ref: ~0 rows (approximately)
/*!40000 ALTER TABLE `host_application_x_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `host_application_x_ref` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.ical
DROP TABLE IF EXISTS `ical`;
CREATE TABLE IF NOT EXISTS `ical` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the iCal',
  `migration_cutover_event_id` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `sender_email` varchar(255) NOT NULL,
  `date_of_meeting` date NOT NULL,
  `time_of_meeting` time NOT NULL,
  `bridge` varchar(120) DEFAULT NULL,
  `meeting_url` varchar(255) DEFAULT NULL,
  `change_mgmt_url` varchar(255) DEFAULT NULL,
  `attendees` text DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
  UNIQUE KEY `migration_id` (`migration_cutover_event_id`),
  KEY `date_idx` (`date_of_meeting`),
  CONSTRAINT `FKi3sgqa5j7h54goyw8yftueso2` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`),
  CONSTRAINT `fk_ical_migration_cutover_event` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.ical: ~0 rows (approximately)
/*!40000 ALTER TABLE `ical` DISABLE KEYS */;
/*!40000 ALTER TABLE `ical` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.line_of_business
DROP TABLE IF EXISTS `line_of_business`;
CREATE TABLE IF NOT EXISTS `line_of_business` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `liason_contact_number` varchar(255) DEFAULT NULL,
  `liason_email` varchar(255) DEFAULT NULL,
  `liason_first_name` varchar(255) DEFAULT NULL,
  `liason_last_name` varchar(255) DEFAULT NULL,
  `liason_user_name` varchar(255) DEFAULT NULL,
  `lob_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.line_of_business: ~0 rows (approximately)
/*!40000 ALTER TABLE `line_of_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `line_of_business` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.migration_cutover_event
DROP TABLE IF EXISTS `migration_cutover_event`;
CREATE TABLE IF NOT EXISTS `migration_cutover_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Event',
  `migrate_week` date NOT NULL DEFAULT '1900-01-01',
  `migrate_day` int(4) NOT NULL DEFAULT 0,
  `migrate_time` varchar(60) NOT NULL DEFAULT '0',
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `application_id` int(11) NOT NULL DEFAULT 0,
  `migration_approved` tinyint(1) DEFAULT 0,
  `high_over_write` tinyint(4) DEFAULT NULL,
  `lob_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.migration_cutover_event: ~0 rows (approximately)
/*!40000 ALTER TABLE `migration_cutover_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_event` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.migration_cutover_src_to_tgt
DROP TABLE IF EXISTS `migration_cutover_src_to_tgt`;
CREATE TABLE IF NOT EXISTS `migration_cutover_src_to_tgt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Source to Target',
  `migration_cutover_event_id` int(11) NOT NULL,
  `data_protection_policy_id` int(11) NOT NULL,
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `application_id` int(11) NOT NULL DEFAULT 0,
  `host_id_list` varchar(1024) DEFAULT NULL COMMENT 'DEV TBD - We should be able to get this from the src and tgt IDs.',
  `processed` tinyint(1) NOT NULL DEFAULT 0,
  `provisioned` tinyint(4) DEFAULT 0,
  `replication` tinyint(4) DEFAULT 0,
  `completed` tinyint(4) DEFAULT 0,
  `src_data_center_id` int(11) NOT NULL DEFAULT 0,
  `src_aggregate_id` int(11) NOT NULL,
  `src_controller_id` int(11) NOT NULL,
  `src_volume_id` int(11) NOT NULL DEFAULT 0,
  `src_qtree_id` int(11) NOT NULL DEFAULT 0,
  `tgt_data_center_id` int(11) NOT NULL DEFAULT 0,
  `tgt_aggregate_id` int(11) NOT NULL,
  `tgt_controller_id` int(11) NOT NULL,
  `tgt_volume_id` int(11) NOT NULL DEFAULT 0,
  `tgt_qtree_id` int(11) NOT NULL DEFAULT 0,
  `tgt_capacity` tinyint(4) DEFAULT 0,
  `tgt_status` enum('Red','Amber','Green') DEFAULT 'Red',
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`migration_cutover_event_id`),
  KEY `fk_migration_cutover_src_to_tgt_migration_cutover_event1_idx` (`migration_cutover_event_id`),
  KEY `fk_migration_cutover_src_to_tgt_data_protection_policy1_idx` (`data_protection_policy_id`),
  CONSTRAINT `FK6vhd5c9hb48xpn6wn6lsk9d9e` FOREIGN KEY (`id`) REFERENCES `migration_cutover_team` (`id`),
  CONSTRAINT `FK8w9rqfjyeclv7fawsk8lmsxfs` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`),
  CONSTRAINT `FKlxm5ifi3fuqi0hy6dlfmcutwl` FOREIGN KEY (`data_protection_policy_id`) REFERENCES `data_protection_policy` (`id`),
  CONSTRAINT `fk_migration_cutover_src_to_tgt_data_protection_policy1` FOREIGN KEY (`data_protection_policy_id`) REFERENCES `data_protection_policy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_migration_cutover_src_to_tgt_migration_cutover_event1` FOREIGN KEY (`migration_cutover_event_id`) REFERENCES `migration_cutover_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_migration_cutover_src_to_tgt_migration_cutover_team` FOREIGN KEY (`id`) REFERENCES `migration_cutover_team` (`migration_cutover_src_to_tgt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.migration_cutover_src_to_tgt: ~0 rows (approximately)
/*!40000 ALTER TABLE `migration_cutover_src_to_tgt` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_src_to_tgt` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.migration_cutover_team
DROP TABLE IF EXISTS `migration_cutover_team`;
CREATE TABLE IF NOT EXISTS `migration_cutover_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Migration Cutover Team',
  `migration_cutover_src_to_tgt_id` int(11) NOT NULL,
  `team_member_role` enum('system_admin','app_stop','app_start','db_stop','db_start','validate_data','validate_app') NOT NULL,
  `user_corporate_id` int(11) NOT NULL DEFAULT 0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `migration_cutover_src_to_tgt_id_idx` (`migration_cutover_src_to_tgt_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.migration_cutover_team: ~0 rows (approximately)
/*!40000 ALTER TABLE `migration_cutover_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_cutover_team` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.migration_key
DROP TABLE IF EXISTS `migration_key`;
CREATE TABLE IF NOT EXISTS `migration_key` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `migration_key` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_corporate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.migration_key: ~0 rows (approximately)
/*!40000 ALTER TABLE `migration_key` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_key` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.migration_time
DROP TABLE IF EXISTS `migration_time`;
CREATE TABLE IF NOT EXISTS `migration_time` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `time_slot` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.migration_time: ~0 rows (approximately)
/*!40000 ALTER TABLE `migration_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `migration_time` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.mms_config
DROP TABLE IF EXISTS `mms_config`;
CREATE TABLE IF NOT EXISTS `mms_config` (
  `id` int(11) NOT NULL,
  `component_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `encrypted` tinyint(4) NOT NULL,
  `environment_name` varchar(255) DEFAULT NULL,
  `expiration` date DEFAULT NULL,
  `last_update_user` varchar(255) DEFAULT NULL,
  `last_updated_ts` datetime DEFAULT NULL,
  `property_name` varchar(255) DEFAULT NULL,
  `property_type_id` int(11) DEFAULT NULL,
  `property_value` varchar(255) DEFAULT NULL,
  `subcomponent_name` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.mms_config: ~0 rows (approximately)
/*!40000 ALTER TABLE `mms_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `mms_config` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.mms_property_type
DROP TABLE IF EXISTS `mms_property_type`;
CREATE TABLE IF NOT EXISTS `mms_property_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `property_type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.mms_property_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `mms_property_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mms_property_type` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.mount_point
DROP TABLE IF EXISTS `mount_point`;
CREATE TABLE IF NOT EXISTS `mount_point` (
  `host_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `inventory_number` varchar(255) DEFAULT NULL,
  `mount_location` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`host_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.mount_point: ~0 rows (approximately)
/*!40000 ALTER TABLE `mount_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount_point` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.mst_emailing_date
DROP TABLE IF EXISTS `mst_emailing_date`;
CREATE TABLE IF NOT EXISTS `mst_emailing_date` (
  `email_type_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `app_owner_user_corporate_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `mailing_date_time` datetime DEFAULT NULL,
  `migrate_week` date DEFAULT NULL,
  `system_admin_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`email_type_id`,`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.mst_emailing_date: ~0 rows (approximately)
/*!40000 ALTER TABLE `mst_emailing_date` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_emailing_date` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.mst_email_type
DROP TABLE IF EXISTS `mst_email_type`;
CREATE TABLE IF NOT EXISTS `mst_email_type` (
  `id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `email_type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.mst_email_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `mst_email_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_email_type` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.nas_volume
DROP TABLE IF EXISTS `nas_volume`;
CREATE TABLE IF NOT EXISTS `nas_volume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID of the NAS Volume. This is not a Surrogate!',
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
  `qtree_tally` int(11) NOT NULL DEFAULT 0,
  `snap_tally` int(11) DEFAULT 0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`aggregate_id`,`controlled_id`),
  KEY `vol_name_idx` (`vserver`,`volume_name`),
  KEY `volume_controller_idx` (`controlled_id`),
  KEY `volume_aggregate` (`aggregate_id`),
  CONSTRAINT `fk_volume_aggregate1` FOREIGN KEY (`aggregate_id`) REFERENCES `aggregate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_volume_controller1` FOREIGN KEY (`controlled_id`) REFERENCES `controller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  AUTO_INCREMENT=3416 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.nas_volume: ~220 rows (approximately)
/*!40000 ALTER TABLE `nas_volume` DISABLE KEYS */;
INSERT INTO `nas_volume` (`id`, `controlled_id`, `aggregate_id`, `vserver`, `volume_name`, `allocated_capacity_gb`, `used_capacity_gb`, `snap_type`, `snap_src_volume_id`, `snap_tgt_volume_id`, `snap_destination_volume`, `volume_status`, `volume_last_accessed`, `disposition`, `justification`, `avg_iops`, `peak_iops`, `qtree_tally`, `snap_tally`, `create_time`, `update_time`) VALUES
	(311, 1, 23, 'fspodrtp03-n01', 'vol0', 467, 467, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 25, 127, 1, 8, '2017-09-27 12:52:27', NULL),
	(312, 2, 26, 'fspodrtp03-n02', 'vol0', 348, 348, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 21, 73, 1, 8, '2017-09-27 12:52:27', NULL),
	(313, 1, 25, 'fspodrtp03d', 'fspodrtp03d_root', 1, 1, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(314, 1, 24, 'fspodrtp03p', 'fspodrtp03p_root', 1, 1, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(315, 3, 29, 'fspodrtp04-n01', 'vol0', 903, 903, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 27, 165, 1, 8, '2017-09-27 12:52:27', NULL),
	(316, 4, 32, 'fspodrtp04-n02', 'vol0', 677, 677, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 19, 136, 1, 8, '2017-09-27 12:52:27', NULL),
	(317, 3, 31, 'fspodrtp04d', 'fspodrtp04d_root', 1, 1, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(318, 3, 30, 'fspodrtp04p', 'fspodrtp04p_root', 1, 1, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(569, 409, 414, 'vfiler0', 'Dan_test', 0, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(570, 409, 414, 'vfiler0', 'ExelonPSVol1', 2, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(571, 409, 414, 'vfiler0', 'ExelonPSVol2', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(572, 409, 414, 'vfiler0', 'ExelonPSVol3', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(573, 409, 414, 'vfiler0', 'Julie_online_stg1', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 2, 2, '2017-09-27 12:52:27', NULL),
	(574, 409, 414, 'vfiler0', 'WFA_Chris1', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(575, 409, 414, 'vfiler0', 'WFA_Chris2', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(576, 409, 414, 'vfiler0', 'WFA_Chris3', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(577, 409, 414, 'vfiler0', 'WFA_Drew1', 1, 1, 'FlexClone', 577, 658, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(578, 409, 414, 'vfiler0', 'WFA_Drew2', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(579, 409, 414, 'vfiler0', 'WFA_Drew3', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(580, 409, 414, 'vfiler0', 'WFA_Julie1', 1, 1, 'FlexClone', 580, 659, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(581, 409, 414, 'vfiler0', 'WFA_Julie2', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(582, 409, 414, 'vfiler0', 'WFA_Julie3', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(583, 409, 414, 'vfiler0', 'WFA_Ron1', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(584, 409, 414, 'vfiler0', 'WFA_Ron2', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(585, 409, 414, 'vfiler0', 'WFA_Ron2_stg1', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 2, 2, '2017-09-27 12:52:27', NULL),
	(586, 409, 414, 'vfiler0', 'WFA_Ron3', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(587, 409, 414, 'vfiler0', 'WFA_Zach1', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(588, 409, 414, 'vfiler0', 'WFA_Zach2', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(589, 409, 414, 'vfiler0', 'WFA_Zach3', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(590, 409, 414, 'vfiler0', 'WFA_vol_Chris_Multi', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 4, 8, '2017-09-27 12:52:27', NULL),
	(591, 409, 414, 'vfiler0', 'WFA_vol_Drew_Multi', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 5, 8, '2017-09-27 12:52:27', NULL),
	(592, 409, 414, 'vfiler0', 'WFA_vol_Julie_Multi', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 4, 8, '2017-09-27 12:52:27', NULL),
	(593, 409, 414, 'vfiler0', 'WFA_vol_Ron_Multi', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 4, 8, '2017-09-27 12:52:27', NULL),
	(594, 409, 414, 'vfiler0', 'WFA_vol_Zach_Multi', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 4, 8, '2017-09-27 12:52:27', NULL),
	(595, 409, 414, 'amgen', 'amgen', 10, 10, NULL, NULL, NULL, NULL, 'online', '2017-04-15 13:08:41', 'DiscoverOwner', 'No Rules Matched', 0, 1, 1, 10, '2017-09-27 12:52:27', NULL),
	(596, 409, 414, 'vfiler0', 'amgenSM3', 2, 2, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(597, 409, 413, 'amgen', 'amgentest2', 2, 2, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 4, 12, '2017-09-27 12:52:27', NULL),
	(598, 409, 414, 'amgen', 'amgentestSM', 4, 4, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 4, 14, '2017-09-27 12:52:27', NULL),
	(599, 409, 414, 'amgen', 'amgentestSV', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 52, '2017-09-27 12:52:27', NULL),
	(600, 409, 414, 'vfiler0', 'av_test', 25, 12, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(601, 409, 414, 'vfiler0', 'cbauernf_sv_dst', 0, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 2, 9, '2017-09-27 12:52:27', NULL),
	(602, 409, 414, 'vfiler0', 'cbauernf_sv_src', 0, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 3, 17, '2017-09-27 12:52:27', NULL),
	(603, 409, 414, 'cbauernf_vf', 'cbauernf_vf', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(604, 409, 414, 'cbauernf_vf', 'cbauernf_xcp', 10, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(605, 409, 414, 'vfiler0', 'cbquota', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(606, 409, 414, 'vfiler0', 'change_aggr', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 10, '2017-09-27 12:52:27', NULL),
	(607, 409, 414, 'vfiler0', 'charlie', 0, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(608, 409, 414, 'vfiler0', 'cifstest', 22, 13, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(609, 409, 414, 'vfiler0', 'drew', 12, 12, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 0, '2017-09-27 12:52:27', NULL),
	(610, 409, 414, 'vfiler0', 'drew4_stg1', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 2, 2, '2017-09-27 12:52:27', NULL),
	(611, 409, 414, 'vf_drew_lab', 'drew_NFS', 5, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 0, '2017-09-27 12:52:27', NULL),
	(612, 409, 414, 'vf_drew_lab', 'drew_iscsi', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(613, 409, 414, 'vfiler0', 'mackenzi_testr', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(614, 409, 414, 'vfiler0', 'mms_pr_crqsv_multi_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 2, 5, 3, 15, '2017-09-27 12:52:27', NULL),
	(615, 409, 414, 'vfiler0', 'mms_pr_drqsm_pr_crqsv_one_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 1, 2, 16, '2017-09-27 12:52:27', NULL),
	(616, 409, 414, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro', 1, 0, 'SnapMirror', 616, 644, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 1, 3, 2, 17, '2017-09-27 12:52:27', NULL),
	(617, 409, 414, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw', 1, 0, 'SnapMirror', 617, 646, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 1, 3, 2, 17, '2017-09-27 12:52:27', NULL),
	(618, 409, 414, 'vfiler0', 'mms_pr_drvsm_crqsv_no_qtree', 1, 0, 'SnapMirror', 618, 648, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 1, 3, 1, 17, '2017-09-27 12:52:27', NULL),
	(619, 409, 414, 'vfiler0', 'mms_pr_drvsm_one_qtree', 1, 0, 'SnapMirror', 619, 650, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 2, 9, '2017-09-27 12:52:27', NULL),
	(620, 409, 414, 'vfiler0', 'mms_pr_drvsm_pr_crqsv_multi_qtree', 1, 0, 'SnapMirror', 620, 651, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 3, 16, '2017-09-27 12:52:27', NULL),
	(621, 409, 414, 'vFilerMMS', 'mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms', 1, 1, 'SnapMirror', 621, 653, NULL, 'online', '2017-04-26 08:20:19', 'DiscoverOwner', 'No Rules Matched', 0, 178, 2, 19, '2017-09-27 12:52:27', NULL),
	(622, 409, 414, 'vfiler0', 'mms_pr_only_multi_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 3, 9, '2017-09-27 12:52:27', NULL),
	(623, 409, 414, 'vfiler0', 'mms_pr_only_no_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 1, 2, 1, 8, '2017-09-27 12:52:27', NULL),
	(624, 409, 414, 'vfiler0', 'mms_pr_only_one_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 2, 8, '2017-09-27 12:52:27', NULL),
	(625, 409, 413, 'amgen', 'nocifs', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(626, 409, 414, 'vfiler0', 'robocopy', 10, 10, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 3, 8, '2017-09-27 12:52:27', NULL),
	(627, 409, 413, 'vfiler0', 'shahul_cdot_wfa_stg1', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 2, 2, '2017-09-27 12:52:27', NULL),
	(628, 409, 414, 'vfiler0', 'shahul_wfa2_stg1', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 2, 2, '2017-09-27 12:52:27', NULL),
	(629, 409, 414, 'vfiler0', 'shahul_wfavol', 7, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 11, '2017-09-27 12:52:27', NULL),
	(630, 409, 414, 'vfiler0', 'sxvoltest', 10, 8, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(631, 409, 414, 'vFilerMMS', 'vFilerMMS_root', 2, 2, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 2, 1, 8, '2017-09-27 12:52:27', NULL),
	(632, 409, 414, 'vf_drew_lab', 'vf_drew_lab_ISCSI_Linux1', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(633, 409, 414, 'vf_drew_lab', 'vf_drew_lab_ISCSI_Linux2', 10, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(634, 409, 414, 'vf_drew_lab', 'vf_drew_lab_NFS', 30, 18, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 16, '2017-09-27 12:52:27', NULL),
	(635, 409, 414, 'vf_drew_lab', 'vf_drew_lab_root', 0, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(636, 409, 413, 'vfiler0', 'vol0', 229, 229, NULL, NULL, NULL, NULL, 'online', '2017-04-15 13:08:41', 'NetApp', 'Netapp System Volume', 60, 197, 1, 9, '2017-09-27 12:52:27', NULL),
	(637, 409, 414, 'vfiler0', 'vol_07012014_102754', 20, 20, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(638, 409, 414, 'vfiler0', 'vol_07012014_130705', 15, 15, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(639, 409, 414, 'vfiler0', 'volume1', 10, 10, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(640, 409, 414, 'vf_zach_lab', 'zach_lab_vol', 10, 10, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 2, 8, '2017-09-27 12:52:27', NULL),
	(641, 410, 416, 'vfiler0', 'mms_pr_crqsv_multi_qtree_cr', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 4, 3, 31, '2017-09-27 12:52:27', NULL),
	(642, 410, 416, 'vfiler0', 'mms_pr_drqsm_pr_crqsv_one_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 1, 2, 9, '2017-09-27 12:52:27', NULL),
	(643, 410, 416, 'vfiler0', 'mms_pr_drqsm_pr_crqsv_one_qtree_cr', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 3, 2, 31, '2017-09-27 12:52:27', NULL),
	(644, 410, 416, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 1, 3, 2, 18, '2017-09-27 12:52:27', NULL),
	(646, 410, 416, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 1, 3, 2, 18, '2017-09-27 12:52:27', NULL),
	(648, 410, 416, 'vfiler0', 'mms_pr_drvsm_crqsv_no_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 1, 3, 1, 18, '2017-09-27 12:52:27', NULL),
	(650, 410, 416, 'vfiler0', 'mms_pr_drvsm_one_qtree', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 0, 2, 10, '2017-09-27 12:52:27', NULL),
	(651, 410, 416, 'vfiler0', 'mms_pr_drvsm_pr_crqsv_multi_qtree', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 0, 3, 17, '2017-09-27 12:52:27', NULL),
	(652, 410, 416, 'vfiler0', 'mms_pr_drvsm_pr_crqsv_multi_qtree_cr', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'CIFS-Only', 'CIFS Only- Orphan identify not defined', 0, 0, 3, 31, '2017-09-27 12:52:27', NULL),
	(653, 410, 416, 'vfiler1', 'mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 178, 2, 20, '2017-09-27 12:52:27', NULL),
	(654, 410, 416, 'vFiler2', 'mms_pr_drvsm_pr_crqsv_one_qtree_vfilermms_cr', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 3, 40, '2017-09-27 12:52:27', NULL),
	(655, 410, 416, 'vfiler1', 'vfiler1_root', 2, 2, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 2, 1, 8, '2017-09-27 12:52:27', NULL),
	(656, 410, 416, 'vFiler2', 'vfiler2_root', 2, 2, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 2, 1, 8, '2017-09-27 12:52:27', NULL),
	(657, 410, 415, 'vfiler0', 'vol0', 353, 353, NULL, NULL, NULL, NULL, 'online', NULL, 'NetApp', 'Netapp System Volume', 60, 197, 1, 8, '2017-09-27 12:52:27', NULL),
	(658, 409, 414, 'vfiler0', 'WFA_Drew1_clone1', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(659, 409, 414, 'vfiler0', 'WFA_Julie1_clone1', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(660, 409, 414, 'vfiler0', 'WFA_Julie1_clone2', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan', 'ACL- Meets customer\'s NFS ACL Orphan rule', 0, 0, 1, 9, '2017-09-27 12:52:27', NULL),
	(1702, 409, 414, 'vfiler0', 'win2k12NFS', 1, 0, NULL, NULL, NULL, NULL, 'online', '2017-05-04 15:03:05', 'DiscoverOwner', 'No Rules Matched', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(1749, 409, 414, 'vFilerMMS', 'vfilerMMS_vol', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(1750, 409, 414, 'vfiler0', 'vol_parker_mms_1qtree_novfiler', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 2, 8, '2017-09-27 12:52:27', NULL),
	(1751, 409, 414, 'vFilerMMS', 'vol_parker_mms_1qtree_vfiler', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 2, 8, '2017-09-27 12:52:27', NULL),
	(1752, 409, 414, 'vfiler0', 'vol_parker_mms_2qtree_novfiler', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 3, 8, '2017-09-27 12:52:27', NULL),
	(1753, 409, 414, 'vfiler0', 'vol_parker_mms_noqtree_novfiler', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(1754, 409, 414, 'vFilerMMS', 'vol_parker_mms_noqtree_vfiler', 1, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 1, 8, '2017-09-27 12:52:27', NULL),
	(1836, 1, 25, 'fspodrtp03p', 'fspodrtp03p_a_b_b_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 0, '2017-09-27 12:52:27', NULL),
	(1887, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_parker_b100_prd', 2, 0, 'SnapMirror', 1887, 1888, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 26, '2017-09-27 12:52:27', NULL),
	(1888, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_parker_b100_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1889, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prcr001_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1890, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prcr001_prd', 2, 0, 'SnapVault', 1890, 1889, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 26, '2017-09-27 12:52:27', NULL),
	(1891, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr001_prd', 2, 0, 'SnapVault', 1891, 1892, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1892, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr001_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1893, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr001_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1894, 409, 414, 'vfiler0', 'mms_parker_nfs_100', 1, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 0, 2, 0, '2017-09-27 12:52:27', NULL),
	(1895, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_parker_nfs101_prd', 1, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 0, '2017-09-27 12:52:27', NULL),
	(1896, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_pr001_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 0, '2017-09-27 12:52:27', NULL),
	(1897, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr006_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1898, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr006_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1899, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr006_prd', 2, 0, 'SnapVault', 1899, 1897, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1900, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr108_prd', 2, 0, 'SnapVault', 1900, 1904, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1901, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr110_prd', 2, 0, 'SnapVault', 1901, 1905, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1902, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr111_prd', 2, 0, 'SnapVault', 1902, 1906, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1903, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr112_prd', 2, 0, 'SnapVault', 1903, 1907, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 27, '2017-09-27 12:52:27', NULL),
	(1904, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr108_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1905, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr110_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1906, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr111_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1907, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr112_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1908, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr108_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1909, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr110_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1910, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr111_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1911, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr112_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 28, '2017-09-27 12:52:27', NULL),
	(1912, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr113_prd', 2, 0, 'SnapVault', 1912, 1916, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 26, '2017-09-27 12:52:27', NULL),
	(1913, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr114_prd', 2, 0, 'SnapVault', 1913, 1917, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 26, '2017-09-27 12:52:27', NULL),
	(1914, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr115_prd', 2, 0, 'SnapVault', 1914, 1918, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 26, '2017-09-27 12:52:27', NULL),
	(1915, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr118_prd', 2, 0, 'SnapVault', 1915, 1919, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 25, '2017-09-27 12:52:27', NULL),
	(1916, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr113_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1917, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr114_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1918, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr115_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1919, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr118_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(1920, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr120_prd', 2, 0, 'SnapVault', 1920, 1921, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 25, '2017-09-27 12:52:27', NULL),
	(1921, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr120_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2280, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr124_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2281, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr124_prd', 2, 0, 'SnapVault', 2281, 2280, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 25, '2017-09-27 12:52:27', NULL),
	(2282, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mmstest_parker_pronly_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 0, '2017-09-27 12:52:27', NULL),
	(2498, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr206_prd', 2, 0, 'SnapMirror', 2498, 2499, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2499, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr206_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 17, '2017-09-27 12:52:27', NULL),
	(2500, 1, 25, 'fspodrtp03p', 'fspodrtp03p_mms_sample_parker0r01_prd', 2, 0, 'SnapVault', 2500, 2501, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2501, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_parker0r01_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2502, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr206_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2503, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_parker0r01_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 17, '2017-09-27 12:52:27', NULL),
	(2504, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sample_prdrcr207_prd', 2, 0, 'SnapVault', 2504, 2505, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2505, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sample_prdrcr207_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2506, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sample_prdrcr207_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 17, '2017-09-27 12:52:27', NULL),
	(2609, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr212_prd', 2, 0, 'SnapMirror', 2609, 2615, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2610, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_prdrcr218_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2611, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr213_prd', 2, 0, 'SnapMirror', 2611, 2616, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2612, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr214_prd', 2, 0, 'SnapMirror', 2612, 2617, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2613, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr215_prd', 2, 0, 'SnapMirror', 2613, 2618, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2614, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr218_prd', 2, 0, 'SnapVault', 2614, 2610, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2615, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr212_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2616, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr213_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2617, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr214_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2618, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr215_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2619, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr218_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2722, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr239_prd', 2, 0, 'SnapVault', 2722, 2723, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2723, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_prdrcr239_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2724, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr239_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2725, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_prdrcr243_prd', 2, 0, 'SnapVault', 2725, 2726, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2726, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_prdrcr243_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2727, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_prdrcr243_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 16, '2017-09-27 12:52:27', NULL),
	(2728, 409, 414, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_ro_cr', 5, 0, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 1, 2, 31, '2017-09-27 12:52:27', NULL),
	(2729, 409, 414, 'vfiler0', 'mms_pr_drvsm_cr_qsv_one_qtree_anon_glob_rw_cr', 5, 1, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 1, 2, 28, '2017-09-27 12:52:27', NULL),
	(2730, 409, 414, 'vfiler0', 'mms_pr_drvsm_crqsv_no_qtree_cr', 5, 5, NULL, NULL, NULL, NULL, 'online', NULL, 'NFS-Orphan w/CIFS', 'ACL- Meets customer\'s NFS ACL Orphan rule but contains CIFS shares', 0, 1, 2, 28, '2017-09-27 12:52:27', NULL),
	(2842, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_payr107_prd', 2, 0, 'SnapVault', 2842, 2843, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2843, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_payr107_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2844, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_payr107_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2845, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_payr101_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2846, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_payr101_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2847, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_payr101_prd', 2, 0, 'SnapVault', 2847, 2845, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2848, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay201_prd', 2, 0, 'SnapVault', 2848, 2849, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2849, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay201_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2850, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay201_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 15, '2017-09-27 12:52:27', NULL),
	(2953, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay209_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2954, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay209_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2955, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay209_prd', 2, 0, 'SnapVault', 2955, 2953, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 13, '2017-09-27 12:52:27', NULL),
	(2956, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay210_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2957, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay210_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2958, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay210_prd', 2, 0, 'SnapVault', 2958, 2956, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 13, '2017-09-27 12:52:27', NULL),
	(2959, 2, 27, 'fspodrtp03p', 'fspodrtp03p_parker_sub_test222_prd', 1, 0, 'SnapVault', 2959, 2960, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 13, '2017-09-27 12:52:27', NULL),
	(2960, 3, 30, 'fspodrtp04d', 'fspodrtp03p_parker_sub_test222_prd', 1, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2961, 3, 31, 'fspodrtp04p', 'fspodrtp03p_parker_sub_test222_prd', 1, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2962, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay302_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(2963, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay302_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 14, '2017-09-27 12:52:27', NULL),
	(2964, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay302_prd', 2, 0, 'SnapVault', 2964, 2962, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 13, '2017-09-27 12:52:27', NULL),
	(3102, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay312_prd', 2, 0, 'SnapVault', 3102, 3103, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 12, '2017-09-27 12:52:27', NULL),
	(3103, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay312_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3104, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay312_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 13, '2017-09-27 12:52:27', NULL),
	(3105, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay323_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3106, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay322_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3107, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay323_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 12, '2017-09-27 12:52:27', NULL),
	(3108, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay322_prd', 2, 0, 'SnapVault', 3108, 3106, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 10, '2017-09-27 12:52:27', NULL),
	(3109, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay323_prd', 2, 0, 'SnapVault', 3109, 3105, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 11, '2017-09-27 12:52:27', NULL),
	(3110, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay325_prd', 2, 0, 'SnapVault', 3110, 3113, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 11, '2017-09-27 12:52:27', NULL),
	(3111, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay326_prd', 2, 0, 'SnapVault', 3111, 3112, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 11, '2017-09-27 12:52:27', NULL),
	(3112, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay326_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3113, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay325_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3114, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay326_prd', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 12, '2017-09-27 12:52:27', NULL),
	(3280, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay333_prd', 2, 0, 'SnapVault', 3280, 3281, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 7, '2017-09-27 12:52:27', NULL),
	(3281, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay333_prd', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3313, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay335_prd_pay335', 2, 0, 'SnapVault', 3313, 3314, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 6, '2017-09-27 12:52:27', NULL),
	(3314, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay335_prd_pay335', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3348, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay3351001_prd_pay3351001', 2, 0, 'SnapVault', 3348, 3350, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 6, '2017-09-27 12:52:27', NULL),
	(3349, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mms_sub_pay335null_prd_pay335null', 2, 0, 'SnapVault', 3349, 3352, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 5, '2017-09-27 12:52:27', NULL),
	(3350, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mms_sub_pay3351001_prd_pay3351001', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3351, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay3351001_prd_pay3351001', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 7, '2017-09-27 12:52:27', NULL),
	(3352, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mms_sub_pay335null_prd_pay335null', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, 0, 0, 2, 1, '2017-09-27 12:52:27', NULL),
	(3411, 3, 30, 'fspodrtp04d', 'fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, NULL, NULL, 2, 1, '2017-09-27 12:52:27', NULL),
	(3412, 3, 30, 'fspodrtp04p', 'fspodrtp03p_mouse_sub_delipeeps1004_prd_delipeeps1004', 3, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, NULL, NULL, 2, 1, '2017-09-27 12:52:27', NULL),
	(3413, 3, 31, 'fspodrtp04p', 'fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull', 2, 0, NULL, NULL, NULL, NULL, 'ONLINE', NULL, NULL, NULL, NULL, NULL, 2, 4, '2017-09-27 12:52:27', NULL),
	(3414, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mouse_sub_delipeeps1004_prd_delipeeps1004', 2, 0, 'SnapVault', 3414, 3412, NULL, 'ONLINE', NULL, NULL, NULL, NULL, NULL, 2, 2, '2017-09-27 12:52:27', NULL),
	(3415, 2, 28, 'fspodrtp03p', 'fspodrtp03p_mouse_sub_delipepsnull_prd_delipepsnull', 2, 0, 'SnapVault', 3415, 3411, NULL, 'ONLINE', NULL, NULL, NULL, NULL, NULL, 2, 3, '2017-09-27 12:52:27', NULL);
/*!40000 ALTER TABLE `nas_volume` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.qtree
DROP TABLE IF EXISTS `qtree`;
CREATE TABLE IF NOT EXISTS `qtree` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID of the QTree. This is not a Surrogate!',
  `nas_volume_id` int(11) NOT NULL,
  `qtree_name` varchar(225) DEFAULT NULL,
  `quota_hard_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `quota_soft_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `quota_used_capacity_limit_mb` bigint(20) DEFAULT NULL,
  `qtree_type` enum('DEFAULT','EXPLICIT') DEFAULT NULL,
  `security_style` enum('UNIX','NTFS','MIXED') DEFAULT NULL,
  `qtree_status` varchar(225) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`nas_volume_id`),
  KEY `qtreedata_internalVolumeId_idx` (`nas_volume_id`),
  CONSTRAINT `Volume_verb_QTree_fk` FOREIGN KEY (`nas_volume_id`) REFERENCES `nas_volume` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  AUTO_INCREMENT=3426 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.qtree: ~224 rows (approximately)
/*!40000 ALTER TABLE `qtree` DISABLE KEYS */;
INSERT INTO `qtree` (`id`, `nas_volume_id`, `qtree_name`, `quota_hard_capacity_limit_mb`, `quota_soft_capacity_limit_mb`, `quota_used_capacity_limit_mb`, `qtree_type`, `security_style`, `qtree_status`, `create_time`, `update_time`) VALUES
	(328, 313, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(329, 314, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(332, 317, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(333, 318, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(696, 569, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(697, 570, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(698, 571, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(699, 572, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(700, 573, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(702, 574, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(703, 575, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(704, 576, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(705, 577, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(706, 578, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(707, 579, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(708, 580, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(709, 581, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(710, 582, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(711, 583, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(712, 584, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(713, 585, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(715, 586, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(716, 587, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(717, 588, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(718, 589, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(719, 590, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(723, 591, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(728, 592, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(732, 593, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(736, 594, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(740, 595, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(741, 596, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(742, 597, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(744, 597, 'tree1', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(745, 597, 'tree2', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(746, 598, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(750, 599, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(751, 600, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(752, 601, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(754, 602, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(757, 603, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(758, 604, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(759, 605, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(760, 606, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(762, 608, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(764, 610, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(768, 613, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(770, 614, 'pr_crqsv_multi_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(771, 614, 'pr_crqsv_multi_qtree2', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(773, 615, 'pr_drqsm_pr_crqsv_one_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(775, 616, 'pr_drvsm_cr_qsv_one_qtree_anon_glob_ro', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(777, 617, 'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(778, 618, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(780, 619, 'pr_drvsm_one_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(782, 620, 'pr_drvsm_pr_crqsv_multi_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(783, 620, 'pr_drvsm_pr_crqsv_multi_qtree2', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(785, 621, 'pr_drvsm_pr_crqsv_one_qtree_vfilermms', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(787, 622, 'pr_only_multi_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(788, 622, 'pr_only_multi_qtree2', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(789, 623, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(791, 624, 'pr_only_one_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(792, 625, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(793, 626, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(796, 627, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(798, 628, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(800, 629, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(801, 630, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(802, 631, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(803, 632, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(804, 633, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(807, 636, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(809, 638, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(811, 640, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(812, 640, 'share1', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(814, 641, 'pr_crqsv_multi_qtree2_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(815, 641, 'pr_crqsv_multi_qtree_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(817, 642, 'pr_drqsm_pr_crqsv_one_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapmirrored', '2017-09-27 12:52:27', NULL),
	(819, 643, 'pr_drqsm_pr_crqsv_one_qtree_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(825, 646, 'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(832, 650, 'pr_drvsm_one_qtree', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(835, 651, 'pr_drvsm_pr_crqsv_multi_qtree2', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'normal', '2017-09-27 12:52:27', NULL),
	(837, 652, 'pr_drvsm_pr_crqsv_multi_qtree2_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(838, 652, 'pr_drvsm_pr_crqsv_multi_qtree_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(840, 653, 'pr_drvsm_pr_crqsv_one_qtree_vfilermms', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(843, 654, 'pr_drvsm_pr_crqsv_one_qtree_vfilermms_sv', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(844, 655, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(845, 656, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(846, 657, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(847, 658, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(848, 659, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(849, 660, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1703, 1702, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1756, 1749, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1757, 1750, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1758, 1750, 'q1', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1759, 1751, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1760, 1751, 'q1', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1761, 1752, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1762, 1752, 'q1_vfilerMMS', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1763, 1752, 'q2_vfiler0', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1764, 1753, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1765, 1754, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1837, 1836, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1952, 1888, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1954, 1889, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1956, 1890, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1958, 1891, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1960, 1892, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1962, 1893, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1965, 1894, 'parker_nfs_100', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'normal', '2017-09-27 12:52:27', NULL),
	(1966, 1895, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1968, 1896, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1970, 1897, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1972, 1898, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1974, 1899, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1976, 1900, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1978, 1901, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1980, 1902, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1982, 1903, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(1984, 1904, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1986, 1905, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1988, 1906, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1990, 1907, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1992, 1908, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1994, 1909, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1996, 1910, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(1998, 1911, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2000, 1912, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2002, 1913, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2004, 1914, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2006, 1915, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2008, 1916, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2010, 1917, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2012, 1918, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2014, 1919, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2016, 1920, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2018, 1921, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2283, 2280, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2285, 2281, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2287, 2282, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2288, 2282, 'mmstest_parker_pronly_prd', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2513, 2498, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2515, 2499, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2516, 2500, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2518, 2501, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2520, 2502, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2522, 2503, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2525, 2504, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2527, 2505, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2529, 2506, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2624, 2610, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2625, 2609, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2628, 2611, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2630, 2612, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2632, 2613, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2634, 2614, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2636, 2615, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2638, 2616, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2640, 2617, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2642, 2618, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2644, 2619, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2737, 2722, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2739, 2723, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2741, 2724, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2743, 2725, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2745, 2726, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2747, 2727, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2750, 2728, 'pr_drvsm_cr_qsv_one_qtree_anon_glob_ro_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(2752, 2729, 'pr_drvsm_cr_qsv_one_qtree_anon_glob_rw_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(2754, 2730, 'pr_drvsm_crqsv_no_qtree_sv', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'snapvaulted', '2017-09-27 12:52:27', NULL),
	(2857, 2842, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2858, 2842, 'mms_sub_payr107_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2859, 2843, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2861, 2844, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2863, 2845, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2865, 2846, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2867, 2847, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2868, 2847, 'mms_sub_payr101_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2968, 2953, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2970, 2954, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2972, 2955, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2973, 2955, 'mms_sub_pay209_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2974, 2956, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2976, 2957, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2978, 2958, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2979, 2958, 'mms_sub_pay210_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2980, 2959, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2981, 2959, 'parker_sub_test222_prd', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2982, 2960, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2984, 2961, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2986, 2962, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2988, 2963, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(2990, 2964, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(2991, 2964, 'mms_sub_pay302_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3117, 3102, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3118, 3102, 'mms_sub_pay312_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3119, 3103, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3121, 3104, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3123, 3105, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3125, 3106, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3127, 3107, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3129, 3108, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3130, 3108, 'mms_sub_pay322_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3131, 3109, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3132, 3109, 'mms_sub_pay323_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3133, 3110, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3134, 3110, 'mms_sub_pay325_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3135, 3111, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3136, 3111, 'mms_sub_pay326_prd', NULL, NULL, NULL, 'EXPLICIT', 'NTFS', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3137, 3112, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3139, 3113, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3141, 3114, '-', NULL, NULL, NULL, 'DEFAULT', 'NTFS', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3283, 3280, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3284, 3280, 'mms_sub_pay333_prd', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3285, 3281, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3316, 3313, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3317, 3313, 'mms_sub_pay335_prd_pay335', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3318, 3314, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3357, 3349, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3358, 3349, 'mms_sub_pay335null_prd_pay335null', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3363, 3352, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3420, 3412, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'READONLY', '2017-09-27 12:52:27', NULL),
	(3424, 3414, '-', NULL, NULL, NULL, 'DEFAULT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL),
	(3425, 3414, 'mouse_sub_delipeeps1004_prd_delipeeps1004', NULL, NULL, NULL, 'EXPLICIT', 'UNIX', 'NORMAL', '2017-09-27 12:52:27', NULL);
/*!40000 ALTER TABLE `qtree` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.replication
DROP TABLE IF EXISTS `replication`;
CREATE TABLE IF NOT EXISTS `replication` (
  `id` int(11) NOT NULL,
  `migration_cutover_src_to_tgt_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `src_mirror_aggregate_name` varchar(255) DEFAULT NULL,
  `src_mirror_controller_name` varchar(255) DEFAULT NULL,
  `src_mirror_data_center_name` varchar(255) DEFAULT NULL,
  `src_mirror_qtree_name` varchar(255) DEFAULT NULL,
  `src_mirror_volume_name` varchar(255) DEFAULT NULL,
  `src_prod_data_center_name` varchar(255) DEFAULT NULL,
  `src_vault_aggregate_name` varchar(255) DEFAULT NULL,
  `src_vault_controller_name` varchar(255) DEFAULT NULL,
  `src_vault_data_center_name` varchar(255) DEFAULT NULL,
  `src_vault_qtree_name` varchar(255) DEFAULT NULL,
  `src_vault_volume_name` varchar(255) DEFAULT NULL,
  `tgt_mirror_aggregate_id` int(11) DEFAULT NULL,
  `tgt_mirror_data_center_id` int(11) DEFAULT NULL,
  `tgt_mirror_storage_id` int(11) DEFAULT NULL,
  `tgt_vault_aggregate_id` int(11) DEFAULT NULL,
  `tgt_vault_data_center_id` int(11) DEFAULT NULL,
  `tgt_vault_storage_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`migration_cutover_src_to_tgt_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.replication: ~0 rows (approximately)
/*!40000 ALTER TABLE `replication` DISABLE KEYS */;
/*!40000 ALTER TABLE `replication` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.schedule
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE IF NOT EXISTS `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Schedule',
  `week_date` date NOT NULL DEFAULT '1900-01-01',
  `schedule_status` varchar(45) DEFAULT 'Open',
  `migration_limit` int(11) DEFAULT NULL,
  `migration_pending` int(11) DEFAULT NULL,
  `migration_booked` int(11) DEFAULT NULL,
  `host_connection_limit` int(11) DEFAULT 0,
  `host_connection_booked` int(11) NOT NULL DEFAULT 0,
  `host_connection_pending` int(11) DEFAULT 0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.schedule: ~53 rows (approximately)
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` (`id`, `week_date`, `schedule_status`, `migration_limit`, `migration_pending`, `migration_booked`, `host_connection_limit`, `host_connection_booked`, `host_connection_pending`, `create_time`, `update_time`) VALUES
	(1, '2017-01-02', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(2, '2017-01-09', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(3, '2017-01-16', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(4, '2017-01-23', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(5, '2017-01-30', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(6, '2017-02-06', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(7, '2017-02-13', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(8, '2017-02-20', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(9, '2017-02-27', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(10, '2017-03-06', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(11, '2017-03-13', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(12, '2017-03-20', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(13, '2017-03-27', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(14, '2017-04-03', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(15, '2017-04-10', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(16, '2017-04-17', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(17, '2017-04-24', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(18, '2017-05-01', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(19, '2017-05-08', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(20, '2017-05-15', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(21, '2017-05-22', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(22, '2017-05-29', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(23, '2017-06-05', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(24, '2017-06-12', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(25, '2017-06-19', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(26, '2017-06-26', 'Closed', 30, 0, 30, 1000, 4, 0, '2017-09-27 12:52:27', NULL),
	(27, '2017-07-03', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(28, '2017-07-10', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(29, '2017-07-17', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(30, '2017-07-24', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(31, '2017-07-31', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(32, '2017-08-07', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(33, '2017-08-14', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(34, '2017-08-21', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(35, '2017-08-28', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(36, '2017-09-04', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(37, '2017-09-11', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(38, '2017-09-18', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(39, '2017-09-25', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(40, '2017-10-02', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(41, '2017-10-09', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(42, '2017-10-16', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(43, '2017-10-23', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(44, '2017-10-30', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(45, '2017-11-06', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(46, '2017-11-13', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(47, '2017-11-20', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(48, '2017-11-27', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(49, '2017-12-04', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(50, '2017-12-11', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(51, '2017-12-18', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(52, '2017-12-25', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL),
	(53, '2018-01-01', 'Open', 30, 0, 0, 1000, 0, 0, '2017-09-27 12:52:27', NULL);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.schedule_reset
DROP TABLE IF EXISTS `schedule_reset`;
CREATE TABLE IF NOT EXISTS `schedule_reset` (
  `id` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `host_count` int(11) DEFAULT NULL,
  `jsession_id` varchar(255) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_corporate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.schedule_reset: ~0 rows (approximately)
/*!40000 ALTER TABLE `schedule_reset` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_reset` ENABLE KEYS */;
<<<<<<< HEAD

-- Dumping structure for table vitae_data_refactor.schema_version
DROP TABLE IF EXISTS `schema_version`;
CREATE TABLE IF NOT EXISTS `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `checksum` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL,
  `installed_by` varchar(255) DEFAULT NULL,
  `installed_on` datetime DEFAULT NULL,
  `script` varchar(255) DEFAULT NULL,
  `success` tinyint(4) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`installed_rank`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.schema_version: ~0 rows (approximately)
/*!40000 ALTER TABLE `schema_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `schema_version` ENABLE KEYS */;
=======
UNLOCK TABLES;



--
-- Table structure for table `share`
--
>>>>>>> b_models_repos

-- Dumping structure for table vitae_data_refactor.share
DROP TABLE IF EXISTS `share`;
CREATE TABLE IF NOT EXISTS `share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `owner_user_corporate_id` int(11) DEFAULT NULL,
  `qtree_id` int(11) DEFAULT NULL,
  `share_name` varchar(255) DEFAULT NULL,
  `share_type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`host_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.share: ~0 rows (approximately)
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
/*!40000 ALTER TABLE `share` ENABLE KEYS */;

-- Dumping structure for procedure vitae_data_refactor.sp_activity_migrate
DROP PROCEDURE IF EXISTS `sp_activity_migrate`;
DELIMITER //
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

END//
DELIMITER ;

-- Dumping structure for table vitae_data_refactor.storage
DROP TABLE IF EXISTS `storage`;
CREATE TABLE IF NOT EXISTS `storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID of the Storage. This is not a Surrogate!',
  `storage_name` varchar(255) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `microcode_version` varchar(255) DEFAULT NULL,
  `raw_capacity_mb` bigint(20) DEFAULT NULL,
  `work_package_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `storage_name_idx` (`storage_name`),
  KEY `fk_storage_work_package1_idx` (`work_package_id`),
  CONSTRAINT `fk_storage_work_package1` FOREIGN KEY (`work_package_id`) REFERENCES `work_package` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.storage: ~3 rows (approximately)
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` (`id`, `storage_name`, `model`, `family`, `manufacturer`, `microcode_version`, `raw_capacity_mb`, `work_package_id`, `create_time`, `update_time`) VALUES
	(17, 'fspodrtp03.rdc.lab', 'FAS3270', 'FAS3200', 'NetApp', '8.2.4P1 clustered Data ONTAP', 48535982, 1, '2017-09-27 12:52:27', '2018-01-19 12:12:09'),
	(18, 'fspodrtp04.rdc.lab', 'FAS3270', 'FAS3200', 'NetApp', '8.3.1P1 clustered Data ONTAP', 102302404, 1, '2017-09-27 12:52:27', '2018-01-19 12:12:11'),
	(41, '7GN1-RTPRDC,7GN2-RTPRDC', 'FAS3140', 'FAS3100', 'NetApp', '8.2.4P6 7-Mode', 17782053, 1, '2017-09-27 12:52:27', '2018-01-19 12:12:13');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.storagex
DROP TABLE IF EXISTS `storagex`;
CREATE TABLE IF NOT EXISTS `storagex` (
  `id` int(11) NOT NULL,
  `migration_cutover_event_id` int(11) NOT NULL,
  `completed` tinyint(4) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `policy_name` varchar(255) DEFAULT NULL,
  `source_path` varchar(255) DEFAULT NULL,
  `submitted` tinyint(4) NOT NULL,
  `target_path` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`migration_cutover_event_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.storagex: ~0 rows (approximately)
/*!40000 ALTER TABLE `storagex` DISABLE KEYS */;
/*!40000 ALTER TABLE `storagex` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.system_admin
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE IF NOT EXISTS `system_admin` (
  `id` int(11) NOT NULL,
  `user_corporate_id` int(11) NOT NULL,
  `contact_type` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `mailing_list` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `system_admin` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`user_corporate_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.system_admin: ~0 rows (approximately)
/*!40000 ALTER TABLE `system_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_admin` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.user_api
DROP TABLE IF EXISTS `user_api`;
CREATE TABLE IF NOT EXISTS `user_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `enabled` tinyint(4) NOT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.user_api: ~1 rows (approximately)
/*!40000 ALTER TABLE `user_api` DISABLE KEYS */;
INSERT INTO `user_api` (`id`, `client_id`, `client_secret`, `create_time`, `enabled`, `purpose`, `update_time`) VALUES
	(1, 'talend', '$2a$04$J/B4Okg/BkF35D0fcPpo1OdzFWd5sPuh39SaGKi5ByrK7L7m9QBVe', '2018-01-19 11:52:54', 1, 'For Talend integration', '2018-01-19 11:55:23');
/*!40000 ALTER TABLE `user_api` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.user_corporate
DROP TABLE IF EXISTS `user_corporate`;
CREATE TABLE IF NOT EXISTS `user_corporate` (
  `id` int(11) NOT NULL,
  `best_phone` varchar(255) DEFAULT NULL,
  `cost_center` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `manager_user_corporate_id` int(11) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `timezone` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `work_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.user_corporate: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_corporate` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_corporate` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.user_native
DROP TABLE IF EXISTS `user_native`;
CREATE TABLE IF NOT EXISTS `user_native` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User - Native.',
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `user_name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 0,
  `user_role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_idx` (`user_name`),
  KEY `user_role_id_idx` (`user_role_id`),
  CONSTRAINT `FK_user_native_user_roles` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  AUTO_INCREMENT=192 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.user_native: ~16 rows (approximately)
/*!40000 ALTER TABLE `user_native` DISABLE KEYS */;
INSERT INTO `user_native` (`id`, `first_name`, `last_name`, `user_name`, `email`, `password`, `salt`, `enabled`, `user_role_id`, `create_time`, `update_time`) VALUES
	(1, 'John', 'Doe', 'jdoe', 'jdoe@corp.com', '$2a$04$9/d4IvU5Qt.MeVgdDUC8t.OdoZUTchzW0fSK3pcgs8feObhOaTzP.', NULL, 1, 1, '2018-01-18 15:12:20', '2018-01-18 15:14:20'),
	(2, 'Mohan', 'Bondada', 'mbondada', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(3, 'Mohan1', 'Bondada', 'mbondada28', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(4, 'Mohan2', 'Bondada', 'mbondada29', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(5, 'Mohan', 'Bondada', 'mbondada4', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(6, 'Mohan1', 'Bondada', 'mbondada36', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(7, 'Mohan2', 'Bondada', 'mbondada37', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 1, NULL, NULL),
	(8, 'Mohan2', 'Bondada', 'mbondada38', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(9, 'Mohan4', 'Bondada', 'mbondada39', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 3, NULL, NULL),
	(10, 'Mohan2', 'Bondada', 'mbondada40', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 4, NULL, NULL),
	(11, 'Mohan2', 'Bondada', 'mbondada41', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 5, NULL, NULL),
	(157, 'Mohan2', 'Bondada', 'mbondada42', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 1, NULL, NULL),
	(158, 'Mohan2', 'Bondada', 'mbondada43', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 2, NULL, NULL),
	(159, 'Mohan4', 'Bondada', 'mbondada44', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 3, NULL, NULL),
	(160, 'Mohan2', 'Bondada', 'mbondada45', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 4, NULL, NULL),
	(161, 'Mohan2', 'Bondada', 'mbondada46', 'mbondada@consultparagon.com', 'Paragon123', NULL, 0, 5, NULL, NULL);
/*!40000 ALTER TABLE `user_native` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the User Role.',
  `user_role` varchar(30) NOT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)  AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.user_roles: ~5 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`, `user_role`, `create_time`, `update_time`) VALUES
	(1, 'ROLE_USER', '2017-09-27 12:52:27', NULL),
	(2, 'ROLE_ADMIN', '2017-09-27 12:52:27', NULL),
	(3, 'ROLE_RUSER', '2017-09-27 12:52:27', NULL),
	(4, 'ROLE_SUPERUSER', '2017-09-27 12:52:27', NULL),
	(5, 'ROLE_MSLEAD', '2017-09-27 12:52:27', NULL);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

-- Dumping structure for procedure vitae_data_refactor.vitae_update
DROP PROCEDURE IF EXISTS `vitae_update`;
DELIMITER //
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

END//
DELIMITER ;

-- Dumping structure for table vitae_data_refactor.wfa_data
DROP TABLE IF EXISTS `wfa_data`;
CREATE TABLE IF NOT EXISTS `wfa_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the WFA Data',
  `workflow_id` int(11) NOT NULL,
  `region` varchar(24) DEFAULT NULL,
  `protocol` varchar(20) DEFAULT NULL,
  `purpose` varchar(24) DEFAULT NULL,
  `nfs_export_rules` varchar(10) DEFAULT NULL,
  `dominant_protocol` varchar(10) DEFAULT NULL,
  `migrationTarget` tinyint(1) DEFAULT 1,
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
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`workflow_id`),
  KEY `workflowId_idx` (`workflow_id`),
  CONSTRAINT `workflowId` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.wfa_data: ~0 rows (approximately)
/*!40000 ALTER TABLE `wfa_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_data` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.wfa_message
DROP TABLE IF EXISTS `wfa_message`;
CREATE TABLE IF NOT EXISTS `wfa_message` (
  `id` int(11) NOT NULL,
  `workflow_id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `meaning` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`workflow_id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.wfa_message: ~0 rows (approximately)
/*!40000 ALTER TABLE `wfa_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_message` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.wfa_ocum_controller_data
DROP TABLE IF EXISTS `wfa_ocum_controller_data`;
CREATE TABLE IF NOT EXISTS `wfa_ocum_controller_data` (
  `id` int(11) NOT NULL,
  `controller_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ocum_controller_name` varchar(255) DEFAULT NULL,
  `ocum_controller_serial_number` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.wfa_ocum_controller_data: ~0 rows (approximately)
/*!40000 ALTER TABLE `wfa_ocum_controller_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wfa_ocum_controller_data` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.workflow
DROP TABLE IF EXISTS `workflow`;
CREATE TABLE IF NOT EXISTS `workflow` (
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
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`,`migration_cutover_src_to_tgt_id`,`migration_cutover_src_to_tgt_migration_cutover_event_id`),
  UNIQUE KEY `wfa_job_id_idx` (`wfa_job_id`),
  KEY `fk_workflow_migration_cutover_src_to_tgt1_idx` (`migration_cutover_src_to_tgt_id`,`migration_cutover_src_to_tgt_migration_cutover_event_id`),
  CONSTRAINT `FKsjax6wnkco9f4myn3plai6sa6` FOREIGN KEY (`migration_cutover_src_to_tgt_id`, `migration_cutover_src_to_tgt_migration_cutover_event_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`, `migration_cutover_event_id`),
  CONSTRAINT `fk_workflow_migration_cutover_src_to_tgt1` FOREIGN KEY (`migration_cutover_src_to_tgt_id`, `migration_cutover_src_to_tgt_migration_cutover_event_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`, `migration_cutover_event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.workflow: ~0 rows (approximately)
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;

-- Dumping structure for table vitae_data_refactor.work_package
DROP TABLE IF EXISTS `work_package`;
CREATE TABLE IF NOT EXISTS `work_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate ID of the Work Package',
  `work_package_name` varchar(255) NOT NULL,
  `asset_number` varchar(60) DEFAULT NULL,
  `controller_installed_date` date NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `processed` tinyint(1) DEFAULT 0,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table vitae_data_refactor.work_package: ~2 rows (approximately)
/*!40000 ALTER TABLE `work_package` DISABLE KEYS */;
INSERT INTO `work_package` (`id`, `work_package_name`, `asset_number`, `controller_installed_date`, `priority`, `processed`, `create_time`, `update_time`) VALUES
	(1, 'QA1', 'Z00000', '1999-01-24', 1, 1, '2017-09-27 12:52:28', NULL),
	(2, 'QA1', 'Z00000', '1999-01-24', 1, 1, '2017-09-27 12:52:28', NULL);
/*!40000 ALTER TABLE `work_package` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
