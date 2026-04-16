package com.zsgs.cabbooking.features.admin.availableCabs;

public class AvailableCabsModel {
    private AvailableCabsView availableCabsView;

    public AvailableCabsModel(){
        this.availableCabsView = new AvailableCabsView();
    }
    public void getAvailableCabsDetails(){
        availableCabsView.showAvailableCabsDetails();
    }
}
