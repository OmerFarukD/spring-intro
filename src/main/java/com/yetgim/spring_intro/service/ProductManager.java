package com.yetgim.spring_intro.service;

import com.yetgim.spring_intro.entities.Product;
import com.yetgim.spring_intro.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
// @Repository , @Service , @Configuration, @Component
public class ProductManager {

    private ProductRepository productRepository;

    // Constructor Arg Injection.
    public  ProductManager(ProductRepository productRepository){

        this.productRepository = productRepository;

    }

    public  void  add(Product product){

        if (product.getName()== null){
            throw new RuntimeException("İsim alanı boş olamaz.");
        }

        if (product.getName().length()<2){
            throw new RuntimeException("İsim alanı minimum 2 haneli olmalıdır.");
        }

        if (product.getPrice()<0){
            throw new RuntimeException("Fiyat alanı negatif değer alamaz.");
        }

        if (product.getStock()<0){
            throw new RuntimeException("Stok alanı negatif değer alamaz.");
        }

        // Insert ınto Products(kolonlar) values(değerler);

        this.productRepository.save(product);
    }


    public List<Product> getAll(){
        // SELECT * FROM Products
        List<Product> products = this.productRepository.findAll();
        return  products;
    }

    public Product getById(Long id){

        // SELECT * FROM Products where id = id;
        Optional<Product> product =this.productRepository.findById(id);

        if (product.isEmpty()){
            throw new RuntimeException("İlgili ürün bulunamadı.");
        }
        return product.get();
    }


    // SELECT * FROM Products where Price<=max and price>=min;
    public List<Product> getAllPriceRange(double min, double max){
        List<Product> products = this.productRepository.findAllPriceRange(min,max);
        return products;
    }

}
