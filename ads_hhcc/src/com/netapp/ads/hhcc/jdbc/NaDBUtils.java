package com.netapp.ads.hhcc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netapp.ads.hhcc.vo.ActiveHostBulkImport;
import com.netapp.ads.hhcc.vo.CIFSSessionsDataTableRow;
import com.netapp.ads.hhcc.vo.DWHNFSShowMount;
import com.netapp.ads.hhcc.vo.ExportsAndHost;
import com.netapp.ads.hhcc.vo.NFSImportData;
import com.netapp.ads.hhcc.vo.ShowmountImportData;
import com.netapp.ads.hhcc.vo.StorageVolume;

public class NaDBUtils {

	static JDBCMysqlConnection sqlConnection = new JDBCMysqlConnection();

	public ArrayList<DWHNFSShowMount> getDWHNFSShowMountsList(String netAppSystemName, String netAppSerialNumber) {

		ArrayList<DWHNFSShowMount> dWHShowmountList = new ArrayList<>();
		try {
			System.out.println("netAppSystemName: " + netAppSystemName);
			System.out.println("netAppSerialName: " + netAppSerialNumber);

			/*
			 * dwh_inventory.storage_node.name AS 'Storage Node Name' ,ns.shareId,
			 * ns.intVolId, ns.storageid, ns.name AS 'export', ns.hostIp AS 'ip',
			 * ns.protocol
			 */
			String query = getQueryOfControllerByNASystemAndSerNumber(netAppSystemName, netAppSerialNumber);
			sqlConnection.getConnection();
			ResultSet resultSet = sqlConnection.executeSelectQuery(query, sqlConnection.getConnection());

			// if resultSet is empty, then use dummy
			while (resultSet.next()) {
				dWHShowmountList.add(extractShowMounts(resultSet));
			}

			/*
			 * if (dWHShowmountList.size() == 0 &&
			 * NetAppADSConfig.RUN_MODE.equalsIgnoreCase(NetAppADSConfig.DRY_RUN)) {
			 * 
			 * System.out.
			 * println("showmounts not found: so getting all showmounts by ignoring input data"
			 * ); query = dummy_getQueryControllerByNASystemAndSerNumber(netAppSystemName,
			 * netAppSerialNumber); resultSet = sqlConnection.executeSelectQuery(query,
			 * sqlConnection.getConnection());
			 * 
			 * // if resultSet is empty, then use dummy while (resultSet.next()) {
			 * 
			 * dWHShowmountList.add(extractShowMounts(resultSet)); } }
			 */

			// sqlConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dWHShowmountList;
	}

	public DWHNFSShowMount extractShowMounts(ResultSet resultSet) {

		DWHNFSShowMount showmount = new DWHNFSShowMount();

		try {
			showmount.setStorageNodeName(resultSet.getString("Storage Node Name"));
			showmount.setShareId(resultSet.getInt("ns.shareId"));
			showmount.setIntVolId(resultSet.getInt("ns.intVolId"));
			showmount.setStorageid(resultSet.getInt("ns.storageid"));
			showmount.setExport(resultSet.getString("export"));
			showmount.setIp(resultSet.getString("ip"));
			showmount.setProtocol(resultSet.getString("ns.protocol"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showmount;
	}

	public static Timestamp getCurrentTimeStamp() {

		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		return timeStamp;
	}

	public static String getQueryOfControllerByNASystemAndSerNumber(String netAppSystemName,
			String netAppSerialNumber) {

		String query="SELECT dwh_inventory.storage_node.name AS 'Storage Node Name'," + 
				"                        ns.shareId," + 
				"                        ns.intVolId," + 
				"                        ns.storageid," + 
				"                        ns.name AS 'export'," + 
				"                        ns.hostIp AS 'ip'," + 
				"                        ns.protocol" + 
				"                       " + 
				"    FROM dwh_inventory.nfs_host_showmount ns" + 
				"     " + 
				"     " + 
				"    join dwh_inventory.storage_node_to_internal_volume" + 
				"                    ON ns.intVolId = dwh_inventory.storage_node_to_internal_volume.internalVolumeId" + 
				"       " + 
				"                    on dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id" + 
				"    join dwh_inventory.storage_node" + 
				"       " + 
				"    WHERE " + 
				"        dwh_inventory.storage_node.name='" + netAppSystemName + "' " + 
				"        AND dwh_inventory.storage_node.serialNumber='" + netAppSerialNumber + "'"+ 
				"        AND dwh_inventory.ns.protocol = 'NFS'";
		
		System.out.println("getQueryControllerByNASystemAndSerNumber:Query" + query);
		return query;
	}

		public static String getQueryStorageVolumes(String netAppSystemName, String netAppSerialNumber) {

		String query="SELECT " + 
				"              dwh_inventory.storage_node.id AS 'id'," + 
				"                substring_index(internal_volume.name, ':', -1) AS 'volumeName'," + 
				"                internal_volume.id AS 'intVolId'" + 
				"            FROM dwh_inventory.storage_node" + 
				"            JOIN dwh_inventory.storage_node_to_internal_volume" + 
				"                on dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id" + 
				"                join dwh_inventory.internal_volume on internal_volume.id = storage_node_to_internal_volume.internalVolumeId" + 
				"            WHERE " + 
				"                dwh_inventory.storage_node.name='"+netAppSystemName+"' " + 
				"                AND dwh_inventory.storage_node.serialNumber='"+netAppSerialNumber+"'";
		
		System.out.println("getStorageVolumes:Query:\n" + query);
		return query;
	}

	public static List<StorageVolume> getStorageVolumes(String netAppSystemName, String netAppSerialNumber) {

		String query = getQueryStorageVolumes(netAppSystemName, netAppSerialNumber);
		ResultSet resultSet = sqlConnection.executeSelectQuery(query, sqlConnection.getConnection());
		List<StorageVolume> lstStorageVolumes = new ArrayList<>();

		try {
			while (resultSet.next()) {
				StorageVolume storageVolume = new StorageVolume();
				storageVolume.setId(resultSet.getString("id"));
				storageVolume.setStorageVolumeId(resultSet.getString("intVolId"));
				storageVolume.setVolumeName(resultSet.getString("volumeName"));
				lstStorageVolumes.add(storageVolume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lstStorageVolumes;
	}

	public static List<ExportsAndHost> getCurrentExportsAndHostInfoFromWareHouse(String netAppSystemName,
			String netAppSerialNumber) {

		String query = getQueryCurrentExportsAndHostInformation(netAppSystemName, netAppSerialNumber);
		ResultSet resultSet = sqlConnection.executeSelectQuery(query, sqlConnection.getConnection());

		List<ExportsAndHost> listEexportAndHosts = new ArrayList<>();
		try {
			// if resultSet is empty, then use dummy
			while (resultSet.next()) {
				ExportsAndHost exportsAndHostInfo = new ExportsAndHost();
				exportsAndHostInfo.setStorageNodeName(resultSet.getString("Storage Node Name"));
				exportsAndHostInfo.setInternalVolumeId(resultSet.getString("internalVolumeId"));
				exportsAndHostInfo.setId(resultSet.getString("ns.id"));
				exportsAndHostInfo.setFileshareId(resultSet.getString("ns.fileshareId"));
				exportsAndHostInfo.setStorageid(resultSet.getString("ns.storageid"));
				exportsAndHostInfo.setIdentifier(resultSet.getString("ns.identifier"));
				exportsAndHostInfo.setName(resultSet.getString("ns.name"));
				exportsAndHostInfo.setProtocol(resultSet.getString("ns.protocol"));
				exportsAndHostInfo.setIpinterfaces(resultSet.getString("ns.ipinterfaces"));

				listEexportAndHosts.add(exportsAndHostInfo);
				// dWHShowmountList.add(extractShowMounts(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// sqlConnection.closeConnection();
		return listEexportAndHosts;

		// return dWHShowmountList;

	}

	public static String getQueryCurrentExportsAndHostInformation(String netAppSystemName, String netAppSerialNumber) {

		String strQuery="SELECT dwh_inventory.storage_node.name AS 'Storage Node Name'," + 
				"                dwh_inventory.qtree.internalVolumeId," + 
				"                ns.id," + 
				"                ns.fileshareId," + 
				"                ns.storageid," + 
				"                ns.identifier," + 
				"                ns.name," + 
				"                ns.protocol," + 
				"                ns.ipinterfaces" + 
				"" + 
				"            FROM dwh_inventory.nas_share ns" + 
				"" + 
				"            Join dwh_inventory.nas_file_share" + 
				"                on ns.fileshareId = dwh_inventory.nas_file_share.id" + 
				"" + 
				"            join dwh_inventory.qtree" + 
				"                on dwh_inventory.nas_file_share.qtreeid = dwh_inventory.qtree.id" + 
				"" + 
				"            join dwh_inventory.storage_node_to_internal_volume" + 
				"                ON dwh_inventory.qtree.internalVolumeId = dwh_inventory.storage_node_to_internal_volume.internalVolumeId" + 
				"" + 
				"            join dwh_inventory.storage_node" + 
				"                on dwh_inventory.storage_node_to_internal_volume.storageNodeId = dwh_inventory.storage_node.id" + 
				"" + 
				"            WHERE " + 
				"                dwh_inventory.storage_node.name='"+netAppSystemName+"' " + 
				"                AND dwh_inventory.storage_node.serialNumber='"+netAppSerialNumber+"'" + 
				"                AND dwh_inventory.ns.protocol = 'NFS' ";
		

		System.out.println("getCurrentExportsAndHostInformation: Query:\n" + strQuery);

		return strQuery;
	}

	public static String getQueryCreateNFSHostConnTable() {

		String query = "CREATE TABLE IF NOT EXISTS dwh_inventory.nfs_host_conn ( " + "shareId int(11) NOT NULL, "
				+ "intVolId int(11) NOT NULL, " + "name varchar(255) NOT NULL, " + "protocol varchar(48) DEFAULT NULL, "
				+ "hostId int(11) NOT NULL DEFAULT '0', " + "hostIp varchar(255) DEFAULT '0.0.0.0', "
				+ "nfsOps bigint(255) DEFAULT '0', " + "firstSeen timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ "lastSeen timestamp NOT NULL DEFAULT '0000-00-00 00:00:00', "
				+ "PRIMARY KEY (shareId,hostId,hostIp,name) " + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

		return query;

	}

	public static String getQueryCreateNFSHostConnNoMountTable() {

		String query = "CREATE TABLE IF NOT EXISTS dwh_inventory.nfs_host_conn_nomount ( "
				+ "storageId varchar(255) NOT NULL, " + "protocol varchar(48) DEFAULT NULL, "
				+ "hostId int(11) NOT NULL DEFAULT '0', " + "hostIp varchar(255) DEFAULT '0.0.0.0', "
				+ "nfsOps bigint(255) DEFAULT '0', " + "firstSeen timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ "lastSeen timestamp NOT NULL DEFAULT '0000-00-00 00:00:00', "
				+ "PRIMARY KEY (storageId,hostId,hostIp) " + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
		return query;

	}

	/*
	 * public static String importInactiveHostInformation(int shareId, int intVolId,
	 * String name, String protocol, int hostId, String hostIp, long nfsOps,
	 * Timestamp firstSeen, Timestamp lastSeen) {
	 * 
	 * 
	 * INSERT INTO dwh_inventory.nfs_host_conn
	 * (shareId,intVolId,name,protocol,hostId,hostIp,nfsOps,lastSeen,firstSeen)
	 * VALUES (11,12,'name1','12',12,'12.12.12.12',1,CURRENT_TIME(),CURRENT_TIME()
	 * ON DUPLICATE KEY UPDATE lastSeen=now()")"
	 * 
	 * String query = "INSERT INTO dwh_inventory.nfs_host_conn " +
	 * "(shareId,intVolId,name,protocol,hostId,hostIp,nfsOps,firstSeen,lastSeen) " +
	 * " VALUES " + "(?,?,?,?,?,?,?,?,?) " +
	 * " ON DUPLICATE KEY UPDATE lastSeen=now()";
	 * 
	 * return query;
	 * 
	 * }
	 */

	public static void importNFSActiveHostInformation(NFSImportData nfsImportData,Timestamp currentTimeStamp) {

		String shareId = nfsImportData.getShareId();
		String internalVolId = nfsImportData.getInternalVolId();
		String name = nfsImportData.getName();
		String protocol = nfsImportData.getProtocol();
		String hostId = nfsImportData.getHostId();
		String ip = nfsImportData.getIp();
		String operation = nfsImportData.getOperation();

		String query = "INSERT INTO dwh_inventory.nfs_host_conn "
				+ "(shareId,intVolId,name,protocol,hostId,hostIp,nfsOps,lastSeen,firstSeen)  " + "VALUES  " + "("
				+ "?,?,?,?,?,?,?,?,?,?)  " + "ON DUPLICATE KEY UPDATE lastSeen=now()";
		Connection conn = sqlConnection.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, shareId);
			psmt.setString(2, internalVolId);
			psmt.setString(3, name);
			psmt.setString(4, protocol);
			psmt.setString(5, hostId);
			psmt.setString(6, ip);
			psmt.setString(7, operation);
			psmt.setTimestamp(8, currentTimeStamp);
			psmt.setTimestamp(9, currentTimeStamp);

			psmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String importInactiveHostInformation(ActiveHostBulkImport activeHostBulkImport,Timestamp currentTimeStamp) {

		String strStorageId = activeHostBulkImport.getStorageId();
		String protocol = activeHostBulkImport.getProtocol();
		String hostId = activeHostBulkImport.getHostId();
		String hostIp = activeHostBulkImport.getHostIp();
		String nfsOps = activeHostBulkImport.getNfsOps();

		String strQuery = "INSERT INTO dwh_inventory.nfs_host_conn_nomount "
				+ "            (storageId,protocol,hostId,hostIp,nfsOps,lastSeen) " + "         VALUES "
				+ "             (?,?,?,?,?,?) " + "         ON DUPLICATE KEY UPDATE lastSeen=now()";

		Connection conn = sqlConnection.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(strQuery);
			psmt.setInt(1, 1);
			psmt.setString(2, protocol);
			psmt.setString(3, hostId);
			psmt.setString(4, hostIp);
			psmt.setString(5, nfsOps);
			psmt.setTimestamp(6, currentTimeStamp);
			// psmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			psmt.execute();

			// sqlConnection.executeSelectQuery(query, sqlConnection.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strQuery;
	}

	public static void main(String[] args) {

		// getStorageVolumesQuery(null,null); // NO DATA
		// getCurrentExportsAndHostInformation(null,null);

	}

	public static Map<String, String> getHostIds() {

		Map<String, String> hostIdIpMap = new HashMap<>();
		String query = "SELECT ip,id FROM dwh_inventory.host";

		ResultSet resultSet = sqlConnection.executeSelectQuery(query, sqlConnection.getConnection());

		try {
			while (resultSet.next()) {

				hostIdIpMap.put(resultSet.getString("ip"), resultSet.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hostIdIpMap;
	}

	public static void insertIntoWCRCifsTemp(CIFSSessionsDataTableRow cIFSDataRow) {

		String strQuery = "insert into table wcr_cifs_temp(DateTime,ControllerName,SerialNumber,VfilerName,VfilerUuid,VolumeName,ShareName,MountPoint,HostIp,HostName,WindowsUser,UnixUser) "
				+ "		Values " + "(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = sqlConnection.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(strQuery);
			psmt.setTimestamp(1, cIFSDataRow.getDateTime());
			psmt.setString(2, cIFSDataRow.getControllerName());
			psmt.setString(3, cIFSDataRow.getSerialNumber());
			psmt.setString(4, cIFSDataRow.getvFileName());
			psmt.setString(5, cIFSDataRow.getvFilerUuid());
			psmt.setString(6, cIFSDataRow.getVolumeName());
			psmt.setString(7, cIFSDataRow.getShareName());
			psmt.setString(8, cIFSDataRow.getMountPoint());
			psmt.setString(9, cIFSDataRow.getHostIp());
			psmt.setString(10, cIFSDataRow.getHostName());
			psmt.setString(11, cIFSDataRow.getWindowUser());
			psmt.setString(12, cIFSDataRow.getUnixUser());
			psmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoHostShowmount(ShowmountImportData showmountRow,Timestamp currentTimeStamp) {

		String strQuery = "INSERT INTO dwh_inventory.nfs_host_showmount "
				+ "   (shareId,intVolId,storageId,name,protocol,hostIp,lastSeen) VALUES "
				+ "	(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE lastSeen=now()";
		Connection conn = sqlConnection.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(strQuery);
			psmt.setString(1, showmountRow.getShareId());
			psmt.setString(2, showmountRow.getInternalVolId());
			psmt.setString(3, showmountRow.getStorageId());
			psmt.setString(4, showmountRow.getName());
			psmt.setString(5, showmountRow.getProtocol());
			psmt.setString(6, showmountRow.getHostIp());
			psmt.setTimestamp(7, currentTimeStamp);
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void releaseDBConnections() {
		sqlConnection.closeConnection();
	}
	/*
	 * public static void createNFSHostConnNoMountTable() {
	 * 
	 * Connection conn = sqlConnection.getConnection();
	 * sqlConnection.executeSelectQuery(query, connection);
	 * 
	 * String query=getQueryCreateNFSHostConnNoMountTable();
	 * 
	 * 
	 * }
	 */

	/*
	 * public static void importInactiveHostInformation(String storageId, String
	 * protocol, String hostId, String hostIp, String nfsOps) {
	 * 
	 * getInsertQueryNFSHostConnNoMount(shareId, intVolId, name, protocol, hostId,
	 * hostIp, nfsOps, firstSeen, lastSeen);
	 * 
	 * }
	 */

}
