package com.ridex.cabbooking.features.admin.list.cabspositionlist;

import com.ridex.cabbooking.data.dto.CabCurrentPosition;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class CabsPositionListModel {
    private CabsPositionListView cabsPositionListView;
    private RideXDB rideXDB;
    public CabsPositionListModel(CabsPositionListView cabsPositionListView){
        this.cabsPositionListView = cabsPositionListView;
        this.rideXDB = RideXDB.getInstance();
    }
    public void getCabs(){
        ArrayList<CabCurrentPosition> cabCurrentPositions = rideXDB.getCabsPosition();
        if(cabCurrentPositions.isEmpty()) cabsPositionListView.showFailedCabs("No Cabs Found!");
        else{
            cabsPositionListView.showOnCabsSuccessful(cabCurrentPositions);
        }
    }
}
