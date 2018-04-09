package com.paragon.netapp.projectUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DatabaseManager 
{
	public static Connection conn;
	
	
	/**
	 * @return
	 * @throws Exception
	 * Method to make a com=nnection getConnection to Maria DB
	 */
	public static Connection getConnection() throws Exception
	{
		String DBurl=ProjectUtility.getProperty("DBNAME");
		String DBusername=ProjectUtility.getProperty("DBUSERNAME");
		String DBpassword=ProjectUtility.getProperty("DBPASSWORD");
		
		System.out.println(DBurl+"   "+DBusername+"   "+DBpassword);
		
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(DBurl, DBusername, DBpassword);
		System.out.println("***********************DB connnected");
		return conn;
	}
	
	/**
	 * @param userName
	 * @return
	 * @throws Exception
	 * Verify User In database.
	 */
	public static ResultSet verifyUserinDB(String userName) throws Exception
	{
		ResultSet rs=DatabaseManager.getUserInfo(userName);
		return rs;
	}
	

	/**
	 * @param username
	 * @return
	 * @throws Exception
	 * SQL Query to validate in Database for User created in Admin Module.
	 */
	public static ResultSet getUserInfo(String username) throws Exception
	{
		String sql="select user_name,first_name,last_name,email, case "
				+ "when user_role_id=1 then 'ROLE_USER'"
				+ "when user_role_id=2 then 'ROLE_ADMIN' "
				+ "when user_role_id=3 then 'ROLE_RUSER' "
				+ "when user_role_id=4 then 'ROLE_SUPERUSER' "
				+ "when user_role_id=5 then 'ROLE_MSLEAD' "
				+ "else 'not defined' END as user_role_id , "
				+ "case	when enabled=1 then 'Yes' "
				+ "else 'No'	END as enabled	"
				+ "from user_native where user_name='"+username+"'";
		
		conn=DatabaseManager.getConnection();
		
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		
		return rs;
	}
}
