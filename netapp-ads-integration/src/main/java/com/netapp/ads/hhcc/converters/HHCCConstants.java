package com.netapp.ads.hhcc.converters;

public class HHCCConstants {

	public static final String NA_API_SYSTEM_GET_INFO = "system-get-info";
	public static final String NA_API_NET_IFCONFIG_GET = "net-ifconfig-get";
	public static final String NA_API_VFILER_LIST_INFO = "vfiler-list-info";
	public static final String NA_API_NFS_STAT_START = "nfs-stats-top-clients-list-iter-start";
	public static final String NA_API_NFS_STAT_CLIENTS = "nfs-stats-top-clients-list-iter-next";
	public static final String NA_API_NFS_STATS_ZERO_STATS = "nfs-stats-zero-stats";
	
	public static final String NA_API_CIFS_STATUS = "cifs-status";
	public static final String NA_API_CIFS_SESSION_LIST_ITER_START = "cifs-session-list-iter-start";
	public static final String NA_API_CIFS_SESSION_LIST_ITER_NEXT = "cifs-session-list-iter-next";
	public static final String NA_API_CLOCK_GET_CLOCK = "clock-get-clock";
	
	
	public static final String MAX_CLIENTS = "maxclients";
	public static final String TAG = "tag";
	public static final String MAXIMUM = "maximum";

	public static final boolean TESTING = true;

	public static final String NW_API_SHOWMOUNT = "showmount -a ";

	public static final String STR_VFILER = "vfiler";

	public static final String STR_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	
	public static final String DWH_INVENTORY = "dwh_inventory";
	public static final String TBL_CIFS_TEMP = DWH_INVENTORY + ".hhcc_cifs_temp";
	public static final String TBL_STORAGE_NODE = DWH_INVENTORY + ".storage_node";
	public static final String TBL_NFS_HOST_CONN = DWH_INVENTORY + ".nfs_host_conn";
	public static final String TBL_NFS_HOST_CONN_NO_MOUNT = DWH_INVENTORY + ".nfs_host_conn_nomount";
	public static final String TBL_NFS_HOST_SHOW_MOUNT = DWH_INVENTORY + ".nfs_host_showmount";
	public static final String TBL_HOST = DWH_INVENTORY + ".host";
}
