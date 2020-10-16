package com.esl.demo.service.implementations;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.entity.ESLEntity;
import com.esl.demo.repository.ESLRepository;
import com.esl.demo.rest.errors.BadRequestException;
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
                    throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
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
                    throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
                });

        if (eslDto.getSize() != null)
            updatedEntity.setSize(eslDto.getSize());
        if (eslDto.getDeleted() != null)
            updatedEntity.setEslLinks(eslDto.getEslLinks());
        if (eslDto.getDeleted() == null)
            updatedEntity.setDeleted(eslDto.getDeleted());

        return eslRepository.save(updatedEntity).convertToDto();

    }

    @Override
    public void delete(Long id) {

        ESLEntity deletedEntity = eslRepository.findById(id).orElseThrow(() -> {
            throw new BadRequestException(ErrorConstants.ERR_INVALID_FIELDS);
        });

        deletedEntity.setDeleted(true);
        eslRepository.save(deletedEntity);

    }
}
