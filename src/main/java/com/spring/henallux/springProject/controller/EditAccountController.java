package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.dataAccess.repository.UserRepository;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/editAccount")
@SessionAttributes({Constants.CURRENT_USER})
public class EditAccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String editForm(@ModelAttribute(Constants.CURRENT_USER) User user) {
        return "integrated:editAccount";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitEdit(Model model, @Valid @ModelAttribute(Constants.CURRENT_USER) User user, final BindingResult errors) {
        if (errors.hasErrors()) {
            ArrayList<String> validationErrors = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                validationErrors.add(error.getField() + ": " + error.getDefaultMessage());
            }

            model.addAttribute("validationErrors", validationErrors);
            return "integrated:editAccount";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        userService.saveUser(user);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return "redirect:home";
    }
}
