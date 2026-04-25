package com.zsgs.cabbooking.features.admin.driverdetails;

import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.input.Input;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class DriverDetailsModel {
    private DriverDetailsView driverDetailsView;
    private CabDB cabDB;

    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");
    public DriverDetailsModel(DriverDetailsView driverDetailsView){
        this.driverDetailsView = driverDetailsView;
        cabDB = CabDB.getInstance();

    }
    public void storeDriverData(String name , String address , int age , int experience , String mobileNumber){
        long id = cabDB.getDriverId();
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDriverDetails(name , id , address , age , experience , mobileNumber);
        cabDB.addDriver(driverDetails);
        ArrayList<DriverDetails> driverDetails1 = cabDB.getDriver();
        driverDetailsView.onDriverSuccessful();
        for(DriverDetails driverDetails2 : driverDetails1){
            System.out.println("Name : "+ driverDetails2.getName() +"    "+"id : "+
                    driverDetails2.getId() +"  "+"MobileNumber "+driverDetails2.getMobileNumber()+" experience : "+ driverDetails2.getExperience() + " age : "+ driverDetails2.getAge() +"Address : "+ driverDetails2.getAddress());
        }
    }

    String validateName(String name){

        if(name == null || name.trim().isEmpty()){
            return "Name Cannot be Empty";
        }
        else if(name.length() < 3 || name.length() > 30){
            return "Name must be between 3 to 30 Characters";
        }
        return null;
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
            return "Your age Must be between 18 to 60";
        }
        return null;
    }
    String validateExperience(int experience){
        if(experience < 1){
            return "The Experience must be more than 1 year";
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
