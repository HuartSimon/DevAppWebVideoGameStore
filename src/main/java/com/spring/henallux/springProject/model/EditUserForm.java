package com.spring.henallux.springProject.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditUserForm {

    public EditUserForm(){

    }
    public EditUserForm(User user){
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setAddress(user.getAddress());
        setPhoneNumber(user.getPhoneNumber());
        setIsMan(user.getIsMan());
    }


    @Size(min = 1, max = 50)
    private String firstName;
    @Size(min = 1, max = 50)
    private String lastName;
    @Size(max = 100)
    @NotEmpty
    private String address;
    @Pattern(regexp = "^\\+?[0-9 ]{1,15}$")
    private String phoneNumber;
    private Boolean isMan;


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
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


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setIsMan(Boolean man) {
        isMan = man;
    }
}
