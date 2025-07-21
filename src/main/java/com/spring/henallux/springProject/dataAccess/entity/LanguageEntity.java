package com.spring.henallux.springProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class LanguageEntity {
    @Id
    @Column(name = "label")
    private String label;

    public LanguageEntity() {}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
