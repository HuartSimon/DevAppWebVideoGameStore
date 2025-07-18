package com.spring.henallux.springProject.model;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Category category;


    public Product (){}
    public Product(Integer id, String name, String description, Double price, Category category){
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
    public void setCategory(Category category) {
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
    public Category getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }

    public Double getFinalPrice(){
        var currentDiscountValue = getCategory().getCurrentDiscountValue();

        if(currentDiscountValue == null){
            return getPrice();
        }else {
            return getPrice() - (getPrice() *  getCategory().getCurrentDiscountValue());
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
