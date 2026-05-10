package com.ridex.cabbooking.features.admin.list.accountslist;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class AccountsListModel {

    private AccountsListView accountsListView;
//    private CabDB cabDB;

    private RideXDB rideXDB;

    public AccountsListModel(AccountsListView accountsListView) throws SQLException, ClassNotFoundException {
        this.accountsListView = accountsListView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }

    void getAccounts() throws SQLException, ClassNotFoundException {

//        ArrayList<AccountDetails> accountDetails = cabDB.getAccounts();
        ArrayList<AccountDetails> accountDetails = rideXDB.getAccountList();
        if (accountDetails.isEmpty()) {
            accountsListView.onAccountFailed();
        } else {
            accountsListView.showAccounts(accountDetails);
        }
    }
}
