package com.spring.henallux.springProject.dataAccess.dao;
import com.spring.henallux.springProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.springProject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageDBAccess implements LanguageDataAccess{
    private LanguageRepository languageRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public LanguageDBAccess(LanguageRepository languageRepository, ProviderConverter providerConverter) {
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Language> findAll(){
        List<LanguageEntity> languages = languageRepository.findAll();
        ArrayList<Language> languagesModel = new ArrayList<>();

        for (LanguageEntity language : languages)
            languagesModel.add(providerConverter.languageEntityToLanguageModel(language));

        return languagesModel;
    }

    @Override
    public Language findById(String label){
        return providerConverter.languageEntityToLanguageModel(languageRepository.findByLabel(label));
    }

}
