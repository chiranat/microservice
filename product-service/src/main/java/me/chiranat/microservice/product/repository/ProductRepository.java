package me.chiranat.microservice.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.chiranat.microservice.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
