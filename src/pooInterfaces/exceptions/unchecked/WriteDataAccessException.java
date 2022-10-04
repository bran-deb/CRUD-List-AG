package pooInterfaces.exceptions.unchecked;

public class WriteDataAccessException extends DataAccessException {
    public WriteDataAccessException(String message) {
        super(message);
    }

    public WriteDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
