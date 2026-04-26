package com.zsgs.cabbooking.features.driverdetails;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;
import java.util.regex.Pattern;

class DriverDetailsModel {
    private DriverDetailsView driverDetailsView;
    private CabDB cabDB;


    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");
    public DriverDetailsModel(DriverDetailsView driverDetailsView){
        this.driverDetailsView = driverDetailsView;
        cabDB = CabDB.getInstance();

    }
    public void storeDriverData(String address , int age , int experience , String mobileNumber){
        long id = cabDB.getDriverId();
        String name = cabDB.getDriverName(id);
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDriverDetails(name , id , address , age , experience , mobileNumber);
        cabDB.addDriver(driverDetails);
        ArrayList<DriverDetails> driverDetails1 = cabDB.getDriverDetails();
        driverDetailsView.onDriverSuccessful(id);

    }


    String validateAddress(String name){

        if(name == null || name.trim().isEmpty()){
            return "Address Cannot be Empty";
        }
        else if(name.length() < 3 || name.length() > 100){
            return "Address must be between 3 to 100 Characters";
        }
        return null;
    }

    String validateAge(int age){
        if(age < 19 || age > 60){
            return "Your age Must be between 19 to 60";
        }
        return null;
    }
    String validateExperience(int experience , int age){
        if(experience < 1){
            return "The Experience must be more than 1 year";
        }
        else if(experience > 0 && (age - experience) < 18){
            return "The Experience cannot be meet the age requirement";
        }
        return null;
    }
    String validateMobileNumber(String mobileNumber){

        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            return "Mobile number cannot be empty";
        }
        if (!MOBILE_PATTERN.matcher(mobileNumber.trim()).matches()) {
            return "Enter a valid 10 digit mobile number";
        }
        return null;
    }


}
