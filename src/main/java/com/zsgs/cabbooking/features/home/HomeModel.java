package com.zsgs.cabbooking.features.home;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;

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
        else {
            homeView.showUserMenu();
        }

    }
}
