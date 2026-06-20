package com.app.springdatajpa.turtorial.productcatalogcachesystem.Repositary;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
