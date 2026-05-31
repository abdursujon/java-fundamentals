package custom_unchecked_exceptions;

public class InvalidAccountStateException extends RuntimeException {
    public InvalidAccountStateException(String message){
        super(message);
    }
}
