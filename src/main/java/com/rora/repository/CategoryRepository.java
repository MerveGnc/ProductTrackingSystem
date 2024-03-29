package com.rora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.rora.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
