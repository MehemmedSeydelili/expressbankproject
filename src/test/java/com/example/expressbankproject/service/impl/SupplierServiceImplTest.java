package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.model.entity.Supplier;
import com.example.expressbankproject.model.request.SupplierDto;
import com.example.expressbankproject.model.response.SupplierResponse;
import com.example.expressbankproject.repository.SupplierRepository;
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
class SupplierServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Test
    public void testCreateSupplier() {

        SupplierDto supplierDto = new SupplierDto();
        Supplier supplier = new Supplier();
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);

        SupplierResponse response = supplierService.create(supplierDto);

        assertNotNull(response);

    }

    @Test
    public void testGetAllSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();
        Supplier supplier1 = new Supplier();
        supplier1.setId(1L);
        Supplier supplier2 = new Supplier();
        supplier2.setId(2L);
        supplierList.add(supplier1);
        supplierList.add(supplier2);

        when(supplierRepository.findAll()).thenReturn(supplierList);

        List<SupplierResponse> supplierResponses = supplierService.getAll();

        assertNotNull(supplierResponses);
        assertEquals(2, supplierResponses.size());

        SupplierResponse response1 = supplierResponses.get(0);
        assertEquals(supplier1.getId(), response1.getId());
    }

    @Test
    public void testGetAllSuppliersWithEmptyList() {

        when(supplierRepository.findAll()).thenReturn(Collections.emptyList());

        List<SupplierResponse> supplierResponses = supplierService.getAll();

        assertNotNull(supplierResponses);
        assertTrue(supplierResponses.isEmpty());

    }
}