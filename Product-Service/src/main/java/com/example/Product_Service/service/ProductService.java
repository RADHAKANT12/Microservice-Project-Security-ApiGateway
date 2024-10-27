package com.example.Product_Service.service;


import com.example.Product_Service.entity.Product;
import com.example.Product_Service.payload.ClientDto;
import com.example.Product_Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientFeignClient clientFeignClient;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        // Call Client Service using Feign Client to get client details
        ClientDto client = clientFeignClient.getClientById(product.getClientId());

        if (client == null) {
            throw new RuntimeException("Client not found");
        }

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

