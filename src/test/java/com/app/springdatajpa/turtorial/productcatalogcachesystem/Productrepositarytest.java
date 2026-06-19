package com.app.springdatajpa.turtorial.productcatalogcachesystem;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary.productrepositary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Productrepositarytest {

    @Autowired
    productrepositary Productrepositary ;

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
