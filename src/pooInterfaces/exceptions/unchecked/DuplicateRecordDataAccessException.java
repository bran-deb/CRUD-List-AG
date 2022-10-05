package pooInterfaces.exceptions.unchecked;

public class DuplicateRecordDataAccessException extends WriteDataAccessException {


    public DuplicateRecordDataAccessException(String message) {
        super(message);
    }

    public DuplicateRecordDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
