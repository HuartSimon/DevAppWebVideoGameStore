package com.spring.henallux.springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @RequestMapping(method = RequestMethod.GET)
    public String companyGet() {
        return "integrated:company";
    }
}
