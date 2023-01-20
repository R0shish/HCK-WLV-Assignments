package course_management_system.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import course_management_system.exceptions.InvalidEmailException;
import course_management_system.exceptions.InvalidPasswordException;
import course_management_system.util.DatabaseManager;

public class Auth {
	private static Statement stmt;
	public Auth(DatabaseManager db) {
		Auth.stmt = db.getStatement();
	}
	
	  public static String returnRole(String email, String password) throws Exception {
	        try {
	            String sql = "SELECT name FROM auth WHERE email='" + email + "' AND password='" + password + "'";
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                return rs.getString("name");
	            } else {
	                throw new InvalidPasswordException("Password not valid!");
	            }
	        } catch (SQLException e) {
	            throw new InvalidEmailException("No user with this email found!");
	        }
	    }
	
	  public static void addCredential(String name, String email, String password) throws Exception {
	        try {
	            String sql = "SELECT email FROM auth WHERE email='" + email + "'";
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                throw new InvalidEmailException("Email already in use!");
	            } else {
	            	sql = "INSERT INTO auth (name, email, password, role) VALUES ('" + name + "', '" + email + "', '" + password + "', 'Student')";
	                stmt.executeUpdate(sql);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 }
