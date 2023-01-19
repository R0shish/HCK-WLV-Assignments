package course_management_system.exceptions;

public class InvalidEmailException extends Exception {

	private static final long serialVersionUID = -8145316108548232390L;
	public InvalidEmailException(String message) {
		super(message);
	}
}
