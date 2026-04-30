package com.zsgs.cabbooking.features.admin.list.usertriplist;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.data.dto.TripStatus;
import com.zsgs.cabbooking.data.dto.UserTripDetails;

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

        System.out.printf("%-10s %-15s %-10s %-20s %-12s %-8s %-8s %-10s %-10s %-12s %-12s %-12s%n",
                "User ID", "Name", "Role", "Email", "Mobile",
                "TripID", "CabID", "Pickup", "Drop",
                "Pick Time", "Drop Time", "Status");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        for (UserTripDetails userTripDetails1 : userTripDetails) {
            System.out.printf("%-10d %-15s %-10s %-20s %-12s %-8d %-8d %-10s %-10s %-12s %-12s %-12s%n",
                    userTripDetails1.getAccountDetails().getId(),
                    userTripDetails1.getAccountDetails().getName(),
                    userTripDetails1.getAccountDetails().getRole(),
                    userTripDetails1.getAccountDetails().getEmail(),
                    userTripDetails1.getAccountDetails().getMobileNumber(),
                    userTripDetails1.getTripId(),
                    userTripDetails1.getCabId(),
                    userTripDetails1.getPickUp(),
                    userTripDetails1.getDropUp(),
                    userTripDetails1.getPickupTiming(),
                    userTripDetails1.getDropupTiming(),
                    userTripDetails1.getStatus());
        }
    }
}
