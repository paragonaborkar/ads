ALTER TABLE `host` ADD COLUMN `resolver` VARCHAR(60) NULL AFTER `system_admin_id`;




INSERT INTO `ads_dev`.`share` (`id`, `qtree_id`, `share_name`, `host_id`) VALUES ('1', '768', 'test1', '1');
INSERT INTO `ads_dev`.`share` (`id`, `qtree_id`, `share_name`, `host_id`) VALUES ('2', '800', 'test2', '2');

