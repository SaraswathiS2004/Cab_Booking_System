package com.ridex.cabbooking.features.signup;

import com.ridex.cabbooking.data.dto.AccountDetails;
import com.ridex.cabbooking.data.dto.Role;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.regex.Pattern;

class SignUpModel {

    private SignUpView signUpView;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

    private RideXDB rideXDB;


    public SignUpModel(SignUpView signUpView) throws SQLException, ClassNotFoundException {
        this.signUpView = signUpView;
        this.rideXDB = new RideXDB();
    }

    public boolean isAdmin() throws SQLException, ClassNotFoundException {

        boolean isAdmin = new RideXDB().isAdmin();
        return isAdmin;
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

    public boolean checkIsEmailId(String email) throws SQLException, ClassNotFoundException {
        String message = new RideXDB().checkIsAlreadyExistEmailId(email);
        if (message == null) {
            return false;
        }
        return true;
    }

    public void storeData(String name, String password, String email, String city, String mobileNumber, Role role) throws SQLException, ClassNotFoundException {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.registerPeople(name, password, email, city, mobileNumber, role);
        rideXDB.storeAccount(accountDetails);
        boolean isFirstUser = rideXDB.getAccountList().size() == 1;
        signUpView.onSignUpSuccessful(isFirstUser);
    }
}