package silly.exception;

/**
 * @author gacl
 * 自定义异常
 */
public class ExistException extends Exception {

	public ExistException() {
		super();
	}

	public ExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistException(String message) {
		super(message);
	}

	public ExistException(Throwable cause) {
		super(cause);
	}
}
