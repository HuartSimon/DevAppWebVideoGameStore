package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.*;
import com.spring.henallux.springProject.service.CartService;
import com.spring.henallux.springProject.service.DiscountService;
import com.spring.henallux.springProject.service.OrderLineService;
import com.spring.henallux.springProject.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_USER, Constants.CURRENT_ORDER})
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private DiscountService discountService;

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() { return new Cart(); }

    @ModelAttribute(Constants.CURRENT_ORDER)
    public Order order() { return new Order(); }

    @ModelAttribute(Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }

    @RequestMapping(method = RequestMethod.GET)
    public String cartGet(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        HashMap<Integer, OrderLine> orderLines = cart.getOrderLines();
        model.addAttribute("orderLines", orderLines.values());

        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String order(Model model,
                        RedirectAttributes redirectAttributes,
                        @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,
                        @ModelAttribute(value = Constants.CURRENT_USER) User user,
                        @ModelAttribute(value = Constants.CURRENT_ORDER) Order order)
    {
        if (user instanceof VisitorUser) {
            redirectAttributes.addFlashAttribute("notAuthenticatedError", "You must be logged in to place an order ! Please log in or sign up." );
            return "redirect:/cart"; // Redirect instead of integrated/forward to have the model.attribute : orderLines made in the GET
            // If I make integrated, all my orderLines will be lost
        } else { // If the user is not a visitor -> save order in the DB
            order.setOrderDate(LocalDate.now());
            order.setIsPayed(false);
            order.setUser(user);
            order.setId(null);
            order = orderService.saveOrder(order);
            // Save all the orderLines of the order
            for (OrderLine orderLine : cart.getOrderLines().values()) {
                orderLine.setOrder(order);

                // WHAT IF IN THE DB, SOMETHING HAVE CHANGED MEANWHILE
                // (between the orderLine is added in the cart and the moment the user order)

                orderLine.setId(null); // Remove the session ID to assure the auto incremented ID in the DB
                orderLine = orderLineService.saveOrderLine(orderLine);
            }
            cart.clear();
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

