package pooInterfaces.exceptions.checked;

public class DuplicateRecordDataAccessException extends WriteDataAccessException{

    public DuplicateRecordDataAccessException(String message) {
        super(message);
    }
}
