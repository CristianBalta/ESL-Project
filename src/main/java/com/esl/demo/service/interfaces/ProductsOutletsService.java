package com.esl.demo.service.interfaces;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.LinkId;

import java.util.List;

public interface ProductsOutletsService {

    ProductsOutletsDto getById(LinkId id);

    List<ProductsOutletsDto> getAll();

    ProductsOutletsDto add(ProductsOutletsDto productsOutletsDto);

    ProductsOutletsDto update(ProductsOutletsDto productsOutletsDto);

    void delete(LinkId id);

}
