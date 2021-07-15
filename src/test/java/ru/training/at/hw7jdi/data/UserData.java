package ru.training.at.hw7jdi.data;

import pages.hw7jdi.entities.User;

public class UserData {
    public static User DEFAULT_USER = new User().set(
        u -> {
            u.userName = "Roman";
            u.password = "Jdi1234";
        });
}
