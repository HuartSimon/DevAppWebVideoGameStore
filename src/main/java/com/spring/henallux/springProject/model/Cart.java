package com.spring.henallux.springProject.model;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, OrderLine> orderLines = new HashMap<>();

    public HashMap<Integer, OrderLine>  getOrderLines() { return orderLines; }

    public void addOrderLine(Integer orderLineId, OrderLine orderLine) {
        orderLines.put(orderLineId, orderLine);
    }
    public void removeOrderLine(Integer orderLineId) {
        orderLines.remove(orderLineId);
    }

    public Order ToOrder(User user){
        Order order = new Order(user);

        order.setOrderLines(getOrderLines().values().stream().toList());
        orderLines.clear();

        return order;
    }

    public Double getTotalPrice() {
        return orderLines.values().stream().mapToDouble(OrderLine::getTotalPrice).sum();
    }
}
