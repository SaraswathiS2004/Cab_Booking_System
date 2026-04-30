package com.zsgs.cabbooking;

import com.zsgs.cabbooking.data.dto.DriverDetails;
import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.admin.list.accountslist.AccountsListView;
import com.zsgs.cabbooking.features.driverdetails.DriverDetailsView;
import com.zsgs.cabbooking.features.home.HomeView;
import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.signin.SignInView;
import com.zsgs.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class CabBooking {

    public static void main(String[] args) {
        System.out.println("Welcome to RideX");
        showMenu();
    }
    public static void showMenu() {
        CabDB cabDB = CabDB.getInstance();
        Input input = new Input();
        Scanner scan = input.getInstance();

        String choice = "Y";
        do {
            if (cabDB.getAccounts().size() == 0) {
                System.out.print("1. SignUp");

            } else {
                System.out.print("\n1. SignUp");
                System.out.print("\n2. SignIn");

            }
            System.out.print("\nChoose Your Option : ");
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
                    System.out.print("\nChoose a correct Option");
                    break;
            }
            System.out.print("\nDo you want to Continue(Y/N)");
            choice = scan.next();
        }
        while (choice.equalsIgnoreCase("Y"));
    }
}