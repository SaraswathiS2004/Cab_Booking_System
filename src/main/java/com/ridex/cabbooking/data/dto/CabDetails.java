package com.ridex.cabbooking.data.dto;

public class CabDetails {
    private long driverId;
    private String cabRegistrationNumber;
    private long cabId;
    private String model;
    private String type;
    private int totalEarning = 0;

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public void setCabRegistrationNumber(String registrationNumber) {
        this.cabRegistrationNumber = registrationNumber;
    }

    public long getCabId() {
        return cabId;
    }

    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public String getCabRegistrationNumber() {
        return cabRegistrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValues(long driverId , long cabId  , String registrationNumber , String model , String type){
        setCabId(cabId);
        setCabRegistrationNumber(registrationNumber);
        setModel(model);
        setType(type);
        setDriverId(driverId);
    }
}
