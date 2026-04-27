package com.zsgs.cabbooking;

import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.admin.list.accountslist.AccountsListView;
import com.zsgs.cabbooking.features.driverdetails.DriverDetailsView;
import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signin.SignInView;
import com.zsgs.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class CabBooking {

    public static void main(String[] args) {
        System.out.println("Welcome to RideX");
        showMenu();
    }
//    public static void showMenu(){
//        new AccountsListView().init();
//    }


    public static void showMenu() {
        CabDB cabDB = CabDB.getInstance();
        Input input = new Input();
        Scanner scan = input.getInstance();

        String choice = "Y";
        do {
            if (cabDB.getAccounts().size() == 0) {
                System.out.println("1. SignUp");
                System.out.println("Choose Your Option");
            } else {
                System.out.println("1. SignUp");
                System.out.println("2. SignIn");
            }

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