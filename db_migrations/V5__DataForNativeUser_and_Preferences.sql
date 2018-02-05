ALTER TABLE `user_native` AUTO_INCREMENT = 1;
INSERT INTO `user_native`  (`email`, `password`, `first_name`, `last_name`, `user_name`,`enabled`) VALUES ('jdoe@corp.com', '$2a$04$oSWA81OzAMQfHh9q5m3iJurx9L4HGHimPzEaHqcONA9VNBFj6joc6', 'Joe', 'Doe','sparky', 1);
INSERT INTO `user_native`  (`email`, `password`, `first_name`, `last_name`, `user_name`,`enabled`) VALUES ('jdoe2@corp.com', '$2a$04$oSWA81OzAMQfHh9q5m3iJurx9L4HGHimPzEaHqcONA9VNBFj6joc6', 'James', 'Do','dog', 1);

INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `created_on`, `updated_on`) VALUES (2, 'UserListing', 'USER', NULL, NULL);

INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (2, 2, NULL, 1, 'firstName', 2, '0', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (6, 2, NULL, 1, 'active', 2, '1', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, 2, NULL, 1, 'lastName', 2, '1', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (4, 2, NULL, 1, 'userName', 1, '0', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (5, 2, NULL, 1, 'email', 1, '1', NULL, NULL);


INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `created_on`, `updated_on`) VALUES (3, 'UserListing', 'SYSTEM', NULL, NULL);

INSERT INTO `preference_detail` ( `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, NULL, 1, 'firstName', 2, '0', NULL, NULL);
INSERT INTO `preference_detail` ( `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, NULL, 1, 'active', 2, '1', NULL, NULL);
INSERT INTO `preference_detail` ( `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, NULL, 1, 'lastName', 2, '1', NULL, NULL);
INSERT INTO `preference_detail` ( `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, NULL, 1, 'userName', 1, '0', NULL, NULL);
INSERT INTO `preference_detail` ( `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, NULL, 1, 'email', 1, '1', NULL, NULL);