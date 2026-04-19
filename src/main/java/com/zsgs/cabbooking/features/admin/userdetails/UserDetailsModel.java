package com.zsgs.cabbooking.features.admin.userdetails;

class UserDetailsModel {

    private UserDetailsView userDetailsView;

    public UserDetailsModel(){
        userDetailsView = new UserDetailsView();
    }

    public void getUserDetails(){
        userDetailsView.showUserDetails();
    }
}
