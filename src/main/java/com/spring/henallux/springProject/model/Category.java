package com.spring.henallux.springProject.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Category {
    private Integer id;
    private List<Discount> discounts;

    public Category(){
    }
    public Category(Integer id, List<Discount> discounts) {
        setDiscounts(discounts);
        setId(id);
    }

    public Integer getId() { return id; }
    public Double getCurrentDiscountValue() {
        var discount = discounts.stream()
            .filter(dis ->
                LocalDateTime.now().isAfter(dis.getBeginDate()) &&
                LocalDateTime.now().isBefore(dis.getEndDate()))
            .findFirst();
        System.out.println(discount);
        
        return discount.isPresent() ? discount.get().getDiscountVal() : null;
    }

    public void setId(Integer id) { this.id = id; }

    public List<Discount> getDiscounts() { return discounts; }

    public void setDiscounts(List<Discount> discounts) { this.discounts = discounts; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }
}
