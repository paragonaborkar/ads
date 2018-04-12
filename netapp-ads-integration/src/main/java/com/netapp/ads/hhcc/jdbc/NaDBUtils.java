package com.netapp.ads.hhcc.jdbc;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.netapp.ads.hhcc.converters.HHCCConstants;
import com.netapp.ads.hhcc.vo.ActiveHostBulkImport;
import com.netapp.ads.hhcc.vo.DWHNFSShowMount;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.NFSImportData;
import com.netapp.ads.hhcc.vo.ShowmountImportData;
import com.netapp.ads.hhcc.vo.StorageVolume;

@Service
public class NaDBUtils {

	private static final Logger log = LoggerFactory.getLogger(NaDBUtils.class);
	
	@Autowired
	@Qualifier("ociJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	public ArrayList<DWHNFSShowMount> getDWHNFSShowMountsList(String netAppSystemName, String netAppSerialNumber) {
		ArrayList<DWHNFSShowMount> dWHShowmountList = new ArrayList<>();
		log.debug("getDWHNFSShowMountsList(): netAppSystemName: {}, netAppSerialName: {}", netAppSystemName, netAppSerialNumber);
		String query = getQueryOfControllerByNASystemAndSerNumber(netAppSystemName, netAppSerialNumber);
		log.debug("getDWHNFSShowMountsList(): Query: {}", query);
		List<Map<String, Object>> showMounts =  jdbcTemplate.queryForList(query);
		for(Map<String, Object> showMountMap: showMounts) {
			DWHNFSShowMount showmount = new DWHNFSShowMount();
			showmount.setStorageNodeName((String) showMountMap.get("Storage Node Name"));
			showmount.setShareId((int) showMountMap.get("shareId"));
			showmount.setIntVolId((int) showMountMap.get("intVolId"));
			showmount.setStorageid((int) showMountMap.get("storageid"));
			showmount.setExport((String) showMountMap.get("export"));
			showmount.setIp((String) showMountMap.get("ip"));
			showmount.setProtocol((String) showMountMap.get("protocol"));
			dWHShowmountList.add(showmount);
		}
		return dWHShowmountList;
	}

	public static String getCurrentTimeStamp() {

		SimpleDateFormat format = new SimpleDateFormat(HHCCConstants.STR_DATE_FORMAT);
		String strDate = format.format(new java.util.Date());
		return strDate;
	}

	public static String getQueryOfControllerByNASystemAndSerNumber(String netAppSystemName,
			String netAppSerialNumber) {

		String query = "SELECT dwh_inventory.storage_node.name AS 'Storage Node Name',"
				+ " ns.shareId,ns.intVolId,"
				+ " ns.storageid,ns.name AS 'export',"
				+ " ns.hostIp AS 'ip',ns.protocol"
				+ " FROM dwh_inventory.nfs_host_showmount ns"
				+ " JOIN dwh_inventory.storage_node_to_internal_volume"
				+ " ON ns.intVolId = dwh_inventory.storage_node_to_internal_volume.internalVolumeId"
				+ " JOIN dwh_inventory.storage_node"
				+ " ON dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id"
				+ " WHERE dwh_inventory.storage_node.name='" + netAppSystemName + "' "
				+ " AND dwh_inventory.storage_node.serialNumber='" + netAppSerialNumber + "'"
				+ " AND dwh_inventory.ns.protocol = 'NFS'";
		
		log.debug("getQueryOfControllerByNASystemAndSerNumber(): Query: {}", query);
		return query;
	}

	public static String getQueryStorageVolumes(String netAppSystemName, String netAppSerialNumber) {

		String query = "SELECT dwh_inventory.storage_node.id AS 'id',"
				+ " substring_index(internal_volume.name, ':', -1) AS 'volumeName',"
				+ " internal_volume.id AS 'intVolId' FROM dwh_inventory.storage_node"
				+ " JOIN dwh_inventory.storage_node_to_internal_volume"
				+ " ON dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id"
				+ " JOIN dwh_inventory.internal_volume ON internal_volume.id = storage_node_to_internal_volume.internalVolumeId"
				+ " WHERE dwh_inventory.storage_node.name='" + netAppSystemName + "' "
				+ " AND dwh_inventory.storage_node.serialNumber='" + netAppSerialNumber + "'";
		log.debug("getQueryStorageVolumes(): Query: {}", query);
		return query;
	}

	public List<StorageVolume> getStorageVolumes(String netAppSystemName, String netAppSerialNumber) {

		String query = getQueryStorageVolumes(netAppSystemName, netAppSerialNumber);
		List<StorageVolume> lstStorageVolumes = new ArrayList<>();
		List<Map<String, Object>> storageVolumes =  jdbcTemplate.queryForList(query);
		for(Map<String, Object> storageVolumeMap: storageVolumes) {
			StorageVolume storageVolume = new StorageVolume();
			storageVolume.setId(String.valueOf(storageVolumeMap.get("id")));
			storageVolume.setStorageVolumeId(String.valueOf(storageVolumeMap.get("intVolId")));
			storageVolume.setVolumeName(String.valueOf(storageVolumeMap.get("volumeName")));
			lstStorageVolumes.add(storageVolume);
		}

		return lstStorageVolumes;
	}

	public List<ExportsAndHost> getCurrentExportsAndHostInfoFromWareHouse(String netAppSystemName,
			String netAppSerialNumber) {

		String query = getQueryCurrentExportsAndHostInformation(netAppSystemName, netAppSerialNumber);
		List<Map<String, Object>> exportsAndHosts =  jdbcTemplate.queryForList(query);
		List<ExportsAndHost> listEexportAndHosts = new ArrayList<>();
		for(Map<String, Object> exportsAndHostsMap: exportsAndHosts) {
			ExportsAndHost exportsAndHostInfo = new ExportsAndHost();
			exportsAndHostInfo.setStorageNodeName((String) exportsAndHostsMap.get("Storage Node Name"));
			exportsAndHostInfo.setInternalVolumeId(String.valueOf(exportsAndHostsMap.get("internalVolumeId")));
			exportsAndHostInfo.setId(String.valueOf(exportsAndHostsMap.get("ns.id")));
			exportsAndHostInfo.setFileshareId(String.valueOf(exportsAndHostsMap.get("ns.fileshareId")));
			exportsAndHostInfo.setStorageid(String.valueOf(exportsAndHostsMap.get("ns.storageid")));
			exportsAndHostInfo.setIdentifier(String.valueOf(exportsAndHostsMap.get("ns.identifier")));
			exportsAndHostInfo.setName(String.valueOf(exportsAndHostsMap.get("ns.name")));
			exportsAndHostInfo.setProtocol(String.valueOf(exportsAndHostsMap.get("ns.protocol")));
			exportsAndHostInfo.setIpinterfaces(String.valueOf(exportsAndHostsMap.get("ns.ipinterfaces")));
			listEexportAndHosts.add(exportsAndHostInfo);
		}
		return listEexportAndHosts;

		// return dWHShowmountList;

	}

	public static String getQueryCurrentExportsAndHostInformation(String netAppSystemName, String netAppSerialNumber) {

		String strQuery = "SELECT dwh_inventory.storage_node.name AS 'Storage Node Name',"
				+ "dwh_inventory.qtree.internalVolumeId,ns.id,"
				+ " ns.fileshareId,ns.storageid,ns.identifier,"
				+ " ns.name,ns.protocol,ns.ipinterfaces"
				+ " FROM dwh_inventory.nas_share ns JOIN dwh_inventory.nas_file_share"
				+ " ON ns.fileshareId = dwh_inventory.nas_file_share.id"
				+ " JOIN dwh_inventory.qtree"
				+ " ON dwh_inventory.nas_file_share.qtreeid = dwh_inventory.qtree.id"
				+ " JOIN dwh_inventory.storage_node_to_internal_volume"
				+ " ON dwh_inventory.qtree.internalVolumeId = dwh_inventory.storage_node_to_internal_volume.internalVolumeId"
				+ " JOIN dwh_inventory.storage_node"
				+ " ON dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id"
				+ " WHERE dwh_inventory.storage_node.name='" + netAppSystemName + "'"
				+ " AND dwh_inventory.storage_node.serialNumber='" + netAppSerialNumber + "'"
				+ " AND dwh_inventory.ns.protocol = 'NFS'";

		log.debug("getQueryCurrentExportsAndHostInformation(): Query: {}", strQuery);
		return strQuery;
	}

	public static String getQueryCreateNFSHostConnTable() {

		String query = "CREATE TABLE IF NOT EXISTS dwh_inventory.nfs_host_conn ( " + "shareId int(11) NOT NULL, "
				+ "intVolId int(11) NOT NULL, " + "name varchar(255) NOT NULL, " + "protocol varchar(48) DEFAULT NULL, "
				+ "hostId int(11) NOT NULL DEFAULT '0', " + "hostIp varchar(255) DEFAULT '0.0.0.0', "
				+ "nfsOps bigint(255) DEFAULT '0', " + "firstSeen timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ "lastSeen timestamp NOT NULL DEFAULT '0000-00-00 00:00:00', "
				+ "PRIMARY KEY (shareId,hostId,hostIp,name) " + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		log.debug("getQueryCreateNFSHostConnTable(): Query: {}", query);
		return query;

	}

	public static String getQueryCreateNFSHostConnNoMountTable() {

		String query = "CREATE TABLE IF NOT EXISTS dwh_inventory.nfs_host_conn_nomount ( "
				+ "storageId varchar(255) NOT NULL, " + "protocol varchar(48) DEFAULT NULL, "
				+ "hostId int(11) NOT NULL DEFAULT '0', " + "hostIp varchar(255) DEFAULT '0.0.0.0', "
				+ "nfsOps bigint(255) DEFAULT '0', " + "firstSeen timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ "lastSeen timestamp NOT NULL DEFAULT '0000-00-00 00:00:00', "
				+ "PRIMARY KEY (storageId,hostId,hostIp) " + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		log.debug("getQueryCreateNFSHostConnNoMountTable(): Query: {}", query);
		return query;

	}

	public void importNFSActiveHostInformation(NFSImportData nfsImportData, String currentTimeStamp) {
		String shareId = nfsImportData.getShareId();
		String internalVolId = nfsImportData.getInternalVolId();
		String name = nfsImportData.getName();
		String protocol = nfsImportData.getProtocol();
		String hostId = nfsImportData.getHostId();
		String ip = nfsImportData.getIp();
		String operation = nfsImportData.getOperation();

		String query = "INSERT INTO dwh_inventory.nfs_host_conn "
				+ "(shareId,intVolId,name,protocol,hostId,hostIp,nfsOps,lastSeen,firstSeen)  " + "VALUES  " + "("
				+ "?,?,?,?,?,?,?,?,?)  " + "ON DUPLICATE KEY UPDATE lastSeen=now()";
		log.debug("importNFSActiveHostInformation(): Query: {}", query);
		
		Timestamp timeStamp = getSQLDate(currentTimeStamp);
		Object[] params = {shareId, internalVolId, name, protocol, hostId, ip, operation, timeStamp, timeStamp};
		jdbcTemplate.update(query, params);
	}

	public static Timestamp getSQLDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(HHCCConstants.STR_DATE_FORMAT);
		Timestamp time = null;
		try {
			time = new Timestamp(sdf.parse(strDate).getTime());
		} catch (ParseException e) {
			log.error("getSQLDate(): Error parsing date: {}", strDate);
		}
		return time;
	}

	public String importInactiveHostInformation(ActiveHostBulkImport activeHostBulkImport,
		String currentTimeStamp) {

		String strQuery = "INSERT INTO dwh_inventory.nfs_host_conn_nomount "
				+ " (storageId,protocol,hostId,hostIp,nfsOps,lastSeen) VALUES "
				+ " (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE lastSeen=now()";
		log.debug("importInactiveHostInformation(): Query: {}", strQuery);
		
		Object[] params = {1, activeHostBulkImport.getProtocol(), activeHostBulkImport.getHostId(), activeHostBulkImport.getHostIp() ,activeHostBulkImport.getNfsOps(), currentTimeStamp};
		jdbcTemplate.update(strQuery, params);
		return strQuery;
	}

	public Map<String, String> getHostIds() {
		Map<String, String> hostIdIpMap = new HashMap<>();
		String query = "SELECT ip,id FROM dwh_inventory.host";
		List<Map<String, Object>> hostIdIps =  jdbcTemplate.queryForList(query);
		for(Map<String, Object> hostIdIp: hostIdIps) {
			hostIdIpMap.put(String.valueOf(hostIdIp.get("ip")), String.valueOf(hostIdIp.get("id")));
		}
		return hostIdIpMap;
	}

	public void insertIntoHostShowmount(ShowmountImportData showmountRow, String currentTimeStamp) {

		String strQuery = "INSERT INTO dwh_inventory.nfs_host_showmount"
				+ " (shareId,intVolId,storageId,name,protocol,hostIp,lastSeen,firstSeen) VALUES "
				+ "	(?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE lastSeen=now()";
		log.debug("insertIntoHostShowmount(): Query: {}", strQuery);
		
		Timestamp timeStamp = getSQLDate(currentTimeStamp);
		Object[] params = {showmountRow.getShareId(), showmountRow.getInternalVolId(), showmountRow.getStorageId(), showmountRow.getName()
		,showmountRow.getProtocol(), showmountRow.getHostIp(), timeStamp, timeStamp
		};
		jdbcTemplate.update(strQuery, params);
;
	}
}
