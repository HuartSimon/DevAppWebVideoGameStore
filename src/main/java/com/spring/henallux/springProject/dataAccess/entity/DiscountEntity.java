package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="discount")
public class DiscountEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="discount_val")
    private Double discountVal;

    @Column(name="begin_date")
    private LocalDateTime beginDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;


    public DiscountEntity() {}
    public DiscountEntity(Integer id, Double discountVal, LocalDateTime beginDate, LocalDateTime endDate, CategoryEntity category) {
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
    public CategoryEntity getCategory() {
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
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
