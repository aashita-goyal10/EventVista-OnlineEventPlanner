package com.eventVista.authentication;
import com.eventVista.users.Vendor;
import com.eventVista.exceptions.InvalidVendorCredentialsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorAuth {
	/*
    public boolean vendorLogin(String vendorUserName,String vendorPassword)throws InvalidVendorCredentialsException
    {
        //fetch from db n check if password n username is matching
        //with .equals method else raise suitable exception


        return true;}
        */
    String jdbcUrl = "jdbc:mysql://your_database_host:3306/EventDB";
    String dbUsername = "root";
    String dbPassword = "TheNun";

	public boolean vendorLogin(String vendorUserName,String vendorEmail, String vendorPassword) throws InvalidVendorCredentialsException {
	    // Define database connection parameters


	    // Initialize database connection
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
	        // Prepare an SQL query to retrieve the vendor's password based on the username
	        String sql = "SELECT password FROM vendor_table WHERE userName =vendorUserName and email=vendorEmail";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, vendorUserName);

	            // Execute the query
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    String storedPassword = resultSet.getString("password");
	                    if (vendorPassword.equals(storedPassword)) {
	                        // Passwords match; login is successful
	                        return true;
	                    } else {
	                        // Passwords do not match; throw an exception
	                        throw new InvalidVendorCredentialsException("Invalid password");
	                    }
	                } else {
	                    // No vendor found with the given username; throw an exception
	                    throw new InvalidVendorCredentialsException("Vendor not found");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        // Handle any database-related exceptions here
	        e.printStackTrace();
	        throw new InvalidVendorCredentialsException("Database error");
	    }
	}
     /*
    public void vendorRegister(){
        //create new obj of Vendor class and call addVendor Method which will
        //insert new vendor to db
    }
    */
	  public void addVendor(Vendor newVendor) {
	        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
	            String sql = "INSERT INTO vendor_table (vendorId,vendorName,vendorAddress,vendorEmail,vendorMobile) VALUES (?,?,? ?, ?)";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	               
	                statement.setString(2, newVendor.getVendorName());
	                statement.setString(3, newVendor.getVendorAddress());

	                // Execute the insert statement
	                statement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            // Handle any database-related exceptions here
	            e.printStackTrace();
	        }
	    }

	    public void vendorRegister(String vendorName, String vendorAddress, String vendorEmail,long vendorMobile,int vendorId) {
	        // Create a new Vendor object with the provided data
	        Vendor newVendor = new Vendor(vendorName,  vendorAddress,vendorEmail ,vendorMobile,vendorId);

	        // Call the addVendor method to insert the new vendor into the database
	        addVendor(newVendor);
	    }
	}



