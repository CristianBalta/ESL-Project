package com.esl.demo.service.interfaces;

import com.esl.demo.dto.ProductsOutletsDto;
import com.esl.demo.entity.compositeKeys.ProductsOutletsLinkId;

import java.util.List;

public interface ProductsOutletsService {

    ProductsOutletsDto getById(ProductsOutletsLinkId id);

    List<ProductsOutletsDto> getAll();

    ProductsOutletsDto add(ProductsOutletsDto productsOutletsDto);

    ProductsOutletsDto update(ProductsOutletsDto productsOutletsDto);

    void delete(ProductsOutletsLinkId id);
}
