package com.rajasekhar.kafka.producer.controller;

import com.rajasekhar.kafka.producer.request.CreateProductRequest;
import com.rajasekhar.kafka.producer.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    ProductService productService;

    public ProductsController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRequest createProductRequest){
        String productId = productService.createProduct(createProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }
}




