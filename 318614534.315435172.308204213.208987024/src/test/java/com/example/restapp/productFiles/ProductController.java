package com.example.restapp.productFiles;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class ProductController {

    private final ProductRepo productDataBase;
    private ProductWrapFactory pwf;


    //constractur
    public ProductController(ProductRepo productDataBase,ProductWrapFactory pwf) {
        this.productDataBase = productDataBase;
        this.pwf = pwf;
    }

    /**
     *will extract the name by the query we made in productRepo
     * @param name
     * @return responseEntity which taking care for both the http response and the body
     * in addition sends the product in collectionModel which is sort of contrainer for entitys
     */

   // שאלה 1 אחרי שינוי עם query
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(@RequestParam Optional<String> name ){
        if(name.isPresent()) {
            return ResponseEntity.ok(productDataBase.findByTitle(name.get()));
        }
        // שאלה 1 החלק המקורי בלי השאילתה
        List<EntityModel<Product2>> p2 = productDataBase.findAll().stream()
                .map(p -> pwf.toModel(p)).collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(p2));
    }

    /**
     * המטודה הזאת מקבלת את המזהה של פרודקט בודקת אם הוא קיים
     * אם לא, זורקת שגיאת 404 not Found
     * @param id
     * @return ResponseEntity המוצר יהיה עטוף בריספונסאנטיטי ששולח גם statusCode 200 שמשמע שפעולה בוצעה בהצלחה
     */


      //2
      @GetMapping("/products/{id}")
      public ResponseEntity<?> singleProduct(@PathVariable Long id){
        Product2 pro2 = productDataBase.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        return ResponseEntity.ok(pwf.toModel(pro2));
      }



}
