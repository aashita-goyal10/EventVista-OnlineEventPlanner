package com.eventVista.users;

import com.eventVista.exceptions.VendorPackageAlreadyExistsException;
import com.eventVista.exceptions.VendorPackageDoesNotExistsException;
import com.eventVista.vendorPackage.VendorPackage;

import java.sql.*;

public class Vendor {
    private String vendorName,vendorAddress,vendorEmail;
    private int vendorId;
    private long vendorMobile;

    public Vendor(String vendorName, String vendorAddress, String vendorEmail, long vendorMobile, int vendorId) {
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorEmail = vendorEmail;
        this.vendorMobile = vendorMobile;
        this.vendorId = vendorId;
    }

    public void addPackage(VendorPackage vp)throws VendorPackageAlreadyExistsException
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
            String ins="insert into VendorPackage values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(ins);
            pst.setInt(1,vp.getVendorPackageId());
            pst.setString(2,vp.getVendorPackageType());
            pst.setDouble(3,vp.getCost());
            pst.setString(4,vp.getListOfServices());
            pst.execute();
            System.out.println("Vendor Package added");
            con.close();
        }catch (SQLException s){
            throw new VendorPackageAlreadyExistsException("Vendor Package Already Exists");
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

    public void updatePackage(VendorPackage vp)throws VendorPackageDoesNotExistsException
    {
        Connection con =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EventDB","root","Rohit@123");

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try{

            String ins="update VendorPackage set vendorPackageType=?,cost=?,listOfServices=? where vendorPackageId=?";
            PreparedStatement pst=con.prepareStatement(ins);
            pst.setString(1,vp.getVendorPackageType());
            pst.setDouble(2,vp.getCost());
            pst.setString(3,vp.getListOfServices());
            pst.setInt(4,vp.getVendorPackageId());
            pst.execute();
            System.out.println("Package Updated");

        }catch (SQLException s){
            throw new VendorPackageDoesNotExistsException("Package not found");
        }
        try{
            con.close();
        }catch (SQLException s)
        {
            System.out.println("con did not close");
        }

    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public long getVendorMobile() {
        return vendorMobile;
    }

    public void setVendorMobile(int vendorMobile) {
        this.vendorMobile = vendorMobile;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
