package com.lxz.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private int order_oid;
    private int user_uid;
    private int add_aid;
    private int  sh_sid;
    private int good_gid;
    private String good_name;
    private double order_allpri;
    private String order_state;
    private String order_rate;
    private String order_time;
    private String upda_time;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_oid=" + order_oid +
                ", user_uid=" + user_uid +
                ", add_aid=" + add_aid +
                ", sh_sid=" + sh_sid +
                ", good_gid=" + good_gid +
                ", good_name='" + good_name + '\'' +
                ", order_allpri=" + order_allpri +
                ", order_state='" + order_state + '\'' +
                ", order_rate='" + order_rate + '\'' +
                ", order_time='" + order_time + '\'' +
                ", upda_time='" + upda_time + '\'' +
                '}';
    }

    public int getOrder_oid() {
        return order_oid;
    }

    public void setOrder_oid(int order_oid) {
        this.order_oid = order_oid;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public int getAdd_aid() {
        return add_aid;
    }

    public void setAdd_aid(int add_aid) {
        this.add_aid = add_aid;
    }

    public int getSh_sid() {
        return sh_sid;
    }

    public void setSh_sid(int sh_sid) {
        this.sh_sid = sh_sid;
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

    public double getOrder_allpri() {
        return order_allpri;
    }

    public void setOrder_allpri(double order_allpri) {
        this.order_allpri = order_allpri;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getOrder_rate() {
        return order_rate;
    }

    public void setOrder_rate(String order_rate) {
        this.order_rate = order_rate;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getUpda_time() {
        return upda_time;
    }

    public void setUpda_time(String upda_time) {
        this.upda_time = upda_time;
    }
}
