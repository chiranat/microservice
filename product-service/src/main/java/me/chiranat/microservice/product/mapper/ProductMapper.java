package me.chiranat.microservice.product.mapper;

import org.springframework.stereotype.Component;

import me.chiranat.microservice.product.dto.ProductRequest;
import me.chiranat.microservice.product.dto.ProductResponse;
import me.chiranat.microservice.product.model.Product;

@Component
public class ProductMapper {
    
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice()
        );
    }

    public Product toEntity(ProductRequest productRequest) {
        return Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price() != null ? productRequest.price() : null)
            .build();
    }

}
