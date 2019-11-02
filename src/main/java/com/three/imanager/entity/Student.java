package com.three.imanager.entity;

import java.util.Date;

public class Student {

    private int uid;

    private int stuid;

    private String sname;

    private Date birth;

    private String sex;

    private String cel;

    private String address;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", stuid=" + stuid +
                ", sname='" + sname + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", cel='" + cel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
