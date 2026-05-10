package com.ridex.cabbooking.features.user.traveldetails;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.dto.CabDetails;
import com.ridex.cabbooking.data.dto.TripStatus;
import com.ridex.cabbooking.util.ConsoleInput;
import com.ridex.cabbooking.features.signin.SignInView;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelDetailsView {

    private TravelDetailsModel travelDetailsModel;
    private AccountDetails accountDetails;
    private Scanner scanner;

    public TravelDetailsView(AccountDetails accountDetails) throws SQLException, ClassNotFoundException {
        this.travelDetailsModel = new TravelDetailsModel(this);
        ConsoleInput consoleInput = new ConsoleInput();
        this.scanner = consoleInput.getInstance();
        this.accountDetails = accountDetails;
    }

    public void init() throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to RideX\n");
        promptTravelDetails();
    }

    void promptTravelDetails() throws SQLException, ClassNotFoundException {
        ArrayList<CabDetails> cabDetails = travelDetailsModel.getAvailableCabs();
        if (cabDetails.size() == 0) {
            showErrorMessage("No cabs are available in this moment");
            promptPostFailureAction();
        } else {
            String pickUp = promptPickUpPoint();
            String dropUp = promptDropUpPoint(pickUp);
            LocalDateTime pickupTiming = LocalDateTime.now();
            LocalDateTime dropupTiming = travelDetailsModel.getDropTiming(pickUp, dropUp);
            long cabId = travelDetailsModel.getCabs(pickUp);
            showCabs("Your Cab Id is : " + cabId);
            TripStatus tripStatus = TripStatus.BOOKED;
            int payment = promptPayAmount(pickUp, dropUp);
            travelDetailsModel.setCabEarnings(cabId, payment);
            AccountDetails currentUser = accountDetails;
            LocalDate pick_up_date = pickupTiming.toLocalDate();
            LocalDate drop_up_date = dropupTiming.toLocalDate();
            travelDetailsModel.storeData(pickUp, dropUp, pickupTiming.toLocalTime(), dropupTiming.toLocalTime(), pick_up_date, drop_up_date, cabId, tripStatus, currentUser, payment, accountDetails.getId());
        }
    }

    void onDetailsUploadedSuccessful() {
        System.out.println("\nTrip details uploaded successfully!");
        System.out.println("Thank you for using RideX!");
    }

    int promptPayAmount(String pickUp, String dropUp) {
        System.out.println("\n========== PAYMENT ==========");
        System.out.println("Please pay for your trip.");
        int money = travelDetailsModel.calculateMoney(pickUp, dropUp);
        System.out.println("Total Cost : " + money);
        int amount = promptGetAmount(money);
        return amount;
    }

    int promptGetAmount(int money) {

        while (true) {
            System.out.print("Enter payment amount: ");
            int amount = scanner.nextInt();
            String error = travelDetailsModel.validateAmount(money, amount);
            if (error == null) {
                return amount;
            }
            showErrorMessage(error);
        }
    }

    void showCabs(String message) {
        System.out.println(message);
    }

    void promptPostFailureAction() throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.println("\n========== OPTIONS ==========");
            System.out.println("1. Sign In");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    new SignInView().init();
                    break;
                case "2":
                    System.out.println("\nThank you for using RideX.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    long promptCabId(ArrayList<CabDetails> cabDetails) {

        while (true) {
            System.out.print("Enter Cab ID: ");
            long cabId = scanner.nextLong();
            String error = travelDetailsModel.validateCabId(cabDetails, cabId);
            if (error == null) {
                return cabId;
            } else {
                showErrorMessage(error);
            }
        }

    }

    String promptPickUpPoint() {

        while (true) {
            System.out.print("Enter pickup location (A, B, C, D, E , F): ");
            String pickUp = String.valueOf(scanner.next()).toUpperCase();
            String error = travelDetailsModel.validatePickUpPlace(pickUp);
            if (error == null) {
                return pickUp;
            } else {
                showErrorMessage(error);
            }
        }
    }

    String promptDropUpPoint(String pickUp) {

        while (true) {
            System.out.print("Enter drop location (A, B, C, D, E, F): ");
            String dropUp = scanner.next().toUpperCase();
            String error = travelDetailsModel.validateDropUpPlace(pickUp, dropUp);
            if (error == null) {
                return dropUp;
            } else {
                showErrorMessage(error);
            }
        }
    }

    void showErrorMessage(String message) {
        System.out.println(message);
    }

}
