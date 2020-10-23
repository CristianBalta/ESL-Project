package com.esl.demo.service.interfaces;

import com.esl.demo.dto.ESLLinkDto;
import com.esl.demo.entity.compositeKeys.ESLLinkId;

import java.util.List;

public interface ESLLinkService {

    ESLLinkDto getById(ESLLinkId eslLinkId);

    List<ESLLinkDto> getAll();

    ESLLinkDto add(ESLLinkDto eslLinkDto);

    ESLLinkDto update(ESLLinkDto eslLinkDto);

    void delete(ESLLinkId id);
}
