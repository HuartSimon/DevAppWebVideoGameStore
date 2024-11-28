package com.spring.henallux.springProject.model;

public class Category {
    private Integer id;

    public Category(){}
    public Category(Integer id) {
        setId(id);
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }
}
