package com.eventVista.users;

import com.eventVista.events.Event;
import com.eventVista.exceptions.EventAlreadyExistsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class User {
    private String userStatus,userName,userEmail,userPassword,userLocation,userFullName,userDepartment;
    private int userId,mobile;
    private Date doj,dob;

    public User(String userStatus, String userName, String userEmail, String userPassword, String userLocation, String userFullName, String userDepartment, int userId, int mobile, Date doj, Date dob) {
        this.userStatus = userStatus;// active/inactive
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userLocation = userLocation;
        this.userFullName = userFullName;
        this.userDepartment = userDepartment;// marketing/sales/IT
        this.userId = userId;
        this.mobile = mobile;
        this.doj = doj;
        this.dob = dob;
    }

    public void createEvent(Event eobj)throws EventAlreadyExistsException
    {
        Connection con =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){}
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EventDB","root","Rohit@123");

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            String ins="insert into Event values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(ins);
            pst.setInt(1,eobj.getEventId());
            pst.setString(2,eobj.getEventName());
            pst.setInt(3,eobj.getVendorId());
            pst.setString(4,eobj.getVendorName());
            pst.setDouble(5,eobj.getCost());
            pst.setString(6,eobj.getVenue());
            pst.setDate(7,eobj.getDate());

            pst.execute();
            System.out.println("Event Package added");
            con.close();
        }catch (SQLException s){
            throw new EventAlreadyExistsException("Event  Already Exists");
        }

    };

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
