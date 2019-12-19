package com.lxz.pojo;

import java.io.Serializable;

public class ShipAddress implements Serializable {
    private int add_aid;
    private int user_uid;
    private String add_name;
    private String add_address;
    private String add_phone;
    private int add_flag;

    public ShipAddress() {
    }

    @Override
    public String toString() {
        return "ShipAddress{" +
                "add_aid=" + add_aid +
                ", user_uid=" + user_uid +
                ", add_name='" + add_name + '\'' +
                ", add_address='" + add_address + '\'' +
                ", add_phone='" + add_phone + '\'' +
                ", add_flag=" + add_flag +
                '}';
    }

    public String getAdd_address() {
        return add_address;
    }

    public void setAdd_address(String add_address) {
        this.add_address = add_address;
    }

    public int getAdd_aid() {
        return add_aid;
    }

    public void setAdd_aid(int add_aid) {
        this.add_aid = add_aid;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public String getAdd_name() {
        return add_name;
    }

    public void setAdd_name(String add_name) {
        this.add_name = add_name;
    }

    public String getAdd_phone() {
        return add_phone;
    }

    public void setAdd_phone(String add_phone) {
        this.add_phone = add_phone;
    }

    public int getAdd_flag() {
        return add_flag;
    }

    public void setAdd_flag(int add_flag) {
        this.add_flag = add_flag;
    }
}
