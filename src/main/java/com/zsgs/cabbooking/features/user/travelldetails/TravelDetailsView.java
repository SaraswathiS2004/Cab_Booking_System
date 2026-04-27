package com.zsgs.cabbooking.features.user.travelldetails;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.Login;
import com.zsgs.cabbooking.data.dto.TripStatus;
import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.home.HomeView;
import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signin.SignInView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TravelDetailsView {

    private TravelDetailsModel travelDetailsModel;
    private AccountDetails accountDetails;
    private Scanner scanner;

    public TravelDetailsView(AccountDetails accountDetails){
        this.travelDetailsModel = new TravelDetailsModel(this);
        Input input = new Input();
        this.scanner = input.getInstance();
        this.accountDetails = accountDetails;
    }

    public void init(){
        System.out.println("Welcome to RideX");
        promptTravelDetails();
    }

    public void showTravelDetails(){

    }
    void promptTravelDetails(){
        ArrayList<CabDetails> cabDetails = travelDetailsModel.getAvailableCabs();
        if(cabDetails.size() == 0){
            showErrorMessage("There is no available Cabs");
            promptPostFailureAction();
        }
        else {
            String pickUp = promptPickUpPoint();
            String dropUp = promptDropUpPoint(pickUp);
            int pickupTiming = promptPickUpTiming();
            showCabs(cabDetails);
            long cabId = promptCabId(cabDetails);
            TripStatus tripStatus = TripStatus.BOOKED;
            AccountDetails currentUser = accountDetails;

            travelDetailsModel.storeData(pickUp , dropUp , pickupTiming ,cabId , tripStatus , currentUser);
        }
    }

    void onDetailsUploadedSuccessful(){
        System.out.println("Successfully Uploded Your Trip details");
    }
    void showCabs(ArrayList<CabDetails> cabs){
        System.out.println("Cabs List :");
        System.out.println();
        for(CabDetails cabDetails : cabs){
            System.out.println("Cab Id "+ cabDetails.getCabId() +" Driver Regitraion Number : "+
                    cabDetails.getRegistrationNumber() +" Model : "+cabDetails.getModel() +" Type : "+ cabDetails.getType());
        }
    }
    void promptPostFailureAction(){
        while(true){
            System.out.println();
            System.out.println("1. Sign In");
            System.out.println("2. Exit");
            String choice = scanner.next();
            switch (choice){
                case "1" :
                    new SignInView().init();
                    break;
                case "2":
                    System.out.println("Thank you for using RideX");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Please Try Again!");
                    break;
            }
        }
    }
    long promptCabId(ArrayList<CabDetails> cabDetails){

        while(true){
            System.out.println("Choose Your Cab Id ");
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
            System.out.println("Enter Your Pick Up place (A , B, C , D , E)");
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
            System.out.println("Enter Your Drop Up Place (A , B , C , D , E)");
            String dropUp = String.valueOf(scanner.next()).toUpperCase();
            String error = travelDetailsModel.validateDropUpPlace(pickUp  , dropUp);
            if(error == null){
                return pickUp;
            }
            else {
                showErrorMessage(error);
            }
        }
    }

    int promptPickUpTiming(){
        while(true){
            System.out.println("Enter your pickUp Timing : ");
            System.out.println("Enter Hours and Minutes eg : 10 30");
            int hours = scanner.nextInt();
            int minutes = scanner.nextInt();
            int pickUpTime = hours * minutes;
            String error = travelDetailsModel.validatePickUpTiming(pickUpTime);
            if(error == null){
                return pickUpTime;
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
