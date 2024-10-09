package com.ecommerce.project.exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//we wish to increase robustness and usebility of our application with respect to exception handling.
//both below gives us that

//Below is specialised version of controlleradvice
//This throw exception thrown by any controller in the application
@RestControllerAdvice

//Below handler used to handle specific type of exception.
//@ExceptionHandler

//handling all exception in single class gives standard way to handle project
//any exception happens that handled by this particular class.
public class MyGlobalExceptionHandler {

    //We need to specify we created this handler to handle which method.
    //Whenever MethodArgumentNotValidException exception happens handled here.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, String> response = new HashMap<>();
        //This method going to retrieve list of all the errors that are caught during the validation
        //of method paramater

        //we are creating response to represent it in more friendly user way
        e.getBindingResult().getAllErrors().forEach(err ->{
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(response,
                HttpStatus.BAD_REQUEST);
    }

    //This is basically handler Interceptiong all the resource not found exceptions that occure in the
    //all the controllers and even methods that controllers in calling
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> myResourceNotFoundException(ResourceNotFoundException e)
    {
        String message = e.getMessage();
        //we are drafting message that we adder below
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> myAPIException(APIException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
