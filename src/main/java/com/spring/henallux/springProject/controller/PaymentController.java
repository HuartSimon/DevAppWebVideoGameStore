package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String payment(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "integrated:payment";
    }

    @RequestMapping(value = "/{id}/paymentFailed", method = RequestMethod.GET)
    public String paymentFailed() {
        return "integrated:paymentFailed";
    }

    @RequestMapping(value = "/{id}/paymentSuccess", method = RequestMethod.GET)
    public String paymentSuccess(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        order.setIsPayed(true);
        orderService.saveOrder(order);;
        return "integrated:paymentSuccess";
    }

    @RequestMapping(value = "/{id}/goToPayment", method = RequestMethod.POST)
    public String goToPayment(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);

        String uri = UriComponentsBuilder
                .fromHttpUrl("https://www.sandbox.paypal.com/cgi-bin/webscr")
                .queryParam("business", "emilienberlemontsellor@business.example.com")
                .queryParam("cert_id", "AdRnk4V3O1FCsqRX3qgQoutj4AcHA2-VuAYurVgGfLUDjWOvyWhSTBNy-V6SXUpq9Fw2cxXE09skI7YW")
                .queryParam("cmd", "_xclick")
                .queryParam("amount", order.getTotalPrice())
                .queryParam("item_name", "Order")
                .queryParam("currency_code", "USD")
                .queryParam("lc", "en_US")
                .queryParam("locale.x", "en_US")
                .queryParam("return", "http://localhost:3002/spring/payment/" + order.getId() + "/paymentSuccess")
                .queryParam("cancel_return", "http://localhost:3002/spring/payment/" + order.getId() + "/paymentFailed")
                .toUriString();

        return "redirect:" + uri;
    }
}
