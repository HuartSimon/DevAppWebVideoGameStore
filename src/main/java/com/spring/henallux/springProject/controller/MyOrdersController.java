package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/myOrders")
@SessionAttributes(Constants.CURRENT_USER)

public class MyOrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String myOrders(Model model, @SessionAttribute(Constants.CURRENT_USER) User user) {
        ArrayList<Order> orders = orderService.getOrdersByUser(user);
        model.addAttribute("orders", orders);
        return "integrated:myOrders";
    }
}
