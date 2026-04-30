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
        System.out.println("========== DRIVER LIST ==========\n");

        System.out.printf("%-10s %-15s %-20s %-5s %-12s %-15s%n",
                "Reg No", "Name", "Address", "Age", "Experience", "Mobile");

        System.out.println("--------------------------------------------------------------------------");

        for(DriverDetails driverDetails1 : driverDetails){
            System.out.printf("%-10d %-15s %-20s %-5d %-12s %-15s%n",
                    driverDetails1.getId(),
                    driverDetails1.getName(),
                    driverDetails1.getAddress(),
                    driverDetails1.getAge(),
                    driverDetails1.getExperience(),
                    driverDetails1.getMobileNumber());
        }
    }
    void onDriversListFailed(){
        System.out.println("\nNo drivers are available.");
    }
}
