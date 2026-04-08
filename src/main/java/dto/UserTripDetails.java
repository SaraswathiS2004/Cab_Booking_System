package dto;

public class UserTripDetails {
    private char pickUp;
    private char dropUp;
    private long pickupTiming;
    private String cabName;
    private float price;
    private TripStatus status;

    public enum TripStatus{
        BOOKING , NOT_BOOKING
    }

    public void setPick_up(char pickUp){
        this.pickUp = pickUp;
    }
    public char getPick_up(){
        return pickUp;
    }
    public void setDrop_up(char dropUp){
        this.dropUp = dropUp;
    }
    public char getDropUp(){
        return dropUp;
    }
    public void setPickupTiming(long pickupTiming){
        this.pickupTiming = pickupTiming;
    }
    public long getPickupTiming(){
        return pickupTiming;
    }
    public void setCabName(String cabName){
        this.cabName = cabName;
    }
    public String getCabName(){
        return cabName;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public void setTripStatus(TripStatus status){
        this.status = status;
    }
    public TripStatus getStatus(){
        return status;
    }

}
