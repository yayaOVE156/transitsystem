package com.example.transit_system;

public class UserS{
    private static final UserS instance = new UserS();

    private String username;
    public static UserS getInstance(){
        return instance;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }


}
