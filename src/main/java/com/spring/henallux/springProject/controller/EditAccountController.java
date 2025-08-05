package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.EditUserForm;
import com.spring.henallux.springProject.model.User;
import com.spring.henallux.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/editAccount")
@SessionAttributes({Constants.CURRENT_USER})
public class EditAccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String editForm(@SessionAttribute(Constants.CURRENT_USER) User user, Model model) {
        model.addAttribute("userForm", new EditUserForm(user));
        return "integrated:editAccount";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitEdit(Model model, @SessionAttribute(Constants.CURRENT_USER) User user, @Valid @ModelAttribute(name = "userForm") EditUserForm editUserForm, final BindingResult errors) {
        if (errors.hasErrors()) {
            return "integrated:editAccount";
        }

        user.update(editUserForm);
        userService.saveUser(user);

        return "redirect:home";
    }
}
