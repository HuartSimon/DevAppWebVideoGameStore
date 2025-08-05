package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.springProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = WebSecurityConfiguration.LOGIN_REQUEST)
@SessionAttributes({Constants.CURRENT_USER})
public class LoginController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User currentUser() { return new User(); }

    @RequestMapping(method = RequestMethod.GET)
    public String login(@ModelAttribute(value = Constants.CURRENT_USER) User user) {
        return "integrated:login";
    }
}