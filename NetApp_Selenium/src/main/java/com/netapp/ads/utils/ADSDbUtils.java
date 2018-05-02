package com.netapp.ads.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.DbUtils;

public class ADSDbUtils {
	private static Connection connection;
	
	public static void setUpDB() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(ProjectUtility.getProperty("DBURL"), ProjectUtility.getProperty("DBUSERNAME"), ProjectUtility.getProperty("DBPASSWORD"));
	}
	
	public static void closeBD() {
		DbUtils.closeQuietly(connection);
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
