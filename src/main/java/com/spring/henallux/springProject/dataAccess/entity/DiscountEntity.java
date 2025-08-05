package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="discount")
public class DiscountEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "category")
    @ManyToOne()
    private CategoryEntity category;

    @Column(name="discount_val")
    private Double discountVal;

    @Column(name="begin_date")
    private LocalDateTime beginDate;

    @Column(name="end_date")
    private LocalDateTime endDate;


    public DiscountEntity() {}


    public Integer getId() {
        return id;
    }
    public Double getDiscountVal() {
        return discountVal;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public CategoryEntity getCategory() {
        return category;
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

    public void setCategory(CategoryEntity categoryEntity) {
        this.category = categoryEntity;
    }
}
