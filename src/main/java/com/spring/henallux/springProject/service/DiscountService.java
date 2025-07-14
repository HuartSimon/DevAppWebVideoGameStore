package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.DiscountDataAccess;
import com.spring.henallux.springProject.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DiscountService {

    @Autowired
    private DiscountDataAccess discountDAO;

    public List<Discount> getAllCurrent(){
        return discountDAO.getAllCurrent();
    }

    public Discount getCurrentAndByCategoryId(Integer id){
        return discountDAO.getCurrentAndByCategoryId(id);
    }
}
