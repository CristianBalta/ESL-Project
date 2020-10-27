package com.esl.demo.service.implementations;

import com.esl.demo.dto.OutletDto;
import com.esl.demo.entity.OutletEntity;
import com.esl.demo.repository.OutletRepository;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.OutletService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OutletServiceImpl implements OutletService {

    private final OutletRepository outletRepository;

    public OutletServiceImpl(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    @Override
    public OutletDto getById(Long id) {

        return outletRepository.findById(id)
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                })
                .convertToDto();
    }

    @Override
    public List<OutletDto> getAll() {

        return outletRepository.findAll().stream()
                .map(OutletEntity::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OutletDto add(OutletDto outletDto) {

        return outletRepository.save(outletDto.convertToEntity()).convertToDto();
    }

    @Override
    public OutletDto update(OutletDto outletDto) {

        OutletEntity updatedEntity = outletRepository
                .findById(outletDto.getId())
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                });
        updatedEntity.setName(outletDto.getName());
        updatedEntity.setCode(outletDto.getCode());
        updatedEntity.setDeleted(outletDto.getDeleted());

        return outletRepository.save(updatedEntity).convertToDto();
    }

    @Override
    public void delete(Long id) {

        OutletEntity deletedEntity = outletRepository.findById(id).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        deletedEntity.setDeleted(true);
        outletRepository.save(deletedEntity);
    }
}
