package com.example.restapp.orderFiles;


import com.example.restapp.productFiles.Product2;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    private final OrderRepo orderDataBase;
    private OrderWrapFactory owf;


    public OrderController(OrderRepo orderDataBase,OrderWrapFactory owf){
        this.orderDataBase = orderDataBase;
        this.owf = owf;
    }

    /**
     * בעזרת query שיצרנו ב-OrderRepo בודק אם המחיר של ההזמנה קיים אם לא מציג את כל ה-Orders
     * @param price
     * @return ResponseEntity of the orders + statusCode 200
     */


    @GetMapping("/orders")
    public ResponseEntity<?> allOrders(@RequestParam Optional<Double> price){
        List<Order> orders;
                if(price.isPresent()){
                    orders = orderDataBase.findCheaperOrders(price.get());

                }else{
                    orders = orderDataBase.findAll();
                }
                List<EntityModel<Order>>orderWrap = orders.stream().map(order -> owf.toModel(order))
                        .collect(Collectors.toList());

                return ResponseEntity.ok(CollectionModel.of(orderWrap));

    }

    /**
     * a method that check primary key of Order. extracting the Order if id param found
     * ואם לא נמצא, אז זורק שגיאת 404
     * @param id
     * @return ResponseEntity של המופעים של אורדר שנמצאו מה-DB בתוספת statusCode 200
     */


    @GetMapping("order/{id}")
    ResponseEntity<EntityModel<Order>> singleOrder(@PathVariable Long id) {
        Order order = orderDataBase.findById(id).orElseThrow(()-> new OrderNotFoundException(id));

        return ResponseEntity.ok(owf.toModel(order));
    }

    /**
     * a method of type POST which create new order
     * @param order
     * @return ResponseEntity
     */

   // בקשת POST
    // 3)
    @PostMapping("/orders")
    ResponseEntity<?>placeOrder(@RequestBody Order order){
        EntityModel<Order> productEntiyy = owf.toModel(orderDataBase.save(order));
        return ResponseEntity.created(productEntiyy.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productEntiyy);

    }







}
