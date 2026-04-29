package com.zsgs.cabbooking.features.user.availablecabs;

import com.zsgs.cabbooking.features.user.availablecabs.AvailableCabsView;
import com.zsgs.cabbooking.features.user.availablecabs.AvailableCabsModel;
import com.zsgs.cabbooking.data.dto.CabDetails;

import java.util.ArrayList;

public class AvailableCabsView {
    private AvailableCabsModel availableCabsModel;

    public AvailableCabsView() {
        this.availableCabsModel = new AvailableCabsModel(this);

    }

    public void init() {
        System.out.println("Welcome to RideX");
        availableCabsModel.getAvailableCabsDetails();
    }

    public void showAvailableCabsDetails(ArrayList<CabDetails> cabDetails) {
        System.out.println("Cab Details ");
        System.out.println();
        for (CabDetails cabDetails1 : cabDetails) {
            System.out.println(" Id : " + cabDetails1.getCabId() + " Driver Registraion Number : " +
                    cabDetails1.getRegistrationNumber() + " Model : " + cabDetails1.getModel() +
                    " Type : " + cabDetails1.getType() + " Total Earnings : " + cabDetails1.getTotalEarning());

        }
    }

    public void showCabsFailed() {
        System.out.println("There are no Cabs Available now!");
    }
}
