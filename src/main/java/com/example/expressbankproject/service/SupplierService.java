package com.example.expressbankproject.service;

import com.example.expressbankproject.model.request.SupplierDto;
import com.example.expressbankproject.model.response.SupplierResponse;

import java.util.List;

public interface SupplierService {

    SupplierResponse create(SupplierDto dto);
    List<SupplierResponse> getAll();

}
