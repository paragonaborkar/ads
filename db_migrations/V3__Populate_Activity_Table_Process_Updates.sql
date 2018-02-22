ALTER TABLE `host` ADD COLUMN `resolver` VARCHAR(60) NULL AFTER `system_admin_id`;




INSERT INTO `ads_dev`.`share` (`id`, `qtree_id`, `share_name`, `host_id`) VALUES ('1', '768', 'test1', '1');
INSERT INTO `ads_dev`.`share` (`id`, `qtree_id`, `share_name`, `host_id`) VALUES ('2', '800', 'test2', '2');


select count(*) from share s

JOIN qtree
	ON qtree.id = s.qtree_id
	
JOIN nas_volume
	ON qtree.nas_volume_id = nas_volume.id
		
