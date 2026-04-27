package com.zsgs.cabbooking.features.signin;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Login;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.regex.Pattern;

class SignInModel {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private SignInView signInView;
    private CabDB cabDB;

    public SignInModel(SignInView signInView){
        this.signInView = signInView;
        cabDB = CabDB.getInstance();
    }
    public void authenticate(Login login){

        if(login == null){
            signInView.onSignInFailed("Invalid email or password");
            return;
        }
        String emailError = validateEmailAddress(login.getEmail());
        if(emailError != null){
            signInView.onSignInFailed(emailError);
        }
        String passwordError = validatePassword(login.getPassword());
        if(passwordError != null){
            signInView.onSignInFailed(passwordError);
            return;
        }

        AccountDetails accountDetails = cabDB.getEmployeeByEmail(login.getEmail() , login.getPassword());
        if(accountDetails == null) {
            signInView.showErrorMessage("You cannot Sign in Your Account");
            signInView.showErrorMessage("Please try again");
        }
        else{
            signInView.onSignInSuccessful(accountDetails);
        }

    }
    public void isAuthenticate(String password , String email){

        Login login = new Login();
        login.setPassword(password);
        login.setEmail(email);
        authenticate(login);

    }

    String validateEmailAddress(String email){
        String trimmed = email.trim();
        if(email == null || trimmed.isEmpty()){
            return "Email address cannot be empty";
        }
        if(!EMAIL_PATTERN.matcher(trimmed).matches()){
            return "Enter Valid Email address";
        }
        return null;
    }
    String validatePassword(String password) {

        if (password == null || password.trim().isEmpty()) {
            return "Password Cannot be Empty";
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return "Password must be at least 8 characters and contain letters and numbers";
        } else {
            return null;
        }
    }
}
