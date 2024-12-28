package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/payment/{id}/paymentSuccess")
public class PaymentSuccessController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String paymentSuccess(@PathVariable("id") int id, Model model) {
        Order order = orderService.getOrderById(id);
        order.setIsPayed(true);
        orderService.saveOrder(order);;
        return "integrated:paymentSuccess";
    }
}
