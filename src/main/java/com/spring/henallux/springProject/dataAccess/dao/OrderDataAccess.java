package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.User;

import java.util.ArrayList;

public interface OrderDataAccess {
    Order findById(int id);
    ArrayList<Order> findAll();
    Order saveOrder(Order order);
    ArrayList<Order> findByUser(User user);
}
