package com.zsgs.cabbooking.features.admin.list.accountslist;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.repository.CabDB;

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
