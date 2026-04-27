package com.zsgs.cabbooking.features.user.travelldetails;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.TripStatus;
import com.zsgs.cabbooking.data.dto.UserTripDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class TravelDetailsModel {

    private TravelDetailsView travelDetailsView;
    private CabDB cabDB;
    private UserTripDetails userTripDetails;
    private ArrayList<String> places = new ArrayList<String>(Arrays.asList("A" , "B" , "C" , "D" , "E"));

    public TravelDetailsModel(TravelDetailsView travelDetailsView){
        this.travelDetailsView = travelDetailsView;
        this.cabDB = CabDB.getInstance();
        this.userTripDetails = new UserTripDetails();
    }


    void storeData(String pickUp , String dropUp , int pickupTiming , long cabId , TripStatus tripStatus , AccountDetails currentUser){
        userTripDetails.setPickUp(pickUp);
        userTripDetails.setDropUp(dropUp);
        userTripDetails.setPickupTiming(pickupTiming);
        userTripDetails.setCabId(cabId);
        userTripDetails.setStatus(tripStatus);
        userTripDetails.setAccountDetails(currentUser);
        userTripDetails.setTripId(cabDB.getCabId());
        cabDB.addTripDetails(userTripDetails);
        travelDetailsView.onDetailsUploadedSuccessful();

    }
    String validatePickUpPlace(String place){

        if(place == null || place.trim().isEmpty() || place.length() > 1 || !places.contains(place)){
            return "Enter the Valid Place";
        }
        else {
            return null;
        }
    }

    String validateDropUpPlace(String pickUp , String dropUp){

        if(dropUp == null || dropUp.trim().isEmpty() || dropUp.length() > 1 || pickUp == dropUp || !places.contains(dropUp)){
            return "There is not a valid Place";
        }
        else {
            return null;
        }
    }
    String validatePickUpTiming(int pickUpTiming){
        if(pickUpTiming <= 0 ){
            return "There is not a valid time";
        }
        LocalTime now = LocalTime.now();
        int hoursAndMinutesNow = now.getHour() * now.getMinute();
        int value = hoursAndMinutesNow - pickUpTiming;
        if(value < 0){
            return "There is not a valid time";
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
    public void getTravelDetails(){
        travelDetailsView.showTravelDetails();
    }
}
