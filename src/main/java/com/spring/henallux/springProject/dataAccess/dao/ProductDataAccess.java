package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Category;
import com.spring.henallux.springProject.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDataAccess {
    Product findById(int id);
    ArrayList<Product> findAll();
    ArrayList<Product> findByCategoryId(Integer categoryId);

}
