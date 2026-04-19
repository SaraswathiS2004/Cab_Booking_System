package com.zsgs.cabbooking.features.admin.cabdetails;

import com.zsgs.cabbooking.features.user.CabNotification.CabNotificationView;

class CabDetailsModel {
     private CabDetailsView cabDetailsView;

     public CabDetailsModel (){
         cabDetailsView = new CabDetailsView();
     }

     public void getCabDetails(){
         cabDetailsView.showCabDetails();
     }
}
