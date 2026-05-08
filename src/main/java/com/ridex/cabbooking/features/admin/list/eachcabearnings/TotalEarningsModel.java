package com.ridex.cabbooking.features.admin.list.eachcabearnings;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class TotalEarningsModel {
    private TotalEarningsView totalEarningsView;
    private RideXDB rideXDB;
    public TotalEarningsModel(TotalEarningsView totalEarningsView){
        this.totalEarningsView = totalEarningsView;
        this.rideXDB = RideXDB.getInstance();
    }

    public void getEarnings(){
        ArrayList<CabDetails> cabDetails = rideXDB.getCabDetails();
        if(cabDetails.isEmpty()) totalEarningsView.showFailedEarnings("No Earnings Found!");
        else {
            totalEarningsView.showSuccessfulEarnings(cabDetails);
        }
    }
}
