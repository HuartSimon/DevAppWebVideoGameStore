package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.CategoryService;
import com.spring.henallux.springProject.service.DiscountService;
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

    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String productsGet(Model model,
                              @PathVariable(value = "categoryId") Integer categoryId, Locale locale) {

        List<Product> products;
        Category chosenCategory = categoryService.getCategoryById(categoryId);
        products = productService.getProductsByCategoryId(chosenCategory);
        Translation translatedCategory = translationService.getTranslationByCategoryAndLanguage(chosenCategory, new Language(locale.getLanguage()));

        model.addAttribute("products", products);

        Map<String, Object> finalCategory = new HashMap<>();
        finalCategory.put("translatedCategory", translatedCategory);
        Discount dis = discountService.getCurrentAndByCategoryId(chosenCategory.getId());
        finalCategory.put("discount", dis);

        model.addAttribute("finalCategory", finalCategory);
        return "integrated:products";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String productsPost() {
        return "integrated:product";
    }
}
