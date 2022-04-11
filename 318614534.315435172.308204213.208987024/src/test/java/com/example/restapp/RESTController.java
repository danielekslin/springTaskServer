//package com.example.restapp;
//
//
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class RESTController {
//
//    private RESTRepo RESTDataBase;
//
//    //constractur
//    public RESTController (RESTRepo RESTDataBase){
//        this.RESTDataBase = RESTDataBase;
//    }
//
//    @GetMapping("/products")
//    CollectionModel<EntityModel<Product2>> getAllproducts(){
//        List<EntityModel<Product2>> products = RESTDataBase.findAll().stream()
//                .map(product -> EntityModel.of(product,
//                        linkTo(methodOn(OrderController.class).singleProduct(product.))
//                                .withSelfRel(),
//                        linkTo(methodOn(OrderController.class).getAllproducts())
//                                .withRel("all products"))).collect(Collectors.toList());
//
//        return CollectionModel.of(products,
//                linkTo(methodOn(OrderController.class).getAllproducts()).withSelfRel());
//
//    }
//
//
//
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<EntityModel<Product>>singleProduct(@PathVariable long id){
//        // EntityModel<Product2> getSingleOrder(@PathVariable Long id){
////        Product2 product2 = OrderDataBase.findById(id).orElseThrow(()-> new OrderAdvice.OrderNotFoundException(id));
////        return EntityModel.of(product2);
//
//    }
//}
