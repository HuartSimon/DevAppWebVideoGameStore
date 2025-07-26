package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_USER})
public class CartController {
    @Autowired
    private OrderService orderService;

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() { return new Cart(); }

    @ModelAttribute(Constants.CURRENT_USER)
    public User currentUser() { return new User(); }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cartGet(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute("cart", cart);
        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String order(RedirectAttributes redirectAttributes,
                        @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                        @ModelAttribute(value = Constants.CURRENT_USER) User user)
    {
        if (!isAuthenticated()) {
            redirectAttributes.addFlashAttribute("notAuthenticatedError", true);
            return "redirect:/cart";
        } else {
            var order = cart.ToOrder(user);
            order = orderService.saveOrder(order);
            return "redirect:/payment/" + order.getId();
        }
    }

    @RequestMapping(value = "/add/{orderLineId}", method = RequestMethod.POST)
    public String addProductQuantity(
            @PathVariable(value = "orderLineId") Integer orderLineId,
            @ModelAttribute(value = Constants.CURRENT_CART) Cart cart){
        cart.increaseProductQuantity(orderLineId, 1);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/remove/{orderLineId}", method = RequestMethod.POST)
    public String removeProduct(
            @PathVariable(value = "orderLineId") Integer orderLineId,
            @ModelAttribute(value = Constants.CURRENT_CART) Cart cart){
        cart.removeOrderLine(orderLineId);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/decrease/{orderLineId}", method = RequestMethod.POST)
    public String decreaseProductQuantity(
            @PathVariable(value = "orderLineId") Integer orderLineId,
            @ModelAttribute(value = Constants.CURRENT_CART) Cart cart){
        cart.decreaseProductQuantity(orderLineId, 1);
        return "redirect:/cart";
    }
}

