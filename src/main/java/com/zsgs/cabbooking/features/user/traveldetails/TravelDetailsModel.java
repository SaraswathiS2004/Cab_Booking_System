package com.zsgs.cabbooking.features.user.traveldetails;

import com.zsgs.cabbooking.data.dto.*;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TravelDetailsModel {

    private TravelDetailsView travelDetailsView;
    private CabDB cabDB;
    private UserTripDetails userTripDetails;
    private ArrayList<String> places = new ArrayList<String>(Arrays.asList("A" , "B" , "C" , "D" , "E" , "F"));
    public TravelDetailsModel(TravelDetailsView travelDetailsView){
        this.travelDetailsView = travelDetailsView;
        this.cabDB = CabDB.getInstance();
        this.userTripDetails = new UserTripDetails();
    }

    LocalTime getDropTiming(String pickUpPlace  , String dropUpPlace){

        int index1 = places.indexOf(pickUpPlace);
        int index2 = places.indexOf(dropUpPlace);
        int value = Math.abs(index2 - index1) * 10;
        LocalTime now = LocalTime.now();
        LocalTime dropTime = now.plusMinutes(value);
        return dropTime;

    }
    void storeData(String pickUp , String dropUp , LocalTime pickupTiming , LocalTime dropupTiming , long cabId , TripStatus tripStatus , AccountDetails currentUser , int payment){
        int money = calculateMoney(pickUp , dropUp);
        userTripDetails.setPickUp(pickUp);
        userTripDetails.setDropUp(dropUp);
        userTripDetails.setPickupTiming(pickupTiming);
        userTripDetails.setDropupTiming(dropupTiming);
        userTripDetails.setCabId(cabId);
        userTripDetails.setStatus(tripStatus);
        userTripDetails.setAccountDetails(currentUser);
        userTripDetails.setTripId(cabDB.getCabId());
        userTripDetails.setPayment(payment + money);
        cabDB.addTripDetails(userTripDetails);
        travelDetailsView.onDetailsUploadedSuccessful();

    }
    void setCabEarnings(long cabId ,int earnings){
        cabDB.setCabEarnings(cabId ,earnings);
    }

    int calculateMoney(String pick , String drop){
        int index = Math.abs(places.indexOf(pick) - places.indexOf(drop));
        int money = 100;
        int km = ((index) * 15) - 5;
        int totalMoney = (km * 10) + money;
        return totalMoney;

    }
    String validatePickUpPlace(String place){

        if(place == null || place.trim().isEmpty() || place.length() > 1 || !places.contains(place)){
            return "Enter the Valid Place";
        }
        else {
            return null;
        }
    }
    long getCabs(ArrayList<CabDetails> cabDetails , String pickUp){
        int minPosition = Integer.MAX_VALUE;
        CabDetails cab = null;
        ArrayList<CabCurrentPosition> cabCurrentPositions = cabDB.getCabsPosition();
        for(CabDetails cabDetails1 : cabDetails){
            long id = cabDetails1.getCabId();
            for(CabCurrentPosition cabCurrentPosition : cabCurrentPositions){
                if(cabCurrentPosition.getCabId() == id){
                    String position = cabCurrentPosition.getPosition();
                    int index1 = position.indexOf(position);
                    int index2 = position.indexOf(pickUp);
                    if(minPosition > Math.abs(index1 - index2)) {
                        minPosition = Math.min(Math.abs(index1 - index2), minPosition);
                        cab = cabDetails1;
                    }
                }
            }
        }
        return cab != null ? cab.getCabId() : null;
    }

    String validateDropUpPlace(String pickUp , String dropUp){

        if(dropUp == null || dropUp.trim().isEmpty() || dropUp.length() > 1 || pickUp == dropUp || !places.contains(dropUp)){
            return "There is not a valid Place";
        }
        else {
            return null;
        }
    }
    ArrayList<CabDetails> getAvailableCabs(){
        ArrayList<CabDetails> cabDetails = cabDB.getCabDetails();

        return cabDetails;
    }
    String validateCabId(ArrayList<CabDetails> cabDetails , long cabId){
        for(CabDetails cabDetails1 : cabDetails){
            if(cabDetails1.getCabId() == cabId){
                return null;
            }
        }
        return "Invalid Cab Id";
    }
    String validateAmount(int money , int payment){
        if(money == payment) return null;
        return "Enter valid Amount";
    }
}
