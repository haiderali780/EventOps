package com.robolux.dao;

import com.robolux.models.User;
import com.robolux.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to add a user to the database
    public boolean addUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, ?)")) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Method to validate user login
    public boolean validateUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = ?")) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());

            ResultSet resultSet = statement.executeQuery();
            boolean isValid = resultSet.next(); // If a record is found, the user is valid

            resultSet.close();
            return isValid;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
