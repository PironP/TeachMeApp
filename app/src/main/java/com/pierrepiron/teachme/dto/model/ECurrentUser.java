package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;

public class ECurrentUser {

    @SerializedName("userID") private int id;
    @SerializedName("token") private String token;

    public ECurrentUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
