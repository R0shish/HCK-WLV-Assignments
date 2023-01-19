package course_management_system.models;

abstract class SystemUser {
	String name;
	public SystemUser(String name){
		this.name = name;
	}
	abstract void signup(String name, String email, String password);
	abstract void login(String email, String password);
}
