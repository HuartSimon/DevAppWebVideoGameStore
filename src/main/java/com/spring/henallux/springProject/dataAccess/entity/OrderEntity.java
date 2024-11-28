package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "`order`")
public class OrderEntity {
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "is_payed")
    private Boolean isPayed;

    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;


    public OrderEntity() {}
    public OrderEntity(Integer id, LocalDate orderDate, Boolean isPayed, UserEntity user) {
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
    public void setUser(UserEntity user) {
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
    public UserEntity getUser() {
        return user;
    }
}
