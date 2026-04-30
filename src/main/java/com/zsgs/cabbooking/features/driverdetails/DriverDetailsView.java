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
        this.scanner = input.getInstance();

    }
    public void init(){
        System.out.println("\n========== RIDEX ==========");
        System.out.println("Welcome to RideX\n");
        promptDriverDetails();
        new CabDetailsView().init();
    }

    public void promptDriverDetails(){
        int age = promptAge();
        String address = promptAddress();
        int experience = promptExperience(age);
        String mobileNumber = promptMobileNumber();
        driverDetailsModel.storeDriverData(address , age , experience , mobileNumber);

    }
    public void onDriverSuccessful(long id){
        System.out.println("\nYour registration number is: " + id);
        System.out.println("Driver details added successfully!");

    }

    public String promptAddress(){
        while(true){
            System.out.print("\nEnter Your Address : ");
            scanner.nextLine();
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
            System.out.print("\nEnter Your Age : ");
            int age = scanner.nextInt();
            String error = driverDetailsModel.validateAge(age);
            if(error == null){
                return age;
            }
            showErrorMessage(error);
        }
    }
    public int promptExperience(int age){
        while(true){
            System.out.print("\nEnter your driving experience (in years) : ");
            int experience = scanner.nextInt();
            String error = driverDetailsModel.validateExperience(experience , age);
            if(error == null){
                return experience;
            }
            showErrorMessage(error);
        }
    }



    public String promptMobileNumber(){
        while(true) {
            System.out.print("\nEnter Your Mobile Number : ");
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
