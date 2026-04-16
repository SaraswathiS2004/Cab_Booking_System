package com.zsgs.cabbooking.features.user.feedback;

public class FeedBackModel {

    private FeedBackView feedBackView;

    public FeedBackModel(){
        feedBackView = new FeedBackView();
    }

    public void getFeedBack(){
        feedBackView.showFeedBack();
    }
}
