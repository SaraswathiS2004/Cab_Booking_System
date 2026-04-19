package com.zsgs.cabbooking.features.admin.totalearnings;

class TotalEarningsModel {
    private TotalEarningsView totalEarningsView;

    public TotalEarningsModel(){
        totalEarningsView = new TotalEarningsView();
    }

    public void getTotalEarnings(){
        totalEarningsView.showTotalEarnings();
    }
}
