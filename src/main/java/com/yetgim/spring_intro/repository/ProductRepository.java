package com.yetgim.spring_intro.repository;

import com.yetgim.spring_intro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {



    List<Product> findAllByPriceBetween(double min, double max);


    // SELECT * FROM PRODUCTS where name ILIKE '%deger%'

    List<Product> findAllByNameContains(String name);
    
    
    // jpql
    @Query("from Product  WHERE  price between :min and :max ")
    List<Product> findAllPriceRange(double min, double max);
}
