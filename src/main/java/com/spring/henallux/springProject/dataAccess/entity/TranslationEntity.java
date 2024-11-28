package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation")
public class TranslationEntity {

    @Column(name="id")
    @Id
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name = "language", referencedColumnName = "label")
    @ManyToOne
    private LanguageEntity language;


    public TranslationEntity() {}
    public TranslationEntity(Integer id, String name, String description, CategoryEntity category, LanguageEntity language) {
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
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    public void setLanguage(LanguageEntity language) {
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
    public CategoryEntity getCategory() {
        return category;
    }
    public LanguageEntity getLanguage() {
        return language;
    }
}
