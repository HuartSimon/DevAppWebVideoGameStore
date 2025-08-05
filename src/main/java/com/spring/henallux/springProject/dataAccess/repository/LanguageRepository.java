package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {
    LanguageEntity findByLabel(String label);
}
