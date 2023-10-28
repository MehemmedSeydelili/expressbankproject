package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.mapper.CategoryMapper;
import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.repository.CategoryRepository;
import com.example.expressbankproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse create(CategoryDto dto) {
        Category category = CategoryMapper.INSTANCE.mapDtoToEntity(dto);
        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.mapEntityToView(category);
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryResponse> categoryResponses = categories.stream()
                .map(category -> CategoryMapper.INSTANCE.mapEntityToView(category))
                .collect(Collectors.toList());
        return categoryResponses;
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("Category not found with ID: "+ id));
    }
}
