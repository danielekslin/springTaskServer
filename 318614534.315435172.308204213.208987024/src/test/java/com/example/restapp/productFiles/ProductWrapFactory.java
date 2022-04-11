package com.example.restapp.productFiles;


import com.example.restapp.productFiles.Product2;
import com.example.restapp.productFiles.ProductController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductWrapFactory implements RepresentationModelAssembler<Product2, EntityModel<Product2>> {

    @Override
    public EntityModel<Product2> toModel(Product2 prod2){
        return EntityModel.of(prod2,
                linkTo(methodOn(ProductController.class).singleProduct(prod2.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAllProducts(Optional.empty())).withRel("all products"));
    }

    /**
     * this class helps us to extract the instances in productController, later on we will invoke this class.
     * it implemnts RepresentationModelAssembler שבמילים יחסית פשוטות עוזר לנו לארגן את המופעים עם הלינקים בעזרת אנטיטימודל
     * entityModel-עוטף את האוביקטים עם הדומיין ומוסיף אליו לינקים
     * הוא מקבל אוביקט מסוג פרודוקט, ונותן קישורים לפונקציות שיצרנו בקונטרולר
     */

}
