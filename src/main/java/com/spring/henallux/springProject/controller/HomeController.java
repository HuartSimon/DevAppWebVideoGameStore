package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.VisitorUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes(Constants.CURRENT_USER)
public class HomeController {

    @ModelAttribute(value = Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }

    @RequestMapping(method = RequestMethod.GET)
    public String homeGet(){ return "integrated:home"; }
}
