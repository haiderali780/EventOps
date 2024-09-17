package com.robolux.controller;

import com.robolux.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegisterEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get event ID from request
        String eventId = request.getParameter("eventId");

        if (eventId != null && !eventId.isEmpty()) {
            // Call EventDAO to update the registered count for the event
            EventDAO eventDAO = new EventDAO();
            boolean isRegistered = eventDAO.incrementRegisteredCount(eventId);

            if (isRegistered) {
                // Registration successful
                request.getSession().setAttribute("RsuccessMessage", "Successfully registered for the event.");
            } else {
                // Registration failed
                request.getSession().setAttribute("RerrorMessage", "Failed to register for the event. Please try again.");
            }
        } else {
            // Invalid event ID
            request.getSession().setAttribute("RerrorMessage", "Invalid event ID.");
        }

        // Redirect back to the events page
        response.sendRedirect("regularuser.jsp");
    }
}
