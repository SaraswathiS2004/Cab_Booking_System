package com.zsgs.cabbooking.features.signin;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.features.driverdetails.DriverDetailsView;
import com.zsgs.cabbooking.features.home.HomeView;
import com.zsgs.cabbooking.util.ConsoleInput;
import com.zsgs.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class SignInView {

    private SignInModel signInModel;
    private Scanner scanner;
    private boolean authenticated;

    public SignInView(){
        signInModel = new SignInModel(this);
        ConsoleInput consoleInput = new ConsoleInput();
        scanner = consoleInput.getInstance();
    }

    public void init(){

        System.out.println("\nSign in to RideX!");
        while (!authenticated) {
            promptAndAuthenticate();
            if (authenticated) return;
            if (!promptPostFailureAction()) return;
        }
    }
    public void promptAndAuthenticate(){
        String email = promptEmailAddress();
        String password = promptPassword();
        signInModel.isAuthenticate(password , email);

    }
    public String promptPassword(){
        while(true){
            try {
                System.out.print("Enter the password : ");
                String password = scanner.next();
                String error = signInModel.validatePassword(password);
                if (error == null) {
                    return password;
                } else {
                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }
    public String promptEmailAddress(){
        while (true) {
            try {
                System.out.print("Enter the Email Address : ");
                String email = scanner.next();
                String error = signInModel.validateEmailAddress(email);
                if (error == null) {
                    return email.trim();
                } else {
                    showErrorMessage(error);
                }
            } catch (Exception e) {
                System.out.println("Enter Valid Input!");
            }
        }
    }


    public void onSignInSuccessful(AccountDetails accountDetails){
        authenticated = true;

        if(accountDetails.getRole().equals(Role.DRIVER)){
            System.out.print("Enter Your Driving Details : ");
           new DriverDetailsView().init();
        }
        else if(accountDetails.getRole().equals(Role.ADMIN)){
            new HomeView(accountDetails).init();
        }
        else if(accountDetails.getRole().equals(Role.USER)){
            new HomeView(accountDetails).init();
        }
    }
    public void onSignInFailed(String message){
        System.out.println(message);
    }

    public boolean promptPostFailureAction(){

        while(true){

            System.out.println();
            System.out.print("\n1. Retry");
            System.out.print("\n2. SignUp");
            System.out.print("\n3. Exit");
            System.out.print("\nChoose Your Option : ");
            String choice = scanner.next().trim();

            switch (choice){
                case "1":
                    return true;
                case "2":
                    new SignUpView().init();
                    return false;
                case "3":
                    System.out.println("Thank you for using RideX");
                    System.exit(0);
                    return false;
                default:
                    System.out.println("Invalid Option Please try again");
            }
        }
    }

    public void showErrorMessage(String message){
        System.out.println(message);
    }
}
