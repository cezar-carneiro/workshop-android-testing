package workshop.com.br.example.api;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorApiException extends Exception {

    public ConversorApiException() {
    }

    public ConversorApiException(String message) {
        super(message);
    }

    public ConversorApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversorApiException(Throwable cause) {
        super(cause);
    }
}
