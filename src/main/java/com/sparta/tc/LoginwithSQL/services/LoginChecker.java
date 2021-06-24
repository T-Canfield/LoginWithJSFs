package com.sparta.tc.LoginwithSQL.services;


import com.sparta.tc.LoginwithSQL.repositories.UserRepository;
import entities.UsersEntity;


import java.util.List;

public class LoginChecker {

    public static String isValidUser(UsersEntity user) {
        UserRepository userRepository = new UserRepository();
        List<UsersEntity> users = userRepository.getUsers();
        String userRole = "0";

        for (UsersEntity userToCheck:
             users) {
            if(userToCheck.getUsername().equals(user.getUsername()) && userToCheck.getPassword().equals(user.getPassword())){
                if(userToCheck.getRole().equals("admin")) {
                    userRole = "admin";
                } else {
                    userRole = "user";
                }
            }
        }
        return false;
    }

}
