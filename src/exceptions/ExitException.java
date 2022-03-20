package exceptions;

public class ExitException extends RuntimeException{
    public ExitException(String e) {
        super(e);
    }
}
