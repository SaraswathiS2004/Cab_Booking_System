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
        System.out.println("Cabs List :");
        System.out.println();

        for(CabDetails cabDetails : cabsList){
            System.out.println("Cab Id "+ cabDetails.getCabId() +" Driver Regitraion Number : "+
                    cabDetails.getRegistrationNumber() +" Model : "+cabDetails.getModel() +" Type : "+ cabDetails.getType());
        }
    }
    void onCabsFailed(){
        System.out.println("There are No Cabs");
    }

}
