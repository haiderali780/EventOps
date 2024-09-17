package com.robolux.controller;
import com.robolux.dao.EventDAO;
import com.robolux.models.Event;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate"); // Keep as string
        String eventLocation = request.getParameter("eventLocation");

        // Create Event object
        Event event = new Event();
        event.setName(eventName);
        event.setDate(eventDate); // Set as string
        event.setLocation(eventLocation);

        // Call EventDAO to add event to the database
        EventDAO eventDAO = new EventDAO();
        boolean success = eventDAO.addEvent(event);

        // Set success or error message in session attribute
        if (success) {
            request.getSession().setAttribute("successMessage", "Event added successfully!");
        } else {
            request.getSession().setAttribute("errorMessage", "Failed to add event!");
        }

        // Redirect back to the admin homepage
        response.sendRedirect("adminhomepage.jsp");
    }
}
