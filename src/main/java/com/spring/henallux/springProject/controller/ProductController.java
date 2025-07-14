package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/product")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_ORDER, Constants.CURRENT_USER})
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderLineService orderLineService;
    @Autowired
    TranslationService translationService;

    @Autowired
    private DiscountService discountService;

    @ModelAttribute(Constants.CURRENT_ORDER_LINE)
    public OrderLine orderLine() { return new OrderLine(); }

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

        Discount discount = discountService.getCurrentAndByCategoryId(product.getCategory().getId());

        Map<String, Object> item = new HashMap<>();
        item.put("product", product);
        item.put("translatedCategory", translatedCategory);
        item.put("discount", discount);

        model.addAttribute("item", item);
        return "integrated:product";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String productPost(@PathVariable("id") int id, Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_ORDER_LINE) OrderLine orderLine,
                              @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                              @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              @ModelAttribute(value = Constants.CURRENT_ORDER) Order order,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "integrated:product/" + id;
        }

        Product product = productService.getProductById(id);

        orderLine.setProduct(product);
        orderLine.setPrice(product.getPrice());

        // FAIRE SYSTEME DE DISCOUNT
        // CHERCHER LA DISCOUNT : EN FONCTION DE LA CATEGORIE DU PRODUIT, SI LA DATE DE L'ORDER EST COMPRISE
        // ENTRE LA DATE DE DEBUT ET DE FIN DE LA DISCOUNT L'APPLIQUER
        // ? SI Y A PLUSIEURS POSSIBILITE QUEL DISCOUNT CHOISIR ?
        orderLine.setDiscount(0.20); // A CHANGER

        orderLine.setId(cart.getOrderLines().size()+1);
        cart.addOrderLine(orderLine.getId(), orderLine);
        return "redirect:/cart";
    }
}
