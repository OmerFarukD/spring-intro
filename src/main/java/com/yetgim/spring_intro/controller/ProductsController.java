package com.yetgim.spring_intro.controller;

import com.yetgim.spring_intro.entities.Product;
import com.yetgim.spring_intro.service.ProductManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductManager productManager;

    public ProductsController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @PostMapping("/add")
    public String add(@RequestBody Product product){
            productManager.add(product);
            return "Ürün eklendi.";
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        List<Product> products = productManager.getAll();
        return products;
    }


    @GetMapping("/get/{id}")
    public Product getById(@PathVariable Long id){
        Product product = productManager.getById(id);
        return product;
    }


    @GetMapping("/pricerange")
    public List<Product> getAllPriceRange(@RequestParam double min, @RequestParam double max){

        List<Product> products = this.productManager.getAllPriceRange(min, max);
        return products;
    }

}
