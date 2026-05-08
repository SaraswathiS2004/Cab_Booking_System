package com.ridex.cabbooking.features.admin.list.usertriplist;

import com.ridex.cabbooking.data.dto.UserTripDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class UserTripDetailsModel {

    private UserTripDetailsView userDetailsView;
    private RideXDB rideXDB;
    public UserTripDetailsModel(UserTripDetailsView userDetailsView){
        this.userDetailsView = userDetailsView;
        this.rideXDB = RideXDB.getInstance();
    }

    public void getUsers(){
        ArrayList<UserTripDetails> userTripDetails = rideXDB.getUserTripDetails();
        if(userTripDetails.isEmpty()) {
            userDetailsView.showFailedUserDetails("No trips found");
        }
        else{
            userDetailsView.showUserTripDetails(userTripDetails);
        }
    }
}
