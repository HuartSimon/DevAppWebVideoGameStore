package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/changePassword")
@SessionAttributes({Constants.CURRENT_USER})
public class ChangePasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String editForm() {
        return "integrated:changePassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute(Constants.CURRENT_USER) User user, Model model,
                             @RequestParam("oldPassword") String oldPassword,
                             @RequestParam("newPassword") String newPassword,
                             @RequestParam("confirmedNewPassword") String confirmedNewPassword) {

        if(!(passwordEncoder.matches(oldPassword, user.getPassword()))) {
            model.addAttribute("oldPasswordError", true);
            return "integrated:changePassword";
        }
        if (!newPassword.equals(confirmedNewPassword)) {
            model.addAttribute("confirmedNewPasswordError", true);
            return "integrated:changePassword";
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userService.saveUser(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return "integrated:home";
    }
}
