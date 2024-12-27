package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.dataAccess.dao.*;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.model.VisitorUser;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes(Constants.CURRENT_USER)
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

    @ModelAttribute(value = Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser();}

    @RequestMapping(method = RequestMethod.GET)
    public String homeGet(){

        // a delete
        ////////////////////////////////

        //System.out.println(userDataAccess.findAll());
        //System.out.println(orderDataAccess.findAll());
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
