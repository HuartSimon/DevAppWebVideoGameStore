package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.spring.henallux.springProject.Constants;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.context.MessageSource;


@SuppressWarnings("ALL")
@Controller
@RequestMapping(value = "/signUp")
public class SignUpController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PasswordEncoder encoder;

    @ModelAttribute(Constants.CURRENT_USER)
    public User currentUser() { return new User(); }

    @RequestMapping(method = RequestMethod.GET)
    public String signupForm(Model model) {
        return "integrated:signUp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitSignup(@RequestParam("confirmedPassword") String confirmedPassword, Model model, Locale locale, @Valid @ModelAttribute(value = Constants.CURRENT_USER) User user, BindingResult errors) {

        if (userService.isUsernameAlreadyTaken(user.getUsername())) {
            errors.rejectValue("username", "Username.Error.Unique");
        }
        if (userService.isEmailAlreadyTaken(user.getEmail())) {
            errors.rejectValue("email", "Email.Error.Unique");
        }
        if(!(user.getPassword().equals(confirmedPassword))) {
            errors.rejectValue("password", "Password.Error");
        }
        if(errors.hasErrors()) {
            return "integrated:signUp";
        }

        user.setAuthorities("ROLE_USER");
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setPassword(encoder.encode(user.getPassword()));

        userService.saveUser(user);

        return "redirect:login";
    }
}
