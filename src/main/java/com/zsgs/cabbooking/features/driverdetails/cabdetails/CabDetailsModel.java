package com.zsgs.cabbooking.features.driverdetails.cabdetails;

import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class CabDetailsModel {
     private CabDetailsView cabDetailsView;
     private CabDetails cabDetails;
     private CabDB cabDB;

     public CabDetailsModel (CabDetailsView cabDetailsView){
         this.cabDetailsView = cabDetailsView;
         cabDetails = new CabDetails();
         cabDB = CabDB.getInstance();
     }

     public void storeData(long registrationNumber  , String model , String type){
         long cabId = cabDB.getCabId();
         cabDetails.setValues(cabId , registrationNumber , model , type);
         cabDB.addCab(cabDetails);
         cabDetailsView.onSuccessful();
     }

     String validateId(long id){
         if(id < 0 ){
             return "Id cannot be Negative value";
         }
         return null;
     }

    String validateModel(String model){
         if(model == null || model.trim().isEmpty()){
             return "Model cannot be empty";
         }
         else if(model.trim().length() < 3 ) {
             return "Model must be Between 3 to 30 Characters";
         }
         return null;
    }
    String validateType(String type){
         if(type == null || type.trim().isEmpty()){
             return "Type Cannot be Empty";
         }
         else if(type.trim().length() < 3){
             return "Type Must be Between 3 to 30 Characters";
         }
         return null;
    }
     boolean isAlreadyRegistered(long id){

         ArrayList<DriverDetails> driverDetails = cabDB.getDriver();

         for(DriverDetails driverDetails1 : driverDetails){
             if(driverDetails1 == null) continue;
             else {
                 long registerId = driverDetails1.getId();
                 if(registerId == id){
                     return true;
                 }
             }
         }
         return false;
     }

}
