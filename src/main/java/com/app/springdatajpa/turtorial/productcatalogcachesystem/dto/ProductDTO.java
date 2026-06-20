package com.app.springdatajpa.turtorial.productcatalogcachesystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;




@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Double price;
    private Integer quantity;
}
