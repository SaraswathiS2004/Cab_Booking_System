package com.zsgs.cabbooking.features.signup;

import com.zsgs.cabbooking.features.signin.SignInView;

public class SignUpModel {

    private SignUpView signUpView;

    public SignUpModel() {
        signUpView = new SignUpView();
    }

    public void getSignUp(){
        signUpView.showSignUp();
    }
}