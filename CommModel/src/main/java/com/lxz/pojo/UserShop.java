package com.lxz.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserShop implements Serializable {
    private int shop_sid;
    private int user_uid;
    private String shop_name;
    private String shop_state;
    private String shop_jianjie;
    private Timestamp shop_time;
    public UserShop() {
    }

    public int getShop_sid() {
        return shop_sid;
    }

    public void setShop_sid(int shop_sid) {
        this.shop_sid = shop_sid;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_state() {
        return shop_state;
    }

    public void setShop_state(String shop_state) {
        this.shop_state = shop_state;
    }

    public String getShop_jianjie() {
        return shop_jianjie;
    }

    public void setShop_jianjie(String shop_jianjie) {
        this.shop_jianjie = shop_jianjie;
    }

    public Timestamp getShop_time() {
        return shop_time;
    }

    public void setShop_time(Timestamp shop_time) {
        this.shop_time = shop_time;
    }

    @Override
    public String toString() {
        return "UserShop{" +
                "shop_sid=" + shop_sid +
                ", user_uid=" + user_uid +
                ", shop_name='" + shop_name + '\'' +
                ", shop_state='" + shop_state + '\'' +
                ", shop_jianjie='" + shop_jianjie + '\'' +
                ", shop_time=" + shop_time +
                '}';
    }
}
