package com.ridex.cabbooking.features.user.traveldetails;

import com.ridex.cabbooking.data.dto.*;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

class TravelDetailsModel {

    private TravelDetailsView travelDetailsView;
    //    private CabDB cabDB;
    private RideXDB rideXDB;
    private UserTripDetails userTripDetails;
    private ArrayList<String> places = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F"));

    public TravelDetailsModel(TravelDetailsView travelDetailsView) throws SQLException, ClassNotFoundException {
        this.travelDetailsView = travelDetailsView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
        this.userTripDetails = new UserTripDetails();
    }

    LocalDateTime getDropTiming(String pickUpPlace, String dropUpPlace) {

        int index1 = places.indexOf(pickUpPlace);
        int index2 = places.indexOf(dropUpPlace);
//        int value = Math.abs(index2 - index1) * 1;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dropTime = now.plusMinutes(1);
        return dropTime;

    }

    void storeData(String pickUp, String dropUp, LocalTime pickupTiming, LocalTime dropupTiming, LocalDate pickUpDate, LocalDate dropUpDate, long cabId, TripStatus tripStatus, AccountDetails currentUser, int payment, long userId) throws SQLException, ClassNotFoundException {
        userTripDetails.setPickUp(pickUp);
        userTripDetails.setDropUp(dropUp);
        userTripDetails.setPickupTiming(pickupTiming);
        userTripDetails.setDropupTiming(dropupTiming);
        userTripDetails.setCabId(cabId);
        userTripDetails.setStatus(tripStatus);
        userTripDetails.setAccountDetails(currentUser);
        userTripDetails.setPickUpDate(pickUpDate);
        userTripDetails.setDropUpDate(dropUpDate);
//      userTripDetails.setTripId(cabDB.getCabId());
        userTripDetails.setPayment(payment);
        rideXDB.setUpdateCabs(cabId, null, CabStatus.UN_AVAILABLE);
        rideXDB.storeUserTrips(userTripDetails);
//      cabDB.addTripDetails(userTripDetails , userId);
        travelDetailsView.onDetailsUploadedSuccessful();

    }

    void setCabEarnings(long cabId, int earnings) {
//        CabDB.getInstance().setCabEarnings(cabId ,earnings);

        rideXDB.setCabEarnings(cabId, earnings);
    }

    int calculateMoney(String pick, String drop) {
        int index = Math.abs(places.indexOf(pick) - places.indexOf(drop));
        int money = 100;
        int km = ((index) * 15) - 5;
        int totalMoney = (km * 10) + money;
        return totalMoney;

    }

    String validatePickUpPlace(String place) {

        if (place == null || place.trim().isEmpty() || place.length() > 1 || !places.contains(place)) {
            return "Enter the Valid Place";
        } else {
            return null;
        }
    }

    long getCabs(String pickUp) throws SQLException, ClassNotFoundException {
        int minPosition = Integer.MAX_VALUE;
        CabDetails cab = null;
        ArrayList<CabDetails> cabDetails = rideXDB.getAvailableCabs();
        ArrayList<CabCurrentPosition> cabCurrentPositions = new RideXDB().getCabPositionList();

        for (CabDetails cabDetails1 : cabDetails) {
            long id = cabDetails1.getCabId();
            for (CabCurrentPosition cabCurrentPosition : cabCurrentPositions) {
                if (cabCurrentPosition.getCabId() == id) {
                    String position = cabCurrentPosition.getPosition();
                    int index1 = places.indexOf(position);
                    int index2 = places.indexOf(pickUp);
                    if (minPosition > Math.abs(index1 - index2)) {
                        minPosition = Math.min(Math.abs(index1 - index2), minPosition);
                        cab = cabDetails1;
                    } else if (minPosition == Math.abs(index1 - index2)) {
                        if (cabDetails1.getTotalEarning() < cab.getTotalEarning()) {
                            cab = cabDetails1;
                        }
                    }
                }
            }
        }
        return cab != null ? cab.getCabId() : null;
    }

    String validateDropUpPlace(String pickUp, String dropUp) {

        if (dropUp == null || dropUp.trim().isEmpty() || dropUp.length() > 1 || pickUp == dropUp || !places.contains(dropUp)) {
            return "There is not a valid Place";
        } else {
            return null;
        }
    }

    ArrayList<CabDetails> getAvailableCabs() throws SQLException, ClassNotFoundException {
//        ArrayList<CabDetails> cabDetails = cabDB.getCabDetails();
        ArrayList<CabDetails> cabDetails = new RideXDB().getCabList();
        return cabDetails;
    }

    String validateCabId(ArrayList<CabDetails> cabDetails, long cabId) {
        for (CabDetails cabDetails1 : cabDetails) {
            if (cabDetails1.getCabId() == cabId) {
                return null;
            }
        }
        return "Invalid Cab Id";
    }

    String validateAmount(int money, int payment) {
        if (money == payment) return null;
        return "Enter valid Amount";
    }
}
