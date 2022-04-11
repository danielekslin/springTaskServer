package com.example.restapp.productFiles;

import com.example.restapp.orderFiles.Order;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "products")
public class Product2 {

         private double price;
         private String category;
         public String description;
         @Id @GeneratedValue private Long id;
         private String Pname;

    /**
     * 1) Product class contain all the properties for the DB
     *
     * @Data anotation give us all the needed stuff for class by default(ToString,getter/setter/hash
     *we also declared id anotaion for primary key, and ManytoOne for connecting other tables to Order as parent.
     *we created a default constractur, and a normala one
     */

    @ManyToOne
    private Order orderProducts;


    public Product2(){

    }
     // כאן לא צריך להוסיף את שאר המאפיינים של אורדר כי אני כבר מכיל אותם
    public Product2(String description,String category,double price,String Pname){
        this.description = description;
        this.category = category;
        this.price = price;
        this.Pname = Pname;
    }






}
