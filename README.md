# Atelier Resleriana Data API

A Spring Boot Java backend API that provides access to Atelier Resleriana game data, including characters and memorias with their relevant information.

## Overview

This project serves as a RESTful API backend for Atelier Resleriana data. It connects to a PostgreSQL database and provides endpoints to retrieve information about characters, memorias, and other game-related data.

## Features

- RESTful API endpoints for Atelier Resleriana game data
- Character information retrieval with detailed attributes
- Memoria data access with relevant stats and properties
- Built with Spring Boot for robust performance and easy extensibility
- PostgreSQL database integration

## Technologies

- Java
- Spring Boot
- PostgreSQL
- Hibernate/JPA
- RESTful API design

## Prerequisites

- JDK 17 or newer
- Gradle
- PostgreSQL database

The database schema is generated using [Resleriana DB SQL generator](https://github.com/jsncrz/resleriana-db-sql-generator). Please refer to that project for database setup instructions.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/jsncrz/resleriana-DB.git
   cd atelier-resleriana-api
   ```

2. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/atelier_resleriana
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Build the project:
   ```bash
   ./gradlew build
   ```

4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

## API Endpoints
### Important Note
**All API requests require the `Accept-Language` header set to either `jp` or `en` to specify the language of the returned data.**


### Characters

- `GET /api/v1/characters` - Retrieve all characters
- `GET /api/v1/characters/{id}` - Retrieve a specific character by ID

### Memorias

- `GET /api/v1/memorias` - Retrieve all memorias
- `GET /api/v1/memorias/{id}` - Retrieve a specific memoria by ID

## Usage Examples

Retrieve all characters in English:
```bash
curl -X GET http://localhost:8080/api/v1/characters -H "Accept-Language: en"
```

Retrieve a specific character in Japanese:
```bash
curl -X GET http://localhost:8080/api/v1/characters/1 -H "Accept-Language: jp"
```

## Docker Support

Docker support is planned but not currently implemented. Stay tuned for future updates.

## Acknowledgments

- Atelier Resleriana game developers.
- [theBowJa's resleriana-db](https://github.com/theBowja/resleriana-db) JSON data is used for this project. 