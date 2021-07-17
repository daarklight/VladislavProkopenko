package ru.training.at.hw7jdi.data;

import pages.hw7jdi.entities.User;

public class UserData {

    private static User DEFAULT_USER = new User().set(
        u -> {
            u.userName = "Roman";
            u.password = "Jdi1234";
        });

    public static User getDefaultUser() {
        return DEFAULT_USER;
    }

    public static void setDefaultUser(User defaultUser) {
        DEFAULT_USER = defaultUser;
    }
}
