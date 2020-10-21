package com.esl.demo.repository;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.LinkId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsOutletsRepository extends CrudRepository<ProductsOutletsEntity, LinkId> {

    ProductsOutletsEntity getByProductsOutletsId(LinkId linkId);

    List<ProductsOutletsEntity> findAll();

}
