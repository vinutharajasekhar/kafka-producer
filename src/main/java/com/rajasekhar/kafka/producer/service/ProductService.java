package com.rajasekhar.kafka.producer.service;

import com.rajasekhar.kafka.producer.request.CreateProductRequest;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductRequest createProductRequest) throws ExecutionException, InterruptedException;
}
