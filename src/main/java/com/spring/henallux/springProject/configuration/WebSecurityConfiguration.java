package com.spring.henallux.springProject.configuration;

import com.spring.henallux.springProject.dataAccess.util.CustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String LOGIN_REQUEST = "/login";
    public static final String[] AUTHORIZED_REQUESTS_ANYBODY = new String[]{
            "/home", "/signUp", "/company", "/products", "/product/**", "/cart/**", "/css/**", "/images/**"
    };
    public static final String[] AUTHORIZED_REQUESTS_ADMIN = new String[]{"/admin"};

    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsServiceImplementation) {
        this.userDetailsServiceImpl = userDetailsServiceImplementation;
    }

    /**
     * We do the configuration of spring security here.
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/home"); // Set the default page to redirect to /home if there is no last request

        http.csrf().disable(); // Disable because not necessary

        http
            .authorizeRequests() // We define the authorization here
            .antMatchers(AUTHORIZED_REQUESTS_ADMIN).hasRole("ADMIN") // For the request to "/admin", the user needs to be an admin
            .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll() // For the request to the index page, any user has access
            .anyRequest().authenticated() // For all the other requests, the user needs to be authenticated

            .and()
                .formLogin() // We define the login part here.
                    .successHandler(successHandler) // provided by spring to redirect to the last request or the default redirect
                    .loginPage(LOGIN_REQUEST) // We specify a login page. Otherwise spring creates one by default
                    .successHandler(new CustomLoginSuccessHandler()) // To add authenticatedUser (made by spring security) to CURRENT_USER
                    .failureUrl(LOGIN_REQUEST + "?error=true") // to display an error in case of failure
            .permitAll() // To make the login page the available for any user

            .and()
            .logout() // We define the logout part here - By default : URL = "/logout"
            //.logoutUrl("...") // If other link than "/logout" (that is by default)
            .logoutSuccessUrl("/home")  // URL to return if logout is successfull
            .permitAll(); // To make the logout available for any user
    }




    /**
     * We provide the service which will return the user and the password encoder
     * The service which is created here need to implement an interface provided by spring security.
     * See @UserDetailsServiceImpl
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Disable the protection to the CRFS.
        // Otherwise, we need to implement it and it is not necessary for our concerns

        http
                .authorizeRequests() // We define the authorization here
                .antMatchers(AUTHORIZED_REQUESTS_ADMIN).hasRole("ADMIN") // For the request to "/admin", the user needs to be an admin
                .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll() // For the request to the index page, any user has access
                .anyRequest().authenticated() // For all the other requests, the user needs to be authenticated

                .and()
                .formLogin() // We define the login part here.
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler()) // This handler is already provided by spring to redirect to the last request
                .loginPage(LOGIN_REQUEST) // We specify a login page. Otherwise spring create one by default
                .permitAll() // To make the login page the available for any user

                .and()
                .logout() // We define the logout part here
                .permitAll(); // To make the logout the available for any user
    }*/

}