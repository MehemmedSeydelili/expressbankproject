package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;


    @Test
    public void testCreateCategory() {

        CategoryDto categoryDto = new CategoryDto();
        Category category = new Category();
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryResponse response = categoryService.create(categoryDto);

        assertNotNull(response);

    }


    @Test
    public void testGetAllCategories() {

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category());

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<CategoryResponse> categoryResponses = categoryService.getAll();

        assertNotNull(categoryResponses);
        assertEquals(1, categoryResponses.size());

    }

    @Test
    public void testGetAllCategoriesWithEmptyList() {

        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());

        List<CategoryResponse> categoryResponses = categoryService.getAll();

        assertNotNull(categoryResponses);
        assertTrue(categoryResponses.isEmpty());

    }
}