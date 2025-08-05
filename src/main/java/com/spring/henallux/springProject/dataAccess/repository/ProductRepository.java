package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findById(int id);
    ArrayList<ProductEntity> findAll();
    ArrayList<ProductEntity> findByCategory_Id(Integer categoryId);
}
