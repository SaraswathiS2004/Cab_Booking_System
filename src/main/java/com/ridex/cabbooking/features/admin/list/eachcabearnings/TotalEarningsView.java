package com.ridex.cabbooking.features.admin.list.eachcabearnings;

import com.ridex.cabbooking.data.dto.CabDetails;


import java.sql.SQLException;
import java.util.ArrayList;

public class TotalEarningsView {

    private TotalEarningsModel totalEarningsModel;

    public TotalEarningsView() throws SQLException, ClassNotFoundException {
        this.totalEarningsModel = new TotalEarningsModel(this);
    }

    public void init() {

        System.out.println("====== Welcome to RideX ======");
        totalEarningsModel.getEarnings();
    }

    void showFailedEarnings(String message) {
        System.out.println(message);
    }

    void showSuccessfulEarnings(ArrayList<CabDetails> cabDetails) {
        System.out.println("Cabs Total Earnings");
        System.out.println("======================");

        for (CabDetails cabDetails1 : cabDetails) {
            System.out.println("Cab Id : " + cabDetails1.getCabId() + "  Total Earnings : " + cabDetails1.getTotalEarning());
        }
        System.out.println("======================");
    }
}
