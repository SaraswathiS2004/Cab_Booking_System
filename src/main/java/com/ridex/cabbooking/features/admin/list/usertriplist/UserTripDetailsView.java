package com.ridex.cabbooking.features.admin.list.usertriplist;

import com.ridex.cabbooking.data.dto.UserTripDetails;

import java.util.ArrayList;

public class UserTripDetailsView {

    private UserTripDetailsModel userDetailsModel;

    public UserTripDetailsView() {
        this.userDetailsModel = new UserTripDetailsModel(this);
    }
    public void init() {
        System.out.println("========== RIDEX ==========\n");
        System.out.println("User Trip Details\n");
        userDetailsModel.getUsers();
    }

    public void showUserTripDetails(ArrayList<UserTripDetails> userTripDetails) {
        System.out.println("========== USER TRIP DETAILS ==========\n");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (UserTripDetails userTripDetails1 : userTripDetails) {
            System.out.println("User Id : "+userTripDetails1.getAccountDetails().getId() +
                    "  Name : "+userTripDetails1.getAccountDetails().getName() +
                    "  Role : "+ userTripDetails1.getAccountDetails().getRole() +
                    "  Email : "+userTripDetails1.getAccountDetails().getEmail() +
                    "  Mobile Number : "+userTripDetails1.getAccountDetails().getMobileNumber() +
                    "  Trip Id : "+userTripDetails1.getTripId() +
                    "  Cab Id : "+userTripDetails1.getCabId() +
                    "  Pick Up : "+ userTripDetails1.getPickUp()+
                    "  Drop Up : "+userTripDetails1.getDropUp() +
                    "  Pick Up Time : "+ userTripDetails1.getPickupTiming()+
                    "  Drop Up Time : "+ userTripDetails1.getDropupTiming()+
                    "  User Travel Status : "+userTripDetails1.getStatus());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    void showFailedUserDetails(String message){
        System.out.println(message);
    }
}
