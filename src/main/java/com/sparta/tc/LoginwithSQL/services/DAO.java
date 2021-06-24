package com.sparta.tc.LoginwithSQL.services;


import entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DAO {
    private static EntityManagerFactory setupFactory() {
        return Persistence.createEntityManagerFactory("default");
    }

    private static EntityManager setup(EntityManagerFactory factory){
        return factory.createEntityManager();
    }

    public void addNewUser(UsersEntity user){
        EntityManagerFactory factory = setupFactory();
        EntityManager manager = setup(factory);
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }

    public void deleteEntry(UsersEntity user){
        EntityManagerFactory factory = setupFactory();
        EntityManager manager = setup(factory);
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(user);
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }

    public static List<UsersEntity> retrieveUser(){
        EntityManagerFactory factory = setupFactory();
        EntityManager manager = setup(factory);
        return manager.createNativeQuery(("select * FROM users.users"), UsersEntity.class).getResultList();
    }
}
