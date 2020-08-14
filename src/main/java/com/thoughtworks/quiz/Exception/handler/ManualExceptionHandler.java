package com.thoughtworks.quiz.Exception.handler;


import com.thoughtworks.quiz.Controller.OrderController;
import com.thoughtworks.quiz.Controller.StoreController;
import com.thoughtworks.quiz.Exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.thoughtworks.quiz.Exception.Error;

@ControllerAdvice(assignableTypes = {StoreController.class, OrderController.class})
public class ManualExceptionHandler {

    @ExceptionHandler({BadRequestException.class,RuntimeException.class})
    public ResponseEntity<Error> badRequestHandler(Exception e){
        Error error = new Error(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }





}
