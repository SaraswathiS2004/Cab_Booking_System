package com.zsgs.cabbooking.data.repository;

import com.zsgs.cabbooking.data.dto.AccountDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CabDB {

    private static CabDB cabDB;
     private CabDB(){

     }
     private static ArrayList<AccountDetails> accountDetails = new ArrayList<>();

    public static ArrayList<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    public static void setAccountDetails(ArrayList<AccountDetails> accountDetails) {
        CabDB.accountDetails = accountDetails;
    }

    public static CabDB getInstance(){
         if(cabDB == null){
             cabDB = new CabDB();
         }
         return cabDB;
     }
     public void addAccount(AccountDetails accountDetails){
         CabDB.accountDetails.add(accountDetails);
     }
     public ArrayList<AccountDetails> getAccounts(){
        return accountDetails;
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
}
