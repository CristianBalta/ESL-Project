package com.esl.demo.service.implementations;

import com.esl.demo.dto.ESLLinkDto;
import com.esl.demo.entity.ESLEntity;
import com.esl.demo.entity.ESLLinkEntity;
import com.esl.demo.entity.OutletEntity;
import com.esl.demo.entity.ProductEntity;
import com.esl.demo.entity.compositeKeys.ESLLinkId;
import com.esl.demo.repository.ESLLinkRepository;
import com.esl.demo.repository.ESLRepository;
import com.esl.demo.repository.OutletRepository;
import com.esl.demo.repository.ProductRepository;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ESLLinkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ESLLinkServiceImpl implements ESLLinkService {

    private final ESLLinkRepository eslLinkRepository;
    private final ESLRepository eslRepository;
    private final ProductRepository productRepository;
    private final OutletRepository outletRepository;

    public ESLLinkServiceImpl(ESLLinkRepository eslLinkRepository, ESLRepository eslRepository, ProductRepository productRepository, OutletRepository outletRepository) {
        this.eslLinkRepository = eslLinkRepository;
        this.eslRepository = eslRepository;
        this.productRepository = productRepository;
        this.outletRepository = outletRepository;
    }

    @Override
    public ESLLinkDto getById(ESLLinkId eslLinkId) {

        return eslLinkRepository.findByEslIdAndProductIdAndOutletId(eslLinkId.getEslId(), eslLinkId.getProductId(), eslLinkId.getOutletId())
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                })
                .convertToDto();
    }

    @Override
    public List<ESLLinkDto> getAll() {

        return eslLinkRepository.findAll().stream()
                .map(ESLLinkEntity::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ESLLinkDto add(ESLLinkDto eslLinkDto) {

        return eslLinkRepository.save(addForeignFieldsToEntity(eslLinkDto)).convertToDto();
    }

    @Override
    public ESLLinkDto update(ESLLinkDto eslLinkDto) {

        ESLLinkEntity updatedEntity = eslLinkRepository
                .findByEslIdAndProductIdAndOutletId(eslLinkDto.getEslId(), eslLinkDto.getProductId(), eslLinkDto.getOutletId())
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                });
        updatedEntity.setDeleted(eslLinkDto.getDeleted());

        return eslLinkRepository.save(updatedEntity).convertToDto();
    }

    @Override
    public void delete(ESLLinkId eslLinkId) {

        ESLLinkEntity deletedEntity = eslLinkRepository.findByEslIdAndProductIdAndOutletId(eslLinkId.getEslId(), eslLinkId.getProductId(), eslLinkId.getOutletId()).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        deletedEntity.setDeleted(true);
        eslLinkRepository.save(deletedEntity);
    }

    private ESLLinkEntity addForeignFieldsToEntity(ESLLinkDto eslLinkDto) {

        ESLLinkEntity returnEntity = new ESLLinkEntity();

        ESLEntity eslEntity = eslRepository.findById(eslLinkDto.getEslId()).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        ProductEntity productEntity = productRepository.findById(eslLinkDto.getProductId()).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        OutletEntity outletEntity = outletRepository.findById(eslLinkDto.getOutletId()).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        returnEntity.setEsl(eslEntity);
        returnEntity.setOutlet(outletEntity);
        returnEntity.setProduct(productEntity);
        if (eslLinkDto.getDeleted() != null)
            returnEntity.setDeleted(eslLinkDto.getDeleted());

        return returnEntity;
    }
}
