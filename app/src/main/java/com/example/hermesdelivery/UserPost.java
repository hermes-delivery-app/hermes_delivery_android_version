package com.example.hermesdelivery;

import java.util.ArrayList;

public class UserPost {

    public UserPost(String user_name, String phoneNumber, String password, ArrayList<com.example.hermesdelivery.UserPostInner> userPostInner) {
        this.user_name = user_name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        UserPostInner = userPostInner;
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

    public ArrayList<com.example.hermesdelivery.UserPostInner> getUserPostInner() {
        return UserPostInner;
    }

    public void setUserPostInner(ArrayList<com.example.hermesdelivery.UserPostInner> userPostInner) {
        UserPostInner = userPostInner;
    }

    String user_name;
    String phoneNumber;
    String password;
    ArrayList<UserPostInner> UserPostInner;
}
