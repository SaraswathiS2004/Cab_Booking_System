package com.zsgs.cabbooking.features.admin.totalearnings;

import com.zsgs.cabbooking.data.repository.CabDB;

import java.lang.classfile.attribute.LineNumberInfo;

public class TotalEarningsView {

    private TotalEarningsModel totalEarningsModel;
    private CabDB cabDB;
    public TotalEarningsView(){
        this.totalEarningsModel = new TotalEarningsModel(this);
    }

    public void init(){

    }
}
