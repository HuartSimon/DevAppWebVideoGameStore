package com.spring.henallux.springProject.model;

import javax.validation.constraints.Min;

public class NewOrderLineForm {

    private Integer productId;

    @Min(1)
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
