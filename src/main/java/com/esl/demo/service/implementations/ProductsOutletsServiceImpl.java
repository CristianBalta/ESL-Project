package com.esl.demo.service.implementations;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.OutletEntity;
import com.esl.demo.entity.ProductEntity;
import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.LinkId;
import com.esl.demo.repository.OutletRepository;
import com.esl.demo.repository.ProductRepository;
import com.esl.demo.repository.ProductsOutletsRepository;
import com.esl.demo.rest.errors.BadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.rest.errors.ResourceNotFoundException;
import com.esl.demo.service.interfaces.ProductsOutletsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsOutletsServiceImpl implements ProductsOutletsService {

    private final ProductsOutletsRepository productsOutletsRepository;
    private final ProductRepository productRepository;
    private final OutletRepository outletRepository;

    public ProductsOutletsServiceImpl(ProductsOutletsRepository productsOutletsRepository, ProductRepository productRepository, OutletRepository outletRepository) {
        this.productsOutletsRepository = productsOutletsRepository;
        this.productRepository = productRepository;
        this.outletRepository = outletRepository;
    }

    @Override
    public ProductsOutletsDto getById(LinkId id) {

        return productsOutletsRepository.findById(id)
                .orElseThrow(() -> {
                    throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
                })
                .convertToDto();

    }

    @Override
    public List<ProductsOutletsDto> getAll() {

        return productsOutletsRepository.findAll().stream()
                .map(ProductsOutletsEntity::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public ProductsOutletsDto add(ProductsOutletsDto productsOutletsDto) {

        return productsOutletsRepository.save(addForeignFieldsToEntity(productsOutletsDto)).convertToDto();

    }

    @Override
    public ProductsOutletsDto update(ProductsOutletsDto productsOutletsDto) {

        ProductsOutletsEntity updatedEntity = productsOutletsRepository
                .findById(new LinkId(productsOutletsDto.getProductId(), productsOutletsDto.getOutletId()))
                .orElseThrow(() -> {
                    throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
                });

        if (productsOutletsDto.getPrice() != null)
            updatedEntity.setPrice(productsOutletsDto.getPrice());
        if (productsOutletsDto.getDeleted() == null)
            updatedEntity.setDeleted(productsOutletsDto.getDeleted());

        return productsOutletsRepository.save(updatedEntity).convertToDto();

    }

    @Override
    public void delete(LinkId id) {

        ProductsOutletsEntity deletedEntity = productsOutletsRepository.findById(id).orElseThrow(() -> {
            throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
        });

        deletedEntity.setDeleted(true);
        productsOutletsRepository.save(deletedEntity);

    }

    private ProductsOutletsEntity addForeignFieldsToEntity(ProductsOutletsDto productsOutletsDto) {

        ProductsOutletsEntity returnEntity = new ProductsOutletsEntity();

        ProductEntity productEntity = productRepository.findById(productsOutletsDto.getProductId()).orElseThrow(() -> {
            throw new ResourceNotFoundException(ErrorConstants.ERR_INVALID_FIELDS);
        });

        OutletEntity outletEntity = outletRepository.findById(productsOutletsDto.getOutletId()).orElseThrow(() -> {
            throw new ResourceNotFoundException(ErrorConstants.ERR_INVALID_FIELDS);
        });

        returnEntity.setOutlet(outletEntity);
        returnEntity.setProduct(productEntity);
        returnEntity.setPrice(productsOutletsDto.getPrice());

        return returnEntity;

    }

}
