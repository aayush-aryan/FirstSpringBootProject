package com.myfirstapp.model;
public class User {
    private static String firstName;
    private static String lastName;

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName;
    }
}