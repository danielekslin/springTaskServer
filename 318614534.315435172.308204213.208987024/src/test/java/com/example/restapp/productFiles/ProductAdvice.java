package com.example.restapp.productFiles;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductAdvice {

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException pnf){
        return pnf.getMessage();
    }

/**
 * האדבייס מקבל את מחלקת ProductNotFoundException וזורק אותו עם 404 במידה וה-id לא נמצא עם הודעה מתאימה
 */
}
