package com.example.expressbankproject.model.response;

import com.example.expressbankproject.model.entity.Category;
import lombok.Data;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Double price;

}
