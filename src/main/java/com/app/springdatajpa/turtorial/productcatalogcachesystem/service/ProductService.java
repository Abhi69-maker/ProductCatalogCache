package com.app.springdatajpa.turtorial.productcatalogcachesystem.service;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary.ProductRepository;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private void simulateSlowDbCall() {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }


    public List<Product> getAllProducts() {

        log.info("Getting all products");
        simulateSlowDbCall();

        return productRepository.findAll();
    }
    @Cacheable(value = "products",key="#id")
    public Product getProductById(Integer id) {


        log.info("Getting product by ID {}", id);
        simulateSlowDbCall();

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
    @CachePut(value = "products",key = "#id")
    public Product updateProductById(ProductDTO productDTO, Integer id) {
        log.info("Updating product {}", productDTO.getName());
        simulateSlowDbCall();

        Product existing = getProductById(id);

        existing.setName(productDTO.getName());
        existing.setPrice(productDTO.getPrice());
        existing.setQuantity(productDTO.getQuantity());


        return productRepository.save(existing);



    }
    @CacheEvict(value = "products",key = "#id")
    public String deleteProductByID(Integer id) {

        log.info("Deleting product by ID {}", id);
        simulateSlowDbCall();

        productRepository.deleteById(id);

        return "Product Deleted Successfully";

    }
}
