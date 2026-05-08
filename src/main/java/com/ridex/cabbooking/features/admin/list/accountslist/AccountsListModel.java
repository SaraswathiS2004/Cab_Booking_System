package com.ridex.cabbooking.features.admin.list.accountslist;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class AccountsListModel {

    private AccountsListView accountsListView;
    private RideXDB rideXDB;
    public AccountsListModel(AccountsListView accountsListView){
        this.accountsListView = accountsListView;
        this.rideXDB = RideXDB.getInstance();
    }

    void getAccounts(){

        ArrayList<AccountDetails> accountDetails = rideXDB.getAccounts();
        if(accountDetails.isEmpty()){
            accountsListView.onAccountFailed();
        }
        else {
            accountsListView.showAccounts(accountDetails);
        }
    }
}
