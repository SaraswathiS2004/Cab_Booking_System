package com.ridex.cabbooking.features.driverdetails;

import com.ridex.cabbooking.data.dto.DriverDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.sql.SQLException;
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
    public void storeDriverData(long driverId , String address , int age , int experience , String mobileNumber) throws SQLException, ClassNotFoundException {

        String name = cabDB.getDriverName(driverId);
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDriverDetails(driverId ,name , address , age , experience , mobileNumber);
        cabDB.addDriver(driverDetails);
        ArrayList<DriverDetails> driverDetails1 = cabDB.getDriverDetails();
        driverDetailsView.onDriverSuccessful(driverId);

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
