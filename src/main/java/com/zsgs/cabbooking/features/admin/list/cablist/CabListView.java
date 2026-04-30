package com.zsgs.cabbooking.features.admin.list.cablist;

import com.zsgs.cabbooking.data.dto.CabDetails;

import java.util.ArrayList;

public class CabListView {

    private CabListModel cabListModel;
    public CabListView(){
        this.cabListModel = new CabListModel(this);
    }
    public void init(){
        cabListModel.getCabs();
    }
    void showCabs(ArrayList<CabDetails> cabsList){
        System.out.println("========== CAB LIST ==========\n");

        System.out.printf("%-7s %-20s %-15s %-10s%n",
                "Cab ID", "Registration No", "Model", "Type");

        System.out.println("----------------------------------------------------------");

        for(CabDetails cabDetails : cabsList){
            System.out.printf("%-7d %-20s %-15s %-10s%n",
                    cabDetails.getCabId(),
                    cabDetails.getRegistrationNumber(),
                    cabDetails.getModel(),
                    cabDetails.getType());
        }
    }
    void onCabsFailed(){
        System.out.println("\nNo cabs are available.");
    }

}
