package com.robolux.controller;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get the session without creating a new one if it doesn't exist
        if (session != null) {
            session.invalidate(); // Invalidate the session, removing any associated data
        }
        response.sendRedirect("index.jsp"); // Redirect to the index.jsp page
    }
}
