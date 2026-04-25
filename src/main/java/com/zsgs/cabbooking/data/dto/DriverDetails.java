package com.zsgs.cabbooking.data.dto;

public class DriverDetails {
    private long id;
    private String name;
    private String address;
    private int age;
    private int experience;
    private String mobileNumber;
    private CabDetails cabDetails;

    public void setDriverDetails(String name , long id , String address , int age , int experience , String mobileNumber ){
        setName(name);
        setId(id);
        setAddress(address);
        setAge(age);
        setExperience(experience);
        setMobileNumber(mobileNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setCabDetails(CabDetails cabDetails){
        this.cabDetails = cabDetails;
    }
    public CabDetails getCabDetails(){
        return cabDetails;
    }
}
