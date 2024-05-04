package com.TicketBooking.ControllersApis;

import com.TicketBooking.ApplicationExceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(TicketAlreadySignedInException.class)
    public ResponseEntity<String> handleTicketAlreadySignedInException(){
        return new ResponseEntity<>("Ticket Already Signedin", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ExpiredTicketException.class)
    public ResponseEntity<String> handleExpiredTicketException(){
        return new ResponseEntity<>("Ticket Expired", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<String> handleTicketNotFoundException(){
        return new ResponseEntity<>("Ticket Not Found", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MalPracticeException.class)
    public ResponseEntity<String> handleMalPracticeException(){
        return new ResponseEntity<>("Malpractice Detected, Cannot Sign-out Un-Signed Ticked", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketAlreadySignedOutException.class)
    public ResponseEntity<String> handleTicketAlreadySignedOutException(){
        return new ResponseEntity<>("Ticket Already SignedOut, Cannot Sign-out Again", HttpStatus.BAD_REQUEST);
    }


}
