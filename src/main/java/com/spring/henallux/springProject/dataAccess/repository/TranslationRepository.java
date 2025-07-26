package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.springProject.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    TranslationEntity findById(int id);
    TranslationEntity findByCategory_IdAndLanguage_Label(int categoryId, String languageId);
}
