package com.spring.henallux.springProject.configuration;

import com.spring.henallux.springProject.Constants;
import com.spring.henallux.springProject.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Used to add the user in the session (CURRENT_USER), because we can't do this in the POST method in the loginController (cause of spring security)
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        User authUser = (User) authentication.getPrincipal();
        request.getSession().setAttribute(Constants.CURRENT_USER, authUser);
        response.sendRedirect(request.getContextPath() + "/home");
    }
}
