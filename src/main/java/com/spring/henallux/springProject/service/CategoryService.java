package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.springProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDataAccess categoryDAO;

    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryDAO.findById(id);
    }
}
