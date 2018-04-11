USE dwh_inventory;

CREATE TABLE IF NOT EXISTS `dwh_inventory`.`hhcc_nfs_host_conn` (
	`shareId` INT(11) NOT NULL,
	`intVolId` INT(11) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`protocol` VARCHAR(48),
	`hostId` INT(11) NOT NULL DEFAULT 0,
	`firstSeen` DATETIME NOT NULL,
	`lastSeen` DATETIME NOT NULL,
	PRIMARY KEY (`shareId`,`hostId`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = latin1;

USE dwh_inventory;

DELIMITER $$

CREATE PROCEDURE hhccNfsHostConnUpdate()
	BEGIN
		INSERT INTO dwh_inventory.wcr_nfs_host_conn
		(`shareId`,`intVolId`,`name`,`protocol`,`hostId`,`firstSeen`,`lastSeen`)
		SELECT 
			dwh_inventory.nas_share.id,
			dwh_inventory.internal_volume.id,
			dwh_inventory.nas_share.name,
			dwh_inventory.nas_share.protocol,
			IF(dwh_inventory.host.id IS NULL,NULL,dwh_inventory.host.id),
			IF(dwh_inventory.host.id IS NULL,NULL,NOW()),
			IF(dwh_inventory.host.id IS NULL,NULL,NOW())
    
		FROM dwh_inventory.nas_share

			JOIN dwh_inventory.nas_file_share 
				ON dwh_inventory.nas_file_share.id = dwh_inventory.nas_share.fileshareid
            
			JOIN dwh_inventory.internal_volume 
				ON dwh_inventory.internal_volume.id = dwh_inventory.nas_file_share.internalvolumeid
        
			JOIN dwh_inventory.nas_logical 
				ON dwh_inventory.nas_share.id = dwh_inventory.nas_logical.shareid
        
			JOIN dwh_inventory.host 
				ON dwh_inventory.nas_logical.hostId = dwh_inventory.host.id
			
			WHERE  dwh_inventory.nas_share.protocol = 'NFS'

        
		ON DUPLICATE KEY UPDATE dwh_inventory.wcr_nfs_host_conn.lastSeen=NOW() ;
	END$$
    
DELIMITER ;

/*set GLOBAL event_scheduler = ON;*/

DELIMITER $$

CREATE EVENT IF NOT EXISTS hhccNfsHostConnUpdateSched
	ON SCHEDULE 
    EVERY 1 DAY
    STARTS STR_TO_DATE( DATE_FORMAT(NOW(), '%Y%m%d 2340'), '%Y%m%d %H%i') + INTERVAL 1 DAY
    
    DO CALL dwh_inventory.hhccNfsHostConnUpdate();
	
$$

DELIMITER ;
        
	