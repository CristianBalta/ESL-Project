package com.esl.demo.service.implementations;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.LinkId;
import com.esl.demo.service.interfaces.ProductsOutletsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductsOutletsServiceImpl implements ProductsOutletsService {
    @Override
    public ProductsOutletsDto getById(LinkId id) {
        return null;
    }

    @Override
    public List<ProductsOutletsDto> getAll() {
        return null;
    }

    @Override
    public ProductsOutletsDto add(ProductsOutletsDto productsOutletsDto) {
        return null;
    }

    @Override
    public ProductsOutletsDto update(ProductsOutletsDto productsOutletsDto) {
        return null;
    }

    @Override
    public void delete(LinkId id) {

    }
}
