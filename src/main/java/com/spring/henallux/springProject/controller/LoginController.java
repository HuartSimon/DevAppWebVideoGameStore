package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.model.VisitorUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = WebSecurityConfiguration.LOGIN_REQUEST)
@SessionAttributes({Constants.CURRENT_USER})
public class LoginController {

    @ModelAttribute(Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
        return "integrated:login";
    }
}
