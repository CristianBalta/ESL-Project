package com.esl.demo.repository;

import com.esl.demo.entity.ESLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESLRepository extends JpaRepository<ESLEntity, Long> {
}
