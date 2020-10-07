package com.example.bookmanager_hung.model;

public class NguoiDung {
    private String usename, pass, phone, fullname;

    public NguoiDung(String usename, String pass, String phone, String fullname) {
        this.usename = usename;
        this.pass = pass;
        this.phone = phone;
        this.fullname = fullname;
    }

    public NguoiDung() {
        this.usename = "no name";
        this.pass = "123456";
        this.phone = "123456";
        this.fullname = "no name";
    }

    public NguoiDung(String usename, String pass) {
        this.usename = usename;
        this.pass = pass;

    }

    public String getUserName() {
        return usename;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String toString() {
        return usename + phone;
    }
}
