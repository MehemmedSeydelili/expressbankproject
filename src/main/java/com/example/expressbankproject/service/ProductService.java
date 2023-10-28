package com.example.expressbankproject.service;

import com.example.expressbankproject.model.request.ProductDto;
import com.example.expressbankproject.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse save(ProductDto dto);
    List<ProductResponse> getAll();
    ProductResponse getById(Long id);
    ProductResponse update(ProductDto dto, Long id);
    void delete(Long id);
}
