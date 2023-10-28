package com.example.expressbankproject.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String name;

    @Size(max = 255, message = "Description should not exceed 255 characters")
    private String description;

    @Positive(message = "Price should be a positive number")
    private Double price;

    private Long categoryId;

    private Long supplierId;
}
