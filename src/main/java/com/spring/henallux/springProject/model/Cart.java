package com.spring.henallux.springProject.model;

import java.util.HashMap;

// This class is a order wich is not saved in the DB yet.
// It will be converted into order and will be saved in the DB when the user validate the order
public class Cart {
    private HashMap<Integer, OrderLine> orderLines = new HashMap<>();

    public HashMap<Integer, OrderLine>  getOrderLines() { return orderLines; }

    public void addOrderLine(Integer orderLineId, OrderLine orderLine) {
        orderLines.put(orderLineId, orderLine);
    }
    public void removeOrderLine(Integer orderLineId) {
        orderLines.remove(orderLineId);
    }

    public void clear() {
        orderLines.clear();
    }


}
