package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.OrderLine;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.OrderLineService;
import com.spring.henallux.springProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/myOrders")
@SessionAttributes(Constants.CURRENT_USER)
public class MyOrdersController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderLineService orderLineService;

    @RequestMapping(method = RequestMethod.GET)
    public String myOrders(Model model, @ModelAttribute(Constants.CURRENT_USER) User user) {
        ArrayList<Order> orders = orderService.getOrdersByUser(user);

        List<Map<String, Object>> ordersWithPrice = new ArrayList<>();
        for (Order order : orders) {
            ArrayList<OrderLine> orderLines = orderLineService.getOrderLinesByOrderId(order.getId());
            double orderPrice = 0;

            for (OrderLine orderLine : orderLines) {
                double orderLinePrice = orderLine.getPrice()*orderLine.getQuantity()*(1-(orderLine.getDiscount() == null ? 0 : orderLine.getDiscount()));
                orderPrice += orderLinePrice;

            }

            Map<String, Object> map = new HashMap<>();
            map.put("order", order);
            map.put("orderPrice", orderPrice);
            ordersWithPrice.add(map);
        }

        model.addAttribute("ordersWithPrice", ordersWithPrice);
        return "integrated:myOrders";
    }
}
