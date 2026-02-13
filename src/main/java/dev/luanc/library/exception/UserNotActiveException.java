package dev.luanc.library.exception;

public class UserNotActiveException extends RuntimeException{
    public UserNotActiveException(String message) {
        super(message);
    }
}
