package com.zsgs.cabbooking.features.admin.list.driversList;

import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;

import java.util.ArrayList;

public class DriversListView {
    private DriversListModel driversListModel;
    public DriversListView(){
        this.driversListModel = new DriversListModel(this);
    }
    public void init(){
       driversListModel.getDrivers();
    }
    void showDrivers(ArrayList<DriverDetails> driverDetails){

        for(DriverDetails driverDetails1 : driverDetails){
            System.out.println("Register_number : "+ driverDetails1.getId()+" Name : "+ driverDetails1.getName()
            +" Address : "+driverDetails1.getAddress()+" Age : "+driverDetails1.getAge()+" Experience "+
                    driverDetails1.getExperience()+ " Mobile Number "+ driverDetails1.getMobileNumber());
        }
    }
    void onDriversListFailed(){
        System.out.println("Drivers is not available");
    }
}
