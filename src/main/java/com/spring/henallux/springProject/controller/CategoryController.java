package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.CategoryService;
import com.spring.henallux.springProject.service.DiscountService;
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

    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET)
    public String categoriesGet(Model model, Locale locale){
        List<Category> categories = categoryService.getAllCategories();
        List<Translation> translatedCategories = categories
                .stream()
                .map(c -> translationService.getTranslationByCategoryAndLanguage(c, new Language(locale.getLanguage())))
                .toList();

        List<Discount> discounts = discountService.getAllCurrent();

        List<Map<String, Object>> finalCategories = translatedCategories.stream().map(transCat -> {
            Map<String, Object> cat = new HashMap<>();
            cat.put("translatedCategory", transCat);
            Optional<Discount> dis = discounts.stream()
                    .filter(d -> d.getCategory().getId() == transCat.getCategory().getId())
                    .findFirst();
            cat.put("discount", dis);

            return cat;
        }).toList();

        model.addAttribute("finalCategories", finalCategories);
        return "integrated:categories";
    }
}
