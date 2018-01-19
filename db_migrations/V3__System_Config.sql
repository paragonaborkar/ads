ALTER TABLE `mms_config` RENAME TO  `sys_config`;
ALTER TABLE `mms_property_type` RENAME TO  `sys_config_property_type`;

ALTER TABLE `sys_config` DROP INDEX `prop_env_id`;
ALTER TABLE `sys_config` DROP COLUMN `environment_name` ;
ALTER TABLE `sys_config` DROP COLUMN `component_name` ;
ALTER TABLE `sys_config` DROP COLUMN `subcomponent_name` ;
ALTER TABLE `sys_config` DROP COLUMN `expiration` ;

ALTER TABLE `sys_config` DROP COLUMN `last_update_user` ;
ALTER TABLE `sys_config` DROP COLUMN `last_updated_ts` ;
ALTER TABLE `sys_config` DROP COLUMN `create_time` ;
ALTER TABLE `sys_config` DROP COLUMN `update_time` ;

ALTER TABLE `sys_config_property_type` DROP COLUMN `create_time` ;
ALTER TABLE `sys_config_property_type` DROP COLUMN `update_time` ;

ALTER TABLE `sys_config`  ADD COLUMN `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `sys_config`  ADD COLUMN `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE `sys_config_property_type`  ADD COLUMN `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `sys_config_property_type`  ADD COLUMN `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP;