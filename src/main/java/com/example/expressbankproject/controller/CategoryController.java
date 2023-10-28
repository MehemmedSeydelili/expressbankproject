package com.example.expressbankproject.controller;

import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }
}
