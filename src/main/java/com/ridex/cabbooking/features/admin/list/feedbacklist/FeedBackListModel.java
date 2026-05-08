package com.ridex.cabbooking.features.admin.list.feedbacklist;

import com.ridex.cabbooking.data.dto.UserFeedBack;
import com.ridex.cabbooking.data.repository.RideXDB;

import java.util.ArrayList;

class FeedBackListModel {

    private FeedBackListView feedBackListView;
    private RideXDB rideXDB;
    public FeedBackListModel(FeedBackListView feedBackListView){
        this.feedBackListView = feedBackListView;
        this.rideXDB = RideXDB.getInstance();
    }

    public void getFeedBacks(){
        ArrayList<UserFeedBack> userFeedBacks = rideXDB.getUserFeedBacks();
        if(userFeedBacks.isEmpty()){
            feedBackListView.showFailedUserFeedBack("No FeedBack Found");
        }
        else {
            feedBackListView.showSuccessfulFeedBacks(userFeedBacks);
        }
    }


}
