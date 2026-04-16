package com.zsgs.cabbooking.features.admin.totalearnings;

public class TotalEarningsModel {
    private TotalEarningsView totalEarningsView;

    public TotalEarningsModel(){
        totalEarningsView = new TotalEarningsView();
    }

    public void getTotalEarnings(){
        totalEarningsView.showTotalEarnings();
    }
}
