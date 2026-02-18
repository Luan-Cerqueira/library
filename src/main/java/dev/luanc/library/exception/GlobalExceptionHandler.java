package dev.luanc.library.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorMessage errorBody = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage errorBody = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotActiveException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> userNotActiveException(UserNotActiveException ex, WebRequest request) {
        ErrorMessage errorBody = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookCopyNotAvailableException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> bookCopyNotAvailableException(BookCopyNotAvailableException ex, WebRequest request) {
        ErrorMessage errorBody = new ErrorMessage(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

}
