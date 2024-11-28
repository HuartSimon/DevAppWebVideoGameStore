package com.spring.henallux.springProject.model;

import javax.validation.constraints.NotNull;

public class Language {
    private String label;

    public Language() {}
    public Language(String label) {
        setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Language{" +
                "label='" + label + '\'' +
                '}';
    }
}
