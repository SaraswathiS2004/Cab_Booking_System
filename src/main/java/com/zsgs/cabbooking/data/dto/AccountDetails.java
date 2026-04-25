package com.zsgs.cabbooking.data.dto;

public class AccountDetails {

    private String name;
    private String password;
    private String email;
    private Role role;
    private String mobileNumber;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void registerPeople(String name , String password ,String email ,  String mobileNumber , String city , Role role , long id){
        setName(name);
        setPassword(password);
        setEmail(email);
        setCity(city);
        setMobileNumber(mobileNumber);
        setRole(role);
        setId(id);
    }

}
