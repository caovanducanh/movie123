# MyMovie - Movie Streaming Application

## Project Overview
MyMovie is a web-based movie streaming application built with Spring Boot. It allows users to browse, search, and watch movies, as well as interact with the platform through comments and favorites. The application includes both user-facing features and administrative capabilities for content management.

## Technologies Used
- **Backend**: Java, Spring Boot, Spring MVC, Spring Data JPA
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: Microsoft SQL Server
- **Build Tool**: Maven

## Features
### User Features
- Browse and search for movies
- View movie details including description, release year, and rating
- Watch movies
- Add movies to favorites
- Comment on movies
- User authentication (login/register)

### Admin Features
- Manage movies (Create, Read, Update, Delete)
- User management
- Genre and country management

## Setup Instructions
1. Clone the repository
2. Configure your database connection in `application.properties`
3. Run the application using Maven: `mvn spring-boot:run`
4. Access the application at `http://localhost:8080/movies/home`

## Database Setup
The application uses Microsoft SQL Server. You'll need to:
1. Create a database named "MyMovie"
2. Configure the database connection in the application.properties file
3. The application is set to create the schema automatically on startup (`spring.jpa.hibernate.ddl-auto=create`)

## Project Structure
- **Controllers**: Handle HTTP requests and define application endpoints
- **Models**: Define the data structure and relationships
- **Repositories**: Interface with the database
- **Services**: Contain business logic
- **Templates**: Thymeleaf templates for the user interface

## Main Entities
- **Movie**: Core entity with properties like name, description, release year, rating
- **User**: Represents application users with authentication details
- **Genre**: Movie categories
- **Country**: Movie origin countries
- **Comment**: User comments on movies
- **FavoriteMovie**: Tracks user's favorite movies

## Usage
### For Users
1. Register for an account or log in
2. Browse movies on the home page
3. Search for specific movies using the search function
4. View movie details by clicking on a movie
5. Watch movies by clicking the watch button
6. Add movies to favorites
7. Comment on movies

### For Administrators
1. Log in with admin credentials
2. Access the admin panel
3. Manage movies, users, genres, and countries

## License
[Your License Information]

## Contributors
[Your Contributor Information]