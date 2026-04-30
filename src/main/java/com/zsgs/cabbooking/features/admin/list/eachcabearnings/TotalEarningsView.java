package com.zsgs.cabbooking.features.admin.list.eachcabearnings;

import com.zsgs.cabbooking.data.repository.CabDB;

public class TotalEarningsView {

    private TotalEarningsModel totalEarningsModel;
    private CabDB cabDB;
    public TotalEarningsView(){
        this.totalEarningsModel = new TotalEarningsModel(this);
    }

    public void init(){

    }
}
