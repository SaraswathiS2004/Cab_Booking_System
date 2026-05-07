package com.zsgs.cabbooking.data.repository;

import com.zsgs.cabbooking.data.dto.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CabDB {

    private static CabDB cabDB;
    private static long peopleId = 1;
    private static long driverId = 1;
    private static long cabId = 1;
    private static long tripId = 1;
    private static long feedBackId = 1;
    private CabDB(){}
    public long getDriverId() {
        return driverId;
    }
    public long getCabId(){
         return cabId;
    }
    public long getFeedBackId(){
         return feedBackId;
    }
     private static ArrayList<AccountDetails> accountDetails = new ArrayList<>();
     private static ArrayList<DriverDetails> driverDetails = new ArrayList<>();
     private static ArrayList<CabDetails> cabDetails = new ArrayList<>();
     private static ArrayList<UserTripDetails> userTripDetails = new ArrayList<>();
     private static ArrayList<UserFeedBack> userFeedBacks = new ArrayList<>();
     private static ArrayList<CabCurrentPosition> cabsPosition = new ArrayList<>();

    public static ArrayList<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    public static CabDB getInstance(){
         if(cabDB == null){
             cabDB = new CabDB();
         }
         return cabDB;
     }
     public void addAccount(AccountDetails accountDetails){


         CabDB.accountDetails.add(accountDetails);
         peopleId++;
     }
     public void addTripDetails(UserTripDetails userTripDetails){
        long cabId = userTripDetails.getCabId();
        for(CabCurrentPosition cabCurrentPosition : cabsPosition){
            if(cabCurrentPosition.getCabId() == cabId){
                cabCurrentPosition.setPosition(userTripDetails.getDropUp());
                userTripDetails.setStatus(TripStatus.DROPPED);
            }
        }

        cabDB.userTripDetails.add(userTripDetails);

         tripId++;
     }
     public void addFeedBack(UserFeedBack userFeedBack){
        CabDB.userFeedBacks.add(userFeedBack);
         feedBackId++;
     }

     public void setCabEarnings(long cabId , int earnings){
        for(CabDetails cabDetails1 : cabDetails){
            if(cabDetails1.getCabId() == cabId){
                cabDetails1.setTotalEarning(cabDetails1.getTotalEarning() + earnings);
            }
        }
     }
    public ArrayList<AccountDetails> getAccounts(){
        return accountDetails;
    }

    public void addDriver(DriverDetails driverDetails){

        CabDB.driverDetails.add(driverDetails);
        driverId++;
    }
    public ArrayList<DriverDetails> getDriverDetails(){
        return driverDetails;
    }
    public void addCab(CabDetails cabDetails){
        cabDB.cabDetails.add(cabDetails);
        cabId++;
    }
    public void addCabPosition(CabCurrentPosition cabCurrentPosition){
        cabDB.cabsPosition.add(cabCurrentPosition);
    }
    public ArrayList<CabDetails> getCabDetails(){
        return cabDetails;
    }
    public ArrayList<UserFeedBack> getUserFeedBacks(){
        return userFeedBacks;
    }
    public ArrayList<CabCurrentPosition> getCabsPosition(){
        return cabsPosition;
    }
    public AccountDetails getEmployeeByEmail(String email , String password){
        if (email == null){
            return null;
        }
        if(email.isEmpty()) return null;
        for(AccountDetails current : accountDetails){
            if(current.getEmail() != null && current.getEmail().equals(email) && current.getPassword().equals(password)){
                return current;
            }
        }
        return null;
    }
    public long getPeopleId(){
        return peopleId;
    }

    public String  checkIsAlreadyExistEmailId(String email){
        for(AccountDetails accountDetails1 : accountDetails){
            if(accountDetails1.getEmail().equals(email)){
                return "This Email id Already Exist";
            }
        }
        return null;
    }

    public String getDriverName(long id){
        for(AccountDetails accountDetails1 : accountDetails){
            if(accountDetails1.getId() == id){
                return accountDetails1.getName();
            }
        }
        return null;
    }

    public ArrayList<UserTripDetails> getUserTripDetails(){
        return userTripDetails;
    }

}
