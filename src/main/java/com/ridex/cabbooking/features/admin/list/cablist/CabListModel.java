package com.ridex.cabbooking.features.admin.list.cablist;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

public class CabListModel {

    private CabListView cabListView;
    private RideXDB rideXDB;
    public CabListModel(CabListView cabListView){
        this.cabListView = cabListView;
        this.rideXDB = RideXDB.getInstance();
    }
    public void getCabs(){
        ArrayList<CabDetails> cabsList = rideXDB.getCabDetails();
        if(cabsList.size() == 0){
            cabListView.onCabsFailed();
        }
        else {
            cabListView.showCabs(cabsList);
        }
    }

}
