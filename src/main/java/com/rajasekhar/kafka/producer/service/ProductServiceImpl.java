package com.rajasekhar.kafka.producer.service;

import com.rajasekhar.kafka.producer.event.ProductCreatedEvent;
import com.rajasekhar.kafka.producer.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    @Override
    public String createProduct(CreateProductRequest createProductRequest) {
        String productId= UUID.randomUUID().toString();
        //TODO : persist the event data into database table before publishing an event
        ProductCreatedEvent event = new ProductCreatedEvent();
        event.setProductId(productId);
        event.setName(createProductRequest.getName());
        event.setPrice(createProductRequest.getPrice());
        event.setQuantity(createProductRequest.getQuantity());

        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
                kafkaTemplate.send("product-created-events-topic", productId, event);
        future.whenComplete((result, exception) -> {
            if(null != exception){
                System.out.println("Failed to send message"+exception.getMessage());
            }else{
                System.out.println("Message sent successfully "+result.getRecordMetadata());
            }
        });

        
        System.out.println("************** returning product id ************");
        return productId;
    }
}
