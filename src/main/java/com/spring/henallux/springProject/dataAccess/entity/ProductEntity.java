package com.spring.henallux.springProject.dataAccess.entity;

import com.spring.henallux.springProject.model.Category;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;


    public ProductEntity() {}
    public ProductEntity(Integer id, String name, String description, Double price, CategoryEntity category) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory(category);
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public CategoryEntity getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
}
