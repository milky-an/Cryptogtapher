package exceptions;

import java.io.IOException;

public class FileReadException extends Exception {
    IOException exception;

    public FileReadException(String message, IOException exception) {
        super(message);
        this.exception = exception;
    }
}
