package com.spring.henallux.springProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    @Size(min = 1, max = 50)
    private String username;
    @Size(min = 1, max = 50)
    private String firstName;
    @Size(min = 1, max = 50)
    private String lastName;
    @NotEmpty
    @Size(max = 50)
    @Email
    private String email;
    @Size(max = 100)
    @NotEmpty
    private String address;
    @NotEmpty
    private String password;
    @NotEmpty
    @Size(max = 15)
    @Pattern(regexp = "^\\+?[0-9 ]{1,15}$",
            message = "! Invalid phone number format. The phone number must start with an optional '+' for international numbers, contain only digits and spaces, and be between 1 and 15 characters long.")
    private String phoneNumber;
    private Boolean isMan;
    @Size(max = 200)
    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;


    public User() {}
    public User(String username, String firstName, String lastName, String email, String address, String password, String phoneNumber, Boolean isMan, String authorities, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddress(address);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setIsMan(isMan);
        setAuthorities(authorities);
        setAccountNonExpired(accountNonExpired);
        setAccountNonLocked(accountNonLocked);
        setCredentialsNonExpired(credentialsNonExpired);
        setEnabled(enabled);
    }
    public User(String username, String firstName, String lastName, String email, String address, String password, String phoneNumber, Boolean isMan) {
        this(username, firstName, lastName, email, address, password, phoneNumber, isMan, "ROLE_USER", true, true, true, true);
    }


        @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }


    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    // x != null ? x : false (Car on implemente UserDetails qui a des méthodes boolean (type primitif qui ne peut être null)
    // Donc si null -> renvoyer false
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired != null ? accountNonExpired : false;
    }
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked != null ? accountNonLocked : false;
    }
    @Override
    public boolean isCredentialsNonExpired() {return credentialsNonExpired != null ? credentialsNonExpired : false;}
    @Override
    public boolean isEnabled() {
        return enabled != null ? enabled : false;
    }


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Boolean getIsMan() {
        return isMan;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setIsMan(Boolean man) {
        isMan = man;
    }
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void update(EditUserForm editUserForm){
        setFirstName(editUserForm.getFirstName());
        setLastName(editUserForm.getLastName());
        setAddress(editUserForm.getAddress());
        setPhoneNumber(editUserForm.getPhoneNumber());
        setIsMan(editUserForm.getIsMan());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isMan=" + isMan +
                ", authorities='" + authorities + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}
