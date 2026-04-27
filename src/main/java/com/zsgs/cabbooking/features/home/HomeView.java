package com.zsgs.cabbooking.features.home;

import com.zsgs.cabbooking.CabBooking;
import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.features.admin.list.accountslist.AccountsListView;
import com.zsgs.cabbooking.features.admin.list.cablist.CabListModel;
import com.zsgs.cabbooking.features.admin.list.cablist.CabListView;
import com.zsgs.cabbooking.features.admin.list.driversList.DriversListView;
import com.zsgs.cabbooking.features.admin.list.userList.UserDetailsView;
import com.zsgs.cabbooking.features.input.Input;

import java.util.Scanner;

public class HomeView {
    private static Scanner scanner;
    private AccountDetails accountDetails;
    private HomeModel homeModel;
    public HomeView(AccountDetails accountDetails){
        this.accountDetails = accountDetails;
        scanner = new Input().getInstance();
        this.homeModel = new HomeModel(this);
    }
    public void init(){
        homeModel.init(accountDetails);
    }
    public void showUnAuthorized(){
        System.out.println("YOur Account role is not set");
    }

    void showAdminMenu(){

        while (true){
            System.out.println();
            System.out.println("1. Display Account Details");
            System.out.println("2. Display Driver Details");
            System.out.println("3. Display Cab Details");
            System.out.println("4. Display User Details");
            System.out.println("5. Log out");
            System.out.println("6. Exit");
            String choice = scanner.next();
            switch (choice){
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
                    new UserDetailsView().init();
                case "5":
                    CabBooking.showMenu();
                    System.exit(0);
                    break;
                case "6":
                    System.out.println("Thank you for using RideX");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option please ty again");
                    break;
            }
        }

    }

    void showUserMenu(){

    }

}
