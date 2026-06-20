package com.app.springdatajpa.turtorial.productcatalogcachesystem.Controller;

import com.app.springdatajpa.turtorial.productcatalogcachesystem.Entity.Product;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.dto.ProductDTO;
import com.app.springdatajpa.turtorial.productcatalogcachesystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productservice;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return ResponseEntity.ok(productservice.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(productservice.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO)
    {
        return ResponseEntity.ok(productservice.createProduct(productDTO));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProdictById(@RequestBody ProductDTO productDTO, @PathVariable Integer id){
        return ResponseEntity.ok(productservice.updateProductById(productDTO,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){

        return ResponseEntity.ok(productservice.deleteProductByID(id));

    }




}
