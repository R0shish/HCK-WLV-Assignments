package course_management_system.auth;

import java.util.ArrayList;

import course_management_system.exceptions.InvalidEmailException;
import course_management_system.exceptions.InvalidPasswordException;

class Credential{
	private final String name;
	private final String email;
	private final String password;
	
	public Credential(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
public class Auth {
	static ArrayList<Credential> credential = new ArrayList<Credential>();
	
	public static String returnName(String email, String password) throws Exception {
	    for (Credential c : credential) {
	        if (c.getEmail().equals(email)) {
	        	if (c.getPassword().equals(password))
	        		return c.getName();
	        	throw new InvalidPasswordException("Password not valid!");
	        }
	        	
	    }
	    throw new InvalidEmailException("No User with Email Found!");
	}
	
	public static void addCredential(String name, String email, String password ) throws InvalidEmailException{
		 for (Credential c : credential) {
		        if (c.getEmail().equals(email)) {
		        	throw new InvalidEmailException("Email already in use!");
		        }
		 }
		 credential.add(new Credential(name, email, password));
	}
}
