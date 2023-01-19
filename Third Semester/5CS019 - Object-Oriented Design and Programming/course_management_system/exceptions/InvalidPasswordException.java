package course_management_system.exceptions;

public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 3761449227809409477L;
	public InvalidPasswordException(String message) {
		super(message);
	}
}
