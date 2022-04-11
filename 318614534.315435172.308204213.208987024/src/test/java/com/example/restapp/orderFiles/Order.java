package com.example.restapp.orderFiles;


import com.example.restapp.productFiles.Product2;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name ="orders")
public class Order {

    @Id @GeneratedValue private Long id;
    private LocalDate purchaseDate;
    private String title;
    private double price;

    public List<Product2> productsList;

    /**
     * 1) Order class contain all the properties for the Db,including a List that holds Product class
     * data anotaion for setter/getter, id anotaion as primary, and constracturs
     */

    //default constractur
    public Order(){

    }

    // constractur
    public Order(LocalDate purchaseDate, String title,double price,List<Product2> productsList){

         this.purchaseDate = LocalDate.now();
        this.title = title;
        this.price = price;
        this.productsList = productsList;
    }
}
