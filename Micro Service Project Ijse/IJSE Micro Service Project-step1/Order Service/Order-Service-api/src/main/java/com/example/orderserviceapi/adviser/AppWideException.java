package com.example.orderserviceapi.adviser;


import com.example.orderserviceapi.exception.DuplicateEntryException;
import com.example.orderserviceapi.exception.EntryNotFoundException;
import com.example.orderserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideException {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(404,e.getMessage(),e), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponse> handleDuplicateEntryFoundException(DuplicateEntryException e){
        return new ResponseEntity<>(
                new StandardResponse(409,e.getMessage(),e), HttpStatus.CONFLICT
        );

    }

}
