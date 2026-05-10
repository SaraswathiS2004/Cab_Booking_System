package com.ridex.cabbooking.features.admin.list.feedbacklist;

import com.ridex.cabbooking.data.dto.UserFeedBack;
import com.ridex.cabbooking.data.repository.database.RideXDB;

import java.sql.SQLException;
import java.util.ArrayList;

class FeedBackListModel {

    private FeedBackListView feedBackListView;
    //    private CabDB cabDB;
    private RideXDB rideXDB;

    public FeedBackListModel(FeedBackListView feedBackListView) throws SQLException, ClassNotFoundException {
        this.feedBackListView = feedBackListView;
//        this.cabDB = CabDB.getInstance();
        this.rideXDB = new RideXDB();
    }

    public void getFeedBacks() {
//        ArrayList<UserFeedBack> userFeedBacks = cabDB.getUserFeedBacks();
        ArrayList<UserFeedBack> userFeedBacks = rideXDB.getFeedBackList();

        if (userFeedBacks.isEmpty()) {
            feedBackListView.showFailedUserFeedBack("No FeedBack Found");
        } else {
            feedBackListView.showSuccessfulFeedBacks(userFeedBacks);
        }
    }


}
