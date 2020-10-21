package com.esl.demo.repository;

import com.esl.demo.entity.ESLEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ESLRepository extends CrudRepository<ESLEntity, Long> {

    ESLEntity getById(Long id);

    List<ESLEntity> findAll();

}
