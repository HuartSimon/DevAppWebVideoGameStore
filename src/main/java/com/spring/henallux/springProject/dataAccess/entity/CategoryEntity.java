package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "category")
    private List<DiscountEntity> discounts;

    public CategoryEntity(){

    }

    public CategoryEntity(Integer id, List<DiscountEntity> discounts) {
        setDiscounts(discounts);
        setId(id);
    }

    public Integer getId() { return id; }
    public List<DiscountEntity> getDiscounts() {
        return discounts;
    }

    public void setId(Integer id) { this.id = id; }
    public void setDiscounts(List<DiscountEntity> discounts) {
        this.discounts = discounts;
    }
}
