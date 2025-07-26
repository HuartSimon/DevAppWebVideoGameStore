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
    @Pattern(regexp = "^\\+?[0-9 ]{1,15}$",
            message = "! Invalid phone number format. The phone number must start with an optional '+' for international numbers, contain only digits and spaces, and be between 1 and 15 characters long.")
    private String phoneNumber;
    private Boolean isMan;

    public @Size(min = 1, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(min = 1, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @Size(min = 1, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(min = 1, max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @Size(max = 100) @NotEmpty String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 100) @NotEmpty String address) {
        this.address = address;
    }

    public @Pattern(regexp = "^\\+?[0-9 ]{1,15}$",
            message = "! Invalid phone number format. The phone number must start with an optional '+' for international numbers, contain only digits and spaces, and be between 1 and 15 characters long.") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^\\+?[0-9 ]{1,15}$",
            message = "! Invalid phone number format. The phone number must start with an optional '+' for international numbers, contain only digits and spaces, and be between 1 and 15 characters long.") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIsMan(Boolean man) {
        isMan = man;
    }

    public Boolean getIsMan() {
        return isMan;
    }
}
