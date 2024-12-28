package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.springProject.dataAccess.dao.OrderLineDataAccess;
import com.spring.henallux.springProject.model.Cart;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.OrderLine;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderDataAccess orderDAO;
    @Autowired
    private OrderLineDataAccess orderLineDAO;

    public Order saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }

    public ArrayList<Order> getOrdersByUser(User user) {
        return orderDAO.findByUser(user);
    }

    public Order getOrderById(int orderId) {
        return orderDAO.findById(orderId);
    }


}
