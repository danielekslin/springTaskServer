package com.example.restapp.orderFiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query("select o from Order o where o.price < : price")
    List<Order>findCheaperOrders(double price);

    /**
     * this is an interface we send to the DB, this interface extends jpaRepository
     * which give us the ablity for CRUD (create,read,update,delete)
     * האינטרפייס מקבל את קלאס של אורדר, עם המזהה שלו
     *  בהמשך יצרנו שאילתה findCheaperOrders
     *  עם List שמכיל Order
     *  שבאמצעותה אנו מוצאים את כל האורדרים המתאימים מה-DB ושולחים אותם
     */
}
