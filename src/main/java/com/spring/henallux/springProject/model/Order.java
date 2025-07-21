package com.spring.henallux.springProject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private LocalDate orderDate;
    private Boolean isPayed;
    private User user;
    private List<OrderLine> orderLines;

    public Order() {}
    public Order(User user) {
        setUser(user);
        setId(null);
        setIsPayed(false);
        setOrderDate(LocalDate.now());
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public void setIsPayed(Boolean payed) {
        isPayed = payed;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setOrderLines(List<OrderLine> orderLines) { this.orderLines = orderLines; }

    public Integer getId() {
        return id;
    }
    public Boolean getIsPayed() {
        return isPayed;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public User getUser() {
        return user;
    }
    public List<OrderLine> getOrderLines() { return orderLines; }
    public Double getTotalPrice() {
        return orderLines.stream().mapToDouble(OrderLine::getTotalPrice).sum();
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", isPayed=" + isPayed +
                ", user=" + user +
                '}';
    }
}
