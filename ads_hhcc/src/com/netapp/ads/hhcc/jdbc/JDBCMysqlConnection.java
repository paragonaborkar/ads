package com.netapp.ads.hhcc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMysqlConnection {

	static Connection connection = null;
	static Statement stmt = null;

	public JDBCMysqlConnection() {

		getConnection();
	}

	public static Connection getConnection() {

		try {

			if (connection == null) {

				Class.forName("com.mysql.jdbc.Driver");
				// connection =
				// DriverManager.getConnection("jdbc:mysql://localhost:3308/dwh_inventory",
				// "root", "adsAdmin1");
				connection = DriverManager.getConnection("jdbc:mysql://10.216.15.36:3306/dwh_inventory", "root",
						"ugauga");
				System.out.println("Connected database successfully...");

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
			System.out.println("Connected closed successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		getConnection();
		// getLast10OrdersInAscOrders();
		closeConnection();
	}

	public ResultSet executeSelectQuery(String query, Connection connection) {

		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
