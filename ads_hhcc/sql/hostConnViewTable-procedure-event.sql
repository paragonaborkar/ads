USE dwh_inventory;

DROP TABLE IF EXISTS dwh_inventory.wcr_cifs_host_conn_view;
CREATE TABLE IF NOT EXISTS dwh_inventory.wcr_cifs_host_conn_view (
	`clusterName` VARCHAR(100) DEFAULT 'N/A',
	`clusterId` INT(11),
	`nodeName` VARCHAR(100) DEFAULT 'N/A',
	`nodeId` INT(11),
	`nodeSerial` VARCHAR(100),
	`vFiler` VARCHAR(100),
	`aggregateName` VARCHAR(100),
	`aggregateId` INT(11),
	`volumeName` VARCHAR(255),
	`intVolId` INT(11),
	`volAvgThroughput` INT(11),
	`volPeakThroughput` INT(11),
	`qtreeName` VARCHAR(100),
	`qtreeId` INT(11),
	`shareName` VARCHAR(255),
	`shareId` INT(11),
	`protocol` VARCHAR(45),
	`fqdn` VARCHAR(255),
	`hostName` VARCHAR(255),
	`ip` VARCHAR(255),
	`hostId` INT(11),
	`user` VARCHAR(255),
	`firstSeen` DATETIME,
	`lastSeen` DATETIME,
	`updated` DATETIME,
	PRIMARY KEY(shareId,hostName,user),
	INDEX idx_nodeName (nodeName),
	INDEX idx_hostName (hostName)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS dwh_inventory.wcr_host_conn_view;
CREATE TABLE IF NOT EXISTS dwh_inventory.wcr_host_conn_view (
	`clusterName` VARCHAR(100) DEFAULT 'N/A',
	`clusterId` INT(11),
	`nodeName` VARCHAR(100) DEFAULT 'N/A',
	`nodeId` INT(11),
	`nodeSerial` VARCHAR(100),
	`vFiler` VARCHAR(100),
	`aggregateName` VARCHAR(100),
	`aggregateId` INT(11),
	`volumeName` VARCHAR(255),
	`intVolId` INT(11),
	`volAvgThroughput` INT(11),
	`volPeakThroughput` INT(11),
	`qtreeName` VARCHAR(100),
	`qtreeId` INT(11),
	`shareName` VARCHAR(255),
	`shareId` INT(11),
	`protocol` VARCHAR(45),
	`fqdn` VARCHAR(255),
	`hostName` VARCHAR(255),
	`ip` VARCHAR(255),
	`hostId` INT(11),
	`user` VARCHAR(255),
	`firstSeen` DATETIME,
	`lastSeen` DATETIME,
	`updated` DATETIME,
	PRIMARY KEY(nodeName,shareName,ip,user),
	INDEX idx_nodeName (nodeName),
	INDEX idx_hostName (hostName)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

DELIMITER $$

DROP PROCEDURE IF EXISTS cifshostConnectionTable;
CREATE  PROCEDURE cifshostConnectionTable ()
BEGIN

INSERT INTO dwh_inventory.wcr_cifs_host_conn_view 
	(`clusterName`,`clusterId`,`nodeName`,`nodeId`,`nodeSerial`,`vFiler`,`aggregateName`,`aggregateId`,
	`volumeName`,`intVolId`,`volAvgThroughput`,`volPeakThroughput`,`qtreeName`,`qtreeId`,
	`shareName`,`shareId`,`protocol`,`fqdn`,`hostName`,`ip`,`hostId`,`user`,`firstSeen`,`lastSeen`,
	`updated`)

	SELECT 
		storage.name,
		storage.id,
		storage_node.name,
		storage_node.id,
		storage_node.serialNumber,
		internal_volume.virtualStorage,
		SUBSTRING_INDEX(storage_pool.name,':',-1),
		storage_pool.id,
		SUBSTRING_INDEX(internal_volume.name,':',-1),
		internal_volume.id,
		wcr_vol_combined_data.avgThroughput,
		wcr_vol_combined_data.peakThroughput,
		qtree.name,
		qtree.id,
		nas_share.name,
		wcr_cifs_host_conn.shareId,
		wcr_cifs_host_conn.protocol,
		'',
		wcr_cifs_host_conn.hostName,
		wcr_cifs_host_conn.ip,
		0,
		wcr_cifs_host_conn.windowsUser,
		wcr_cifs_host_conn.firstSeen,
		wcr_cifs_host_conn.lastSeen,
		NOW()
    
	FROM dwh_inventory.wcr_cifs_host_conn wcr_cifs_host_conn

	JOIN dwh_inventory.internal_volume internal_volume
		ON wcr_cifs_host_conn.intVolId = internal_volume.id

	JOIN dwh_inventory.storage_pool storage_pool
		ON internal_volume.storagePoolId = storage_pool.id

	JOIN dwh_inventory.storage_node storage_node
		ON wcr_cifs_host_conn.nodeId = storage_node.id
		
	JOIN dwh_inventory.storage storage
		ON storage_node.storageId = storage.id

	JOIN dwh_inventory.nas_share nas_share
		ON wcr_cifs_host_conn.shareId = nas_share.id
	  
	JOIN dwh_inventory.qtree qtree
		ON wcr_cifs_host_conn.qtreeId=qtree.id
          
	LEFT JOIN dwh_inventory.wcr_volume_dimension wcr_volume_dimension
		ON internal_volume.id = wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data wcr_vol_combined_data
		ON wcr_volume_dimension.id = wcr_vol_combined_data.volDimId

ON DUPLICATE KEY UPDATE 
			`volAvgThroughput`= wcr_vol_combined_data.avgThroughput,
			`volPeakThroughput` = wcr_vol_combined_data.peakThroughput,
			`lastSeen` = wcr_cifs_host_conn.lastSeen,
			`updated` = NOW()
;
END $$

DROP PROCEDURE IF EXISTS hostConnectionTable;
CREATE PROCEDURE hostConnectionTable ()
BEGIN

INSERT INTO dwh_inventory.wcr_host_conn_view 
	(`clusterName`,`clusterId`,`nodeName`,`nodeId`,`nodeSerial`,`vFiler`,`aggregateName`,`aggregateId`,
	`volumeName`,`intVolId`,`volAvgThroughput`,`volPeakThroughput`,`qtreeName`,`qtreeId`,
	`shareName`,`shareId`,`protocol`,`fqdn`,`hostName`,`ip`,`hostId`,`user`,`firstSeen`,`lastSeen`,
	`updated`)
	
	SELECT
		    storage.name,
        storage.id,
        storage_node.name,
        storage_node.id,
        storage_node.serialNumber,
        internal_volume.virtualStorage,
        SUBSTRING_INDEX(storage_pool.name,':',-1),
        storage_pool.id,
        SUBSTRING_INDEX(internal_volume.name,':',-1),
        nfs_host_conn.intVolId,
        wcr_vol_combined_data.avgThroughput,
        wcr_vol_combined_data.peakThroughput,
        qtree.name,
        qtree.id ,
        nfs_host_conn.name ,
        nfs_host_conn.shareId ,
        nfs_host_conn.protocol ,
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 'Hostname not identified'
            WHEN 0 THEN 'Hostname not identified'
            ELSE host.name
        END ,
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 'Hostname not identified'
            WHEN 0 THEN 'Hostname not identified'
            ELSE SUBSTRING_INDEX(host.name,'.',1)
        END,
        nfs_host_conn.hostip,
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 0
            WHEN 0 THEN 0
            ELSE host.id
        END,
        '' ,
        nfs_host_conn.firstSeen,
        nfs_host_conn.lastSeen,
		NOW()
        
	FROM dwh_inventory.nfs_host_conn nfs_host_conn
    
    JOIN dwh_inventory.internal_volume internal_volume
		ON nfs_host_conn.intVolId = internal_volume.id
        
	JOIN dwh_inventory.storage_pool storage_pool
		ON internal_volume.storagePoolId = storage_pool.id
	
    JOIN dwh_inventory.storage_node_to_internal_volume storage_node_to_internal_volume
		ON nfs_host_conn.intVolId = storage_node_to_internal_volume.internalVolumeId
	
    JOIN dwh_inventory.storage_node storage_node
		ON storage_node_to_internal_volume.storageNodeId = storage_node.id
        
	JOIN dwh_inventory.storage storage
		ON storage_node_to_internal_volume.storageId = storage.id
        
	LEFT JOIN dwh_inventory.host host
		ON nfs_host_conn.hostId = host.id
    
    LEFT JOIN dwh_inventory.nas_share nas_share
		ON nfs_host_conn.shareId = nas_share.id
        
	LEFT JOIN dwh_inventory.nas_file_share nas_file_share
		ON nas_share.fileShareId = nas_file_share.id
        
	LEFT JOIN dwh_inventory.qtree qtree
		ON nas_file_share.qtreeId = qtree.id
	
    LEFT JOIN dwh_inventory.wcr_volume_dimension wcr_volume_dimension
		ON internal_volume.id = wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data wcr_vol_combined_data
		ON wcr_volume_dimension.id = wcr_vol_combined_data.volDimId
ON DUPLICATE KEY UPDATE 
            `volAvgThroughput`= wcr_vol_combined_data.avgThroughput,
						`volPeakThroughput` = wcr_vol_combined_data.peakThroughput,
            `lastSeen` = nfs_host_conn.lastSeen,
						`updated` = NOW()
;

INSERT INTO dwh_inventory.wcr_host_conn_view 
	(`clusterName`,`clusterId`,`nodeName`,`nodeId`,`nodeSerial`,`vFiler`,`aggregateName`,`aggregateId`,
	`volumeName`,`intVolId`,`volAvgThroughput`,`volPeakThroughput`,`qtreeName`,`qtreeId`,
	`shareName`,`shareId`,`protocol`,`fqdn`,`hostName`,`ip`,`hostId`,`user`,`firstSeen`,`lastSeen`,
	`updated`)
	
	SELECT 
    storage.name,
	storage.id,
    storage_node.name,
    storage_node.id,
    storage_node.serialNumber,
    internal_volume.virtualStorage,
    SUBSTRING_INDEX(storage_pool.name,':',-1),
    storage_pool.id,
    SUBSTRING_INDEX(internal_volume.name,':',-1),
    internal_volume.id,
    wcr_vol_combined_data.avgThroughput,
	wcr_vol_combined_data.peakThroughput,
    qtree.name,
    qtree.id,
    nas_share.name,
    wcr_cifs_host_conn.shareId,
    wcr_cifs_host_conn.protocol,
    '',
    wcr_cifs_host_conn.hostName,
    wcr_cifs_host_conn.ip,
    0,
    wcr_cifs_host_conn.windowsUser,
    wcr_cifs_host_conn.firstSeen,
    wcr_cifs_host_conn.lastSeen,
	NOW()
    
	FROM dwh_inventory.wcr_cifs_host_conn wcr_cifs_host_conn

	JOIN dwh_inventory.internal_volume internal_volume
		ON wcr_cifs_host_conn.intVolId = internal_volume.id

	JOIN dwh_inventory.storage_pool storage_pool
		ON internal_volume.storagePoolId = storage_pool.id

	JOIN dwh_inventory.storage_node storage_node
		ON wcr_cifs_host_conn.nodeId = storage_node.id
		
	JOIN dwh_inventory.storage storage
		ON storage_node.storageId = storage.id

	JOIN dwh_inventory.nas_share nas_share
		ON wcr_cifs_host_conn.shareId = nas_share.id
	  
	JOIN dwh_inventory.qtree qtree
		ON wcr_cifs_host_conn.qtreeId=qtree.id
          
	LEFT JOIN dwh_inventory.wcr_volume_dimension wcr_volume_dimension
		ON internal_volume.id = wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data wcr_vol_combined_data
		ON wcr_volume_dimension.id = wcr_vol_combined_data.volDimId

ON DUPLICATE KEY UPDATE 
			`volAvgThroughput`= wcr_vol_combined_data.avgThroughput,
			`volPeakThroughput` = wcr_vol_combined_data.peakThroughput,
      `lastSeen` = wcr_cifs_host_conn.lastSeen,
			`updated` = NOW()
;

END $$

CREATE EVENT IF NOT EXISTS wcrHostConnTableSched
	ON SCHEDULE 
    EVERY 1 DAY
    STARTS STR_TO_DATE( DATE_FORMAT(NOW(), '%Y%m%d 1430'), '%Y%m%d %H%i') + INTERVAL 1 DAY
    
    DO BEGIN
		CALL dwh_inventory.hostConnectionTable();
		CALL dwh_inventory.cifsHostConnectionTable();
	END
$$

DELIMITER ;
