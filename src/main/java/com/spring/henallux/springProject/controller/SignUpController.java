package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.model.CreateUserForm;
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
@SessionAttributes({Constants.CURRENT_USER})
public class SignUpController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PasswordEncoder encoder;

    @ModelAttribute(Constants.CURRENT_USER)
    public User currentUser() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String signupForm(Model model) {
        model.addAttribute("userForm", new CreateUserForm());
        return "integrated:signUp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitSignup(Model model, Locale locale, @SessionAttribute(value = Constants.CURRENT_USER) User user, @Valid @ModelAttribute(name = "userForm") CreateUserForm userForm, BindingResult errors) {

        if (userService.isUsernameAlreadyTaken(userForm.getUsername())) {
            errors.rejectValue("username", "Username.Error.Unique");
        }
        if (userService.isEmailAlreadyTaken(userForm.getEmail())) {
            errors.rejectValue("email", "Email.Error.Unique");
        }
        if(!(userForm.getPassword().equals(userForm.getConfirmPassword()))) {
            errors.rejectValue("password", "Password.Error");
        }
        if(errors.hasErrors()) {
            return "integrated:signUp";
        }

        user = new User(userForm, encoder.encode(userForm.getPassword()));
        userService.saveUser(user);

        return "redirect:login";
    }
}
