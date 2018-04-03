USE dwh_inventory;

CREATE OR REPLACE VIEW `wcr_nfs_host_conn_view` AS
	SELECT
		storage.name AS 'clusterName',
        storage.id AS 'clusterID',
        storage_node.name AS 'nodeName',
        storage_node.id as 'nodeID',
        storage_node.serialNumber AS 'serial',
        internal_volume.virtualStorage AS 'vFiler',
        SUBSTRING_INDEX(storage_pool.name,':',-1) AS 'aggregateName',
        storage_pool.id AS 'aggregateID',
        SUBSTRING_INDEX(internal_volume.name,':',-1) AS 'volumeName',
        nfs_host_conn.intVolId AS 'internalVolID',
        wcr_vol_combined_data.avgThroughput AS 'volAverageThroughput',
        wcr_vol_combined_data.peakThroughput AS 'volPeakThroughput',
        qtree.name AS 'qTreeName',
        qtree.id AS 'qTreeID',
        nfs_host_conn.name AS 'shareName',
        nfs_host_conn.shareId AS 'shareID',
        nfs_host_conn.protocol AS 'protocol',
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 'UNKNOWN'
            WHEN 0 THEN 'UNKNOWN'
            ELSE host.name
        END AS 'FQDN',
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 'UNKNOWN'
            WHEN 0 THEN 'UNKNOWN'
            ELSE SUBSTRING_INDEX(host.name,'.',1)
        END AS 'hostname',
        nfs_host_conn.hostip AS 'IP',
        CASE nfs_host_conn.hostId
            WHEN -1 THEN 'UNKNOWN'
            WHEN 0 THEN 'UNKNOWN'
            ELSE host.id
        END AS 'hostID',
        '' AS 'user',
        nfs_host_conn.firstSeen AS 'firstSeen',
        nfs_host_conn.lastSeen AS 'fastSeen'
        
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
;