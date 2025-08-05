package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryDBAccess implements CategoryDataAccess {
    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDBAccess(CategoryRepository categoryRepository, ProviderConverter providerConverter) {
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Category findById(int id){
        return providerConverter.categoryEntityToCategoryModel(categoryRepository.findById(id));
    }

    @Override
    public ArrayList<Category> findAll() {
        return new ArrayList<>(categoryRepository.findAll()
                .stream()
                .map(category -> providerConverter.categoryEntityToCategoryModel(category))
                .toList());
    }
}
