package com.zsgs.cabbooking.data.dto;

public class AccountDetails {

    private String name;
    private String password;
    private Role role;

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return role;
    }

}
