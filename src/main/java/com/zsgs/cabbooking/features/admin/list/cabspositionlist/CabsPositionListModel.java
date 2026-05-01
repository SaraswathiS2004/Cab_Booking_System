package com.zsgs.cabbooking.features.admin.list.cabspositionlist;

import com.zsgs.cabbooking.data.dto.CabCurrentPosition;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

public class CabsPositionListModel {
    private CabsPositionListView cabsPositionListView;
    private CabDB cabDB;
    public CabsPositionListModel(CabsPositionListView cabsPositionListView){
        this.cabsPositionListView = cabsPositionListView;
        this.cabDB = CabDB.getInstance();
    }
    public void getCabs(){
        ArrayList<CabCurrentPosition> cabCurrentPositions = cabDB.getCabsPosition();
        if(cabCurrentPositions.isEmpty()) cabsPositionListView.showFailedCabs("No Cabs Found!");
        else{
            cabsPositionListView.showOnCabsSuccessful(cabCurrentPositions);
        }
    }
}
