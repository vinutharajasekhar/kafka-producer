package com.rajasekhar.kafka.producer.controller;

import com.rajasekhar.kafka.producer.error.ErrorMessage;
import com.rajasekhar.kafka.producer.request.CreateProductRequest;
import com.rajasekhar.kafka.producer.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/products")
public class ProductsController {

    ProductService productService;

    public ProductsController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductRequest createProductRequest){
        String productId ;
        try {
            productId = productService.createProduct(createProductRequest);
        }catch (Exception exc){
            exc.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(LocalDateTime.now(), exc.getMessage(), "/products"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}




