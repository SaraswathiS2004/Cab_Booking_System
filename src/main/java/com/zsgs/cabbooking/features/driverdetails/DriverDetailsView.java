package com.zsgs.cabbooking.features.driverdetails;

//import com.zsgs.cabbooking.features.admin;

import com.zsgs.cabbooking.features.driverdetails.cabdetails.CabDetailsView;
import com.zsgs.cabbooking.features.input.Input;

import java.util.Scanner;

public class DriverDetailsView {

    private DriverDetailsModel driverDetailsModel;
    private Scanner scanner;

    public DriverDetailsView(){
        this.driverDetailsModel = new DriverDetailsModel(this);
        Input input = new Input();
        scanner = input.getInstance();

    }
    public void init(){
        System.out.println("Welcome to RideX");
        promptDriverDetails();
        new CabDetailsView().init();
    }

    public void promptDriverDetails(){

        String name = promptName();
        String address = promptAddress();
        int age = promptAge();
        int experience = promptExperience();
        String mobileNumber = promptMobileNumber();
        driverDetailsModel.storeDriverData(name  ,address , age , experience , mobileNumber);

    }
    public void onDriverSuccessful(){
        System.out.println("Successfully added Your Details");

    }

    public String promptName(){
        while(true){
            System.out.println("Enter Your Name");
            String name = scanner.next();
            String error = driverDetailsModel.validateName(name);
            if(error == null){
                return name;
            }
            showErrorMessage(error);
        }
    }
    public String promptAddress(){
        while(true){
            System.out.println("Enter Your Address");
            String address = scanner.nextLine();
            String error = driverDetailsModel.validateAddress(address);
            if(error == null){
                return address;
            }
            showErrorMessage(error);
        }
    }
    public int promptAge(){
        while(true){
            System.out.println("Enter Your Age");
            int age = scanner.nextInt();
            String error = driverDetailsModel.validateAge(age);
            if(error == null){
                return age;
            }
            showErrorMessage(error);
        }
    }
    public int promptExperience(){
        while(true){
            System.out.println("Enter Your Drive Experience");
            int experience = scanner.nextInt();
            String error = driverDetailsModel.validateExperience(experience);
            if(error == null){
                return experience;
            }
            showErrorMessage(error);
        }
    }

    public String promptMobileNumber(){
        while(true) {
            System.out.println("Enter Your Mobile Number");
            String mobileNumber = scanner.next();
            String error = driverDetailsModel.validateMobileNumber(mobileNumber);
            if (error == null) {
                return mobileNumber;
            } else {
                showErrorMessage(error);
            }
        }
    }

    public void showErrorMessage(String message){
        System.out.println(message);
    }

}
