package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.dataAccess.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    // a delete
    /////////////////////////////
    private UserDataAccess userDataAccess;
    private OrderDataAccess orderDataAccess;
    private OrderLineDataAccess orderLineDataAccess;
    private ProductDataAccess productDataAccess;
    private CategoryDataAccess categoryDataAccess;
    private DiscountDataAccess discountDataAccess;
    private TranslationDataAccess translationDataAccess;
    private LanguageDataAccess languageDataAccess;

    @Autowired
    public HomeController(UserDataAccess userDataAccess, OrderDataAccess orderDataAccess, OrderLineDataAccess orderLineDataAccess, ProductDataAccess productDataAccess, CategoryDataAccess categoryDataAccess, DiscountDataAccess discountDataAccess, TranslationDataAccess translationDataAccess, LanguageDataAccess languageDataAccess) {
        this.userDataAccess = userDataAccess;
        this.orderDataAccess = orderDataAccess;
        this.orderLineDataAccess = orderLineDataAccess;
        this.productDataAccess = productDataAccess;
        this.categoryDataAccess = categoryDataAccess;
        this.discountDataAccess = discountDataAccess;
        this.translationDataAccess = translationDataAccess;
        this.languageDataAccess = languageDataAccess;
    }

    ////////////////////////////////

    @RequestMapping(method = RequestMethod.GET)
    public String home(){

        // a delete
        ////////////////////////////////

        //System.out.println(userDataAccess.findAll());
        System.out.println(orderDataAccess.findAll());
        //System.out.println(orderLineDataAccess.findAll());
        //System.out.println(productDataAccess.findAll());
        //System.out.println(categoryDataAccess.findAll());
        //System.out.println(discountDataAccess.findAll());
        //System.out.println(translationDataAccess.findAll());
        //System.out.println(languageDataAccess.findAll());

        ////////////////////////////////

        return "integrated:home";
    }
}
