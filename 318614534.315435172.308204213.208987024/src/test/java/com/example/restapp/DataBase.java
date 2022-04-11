package com.example.restapp;

import com.example.restapp.orderFiles.Order;
import com.example.restapp.orderFiles.OrderRepo;
import com.example.restapp.productFiles.Product2;
import com.example.restapp.productFiles.ProductRepo;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class DataBase {
    private static final Logger log = (Logger) LoggerFactory.getLogger(DataBase.class);

    @Bean
    CommandLineRunner initializeDataBase(ProductRepo myProducts){
        return args -> {
            log.info("logging" + myProducts.save
                    (new Product2("description","Televisions",980.99,"samsung j45")));


            log.info("logging" + myProducts.save
                    (new Product2("description","books",40.50,"Harry Poter")));


        };

    }

    @Bean
    CommandLineRunner initializeDataBase2(OrderRepo myOrders){
        return args -> {
            log.info("logging" + myOrders.save
                    (new Order(LocalDate.now(),"first order",350.20,List.of())));

            log.info("logging" + myOrders.save
                    (new Order(LocalDate.now(),"second order",710.50,List.of())));


        };
    }

    /**
     *
     */
}
