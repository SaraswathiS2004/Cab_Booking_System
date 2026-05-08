package com.ridex.cabbooking.features.admin.list.driversList;

import com.ridex.cabbooking.data.dto.DriverDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class DriversListModel {

    private DriversListView driversListView;
    private RideXDB rideXDB;
    public DriversListModel(DriversListView driversListView){
        this.driversListView = driversListView;
        this.rideXDB = RideXDB.getInstance();
    }
    void getDrivers(){
        ArrayList<DriverDetails> driverDetails = rideXDB.getDriverDetails();
        if(driverDetails.isEmpty()){
            driversListView.onDriversListFailed();
        }
        else {
            driversListView.showDrivers(driverDetails);
        }
    }


}
