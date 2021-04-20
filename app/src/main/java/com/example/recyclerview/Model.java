package com.example.recyclerview;

public class Model {

String username, password;

    public Model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Model() {
        //default constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
