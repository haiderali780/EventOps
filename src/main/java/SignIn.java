/*
 1* import javax.servlet.*; import javax.servlet.http.*; import java.io.*; import
 * java.sql.*;
 * 
 * public class SignIn extends HttpServlet {
 * 
 * // Process the HTTP POST request public void doPost(HttpServletRequest
 * request, HttpServletResponse response) throws ServletException, IOException {
 * response.setContentType("text/html");
 * 
 * // Get PrintWriter object PrintWriter out = response.getWriter();
 * 
 * String name = request.getParameter("name"); String password =
 * request.getParameter("password"); String userType =
 * request.getParameter("usertype"); // Fetching user type
 * 
 * out.println("<html>"); out.println("<head><title>Response</title></head>");
 * out.println("<body bgcolor=\"#ffffff\">");
 * 
 * try { Class.forName("com.mysql.cj.jdbc.Driver");
 * 
 * String url = "jdbc:mysql://127.0.0.1:3306/termproject"; Connection con =
 * DriverManager.getConnection(url, "root", "root");
 * 
 * String query =
 * "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
 * PreparedStatement ps = con.prepareStatement(query); ps.setString(1, name);
 * ps.setString(2, password); ps.setString(3, userType); // Check user type
 * 
 * ResultSet rs = ps.executeQuery();
 * 
 * out.println("<h1>Welcome</h1>"+name ); // if (rs.next()) { // HttpSession
 * session = request.getSession(); // session.setAttribute("username", name); //
 * session.setAttribute("role", userType); // // } else { //
 * out.println("<h1>No record found</h1>"); // }
 * 
 * if (rs.next()) { // Create a session HttpSession session =
 * request.getSession(); session.setAttribute("username", name);
 * session.setAttribute("role", userType); // Redirect based on user type if
 * ("admin".equals(userType)) { response.sendRedirect("adminhomepage.html"); }
 * else if ("regular".equals(userType)) {
 * response.sendRedirect("regularuser.html"); } else {
 * response.sendRedirect("index.html"); } } else {
 * out.println("<h1>No record found</h1>"); } out.println("</body></html>");
 * rs.close(); ps.close(); con.close();
 * 
 * } catch (Exception e) { out.println("<h1>Error: " + e.getMessage() +
 * "</h1>"); } } }
 * 
 * 
 * 
 * 
 * 
 * 
 */


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignIn extends HttpServlet {

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String userType = request.getParameter("usertype");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/termproject";
            Connection con = DriverManager.getConnection(url, "root", "root");

            String query = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, userType);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Create a session
                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                session.setAttribute("role", userType);

                // Redirect based on user type
                if ("admin".equals(userType)) {
                    response.sendRedirect("adminhomepage.jsp");
                } else if ("regular".equals(userType)) {
                    response.sendRedirect("regularuser.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                // If no record found, set error message and forward back to login page
                request.setAttribute("loginErrorMessage", "No record found. Please try again.");
                request.setAttribute("formType", "signIn");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            // Set error message and forward back to login page
            request.setAttribute("loginErrorMessage", "Error: " + e.getMessage());
            request.setAttribute("formType", "signIn");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
