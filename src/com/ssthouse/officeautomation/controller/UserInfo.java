package com.ssthouse.officeautomation.controller;

/**
 * Created by ssthouse on 26/01/2017.
 */
public class UserInfo {

    private String username;

    private String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserInfo(String username, String age) {
        this.username = username;
        this.age = age;
    }
}
