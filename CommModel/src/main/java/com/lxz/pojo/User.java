package com.lxz.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int user_uid;
    private String user_phone;
    private String user_pass;
    private String user_salt;
    private int user_flag;

    public User() {
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_salt() {
        return user_salt;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }

    public int getUser_flag() {
        return user_flag;
    }

    public void setUser_flag(int user_flag) {
        this.user_flag = user_flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_uid=" + user_uid +
                ", user_phone=" + user_phone +
                ", user_pass='" + user_pass + '\'' +
                ", user_salt='" + user_salt + '\'' +
                ", user_flag=" + user_flag +
                '}';
    }
}
