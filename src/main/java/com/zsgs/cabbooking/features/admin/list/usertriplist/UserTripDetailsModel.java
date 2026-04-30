package com.zsgs.cabbooking.features.admin.list.usertriplist;

import com.zsgs.cabbooking.data.dto.UserTripDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

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
    }
}
