package com.spring.henallux.springProject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class OrderLine {
    private Integer id;
    @Min(value = 1)
    private Integer quantity;
    private Double price;
    private Double discount;
    private Product product;


    public OrderLine() { }


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
    public Product getProduct() {
        return product;
    }

    public Double getTotalPrice(){
        return quantity * getFinalPrice();
    }

    public Double getFinalPrice(){
        var currentDiscountValue = getDiscount();

        if(currentDiscountValue == null){
            return getPrice();
        }else {
            return getPrice() - (getPrice() *  currentDiscountValue);
        }
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", product=" + product +
                '}';
    }
}
