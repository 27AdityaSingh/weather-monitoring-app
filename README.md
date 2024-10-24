Weather Monitoring Application
Overview
The Weather Monitoring Application is designed to gather, process, and monitor real-time weather data for cities across India. It leverages the OpenWeatherMap API to fetch weather information and stores it in a MySQL database for further processing. The application provides features like temperature conversion, daily/weekly summaries, and alert notifications based on configurable weather thresholds.

The project is built using Java Spring Boot for the backend, Hibernate for ORM, and MySQL as the database. The application handles real-time data processing and allows users to configure weather thresholds to trigger alerts when specific conditions are met.

Features
Fetches real-time weather data from the OpenWeatherMap API.
Stores the weather data in a MySQL database for persistence.
Provides daily and weekly weather summaries, including average, minimum, and maximum temperatures.
Supports temperature conversion between Celsius and Fahrenheit.
Configurable weather alert system based on user-defined thresholds (e.g., extreme temperatures).
Scheduled weather data fetch and summary generation using Spring's scheduling capabilities.
Table of Contents
Technologies Used
Project Structure
Setup Instructions
Usage
APIs and Endpoints
Contributing
License
Technologies Used
Java 11: Core language for the backend.
Spring Boot: Framework for building the REST API and handling backend logic.
Hibernate/Jakarta Persistence: ORM tool for interacting with MySQL.
MySQL: Relational database to store weather data.
OpenWeatherMap API: Third-party API to fetch weather data.
Maven: Dependency management and build tool.
Project Structure
Here’s the basic structure of the project:

bash
Copy code
weather-monitoring-app/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/weather/monitor/
│   │   │   │   ├── controller/
│   │   │   │   │   └── WeatherDataController.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── DailyTemperatureSummaryDTO.java
│   │   │   │   │   └── WeeklyTemperatureSummaryDTO.java
│   │   │   │   ├── model/
│   │   │   │   │   └── WeatherData.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── WeatherDataRepository.java
│   │   │   │   │   └── WeatherSummaryRepository.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── WeatherApiService.java
│   │   │   │   │   ├── WeatherDataService.java
│   │   │   │   │   └── WeatherSummaryService.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       ├── java/
│   │       └── resources/
│   └── pom.xml
│
├── README.md
└── .gitignore
Key Components
Controller: Handles incoming HTTP requests for weather data (WeatherDataController).
DTO: Data Transfer Objects used to move data between layers (DailyTemperatureSummaryDTO, WeeklyTemperatureSummaryDTO).
Model: Defines the data structure for weather information (WeatherData).
Repository: Interfaces for database interactions (WeatherDataRepository, WeatherSummaryRepository).
Service: Business logic layer that processes and schedules weather data tasks (WeatherApiService, WeatherDataService, WeatherSummaryService).
Resources: Configuration files, such as application.properties for database and API configurations.
Setup Instructions
Prerequisites
Java 11
MySQL
Maven
OpenWeatherMap API Key
Git
Step 1: Clone the Repository
Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/27AdityaSingh/weather-monitoring-app.git
cd weather-monitoring-app
Step 2: Configure MySQL Database
Create a MySQL database for the project. Run the following SQL commands to create the database:

sql
Copy code
CREATE DATABASE WEATHER_DATA;
Update the src/main/resources/application.properties file with your MySQL credentials:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/WEATHER_DATA
spring.datasource.username=root
spring.datasource.password=ADITYA27
spring.jpa.hibernate.ddl-auto=update
Step 3: Add OpenWeatherMap API Key
Update the application.properties file with your OpenWeatherMap API key:

properties
Copy code
openweathermap.api.key=0eb2fde273b7ce6a6000a64754824508
Step 4: Build and Run the Application
Build the application using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
The application will start on http://localhost:8080.

Step 5: Scheduling Weather Data Fetch
The application automatically fetches weather data and summarizes it at scheduled intervals using the WeatherSummaryScheduler class.

Usage
APIs and Endpoints
Get Daily Temperature Summary

Endpoint: GET /weather/daily-summary
Description: Returns the daily weather summary (average, minimum, maximum temperatures).
Example Response:
json
Copy code
{
  "date": "2024-10-25",
  "averageTemperature": 28.5,
  "minTemperature": 22.1,
  "maxTemperature": 32.9
}
Get Weekly Temperature Summary

Endpoint: GET /weather/weekly-summary
Description: Returns the weekly weather summary.
Configure Weather Alerts

Endpoint: POST /weather/alerts
Description: Allows users to configure temperature thresholds to trigger alerts.
Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch for your feature (git checkout -b feature-name).
Commit your changes (git commit -m "Add new feature").
Push to your branch (git push origin feature-name).
Open a Pull Request.
