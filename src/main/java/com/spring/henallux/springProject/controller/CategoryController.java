package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.CategoryService;
import com.spring.henallux.springProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TranslationService translationService;

    @RequestMapping(method = RequestMethod.GET)
    public String categoriesGet(Model model, Locale locale){
        List<Category> categories = categoryService.getAllCategories();
        List<Translation> translatedCategories = categories
            .stream()
            .map(c -> translationService.getTranslationByCategoryAndLanguage(c.getId(), locale.getLanguage()))
            .toList();

        model.addAttribute("translatedCategories", translatedCategories);
        return "integrated:categories";
    }
}