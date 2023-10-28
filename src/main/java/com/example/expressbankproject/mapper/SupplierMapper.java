package com.example.expressbankproject.mapper;

import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.entity.Supplier;
import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.request.SupplierDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.model.response.SupplierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    Supplier mapDtoToEntity(SupplierDto supplierDto);
    SupplierResponse mapEntityToView(Supplier supplier);

}
