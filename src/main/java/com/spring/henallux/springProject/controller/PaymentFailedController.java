package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/payment/{id}/paymentFailed")
public class PaymentFailedController {

    @RequestMapping(method = RequestMethod.GET)
    public String paymentSuccess() {
        return "integrated:paymentFailed";
    }
}
