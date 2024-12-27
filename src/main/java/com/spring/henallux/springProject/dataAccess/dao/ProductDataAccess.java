package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    Product findById(int id);
    ArrayList<Product> findAll();
}
