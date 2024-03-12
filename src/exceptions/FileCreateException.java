package exceptions;

import java.io.IOException;

public class FileCreateException extends Exception {
    IOException exception;

    public FileCreateException(String message, IOException exception) {
        super(message);
        this.exception = exception;
    }
}
