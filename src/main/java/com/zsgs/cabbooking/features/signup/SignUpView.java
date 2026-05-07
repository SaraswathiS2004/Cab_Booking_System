package com.zsgs.cabbooking.features.signup;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.util.ConsoleInput;

import com.zsgs.cabbooking.features.signin.SignInView;

import java.util.ArrayList;
import java.util.Scanner;

public class SignUpView {

    private SignUpModel signUpModel;
    private static Scanner scan;
    private ArrayList<AccountDetails> accountDetails;

    public SignUpView(){
        signUpModel = new SignUpModel(this);
        ConsoleInput consoleInput = new ConsoleInput();
        scan = consoleInput.getInstance();

    }
    public void init(){
        System.out.print("Create Your Account!");
        String name = promptName();
        String email = promptEmail();
        String password = promptPassword();
        String city = promptCity();
        String mobileNumber = promptMobileNumber();
        Role role = promptRole();
        accountDetails = signUpModel.storeData(name , password , email , city , mobileNumber , role);

        onSignUpSuccessful();
    }
    public void showSignUp(){

    }

    public String promptName(){

        while(true) {
            try {
                System.out.print("\nEnter Your Name : ");
                scan.nextLine();
                String name = scan.nextLine();
                String error = signUpModel.validateName(name);
                if (error == null) {
                    return name.trim();
                } else {
                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    public String promptPassword(){
        while(true){
            try {
                System.out.print("Enter the Password : ");
                String password = scan.next();
                String error = signUpModel.validatePassword(password);
                if (error == null) {
                    System.out.print("Enter Confirm Password : ");
                    String confirm = scan.next();
                    String error1 = signUpModel.validateConfirmPassword(password, confirm);
                    if (error1 == null) {
                        return password.trim();
                    } else {
                        showErrorMessage(error1);
                    }
                } else {

                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }
    public String promptEmail(){
        while(true){

            try {
                System.out.print("Enter the Email Address : ");
                String email = scan.next();
                String error = signUpModel.validateEmailAddress(email);
                if (error == null) {
                    boolean isTrue = signUpModel.checkIsEmailId(email);
                    if (isTrue) {
                        showErrorMessage("This Email Id Already Exist");
                        continue;
                    }
                    ;
                    return email.trim();
                } else {
                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    public Role promptRole(){
        boolean isAdmin = signUpModel.isAdmin();
        while(true) {
            try {
                if (isAdmin) {
                    return Role.ADMIN;
                } else {
                    System.out.print("Enter Your Role (USER , DRIVER) : ");
                }
                String role = scan.next();
                role = role.toUpperCase();
                String error = signUpModel.validateRole(role, isAdmin);
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
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    public String promptMobileNumber(){
        while(true) {

            try {
                System.out.print("Enter Your Mobile Number : ");
                String mobileNumber = scan.next();
                String error = signUpModel.validateMobileNumber(mobileNumber);
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
    public String promptCity(){
        while(true){
            try {
                System.out.print("Enter Your City : ");
                String city = scan.next();
                String error = signUpModel.validateCity(city);
                if (error == null) {
                    return city;
                } else {
                    showErrorMessage(error);
                }
            }
            catch (Exception e){
                System.out.println("Enter Valid Input!");
            }
        }
    }

    void onSignUpSuccessful(){
        System.out.print("\nAccount Created Successfully!");
        if(accountDetails.size() == 1){
            System.out.print("\nAs the first user in the system, you will be registered as a ADMIN.");
        }
        new SignInView().init();
    }
    void showErrorMessage(String error){
        System.out.println(error);
    }
}
