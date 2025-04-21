# QEATS

Project Summary
The QEats project aims to build a distributed Java backend for a popular food ordering app. The primary goal is to use JSON as the data interchange format, implement REST APIs using Spring Boot, handle asynchronous flows, and integrate with MongoDB for data persistence. The project involves setting up serialization with Jackson, building a REST API server, writing unit tests using Mockito and JUnit, and retrieving restaurant data based on user location.



Project Deliverables


Business Logic Implementation:
- Developed core business logic for handling restaurant data and user interactions.
- Implemented services for retrieving restaurant data based on user location and managing restaurant details.

REST API Development:
- Designed and built a REST API server using Spring Boot to handle client requests.
- Implemented endpoints for retrieving a list of restaurants based on user’s latitude and longitude.
- Ensured proper JSON serialization and deserialization using Jackson.

Asynchronous Processing:
- Handled asynchronous flows in the REST API server to improve performance and responsiveness.

Unit Testing:
- Wrote and fixed unit tests using Mockito and JUnit to ensure the reliability of the service layer.
- Used @InjectMocks and @Mock annotations to mock dependencies and test service logic.

NoSQL Database Integration:
- Integrated MongoDB using Spring Data for persistent storage of restaurant data.
- Designed a fixed schema for the database, including tables for Coordinates, Weather, Main, Wind, Clouds, Sys, and relationships between them.
- Implemented repository interfaces for data access and retrieval.

Data Retrieval and Display:
- Implemented functionality to retrieve restaurant data from MongoDB and return it to the service layer.
- Verified the integration by displaying real restaurant data on the QEats android app.



Skills + Tech Stacks
Tech Stack:
- Java
- Spring Boot for REST API server
- Jackson for JSON serialization and deserialization
- Lombok for boilerplate code reduction
- JUnit and Mockito for unit testing
- MongoDB for NoSQL database
- Spring Data for MongoDB integration

Skills Demonstrated:
- Object-Oriented Programming: Applied principles such as encapsulation, polymorphism, and abstraction.
- REST API Development: Implemented REST endpoints using Spring Boot.
- JSON Serialization: Used Jackson for converting Java objects to JSON and vice versa.
- Asynchronous Programming: Handled asynchronous flows in REST API server.
- Unit Testing: Wrote and fixed unit tests using JUnit and Mockito.
- Dependency Injection: Utilized @InjectMocks and @Mock annotations in unit tests.
- NoSQL Database: Integrated MongoDB using Spring Data and defined a fixed schema.
- Debugging: Identified and resolved logical and syntactical errors in the application.



Key Learnings


Technical Learnings:
- Applied OOP principles to design and implement a scalable and maintainable application.
- Gained experience in REST API development using Spring Boot.
- Enhanced skills in JSON serialization and deserialization using Jackson.
- Improved understanding of asynchronous programming in a REST API context.
- Learned to write and fix unit tests using JUnit and Mockito.
- Gained proficiency in NoSQL database integration using MongoDB and Spring Data.
- Understood the importance of a fixed schema for database design and implementation.
