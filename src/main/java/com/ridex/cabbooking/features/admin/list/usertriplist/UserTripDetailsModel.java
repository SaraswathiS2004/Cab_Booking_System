package com.ridex.cabbooking.features.admin.list.usertriplist;

import com.ridex.cabbooking.data.dto.UserTripDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class UserTripDetailsModel {

    private UserTripDetailsView userDetailsView;
    private CabDB cabDB;
    public UserTripDetailsModel(UserTripDetailsView userDetailsView){
        this.userDetailsView = userDetailsView;
        this.cabDB = CabDB.getInstance();
    }

    public void getUsers(){
        ArrayList<UserTripDetails> userTripDetails = cabDB.getUserTripDetails();
        if(userTripDetails.isEmpty()) {
            userDetailsView.showFailedUserDetails("No trips found");
        }
        else{
            userDetailsView.showUserTripDetails(userTripDetails);
        }
    }
}
