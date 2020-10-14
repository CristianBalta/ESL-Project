package com.esl.demo.repository;

import com.esl.demo.entity.OutletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends JpaRepository<OutletEntity, Long> {
}
