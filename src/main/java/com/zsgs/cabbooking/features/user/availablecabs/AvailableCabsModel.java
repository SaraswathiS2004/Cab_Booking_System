package com.zsgs.cabbooking.features.user.availablecabs;

import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class AvailableCabsModel {
    private AvailableCabsView availableCabsView;

    private CabDB cabDB;

    public AvailableCabsModel(AvailableCabsView availableCabsView) {
        this.availableCabsView = availableCabsView;
        this.cabDB = CabDB.getInstance();
    }

    public void getAvailableCabsDetails() {
        ArrayList<CabDetails> cabDetails = cabDB.getCabDetails();
        if (cabDetails.isEmpty()) availableCabsView.showCabsFailed();
        availableCabsView.showAvailableCabsDetails(cabDetails);
    }
}
