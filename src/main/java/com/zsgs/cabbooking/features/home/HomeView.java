package com.zsgs.cabbooking.features.home;

import com.zsgs.cabbooking.CabBooking;
import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.features.admin.list.accountslist.AccountsListView;
import com.zsgs.cabbooking.features.admin.list.cablist.CabListView;
import com.zsgs.cabbooking.features.admin.list.driversList.DriversListView;
import com.zsgs.cabbooking.features.admin.list.usertriplist.UserTripDetailsView;
import com.zsgs.cabbooking.features.user.availablecabs.AvailableCabsView;
import com.zsgs.cabbooking.features.input.Input;
import com.zsgs.cabbooking.features.user.availablecabs.AvailableCabsView;
import com.zsgs.cabbooking.features.user.feedback.FeedBackView;
import com.zsgs.cabbooking.features.user.traveldetails.TravelDetailsView;

import java.util.Scanner;

public class HomeView {
    private static Scanner scanner;
    private AccountDetails accountDetails;
    private HomeModel homeModel;

    public HomeView(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
        scanner = new Input().getInstance();
        this.homeModel = new HomeModel(this);
    }

    public void init() {

        System.out.println("\nWelcome to " + accountDetails.getName() + " !");

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
            System.out.println("5. Logout");
            System.out.println("6. Exit");
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
                case "5":
                    CabBooking.showMenu();
                    System.exit(0);
                    break;
                case "6":
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
                    CabBooking.showMenu();
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
