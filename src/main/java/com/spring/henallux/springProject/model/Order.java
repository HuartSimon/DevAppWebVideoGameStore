package com.spring.henallux.springProject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private LocalDate orderDate;
    private Boolean isPayed;
    private User user;

    public Order() {}
    public Order(Integer id, LocalDate orderDate, Boolean isPayed, User user) {
        setId(id);
        setOrderDate(orderDate);
        setIsPayed(isPayed);
        setUser(user);
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
