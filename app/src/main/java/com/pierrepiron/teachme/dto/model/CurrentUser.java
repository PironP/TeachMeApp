package com.pierrepiron.teachme.dto.model;


public class CurrentUser {

    private int id;
    private String token;
    private Boolean isLoggedIn = false;

    private CurrentUser() {}

    private static CurrentUser INSTANCE = new CurrentUser();

    public static CurrentUser getInstance()
    {
        return INSTANCE;
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

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
