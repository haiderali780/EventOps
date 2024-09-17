package com.robolux.controller;

import com.robolux.dao.EventDAO;
import com.robolux.models.Event;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String location = request.getParameter("location");
        
        // Update event in the database
        Event updatedEvent = new Event(eventId, name, date, location); // Assuming there's a constructor in Event class
        EventDAO eventDAO = new EventDAO();
        boolean isUpdated = eventDAO.updateEvent(updatedEvent);
        
        // Set success or error message
        if (isUpdated) {
            request.getSession().setAttribute("successMessage", "Event updated successfully.");
        } else {
            request.getSession().setAttribute("errorMessage", "Failed to update event.");
        }

        // Redirect to the events list page
        request.getRequestDispatcher("adminhomepage.jsp").forward(request, response);
    }
}
