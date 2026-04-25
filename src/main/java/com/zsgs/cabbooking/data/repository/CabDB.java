package com.zsgs.cabbooking.data.repository;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.CabDetails;
import com.zsgs.cabbooking.data.dto.DriverDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CabDB {

    private static CabDB cabDB;
    private static long peopleId = 1;
    private static long driverId = 1;
    private static long cabId = 1;
     private CabDB(){

     }
    public long getDriverId() {
        return driverId;
    }
    public long getCabId(){
         return cabId;
    }

     private static ArrayList<AccountDetails> accountDetails = new ArrayList<>();
     private static ArrayList<DriverDetails> driverDetails = new ArrayList<>();
     private static ArrayList<CabDetails> cabDetails = new ArrayList<>();

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

    public ArrayList<AccountDetails> getAccounts(){
        return accountDetails;
    }


    public void addDriver(DriverDetails driverDetails){

        CabDB.driverDetails.add(driverDetails);
        driverId++;
    }
    public ArrayList<DriverDetails> getDriver(){
        return driverDetails;
    }
    public void addCab(CabDetails cabDetails){
        cabDB.cabDetails.add(cabDetails);
        cabId++;
    }
    public ArrayList<CabDetails> getCabDetails(){
        return cabDetails;
    }

    public AccountDetails getEmployeeByEmail(String email){
        if (email == null){
            return null;
        }
        String key =email.trim();
        if(key.isEmpty()) return null;
        for(AccountDetails current : accountDetails){
            if(current.getEmail() != null && current.getEmail().equals(key)){
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
}
