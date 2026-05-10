package com.ridex.cabbooking.features.admin.list.eachcabearnings;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class TotalEarningsModel {
    private TotalEarningsView totalEarningsView;
    //    private CabDB cabDB;
    private RideXDB rideXDB;

    public TotalEarningsModel(TotalEarningsView totalEarningsView) throws SQLException, ClassNotFoundException {
        this.totalEarningsView = totalEarningsView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }

    public void getEarnings() {
        ArrayList<CabDetails> cabDetails = rideXDB.getCabList();
        if (cabDetails.isEmpty()) totalEarningsView.showFailedEarnings("No Earnings Found!");
        else {
            totalEarningsView.showSuccessfulEarnings(cabDetails);
        }
    }
}
