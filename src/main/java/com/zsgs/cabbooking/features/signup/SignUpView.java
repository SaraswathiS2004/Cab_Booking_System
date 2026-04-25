package com.zsgs.cabbooking.features.signup;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.features.input.Input;

import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signin.SignInView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SignUpView {

    private SignUpModel signUpModel;
    private static Scanner scan;

    public SignUpView(){
        signUpModel = new SignUpModel(this);
        Input input = new Input();
        scan = input.getInstance();

    }
    public void init(){
        System.out.println("Create Your Account");
        String name = promptName();
        String password = promptPassword();
        String email = promptEmail();
        String city = promptCity();
        String mobileNumber = promptMobileNumber();
        Role role = promptRole();
        ArrayList<AccountDetails> accountDetails = signUpModel.storeData(name , password , email , city , mobileNumber , role);
//        System.out.println("Name   Password   email      mobileNumber     role");
        if(accountDetails.size() == 1){
            System.out.println("As the first user in the system, you will be registered as a ADMIN.");
        }
        onSignUpSuccessful();
    }
    public void showSignUp(){

    }

    public String promptName(){

        while(true) {
            System.out.println("Enter Your Name");
            String name = scan.next();
            String error = signUpModel.validateName(name);
            if(error == null){
                return name.trim();
            }
            else {
                showErrorMessage(error);
            }
        }
    }

    public String promptPassword(){
        while(true){
            System.out.println("Enter the Password");
            String password = scan.next();
            String error = signUpModel.validatePassword(password);
            if(error == null){
                System.out.println("Enter Confirm Password");
                String confirm = scan.next();
                String error1 = signUpModel.validateConfirmPassword(password , confirm);
                if(error1 == null){
                    return password.trim();
                }
                else {
                    showErrorMessage(error1);
                }
            }
            else {

                showErrorMessage(error);
            }
        }
    }
    public String promptEmail(){
        while(true){
            System.out.println("Enter the Email Address");
            String email = scan.next();
            String error = signUpModel.validateEmailAddress(email);
            if(error == null){
                boolean isTrue = signUpModel.checkIsEmailId(email);
                if(isTrue) {
                    showErrorMessage("This Email Id Already Exist");
                    continue;
                };
                return email.trim();
            }
            else {
                showErrorMessage(error);
            }
        }
    }

    public Role promptRole(){
        boolean isAdmin = signUpModel.isAdmin();
        while(true) {
            if(isAdmin) {
                return Role.ADMIN;
            }
            else {
                System.out.println("Enter Your Role (USER , DRIVER)");
            }
            String role = scan.next();
            role = role.toUpperCase();
            String error = signUpModel.validateRole(role , isAdmin);
            Role res;
            if (error == null) {
                if (role.equals("ADMIN")) {
                    res = Role.ADMIN;
                } else if (role.equals("DRIVER")) {
                    res = Role.DRIVER;
                } else {
                    res = Role.USER;
                }
                return res;
            } else {
                showErrorMessage(error);
            }
        }
    }

    public String promptMobileNumber(){
        while(true) {
            System.out.println("Enter Your Mobile Number");
            String mobileNumber = scan.next();
            String error = signUpModel.validateMobileNumber(mobileNumber);
            if (error == null) {
                return mobileNumber;
            } else {
                showErrorMessage(error);
            }
        }
    }
    public String promptCity(){
        while(true){
            System.out.println("Enter Your City");
            String city = scan.next();
            String error = signUpModel.validateCity(city);
            if(error == null){
                return city;
            }
            else {
                showErrorMessage(error);
            }
        }
    }

    void onSignUpSuccessful(){
        System.out.println("Account Created Successfully");
        System.out.println("Please Sign in to continue");
        new SignInView().init();
    }
    void showErrorMessage(String error){
        System.out.println(error);
    }
}
