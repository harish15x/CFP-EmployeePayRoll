package com.bridgelabz.employeepayroll.Exception.exceptionhandler;

import com.bridgelabz.employeepayroll.Exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response> handlehiringException(EmployeeNotFoundException he){
        Response response = new Response();
        response.setErrorcode(400L);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

