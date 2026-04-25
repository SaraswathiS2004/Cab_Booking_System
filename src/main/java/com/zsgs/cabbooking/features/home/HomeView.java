package com.zsgs.cabbooking.features.home;

import com.zsgs.cabbooking.features.admin.list.driversList.DriversListView;
import com.zsgs.cabbooking.features.admin.list.userList.UserDetailsView;
import com.zsgs.cabbooking.features.input.Input;

import java.util.Scanner;

public class HomeView {
    private static Scanner scanner;

    public HomeView(){
        scanner = new Input().getInstance();
    }
    public void init(){

    }
    public static void showAdminMenu(){

        while (true){
            System.out.println();
            System.out.println("1. Display Driver Details");
            System.out.println("2. Display User Details");
            System.out.println("3. Exit");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    new DriversListView().init();
                    break;
                case "2":
                    new UserDetailsView().init();
                    break;
                case "3":
                    System.out.println("Thank you for using RideX");
                    break;
                default:
                    System.out.println("Invalid Option please ty again");
                    break;
            }
        }
    }

}
