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
        for (AccountDetails acc : accountDetails) {
            System.out.println("User Id :" + acc.getId() + "  Name : " + acc.getName()+ "  Email Id : " +
                    acc.getEmail() + "  Role : "+ acc.getRole() + "  Mobile Number : "+ acc.getMobileNumber() + "  City : "+ acc.getCity());
        }

        System.out.println("--------------------------------------------------------------------------------");

    }
    void onAccountFailed(){
        System.out.println("There are No Account");
    }
}
