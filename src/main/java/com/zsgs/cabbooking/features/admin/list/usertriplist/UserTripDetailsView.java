package com.zsgs.cabbooking.features.admin.list.usertriplist;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.data.dto.TripStatus;
import com.zsgs.cabbooking.data.dto.UserTripDetails;

import java.util.ArrayList;

public class UserTripDetailsView {

    private UserTripDetailsModel userDetailsModel;
    public UserTripDetailsView(){

        this.userDetailsModel = new UserTripDetailsModel(this);

    }
    public void init(){
        System.out.println("Welcome to RideX");
        userDetailsModel.getUsers();
    }
    public void showUserTripDetails(ArrayList<UserTripDetails> userTripDetails){
        System.out.println("User Trip Details");

        for(UserTripDetails userTripDetails1 : userTripDetails){
            System.out.println("Name : "+ userTripDetails1.getAccountDetails().getName() +
            " Password : "+ userTripDetails1.getAccountDetails().getPassword() + "Email Address : "+ userTripDetails1.getAccountDetails().getEmail()
            +" Role : "+ userTripDetails1.getAccountDetails().getRole() + " Mobile Number : "+ userTripDetails1.getAccountDetails().getMobileNumber() +
                    " User Id : "+ userTripDetails1.getAccountDetails().getId()+" User Trip Id : "+
                    userTripDetails1.getTripId()+" User Pick Up place : "+
                    userTripDetails1.getPickUp() +" User Drop Up place : "+
                    userTripDetails1.getDropUp() +" Cab Id "+ userTripDetails1.getCabId() +
                    " User Pick Up Timing : "+ userTripDetails1.getPickupTiming()+
                    "User Drop Up Timing : "+ userTripDetails1.getDropupTiming()+
                    " User Trip Status : "+ userTripDetails1.getStatus());

        }

    }

}
