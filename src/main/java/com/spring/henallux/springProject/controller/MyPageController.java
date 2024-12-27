package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "myPage")
@SessionAttributes({Constants.CURRENT_USER})
public class MyPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String authenticated(@Valid @ModelAttribute(Constants.CURRENT_USER) User user, final BindingResult errors){
        return "integrated:myPage";
    }
}
