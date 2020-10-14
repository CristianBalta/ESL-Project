package com.esl.demo.service.interfaces;

import com.esl.demo.dto.ESLDto;

import java.util.List;

public interface ESLService {

    ESLDto getById(Long id);

    List<ESLDto> getAll();

    ESLDto add(ESLDto eslDto);

    ESLDto update(ESLDto eslDto);

    void delete(Long id);

}
