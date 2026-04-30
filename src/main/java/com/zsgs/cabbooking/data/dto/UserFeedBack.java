package com.zsgs.cabbooking.data.dto;

public class UserFeedBack {
    private long id;
    private String email;
    private String password;
    private String feedBackContent;

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setFeedBackContent(String feedBackContent){
        this.feedBackContent = feedBackContent;
    }
    public String getFeedBackContent(){
        return feedBackContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
