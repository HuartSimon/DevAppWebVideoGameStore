package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.CategoryService;
import com.spring.henallux.springProject.service.ProductService;
import com.spring.henallux.springProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;

import java.util.*;

@Controller
@RequestMapping(value = "/products")
@SessionAttributes(Constants.CURRENT_CATEGORY)
public class ProductsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TranslationService translationService;

    @ModelAttribute(Constants.CURRENT_CATEGORY)
    public Category category() { return new Category(); }

    @RequestMapping(method = RequestMethod.GET)
    public String productsGet(Model model,
                              @RequestParam(value = "category", required = false) Integer categoryId,
                              @ModelAttribute(Constants.CURRENT_CATEGORY) Category currentCategory) {
        List<Category> categories = categoryService.getAllCategories();
        List<Translation> translatedCategories =  new ArrayList<>();
        for (Category category : categories) {
            // A FAIRE : mettre langage choisi par le user
            translatedCategories.add(translationService.getTranslationByCategoryAndLanguage(category, new Language("English")));
        }
        model.addAttribute("translatedCategories", translatedCategories);

        List<Product> products;
        if (categoryId == null) {
            products = productService.getAllProducts();
        } else {
            Category chosenCategory = categoryService.getCategoryById(categoryId);
            products = productService.getProductsByCategoryId(chosenCategory);
        }
        model.addAttribute("products", products);
        model.addAttribute("selectedCategoryId", categoryId);
        return "integrated:products";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String productsPost() {
        return "integrated:product";
    }
}
