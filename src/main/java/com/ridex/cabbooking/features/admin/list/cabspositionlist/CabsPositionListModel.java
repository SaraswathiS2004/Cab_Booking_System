package com.ridex.cabbooking.features.admin.list.cabspositionlist;

import com.ridex.cabbooking.data.dto.CabCurrentPosition;
import com.ridex.cabbooking.data.repository.CabDB;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class CabsPositionListModel {
    private CabsPositionListView cabsPositionListView;
//    private CabDB cabDB;
    private RideXDB rideXDB;
    public CabsPositionListModel(CabsPositionListView cabsPositionListView) throws SQLException, ClassNotFoundException {
        this.cabsPositionListView = cabsPositionListView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }
    public void getCabs() throws SQLException, ClassNotFoundException {
//        ArrayList<CabCurrentPosition> cabCurrentPositions = cabDB.getCabsPosition();

        ArrayList<CabCurrentPosition> cabCurrentPositions = new RideXDB().getCabPositionList();
        if(cabCurrentPositions.isEmpty()) cabsPositionListView.showFailedCabs("No Cabs Found!");
        else{
            cabsPositionListView.showOnCabsSuccessful(cabCurrentPositions);
        }
    }
}
