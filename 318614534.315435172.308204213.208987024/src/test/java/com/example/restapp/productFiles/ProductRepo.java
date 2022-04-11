package com.example.restapp.productFiles;

import com.example.restapp.productFiles.Product2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product2,Long> {
    @Query("select p from Product2 p where p.name = :title")
    Product2 findByTitle(String title);

/**
 * this is an interface we send to the DB, this interface extends jpaRepository
 * which give us the ablity for CRUD (create,read,update,delete)
 * האינטרפייס מקבל את קלאס של פרודוקט, עם המזהה שלו
 *  בהמשך יצרנו שאילתה findByTitle שבאמצעותה אנו מוצאים את שם המוצר מה-DB ושולחים אותו
 */
}
