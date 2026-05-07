package com.ridex.cabbooking.features.admin.list.cabspositionlist;

import com.ridex.cabbooking.data.dto.CabCurrentPosition;

import java.util.ArrayList;

public class CabsPositionListView {

    private CabsPositionListModel cabsPositionListModel;

    public CabsPositionListView(){
        this.cabsPositionListModel = new CabsPositionListModel(this);
    }
    public void init(){
        cabsPositionListModel.getCabs();
    }

    public void showOnCabsSuccessful(ArrayList<CabCurrentPosition> cabCurrentPositions){
        for(CabCurrentPosition cabCurrentPosition : cabCurrentPositions){
            System.out.println("Cab Id : "+ cabCurrentPosition.getCabId() + "  Cab Current Position : "+ cabCurrentPosition.getPosition());
        }
    }
    void showFailedCabs(String message){
        System.out.println(message);
    }
}
