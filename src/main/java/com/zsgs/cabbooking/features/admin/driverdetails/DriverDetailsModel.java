package com.zsgs.cabbooking.features.admin.driverdetails;

import com.zsgs.cabbooking.features.admin.availableCabs.AvailableCabsView;

public class DriverDetailsModel {
    private DriverDetailsView driverDetailsView;

    public DriverDetailsModel(DriverDetailsView driverDetailsView){
        this.driverDetailsView = new DriverDetailsView();
    }
    public void getAvailableCabsDetails(){
        driverDetailsView.showCabDetails();
    }
}
