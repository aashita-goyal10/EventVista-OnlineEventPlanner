package com.eventVista.authentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.eventVista.users.User;

import com.eventVista.exceptions.InvalidUserCredentialsException;

public class UserAuth {
   /*
	public boolean userLogin(String userName,String userPassword)throws InvalidUserCredentialsException
    {
        //fetch from db n check if password n username is matching
        //with .equals method else raise suitable exception


        return true;}
        */

	  // Define database connection parameters
     String jdbcUrl = "jdbc:mysql://your_database_host:3306/EventDB";
     String dbUsername = "root";
     String dbPassword = "TheNun";
	public boolean userLogin(String userName, String userEmail,String userPassword) throws InvalidUserCredentialsException {
	  

	    // Initialize database connection
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
	        // Prepare an SQL query to retrieve the user's password based on the username
	        String sql = "SELECT password FROM user_table WHERE userName =userName and email=userEmail";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, userName);

	            // Execute the query
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    String storedPassword = resultSet.getString("password");
	                    if (userPassword.equals(storedPassword)) {
	                        // Passwords match; login is successful
	                        return true;
	                    } else {
	                        // Passwords do not match; throw an exception
	                        throw new InvalidUserCredentialsException("Invalid password");
	                    }
	                } else {
	                    // No user found with the given username; throw an exception
	                    throw new InvalidUserCredentialsException("User not found");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        // Handle any database-related exceptions here
	        e.printStackTrace();
	        throw new InvalidUserCredentialsException("Database error");
	    }
	}

	

	    public void userRegister(User newUser) {
	        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
	        	
	            String sql = "INSERT INTO user_table (email, userName, password) VALUES (?,?,?)";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, newUser.getUserEmail());
	                statement.setString(2, newUser.getUserName());
	                statement.setString(3, newUser.getUserPassword());

	                // Execute the insert statement
	                statement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            // Handle any database-related exceptions here
	            e.printStackTrace();
	        }
	    }
       /*
	    public void userRegister(String username, String password, String email) {
	        // Create a new User object with the provided data
	        User newUser = new User(username, password, email);

	        // Call the addUser method to insert the new user into the database
	        addUser(newUser);
	    }
	    */
	

}
