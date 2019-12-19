package com.lxz.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Goods implements Serializable {
    private int good_gid;
    private int shop_sid;
    private String good_name;
    private String good_info;
    private String good_liebei;
    private Timestamp good_time;
    private double good_price;
    private double good_hdprice;
    private String good_manner;
    private String good_ynact;
    private String good_p1;
    private String good_p2;
    private String good_p3;
    private String good_p4;

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "good_gid=" + good_gid +
                ", shop_sid=" + shop_sid +
                ", good_name='" + good_name + '\'' +
                ", good_info='" + good_info + '\'' +
                ", good_liebei='" + good_liebei + '\'' +
                ", good_time=" + good_time +
                ", good_price=" + good_price +
                ", good_hdprice=" + good_hdprice +
                ", good_manner='" + good_manner + '\'' +
                ", good_ynact='" + good_ynact + '\'' +
                ", good_p1='" + good_p1 + '\'' +
                ", good_p2='" + good_p2 + '\'' +
                ", good_p3='" + good_p3 + '\'' +
                ", good_p4='" + good_p4 + '\'' +
                '}';
    }

    public int getGood_gid() {
        return good_gid;
    }

    public void setGood_gid(int good_gid) {
        this.good_gid = good_gid;
    }

    public int getShop_sid() {
        return shop_sid;
    }

    public void setShop_sid(int shop_sid) {
        this.shop_sid = shop_sid;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getGood_info() {
        return good_info;
    }

    public void setGood_info(String good_info) {
        this.good_info = good_info;
    }

    public String getGood_liebei() {
        return good_liebei;
    }

    public void setGood_liebei(String good_liebei) {
        this.good_liebei = good_liebei;
    }

    public Timestamp getGood_time() {
        return good_time;
    }

    public void setGood_time(Timestamp good_time) {
        this.good_time = good_time;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public double getGood_hdprice() {
        return good_hdprice;
    }

    public void setGood_hdprice(double good_hdprice) {
        this.good_hdprice = good_hdprice;
    }

    public String getGood_manner() {
        return good_manner;
    }

    public void setGood_manner(String good_manner) {
        this.good_manner = good_manner;
    }

    public String getGood_ynact() {
        return good_ynact;
    }

    public void setGood_ynact(String good_ynact) {
        this.good_ynact = good_ynact;
    }

    public String getGood_p1() {
        return good_p1;
    }

    public void setGood_p1(String good_p1) {
        this.good_p1 = good_p1;
    }

    public String getGood_p2() {
        return good_p2;
    }

    public void setGood_p2(String good_p2) {
        this.good_p2 = good_p2;
    }

    public String getGood_p3() {
        return good_p3;
    }

    public void setGood_p3(String good_p3) {
        this.good_p3 = good_p3;
    }

    public String getGood_p4() {
        return good_p4;
    }

    public void setGood_p4(String good_p4) {
        this.good_p4 = good_p4;
    }
}
