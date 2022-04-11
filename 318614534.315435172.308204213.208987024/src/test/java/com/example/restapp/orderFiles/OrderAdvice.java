package com.example.restapp.orderFiles;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderAdvice {


    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundHandler(OrderNotFoundException onf){
        return onf.getMessage();
    }


    /**
     * האדבייס מקבל את מחלקת OrderNotFoundException וזורק אותו עם 404 במידה וה-id לא נמצא עם הודעה מתאימה
     */


}
