package com.esl.demo.repository;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.ProductsOutletsLinkId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsOutletsRepository extends CrudRepository<ProductsOutletsEntity, ProductsOutletsLinkId> {

    Optional<ProductsOutletsEntity> findByProductIdAndOutletId(Long productId, Long outletId);

    List<ProductsOutletsEntity> findAll();
}
