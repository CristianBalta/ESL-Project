package com.esl.demo.service.implementations;

import com.esl.demo.dto.ProductDto;
import com.esl.demo.entity.ProductEntity;
import com.esl.demo.repository.ProductRepository;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                })
                .convertToDto();
    }

    @Override
    public List<ProductDto> getAll() {

        return productRepository.findAll().stream()
                .map(ProductEntity::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto add(ProductDto productDto) {

        return productRepository.save(productDto.convertToEntity()).convertToDto();
    }

    @Override
    public ProductDto update(ProductDto productDto) {

        ProductEntity updatedEntity = productRepository
                .findById(productDto.getId())
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                });
        updatedEntity.setName(productDto.getName());
        updatedEntity.setDeleted(productDto.getDeleted());
        return productRepository.save(updatedEntity).convertToDto();
    }

    @Override
    public void delete(Long id) {

        ProductEntity deletedEntity = productRepository.findById(id).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        deletedEntity.setDeleted(true);
        productRepository.save(deletedEntity);
    }
}
