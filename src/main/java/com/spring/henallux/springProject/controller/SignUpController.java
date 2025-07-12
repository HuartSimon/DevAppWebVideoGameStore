package com.spring.henallux.springProject.controller;
import com.spring.henallux.springProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.model.VisitorUser;
import com.spring.henallux.springProject.service.UserService;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/signUp")
public class SignUpController {
    @Autowired
    private UserService userService;

    @ModelAttribute(Constants.CURRENT_USER)
    public VisitorUser visitorUser() { return new VisitorUser(); }

    @RequestMapping(method = RequestMethod.GET)
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "integrated:signUp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitSignup(@RequestParam("confirmedPassword") String confirmedPassword, Model model, @Valid @ModelAttribute(value = Constants.CURRENT_USER) User user, BindingResult errors) {
        if (userService.isUsernameAlreadyTaken(user.getUsername())) {
            model.addAttribute("usernameError", true);
            return "integrated:signUp";
        }
        if (userService.isEmailAlreadyTaken(user.getEmail())) {
            model.addAttribute("emailError", true);
            return "integrated:signUp";
        }
        if(!(user.getPassword().equals(confirmedPassword))) {
            model.addAttribute("passwordError", true);
            return "integrated:signUp";
        }
        if (errors.hasErrors()) {
            ArrayList<String> validationErrors = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                validationErrors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            model.addAttribute("validationErrors", validationErrors);
            return "integrated:signUp";
        }
        user.setAuthorities("ROLE_USER");
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        userService.saveUser(user);

        return "redirect:login";
    }
}
