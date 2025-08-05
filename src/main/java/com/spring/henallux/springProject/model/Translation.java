package com.spring.henallux.springProject.model;

public class Translation {
    private Integer id;
    private String name;
    private String description;
    private Category category;
    private Language language;


    public Translation() {}
    public Translation(Integer id, String name, String description, Category category, Language language) {
        setId(id);
        setName(name);
        setDescription(description);
        setCategory(category);
        setLanguage(language);
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }


    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Category getCategory() {
        return category;
    }
    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", language=" + language +
                '}';
    }
}
