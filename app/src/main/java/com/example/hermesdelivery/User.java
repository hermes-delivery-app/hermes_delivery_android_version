package com.example.hermesdelivery;

public class User {
    public User(String user_name, String phoneNumber, String password) {
        this.user_name = user_name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String user_name;
    String phoneNumber;
    String password;
    boolean isArchive = false;
}
