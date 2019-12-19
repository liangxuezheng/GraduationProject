package com.lxz.pojo;

import java.io.Serializable;

public class Shipping implements Serializable {
    private int sh_sid;
    private int user_uid;
    private int good_gid;
    private String good_name;
    private String good_jianjie;
    private String good_p1;
    private double good_price;
    public Shipping() {
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "sh_sid=" + sh_sid +
                ", user_uid=" + user_uid +
                ", good_gid=" + good_gid +
                ", good_name='" + good_name + '\'' +
                ", good_jianjie='" + good_jianjie + '\'' +
                ", good_p1='" + good_p1 + '\'' +
                ", good_price=" + good_price +
                '}';
    }

    public int getSh_sid() {
        return sh_sid;
    }

    public void setSh_sid(int sh_sid) {
        this.sh_sid = sh_sid;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public int getGood_gid() {
        return good_gid;
    }

    public void setGood_gid(int good_gid) {
        this.good_gid = good_gid;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getGood_jianjie() {
        return good_jianjie;
    }

    public void setGood_jianjie(String good_jianjie) {
        this.good_jianjie = good_jianjie;
    }

    public String getGood_p1() {
        return good_p1;
    }

    public void setGood_p1(String good_p1) {
        this.good_p1 = good_p1;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }
}
