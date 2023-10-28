package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.mapper.SupplierMapper;
import com.example.expressbankproject.model.entity.Supplier;
import com.example.expressbankproject.model.request.SupplierDto;
import com.example.expressbankproject.model.response.SupplierResponse;
import com.example.expressbankproject.repository.SupplierRepository;
import com.example.expressbankproject.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponse create(SupplierDto dto) {
        Supplier supplier= SupplierMapper.INSTANCE.mapDtoToEntity(dto);
        supplierRepository.save(supplier);
        return SupplierMapper.INSTANCE.mapEntityToView(supplier);
    }

    @Override
    public List<SupplierResponse> getAll() {
        List<Supplier> suppliers= supplierRepository.findAll();

        List<SupplierResponse> supplierResponses=suppliers.stream()
                .map(supplier -> SupplierMapper.INSTANCE.mapEntityToView(supplier))
                .collect(Collectors.toList());
        return supplierResponses;
    }

    public Supplier getById(Long id){
        return supplierRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Supplier not found with ID: "+id));
    }
}
