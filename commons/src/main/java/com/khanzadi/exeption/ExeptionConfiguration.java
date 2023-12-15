package com.khanzadi.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExeptionConfiguration extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MessengerExp.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, new HttpHeaders()
                ,HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = MessengerExp.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<ErrorMessage> serviceUnavailableNotFoundException(
            MessengerExp ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, new HttpHeaders() ,
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    //try {
    //            this.classTest.methodTest(TEST);
    //    } catch (InterruptedException | ServiceUnavailableException e) {
    //            throw new MessengerExp("test" , e);
    //}
}
