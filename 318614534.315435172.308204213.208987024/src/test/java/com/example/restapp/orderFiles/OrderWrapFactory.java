package com.example.restapp.orderFiles;


import com.example.restapp.productFiles.Product2;
import com.example.restapp.productFiles.ProductController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderWrapFactory implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order){

        return EntityModel.of(order,linkTo(methodOn(OrderController.class).singleOrder(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).allOrders(Optional.empty())).withRel("all the orders"));
    }




}
