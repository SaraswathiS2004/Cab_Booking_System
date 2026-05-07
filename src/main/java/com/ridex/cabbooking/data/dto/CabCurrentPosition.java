package com.ridex.cabbooking.data.dto;

public class CabCurrentPosition {

    long cabId;
    String position;
    public long getCabId() {
        return cabId;
    }

    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
