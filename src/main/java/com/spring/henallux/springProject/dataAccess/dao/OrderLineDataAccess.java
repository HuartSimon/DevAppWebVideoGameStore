package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.OrderLine;

import java.util.ArrayList;
import java.util.List;


public interface OrderLineDataAccess {
    OrderLine findById(int id);
    ArrayList<OrderLine> findAll();
    OrderLine saveOrderLine(OrderLine orderLine);
    void deleteOrderLineById(int id);
    ArrayList<OrderLine> findByOrderId(int orderId);
}
