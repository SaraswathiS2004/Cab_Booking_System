package com.zsgs.cabbooking;

import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signin.SignInView;
import com.zsgs.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class CabBooking {

    public static void main(String[] args){
        System.out.println("Welcome to RideX");
        showMenu();
    }

    public static void showMenu(){
        Input input = new Input();
        Scanner scan = input.getInstance();

        String choice = "Y";
        do {
            System.out.println("1. SignUp");
            System.out.println("2. SignIn");
            System.out.println("Choose Your Option");

            String option = scan.next();
            switch (option) {
                case "1":
                    SignUpView signUpView = new SignUpView();
                    signUpView.init();
                    break;
                case "2":
                    SignInView signInView = new SignInView();
                    signInView.init();
                    break;
                default:
                    System.out.println("Choose a correct Option");
                    break;
            }
            System.out.println("Do you want to Continue(Y/N)");
            choice = scan.next();
        }
        while (choice.equalsIgnoreCase("Y"));
    }
}
