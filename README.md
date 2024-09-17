# EventOps

**EventOps** is a robust event management system designed to streamline event organization and participation. The platform supports two distinct user roles with tailored functionalities: **Admin** and **Regular User**. Leveraging Java Servlets, JSP, and the MVC (Model-View-Controller) architecture, EventOps provides a scalable and efficient solution for managing events and user interactions.

## Features

### For Admin Users:

- **Authentication**: Secure login and sign-up.
- **Event Management**: Create, update, and delete events.
- **User Management**: View and manage registered users for each event.
- **Administrative Control**: Access to all administrative functions related to event organization.

### For Regular Users:

- **Authentication**: Secure login and sign-up.
- **Event Browsing**: View a comprehensive list of all available events.
- **Registration**: Register for events of interest.
- **Registration Management**: Manage and view your event registrations.

### Session Handling:

- **Session Management**: Secure and efficient session handling for both Admin and Regular users.
- **Role-Based Access**: Enforced through session management, ensuring appropriate access levels based on user roles.

## Technical Stack

- **Backend**: Java (Servlets, JSP)
- **Architecture**: MVC (Model-View-Controller)
- **Database**: Relational Database (e.g., MySQL, PostgreSQL)
- **Session Management**: Implemented through Servlets
- **Frontend**: JSP, HTML, CSS

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/haiderali780/EventOps.git
   ```
2. **Database Setup**:
   Configure and set up your database schema as per the provided SQL scripts.
3. **Import Project**:
   Open the project in your preferred IDE (e.g., Eclipse, IntelliJ IDEA).
4. **Configure Servlet Container**:
   Set up and configure your servlet container (e.g., Apache Tomcat).
5. **Deploy and Access**:
   Deploy the application and access it via http://localhost:8080/eventmangement.

## Contributing

Contributions are welcome! If you'd like to contribute to this repository, please fork the repository, make your changes, and submit a pull request.
