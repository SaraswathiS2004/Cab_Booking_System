package com.zsgs.cabbooking.features.driverdetails.cabdetails;

import com.zsgs.cabbooking.data.dto.CabCurrentPosition;
import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class CabDetailsModel {
     private CabDetailsView cabDetailsView;
     private CabDetails cabDetails;
     private CabDB cabDB;
     private CabCurrentPosition cabCurrentPosition;

     public CabDetailsModel (CabDetailsView cabDetailsView){
         this.cabDetailsView = cabDetailsView;
         this.cabDetails = new CabDetails();
         this.cabDB = CabDB.getInstance();
         this.cabCurrentPosition = new CabCurrentPosition();
     }

     public void storeData(long driverId , String registrationNumber  , String model , String type){
         long cabId = cabDB.getCabId();
         cabDetails.setValues(driverId ,cabId , registrationNumber , model , type);
         cabCurrentPosition.setCabId(cabId);
         cabCurrentPosition.setPosition("A");
         cabDB.addCab(cabDetails);
         cabDB.addCabPosition(cabCurrentPosition);
         cabDetailsView.onSuccessful();
     }

    String validateId(String id){
       if(id.trim().length() >= 3 && id.trim().length() < 50){
           return null;
       }
        return "Invalid driver ID.";
    }

    String validateModel(String model){
         if(model == null || model.trim().isEmpty()){
             return "Cab Model cannot be empty.";
         }
         else if(model.trim().length() < 3 ) {
             return "Model must be Between 3 to 30 Characters.";
         }
         return null;
    }
    String validateType(String type){
         if(type == null || type.trim().isEmpty()){
             return "Type Cannot be Empty.";
         }
         else if(type.trim().length() < 3){
             return "Type Must be Between 3 to 30 Characters.";
         }
         return null;
    }
}
