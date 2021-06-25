package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	private static Connection conn = null;

	// Define a method to get the connection
	public static Connection getConnection() {

		try {
			// Check if connection exists
			if (conn == null) {
				// hot-fix to ensure driver loads correctly when application starts
				Class.forName("org.postgresql.Driver");

				// In order to establish a connection to our DB we need our credentials
				Properties props = new Properties();

				InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");

				props.load(input);

				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");

				conn = DriverManager.getConnection(url, username, password);
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		Connection conn = JDBCConnection.getConnection();

		if (conn == null) {
			System.out.println("Unable to Connect");
		} else {
			System.out.println("Connection Successful");
		}
	}
}
