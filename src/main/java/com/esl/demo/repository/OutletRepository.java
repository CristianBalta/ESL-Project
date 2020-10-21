package com.esl.demo.repository;

import com.esl.demo.entity.OutletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletRepository extends CrudRepository<OutletEntity, Long> {

    OutletEntity getById(Long id);

    List<OutletEntity> findAll();

}
