package exceptions;

import java.io.IOException;

public class FileWriteException extends Exception {
    IOException exception;

    public FileWriteException(String message, IOException exception) {
        super(message);
        this.exception = exception;
    }
}

