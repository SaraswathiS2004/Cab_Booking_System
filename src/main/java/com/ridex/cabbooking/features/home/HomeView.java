package com.ridex.cabbooking.features.home;

import com.ridex.cabbooking.RideX;
import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.features.admin.list.accountslist.AccountsListView;
import com.ridex.cabbooking.features.admin.list.cablist.CabListView;
import com.ridex.cabbooking.features.admin.list.cabspositionlist.CabsPositionListView;
import com.ridex.cabbooking.features.admin.list.driversList.DriversListView;
import com.ridex.cabbooking.features.admin.list.eachcabearnings.TotalEarningsView;
import com.ridex.cabbooking.features.admin.list.feedbacklist.FeedBackListView;
import com.ridex.cabbooking.features.admin.list.usertriplist.UserTripDetailsView;
import com.ridex.cabbooking.features.user.availablecabs.AvailableCabsView;
import com.ridex.cabbooking.util.ConsoleInput;
import com.ridex.cabbooking.features.user.feedback.FeedBackView;
import com.ridex.cabbooking.features.user.traveldetails.TravelDetailsView;

import java.util.Scanner;

public class HomeView {
    private static Scanner scanner;
    private AccountDetails accountDetails;
    private HomeModel homeModel;

    public HomeView(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
        scanner = new ConsoleInput().getInstance();
        this.homeModel = new HomeModel(this);
    }

    public void init() {

        System.out.println("\nWelcome to RideX");

        homeModel.init(accountDetails);
    }

    public void showUnAuthorized() {
        System.out.println("Your Account role is not set");
    }

    void showAdminMenu() {

        while (true) {
            System.out.println("\n========== ADMIN DASHBOARD ==========\n");

            System.out.println("1. View Account Details");
            System.out.println("2. View Driver Details");
            System.out.println("3. View Cab Details");
            System.out.println("4. View User Details");
            System.out.println("5. View FeedBack Details");
            System.out.println("6. View Cabs Total Earnings");
            System.out.println("7. View Cabs Current Position");
            System.out.println("8. Logout");
            System.out.println("9. Exit");
            System.out.println("Choose Your Option : ");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    new AccountsListView().init();
                    break;
                case "2":
                    new DriversListView().init();
                    break;
                case "3":
                    new CabListView().init();
                    break;
                case "4":
                    new UserTripDetailsView().init();
                    break;
                case "5":
                    new FeedBackListView().init();
                    break;
                case "6":
                    new TotalEarningsView().init();
                    break;
                case "7":
                    new CabsPositionListView().init();
                    break;
                case "8":
                    RideX.showMenu();
                    System.exit(0);
                    break;
                case "9":
                    System.out.println("Thank you for using RideX");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option please try again");
                    break;
            }
        }

    }

    void showUserMenu() {

        while (true) {

            System.out.println("\n========== USER DASHBOARD ==========\n");

            System.out.println("1. Enter Travel Details");
            System.out.println("2. Check Available Cabs and Drivers");
            System.out.println("3. Feed back Upload");
            System.out.println("4. Log Out");
            System.out.println("5. Exit");
            System.out.print("Choose Your Option : ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    new TravelDetailsView(accountDetails).init();
                    break;
                case "2":
                    new AvailableCabsView().init();
                    break;
                case "3":
                    new FeedBackView().init();
                    break;
                case "4":
                    RideX.showMenu();
                    System.exit(0);
                    break;
                case "5":
                    System.out.println("Thank You for using RideX");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Please Try Again!");
                    break;
            }
        }
    }

}
