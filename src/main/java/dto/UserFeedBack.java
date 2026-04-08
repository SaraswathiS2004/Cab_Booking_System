package dto;

public class UserFeedBack {
    private String name;
    private String password;
    private String feedBackContent;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
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
}
