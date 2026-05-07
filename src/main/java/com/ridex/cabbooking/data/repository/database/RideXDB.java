package com.ridex.cabbooking.data.repository.database;

import com.ridex.cabbooking.data.dto.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RideXDB {

    private Connection connection;
    public RideXDB() throws SQLException, ClassNotFoundException {
        connection = DB.getInstance().getConnection();
    }
    private PreparedStatement pre = null;
    public void storeAccount(AccountDetails accountDetails){
        try {
            PreparedStatement pre =  connection.prepareStatement("INSERT INTO ACCOUNTS(NAME , EMAIL , PASSWORD , CITY , ROLE , MOBILE_NUMBER) VALUES (? , ? , ? ,?,? , ?);");
            pre.setString(1 ,accountDetails.getName());
            pre.setString(2 , accountDetails.getEmail());
            pre.setString(3 , accountDetails.getPassword());
            pre.setString(4 ,accountDetails.getCity());
            pre.setString(5 , accountDetails.getRole().toString());
            pre.setString(6 , accountDetails.getMobileNumber());
            pre.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void storeDriver(DriverDetails driverDetails){
        try{
            pre = connection.prepareStatement
                    ("INSERT INTO DRIVERS(DRIVER_ID ,ADDRESS , AGE , EXPERIENCE , MOBILE_NUMBER) VALUES \n" +
                    "(? ,?, ? , ? , ?);");
            pre.setInt(1 , (int) driverDetails.getDriverId());
            pre.setString(2 , driverDetails.getAddress());
            pre.setInt(3 , driverDetails.getAge());
            pre.setInt(4 , driverDetails.getExperience());
            pre.setString(5 , driverDetails.getMobileNumber());
            pre.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void storeCabs(CabDetails cabDetails) throws SQLException {
        try {
            pre = connection.prepareStatement("INSERT INTO CABS(DRIVER_ID , REGISTRATION_NUMBER , MODEL , TYPE ) " +
                    "VALUES (? , ? , ? , ?);\n");
            pre.setInt(1, (int) cabDetails.getDriverId());
            pre.setString(2,  cabDetails.getCabRegistrationNumber());
            pre.setString(3, cabDetails.getModel());
            pre.setString(4, cabDetails.getType());
            pre.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void storeUserTrips(UserTripDetails userTripDetails){
        LocalTime pickup_time= userTripDetails.getPickupTiming().toLocalTime();
        LocalTime dropup_time = userTripDetails.getDropupTiming().toLocalTime();
        LocalDate pick_date = userTripDetails.getPickupTiming().toLocalDate();
        LocalDate drop_date = userTripDetails.getDropupTiming().toLocalDate();

        try{
            pre = connection.prepareStatement(
                    "INSERT INTO USERTRIPS(CAB_ID , PICK_UP , DROP_UP , PICK_UP_TIMING , DROP_UP_TIMING , PICKUP_DATE , DROPUP_DATE , TRIP_STATUS , PAYMENT)\n" +
                    "VALUES(? ,?,? ,?,?,?,?,?,?);");
            pre.setInt(1 , (int) userTripDetails.getCabId());
            pre.setString(2 , userTripDetails.getPickUp());
            pre.setString(3 , userTripDetails.getDropUp());
            pre.setTime(4 , Time.valueOf(pickup_time));
            pre.setTime(5 , Time.valueOf(dropup_time));
            pre.setDate(6 , Date.valueOf(pick_date));
            pre.setDate(7 , Date.valueOf(drop_date));
            pre.setString(8 , userTripDetails.getStatus().toString());
            pre.setInt(9 , userTripDetails.getPayment());
            pre.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void storeCabPosition(CabCurrentPosition cabCurrentPosition){
        try {
            pre = connection.prepareStatement("INSERT INTO CAB_CURRENT_POSITION (CAB_ID , CURRENT_POSITION) VALUES(? , ?);");
            pre.setInt(1 , (int) cabCurrentPosition.getCabId());
            pre.setString(2 , cabCurrentPosition.getPosition());
            pre.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateTrips(long userId , long cab_id , TripStatus status , String cabPosition){
        try {
            pre = connection.prepareStatement("UPDATE USERTRIPS SET TRIP_STATUS = ? WHERE ID = ? ");
            pre.setString(1 , status.toString());
            pre.setInt(2 ,(int) userId);
            int numberOfRowsAffected1 = pre.executeUpdate();
            System.out.println(numberOfRowsAffected1);
            pre = connection.prepareStatement("UPDATE CAB_CURRENT_POSITION set CURRENT_POSITION = ? where ID = ?");
            pre.setString(1 , cabPosition);
            pre.setInt(2 , (int) cab_id);
            int numberOfRowsAffected2 = pre.executeUpdate();
            System.out.println(numberOfRowsAffected2);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean isAdmin(){
        try {
            pre = connection.prepareStatement("SELECT COUNT(*) FROM ACCOUNTS");
            ResultSet set = pre.executeQuery();
            if(set.next()){
                int count = set.getInt(1);
                if(count == 0){
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public void storeFeedBack(UserFeedBack userFeedBack){
        try {
            pre = connection.prepareStatement("INSERT INTO USERFEEDBACK(EMAIL , PASSWORD , FEEDBACK) VALUES (? , ? , ?);");
            pre.setString(1 , userFeedBack.getEmail());
            pre.setString(2 , userFeedBack.getPassword());
            pre.setString(3 ,userFeedBack.getFeedBackContent());
            pre.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public ArrayList<AccountDetails> getAccountList(){
        ArrayList<AccountDetails> accounts = new ArrayList<>();
        try{

            pre = connection.prepareStatement("SELECT * FROM ACCOUNTS");
            ResultSet set = pre.executeQuery();
            while(set.next()){
                AccountDetails accountDetails = new AccountDetails();
//                accountDetails.setId(set.getInt("ID"));
                accountDetails.setName(set.getString("NAME"));
                accountDetails.setEmail(set.getString("EMAIL"));
                accountDetails.setPassword(set.getString("PASSWORD"));
                accountDetails.setCity(set.getString("CITY"));
                accountDetails.setRole(Role.valueOf(set.getString("ROLE")));
                accountDetails.setMobileNumber(set.getString("MOBILE_NUMBER"));
                accounts.add(accountDetails);
            }

            return accounts;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return accounts;
    }

    public AccountDetails getEmployeeByEmail(String email , String password){
        if (email == null){
            return null;
        }
        if(email.isEmpty()) return null;

        try {
            pre = connection.prepareStatement("SELECT * FROM ACCOUNTS WHERE EMAIL = ? AND PASSWORD = ?");
            pre.setString(1 ,email);
            pre.setString(2 , password);
            ResultSet set = pre.executeQuery();
            while(set.next()){
                AccountDetails accountDetails = new AccountDetails();
//                accountDetails.setId(set.getInt("ID"));
                accountDetails.setName(set.getString("NAME"));
                accountDetails.setEmail(set.getString("EMAIL"));
                accountDetails.setPassword(set.getString("PASSWORD"));
                accountDetails.setCity(set.getString("CITY"));
                accountDetails.setRole(Role.valueOf(set.getString("ROLE")));
                accountDetails.setMobileNumber(set.getString("MOBILE_NUMBER"));
                return accountDetails;
            }

        }
        catch (Exception e){
            System.out.println();
        }
        return null;
    }
    public ArrayList<DriverDetails> getDriversList(){
        ArrayList<DriverDetails> drivers = new ArrayList<>();
        try{
            pre = connection.prepareStatement("SELECT * FROM ACCOUNTS WHERE ROLE = ?");
            pre.setString(1 , "DRIVER");
            ResultSet set = pre.executeQuery();
            while(set.next()){

                long driverId = set.getInt("ID");
                PreparedStatement pre1 = connection.prepareStatement("SELECT * FROM DRIVERS WHERE DRIVER_ID = ? ");
                pre1.setInt(1 , (int) driverId);
                ResultSet set1 = pre1.executeQuery();
                while(set1.next()) {
                    DriverDetails driverDetails = new DriverDetails();
                    driverDetails.setId(set1.getInt("ID"));
                    driverDetails.setDriverId(set1.getInt("DRIVER_ID"));
                    driverDetails.setName(set.getString("NAME"));
                    driverDetails.setAddress(set1.getString("ADDRESS"));
                    driverDetails.setAge((set1.getInt("AGE")));
                    driverDetails.setExperience(set1.getInt("EXPERIENCE"));
                    driverDetails.setMobileNumber(set1.getString("MOBILE_NUMBER"));
                    drivers.add(driverDetails);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return drivers;
    }

    public ArrayList<CabDetails> getCabList(){
        ArrayList<CabDetails> cabDetails = new ArrayList<>();
        try{
           pre = connection.prepareStatement("SELECT * FROM CABS");
           ResultSet set = pre.executeQuery();
           while(set.next()){
               CabDetails cabDetails1 = new CabDetails();
               cabDetails1.setCabId(set.getInt("ID"));
               cabDetails1.setDriverId(set.getInt("DRIVER_ID"));
               cabDetails1.setCabRegistrationNumber(set.getString("REGISTRATION_NUMBER"));
               cabDetails1.setModel(set.getString("MODEL"));
               cabDetails1.setType(set.getString("TYPE"));
               cabDetails1.setTotalEarning(set.getInt("EARNINGS"));
               cabDetails.add(cabDetails1);
           }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return cabDetails;
    }

    public ArrayList<CabCurrentPosition> getCabPositionList(){
        ArrayList<CabCurrentPosition> positions = new ArrayList<>();
        try{
            pre = connection.prepareStatement("SELECT * FROM CAB_CURRENT_POSITION");
            ResultSet set = pre.executeQuery();
            while(set.next()){
                CabCurrentPosition position = new CabCurrentPosition();
                position.setCabId(set.getInt("CAB_ID"));
                position.setPosition(set.getString("CURRENT_POSITION"));
                positions.add(position);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return positions;
    }

    public String checkIsAlreadyExistEmailId(String email)  {
        ArrayList<AccountDetails> accounts = getAccountList();
        for(AccountDetails accountDetails1 : accounts){
            if(accountDetails1.getEmail().equals(email)){
                return "This Email id Already Exist";
            }
        }
        return null;
    }

    public void setCabEarnings(long cabId , int earnings){
        try {
            pre = connection.prepareStatement("SELECT EARNINGS FROM CABS WHERE ID = ?");
            pre.setInt(1, (int) cabId);
            ResultSet set = pre.executeQuery();
            if(set.next()){
                int totalEarnings = set.getInt("EARNINGS");
                int total = totalEarnings + earnings;
                pre = connection.prepareStatement("UPDATE CABS SET EARNINGS = ? WHERE ID = ?");
                pre.setInt(1 , total);
                pre.setInt(2 , (int) cabId);
                pre.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<UserFeedBack> getFeedBackList(){
        ArrayList<UserFeedBack> userFeedBacks = new ArrayList<>();
        try{
            pre = connection.prepareStatement("SELECT * FROM USERFEEDBACK");
            ResultSet set = pre.executeQuery();
            while(set.next()){
                UserFeedBack userFeedBack = new UserFeedBack();
                userFeedBack.setEmail(set.getString("EMAIL"));
                userFeedBack.setPassword(set.getString("PASSWORD"));
                userFeedBack.setFeedBackContent(set.getString("FEEDBACK"));
                userFeedBacks.add(userFeedBack);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }

        return userFeedBacks;
    }

    public ArrayList<UserTripDetails> getUserTripList(){

        ArrayList<UserTripDetails> userTripDetails = new ArrayList<>();
        try{
            pre = connection.prepareStatement("SELECT * FROM USERTRIPS");

            ResultSet set = pre.executeQuery();
            while(set.next()){

                UserTripDetails userTripDetails1 = new UserTripDetails();
                userTripDetails1.setCabId(set.getInt("CAB_ID"));
                userTripDetails1.setPickUp(set.getString("PICK_UP"));
                userTripDetails1.setDropUp(set.getString("DROP_UP"));
                userTripDetails1.setPickupTiming(set.getTime("PICK_UP_TIMING"));
                userTripDetails1.setDropupTiming();
                userTripDetails1.setStatus();
                userTripDetails1.setPayment();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
