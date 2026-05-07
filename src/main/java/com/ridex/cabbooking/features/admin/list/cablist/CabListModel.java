package com.ridex.cabbooking.features.admin.list.cablist;

import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

public class CabListModel {

    private CabListView cabListView;
    private CabDB cabDB;
    public CabListModel(CabListView cabListView){
        this.cabListView = cabListView;
        this.cabDB = CabDB.getInstance();
    }
    public void getCabs(){
        ArrayList<CabDetails> cabsList = cabDB.getCabDetails();
        if(cabsList.size() == 0){
            cabListView.onCabsFailed();
        }
        else {
            cabListView.showCabs(cabsList);
        }
    }

}
