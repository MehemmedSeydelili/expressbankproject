package com.example.expressbankproject.service.impl;

import com.example.expressbankproject.mapper.ProductMapper;
import com.example.expressbankproject.model.entity.Category;
import com.example.expressbankproject.model.entity.Product;
import com.example.expressbankproject.model.entity.Supplier;
import com.example.expressbankproject.model.exception.NotFoundException;
import com.example.expressbankproject.model.request.ProductDto;
import com.example.expressbankproject.model.response.ProductResponse;
import com.example.expressbankproject.repository.CategoryRepository;
import com.example.expressbankproject.repository.ProductRepository;
import com.example.expressbankproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.expressbankproject.model.constant.ExceptionConstant.PRODUCT_NOT_FOUND_CODE;
import static com.example.expressbankproject.model.constant.ExceptionConstant.PRODUCT_NOT_FOUND_MESSAGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryServiceImpl categoryService;
    private final SupplierServiceImpl supplierService;

    @Override
    public ProductResponse save(ProductDto dto) {

        Category category = categoryService.getById(dto.getCategoryId());
        Supplier supplier = supplierService.getById(dto.getSupplierId());

        Product product = ProductMapper.INSTANCE.mapDtoToEntity(dto);
        product.setCategory(category);
        product.setSupplier(supplier);

        productRepository.save(product);
        return ProductMapper.INSTANCE.mapEntityToView(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty())
            throw new NotFoundException(PRODUCT_NOT_FOUND_CODE, "There are not any product!");

        else {
            List<ProductResponse> productResponses = products.stream()
                    .map(product -> ProductMapper.INSTANCE.mapEntityToView(product))
                    .collect(Collectors.toList());
            return productResponses;
        }
    }

    @Override
    public ProductResponse getById(Long id) {
        return ProductMapper.INSTANCE.mapEntityToView(fetchProductIfExist(id));
    }

    @Override
    public ProductResponse update(ProductDto dto, Long id) {

        Product product = fetchProductIfExist(id);

        Category category = categoryService.getById(dto.getCategoryId());
        Supplier supplier = supplierService.getById(dto.getSupplierId());

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setSupplier(supplier);
        product.setCategory(category);

        return ProductMapper.INSTANCE.mapEntityToView(product);

    }
    @Override
    public void delete(Long id) {
        fetchProductIfExist(id);
        productRepository.deleteById(id);
    }

    private Product fetchProductIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            log.error("ProductService.fetchProductIfExist.error id: {}", id);
            throw new NotFoundException(PRODUCT_NOT_FOUND_CODE, String.format(PRODUCT_NOT_FOUND_MESSAGE, id));
        });
    }
}
