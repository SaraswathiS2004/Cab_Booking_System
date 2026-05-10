package com.ridex.cabbooking.features.admin.list.usertriplist;

import com.ridex.cabbooking.data.dto.UserTripDetails;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class UserTripDetailsModel {

    private UserTripDetailsView userDetailsView;
    private RideXDB rideXDB;

    public UserTripDetailsModel(UserTripDetailsView userDetailsView) throws SQLException, ClassNotFoundException {
        this.userDetailsView = userDetailsView;
        this.rideXDB = new RideXDB();
    }

    public void getUsers() {

        ArrayList<UserTripDetails> userTripDetails = rideXDB.getUserTripList();
        if (userTripDetails.isEmpty()) {
            userDetailsView.showFailedUserDetails("No trips found");
        } else {
            userDetailsView.showUserTripDetails(userTripDetails);
        }
    }
}
