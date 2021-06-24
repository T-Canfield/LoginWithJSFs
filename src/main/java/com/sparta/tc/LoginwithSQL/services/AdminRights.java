//package com.sparta.tc.LoginwithSQL.services;
//
//import entities.UsersEntity;
//
//public class AdminRights{
//
//    void deleteUser(UsersEntity user){
//        DAO dao = new DAO();
//        if(!user.isAdmin(user)){
//            dao.deleteEntry(user);
//            System.out.printf("User %s successfully deleted\n", user.getUsername());
//        } else {
//            System.out.println("Sorry, this user is an admin. This user must be demoted in order to be deleted.");
//        }
//    }
//
//    void changeRole(UsersEntity user){
//        if(user.getRole().equals("admin")){
//            user.setRole("user");
//        } else {
//            user.setRole("admin");
//        }
//        System.out.printf("%s's role: %s", user.getUsername(), user.getRole());
//    }
//
//
//}
