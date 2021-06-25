package com.sparta.tc.LoginwithSQL.beans;

import com.sparta.tc.LoginwithSQL.repositories.UserRepository;
import entities.UsersEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Named
@RequestScoped
public class UserRepositoryBean {

    @Inject
    private UserRepository userRepo;

    @Inject
    private UsersEntity user;

    public List<UsersEntity> getUsers() {
        return userRepo.getUsers();
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void addUserRepo(UsersEntity user) {
        this.userRepo.addUser(user);
    }




    public String addUser(){
    addUserRepo(user);
    return "welcomeAdmin";
    }
}
