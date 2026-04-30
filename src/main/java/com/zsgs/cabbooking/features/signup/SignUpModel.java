package com.zsgs.cabbooking.features.signup;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Role;
import com.zsgs.cabbooking.data.repository.CabDB;
import com.zsgs.cabbooking.features.signin.SignInView;

import java.util.ArrayList;
import java.util.regex.Pattern;

class SignUpModel {

    private SignUpView signUpView;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

    private CabDB cabDB;

    public boolean isAdmin() {

        cabDB = CabDB.getInstance();
        ArrayList<AccountDetails> accountDetails = cabDB.getAccounts();
        int size = accountDetails.size();
        if (size == 0) {
            return true;
        }
        return false;
    }

    public SignUpModel(SignUpView signUpView) {
        this.signUpView = signUpView;
        cabDB = CabDB.getInstance();
    }

    public void getSignUp() {
        signUpView.showSignUp();
    }

    String validateName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return "Name Cannot be Empty";
        } else if (name.length() < 3 || name.length() > 30) {
            return "Name must be between 3 to 30 Characters";
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

    String validateEmailAddress(String email) {
        String trimmed = email.trim();
        if (email == null || trimmed.isEmpty()) {
            return "Email address cannot be empty";
        }
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            return "Invalid Email address";
        }
        return null;
    }

    String validateRole(String role, boolean isAdmin) {
        if (isAdmin && !role.equals("ADMIN") && (role.equals("DRIVER") || role.equals("USER"))) {
            return null;
        } else if (role.equals("ADMIN") || role.equals("DRIVER") || role.equals("USER")) {
            return null;
        } else {
            return "Enter Valid Role";
        }
    }

    String validateMobileNumber(String mobileNumber) {

        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            return "Mobile number cannot be empty";
        }
        if (!MOBILE_PATTERN.matcher(mobileNumber.trim()).matches()) {
            return "Enter a valid 10 digit mobile number";
        }
        return null;
    }

    String validateCity(String city) {

        city = city.trim();
        if (city == null || city.isEmpty()) {
            return "City Name Cannot be Empty";
        } else if (city.length() < 3) {
            return "City Name must be minimum 3 Charcaters";
        }
        return null;
    }

    public String validateConfirmPassword(String password1, String password2) {
        if (password1.equals(password2)) return null;
        else {
            return "Password do not Match";
        }
    }

    public boolean checkIsEmailId(String email) {
        String message = cabDB.checkIsAlreadyExistEmailId(email);
        if (message == null) {
            return false;
        }
        return true;
    }

    public ArrayList<AccountDetails> storeData(String name, String password, String email, String city, String mobileNumber, Role role) {
        AccountDetails accountDetails = new AccountDetails();
        long id = cabDB.getPeopleId();
        accountDetails.registerPeople(name, password, email, city, mobileNumber, role, id);
        CabDB cabDB = CabDB.getInstance();
        cabDB.addAccount(accountDetails);
        ArrayList<AccountDetails> accounts = cabDB.getAccounts();
        return accounts;
    }
}