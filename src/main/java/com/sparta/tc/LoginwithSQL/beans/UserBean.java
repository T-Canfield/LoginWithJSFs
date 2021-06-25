package com.sparta.tc.LoginwithSQL.beans;



import com.sparta.tc.LoginwithSQL.repositories.UserRepository;
import com.sparta.tc.LoginwithSQL.services.LoginChecker;
import entities.UsersEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserBean {

    @Inject
    private UsersEntity user;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String addUser(){
        String userRole = LoginChecker.isValidUser(user);
        if (userRole.equals("admin")){
            return "welcomeAdmin";
        } else if (userRole.equals("user")){
            return "welcomeUser";
        } else {
            return "LoginFailed";
        }
    }

    public String deleteUser(){
        UserRepository repository = new UserRepository();
        List<UsersEntity> users = repository.getUsers();
        UsersEntity userToRemove = null;
        for(UsersEntity user : users) {
            if (user.getUsername().equals(this.user.getUsername())) {
                userToRemove = user;
            }
        }
        repository.removeUser(users.get(userToRemove.getUserId()-1));

        return "welcomeAdminAfterDeletion";

//        for(UsersEntity eachUser: users){
//            if(eachUser.getUserId() == user.getUserId()){
//                users.remove(eachUser);
//                break;
//            }
//        }
        //System.out.println("Successfully removed");
        //return "welcomeAdmin";
    }

    public String goHome(){

        return "index";
    }
}
