package com.esl.demo.service.implementations;

import com.esl.demo.dto.ProductDto;
import com.esl.demo.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto getById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }

    @Override
    public ProductDto add(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
