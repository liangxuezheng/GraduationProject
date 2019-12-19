package com.lxz.pojo;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private int act_aid;
    private String act_name;
    private Date creat_time;
    private Date end_time;
    private String act_body;
    private double act_yhl;
    private int state;
    private Date start;
    private Date end;

    public Activity() {
    }

    @Override
    public String toString() {
        return "Activity{" +
                "act_aid=" + act_aid +
                ", act_name='" + act_name + '\'' +
                ", creat_time=" + creat_time +
                ", end_time=" + end_time +
                ", act_body='" + act_body + '\'' +
                ", act_yhl=" + act_yhl +
                ", state=" + state +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int getAct_aid() {
        return act_aid;
    }

    public void setAct_aid(int act_aid) {
        this.act_aid = act_aid;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getAct_body() {
        return act_body;
    }

    public void setAct_body(String act_body) {
        this.act_body = act_body;
    }

    public double getAct_yhl() {
        return act_yhl;
    }

    public void setAct_yhl(double act_yhl) {
        this.act_yhl = act_yhl;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
