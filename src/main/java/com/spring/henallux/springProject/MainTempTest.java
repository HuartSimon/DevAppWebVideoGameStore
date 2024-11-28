package com.spring.henallux.springProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainTempTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("bidondonmaster");
        System.out.println(encodedPassword);
    }
}
