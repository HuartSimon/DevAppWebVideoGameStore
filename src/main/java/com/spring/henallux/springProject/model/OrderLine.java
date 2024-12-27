package com.spring.henallux.springProject.model;

public class OrderLine {
    private Integer id;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Order order;
    private Product product;


    public OrderLine() { }
    public OrderLine(Integer id, Integer quantity, Double price, Double discount, Order order, Product product) {
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setDiscount(discount);
        setOrder(order);
        setProduct(product);
    }


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
    public void setOrder(Order order) {
        this.order = order;
    }
    public void setProduct(Product product) {
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
    public Order getOrder() {
        return order;
    }
    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
