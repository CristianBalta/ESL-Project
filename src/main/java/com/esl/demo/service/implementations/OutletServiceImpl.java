package com.esl.demo.service.implementations;

import com.esl.demo.dto.OutletDto;
import com.esl.demo.service.interfaces.OutletService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OutletServiceImpl implements OutletService {
    @Override
    public OutletDto getById(Long id) {
        return null;
    }

    @Override
    public List<OutletDto> getAll() {
        return null;
    }

    @Override
    public OutletDto add(OutletDto outletDto) {
        return null;
    }

    @Override
    public OutletDto update(OutletDto outletDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
