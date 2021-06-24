package com.sparta.tc.LoginwithSQL.repositories;




import com.sparta.tc.LoginwithSQL.services.DAO;
import entities.UsersEntity;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<UsersEntity> users = new ArrayList<>();

    static {
        UsersEntity user1 = new UsersEntity(1, "Tom", "pword", "admin");
        UsersEntity user2 = new UsersEntity(2, "Karim", "password", "admin");
        UsersEntity user3 = new UsersEntity(3, "Alex", "p", "user");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<UsersEntity> getUsers() {
        return users;
    }

    public void addUser(UsersEntity user){
        users.add(user);
    }

    public void removeUser(UsersEntity user) {
        for(UsersEntity eachUser: users){
            if(eachUser.getUserId() == user.getUserId()){
                users.remove(eachUser);
                break;
            }
        }
    }
}
