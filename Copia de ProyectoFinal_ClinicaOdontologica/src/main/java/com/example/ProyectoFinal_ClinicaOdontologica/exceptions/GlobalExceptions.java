package com.example.ProyectoFinal_ClinicaOdontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> procesarErrorResourceNotFound(ResourceNotFoundException ex1){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex1.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarBadRequest(BadRequestException ex2) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex2.getMessage());
    }
}
