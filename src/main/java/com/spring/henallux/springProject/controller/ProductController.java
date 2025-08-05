package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.Cart;
import com.spring.henallux.springProject.model.NewOrderLineForm;
import com.spring.henallux.springProject.model.Product;
import com.spring.henallux.springProject.model.Translation;
import com.spring.henallux.springProject.service.ProductService;
import com.spring.henallux.springProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/product")
@SessionAttributes({Constants.CURRENT_CART})
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    TranslationService translationService;

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() { return new Cart(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String productGet(@PathVariable("id") int id, Model model, Locale locale) {
        Product product = productService.getProductById(id);
        Translation translatedCategory = translationService.getTranslationByCategoryAndLanguage(product.getCategory().getId(), locale.getLanguage());

        model.addAttribute("product", product);
        model.addAttribute("translatedCategory", translatedCategory);

        // add only if it doesn't exists to keep error info after redirection
        if (!model.containsAttribute("currentNewOrderLineForm")) {
            model.addAttribute("currentNewOrderLineForm", new NewOrderLineForm());
        }

        return "integrated:product";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String productPost(@PathVariable("id") int id,
                              RedirectAttributes redirectAttributes,
                              @SessionAttribute(value = Constants.CURRENT_CART) Cart cart,
                              @Valid @ModelAttribute(name = "currentNewOrderLineForm") NewOrderLineForm newOrderLineForm,
                              final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("currentNewOrderLineForm", newOrderLineForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.currentNewOrderLineForm", bindingResult);
            return "redirect:/product/" + id;
        }

        Product product = productService.getProductById(id);
        cart.addProduct(product, newOrderLineForm.getQuantity());
        return "redirect:/cart";
    }
}
