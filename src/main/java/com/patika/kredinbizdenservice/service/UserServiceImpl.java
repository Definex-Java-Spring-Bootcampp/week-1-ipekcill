package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        if(userList.stream()
                .noneMatch(user1 -> user1.getEmail().equals(user.getEmail()))) {
            userList.add(user);
            System.out.println("User added: " + user.toString());
        } else {
            System.out.println("Mail address is already in use!");
        }
    }
}
