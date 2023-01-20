package course_management_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private Connection conn;
	private Statement stmt;

	public DatabaseManager(String path, String username, String password) throws SQLException {
		this.conn = DriverManager.getConnection(path, username, password);
		this.stmt = conn.createStatement();
		System.out.println("Connected to database");
		createDatabase("course_management_system");
		String query = "USE course_management_system";
		stmt.executeUpdate(query);
		createAuthTable();
	}

	public void createDatabase(String dbName) throws SQLException {
		try {
			stmt.executeUpdate("CREATE DATABASE " + dbName);
			System.out.println("Database created!");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1007)
				System.out.println("Database exists!");
			else
				throw e;
		}
	}
	
	private void createAuthTable() throws SQLException {
		try {
		String createTableSQL = "CREATE TABLE auth (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), password VARCHAR(100), role VARCHAR(20))";
		stmt.executeUpdate(createTableSQL);
		System.out.println("Table Created!");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1050) 
				System.out.println("Table exists!");
			else
				throw e;
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public Statement getStatement() {
		return stmt;
	}
}