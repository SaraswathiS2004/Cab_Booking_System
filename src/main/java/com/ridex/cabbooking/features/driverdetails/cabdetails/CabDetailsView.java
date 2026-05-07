package com.ridex.cabbooking.features.driverdetails.cabdetails;

import com.ridex.cabbooking.util.ConsoleInput;

import java.util.Scanner;

public class CabDetailsView {
    private CabDetailsModel cabDetailsModel;
    private Scanner scanner;
    private long driverId;
    public CabDetailsView(long driverId){
        this.cabDetailsModel = new CabDetailsModel(this);
        ConsoleInput consoleInput = new ConsoleInput();
        scanner = consoleInput.getInstance();
        this.driverId = driverId;
    }
    public void init(){
        System.out.println("========== RIDEX ==========\n");
        System.out.println("Enter your cab details : \n");
        promptAction();
    }
    public void promptAction(){
        String registrationNumber = promptDriverID();
        String model = promptModel();
        String type = promptType();
        cabDetailsModel.storeData(driverId , registrationNumber , model , type);
    }

    public String promptDriverID(){
        while(true){
            try {
                System.out.print("Enter your Cab Registration number: ");
                scanner.nextLine();
                String id = scanner.nextLine();
                String error = cabDetailsModel.validateId(id);
                if (error == null) {
                    return id;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    String promptType(){
        while(true){
            try {
                System.out.print("Enter cab type: ");
                scanner.nextLine();
                String type = scanner.nextLine();
                String error = cabDetailsModel.validateType(type);

                if (error == null) {
                    return type;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    String promptModel(){
        while(true){
            try {
                System.out.print("Enter cab model: ");
                scanner.nextLine();
                String model = scanner.nextLine();
                String error = cabDetailsModel.validateModel(model);
                if (error == null) {
                    return model;
                }
                showErrorMessage(error);
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    void onSuccessful(){
        System.out.println("\nCab details added successfully!");
    }
    void showErrorMessage(String message){
        System.out.println(message);
    }
}
