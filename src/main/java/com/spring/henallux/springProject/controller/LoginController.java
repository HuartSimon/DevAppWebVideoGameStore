package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.springProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = WebSecurityConfiguration.LOGIN_REQUEST)
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "integrated:login";
    }
}
