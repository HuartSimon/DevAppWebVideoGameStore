package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.OrderLineDataAccess;
import com.spring.henallux.springProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.springProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineDataAccess orderLineDAO;

    public OrderLine saveOrderLine(OrderLine orderLine) { return orderLineDAO.saveOrderLine(orderLine); }

    public void deleteOrderLine(Integer orderLineId) {
        orderLineDAO.deleteOrderLineById(orderLineId);
    }

    public void addItem(Integer orderLineId) {
        OrderLine orderLine = orderLineDAO.findById(orderLineId);
        if (orderLine == null)
            throw new RuntimeException("Order line not found");
        orderLine.setQuantity(orderLine.getQuantity() + 1);
        orderLineDAO.saveOrderLine(orderLine);
    }

    public void removeItem(Integer orderLineId) {
        OrderLine orderLine = orderLineDAO.findById(orderLineId);
        if (orderLine == null)
            throw new RuntimeException("Order line not found");
        int newQuantity = orderLine.getQuantity() - 1;
        if (newQuantity > 0) {
            orderLine.setQuantity(newQuantity);
            orderLineDAO.saveOrderLine(orderLine);
        } else {
            // Si la quantité devient 0, supprimez la ligne
            orderLineDAO.deleteOrderLineById(orderLineId);
        }
    }

    public ArrayList<OrderLine> getOrderLinesByOrderId(Integer orderId) {
        return orderLineDAO.findByOrderId(orderId);
    }
}
