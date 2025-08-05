package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`order`")
public class OrderEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "is_payed")
    private Boolean isPayed;

    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLineEntity> orderLines;

    public OrderEntity() {}

    public OrderEntity(UserEntity user) {
        setUser(user);
    }

    public OrderEntity(UserEntity user, List<OrderLineEntity> orderLines) {
        setUser(user);
        setOrderLines(orderLines);
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

    public void setOrderLines(List<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
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

    public List<OrderLineEntity> getOrderLines() {
        return orderLines;
    }
}
