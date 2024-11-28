package com.spring.henallux.springProject.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Order {
    private Integer id;
    private LocalDate orderDate;
    private Boolean isPayed;
    private User user;


    public Order() {}
    public Order(Integer id, LocalDate orderDate, Boolean isPayed, User user) {
        setId(id);
        setOrderDate(orderDate);
        setPayed(isPayed);
        setUser(user);
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public void setPayed(Boolean payed) {
        isPayed = payed;
    }
    public void setUser(User user) {
        this.user = user;
    }


    public Integer getId() {
        return id;
    }
    public Boolean getPayed() {
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
