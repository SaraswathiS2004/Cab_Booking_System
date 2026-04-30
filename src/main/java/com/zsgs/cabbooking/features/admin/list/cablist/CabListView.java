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

        System.out.println("----------------------------------------------------------");

        for(CabDetails cabDetails : cabsList) {

            System.out.println("Cab Id : " + cabDetails.getCabId() +
                    "  Driver Id : " + cabDetails.getRegistrationNumber() +
                    "  Cab Model : " + cabDetails.getModel() + "  Cab Type " + cabDetails.getType() + "  Total Earnings : "+ cabDetails.getTotalEarning());
        }
        System.out.println("----------------------------------------------------------");

    }
    void onCabsFailed(){
        System.out.println("\nNo cabs are available.");
    }

}
