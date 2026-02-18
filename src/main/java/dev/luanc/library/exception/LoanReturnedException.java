package dev.luanc.library.exception;

public class LoanReturnedException extends RuntimeException {
    public LoanReturnedException(String message) {
        super(message);
    }
}
