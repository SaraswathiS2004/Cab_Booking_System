package com.zsgs.cabbooking.features.user.feedback;


import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class FeedBackView {

    private FeedBackModel feedBackModel;
    private Scanner scanner;
    private boolean authenticated;

    public FeedBackView(){
        this.feedBackModel = new FeedBackModel(this);
        this.scanner = new Input().getInstance();
    }

    public void init(){
        System.out.println("Welcome to RideX");

        while (!authenticated) {
            promptAndAuthenticate();
            if (authenticated) return;
            if (!promptPostFailureAction()) return;
        }
    }
    public void promptAndAuthenticate(){
        long id = feedBackModel.getFeedBackId();
        String email = promptEmailAddress();
        String password = promptPassword();
        String feedBack = promptFeedBack();
        feedBackModel.isAuthenticate(email , password);
        feedBackModel.storeData(id ,email , password , feedBack);
    }

    String promptFeedBack() {

        while (true) {
            System.out.println("Enter Your Feed Back : ");
            String content = scanner.nextLine();
            String error = feedBackModel.validateContent(content);
            if (error == null) {
                return content;
            }
            showErrorMessage(error);
        }
    }

    String promptEmailAddress(){
        while(true){
            System.out.println("Enter the Email Address");
            String email = scanner.next();
            String error = feedBackModel.validateEmailAddress(email);
            if(error == null){
                return email.trim();
            }
            else {
                showErrorMessage(error);
            }
        }
    }
    public String promptPassword(){
        while(true){
            System.out.println("Enter the password");
            String password = scanner.next();
            String error = feedBackModel.validatePassword(password);
            if(error == null){
                return password;
            }
            else {
                showErrorMessage(error);
            }
        }
    }

    public boolean promptPostFailureAction() {

        while (true) {
            System.out.println();
            System.out.println("1. Retry");
            System.out.println("2. SignUp");
            System.out.println("3. Exit");
            String choice = scanner.next().trim();

            switch (choice) {
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
    public void onSuccessful() {
        authenticated = true;
    }
    public void onFeedBackAddedSuccessful(){
        System.out.println("Successfully Added Your Feed Back!");
    }

    public void onSignInFailed(String message){
        System.out.println(message);
    }
    void showErrorMessage(String message){
        System.out.println(message);
    }

}
