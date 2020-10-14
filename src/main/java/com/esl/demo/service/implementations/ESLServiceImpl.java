package com.esl.demo.service.implementations;

import com.esl.demo.dto.ESLDto;
import com.esl.demo.service.interfaces.ESLService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ESLServiceImpl implements ESLService {
    @Override
    public ESLDto getById(Long id) {
        return null;
    }

    @Override
    public List<ESLDto> getAll() {
        return null;
    }

    @Override
    public ESLDto add(ESLDto eslDto) {
        return null;
    }

    @Override
    public ESLDto update(ESLDto eslDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
