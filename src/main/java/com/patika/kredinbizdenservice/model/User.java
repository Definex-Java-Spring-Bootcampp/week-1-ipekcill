package com.patika.kredinbizdenservice.model;

import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isActive;


    public User(String name, String surname, String email, String password, String phoneNumber, boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = hashPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
