package com.zsgs.cabbooking;

import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.consoleinput.Input;
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

            while (true) {
                try {
                    if (cabDB.getAccounts().size() == 0) {
                        System.out.print("1. SignUp");

                    } else {
                        System.out.print("\n1. SignUp");
                        System.out.print("\n2. SignIn");
                        System.out.print("\n3. Exit");
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
                        case "3":
                            System.out.println("Thank You For Using RideX!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nChoose a correct Option");
                            break;
                    }
                }
                catch (Exception e){
                    System.out.println("Enter Valid Input!");
                }
            }
    }
}