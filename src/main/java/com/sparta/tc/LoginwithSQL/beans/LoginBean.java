package com.sparta.tc.LoginwithSQL.beans;

import com.sparta.tc.LoginwithSQL.repositories.CurrentUser;
import com.sparta.tc.LoginwithSQL.services.LoginChecker;
import entities.UsersEntity;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class LoginBean {
    @Inject
    private UsersEntity user;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String login(){
        String userRole = LoginChecker.isValidUser(user);
        CurrentUser.setCurrentUser(user.getUsername());
        if (userRole.equals("admin")){
            return "welcomeAdmin";
        } else if (userRole.equals("user")){
            return "welcomeUser";
        } else {
            return "LoginFailed";
        }
    }
    public String logout(){
        return "index";
    }
}
