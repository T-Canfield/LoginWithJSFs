package com.sparta.tc.LoginwithSQL.services;


import com.sparta.tc.LoginwithSQL.repositories.UserRepository;
import entities.UsersEntity;


import java.util.List;

public class LoginChecker {

    public static boolean isValidUser(UsersEntity user) {
        UserRepository userRepository = new UserRepository();
        List<UsersEntity> users = userRepository.getUsers();
        System.out.println(users);
        for (UsersEntity userToCheck:
             users) {
            if(userToCheck.equals(user)){
                System.out.println(userToCheck.getUsername());
                return true;
            }



        }
        return false;
    }
}
