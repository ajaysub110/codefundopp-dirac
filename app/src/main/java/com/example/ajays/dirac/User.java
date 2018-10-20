package com.example.ajays.dirac;

public class User {
    public String password;
    public String region;
    public Integer auth;

    public User(String password, String region, Integer auth) {
        this.password = password;
        this.region = region;
        this.auth = auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
