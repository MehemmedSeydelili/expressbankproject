package com.example.expressbankproject.controller;

import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.request.SupplierDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.model.response.SupplierResponse;
import com.example.expressbankproject.service.SupplierService;
import com.example.expressbankproject.service.impl.SupplierServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierServiceImpl supplierService;

    @PostMapping("/create")
    public ResponseEntity<SupplierResponse> create(@Valid @RequestBody SupplierDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.create(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupplierResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAll());
    }

}
