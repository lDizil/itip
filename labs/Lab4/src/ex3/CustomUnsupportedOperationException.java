package ex3;

public class CustomUnsupportedOperationException extends UnsupportedOperationException {
    public CustomUnsupportedOperationException(String message) {
        super(message);
    }
}
