package com.ridex.cabbooking.features.admin.list.driversList;

import com.ridex.cabbooking.data.dto.DriverDetails;

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
        System.out.println("========== DRIVER LIST ==========\n");

        System.out.println("--------------------------------------------------------------------------");

        for(DriverDetails driverDetails1 : driverDetails){

            System.out.println("Driver Id : "+ driverDetails1.getId()+"  Name : "+ driverDetails1.getName() +
            "  Address : "+ driverDetails1.getAddress()  + "  Age : "+ driverDetails1.getAge() + "  Experience : "+
                    driverDetails1.getExperience() + "  Mobile Number : "+ driverDetails1.getMobileNumber());
        }
    }
    void onDriversListFailed(){
        System.out.println("\nNo drivers are available.");
    }
}
