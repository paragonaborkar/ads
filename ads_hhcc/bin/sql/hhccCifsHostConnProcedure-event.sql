USE dwh_inventory;
# Updated due to error: Error Code: 1171. All parts of a PRIMARY KEY must be NOT NULL; if you need NULL in a key, use UNIQUE instead
CREATE TABLE IF NOT EXISTS `dwh_inventory`.`hhcc_cifs_temp` (
  `DateTime` varchar(255) NOT NULL DEFAULT '',
  `ControllerName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) NOT NULL DEFAULT '',
  `VfilerName` varchar(255) DEFAULT NULL,
  `VfilerUuid` varchar(255) NOT NULL DEFAULT '',
  `VolumeName` varchar(255) NOT NULL DEFAULT '',
  `ShareName` varchar(255) NOT NULL DEFAULT '',
  `MountPoint` varchar(255) DEFAULT NULL,
  `HostIp` varchar(255) NOT NULL DEFAULT '',
  `HostName` varchar(255) NOT NULL DEFAULT '',
  `WindowsUser` varchar(255) NOT NULL DEFAULT '',
  `UnixUser` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DateTime`,`SerialNumber`,`VfilerUuid`,`ShareName`,`HostIp`, `HostName`,`WindowsUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Updated due to error: Error Code: 1171. All parts of a PRIMARY KEY must be NOT NULL; if you need NULL in a key, use UNIQUE instead
CREATE TABLE IF NOT EXISTS `dwh_inventory`.`hhcc_cifs_host_conn` (
	`nodeId` INT(11) NOT NULL,
	`shareId` INT(11) NOT NULL,
	`intVolId` INT(11) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`qtreeId` INT(11) NOT NULL,
	`protocol` VARCHAR(48),
    `hostName` varchar(255) NOT NULL DEFAULT '',
	`ip` varchar(255) NOT NULL DEFAULT '',
	`windowsUser` varchar(255) NOT NULL DEFAULT '',
	`firstSeen` DATETIME NOT NULL,
	`lastSeen` DATETIME NOT NULL,
	PRIMARY KEY (`shareId`,`hostName`,`windowsUser`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = latin1;
    
USE dwh_inventory;

ALTER TABLE dwh_inventory.nas_share
  ADD INDEX idx_nas_share_name (name);

DROP PROCEDURE IF EXISTS hhccCIFSHostConnUpdate ;

DELIMITER $$

CREATE PROCEDURE hhccCIFSHostConnUpdate()
	BEGIN
    UPDATE dwh_inventory.hhcc_cifs_temp
      SET dwh_inventory.hhcc_cifs_temp.ShareName = CONCAT(dwh_inventory.hhcc_cifs_temp.ShareName,'/')
    ;
    
		INSERT INTO dwh_inventory.hhcc_cifs_host_conn
		(`nodeId`,`intVolId`,`shareId`,`name`,`qtreeId`,`protocol`,`hostName`,`ip`,`windowsUser`,`firstSeen`,`lastSeen`)
		  SELECT storage_node_to_internal_volume.storageNodeId AS nodeId,
        internal_volume.id AS intVolId,
        nas_share.id AS shareId,
        nas_share.name AS name,
        nas_file_share.qtreeId AS qtreeId,
        'CIFS' AS 'protocol',
        hhcc_cifs_temp.HostName AS hostName,
        hhcc_cifs_temp.HostIp AS ip,
        hhcc_cifs_temp.WindowsUser AS windowsUser,
        NOW() AS 'firstSeen',
        NOW() AS 'lastSeen'
       
      FROM dwh_inventory.hhcc_cifs_temp hhcc_cifs_temp
  
      JOIN dwh_inventory.nas_share nas_share
        ON nas_share.name= hhcc_cifs_temp.ShareName AND nas_share.protocol = 'CIFS'
        
      JOIN dwh_inventory.nas_file_share nas_file_share
        ON (nas_share.fileShareId = nas_file_share.id)

      JOIN dwh_inventory.internal_volume internal_volume
        ON (nas_file_share.internalVolumeId = internal_volume.id)

      JOIN dwh_inventory.storage_node_to_internal_volume storage_node_to_internal_volume
        ON (internal_volume.id = storage_node_to_internal_volume.internalVolumeId)

    ON DUPLICATE KEY UPDATE dwh_inventory.hhcc_cifs_host_conn.lastSeen=NOW() ;

TRUNCATE dwh_inventory.hhcc_cifs_temp;
	END$$
    
DELIMITER ;

DELIMITER $$

CREATE EVENT IF NOT EXISTS hhccCIFSHostConnUpdateSched
	ON SCHEDULE 
    EVERY 1 DAY
    STARTS STR_TO_DATE( DATE_FORMAT(NOW(), '%Y%m%d 1150'), '%Y%m%d %H%i') + INTERVAL 1 DAY
    
    DO 
      CALL dwh_inventory.hhccCIFSHostConnUpdate();
	
$$

DELIMITER ;