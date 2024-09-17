package com.robolux.controller;

import com.robolux.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the event ID to be deleted from the request parameter
        int eventId = Integer.parseInt(request.getParameter("id"));

        // Delete the event from the database
        EventDAO eventDAO = new EventDAO();
        boolean isDeleted = eventDAO.deleteEvent(eventId);

        // Set success or error message
        if (isDeleted) {
            request.getSession().setAttribute("successMessage", "Event deleted successfully.");
        } else {
            request.getSession().setAttribute("errorMessage", "Failed to delete event.");
        }

        // Redirect to the events list page
        response.sendRedirect("adminhomepage.jsp");
    }
}
