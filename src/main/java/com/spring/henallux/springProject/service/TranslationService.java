package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.TranslationDataAccess;
import com.spring.henallux.springProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    @Autowired
    private TranslationDataAccess translationDAO;

    public Translation getTranslationByCategoryAndLanguage(int categoryId, String languageId) {
        return translationDAO.findByCategoryAndLanguage(categoryId, languageId);
    }
}
