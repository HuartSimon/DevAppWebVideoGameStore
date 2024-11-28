package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.springProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDBAccess implements ProductDataAccess {
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDBAccess(ProductRepository productRepository, ProviderConverter providerConverter) {
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Product findById(int id) {
        return providerConverter.productEntityToProductModel(productRepository.getById(id));
    }

    @Override
    public ArrayList<Product> findAll() {
        List<ProductEntity> productsEntities = productRepository.findAll();
        ArrayList<Product> productsModel = new ArrayList<>();
        for (ProductEntity productEntity : productsEntities) {
            productsModel.add(providerConverter.productEntityToProductModel(productEntity));
        }
        return productsModel;
    }
}
