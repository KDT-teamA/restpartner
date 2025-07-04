package com.example.restpartner.Repository;

import com.example.restpartner.Entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {
    List<StockEntity> findByAnalyst_Id(Integer id);
}