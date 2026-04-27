package com.zsgs.cabbooking.data.dto;

import com.zsgs.cabbooking.data.repository.CabDB;

public class UserTripDetails {
    private long tripId;
    private String pickUp;
    private String dropUp;
    private long cabId;
    private int pickupTiming;
    private TripStatus status;
    private AccountDetails accountDetails;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public String getPickUp() {
        return pickUp;
    }

    public long getCabId() {
        return cabId;
    }

    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDropUp() {
        return dropUp;
    }

    public void setDropUp(String dropUp) {
        this.dropUp = dropUp;
    }

    public int getPickupTiming() {
        return pickupTiming;
    }

    public void setPickupTiming(int pickupTiming) {
        this.pickupTiming = pickupTiming;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }
}
