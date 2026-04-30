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
        System.out.println("Welcome to RideX\n");
        availableCabsModel.getAvailableCabsDetails();
    }

    public void showAvailableCabsDetails(ArrayList<CabDetails> cabDetails) {
        System.out.println("========== AVAILABLE CABS ==========\n");

        System.out.printf("%-5s %-20s %-15s %-10s %-15s%n",
                "ID", "Registration No", "Model", "Type", "Earnings");

        System.out.println("--------------------------------------------------------------------------");

        for (CabDetails cabDetails1 : cabDetails) {
            System.out.printf("%-5d %-20s %-15s %-10s %-15d%n",
                    cabDetails1.getCabId(),
                    cabDetails1.getRegistrationNumber(),
                    cabDetails1.getModel(),
                    cabDetails1.getType(),
                    cabDetails1.getTotalEarning());
        }
    }

    public void showCabsFailed() {
        System.out.println("There are no Cabs Available now!");
    }
}
