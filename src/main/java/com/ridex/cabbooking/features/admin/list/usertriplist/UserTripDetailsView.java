package com.ridex.cabbooking.features.admin.list.usertriplist;

import com.ridex.cabbooking.data.dto.UserTripDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserTripDetailsView {

    private UserTripDetailsModel userDetailsModel;

    public UserTripDetailsView() throws SQLException, ClassNotFoundException {
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
            System.out.println(
                    "Trip Id : "+userTripDetails1.getTripId() +
                    "  Cab Id : "+userTripDetails1.getCabId() +
                    "  Pick Up : "+ userTripDetails1.getPickUp()+
                    "  Drop Up : "+userTripDetails1.getDropUp() +
                    "  Pick Up Time : "+ userTripDetails1.getPickupTiming()+
                    "  Drop Up Time : "+ userTripDetails1.getDropupTiming()+
                            "  Pick Up Date : "+ userTripDetails1.getPickUpDate()+
                            "  Drop Up Date : "+ userTripDetails1.getDropUpDate()+
                    "  User Travel Status : "+userTripDetails1.getStatus()+
                    "  Payment : "+userTripDetails1.getPayment());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    void showFailedUserDetails(String message){
        System.out.println(message);
    }
}
