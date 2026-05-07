package com.ridex.cabbooking.features.user.availablecabs;

import com.ridex.cabbooking.data.dto.CabDetails;

import java.util.ArrayList;

public class AvailableCabsView {
    private AvailableCabsModel availableCabsModel;

    public AvailableCabsView() {
        this.availableCabsModel = new AvailableCabsModel(this);

    }

    public void init() {
        System.out.println("Welcome to RideX\n");
        availableCabsModel.getAvailableCabsDetails();
    }

    public void showAvailableCabsDetails(ArrayList<CabDetails> cabDetails) {
        System.out.println("========== AVAILABLE CABS ==========\n");

        System.out.println("--------------------------------------------------------------------------");

        for (CabDetails cabDetails1 : cabDetails) {
            System.out.println("Driver Id : " + cabDetails1.getDriverId() + "  Cab Id : " + cabDetails1.getCabId() +
                    "  Cab Registration Number : " + cabDetails1.getCabRegistrationNumber() +
                    "  Cab Model : " + cabDetails1.getModel() + "  Cab Type : " + cabDetails1.getType() +
                    "  Total Earnings : " + cabDetails1.getTotalEarning());
            System.out.println("--------------------------------------------------------------------------");
        }

    }
    public void showCabsFailed() {
        System.out.println("There are no Cabs Available now!");
    }
}
