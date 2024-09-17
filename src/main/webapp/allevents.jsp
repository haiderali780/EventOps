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
        .btn-update {
            background-color: #4CAF50;
        }
        .btn-update:hover {
            background-color: #45a049;
        }
        .btn-delete {
            background-color: #f44336;
        }
        .btn-delete:hover {
            background-color: #e53935;
        }
        .dialog {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            z-index: 9999;
        }
        .dialog input[type="text"] {
            width: 100%;
            margin-bottom: 10px;
            padding: 8px;
            box-sizing: border-box;
        }
        .dialog button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }
        .btn-update-dialog {
            background-color: #4CAF50;
            color: white;
        }
        .btn-update-dialog:hover {
            background-color: #45a049;
        }
        .btn-cancel-dialog {
            background-color: #f44336;
            color: white;
        }
        .btn-cancel-dialog:hover {
            background-color: #e53935;
        }
        /* Overlay styling */
        #overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black */
            z-index: 999; /* Higher z-index than dialog */
            backdrop-filter: blur(5px); /* Add blur effect */
        }
        /* Back to Homepage button styling */
        .btn-back {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            margin-bottom: 10px;
            display: inline-block;
        }
        .btn-back:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>All Events</h1>
        <a href="adminhomepage.jsp" class="btn btn-back">Back to Homepage</a>
        <ul>
            <% List<Event> events = (List<Event>) request.getAttribute("events");
               if (events != null) {
                   for (Event event : events) { %>
            <li>
                <div class="event-info">
                    <span><strong>Name:</strong> <%= event.getName() %></span><br>
                    <span><strong>Date:</strong> <%= event.getDate() %></span><br>
                    <span><strong>Location:</strong> <%= event.getLocation() %></span><br>
                    <span><strong>Registered Users:</strong> <%= event.getRegistered_count() %></span>
                </div>
                <div class="event-actions">
                    <button onclick="openDialog('<%= event.getId() %>', '<%= event.getName() %>', '<%= event.getDate() %>', '<%= event.getLocation() %>')" class="btn btn-update">Update</button>
                    <form action="deleteevent" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="<%= event.getId() %>">
                        <button type="submit" class="btn btn-delete">Delete</button>
                    </form>
                </div>
            </li>
            <% }
               } else { %>
            <li>No events found.</li>
            <% } %>
        </ul>
    </div>

    <!-- Update Event Dialog -->
    <div id="updateDialog" class="dialog">
        <h2>Update Event</h2>
        <form action="updateevent" method="post">
            <input type="hidden" id="eventId" name="id">
            <input type="text" id="eventName" name="name" placeholder="Event Name" required><br>
            <input type="text" id="eventDate" name="date" placeholder="Event Date" required><br>
            <input type="text" id="eventLocation" name="location" placeholder="Event Location" required><br>
            <button type="submit" class="btn btn-update-dialog">Update</button>
            <button type="button" onclick="closeDialog()" class="btn btn-cancel-dialog">Cancel</button>
        </form>
    </div>

    <div id="overlay"></div> <!-- This div creates the background overlay -->

    <script>
        function openDialog(id, name, date, location) {
            document.getElementById('eventId').value = id;
            document.getElementById('eventName').value = name;
            document.getElementById('eventDate').value = date;
            document.getElementById('eventLocation').value = location;
            document.getElementById('updateDialog').style.display = 'block';
            document.getElementById('overlay').style.display = 'block';
        }

        function closeDialog() {
            document.getElementById('updateDialog').style.display = 'none';
            document.getElementById('overlay').style.display = 'none';
        }
    </script>
</body>
</html>
