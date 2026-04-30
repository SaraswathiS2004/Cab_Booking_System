package com.zsgs.cabbooking.features.admin.list.feedbacklist;

import com.zsgs.cabbooking.data.dto.UserFeedBack;
import com.zsgs.cabbooking.data.repository.CabDB;

import java.util.ArrayList;

public class FeedBackListModel {

    private FeedBackListView feedBackListView;
    private CabDB cabDB;
    public FeedBackListModel(FeedBackListView feedBackListView){
        this.feedBackListView = feedBackListView;
        this.cabDB = CabDB.getInstance();
    }

    public void getFeedBacks(){
        ArrayList<UserFeedBack> userFeedBacks = cabDB.getUserFeedBacks();
        if(userFeedBacks.isEmpty()){
            feedBackListView.showFailedUserFeedBack("No FeedBack Found");
        }
        else {
            feedBackListView.showSuccessfulFeedBacks(userFeedBacks);
        }
    }


}
