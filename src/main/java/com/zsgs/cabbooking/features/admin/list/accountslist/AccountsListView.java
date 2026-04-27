package com.zsgs.cabbooking.features.admin.list.accountslist;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;

import java.util.ArrayList;

public class AccountsListView {

    private AccountsListModel accountsListModel;

    public AccountsListView(){
        this.accountsListModel = new AccountsListModel(this);
    }
    public void init(){


       accountsListModel.getAccounts();
    }

    void showAccounts(ArrayList<AccountDetails> accountDetails){
        System.out.println("Account List");
        for(AccountDetails accountDetails1 : accountDetails){
            System.out.println("Id : "+ accountDetails1.getId()+" Name : "+ accountDetails1.getName() + " password : "+ accountDetails1.getPassword() +" Email : "+
                    accountDetails1.getEmail() + " Role : "+ accountDetails1.getRole() +" Mobile_number : "+accountDetails1.getMobileNumber());
        }
    }
    void onAccountFailed(){
        System.out.println("There are No Account");
    }
}
