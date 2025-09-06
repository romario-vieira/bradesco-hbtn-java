package exceptions;

public class LivroInvalidoException extends RuntimeException {
    public LivroInvalidoException(String message) {
        super(message);
    }
}
