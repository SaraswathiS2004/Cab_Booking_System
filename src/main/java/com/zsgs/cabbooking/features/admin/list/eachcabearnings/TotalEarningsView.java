package com.zsgs.cabbooking.features.admin.list.eachcabearnings;

import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

public class TotalEarningsView {

    private TotalEarningsModel totalEarningsModel;
    private CabDB cabDB;
    public TotalEarningsView(){
        this.totalEarningsModel = new TotalEarningsModel(this);
    }

    public void init(){
        System.out.println("====== Welcome to RideX ======");

        totalEarningsModel.getEarnings();
    }
    void showFailedEarnings(String message){
        System.out.println(message);
    }
    void showSuccessfulEarnings(ArrayList<CabDetails> cabDetails){
        System.out.println("Cabs Total Earnings");
        System.out.println("======================");

        for (CabDetails cabDetails1 : cabDetails) {
            System.out.println("Cab Id : "+ cabDetails1.getCabId() + "  Total Earnings : "+ cabDetails1.getTotalEarning());
        }
        System.out.println("======================");
    }
}
