CREATE TABLE `hhcc_nfs_host_showmount` (
`shareId` INT(11) NOT NULL,
`intVolId` INT(11) NOT NULL,
`storageId` INT(11) NOT NULL,
`name` VARCHAR(255) NOT NULL,
`protocol` VARCHAR(48) NULL DEFAULT NULL,
`hostIp` VARCHAR(255) NOT NULL DEFAULT '0.0.0.0',
`firstSeen` TIMESTAMP NOT NULL,
`lastSeen` TIMESTAMP NOT NULL,
PRIMARY KEY (`shareId`, `storageId`, `hostIp`, `name`))
ENGINE=InnoDB DEFAULT CHARSET=latin1;
