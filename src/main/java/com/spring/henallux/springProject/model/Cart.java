package com.spring.henallux.springProject.model;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, OrderLine> orderLines = new HashMap<>();

    public HashMap<Integer, OrderLine>  getOrderLines() { return orderLines; }

    public void addProduct(Product product, Integer quantity) {

        var orderLine = orderLines.get(product.getId());

        if(orderLine == null){
            orderLines.put(product.getId(), new OrderLine(quantity, product));
        }else{
            orderLine.addQuantity(quantity);
        }
    }

    public void increaseProductQuantity(Integer id, Integer quantity){
        var orderLine = orderLines.get(id);
        if(orderLine != null)
            orderLine.addQuantity(quantity);
    }

    public void removeOrderLine(Integer id) {
        orderLines.remove(id);
    }

    public void decreaseProductQuantity(Integer id, Integer quantity){
        var orderLine = orderLines.get(id);
        if(orderLine != null){
            orderLine.decreaseQuantity(quantity);
            if(orderLine.getQuantity() == 0)
                removeOrderLine(id);
        }
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

    public boolean isEmpty(){
        return orderLines == null || orderLines.isEmpty() || orderLines.values().isEmpty();
    }
}
