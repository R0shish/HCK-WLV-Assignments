package Week10_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {
	private Connection conn;
	private Statement stmt;

	public DatabaseManager(String path, String username, String password) throws SQLException {
		this.conn = DriverManager.getConnection(path, username, password);
		this.stmt = conn.createStatement();
		System.out.println("Connected to database");
		createDatabase("week10_assignment");
		String query = "USE week10_assignment";
		stmt.executeUpdate(query);
		createUserTable();
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

	private void createUserTable() throws SQLException {
		try {
			String createTableSQL = "CREATE TABLE user (id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(65), last_name VARCHAR(65))";
			stmt.executeUpdate(createTableSQL);
			System.out.println("Table Created!");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1050)
				System.out.println("Table exists!");
			else
				throw e;
		}
	}

	public String[][] getAllUsers() {
		String sql = "SELECT * FROM user";
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				User user = new User(id, firstName, lastName);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String userData[][] = new String[users.size()][3];
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			userData[i][0] = Integer.toString(user.getId());
			userData[i][1] = user.getFirstName();
			userData[i][2] = user.getLastName();
		}

		return userData;
	}

	public void insertUser(String firstName, String lastName) {
		String sql = "INSERT INTO `user`(`first_name`, `last_name`) VALUES ('" + firstName + "','" + lastName + "');";
		try {
			stmt.executeUpdate(sql);
			System.out.println("Inserted Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public Statement getStatement() {
		return stmt;
	}
}