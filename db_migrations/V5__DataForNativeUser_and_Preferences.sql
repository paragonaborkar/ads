UPDATE `ads`.`user_native` SET `email`='jdoe@corp.com', `password`='$2a$04$oSWA81OzAMQfHh9q5m3iJurx9L4HGHimPzEaHqcONA9VNBFj6joc6' WHERE  `id`=1;
UPDATE `ads`.`user_native` SET `first_name`='Joe', `last_name`='Doe' WHERE  `id`=1;

INSERT INTO `preference` (`id`, `page_name`, `preference_type`, `created_on`, `updated_on`) VALUES (2, 'UserListing', 'USER', NULL, NULL);

INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (2, 2, NULL, 1, 'firstName', 3, '1', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (3, 2, NULL, 1, 'lastName', 1, '1', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (4, 2, NULL, 1, 'userName', 2, '1', NULL, NULL);
INSERT INTO `preference_detail` (`id`, `preference_id`, `corp_user_id`, `native_user_id`, `field_name`, `field_order`, `field_visible`, `updated_on`, `created_on`) VALUES (5, 2, NULL, 1, 'email', 4, '1', NULL, NULL);
