package com.rajasekhar.kafka.producer.service;

import com.rajasekhar.kafka.producer.request.CreateProductRequest;

public interface ProductService {
    String createProduct(CreateProductRequest createProductRequest);
}
