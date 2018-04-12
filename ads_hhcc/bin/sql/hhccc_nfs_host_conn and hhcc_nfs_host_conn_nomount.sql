CREATE TABLE IF NOT EXISTS `dwh_inventory`.`hhcc_nfs_host_conn` (
   shareId  int(11) NOT NULL,
   intVolId  int(11) NOT NULL,
   name  varchar(255) NOT NULL,
   protocol  varchar(48) DEFAULT NULL,
   hostId  int(11) NOT NULL DEFAULT '0',
   hostIp  varchar(255) DEFAULT '0.0.0.0',
   nfsOps  bigint(255) DEFAULT '0',
   firstSeen  timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
   lastSeen  timestamp  NULL,
  PRIMARY KEY ( shareId , hostId , hostIp , name )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS  `dwh_inventory`.`hhcc_nfs_host_conn_nomount`  (
   storageId  varchar(255) NOT NULL,
   protocol  varchar(48) DEFAULT NULL,
   hostId  int(11) NOT NULL DEFAULT '0',
   hostIp  varchar(255) DEFAULT '0.0.0.0',
   nfsOps  bigint(255) DEFAULT '0',
   firstSeen  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   lastSeen  timestamp  NULL,
  PRIMARY KEY ( storageId , hostId , hostIp )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;