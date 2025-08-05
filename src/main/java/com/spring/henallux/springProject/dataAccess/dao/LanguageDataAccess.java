package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Language;

import java.util.ArrayList;

public interface LanguageDataAccess {
    Language findById(String label);
    ArrayList<Language> findAll();
}
