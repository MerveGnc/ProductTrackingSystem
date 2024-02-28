package com.rora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rora.model.StoreProductStock;

@Repository
public interface SPSRepository extends JpaRepository<StoreProductStock, Long>{

}
