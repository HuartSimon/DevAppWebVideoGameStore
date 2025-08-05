package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.Product;
import com.spring.henallux.springProject.model.Translation;
import com.spring.henallux.springProject.service.ProductService;
import com.spring.henallux.springProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TranslationService translationService;

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String productsGet(Model model,
                              @PathVariable(value = "categoryId") Integer categoryId, Locale locale) {

        List<Product> products;
        products = productService.getProductsByCategoryId(categoryId);
        Translation translatedCategory = translationService.getTranslationByCategoryAndLanguage(categoryId, locale.getLanguage());

        model.addAttribute("products", products);
        model.addAttribute("translatedCategory", translatedCategory);
        return "integrated:products";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String productsPost() {
        return "integrated:product";
    }
}
