CREATE TABLE `preference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_name` varchar(255) DEFAULT NULL,
  `preference_type` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `preference_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `preference_id` int(11) DEFAULT NULL,
  `corp_user_id` int(11) DEFAULT NULL,
  `native_user_id` int(11) DEFAULT NULL,
  `field_name` varchar(255) DEFAULT NULL,
  `field_order` int(11) DEFAULT NULL,
  `field_visible` varchar(255) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,  
  PRIMARY KEY (`id`),
  KEY `fk_preference_detail_preference` (`preference_id`),
  CONSTRAINT `fk_preference_detail_preference` FOREIGN KEY (`preference_id`) REFERENCES `preference` (`id`)
);