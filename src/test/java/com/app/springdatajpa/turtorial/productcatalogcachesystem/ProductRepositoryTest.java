package com.app.springdatajpa.turtorial.productcatalogcachesystem;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository Productrepositary ;

    @Test
    void testSaveProduct(){

        Product p = Product.builder()
                .name("MacBook")
                .price(150000)
                .quantity(50)


                .build();
    Productrepositary.save(p);








    }


}
