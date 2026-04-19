package com.zsgs.cabbooking.data.dto;

public class Login {
    private String name;
    private String password;


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

}
