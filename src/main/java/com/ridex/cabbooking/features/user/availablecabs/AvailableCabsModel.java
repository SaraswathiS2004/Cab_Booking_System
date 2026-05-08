package com.ridex.cabbooking.features.user.availablecabs;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class AvailableCabsModel {
    private AvailableCabsView availableCabsView;

    private RideXDB rideXDB;

    public AvailableCabsModel(AvailableCabsView availableCabsView) {
        this.availableCabsView = availableCabsView;
        this.rideXDB = RideXDB.getInstance();
    }

    public void getAvailableCabsDetails() {
        ArrayList<CabDetails> cabDetails = rideXDB.getCabDetails();
        if (cabDetails.isEmpty()) availableCabsView.showCabsFailed();
        else availableCabsView.showAvailableCabsDetails(cabDetails);
    }
}
