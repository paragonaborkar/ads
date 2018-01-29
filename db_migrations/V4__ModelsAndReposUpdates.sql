SET FOREIGN_KEY_CHECKS=0;

/*ALTER TABLE `sys_config` DROP INDEX `prop_env_id`, ADD UNIQUE INDEX `prop_env_id` (`property_name`);*/
ALTER TABLE `user_api` CHANGE `key` `client_id` VARCHAR(45);
ALTER TABLE `user_api` CHANGE `secret` `client_secret` VARCHAR(45);
ALTER TABLE `user_api` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);
ALTER TABLE `sys_config_property_type` CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `wfa_ocum_controller_data` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);
ALTER TABLE `mst_email_type` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);
ALTER TABLE `migration_time` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);
ALTER TABLE `controller` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);
ALTER TABLE `aggregate` DROP PRIMARY KEY, CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT, ADD PRIMARY KEY(`id`);


ALTER TABLE `activity` DROP FOREIGN KEY `fk_activity_activity_lob_x_ref1`;
ALTER TABLE `activity` DROP FOREIGN KEY `fk_activity_activity_migration_key_x_ref1`;
ALTER TABLE `activity` DROP FOREIGN KEY `fk_activity_activity_presumed_lob_x_ref1`;
ALTER TABLE `activity` DROP KEY `id_UNIQUE`;

ALTER TABLE `line_of_business` DROP FOREIGN KEY `fk_line_of_business_activity_lob_x_ref1`;
ALTER TABLE `line_of_business` DROP FOREIGN KEY `fk_line_of_business_activity_presumed_lob_x_ref1`;
ALTER TABLE `line_of_business` DROP FOREIGN KEY `fk_line_of_business_application_lob_x_ref1`;
ALTER TABLE `line_of_business` DROP FOREIGN KEY `fk_line_of_business_exports1`;

ALTER TABLE `activity_lob_x_ref` ADD CONSTRAINT `fk_actvitiy_lob_xref_line_of_business1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `activity_lob_x_ref` ADD CONSTRAINT `fk_activity_lob_xref_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `activity_presumed_lob_x_ref` ADD CONSTRAINT `fk_activity_presumed_lob_x_ref_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `activity_presumed_lob_x_ref` ADD CONSTRAINT `fk_activity_presumed_lob_x_ref_activity1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `application_lob_x_ref` ADD CONSTRAINT `fk_application_lob_x_ref_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `application_lob_x_ref` ADD CONSTRAINT `fk_application_lob_x_ref_application1` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `exports` ADD CONSTRAINT `fk_exports_lob1` FOREIGN KEY (`lob_id`) REFERENCES `line_of_business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `application` DROP FOREIGN KEY `fk_application_application_lob_x_ref1`;
ALTER TABLE `application` DROP FOREIGN KEY `fk_application_host_application_x_ref1`;
ALTER TABLE `host_application_x_ref` ADD CONSTRAINT `fk_host_application_x_ref_host1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `host_application_x_ref` ADD CONSTRAINT `fk_host_application_x_ref_application1` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `activity` CHANGE COLUMN `create_time` `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `activity_response` CHANGE COLUMN `create_time` `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `aggregate_purpose` CHANGE COLUMN `create_time` `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE `controller` DROP KEY `fk_exports_id`, ADD CONSTRAINT `fk_exports_id` FOREIGN KEY (`exports_id`) REFERENCES `exports` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `exports` DROP FOREIGN KEY `fk_exports_controller1`;
ALTER TABLE `exports` DROP FOREIGN KEY `fk_exports_exports_host_x_ref1`;
ALTER TABLE `exports_host_x_ref` ADD CONSTRAINT `fk_export_host_x_ref_exports1` FOREIGN KEY (`exports_id`) REFERENCES `exports` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT, ADD CONSTRAINT `fk_export_host_x_ref_host1` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `host` DROP FOREIGN KEY `fk_host_exports_host_x_ref1`;
ALTER TABLE `host` DROP FOREIGN KEY `fk_host_host_application_x_ref1`;

ALTER TABLE `migration_cutover_src_to_tgt` DROP FOREIGN KEY `fk_migration_cutover_src_to_tgt_migration_cutover_team`;
ALTER TABLE `migration_cutover_team` ADD CONSTRAINT `fk_migration_cutover_team_migration_cutover_src_to_tgt` FOREIGN KEY (`migration_cutover_src_to_tgt_id`) REFERENCES `migration_cutover_src_to_tgt` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `migration_key` DROP FOREIGN KEY `fk_migration_key_activity_migration_key_x_ref1`;
ALTER TABLE `activity_migration_key_x_ref` ADD CONSTRAINT `fk_activity_migration_key_x_ref_migration_key1` FOREIGN KEY (`migration_key_id`) REFERENCES `migration_key` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `user_roles` DROP FOREIGN KEY `fk_user_roles_user_native1`;
ALTER TABLE `user_native`  ADD CONSTRAINT `fk_user_native_user_role1` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `activity_migration_key_x_ref`  ADD CONSTRAINT `fk_activity_migration_key_x_ref_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `user_corporate` CHANGE costCenter cost_center varchar(100);
ALTER TABLE `wfa_data` CHANGE migrationTarget migration_target TINYINT(1) DEFAULT 1;

/******************* Missing Foreign Keys in migrationCutoverEvents ***********************/

ALTER TABLE `activity_response` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `activity_id`);
ALTER TABLE `aggregate_purpose` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `aggregate_id`);
ALTER TABLE `audit_reason_code` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `audit_event_id`);
ALTER TABLE `audit_trail_api` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `audit_event_id`);
ALTER TABLE `audit_trail_corporate_user` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `audit_event_id`);
ALTER TABLE `audit_trail_native_user` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `audit_event_id`);
ALTER TABLE `change_management` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_event_id`);
ALTER TABLE `cutover` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `schedule_id`);
ALTER TABLE `cutover_assembly` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `cutover_id`);
ALTER TABLE `cutover_time` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `cutover_assembly_id`);
ALTER TABLE `ical` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_event_id`);
ALTER TABLE `migration_cutover_src_to_tgt` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_event_id`);
ALTER TABLE `mount_point` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `host_id`);
ALTER TABLE `mst_emailing_date` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `email_type_id`);
ALTER TABLE `nas_volume` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `aggregate_id`, `controlled_id`);
ALTER TABLE `qtree` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `nas_volume_id`);
ALTER TABLE `replication` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_src_to_tgt_id`);
ALTER TABLE `share` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `host_id`);
ALTER TABLE `storagex` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_event_id`);
ALTER TABLE `system_admin` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `system_admin`);
ALTER TABLE `wfa_data` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `workflow_id`);
ALTER TABLE `wfa_message` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `workflow_id`);
ALTER TABLE `workflow` DROP PRIMARY KEY, ADD PRIMARY KEY(`id`), ADD CONSTRAINT uc_primary UNIQUE (`id`, `migration_cutover_src_to_tgt_id`, `migration_cutover_src_to_tgt_migration_cutover_event_id`);
ALTER TABLE `workflow` DROP INDEX `fk_workflow_migration_cutover_src_to_tgt1_idx`;

SET FOREIGN_KEY_CHECKS=1;
