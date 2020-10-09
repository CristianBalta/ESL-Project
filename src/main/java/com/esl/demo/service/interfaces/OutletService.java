package com.esl.demo.service.interfaces;

import com.esl.demo.dto.OutletDto;

import java.util.List;

public interface OutletService {

    OutletDto getById(Long id);

    List<OutletDto> getAll();

    OutletDto add(OutletDto outletDto);

    OutletDto update(OutletDto outletDto);

    void delete(Long id);

}
