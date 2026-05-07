package com.ridex.cabbooking.features.admin.list.feedbacklist;

import com.ridex.cabbooking.data.dto.UserFeedBack;

import java.util.ArrayList;

public class FeedBackListView {

    private FeedBackListModel feedBackListModel;
    public FeedBackListView(){
        this.feedBackListModel = new FeedBackListModel(this);
    }

    public void init(){
        feedBackListModel.getFeedBacks();
    }

    public void showFailedUserFeedBack(String message){
        System.out.println(message);
    }
    public void showSuccessfulFeedBacks(ArrayList<UserFeedBack> userFeedBacks){
        System.out.println("========== DRIVER LIST ==========\n");
        System.out.println("--------------------------------------------------------------------------");

        for(UserFeedBack userFeedBack : userFeedBacks){
            System.out.println("Feed Back Id : "+ userFeedBack.getId() + "  Email Id : "+userFeedBack.getEmail() +
                    "  Password : " + userFeedBack.getPassword() + "  FeedBack Content : "+ userFeedBack.getFeedBackContent());
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}
