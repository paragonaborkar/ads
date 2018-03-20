
INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (2, 'UserListing', 'USER', 0, 1);
INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (3, 'UserListing', 'SYSTEM', 0, 0);
INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (4, 'SysPropListing', 'SYSTEM', '0', 0);

INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (5, 'OwnerListing', 'SYSTEM', '0', 0);

INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (6, 'ControllerReleaseListing', 'SYSTEM', 0, 0);
INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `corp_user_id`, `native_user_id`) VALUES (7, 'ControllerTargetListing', 'SYSTEM', 0, 0);



INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (2,  'firstName', 2, '0');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`, `field_template`) VALUES (2,  'enabled', 2, '1', 'yesNo');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (2,  'lastName', 2, '1');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (2,  'userName', 1, '0');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (2,  'email', 1, '1');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (2,  'userRole', 1, '1');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (3,  'firstName', 2, '0');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`, `field_template`) VALUES (2,  'enabled', 2, '1', 'yesNo');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (3,  'lastName', 2, '1');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (3,  'userName', 1, '0');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (3,  'email', 1, '1');
INSERT INTO `preference_detail` ( `preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (3,  'userRole', 1, '1');

INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_visible`, `field_template`) VALUES (4, 'propertyName', '1', 1, 'stringEdit');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_visible`, `field_template`) VALUES (4, 'propertyValue', '1', 1, 'stringEdit');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_visible`) VALUES (4, 'grouping', '1', 1);
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (4, 'Source Controller', '1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (4, 'tgtControllerId', '1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (4, 'processed', '1');

# ALTER TABLE `preference_detail`	ADD COLUMN `field_prop` VARCHAR(50) NULL DEFAULT NULL AFTER `field_name`;

#INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES ('4', 'propertyName', '1');
#INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES ('4', 'propertyValue', '1');
#INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES ('4', 'grouping', '1');

INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_prop`, `field_template`, `field_order`) VALUES (5, 'Last Accessed', 'qtree.lastAccessed', 'dateTime', '2');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_prop`, `field_template`, `field_order`) VALUES (5, 'Qtree Name', 'qtree.qtreeName','','1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_prop`, `field_template`, `field_order`) VALUES (5, 'Share Count', 'shares.length','','3');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_prop`, `field_template`, `field_order`) VALUES (5, 'Volume Name', 'nasVolume.volumeName','','1');


INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_prop`) VALUES (6, 'Source Controller', '1', 'srcController.controllerName');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_prop`) VALUES (6, 'Target Controller', '1', 'tgtController.controllerName');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_template`) VALUES (6, 'processed', '1', 'yesNo');



INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_prop`) VALUES (7, 'Controller', '1', 'controller.controllerName');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (7, 'workPackageName', '1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_prop`, `field_template`) VALUES (7, 'Installed Date', '1', 'controllerInstalledDate', 'date');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (7, 'priority', '1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_template`) VALUES (7, 'processed', '1', 'yesNo');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`) VALUES (7, 'assetNumber', '1');
INSERT INTO `preference_detail` (`preference_id`, `field_name`, `field_order`, `field_template`) VALUES (7, 'createTime', '1', 'dateTime');