package com.ridex.cabbooking.features.admin.list.eachcabearnings;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class TotalEarningsModel {
    private TotalEarningsView totalEarningsView;
    private CabDB cabDB;
    public TotalEarningsModel(TotalEarningsView totalEarningsView){
        this.totalEarningsView = totalEarningsView;
        this.cabDB = CabDB.getInstance();
    }

    public void getEarnings(){
        ArrayList<CabDetails> cabDetails = cabDB.getCabDetails();
        if(cabDetails.isEmpty()) totalEarningsView.showFailedEarnings("No Earnings Found!");
        else {
            totalEarningsView.showSuccessfulEarnings(cabDetails);
        }
    }
}
