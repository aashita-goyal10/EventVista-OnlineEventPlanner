package com.eventVista.authentication;

import com.eventVista.exceptions.InvalidAdminCredentialsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
public class AdminAuth {
    public boolean adminLogin(String adminUserName,String adminPassword)throws InvalidAdminCredentialsException
    {
        //fetch from db n check if password n username is matching
        //with .equals method else raise suitable exception

        return true;
    };
}
*/

public class AdminAuth{
		public boolean adminLogin(String adminUserName,String adminEmail, String adminPassword) throws InvalidAdminCredentialsException {
		    // Define database connection parameters
		    String jdbcUrl = "jdbc:mysql://your_database_host:3306/EventDB";
		    String dbUsername = "root";
		    String dbPassword = "TheNun";
		
		    // Initialize database connection
		    try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
		        // Prepare an SQL query to retrieve the admin's password based on the username
		        String sql = "SELECT password FROM LoginDetails WHERE userName=adminUserName and email=adminEmail";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, adminUserName);
		
		            // Execute the query
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    String storedPassword = resultSet.getString("password");
		                    if (adminPassword.equals(storedPassword)) {
		                        // Passwords match; login is successful
		                        return true;
		                    } else {
		                        // Passwords do not match; throw an exception
		                        throw new InvalidAdminCredentialsException("Invalid password");
		                    }
		                } else {
		                    // No admin found with the given username; throw an exception
		                    throw new InvalidAdminCredentialsException("Admin not found");
		                }
		            }
		        }
		    } catch (SQLException e) {
		        // Handle any database-related exceptions here
		        e.printStackTrace();
		        throw new InvalidAdminCredentialsException("Database error");
		    }
		}
}

