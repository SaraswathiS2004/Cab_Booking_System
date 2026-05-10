package com.ridex.cabbooking;

import com.ridex.cabbooking.data.repository.database.RideXDB;
import com.ridex.cabbooking.util.ConsoleInput;
import com.ridex.cabbooking.features.signin.SignInView;
import com.ridex.cabbooking.features.signup.SignUpView;

import java.util.Scanner;

public class RideX {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to RideX");
        showMenu();
    }

    public static void showMenu() {
        ConsoleInput consoleInput = new ConsoleInput();
        Scanner scan = consoleInput.getInstance();
        while (true) {
            try {
                boolean isAdmin = new RideXDB().isAdmin();
                if (isAdmin) {
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
            } catch (Exception e) {
                System.out.println("Enter Valid Input!");
            }
        }
    }
}