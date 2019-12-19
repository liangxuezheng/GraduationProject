package com.lxz.pojo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private int info_id;
    private int user_uid;
    private String info_nc;
    private String info_name;
    private String info_idcard;
    private String info_sex;
    private String info_school;
    private String info_qq;
    private String info_email;
    private String info_grade;
    private int info_balance;
    private String info_touxiang;
    private String email_code;
    private String email_state;
    private String idcard_state;
    private String user_phone;
    public UserInfo() {
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getIdcard_state() {
        return idcard_state;
    }

    public void setIdcard_state(String idcard_state) {
        this.idcard_state = idcard_state;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public String getInfo_nc() {
        return info_nc;
    }

    public void setInfo_nc(String info_nc) {
        this.info_nc = info_nc;
    }

    public String getInfo_name() {
        return info_name;
    }

    public void setInfo_name(String info_name) {
        this.info_name = info_name;
    }

    public String getInfo_idcard() {
        return info_idcard;
    }

    public void setInfo_idcard(String info_idcard) {
        this.info_idcard = info_idcard;
    }

    public String getInfo_sex() {
        return info_sex;
    }

    public void setInfo_sex(String info_sex) {
        this.info_sex = info_sex;
    }

    public String getInfo_school() {
        return info_school;
    }

    public void setInfo_school(String info_school) {
        this.info_school = info_school;
    }

    public String getInfo_qq() {
        return info_qq;
    }

    public void setInfo_qq(String info_qq) {
        this.info_qq = info_qq;
    }

    public String getInfo_email() {
        return info_email;
    }

    public void setInfo_email(String info_email) {
        this.info_email = info_email;
    }

    public String getInfo_grade() {
        return info_grade;
    }

    public void setInfo_grade(String info_grade) {
        this.info_grade = info_grade;
    }

    public int getInfo_balance() {
        return info_balance;
    }

    public void setInfo_balance(int info_balance) {
        this.info_balance = info_balance;
    }

    public String getInfo_touxiang() {
        return info_touxiang;
    }

    public void setInfo_touxiang(String info_touxiang) {
        this.info_touxiang = info_touxiang;
    }

    public String getEmail_code() {
        return email_code;
    }

    public void setEmail_code(String email_code) {
        this.email_code = email_code;
    }

    public String getEmail_state() {
        return email_state;
    }

    public void setEmail_state(String email_state) {
        this.email_state = email_state;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "info_id=" + info_id +
                ", user_uid=" + user_uid +
                ", info_nc='" + info_nc + '\'' +
                ", info_name='" + info_name + '\'' +
                ", info_idcard='" + info_idcard + '\'' +
                ", info_sex='" + info_sex + '\'' +
                ", info_school='" + info_school + '\'' +
                ", info_qq='" + info_qq + '\'' +
                ", info_email='" + info_email + '\'' +
                ", info_grade='" + info_grade + '\'' +
                ", info_balance=" + info_balance +
                ", info_touxiang='" + info_touxiang + '\'' +
                ", email_code='" + email_code + '\'' +
                ", email_state='" + email_state + '\'' +
                ", idcard_state='" + idcard_state + '\'' +
                ", user_phone='" + user_phone + '\'' +
                '}';
    }
}
