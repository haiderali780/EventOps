<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Event</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Light gray background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 400px;
            background-color: #fff; /* White background */
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
            padding: 40px;
            text-align: center;
            position: relative;
            overflow: hidden;
        }
        h1 {
            margin-bottom: 30px;
            color: #512da8; /* Dark purple heading color */
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label, input {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            font-size: 16px;
        }
        input[type="text"],
        input[type="date"] {
            padding: 12px;
            border: 1px solid #ced4da; /* Light gray border */
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="date"]:focus {
            border-color: #512da8; /* Dark purple border on focus */
            outline: none;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #512da8; /* Dark purple button background */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #311b92; /* Darker purple on hover */
        }
        .back-button {
            position: absolute;
            top: 20px;
            left: 20px;
            background: none;
            border: none;
            color: #512da8; /* Dark purple text color */
            font-size: 16px;
            cursor: pointer;
            transition: color 0.3s;
        }
        .back-button:hover {
            color: #311b92; /* Darker purple on hover */
        }
        .message {
            margin-top: 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <button class="back-button" onclick="goBack()">Back to HomePage</button>
        <h1>Add Event</h1>
        <form action="addEvent" method="post">
            <label for="eventName">Event Name:</label>
            <input type="text" id="eventName" name="eventName" required>
            
            <label for="eventDate">Event Date:</label>
            <input type="date" id="eventDate" name="eventDate" required>
            
            <label for="eventLocation">Event Location:</label>
            <input type="text" id="eventLocation" name="eventLocation" required>
            
            <input type="submit" value="Add Event">
        </form>

        <div class="message">
            <% if (request.getAttribute("successMessage") != null) { %>
                <p style="color:green;"><%= request.getAttribute("successMessage") %></p>
            <% } %>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
            <% } %>
        </div>
    </div>

    <script>
        function goBack() {
            window.location.href = 'adminhomepage.jsp';
        }
    </script>
</body>
</html>
