package com.esl.demo.service.interfaces;

import com.esl.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getById(Long id);

    List<ProductDto> getAll();

    ProductDto add(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    void delete(Long id);
}
