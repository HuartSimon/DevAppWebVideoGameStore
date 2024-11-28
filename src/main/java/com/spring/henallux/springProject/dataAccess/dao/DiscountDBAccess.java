package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.repository.DiscountRepository;
import com.spring.henallux.springProject.dataAccess.entity.DiscountEntity;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountDBAccess implements DiscountDataAccess {
    private DiscountRepository discountRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public DiscountDBAccess(DiscountRepository discountRepository, ProviderConverter providerConverter) {
        this.discountRepository = discountRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public Discount findById(int id){
        return providerConverter.discountEntityToDiscountModel(discountRepository.findById(id));
    }
    @Override
    public ArrayList<Discount> findAll() {
        List<DiscountEntity> discounts = discountRepository.findAll();
        ArrayList<Discount> discountsModel = new ArrayList<>();

        for (DiscountEntity discount : discounts)
            discountsModel.add(providerConverter.discountEntityToDiscountModel(discount));

        return discountsModel;
    }
}
