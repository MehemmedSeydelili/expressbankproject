package com.example.expressbankproject.service;

import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CategoryDto dto);
    List<CategoryResponse> getAll();

}
