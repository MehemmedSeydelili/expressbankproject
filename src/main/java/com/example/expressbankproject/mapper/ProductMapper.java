package com.example.expressbankproject.mapper;

import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.entity.Product;
import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.request.ProductDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import com.example.expressbankproject.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapDtoToEntity(ProductDto productDto);
    ProductResponse mapEntityToView(Product product);

}
