package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Discount;
import java.util.ArrayList;

public interface DiscountDataAccess {
    Discount findById(int id);
    ArrayList<Discount> findAll();
}
