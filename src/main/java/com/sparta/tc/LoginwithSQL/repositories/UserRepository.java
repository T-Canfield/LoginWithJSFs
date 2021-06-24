package com.sparta.tc.LoginwithSQL.repositories;




import com.sparta.tc.LoginwithSQL.services.DAO;
import entities.UsersEntity;

import java.util.List;

public class UserRepository {
    private List<UsersEntity> users;
    DAO dao = new DAO();
    public List<UsersEntity> getUsers() {
        users = dao.retrieveUser();
        System.out.println(users);
        return users;
    }

}
