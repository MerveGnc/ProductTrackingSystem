package com.rora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rora.model.Store;

@Repository
public interface StoreRepository extends JpaRepository <Store,Long>{

}
