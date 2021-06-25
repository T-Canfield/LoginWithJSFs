package com.sparta.tc.LoginwithSQL.repositories;

public class CurrentUser {
    private static String currentUser;

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String user) {
        currentUser = user;
    }
}
