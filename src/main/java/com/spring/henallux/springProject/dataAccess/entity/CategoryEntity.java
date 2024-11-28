package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name="id")
    private Integer id;

    public CategoryEntity(){}
    public CategoryEntity(Integer id) {
        setId(id);
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
}
