package com.example.Product_Service.controller;


import com.example.Product_Service.entity.Product;
import com.example.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    // http://localhost:8081/api/products


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    // http://localhost:8081/api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    // http://localhost:8081/api/products/1


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}

