package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.springProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Category;
import com.spring.henallux.springProject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.henallux.springProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.springProject.model.Translation;

import java.util.ArrayList;
import java.util.List;


@Service
public class TranslationDBAccess implements TranslationDataAccess {
    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDBAccess(TranslationRepository translationRepository, ProviderConverter providerConverter) {
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Translation findById(int id) {
        return providerConverter.translationEntityToTranslationModel(translationRepository.findById(id));
    }

    @Override
    public ArrayList<Translation> findAll() {
        List<TranslationEntity> translationsEntities = translationRepository.findAll();
        ArrayList<Translation> translationsModel = new ArrayList<>();

        for (TranslationEntity translation : translationsEntities)
            translationsModel.add(providerConverter.translationEntityToTranslationModel(translation));

        return translationsModel;
    }

    @Override
    public Translation findByCategoryAndLanguage(Category category, Language language) {
        CategoryEntity categoryEntity = providerConverter.categoryModelToCategoryEntity(category);
        LanguageEntity languageEntity = providerConverter.languageModelToLanguageEntity(language);
        TranslationEntity translationEntity =  translationRepository.findByCategoryAndLanguage(categoryEntity, languageEntity);
        return providerConverter.translationEntityToTranslationModel(translationEntity);
    }
}
