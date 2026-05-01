package com.zsgs.cabbooking.features.user.traveldetails;

import com.zsgs.cabbooking.data.dto.*;
import com.zsgs.cabbooking.features.consoleinput.Input;
import com.zsgs.cabbooking.features.signin.SignInView;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelDetailsView {

    private TravelDetailsModel travelDetailsModel;
    private AccountDetails accountDetails;
    private Scanner scanner;
    private ArrayList<CabDetails> cabDetails;

    public TravelDetailsView(AccountDetails accountDetails){
        this.travelDetailsModel = new TravelDetailsModel(this);
        Input input = new Input();
        this.scanner = input.getInstance();
        this.accountDetails = accountDetails;
    }

    public void init(){
        System.out.println("Welcome to RideX\n");
        promptTravelDetails();
    }
    void promptTravelDetails(){
        cabDetails = travelDetailsModel.getAvailableCabs();
        if(cabDetails.size() == 0){
            showErrorMessage("No cabs are available in this moment");
            promptPostFailureAction();
        }
        else {
            String pickUp = promptPickUpPoint();
            String dropUp = promptDropUpPoint(pickUp);
            LocalTime pickupTiming = LocalTime.now();
            LocalTime dropupTiming = travelDetailsModel.getDropTiming(pickUp , dropUp);
            showCabs(cabDetails);
            long cabId = promptCabId(cabDetails);
            TripStatus tripStatus = TripStatus.BOOKED;
            int payment =  promptPayAmount(pickUp , dropUp);
            travelDetailsModel.setCabEarnings(cabId ,payment);
            AccountDetails currentUser = accountDetails;
            travelDetailsModel.storeData(pickUp , dropUp , pickupTiming ,dropupTiming , cabId , tripStatus , currentUser , payment);
        }
    }

    void onDetailsUploadedSuccessful(){
        System.out.println("\nTrip details uploaded successfully!");

    }

    int promptPayAmount(String pickUp , String dropUp){
        System.out.println("\n========== PAYMENT ==========");
        System.out.println("Please pay for your trip.");
        int money = travelDetailsModel.calculateMoney(pickUp , dropUp);
        System.out.println("Total Cost : "+money);
        int amount = promptGetAmount(money);
        return amount;
    }
    int promptGetAmount(int money){

        while(true){
            System.out.print("Enter payment amount: ");
            int amount = scanner.nextInt();
            String error = travelDetailsModel.validateAmount(money , amount);
            if(error == null){
                return amount;
            }
            showErrorMessage(error);
        }
    }
    void showCabs(ArrayList<CabDetails> cabs){
        System.out.println("\n========== AVAILABLE CABS ==========\n");

        System.out.printf("%-7s %-20s %-15s %-10s%n",
                "Cab ID", "Registration No", "Model", "Type");

        System.out.println("----------------------------------------------------------");

        for (CabDetails cabDetails : cabs) {
            System.out.printf("%-7d %-20s %-15s %-10s%n",
                    cabDetails.getCabId(),
                    cabDetails.getRegistrationNumber(),
                    cabDetails.getModel(),
                    cabDetails.getType());
        }
    }
    void promptPostFailureAction(){
        while(true){
            System.out.println("\n========== OPTIONS ==========");
            System.out.println("1. Sign In");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.next();
            switch (choice){
                case "1" :
                    new SignInView().init();
                    break;
                case "2":
                    System.out.println("\nThank you for using RideX.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    long promptCabId(ArrayList<CabDetails> cabDetails){

        while(true){
            System.out.print("Enter Cab ID: ");
            long cabId = scanner.nextLong();
            String error = travelDetailsModel.validateCabId(cabDetails , cabId);
            if(error == null){
                return cabId;
            }
            else{
                showErrorMessage(error);
            }
        }

    }
    String promptPickUpPoint(){

        while(true){
            System.out.print("Enter pickup location (A, B, C, D, E , F): ");
            String pickUp = String.valueOf(scanner.next()).toUpperCase();
            String error = travelDetailsModel.validatePickUpPlace(pickUp);
            if(error == null){
                return pickUp;
            }
            else {
                showErrorMessage(error);
            }
        }
    }
    String promptDropUpPoint(String pickUp){

        while(true){
            System.out.print("Enter drop location (A, B, C, D, E, F): ");
            String dropUp = String.valueOf(scanner.next()).toUpperCase();
            String error = travelDetailsModel.validateDropUpPlace(pickUp  , dropUp);
            if(error == null){
                return dropUp;
            }
            else {
                showErrorMessage(error);
            }
        }
    }
    void showErrorMessage(String message){
        System.out.println(message);
    }

}
