package com.esl.demo.repository;

import com.esl.demo.entity.ProductsOutletsEntity;
import com.esl.demo.entity.compositeKeys.LinkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOutletsRepository extends JpaRepository<ProductsOutletsEntity, LinkId> {
}
