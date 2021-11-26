package com.academia.clinicaodontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.log4j.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("ExceptionHandler Error ", HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequestException(BadRequestException ex, WebRequest request) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("ExceptionHandler Error ", HttpStatus.BAD_REQUEST);
    }
   /* @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest req)
    {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("ExceptionHandler Error ", HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}