package com.zsgs.cabbooking.data.dto;

public class UserTripDetails {
    private char pickUp;
    private char dropUp;
    private long pickupTiming;
    private String cabName;
    private float price;
    private TripStatus status;
    private int id;
    private Login user;

    public void setPick_up(char pickUp){
        this.pickUp = pickUp;
    }
    public char getPick_up(){
        return pickUp;
    }
    public void setDrop_up(char dropUp){
        this.dropUp = dropUp;
    }
    public char getDropUp(){
        return dropUp;
    }
    public void setPickupTiming(long pickupTiming){
        this.pickupTiming = pickupTiming;
    }
    public long getPickupTiming(){
        return pickupTiming;
    }
    public void setCabName(String cabName){
        this.cabName = cabName;
    }
    public String getCabName(){
        return cabName;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public void setTripStatus(TripStatus status){
        this.status = status;
    }
    public TripStatus getStatus(){
        return status;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setUser(Login user) {
        this.user = user;
    }
    public Login getUser(){
        return user;
    }

}
