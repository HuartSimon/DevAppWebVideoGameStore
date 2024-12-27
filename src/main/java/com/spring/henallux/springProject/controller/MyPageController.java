package com.spring.henallux.springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "myPage")
public class MyPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String authenticated(){
        return "integrated:myPage";
    }
}
