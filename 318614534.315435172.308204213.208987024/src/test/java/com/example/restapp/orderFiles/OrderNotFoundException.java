package com.example.restapp.orderFiles;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long id){
        super("no Order corresponding to: " + id +"id");
    }

    /**
     * this class simply throws notFound exception(404)
     * using the class id (if found = ok, if not -> send exception)
     * we using the advice class in order to send this
     */

}
