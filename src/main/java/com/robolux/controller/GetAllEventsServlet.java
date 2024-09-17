package com.robolux.controller;

import com.robolux.dao.EventDAO;
import com.robolux.models.Event;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAllEventsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        // Call EventDAO to retrieve all events from the database
        EventDAO eventDAO = new EventDAO();
        List<Event> events = eventDAO.getAllEvents();

        // Set events as request attribute
        request.setAttribute("events", events);
        
        String role = (String) session.getAttribute("role");
        if (role.equals("regular")) {
            request.getRequestDispatcher("regularAllEvents.jsp").forward(request, response); 
        } else {
            // Forward to a JSP page to display the events
            request.getRequestDispatcher("allevents.jsp").forward(request, response);
        }
    }
}
