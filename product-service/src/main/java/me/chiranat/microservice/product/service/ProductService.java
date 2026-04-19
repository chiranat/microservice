package me.chiranat.microservice.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chiranat.microservice.product.dto.ProductRequest;
import me.chiranat.microservice.product.dto.ProductResponse;
import me.chiranat.microservice.product.mapper.ProductMapper;
import me.chiranat.microservice.product.model.Product;
import me.chiranat.microservice.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = productMapper.toEntity(productRequest);
        productRepository.save(product);
        log.info("Product created successfully");
        ProductResponse productResponse = productMapper.toResponse(product);
        log.info("Product response: {}", productResponse);
        return productResponse;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

}
