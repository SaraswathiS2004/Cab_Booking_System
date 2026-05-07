package com.ridex.cabbooking.features.admin.list.driversList;

import com.ridex.cabbooking.data.dto.DriverDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class DriversListModel {

    private DriversListView driversListView;
    private CabDB cabDB;
    public DriversListModel(DriversListView driversListView){
        this.driversListView = driversListView;
        this.cabDB = CabDB.getInstance();
    }
    void getDrivers(){
        ArrayList<DriverDetails> driverDetails = cabDB.getDriverDetails();
        if(driverDetails.isEmpty()){
            driversListView.onDriversListFailed();
        }
        else {
            driversListView.showDrivers(driverDetails);
        }
    }


}
