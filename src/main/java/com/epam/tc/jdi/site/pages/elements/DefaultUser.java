package com.epam.tc.jdi.site.pages.elements;

public class DefaultUser {
    public static User ROMAN = new User().set(
        u -> {
            u.userName = "Roman";
            u.password = "Jdi1234";
        });
}
