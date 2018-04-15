USE dwh_inventory;

CREATE OR REPLACE VIEW `wcr_unconnected_shares_view` AS
	SELECT
		storage.name AS 'Cluster Name',
        storage.id AS 'Cluster ID',
        storage_node.name AS 'Node Name',
        storage_node.id as 'Node ID',
        storage_node.serialNumber AS 'Node Serial No',
        internal_volume.virtualStorage AS 'vFiler/vServer',
        SUBSTRING_INDEX(storage_pool.name,':',-1) AS 'Aggregate Name',
        storage_pool.id AS 'Aggregate ID',
        SUBSTRING_INDEX(internal_volume.name,':',-1) AS 'Volume Name',
        internal_volume.id AS 'Internal Volume ID',
        wcr_vol_combined_data.avgThroughput AS 'Volume Average Throughput',
        wcr_vol_combined_data.peakThroughput AS 'Volume Peak Throughput',
        qtree.name AS 'qTree Name',
        qtree.id AS 'qTree ID',
        nas_share.name AS 'Share Name',
        nas_share.id AS 'Share ID',
        nas_share.protocol AS 'Protocol'
        
	FROM dwh_inventory.nas_share nas_share
    
    JOIN dwh_inventory.nas_file_share nas_file_share
		ON nas_share.fileShareId = nas_file_share.id
	
    JOIN dwh_inventory.internal_volume internal_volume
		ON nas_file_share.internalVolumeId = internal_volume.id
	
    JOIN dwh_inventory.qtree qtree
		ON nas_file_share.qtreeId = qtree.id
	
    JOIN dwh_inventory.storage_pool storage_pool
		ON internal_volume.storagePoolId = storage_pool.id
	
    JOIN dwh_inventory.storage_node_to_internal_volume storage_node_to_internal_volume
		ON internal_volume.id = storage_node_to_internal_volume.internalVolumeId
	
    JOIN dwh_inventory.storage_node storage_node
		ON storage_node_to_internal_volume.storageNodeId = storage_node.id
        
	JOIN dwh_inventory.storage storage
		ON storage_node_to_internal_volume.storageId = storage.id
	
    LEFT JOIN dwh_inventory.wcr_volume_dimension wcr_volume_dimension
		ON internal_volume.id = wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data wcr_vol_combined_data
		ON wcr_volume_dimension.id = wcr_vol_combined_data.volDimId

	WHERE (nas_share.id NOT IN ( SELECT shareId FROM dwh_inventory.nfs_host_conn)) 
		AND (dwh_inventory.nas_share.protocol = 'NFS')
    
    UNION ALL
    
    SELECT
		storage.name AS 'Cluster Name',
        storage.id AS 'Cluster ID',
        storage_node.name AS 'Node Name',
        storage_node.id as 'Node ID',
        storage_node.serialNumber AS 'Node Serial No',
        internal_volume.virtualStorage AS 'vFiler/vServer',
        SUBSTRING_INDEX(storage_pool.name,':',-1) AS 'Aggregate Name',
        storage_pool.id AS 'Aggregate ID',
        SUBSTRING_INDEX(internal_volume.name,':',-1) AS 'Volume Name',
        internal_volume.id AS 'Internal Volume ID',
        wcr_vol_combined_data.avgThroughput AS 'Volume Average Throughput',
        wcr_vol_combined_data.peakThroughput AS 'Volume Peak Throughput',
        qtree.name AS 'qTree Name',
        qtree.id AS 'qTree ID',
        nas_share.name AS 'Share Name',
        nas_share.id AS 'Share ID',
        nas_share.protocol AS 'Protocol'
        
	FROM dwh_inventory.nas_share nas_share
    
    JOIN dwh_inventory.nas_file_share nas_file_share
		ON nas_share.fileShareId = nas_file_share.id
	
    JOIN dwh_inventory.internal_volume internal_volume
		ON nas_file_share.internalVolumeId = internal_volume.id
	
    JOIN dwh_inventory.qtree qtree
		ON nas_file_share.qtreeId = qtree.id
	
    JOIN dwh_inventory.storage_pool storage_pool
		ON internal_volume.storagePoolId = storage_pool.id
	
    JOIN dwh_inventory.storage_node_to_internal_volume storage_node_to_internal_volume
		ON internal_volume.id = storage_node_to_internal_volume.internalVolumeId
	
    JOIN dwh_inventory.storage_node storage_node
		ON storage_node_to_internal_volume.storageNodeId = storage_node.id
        
	JOIN dwh_inventory.storage storage
		ON storage_node_to_internal_volume.storageId = storage.id
	
    LEFT JOIN dwh_inventory.wcr_volume_dimension wcr_volume_dimension
		ON internal_volume.id = wcr_volume_dimension.internalVolumeId
        
	LEFT JOIN dwh_inventory.wcr_vol_combined_data wcr_vol_combined_data
		ON wcr_volume_dimension.id = wcr_vol_combined_data.volDimId

	WHERE (nas_share.id NOT IN ( SELECT shareId FROM dwh_inventory.wcr_cifs_host_conn)) 
		AND (dwh_inventory.nas_share.protocol = 'CIFS')
;