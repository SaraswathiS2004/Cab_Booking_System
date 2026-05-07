package com.ridex.cabbooking.features.admin.list.cablist;

import com.ridex.cabbooking.RideX;
import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.CabDB;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class CabListModel {

    private CabListView cabListView;
//    private CabDB cabDB;
    private RideXDB rideXDB;
    public CabListModel(CabListView cabListView) throws SQLException, ClassNotFoundException {
        this.cabListView = cabListView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }
    public void getCabs() throws SQLException, ClassNotFoundException {
//        ArrayList<CabDetails> cabsList = cabDB.getCabDetails();

        ArrayList<CabDetails> cabsList = rideXDB.getCabList();
        if(cabsList.size() == 0){
            cabListView.onCabsFailed();
        }
        else {
            cabListView.showCabs(cabsList);
        }
    }

}
