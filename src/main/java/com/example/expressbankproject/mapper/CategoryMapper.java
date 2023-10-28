package com.example.expressbankproject.mapper;

import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.request.CategoryDto;
import com.example.expressbankproject.model.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper{

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category mapDtoToEntity(CategoryDto categoryDto);
    CategoryResponse mapEntityToView(Category category);
}
