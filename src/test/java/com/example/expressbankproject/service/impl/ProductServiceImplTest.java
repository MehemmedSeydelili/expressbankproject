package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.model.entity.Product;
import com.example.expressbankproject.model.exception.NotFoundException;
import com.example.expressbankproject.model.response.ProductResponse;
import com.example.expressbankproject.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testGetProductById() {

        Long productId = 1L;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        ProductResponse response = productService.getById(productId);

        assertNotNull(response);
    }


    @Test
    public void testGetProductByIdWhenNotExists() {

        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        try {
            ProductResponse response = productService.getById(productId);
            fail("NotFoundException expected, but no exception was thrown.");
        } catch (NotFoundException e) {
        }
    }
}
