package com.spring.henallux.springProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLineEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @JoinColumn(name = "`order`", referencedColumnName = "id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;


    public OrderLineEntity() { }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    public void setProduct(ProductEntity product) {
        this.product = product;
    }


    public Integer getId() {
        return id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getPrice() {
        return price;
    }
    public Double getDiscount() {
        return discount;
    }
    public OrderEntity getOrder() {
        return order;
    }
    public ProductEntity getProduct() {
        return product;
    }
}
