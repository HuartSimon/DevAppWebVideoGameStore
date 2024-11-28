package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.OrderLine;

import java.util.ArrayList;


public interface OrderLineDataAccess {
    OrderLine findById(int id);
    ArrayList<OrderLine> findAll();
}
