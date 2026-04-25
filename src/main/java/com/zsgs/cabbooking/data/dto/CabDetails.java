package com.zsgs.cabbooking.data.dto;

public class CabDetails {
    private long registrationNumber;
    private long cabId;
    private String model;
    private String type;

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public long getCabId() {
        return cabId;
    }

    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
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

    public void setValues(long cabId  , long registrationNumber , String model , String type){
        setCabId(cabId);
        setRegistrationNumber(registrationNumber);
        setModel(model);
        setType(type);
    }
}
