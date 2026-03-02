package dev.luanc.library.exception;

public class BookCopyNotAvailableException extends RuntimeException {
    public BookCopyNotAvailableException(String message) {
        super(message);
    }
}
