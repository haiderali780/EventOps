package com.robolux.dao;

import com.robolux.models.Event;
import com.robolux.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public boolean addEvent(Event event) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO events (name, date, location) VALUES (?, ?, ?)")) {

            statement.setString(1, event.getName());
            statement.setString(2, event.getDate());
            statement.setString(3, event.getLocation());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM events");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setDate(resultSet.getString("date"));
                event.setLocation(resultSet.getString("location"));
                event.setRegistered_count(resultSet.getInt("registered_count")); // Set registered_count
                events.add(event);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return events;
    }

    public boolean updateEvent(Event event) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE events SET name=?, date=?, location=? WHERE id=?")) {

            statement.setString(1, event.getName());
            statement.setString(2, event.getDate());
            statement.setString(3, event.getLocation());
            statement.setInt(4, event.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteEvent(int eventId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM events WHERE id=?")) {

            statement.setInt(1, eventId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean incrementRegisteredCount(String eventId) {
        String query = "UPDATE events SET registered_count = registered_count + 1 WHERE id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, eventId);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
