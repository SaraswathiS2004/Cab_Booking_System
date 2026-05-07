package com.ridex.cabbooking.features.home;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.dto.Role;

public class HomeModel {

    private HomeView homeView;
    HomeModel(HomeView homeView){
        this.homeView = homeView;
    }
    void init(AccountDetails accountDetails){
        if(accountDetails == null || accountDetails.getRole() == null){
            homeView.showUnAuthorized();
        }
        else if(accountDetails.getRole() == Role.ADMIN){
            homeView.showAdminMenu();
        }
        else if(accountDetails.getRole() == Role.USER) {
            homeView.showUserMenu();
        }

    }
}
