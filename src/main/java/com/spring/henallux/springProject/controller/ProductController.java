package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/product")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_USER})
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    TranslationService translationService;

    @ModelAttribute(Constants.CURRENT_NEW_ORDER_LINE_FORM)
    public NewOrderLineForm orderLine() { return new NewOrderLineForm(); }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() { return new Cart(); }

    @ModelAttribute(Constants.CURRENT_ORDER)
    public Order order() { return new Order(); }

    @ModelAttribute(Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String productGet(@PathVariable("id") int id, Model model, Locale locale) {
        Product product = productService.getProductById(id);
        Translation translatedCategory = translationService.getTranslationByCategoryAndLanguage(product.getCategory(), new Language(locale.getLanguage()));

        model.addAttribute("product", product);
        model.addAttribute("translatedCategory", translatedCategory);

        return "integrated:product";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String productPost(@PathVariable("id") int id, Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_NEW_ORDER_LINE_FORM) NewOrderLineForm newOrderLineForm,
                              @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                              @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "integrated:product/" + id;
        }

        Product product = productService.getProductById(id);
        cart.addProduct(product, newOrderLineForm.getQuantity());
        return "redirect:/cart";
    }
}
