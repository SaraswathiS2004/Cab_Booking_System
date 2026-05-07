package com.ridex.cabbooking.features.admin.list.cablist;

import com.ridex.cabbooking.data.dto.CabDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class CabListView {

    private CabListModel cabListModel;
    public CabListView() throws SQLException, ClassNotFoundException {
        this.cabListModel = new CabListModel(this);
    }
    public void init() throws SQLException, ClassNotFoundException {
        cabListModel.getCabs();
    }
    void showCabs(ArrayList<CabDetails> cabsList){
        System.out.println("========== CAB LIST ==========\n");

        System.out.println("----------------------------------------------------------");

        for(CabDetails cabDetails : cabsList) {

            System.out.println("Cab Id : " + cabDetails.getCabId() + " Driver Id : "+ cabDetails.getDriverId() +
                    " Cab Registration Number : " + cabDetails.getCabRegistrationNumber() +
                    "  Cab Model : " + cabDetails.getModel() + "  Cab Type : " + cabDetails.getType() +" Earnings : "+cabDetails.getTotalEarning());
        }
        System.out.println("----------------------------------------------------------");

    }
    void onCabsFailed(){
        System.out.println("\nNo cabs are available.");
    }

}
