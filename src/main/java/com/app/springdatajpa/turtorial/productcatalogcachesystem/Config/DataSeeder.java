package com.app.springdatajpa.turtorial.productcatalogcachesystem.Config;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;


    public void run(String[] args){
        if(productRepository.count()==0){
            log.info("Creating product repository");

            productRepository.saveAll(List.of(
                    Product.builder()
                            .name("MacBook Pro 14")
                            .price(150000.0)
                            .quantity(20)
                            .build(),

                    Product.builder()
                            .name("MacBook Pro 15")
                            .price(160000.0)
                            .quantity(50)
                            .build(),
                    Product.builder()
                            .name("MacBook Pro 16")
                            .price(150000.0)
                            .quantity(60)
                            .build(),
                    Product.builder()
                            .name("MacBook Pro 17")
                            .price(150000.0)
                            .quantity(20)
                            .build(),
                    Product.builder()
                            .name("MacBook Pro 18")
                            .price(150000.0)
                            .quantity(20)
                            .build(),
                    Product.builder()
                            .name("MacBook Pro 11")
                            .price(150000.0)
                            .quantity(10)
                            .build()



            ));

                            log.info("Product repository created");
        }
    }
}
