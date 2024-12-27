package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Translation;
import java.util.ArrayList;

public interface TranslationDataAccess {
    Translation findById(int id);
    ArrayList<Translation> findAll();
}
