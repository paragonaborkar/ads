USE dwh_inventory;

/* Drop tables for rebuilding */
DROP TABLE IF EXISTS dwh_inventory.wcr_volume_dimension;
DROP TABLE IF EXISTS dwh_inventory.wcr_pool_dimension;
DROP TABLE IF EXISTS dwh_inventory.wcr_pool_perf_fact;
DROP TABLE IF EXISTS dwh_inventory.wcr_vol_perf_fact;
DROP TABLE IF EXISTS dwh_inventory.wcr_vol_combined_data;
DROP TABLE IF EXISTS dwh_inventory.wcr_pool_combined_data;

CREATE TABLE IF NOT EXISTS dwh_inventory.wcr_workloads (
  VolumeNameContains VARCHAR(255) DEFAULT 'N/A',
  WorkloadType VARCHAR(255) DEFAULT 'unknown',
  Description VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (VolumeNameContains)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE dwh_inventory.wcr_pool_dimension (
	id INT NOT NULL AUTO_INCREMENT,
	storageName VARCHAR(60) DEFAULT 'N/A',
    storageId INT(11) NOT NULL DEFAULT 0,
    storageManufacturer VARCHAR(60) DEFAULT 'N/A',
    storageFamily VARCHAR(60) DEFAULT 'N/A',
    storageModel VARCHAR(60) DEFAULT 'N/A',
    isVirtual TINYINT(1) DEFAULT 0,
	storagePoolName VARCHAR(60) DEFAULT 'N/A',
    storagePoolId INT(11) NOT NULL DEFAULT 0,
    tier VARCHAR(255) DEFAULT 'N/A',
	allocatedCapMB FLOAT DEFAULT 0,
	usedCapMB FLOAT DEFAULT 0,
    usesFlashPools TINYINT DEFAULT 0,
    diskType VARCHAR(20) DEFAULT 'N/A',
    diskSpeed INT(11) DEFAULT 0,
	diskCount INT(11) DEFAULT 0,
	diskIopsCapability INT(11) DEFAULT 0,
    poolIopsCapability INT(11) DEFAULT 0,
    updated DATETIME,
    PRIMARY KEY (id),
    UNIQUE INDEX idx_wcr_pool_dim (storagePoolId)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE dwh_inventory.wcr_volume_dimension (
	id INT NOT NULL AUTO_INCREMENT,
    storageId INT(11) NOT NULL DEFAULT 0,
    storagePoolId INT(11) NOT NULL DEFAULT 0,
    virtualStorage VARCHAR(255) DEFAULT 'N/A',
    volumeName VARCHAR(255) DEFAULT 'N/A',
    volumeId INT(11) NOT NULL DEFAULT -1,
    internalVolumeId INT(11) NOT NULL DEFAULT -1,
	allocatedCapMB FLOAT DEFAULT 0,
    usedCapMB FLOAT DEFAULT 0,
    qtreeName VARCHAR(100) DEFAULT 'Not Defined',
    qtreeId INT(11),
    nas TINYINT DEFAULT 0,
    techType VARCHAR(60) DEFAULT 'N/A',
    status VARCHAR(60) DEFAULT 'N/A',
    volAppId INT(11) DEFAULT -1,
    volApplication VARCHAR(255) DEFAULT 'No App Defined',
    qtreeAppId INT(11) DEFAULT -1,
    qtreeApplication VARCHAR(255) DEFAULT 'No App Defined',
    busEntityName VARCHAR(255) DEFAULT 'Not Defined',
    busUnit VARCHAR(255) DEFAULT 'Not Defined',
    hostConnected TINYINT(1) DEFAULT 0,
    updated DATETIME,
    PRIMARY KEY (id),
    UNIQUE INDEX idx_vol_dim_complex (storagePoolId,internalVolumeId,volumeId),
    INDEX idx_vol_dim_volID (volumeId),
    INDEX idx_vol_dim_intVolId (internalVolumeId),
    INDEX idx_vol_dim_poolId (storagePoolId))
	ENGINE=INNODB DEFAULT CHARSET=UTF8;
    
CREATE TABLE dwh_inventory.wcr_pool_perf_fact (
	storageId INT(11) DEFAULT -1,
	storagePoolId INT(11) NOT NULL DEFAULT 0,
    poolIopsCapability INT(11) DEFAULT 0,
	avgIOpS INT(11) DEFAULT 0,
	maxIOpS INT(11) DEFAULT 0,
	diskUtilization FLOAT DEFAULT 0,
    adf FLOAT DEFAULT 0,
	fullDate DATETIME DEFAULT '1970-01-01 00:00:01',
	`hour` INT(4) DEFAULT 0,
    odcPeriod INT(2) DEFAULT 0,
    PRIMARY KEY (storagePoolId, fullDate),
    INDEX idx_pool_date (fullDate, hour),
    INDEX idx_pool_duty_cycle (odcperiod)
    
) ENGINE=INNODB DEFAULT CHARSET=UTF8;
    
CREATE TABLE dwh_inventory.wcr_vol_perf_fact (
    volDimId INT(11) DEFAULT -1,
    avgIOpS INT(11) DEFAULT 0,
    peakIOpS INT(11) DEFAULT 0,
	avgThroughput INT(11) DEFAULT 0,
	peakThroughput INT(11) DEFAULT 0,
	avgResponseTime INT(11) DEFAULT 0,
	peakResponseTime INT(11) DEFAULT 0,
    readIops INT(11) DEFAULT 0,
    writeIops INT(11) DEFAULT 0,
    avgVdf FLOAT DEFAULT 0,
    peakVdf FLOAT DEFAULT 0,
	fullDate DATETIME DEFAULT '1970-01-01 00:00:01',
	`hour` INT(4) DEFAULT 0,
    odcPeriod INT(2) DEFAULT 0
    
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE dwh_inventory.wcr_pool_combined_data (
	storageName VARCHAR(60) DEFAULT 'N/A',
    storageManufacturer VARCHAR(60) DEFAULT 'N/A',
    storageFamily VARCHAR(60) DEFAULT 'N/A',
	storageModel VARCHAR(60) DEFAULT 'N/A',
    isVirtual TINYINT(1) DEFAULT 0,
	storagePoolName VARCHAR(60) DEFAULT 'N/A',
    storagePoolId INT(11) DEFAULT -1,
    tier VARCHAR(255),
    poolAllocatedCapMB FLOAT DEFAULT 0,
    poolUsedCapMB FLOAT DEFAULT 0,
    poolIopsCapability INT(11) DEFAULT 0,
    usesFlashPools TINYINT,
    diskType VARCHAR(20),
    diskSpeed INT(11),
	avgIOpS INT(11) DEFAULT 0,
	maxIOpS INT(11) DEFAULT 0,
    avgADF FLOAT DEFAULT 0,
    peakADF FLOAT DEFAULT 0,
	avgDiskUtilization INT(11) DEFAULT 0,
    peakDiskUtilization INT(11) DEFAULT 0,
    peakAdfOdc INT(3) DEFAULT 0,
    updated DATETIME,
	PRIMARY KEY (storagePoolId)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE dwh_inventory.wcr_vol_combined_data (
	storageName VARCHAR(60) DEFAULT 'N/A',
    storageManufacturer VARCHAR(60) DEFAULT 'N/A',
    storageFamily VARCHAR(60) DEFAULT 'N/A',
	storageModel VARCHAR(60) DEFAULT 'N/A',
    storagePoolId INT(11) NOT NULL,
    vServerName VARCHAR(255) DEFAULT 'N/A',
	volumeName VARCHAR(255) DEFAULT 'N/A',
    volDimId INT(11),
	workloadType VARCHAR(60) DEFAULT 'UNKNOWN',
    volAllocatedCapMB FLOAT DEFAULT 0,
    volUsedCapMB FLOAT DEFAULT 0,
    avgIOpS INT(11) DEFAULT 0,
    peakIOpS INT(11) DEFAULT 0,
    avgThroughput INT(11) DEFAULT 0,
	peakThroughput INT(11) DEFAULT 0,
	avgLatency INT(11) DEFAULT 0,
	peakLatency INT(11) DEFAULT 0,
    avgReadOps INT(11) DEFAULT 0,
    avgWriteOps INT(11) DEFAULT 0,
    ioBias VARCHAR(24) DEFAULT 'No Operations',
    avgVDF FLOAT DEFAULT 0,
    peakVDF FLOAT DEFAULT 0,
    peakIopsOdc INT(3) DEFAULT 0,
    peakThroughputOdc INT(3) DEFAULT 0,
    peakVdfOdc INT(3) DEFAULT 0,
    SANNAS VARCHAR(60) DEFAULT 'UNKNOWN',
    volAppName VARCHAR(60),
    busEntityName VARCHAR(60),
    busUnit VARCHAR(60),
    hostConnected TINYINT(1),
    updated DATETIME,
	PRIMARY KEY (volDimId)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;


/* Insert the Storage Pool specifics set */

DELIMITER $$

CREATE PROCEDURE wcrRefresh ()
	BEGIN
		TRUNCATE TABLE dwh_inventory.wcr_vol_perf_fact;
		TRUNCATE TABLE dwh_inventory.wcr_pool_perf_fact;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_pool_dimension
				  		(storageName,storageId,storageManufacturer,storageFamily,storageModel,isVirtual,storagePoolName,storagePoolId,
			            tier,allocatedCapMB,usedCapMB,usesFlashPools,diskCount,diskIOpSCapability,poolIOpSCapability,diskType,diskSpeed,updated)
				SELECT
				IF (dwh_inventory.storage_pool.name LIKE '%:%',
					SUBSTRING_INDEX(dwh_inventory.storage_pool.name,':',1),
			        dwh_inventory.storage.name) AS 'storageName',
			    dwh_inventory.storage.id AS 'storageId',
			    dwh_inventory.storage.manufacturer AS 'storageManufacturer',
			    dwh_inventory.storage.family AS 'storageFamily',
			    dwh_inventory.storage.model AS 'storageModel',
			    dwh_inventory.storage.virtual AS 'isVirtual',
			    IF (dwh_inventory.storage_pool.name LIKE '%:%',
					SUBSTRING_INDEX(dwh_inventory.storage_pool.name,':',-1),
			        dwh_inventory.storage_pool.name) AS 'storagePoolName',
			    dwh_inventory.storage_pool.id AS 'storagePoolId',
			    dwh_inventory.storage_pool.vendorTier AS 'tier',
			    dwh_inventory.storage_pool.totalAllocatedCapacityMB AS 'allocatedCapMB',
				dwh_inventory.storage_pool.totalUsedCapacityMB AS 'usedCapMB',
			    dwh_inventory.storage_pool.usesFlashPools AS 'usesFlashPools',
			    IF(dwh_inventory.storage_pool.usesFlashPools = 1,
							COUNT(DISTINCT 
								CASE 
									WHEN dwh_inventory.disk.type NOT LIKE 'SSD' THEN dwh_inventory.disk.id
								END),
							COUNT(DISTINCT dwh_inventory.disk.id)) AS 'diskCount',
						CASE
							WHEN MIN(CASE
								WHEN dwh_inventory.disk.type = 'SSD' THEN 4
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
								ELSE 1
								END) = 4 THEN 3000
							WHEN MIN(CASE
								WHEN dwh_inventory.disk.type = 'SSD' THEN 4
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
								ELSE 1
								END) = 3 THEN 200
							WHEN MIN(CASE
								WHEN dwh_inventory.disk.type = 'SSD' THEN 4
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
								WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
								WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
								ELSE 1
								END) = 2 THEN 170
							ELSE 75
						END AS 'diskIOpSCapability',
						IF(dwh_inventory.storage_pool.usesFlashPools = 1,
							COUNT(DISTINCT CASE 
								WHEN dwh_inventory.disk.type NOT LIKE 'SSD' THEN dwh_inventory.disk.id
								END) * 
							(CASE
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 4 THEN 3000
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 3 THEN 200
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 2 THEN 170
								ELSE 75
								END ),
							COUNT(DISTINCT dwh_inventory.disk.id) *
							(CASE
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 4 THEN 3000
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 3 THEN 200
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 15000 THEN 3
									WHEN dwh_inventory.disk.type = 'SAS' AND dwh_inventory.disk.speed = 10000 THEN 2
									WHEN dwh_inventory.disk.type = 'FC' AND dwh_inventory.disk.speed = 10000 THEN 2
									ELSE 1
									END) = 2 THEN 170
								ELSE 75
							END ) ) AS 'poolIopsCapability',
			                CASE
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' THEN 3
									WHEN dwh_inventory.disk.type = 'FC'  THEN 2
			                        WHEN dwh_inventory.disk.type LIKE '%SATA%' THEN 1
									ELSE 0
									END) = 4 THEN 'SSD'
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' THEN 3
									WHEN dwh_inventory.disk.type = 'FC'  THEN 2
			                        WHEN dwh_inventory.disk.type LIKE '%SATA%' THEN 1
									ELSE 0
									END) = 3 THEN 'SAS'
								WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' THEN 3
									WHEN dwh_inventory.disk.type = 'FC' THEN 2
									WHEN dwh_inventory.disk.type LIKE '%SATA%' THEN 1
									ELSE 0
									END) = 2 THEN 'FC'
			                     WHEN MIN(CASE
									WHEN dwh_inventory.disk.type = 'SSD' THEN 4
									WHEN dwh_inventory.disk.type = 'SAS' THEN 3
									WHEN dwh_inventory.disk.type = 'FC'  THEN 2
									WHEN dwh_inventory.disk.type LIKE '%SATA%' THEN 1
									ELSE 0
									END) = 1 THEN 'SATA'   
								ELSE 'Not Defined'
								END AS 'diskType',
			                    MIN(dwh_inventory.disk.speed) AS 'diskSpeed',
				NOW() AS 'updated'
    
			FROM dwh_inventory.storage

			JOIN dwh_inventory.storage_pool
			ON dwh_inventory.storage.id = dwh_inventory.storage_pool.storageId

			LEFT JOIN dwh_inventory.storage_pool_to_disk
			ON dwh_inventory.storage_pool.id = dwh_inventory.storage_pool_to_disk.storagePoolId

			LEFT JOIN dwh_inventory.disk
			ON dwh_inventory.storage_pool_to_disk.diskId = dwh_inventory.disk.id

			GROUP BY dwh_inventory.storage_pool.id

			ON DUPLICATE KEY UPDATE dwh_inventory.wcr_pool_dimension.updated=NOW()
			;
		COMMIT;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_volume_dimension
				(storageId,storagePoolId,virtualStorage,volumeName,volumeId,internalVolumeId,
					allocatedCapMB,usedCapMB,qtreeName,qtreeId,techType,volAppId,qtreeAppId,hostConnected,updated) 
				SELECT
					dwh_inventory.volume_in_storage_pool.storageId AS 'storageID',
					dwh_inventory.volume_in_storage_pool.storagePoolId AS 'storagePoolId',
			        dwh_inventory.volume.virtualStorage AS 'virtualStorage',
					dwh_inventory.volume.name AS 'volumeName',
					dwh_inventory.volume.id AS'volumeId',
					IF(dwh_inventory.volume.internalVolumeId IS NOT NULL,
						dwh_inventory.volume.internalVolumeId,-1) AS 'internalVolumeId',
					dwh_inventory.volume.capacityMB AS 'allocatedCapMB',
			        dwh_inventory.volume.consumedCapacityMB AS 'usedCapMB',
					dwh_inventory.qtree.name AS 'qtreeName',
					dwh_inventory.volume.qtreeId AS 'qtreeId',
					dwh_inventory.volume.technologyType AS 'techType',
					dwh_inventory.volume_to_application.applicationId AS 'volAppId',
			        dwh_inventory.qtree_to_application.applicationId AS 'qtreeAppId',
			        IF (COUNT(dwh_inventory.host.id) > 0,1,0) AS 'hostconnected',
			        NOW() AS 'updated'
    
				FROM dwh_inventory.volume

				JOIN dwh_inventory.volume_in_storage_pool
					ON dwh_inventory.volume.id = dwh_inventory.volume_in_storage_pool.volumeId
				JOIN dwh_inventory.storage_pool
					ON dwh_inventory.volume_in_storage_pool.storagePoolId = dwh_inventory.storage_pool.id
				LEFT JOIN dwh_inventory.qtree
					ON dwh_inventory.volume.qtreeId = dwh_inventory.qtree.id
				LEFT JOIN dwh_inventory.volume_to_application
					ON dwh_inventory.volume.id = dwh_inventory.volume_to_application.volumeId
				LEFT JOIN dwh_inventory.qtree_to_application
					ON dwh_inventory.volume.qtreeId = dwh_inventory.qtree_to_application.qtreeId
				LEFT JOIN dwh_inventory.volume_mask
					ON dwh_inventory.volume.id = dwh_inventory.volume_mask.volumeId
				LEFT JOIN dwh_inventory.host
					ON dwh_inventory.volume_mask.hostId = dwh_inventory.host.id
        
				GROUP BY dwh_inventory.volume.id
    
			    ON DUPLICATE KEY UPDATE dwh_inventory.wcr_volume_dimension.updated=NOW()
			;
		COMMIT;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_volume_dimension
				(storageId,storagePoolId,virtualStorage,volumeName,internalVolumeId,nas,volAppId,
			    status,allocatedCapMB,usedCapMB,hostConnected) 

				SELECT
					dwh_inventory.internal_volume.storageId AS 'storageID',
					dwh_inventory.internal_volume.storagePoolId AS 'storagePoolId',
			        dwh_inventory.internal_volume.virtualStorage AS 'virtualStorage',
					dwh_inventory.internal_volume.name AS 'volumeName',
					dwh_inventory.internal_volume.Id AS 'internalVolumeId',
					1 AS 'nas',
			        dwh_inventory.internal_volume_to_application.applicationId AS 'volAppId',
					dwh_inventory.internal_volume.status AS 'status',
			        dwh_inventory.internal_volume.totalAllocatedCapacityMB AS 'allocatedCapMB',
			        dwh_inventory.internal_volume.totalUsedCapacityMB AS 'usedCapMB',
			        IF (COUNT(dwh_inventory.host.id) > 0,1,0) AS 'hostconnected'
    
				FROM dwh_inventory.internal_volume

				JOIN dwh_inventory.storage_pool
					ON dwh_inventory.internal_volume.storagePoolId = dwh_inventory.storage_pool.id
				LEFT JOIN dwh_inventory.internal_volume_to_application
					ON dwh_inventory.internal_volume.id = dwh_inventory.internal_volume_to_application.internalVolumeId
				LEFT JOIN dwh_inventory.nas_file_share
					ON dwh_inventory.internal_volume.Id = dwh_inventory.nas_file_share.internalVolumeId
				LEFT JOIN dwh_inventory.nas_share
					ON dwh_inventory.nas_file_share.id = dwh_inventory.nas_share.fileShareId
				LEFT JOIN dwh_inventory.nas_logical
					ON dwh_inventory.nas_share.id = dwh_inventory.nas_logical.shareId
				LEFT JOIN dwh_inventory.host
					ON dwh_inventory.nas_logical.hostId = dwh_inventory.host.id
        
				GROUP BY dwh_inventory.internal_volume.Id
                
                ON DUPLICATE KEY UPDATE dwh_inventory.wcr_volume_dimension.updated=NOW()
			;
		COMMIT;

		UPDATE dwh_inventory.wcr_volume_dimension
			JOIN dwh_inventory.application
				ON dwh_inventory.wcr_volume_dimension.volAppId = dwh_inventory.application.id
			LEFT JOIN dwh_inventory.business_entity
				ON dwh_inventory.application.businessEntityId = dwh_inventory.business_entity.id
			SET dwh_inventory.wcr_volume_dimension.volApplication = dwh_inventory.application.name,
				dwh_inventory.wcr_volume_dimension.busEntityName = dwh_inventory.business_entity.fullname,
		        dwh_inventory.wcr_volume_dimension.busUnit = dwh_inventory.business_entity.businessUnit
		;

		UPDATE dwh_inventory.wcr_volume_dimension
			JOIN dwh_inventory.application
				ON dwh_inventory.wcr_volume_dimension.qtreeAppId = dwh_inventory.application.id
			LEFT JOIN dwh_inventory.business_entity
				ON dwh_inventory.application.businessEntityId = dwh_inventory.business_entity.id
			SET dwh_inventory.wcr_volume_dimension.qtreeApplication = dwh_inventory.application.name,
				dwh_inventory.wcr_volume_dimension.busEntityName = dwh_inventory.business_entity.fullname,
		        dwh_inventory.wcr_volume_dimension.busUnit = dwh_inventory.business_entity.businessUnit
		;
    
		/* Insert collected data into the Storage Pool performance set */ 

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_pool_perf_fact 
			  		(storageId,storagePoolId,poolIopsCapability,avgIOpS,
						maxIOpS,diskUtilization,fullDate,hour,odcPeriod)
				SELECT 
					dwh_inventory.wcr_pool_dimension.storageId AS 'storageId',
					dwh_inventory.wcr_pool_dimension.storagePoolId AS 'storagePoolId',
					dwh_inventory.wcr_pool_dimension.poolIopsCapability AS 'poolIopsCapability',
					SUM(dwh_performance.disk_hourly_performance_fact.totalIops) AS 'avgIOpS',
					SUM(dwh_performance.disk_hourly_performance_fact.totalIopsMax) AS 'maxIOpS',
					AVG(dwh_performance.disk_hourly_performance_fact.totalUtilizationMax) AS 'diskUtilization',
					dwh_performance.time_dimension.hourDateTime AS 'fullDate',
					HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) AS 'hour', 
					(CASE 
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 6 AND 9 THEN 1
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 10 AND 13 THEN 2
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 14 AND 17 THEN 3
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 18 AND 21 THEN 4
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 22 AND 23 THEN 5
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 0 AND 1 THEN 5
						WHEN HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) BETWEEN 2 AND 5 THEN 6
					END) AS 'odcPeriod'
              
			FROM dwh_inventory.wcr_pool_dimension

			JOIN dwh_inventory.storage_pool_to_disk
			ON dwh_inventory.wcr_pool_dimension.storagePoolId = dwh_inventory.storage_pool_to_disk.storagePoolId

			JOIN dwh_inventory.disk
			ON dwh_inventory.storage_pool_to_disk.diskId = dwh_inventory.disk.id

			JOIN dwh_performance.disk_dimension
			ON dwh_inventory.disk.id = dwh_performance.disk_dimension.id
			AND dwh_performance.disk_dimension.latest = 1

			LEFT JOIN dwh_performance.disk_hourly_performance_fact
			ON dwh_performance.disk_dimension.tk = dwh_performance.disk_hourly_performance_fact.diskTk

			JOIN dwh_performance.time_dimension
				ON dwh_performance.disk_hourly_performance_fact.timeTk = dwh_performance.time_dimension.tk
    
			GROUP BY dwh_performance.disk_hourly_performance_fact.storagePoolTk, 
					dwh_performance.time_dimension.hourDateTime
			;
		COMMIT;

		UPDATE dwh_inventory.wcr_pool_perf_fact
			SET dwh_inventory.wcr_pool_perf_fact.adf=((dwh_inventory.wcr_pool_perf_fact.maxIOpS / 
					dwh_inventory.wcr_pool_perf_fact.poolIopsCapability) * (dwh_inventory.wcr_pool_perf_fact.diskUtilization /100))
		;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_vol_perf_fact 
			   		(volDimId,avgIOpS,peakIOpS,avgThroughput,peakThroughput,avgResponseTime,peakResponseTime,
			        readIops,writeIops,hour,fullDate)

				SELECT 
	    
			        dwh_inventory.wcr_volume_dimension.id AS 'volDimId',
					dwh_performance.volume_hourly_performance_fact.totaliops AS 'avgIOpS',
					dwh_performance.volume_hourly_performance_fact.totaliopsMax AS 'peakIOpS',
					dwh_performance.volume_hourly_performance_fact.totalThroughput AS 'avgThroughput',
					dwh_performance.volume_hourly_performance_fact.totalThroughputMax AS 'peakThroughput',
					dwh_performance.volume_hourly_performance_fact.totalResponseTime AS 'avgResponseTime',
					dwh_performance.volume_hourly_performance_fact.totalResponseTimeMax AS 'peakResponseTime',
					dwh_performance.volume_hourly_performance_fact.readIops AS 'readIops',
					dwh_performance.volume_hourly_performance_fact.writeIops AS 'writeIops',
					HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) AS 'hour',
					dwh_performance.time_dimension.hourDateTime AS 'fullDate'

				FROM dwh_inventory.wcr_volume_dimension

				LEFT JOIN dwh_performance.volume_dimension
					ON dwh_inventory.wcr_volume_dimension.volumeId = dwh_performance.volume_dimension.id 
			        AND dwh_performance.volume_dimension.latest = 1
				LEFT JOIN dwh_performance.volume_hourly_performance_fact
					ON dwh_performance.volume_dimension.tk = dwh_performance.volume_hourly_performance_fact.volumetk
				JOIN dwh_performance.time_dimension
					ON dwh_performance.time_dimension.tk = dwh_performance.volume_hourly_performance_fact.timeTk
        
				WHERE dwh_inventory.wcr_volume_dimension.nas = 0
			;	
		COMMIT;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_vol_perf_fact 
			  		(volDimId,avgIOpS,peakIOpS,avgThroughput,peakThroughput,avgResponseTime,peakResponseTime,
			        readIops,writeIops,hour,fullDate)
    
				SELECT
			        dwh_inventory.wcr_volume_dimension.id AS 'volDimId',
					dwh_performance.internal_volume_hourly_performance_fact.totaliops AS 'avgIOpS',
					dwh_performance.internal_volume_hourly_performance_fact.totaliopsMax AS 'peakIOpS',
					dwh_performance.internal_volume_hourly_performance_fact.totalThroughput AS 'avgThroughput',
					dwh_performance.internal_volume_hourly_performance_fact.totalThroughputMax AS 'peakThroughput',
					dwh_performance.internal_volume_hourly_performance_fact.totalResponseTime AS 'avgResponseTime',
					dwh_performance.internal_volume_hourly_performance_fact.totalResponseTimeMax AS 'peakResponseTime',
					dwh_performance.internal_volume_hourly_performance_fact.readIops AS 'readIops',
					dwh_performance.internal_volume_hourly_performance_fact.writeIops AS 'writeIops',
					HOUR(TIME(dwh_performance.time_dimension.hourDateTime)) AS 'hour',
					dwh_performance.time_dimension.hourDateTime AS 'fullDate'

				FROM	dwh_inventory.wcr_volume_dimension

				LEFT JOIN dwh_performance.internal_volume_dimension
					ON dwh_inventory.wcr_volume_dimension.internalVolumeId = dwh_performance.internal_volume_dimension.id
			        AND dwh_performance.internal_volume_dimension.latest = 1
				LEFT JOIN dwh_performance.internal_volume_hourly_performance_fact
					ON dwh_performance.internal_volume_dimension.tk = dwh_performance.internal_volume_hourly_performance_fact.internalVolumeTk 
				JOIN dwh_performance.time_dimension
					ON dwh_performance.time_dimension.tk = dwh_performance.internal_volume_hourly_performance_fact.timeTk
        
				WHERE dwh_inventory.wcr_volume_dimension.nas = 1
			;
		COMMIT;

		UPDATE dwh_inventory.wcr_vol_perf_fact
	
		    JOIN dwh_inventory.wcr_volume_dimension
				ON dwh_inventory.wcr_volume_dimension.id = dwh_inventory.wcr_vol_perf_fact.volDimId
			SET dwh_inventory.wcr_vol_perf_fact.avgVdf =
				((dwh_inventory.wcr_vol_perf_fact.avgIOpS / (dwh_inventory.wcr_volume_dimension.usedCapMB/1024)) * 
					(dwh_inventory.wcr_vol_perf_fact.avgResponseTime/1000)) * 100,
				dwh_inventory.wcr_vol_perf_fact.peakVdf =
				((dwh_inventory.wcr_vol_perf_fact.peakIOpS / (dwh_inventory.wcr_volume_dimension.usedCapMB/1024)) * 
					(dwh_inventory.wcr_vol_perf_fact.peakResponseTime/1000)) * 100
		;

		UPDATE dwh_inventory.wcr_vol_perf_fact
			SET dwh_inventory.wcr_vol_perf_fact.odcPeriod = 
				CASE 
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 6 AND 9 THEN 1
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 10 AND 13 THEN 2
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 14 AND 17 THEN 3
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 18 AND 21 THEN 4
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 22 AND 23 THEN 5
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 0 AND 1 THEN 5
					WHEN dwh_inventory.wcr_vol_perf_fact.hour BETWEEN 2 AND 5 THEN 6
		            ELSE 0
				END
		;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_pool_combined_data
				(storageName,storageManufacturer,storagePoolName,storageFamily,storageModel,isVirtual,
			    storagePoolId,tier,poolAllocatedCapMB,poolUsedCapMB,poolIopsCapability,usesFlashPools,
			    diskType,diskSpeed,updated)
        
			SELECT 
				dwh_inventory.wcr_pool_dimension.storageName AS 'storageName', 
			    dwh_inventory.wcr_pool_dimension.storageManufacturer AS 'storageManufacturer',
				dwh_inventory.wcr_pool_dimension.storagePoolName AS 'storagePoolName',
			    dwh_inventory.wcr_pool_dimension.storageFamily AS 'storageFamily',
			    dwh_inventory.wcr_pool_dimension.storageModel AS 'storageModel',
			    dwh_inventory.wcr_pool_dimension.isVirtual AS 'isVirtual',
			    dwh_inventory.wcr_pool_dimension.storagePoolId AS 'storagePoolId',
			    dwh_inventory.wcr_pool_dimension.tier AS 'tier',
			    dwh_inventory.wcr_pool_dimension.allocatedCapMB AS 'poolAllocatedCapMB',
			    dwh_inventory.wcr_pool_dimension.usedCapMB AS 'poolUsedCapMB',
			    dwh_inventory.wcr_pool_dimension.poolIopsCapability AS 'poolIopsCapability',
			    dwh_inventory.wcr_pool_dimension.usesFlashPools AS 'usesFlashPools',
			    dwh_inventory.wcr_pool_dimension.diskType AS 'diskType',
			    dwh_inventory.wcr_pool_dimension.diskSpeed AS 'diskSpeed',
			    NOW() AS 'updated'
    
			    FROM dwh_inventory.wcr_pool_dimension
    
			    ON DUPLICATE KEY UPDATE dwh_inventory.wcr_pool_combined_data.updated=NOW()
			;
		COMMIT;

		UPDATE dwh_inventory.wcr_pool_combined_data
			JOIN (SELECT
					dwh_inventory.wcr_pool_perf_fact.storagePoolId AS 'storagePoolId',
					dwh_inventory.wcr_pool_perf_fact.avgIOpS AS 'avgIOpS',
					dwh_inventory.wcr_pool_perf_fact.maxIOpS AS 'maxIOpS',
					AVG(dwh_inventory.wcr_pool_perf_fact.adf) AS 'avgADF',
					MAX(dwh_inventory.wcr_pool_perf_fact.adf) AS 'peakADF',
					CAST(ROUND(AVG(dwh_inventory.wcr_pool_perf_fact.diskUtilization)) AS SIGNED) AS 'avgDiskUtilization',
					MAX(dwh_inventory.wcr_pool_perf_fact.diskUtilization) AS 'peakDiskUtilization' 
				FROM dwh_inventory.wcr_pool_perf_fact
				GROUP BY dwh_inventory.wcr_pool_perf_fact.StoragePoolId 
		        ) t1
    
		    ON dwh_inventory.wcr_pool_combined_data.StoragePoolId = t1.StoragePoolId
    
		    SET dwh_inventory.wcr_pool_combined_data.avgIOpS = t1.avgIOpS,
				dwh_inventory.wcr_pool_combined_data.maxIOpS = t1.maxIOpS,
		        dwh_inventory.wcr_pool_combined_data.avgADF = t1.avgADF,
		        dwh_inventory.wcr_pool_combined_data.peakADF = t1.peakADF,
		        dwh_inventory.wcr_pool_combined_data.avgDiskUtilization = t1.avgDiskUtilization,
		        dwh_inventory.wcr_pool_combined_data.peakDiskUtilization = t1.peakDiskUtilization
		;

		UPDATE dwh_inventory.wcr_pool_combined_data

			JOIN dwh_inventory.wcr_pool_perf_fact
				ON dwh_inventory.wcr_pool_perf_fact.storagePoolId = dwh_inventory.wcr_pool_combined_data.storagePoolId
        
			SET dwh_inventory.wcr_pool_combined_data.peakAdfOdc = dwh_inventory.wcr_pool_perf_fact.odcperiod
				WHERE dwh_inventory.wcr_pool_combined_data.peakADF = dwh_inventory.wcr_pool_perf_fact.adf
		;

		UPDATE dwh_inventory.wcr_pool_combined_data

			JOIN dwh_inventory.wcr_pool_perf_fact
				ON dwh_inventory.wcr_pool_perf_fact.storagePoolId = dwh_inventory.wcr_pool_combined_data.storagePoolId
        
			SET dwh_inventory.wcr_pool_combined_data.peakAdfOdc = dwh_inventory.wcr_pool_perf_fact.odcperiod
				WHERE dwh_inventory.wcr_pool_combined_data.peakADF = dwh_inventory.wcr_pool_perf_fact.adf
		;

		START TRANSACTION;
			INSERT INTO dwh_inventory.wcr_vol_combined_data
				(storageName,storageManufacturer,storageFamily,storageModel,storagePoolId,vServerName,volumeName,volDimId,
					volAllocatedCapMB,volUsedCapMB,SANNAS,volAppName,busEntityName,busUnit,hostConnected,updated)

			SELECT 
			    dwh_inventory.wcr_pool_dimension.storageName AS 'storageName',
			    dwh_inventory.wcr_pool_dimension.storageManufacturer AS 'storageManufacturer',
			    dwh_inventory.wcr_pool_dimension.storageFamily AS 'storageFamily',
			    dwh_inventory.wcr_pool_dimension.storageModel AS 'storageModel',
			    dwh_inventory.wcr_volume_dimension.storagePoolId AS 'storagePoolId',
			    dwh_inventory.wcr_volume_dimension.virtualStorage AS 'vServerName',
			    dwh_inventory.wcr_volume_dimension.volumeName AS 'volumeName',
			    dwh_inventory.wcr_volume_dimension.id AS 'volDimId',
			    dwh_inventory.wcr_volume_dimension.allocatedCapMB AS 'volAllocatedCapMB',
			    dwh_inventory.wcr_volume_dimension.usedCapMB AS 'volUsedCapMB',
			    IF (dwh_inventory.wcr_volume_dimension.nas=0,'SAN','NAS') AS 'SANNAS',
			    dwh_inventory.wcr_volume_dimension.volApplication AS 'volAppName',
			    dwh_inventory.wcr_volume_dimension.busEntityName AS 'busEntityName',
			    dwh_inventory.wcr_volume_dimension.busUnit AS 'busUnit',
			    dwh_inventory.wcr_volume_dimension.hostConnected AS 'hostConnected',
			    NOW() AS 'updated'
    
				FROM dwh_inventory.wcr_volume_dimension
    
			    JOIN dwh_inventory.wcr_pool_dimension
					ON dwh_inventory.wcr_volume_dimension.storagePoolId = dwh_inventory.wcr_pool_dimension.storagePoolId
	
			    ON DUPLICATE KEY UPDATE dwh_inventory.wcr_vol_combined_data.updated=NOW()
			;
		COMMIT;

		UPDATE dwh_inventory.wcr_vol_combined_data 
			JOIN 
		    (SELECT 
				dwh_inventory.wcr_vol_perf_fact.volDimId AS 'volDimID',
		        CAST(ROUND(AVG(dwh_inventory.wcr_vol_perf_fact.avgIOpS)) AS SIGNED) AS 'avgIOpS',
				MAX(dwh_inventory.wcr_vol_perf_fact.peakIOpS) AS'peakIOpS',
				CAST(ROUND(AVG(dwh_inventory.wcr_vol_perf_fact.peakThroughput)) AS SIGNED) AS 'avgThroughput',
				MAX(dwh_inventory.wcr_vol_perf_fact.peakThroughput) AS'peakThroughput',
				CAST(ROUND(AVG(dwh_inventory.wcr_vol_perf_fact.peakResponseTime)) AS SIGNED) AS 'avgLatency',
				MAX(dwh_inventory.wcr_vol_perf_fact.peakResponseTime) AS 'peakLatency',
				CAST(ROUND(AVG(dwh_inventory.wcr_vol_perf_fact.readIops)) AS SIGNED) AS 'avgReadOps',
				CAST(ROUND(AVG(dwh_inventory.wcr_vol_perf_fact.writeIops)) AS SIGNED) AS 'avgWriteOps',
				CASE 
					WHEN MAX(dwh_inventory.wcr_vol_perf_fact.peakIOpS) IS NULL THEN 'UnKnown'
					WHEN MAX(dwh_inventory.wcr_vol_perf_fact.peakIOpS) = 0 THEN 'At Rest'
					WHEN CAST(ROUND(
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) *100)/
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) + 
						AVG(dwh_inventory.wcr_vol_perf_fact.writeIops))) AS SIGNED) BETWEEN 1 AND 20 THEN 'High Write'
					WHEN CAST(ROUND(
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) *100)/
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) + 
						AVG(dwh_inventory.wcr_vol_perf_fact.writeIops))) AS SIGNED) BETWEEN 21 AND 40 THEN 'Moderate Write'
					WHEN CAST(ROUND(
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) *100)/
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) + 
						AVG(dwh_inventory.wcr_vol_perf_fact.writeIops))) AS SIGNED) BETWEEN 41 AND 60 THEN 'Neutral'
					WHEN CAST(ROUND(
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) *100)/
						(AVG(dwh_inventory.wcr_vol_perf_fact.readIops) + 
						AVG(dwh_inventory.wcr_vol_perf_fact.writeIops))) AS SIGNED) BETWEEN 61 AND 80 THEN 'Moderate Read'
					ELSE  'High Read'
				END AS 'ioBias',
		        IF (AVG(dwh_inventory.wcr_vol_perf_fact.avgVdf) IS NOT NULL,AVG(dwh_inventory.wcr_vol_perf_fact.avgVdf),0) AS 'avgVDF',
				IF (MAX(dwh_inventory.wcr_vol_perf_fact.peakVdf) IS NOT NULL,MAX(dwh_inventory.wcr_vol_perf_fact.peakVdf),0) AS 'peakVDF'
		
	
		    FROM dwh_inventory.wcr_vol_perf_fact
        
			GROUP BY dwh_inventory.wcr_vol_perf_fact.volDimId) t1
	
		    ON dwh_inventory.wcr_vol_combined_data.volDimId = t1.volDimId
    
		    SET dwh_inventory.wcr_vol_combined_data.avgIOpS = t1.avgIOpS,
				dwh_inventory.wcr_vol_combined_data.peakIOpS = t1.peakIOpS,
		        dwh_inventory.wcr_vol_combined_data.avgThroughput = t1.avgThroughput,
		        dwh_inventory.wcr_vol_combined_data.peakThroughput = t1.peakThroughput,
		        dwh_inventory.wcr_vol_combined_data.avgLatency = t1.avgLatency,
		        dwh_inventory.wcr_vol_combined_data.peakLatency = t1.peakLatency,
		        dwh_inventory.wcr_vol_combined_data.avgReadOps = t1.avgReadOps,
		        dwh_inventory.wcr_vol_combined_data.avgwriteOps = t1.avgWriteOps,
		        dwh_inventory.wcr_vol_combined_data.ioBias = t1.ioBias,
		        dwh_inventory.wcr_vol_combined_data.avgVDF = t1.avgVDF,
		        dwh_inventory.wcr_vol_combined_data.peakVDF = t1.peakVDF
		;

		UPDATE dwh_inventory.wcr_vol_combined_data
			JOIN dwh_inventory.wcr_workloads
				ON lower(dwh_inventory.wcr_vol_combined_data.volumeName) LIKE CONCAT('%',lower(dwh_inventory.wcr_workloads.volumeNameContains),'%')
			SET dwh_inventory.wcr_vol_combined_data.WorkloadType = dwh_inventory.wcr_workloads.workloadType
		;

		UPDATE dwh_inventory.wcr_vol_combined_data

			JOIN dwh_inventory.wcr_vol_perf_fact
				ON dwh_inventory.wcr_vol_perf_fact.volDimId = dwh_inventory.wcr_vol_combined_data.volDimId
        
			SET dwh_inventory.wcr_vol_combined_data.peakThroughputOdc = dwh_inventory.wcr_vol_perf_fact.odcperiod
				WHERE dwh_inventory.wcr_vol_combined_data.peakThroughput = dwh_inventory.wcr_vol_perf_fact.peakThroughput
		;

		UPDATE dwh_inventory.wcr_vol_combined_data

			JOIN dwh_inventory.wcr_vol_perf_fact
				ON dwh_inventory.wcr_vol_perf_fact.volDimId = dwh_inventory.wcr_vol_combined_data.volDimId
        
			SET dwh_inventory.wcr_vol_combined_data.peakIopsOdc = dwh_inventory.wcr_vol_perf_fact.odcperiod
				WHERE dwh_inventory.wcr_vol_combined_data.peakIOpS = dwh_inventory.wcr_vol_perf_fact.peakIOpS
		;

		UPDATE dwh_inventory.wcr_vol_combined_data

			JOIN dwh_inventory.wcr_vol_perf_fact
				ON dwh_inventory.wcr_vol_perf_fact.volDimId = dwh_inventory.wcr_vol_combined_data.volDimId
        
			SET dwh_inventory.wcr_vol_combined_data.peakVdfOdc = dwh_inventory.wcr_vol_perf_fact.odcperiod
				WHERE dwh_inventory.wcr_vol_combined_data.peakVDF = dwh_inventory.wcr_vol_perf_fact.peakVdf
		;


	END $$

DELIMITER ;

set GLOBAL event_scheduler = ON;

DELIMITER $$

CREATE EVENT IF NOT EXISTS wcrRefreshSched
	ON SCHEDULE 
    EVERY 1 DAY
    STARTS STR_TO_DATE( DATE_FORMAT(NOW(), '%Y%m%d 1200'), '%Y%m%d %H%i') + INTERVAL 1 DAY
    
    DO CALL dwh_inventory.wcrRefresh();
	
$$

DELIMITER ;