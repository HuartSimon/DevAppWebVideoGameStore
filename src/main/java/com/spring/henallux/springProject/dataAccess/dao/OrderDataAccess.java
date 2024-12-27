package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Order;

import java.util.ArrayList;

public interface OrderDataAccess {
    Order findById(int id);
    ArrayList<Order> findAll();
}
