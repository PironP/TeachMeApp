package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;

public class EUser {
    @SerializedName("id_user") private int id_user;
    @SerializedName("firstname") private String firstname;
    @SerializedName("lastname") private String lastname;
    @SerializedName("email") private String email;
    @SerializedName("tel") private String tel;

    public EUser(int id_user, String firstname, String lastname, String email, String tel) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.tel = tel;
    }

    public EUser() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

