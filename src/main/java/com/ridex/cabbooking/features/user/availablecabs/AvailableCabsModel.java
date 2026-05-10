package com.ridex.cabbooking.features.user.availablecabs;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class AvailableCabsModel {
    private AvailableCabsView availableCabsView;
    private RideXDB rideXDB;

    public AvailableCabsModel(AvailableCabsView availableCabsView) throws SQLException, ClassNotFoundException {
        this.availableCabsView = availableCabsView;
        this.rideXDB = new RideXDB();
    }


    public void getAvailableCabsDetails() throws SQLException, ClassNotFoundException {
        ArrayList<CabDetails> cabDetails = rideXDB.getAvailableCabs();
        if (cabDetails.isEmpty()) availableCabsView.showCabsFailed();
        else availableCabsView.showAvailableCabsDetails(cabDetails);
    }
}
