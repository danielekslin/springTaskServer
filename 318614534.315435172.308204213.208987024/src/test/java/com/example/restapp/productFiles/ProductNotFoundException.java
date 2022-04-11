package com.example.restapp.productFiles;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id){
        super("no Product corresponding to: " + id +"id");
    }

    /**
     * this class simply throws notFound exception(404)
     * using the class id (if found = ok, if not -> send exception)
     * we using the advice class in order to send this
     */

}
