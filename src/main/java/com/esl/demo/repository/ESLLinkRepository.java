package com.esl.demo.repository;

import com.esl.demo.entity.ESLLinkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ESLLinkRepository extends CrudRepository<ESLLinkEntity, Long> {

    Optional<ESLLinkEntity> findByEslIdAndProductIdAndOutletId(Long eslId, Long productId, Long outletId);

    List<ESLLinkEntity> findAll();
}
