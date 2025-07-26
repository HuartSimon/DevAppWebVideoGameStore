package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.springProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.springProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Category;
import com.spring.henallux.springProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products;
    @Autowired
    private ProductDataAccess productDAO;


    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        return productDAO.findByCategoryId(categoryId);
    }
}
