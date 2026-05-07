package com.ridex.cabbooking.features.admin.list.driversList;

import com.ridex.cabbooking.data.dto.DriverDetails;
import com.ridex.cabbooking.data.repository.CabDB;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class DriversListModel {

    private DriversListView driversListView;
//    private CabDB cabDB;

    private RideXDB rideXDB;
    public DriversListModel(DriversListView driversListView) throws SQLException, ClassNotFoundException {
        this.driversListView = driversListView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }

    void getDrivers() throws SQLException, ClassNotFoundException {
//        ArrayList<DriverDetails> driverDetails = cabDB.getDriverDetails();
        ArrayList<DriverDetails> driverDetails = rideXDB.getDriversList();
        if(driverDetails.isEmpty()){
            driversListView.onDriversListFailed();
        }
        else {
            driversListView.showDrivers(driverDetails);
        }
    }


}
