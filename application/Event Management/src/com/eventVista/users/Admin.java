package com.eventVista.users;

import com.eventVista.exceptions.VendorAlreadyExistsException;
import com.eventVista.exceptions.VendorDoesNotExistsException;

import java.sql.*;

public class Admin {
    private String adminUserName, adminPassword, adminEmail;
    private int adminMobile;
    public Admin(){};


    private void addVendor(Vendor v) throws VendorAlreadyExistsException
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
            String ins="insert into Vendor values(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(ins);
            pst.setInt(1,v.getVendorId());
            pst.setString(2,v.getVendorName());
            pst.setString(3,v.getVendorAddress());
            pst.setString(4,v.getVendorEmail());
            pst.setLong(5,v.getVendorMobile());
            pst.execute();
            System.out.println("Vendor added");
            con.close();
        }catch (SQLException s){
            throw new VendorAlreadyExistsException("Vendor Already Exists");
        }
    }

    private void viewAllVendor()
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("driver not found");
        }
        try{
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EventDB","root","Rohit@123"
            );
        }catch (SQLException s)
        {
            System.out.println("connection unsuccessful");
        }

        try{
            PreparedStatement pst=con.prepareStatement("select * from Vendor");
            ResultSet rs;
            System.out.println("Id\t"+"Vendor Name\t"+"Address\t\t"+"Email\t\t\t\t"+"Mobile\t"+"\t");
            rs=pst.executeQuery();
            while (rs.next())
            {
                System.out.print(rs.getInt("vendorId")+"\t");
                System.out.print(rs.getString("vendorName")+"\t\t");
                System.out.print(rs.getString("vendorAddress")+"\t\t");
                System.out.print(rs.getString("vendorEmail")+"\t\t");
                System.out.print(rs.getLong("vendorMobile")+"\t");
                System.out.println();

            }
        }catch(SQLException s){
            System.out.println("table or column or data type not found");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }


    }

    private void deleteVendor(int vendorId)throws VendorDoesNotExistsException
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("driver not found");
        }
        try{
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EventDB","root","Rohit@123"
            );
        }catch (SQLException s)
        {
            System.out.println("connection unsuccessful");
        }

        try{
            PreparedStatement pst=con.prepareStatement("DELETE FROM Vendor WHERE vendorId = ?");

            pst.setInt(1,vendorId);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + vendorId + " deleted successfully.");
            } else {
                throw new VendorDoesNotExistsException("No records were deleted.");
            }

        }catch(SQLException s){
            System.out.println("table or column or data type not found");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }

    };
    private void updateVendor(int vendorId){};

    public void viewAllEvents(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("driver not found");
        }
        try{
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EventDB","root","Rohit@123"
            );
        }catch (SQLException s)
        {
            System.out.println("connection unsuccessful");
        }

        try{
            PreparedStatement pst=con.prepareStatement("select * from Event");
            ResultSet rs;
            System.out.println("Event Id\t"+"Event Name\t"+"Vendor Name\t\t"+"Vendor Id\t"+"Cost\t\t"+"Venue\t"+"Date\t\t"+"Guest Count\t"+"\t");
            rs=pst.executeQuery();
            while (rs.next())
            {
                System.out.print(rs.getInt("eventId")+"\t\t\t");
                System.out.print(rs.getString("eventName")+"\t\t\t");
                System.out.print(rs.getString("vendorName")+"\t\t\t\t");
                System.out.print(rs.getInt("vendorId")+"\t\t\t");
                System.out.print(rs.getDouble("cost")+"\t");
                System.out.print(rs.getString("venue")+"\t");
                System.out.print(rs.getString("date")+"\t");
                System.out.print(rs.getInt("no_of_people")+"\t\t");
                System.out.println();

            }
        }catch(SQLException s){
            System.out.println("table or column or data type not found");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }

    }

    private void viewAllUsers(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("driver not found");
        }
        try{
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EventDB","root","Rohit@123"
            );
        }catch (SQLException s)
        {
            System.out.println("connection unsuccessful");
        }

        try{
            PreparedStatement pst=con.prepareStatement("select * from User");
            ResultSet rs;
            System.out.println("Id\t"+"userFullName\t"+"userName\t\t"+"Email\t\t\t\t"
                    +"userPassword\t"+"userStatus\t"+"userLocation\t"+"userDepartment\t"
                    +"Mobile\t\t"+"doj\t\t\t"+"dob\t"+"\t");
            rs=pst.executeQuery();
            while (rs.next())
            {
                System.out.print(rs.getInt("userId")+"\t");
                System.out.print(rs.getString("userFullName")+"\t\t");
                System.out.print(rs.getString("userName")+"\t\t");
                System.out.print(rs.getString("userEmail")+"\t");
                System.out.print(rs.getString("userPassword")+"\t");
                System.out.print(rs.getString("userStatus")+"\t");
                System.out.print(rs.getString("userLocation")+"\t\t\t");
                System.out.print(rs.getString("userDepartment")+"\t\t\t");
                System.out.print(rs.getLong("mobile")+"\t");
                System.out.print(rs.getString("doj")+"\t");
                System.out.print(rs.getString("dob")+"\t");
                System.out.println();

            }
        }catch(SQLException s){
            System.out.println("table or column or data type not found");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }

    }

    public void viewAllPackages(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("driver not found");
        }
        try{
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EventDB","root","Rohit@123"
            );
        }catch (SQLException s)
        {
            System.out.println("connection unsuccessful");
        }

        try{
            PreparedStatement pst=con.prepareStatement("select * from vendorPackage");
            ResultSet rs;
            System.out.println("vendorPackageId\t"+"vendorPackageType\t"+"cost\t\t"+"listOfServices \t");
            rs=pst.executeQuery();
            while (rs.next())
            {
                System.out.print(rs.getInt("vendorPackageId")+"\t\t\t\t");
                System.out.print(rs.getString("vendorPackageType")+"\t\t\t\t");
                System.out.print(rs.getDouble("cost")+"\t");
                System.out.print(rs.getString("listOfServices")+"\t\t\t");
                System.out.println();

            }
        }catch(SQLException s){
            System.out.println("table or column or data type not found");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }

    }



    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminFullName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public int getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(int adminMobile) {
        this.adminMobile = adminMobile;
    }
}
