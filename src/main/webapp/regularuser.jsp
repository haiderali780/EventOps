<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Regular User Homepage</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
            margin: 0;
        }
        .container {
            text-align: center;
            background: white;
            padding: 30px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        .container h1 {
            margin-bottom: 30px;
        }
        .btn {
            display: block;
            width: 200px;
            margin: 10px auto;
            padding: 15px;
            background-color: #512da8; /* Updated background color */
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #311b92; /* Darker hover color */
        }
        .logout-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 10px;
            background-color: #f44336; /* Red color */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }
        .logout-btn:hover {
            background-color: #e53935; /* Darker hover color */
        }
        .success-message {
            color: green;
            margin-top: 20px;
        }
        .error-message {
            color: red;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Regular User Homepage</h1>
        
        <form action="allevents" method="post">
            <button type="submit" class="btn">View All Events</button>
        </form>
        <button onclick="logout()" class="logout-btn">Logout</button>
        
        <%-- Display success message --%>
        <% String successMessage = (String) request.getSession().getAttribute("RsuccessMessage"); %>
        <% if (successMessage != null) { %>
            <p class="success-message"><%= successMessage %></p>
        <% } %>
        <%-- Display error message --%>
        <% String errorMessage = (String) request.getSession().getAttribute("RerrorMessage"); %>
        <% if (errorMessage != null) { %>
            <p class="error-message"><%= errorMessage %></p>
        <% } %>
    </div>

    <script>
        function logout() {
            window.location.href = 'logoutServlet'; // Replace 'logoutServlet' with the actual URL of your logout servlet
        }
    </script>
</body>
</html>
