package com.zsgs.cabbooking.features.driverdetails;

//import com.zsgs.cabbooking.features.admin;

import com.zsgs.cabbooking.features.driverdetails.cabdetails.CabDetailsView;
import com.zsgs.cabbooking.util.ConsoleInput;

import java.util.Scanner;

public class DriverDetailsView {

    private DriverDetailsModel driverDetailsModel;
    private Scanner scanner;

    public DriverDetailsView(){
        this.driverDetailsModel = new DriverDetailsModel(this);
        ConsoleInput consoleInput = new ConsoleInput();
        this.scanner = consoleInput.getInstance();

    }
    public void init(){
        System.out.println("\n========== RIDEX ==========");
        System.out.println("Welcome to RideX");
        promptDriverDetails();
    }

    public void promptDriverDetails(){
        int age = promptAge();
        String address = promptAddress();
        int experience = promptExperience(age);
        String mobileNumber = promptMobileNumber();
        driverDetailsModel.storeDriverData(address , age , experience , mobileNumber);

    }
    public void onDriverSuccessful(long id){
        System.out.println("Your registration number is: " + id);
        System.out.println("Driver details added successfully!");
        new CabDetailsView(id).init();

    }

    public String promptAddress(){
        while(true){
            try {
                System.out.print("Enter Your Address : ");
                scanner.nextLine();
                String address = scanner.nextLine();
                String error = driverDetailsModel.validateAddress(address);
                if (error == null) {
                    return address;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }
    public int promptAge(){
        while(true){
            try {
                System.out.print("Enter Your Age : ");
                int age = scanner.nextInt();
                String error = driverDetailsModel.validateAge(age);
                if (error == null) {
                    return age;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }
    public int promptExperience(int age){
        while(true){
            try {
                System.out.print("Enter your driving experience (in years) : ");
                int experience = scanner.nextInt();
                String error = driverDetailsModel.validateExperience(experience, age);
                if (error == null) {
                    return experience;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }



    public String promptMobileNumber(){
        while(true) {
            try {
                System.out.print("Enter Your Mobile Number : ");
                String mobileNumber = scanner.next();
                String error = driverDetailsModel.validateMobileNumber(mobileNumber);
                if (error == null) {
                    return mobileNumber;
                } else {
                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    public void showErrorMessage(String message){
        System.out.println(message);
    }

}
