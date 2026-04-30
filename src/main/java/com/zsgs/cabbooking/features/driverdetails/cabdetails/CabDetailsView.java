package com.zsgs.cabbooking.features.driverdetails.cabdetails;

import com.zsgs.cabbooking.features.input.Input;

import java.util.Scanner;

public class CabDetailsView {
    private CabDetailsModel cabDetailsModel;
    private Scanner scanner;
    public CabDetailsView(){
        this.cabDetailsModel = new CabDetailsModel(this);
        Input input = new Input();
        scanner = input.getInstance();
    }
    public void init(){
        System.out.println("========== RIDEX ==========\n");
        System.out.println("Enter your cab details\n");
        promptAction();
    }
    public void promptAction(){
        long registrationNumber = promptDriverID();
        String model = promptModel();
        String type = promptType();
        cabDetailsModel.storeData(registrationNumber , model , type);
    }

    public long promptDriverID(){
        while(true){
            System.out.print("Enter your registration number: ");
            long id = scanner.nextLong();
            String error = cabDetailsModel.validateId(id);
            if(error == null){
                return id;
            }
            showErrorMessage(error);
        }
    }

    String promptType(){
        while(true){
            System.out.print("Enter cab type: ");
            String type = scanner.nextLine();
            String error = cabDetailsModel.validateType(type);

            if(error == null){
                return type;
            }
            showErrorMessage(error);
        }
    }

    String promptModel(){
        while(true){
            System.out.print("Enter cab model: ");
            scanner.nextLine();
            String model = scanner.nextLine();
            String error = cabDetailsModel.validateModel(model);
            if(error == null){
                return model;
            }
            showErrorMessage(error);
        }
    }

    void onSuccessful(){
        System.out.println("\nCab details added successfully!");
    }
    void showErrorMessage(String message){
        System.out.println(message);
    }
}
