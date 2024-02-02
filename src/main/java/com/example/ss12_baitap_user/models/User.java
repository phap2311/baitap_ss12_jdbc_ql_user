package com.example.ss12_baitap_user.models;

public class User {
private  Integer id;
private  String  nameUser;
private  String emailUser;
private  String countryUser;

    public User() {
    }

    public User(Integer id, String nameUser, String emailUser, String countryUser) {
        this.id = id;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.countryUser = countryUser;
    }

    public User(String nameUser, String emailUser, String countryUser) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.countryUser = countryUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getCountryUser() {
        return countryUser;
    }

    public void setCountryUser(String countryUser) {
        this.countryUser = countryUser;
    }
}
