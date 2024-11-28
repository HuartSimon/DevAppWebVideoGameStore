package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findById(int id);
}
