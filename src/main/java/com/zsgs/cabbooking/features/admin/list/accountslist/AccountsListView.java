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
        System.out.println("Account List:");
        System.out.println("--------------------------------------------------------------------------");

        System.out.printf("%-5s %-10s %-12s %-25s %-10s %-15s%n",
                "ID", "Name", "Password", "Email", "Role", "Mobile");

        System.out.println("--------------------------------------------------------------------------");

        for (AccountDetails acc : accountDetails) {
            System.out.printf("%-5d %-10s %-12s %-25s %-10s %-15s%n",
                    acc.getId(),
                    acc.getName(),
                    acc.getPassword(),
                    acc.getEmail(),
                    acc.getRole(),
                    acc.getMobileNumber());
        }
    }
    void onAccountFailed(){
        System.out.println("There are No Account");
    }
}
