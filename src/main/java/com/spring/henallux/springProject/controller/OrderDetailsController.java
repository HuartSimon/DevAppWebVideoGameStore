package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.OrderLine;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/orderDetails")
public class OrderDetailsController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String orderDetailsGet(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "integrated:orderDetails";
    }
}
