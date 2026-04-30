package com.zsgs.cabbooking.features.user.feedback;

import com.zsgs.cabbooking.data.dto.AccountDetails;
import com.zsgs.cabbooking.data.dto.Login;
import com.zsgs.cabbooking.data.dto.UserFeedBack;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.regex.Pattern;

public class FeedBackModel {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private FeedBackView feedBackView;
    private CabDB cabDB;

    public FeedBackModel(FeedBackView feedBackView) {
        this.feedBackView = feedBackView;
        this.cabDB = CabDB.getInstance();
    }

    String validateContent(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) return "FeedBack Cannot be empty.";
        return null;
    }
    long getFeedBackId(){
        return cabDB.getFeedBackId();
    }
    public void authenticate(Login login) {

        if (login == null) {
            feedBackView.onSignInFailed("Invalid email or password.");
            return;
        }
        String emailError = validateEmailAddress(login.getEmail());
        if (emailError != null) {
            feedBackView.onSignInFailed(emailError);
        }
        String passwordError = validatePassword(login.getPassword());
        if (passwordError != null) {
            feedBackView.onSignInFailed(passwordError);
            return;
        }

        AccountDetails accountDetails = cabDB.getEmployeeByEmail(login.getEmail(), login.getPassword());
        if (accountDetails == null) {
            feedBackView.showErrorMessage("Unable to sign in to your account.");
            feedBackView.showErrorMessage("Please try again.");
        } else {
            feedBackView.onSuccessful();
        }

    }

    String validateEmailAddress(String email) {
        String trimmed = email.trim();
        if (email == null || trimmed.isEmpty()) {
            return "Email address cannot be empty.";
        }
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            return "Invalid Email address";
        }
        return null;
    }

    String validatePassword(String password) {

        if (password == null || password.trim().isEmpty()) {
            return "Password Cannot be empty.";
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return "Password must be at least 8 characters and contain letters and numbers.";
        } else {
            return null;
        }
    }

    void isAuthenticate(String email, String password) {
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        authenticate(login);
    }

    void storeData(long id , String email , String password , String content){
        UserFeedBack userFeedBack = new UserFeedBack();
        userFeedBack.setId(id);
        userFeedBack.setEmail(email);
        userFeedBack.setPassword(password);
        userFeedBack.setFeedBackContent(content);
    }
}
