package com.zsgs.cabbooking.features.signin;

public class SignInModel {

    private SignInView signInView;

    public SignInModel(){
        signInView = new SignInView();
    }
    public void getSignIn(){
        signInView.showSignIn();
    }
}
