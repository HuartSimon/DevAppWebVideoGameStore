package com.spring.henallux.springProject.model;

import java.time.LocalDateTime;

public class Discount {
    private Integer id;
    private Double discountVal;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Category category;


    public Discount() {}
    public Discount(Integer id, Double discountVal, LocalDateTime beginDate, LocalDateTime endDate, Category category) {
        setId(id);
        setDiscountVal(discountVal);
        setBeginDate(beginDate);
        setEndDate(endDate);
        setCategory(category);
    }


    public Integer getId() {
        return id;
    }
    public Double getDiscountVal() {
        return discountVal;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public Category getCategory() {
        return category;
    }
    public LocalDateTime getBeginDate() {
        return beginDate;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setDiscountVal(Double discountVal) {
        this.discountVal = discountVal;
    }
    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discountVal=" + discountVal +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", category=" + category +
                '}';
    }
}
