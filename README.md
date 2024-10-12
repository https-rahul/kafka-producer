# Spring Boot Kafka Application

This is a simple Spring Boot application that integrates with Apache Kafka for sending messages. The application demonstrates how to produce and consume messages via Kafka, using Spring's `KafkaTemplate` and `@KafkaListener`.

## Features

- **Send messages to Kafka:** The application allows sending messages to a Kafka topic.
- **Dockerized Kafka:** Kafka runs on Docker, making it easy to set up and manage.
- **Spring Boot RestController:** Provides endpoints for interacting with Kafka via HTTP requests.

## Project Structure

- **controller**: Contains the REST controllers for handling HTTP requests.
  - `HomeController`: Handles '/' requests.
  - `KafkaController`: Provides endpoints for sending messages to Kafka.
  
- **model**: Contains the data model for the application.
  - `MessageRequest`: The data model used to send messages.

- **services**: Contains the service layer logic.
  - `KafkaProducerService`: Responsible for producing and sending messages to Kafka.

## Technologies Used

- Java 21
- Spring Boot 3.3.4
- Apache Kafka 7.2.1
- Docker 3
- Maven
