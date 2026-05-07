package com.ridex.cabbooking.features.admin.list.accountslist;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

class AccountsListModel {

    private AccountsListView accountsListView;
    private CabDB cabDB;
    public AccountsListModel(AccountsListView accountsListView){
        this.accountsListView = accountsListView;
        this.cabDB = CabDB.getInstance();
    }

    void getAccounts(){

        ArrayList<AccountDetails> accountDetails = cabDB.getAccounts();
        if(accountDetails.isEmpty()){
            accountsListView.onAccountFailed();
        }
        else {
            accountsListView.showAccounts(accountDetails);
        }
    }
}
