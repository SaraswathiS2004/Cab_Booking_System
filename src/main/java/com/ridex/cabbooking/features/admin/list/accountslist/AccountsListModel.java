package com.ridex.cabbooking.features.admin.list.accountslist;

import com.ridex.cabbooking.RideX;
import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.repository.CabDB;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class AccountsListModel {

    private AccountsListView accountsListView;
    private CabDB cabDB;
    public AccountsListModel(AccountsListView accountsListView){
        this.accountsListView = accountsListView;
        this.cabDB = CabDB.getInstance();
    }

    void getAccounts() throws SQLException, ClassNotFoundException {

//        ArrayList<AccountDetails> accountDetails = cabDB.getAccounts();
        ArrayList<AccountDetails> accountDetails = new RideXDB().getAccountList();
        if(accountDetails.isEmpty()){
            accountsListView.onAccountFailed();
        }
        else {
            accountsListView.showAccounts(accountDetails);
        }
    }
}
