package com.esl.demo.service.implementations;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.entity.ESLEntity;
import com.esl.demo.repository.ESLRepository;
import com.esl.demo.rest.errors.CustomBadRequestException;
import com.esl.demo.rest.errors.ErrorConstants;
import com.esl.demo.service.interfaces.ESLService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ESLServiceImpl implements ESLService {

    private final ESLRepository eslRepository;

    public ESLServiceImpl(ESLRepository eslRepository) {
        this.eslRepository = eslRepository;
    }

    @Override
    public ESLDto getById(Long id) {

        return eslRepository.findById(id)
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                })
                .convertToDto();
    }

    @Override
    public List<ESLDto> getAll() {

        return eslRepository.findAll().stream()
                .map(ESLEntity::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ESLDto add(ESLDto eslDto) {

        return eslRepository.save(eslDto.convertToEntity()).convertToDto();
    }

    @Override
    public ESLDto update(ESLDto eslDto) {

        ESLEntity updatedEntity = eslRepository
                .findById(eslDto.getId())
                .orElseThrow(() -> {
                    throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
                });
        updatedEntity.setSize(eslDto.getSize());
        updatedEntity.setDeleted(eslDto.getDeleted());

        return eslRepository.save(updatedEntity).convertToDto();
    }

    @Override
    public void delete(Long id) {

        ESLEntity deletedEntity = eslRepository.findById(id).orElseThrow(() -> {
            throw new CustomBadRequestException(ErrorConstants.ERR_ENTITY_NOT_FOUND);
        });

        deletedEntity.setDeleted(true);
        eslRepository.save(deletedEntity);
    }
}
