package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Category;
import java.util.ArrayList;

public interface CategoryDataAccess {
    Category findById(int id);
    ArrayList<Category> findAll();
}
