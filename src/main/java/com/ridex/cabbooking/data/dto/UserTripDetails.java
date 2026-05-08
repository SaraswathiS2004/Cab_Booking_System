package com.ridex.cabbooking.data.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class UserTripDetails {
    private long tripId;
    private String pickUp;
    private String dropUp;
    private long cabId;
    private LocalTime pickupTiming;
    private LocalTime dropupTiming;
    private LocalDate pickUpDate;
    private LocalDate dropUpDate;
    private TripStatus status;
    private int payment;
    private AccountDetails accountDetails;

    public LocalDate getDropUpDate() {
        return dropUpDate;
    }

    public void setDropUpDate(LocalDate dropUpDate) {
        this.dropUpDate = dropUpDate;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setPickupTiming(LocalTime pickupTiming) {
        this.pickupTiming = pickupTiming;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public LocalTime getDropupTiming() {
        return dropupTiming;
    }

    public void setDropupTiming(LocalTime dropupTiming) {
        this.dropupTiming = dropupTiming;
    }

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

    public LocalTime getPickupTiming() {
        return pickupTiming;
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
