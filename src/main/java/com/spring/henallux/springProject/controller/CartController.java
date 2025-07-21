package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_USER})
public class CartController {
    @Autowired
    private OrderService orderService;

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() { return new Cart(); }

    @ModelAttribute(Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }

    @RequestMapping(method = RequestMethod.GET)
    public String cartGet(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        HashMap<Integer, OrderLine> orderLines = cart.getOrderLines();
        model.addAttribute("orderLines", orderLines.values()); // TODO : passer la hash map complete pour popvuroi connaitre les id dans la page car les ids des order lines sont vident

        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String order(Model model,
                        RedirectAttributes redirectAttributes,
                        @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                        @ModelAttribute(value = Constants.CURRENT_USER) User user)
    {
        if (user instanceof VisitorUser) {
            redirectAttributes.addFlashAttribute("notAuthenticatedError", "You must be logged in to place an order ! Please log in or sign up." );
            return "redirect:/cart";
        } else {
            var order = cart.ToOrder(user);
            order = orderService.saveOrder(order);
            return "redirect:/payment/" + order.getId();
        }
    }

    @RequestMapping(value = "/delete/{orderLineId}")
    public ResponseEntity<String> deleteOrderLine(@PathVariable(value = "orderLineId") Integer orderLineId, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        if (cart != null) {
            boolean removed = cart.getOrderLines().values().removeIf(orderLine -> orderLine.getId().equals(orderLineId));
            if (removed) {
                return ResponseEntity.ok("Order line deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order line not found in the cart.");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not found.");

    }

    // Ajouter un article
    @RequestMapping(value = "/add/{orderLineId}")
    public ResponseEntity<String> addItem(@PathVariable(value = "orderLineId") Integer orderLineId, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        if (cart != null) {
            for (OrderLine orderLine : cart.getOrderLines().values()) {
                if (orderLine.getId().equals(orderLineId)) {
                    orderLine.setQuantity(orderLine.getQuantity() + 1);
                    return ResponseEntity.ok("Item added successfully!");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order line not found in the cart.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not found.");
    }

    @RequestMapping(value = "/remove/{orderLineId}")
    public ResponseEntity<String> removeItem(@PathVariable(value = "orderLineId") Integer orderLineId, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        if (cart != null) {
            HashMap<Integer, OrderLine> orderLines = cart.getOrderLines();

            for(Integer key : orderLines.keySet()) {
                OrderLine orderLine = orderLines.get(key);
                if (orderLine.getId().equals(orderLineId)) {
                    if (orderLine.getQuantity() > 1) {
                        orderLine.setQuantity(orderLine.getQuantity() - 1);
                    } else {
                        cart.removeOrderLine(orderLine.getId());
                    }
                    return ResponseEntity.ok("Item removed successfully!");
                }
            }

            /*for (OrderLine orderLine : orderLines.values()) {
                if (orderLine.getId().equals(orderLineId)) {
                    if (orderLine.getQuantity() > 1) {
                        orderLine.setQuantity(orderLine.getQuantity() - 1);
                    } else {
                        cart.removeOrderLine(orderLine.getId());
                    }
                    return ResponseEntity.ok("Item removed successfully!");
                }
            }*/
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order line not found in the cart.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not found.");
    }

}

