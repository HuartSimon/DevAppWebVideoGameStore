package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springProject.model.Category;
import com.spring.henallux.springProject.model.Language;
import com.spring.henallux.springProject.model.Translation;
import java.util.ArrayList;
import java.util.List;

public interface TranslationDataAccess {
    Translation findById(int id);
    ArrayList<Translation> findAll();
    Translation findByCategoryAndLanguage(int categoryId, String languageId);
}
