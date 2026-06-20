package com.app.springdatajpa.turtorial.productcatalogcachesystem.service;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary.ProductRepository;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProducts() {

        log.info("Getting all products");

        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {

        log.info("Getting product by ID {}", id);

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));

    }

    public Product createProduct(ProductDTO productDTO) {

        log.info("Creating product {}", productDTO.getName());

        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();

        return productRepository.save(product);
    }

    public Product updateProductById(ProductDTO productDTO, Integer id) {
        log.info("Updating product {}", productDTO.getName());

        Product existing = getProductById(id);

        existing.setName(productDTO.getName());
        existing.setPrice(productDTO.getPrice());
        existing.setQuantity(productDTO.getQuantity());


        return productRepository.save(existing);



    }

    public String deleteProductByID(Integer id) {

        log.info("Deleting product by ID {}", id);

        productRepository.deleteById(id);

        return "Product Deleted Successfully";

    }
}
