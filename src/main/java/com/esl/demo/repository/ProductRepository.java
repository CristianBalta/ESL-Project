package com.esl.demo.repository;

import com.esl.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    ProductEntity getById(Long id);

    List<ProductEntity> findAll();

}
