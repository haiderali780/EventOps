/*
 * import javax.servlet.*; import javax.servlet.http.*; import java.io.*; import
 * java.sql.*;
 * 
 * public class SignUp extends HttpServlet {
 * 
 * // Process the HTTP POST request public void doPost(HttpServletRequest
 * request, HttpServletResponse response) throws ServletException, IOException {
 * response.setContentType("text/html");
 * 
 * // Get PrintWriter object PrintWriter out = response.getWriter();
 * 
 * String name = request.getParameter("name"); String password =
 * request.getParameter("password"); String userType =
 * request.getParameter("userType"); // Fetching user type
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
 * "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
 * System.out.println("User Type: " + userType);
 * 
 * PreparedStatement ps = con.prepareStatement(query); ps.setString(1, name);
 * ps.setString(2, password); ps.setString(3, userType); // Inserting user type
 * 
 * int rs = ps.executeUpdate();
 * 
 * if (rs == 1) { out.println("<h1>Sign Up successful ....</h1><br/>User Type: "
 * + userType);
 * 
 * } else { out.println("<h1>Record could not be inserted.</h1>"); }
 * 
 * out.println("</body></html>"); ps.close(); con.close();
 * 
 * } catch (Exception e) { out.println("<h1>Error: " + e.getMessage() +
 * "</h1>"); } } }
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignUp extends HttpServlet {

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType"); // Fetching user type

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/termproject";
            Connection con = DriverManager.getConnection(url, "root", "root");

            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, userType); // Inserting user type

            int rs = ps.executeUpdate();

            if (rs == 1) {
                // Sign Up successful
                // You can set a success message and redirect to a success page if needed
                // For now, let's forward back to the index.jsp
                request.setAttribute("signupSuccessMessage", "Sign Up successful. User Type: " + userType);
                request.setAttribute("formType", "signUp");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                // Record could not be inserted
                out.println("<h1>Record could not be inserted.</h1>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            // Set error message and forward back to index.jsp
            request.setAttribute("signupErrorMessage", "Error: " + e.getMessage());
            request.setAttribute("formType", "signUp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}


