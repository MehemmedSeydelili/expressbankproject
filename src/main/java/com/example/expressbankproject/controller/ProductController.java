package com.example.expressbankproject.controller;

import com.example.expressbankproject.model.request.ProductDto;
import com.example.expressbankproject.model.response.ProductResponse;
import com.example.expressbankproject.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("getById/{id}")
    private ResponseEntity<ProductResponse> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(dto,id));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
