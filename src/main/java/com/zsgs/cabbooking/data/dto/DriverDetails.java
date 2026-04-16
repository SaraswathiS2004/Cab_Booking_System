package com.zsgs.cabbooking.data.dto;

public class DriverDetails {
    private int id;
    private String address;
    private int age;
    private int experience;
    private String phoneNumber;
    private CabDetails cabDetails;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setCabDetails(CabDetails cabDetails){
        this.cabDetails = cabDetails;
    }
    public CabDetails getCabDetails(){
        return cabDetails;
    }
}
