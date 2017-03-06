package com.ssthouse.officeautomation.entity;

/**
 * Created by ssthouse on 01/02/2017.
 */
public class UserIno {

    private String username;
    private int age;

    public UserIno(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
