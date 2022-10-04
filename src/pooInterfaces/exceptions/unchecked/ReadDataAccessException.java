package pooInterfaces.exceptions.unchecked;

public class ReadDataAccessException extends DataAccessException {
    public ReadDataAccessException(String message) {
        super(message);
    }

    public ReadDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
