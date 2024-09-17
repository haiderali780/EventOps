<%@ page import="java.util.List" %>
<%@ page import="com.robolux.models.Event" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Events</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        li {
            padding: 10px;
            margin-bottom: 10px;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .event-info {
            flex-grow: 1;
        }
        .event-actions {
            display: flex;
            gap: 10px;
        }
        .btn {
            padding: 10px;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
        .btn-register {
            background-color: #4CAF50;
        }
        .btn-register:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>All Events</h1>

        <ul>
            <% List<Event> events = (List<Event>) request.getAttribute("events");
               if (events != null) {
                   for (Event event : events) { %>
            <li>
                <div class="event-info">
                    <span><strong>Name:</strong> <%= event.getName() %></span><br>
                    <span><strong>Date:</strong> <%= event.getDate() %></span><br>
                    <span><strong>Location:</strong> <%= event.getLocation() %></span>
                </div>
                <div class="event-actions">
                    <form action="registerEventServlet" method="post">
                        <input type="hidden" name="eventId" value="<%= event.getId() %>">
                        <button type="submit" class="btn btn-register">Register</button>
                    </form>
                </div>
            </li>
            <% }
               } else { %>
            <li>No events found.</li>
            <% } %>
        </ul>
    </div>
</body>
</html>
