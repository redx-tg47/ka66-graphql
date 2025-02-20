# ka66-graphql

## Overview
This is a Spring Boot application that exposes a GraphQL API for managing books.
It provides CRUD operations to add, retrieve, update, and delete books using GraphQL queries and mutations.

## Technologies Used
- Java 17
- Spring Boot 3+
- Spring GraphQL
- GraphiQL Playground
- Gradle

## Setup Instructions

### Prerequisites
Ensure you have the following installed:
- Java 17
- Maven 3+
- Gradle
- An IDE like IntelliJ IDEA or VS Code

### Clone the Repository
```sh
git clone https://github.com/your-repo/ka66-graphql.git
cd ka66-graphql
```

### Build and Run
```sh
mvn clean install
mvn spring-boot:run
```

## Application Configuration

### Enable GraphiQL Playground
Add the following to `application.properties`:
```properties
spring.graphql.graphiql.enabled=true
spring.graphql.graphiql.path=/graphiql
```
GraphiQL can be accessed at: **http://localhost:8080/graphiql**

## GraphQL API Endpoints

### Queries
#### Get All Books
```graphql
query {
  getBooks {
    id
    title
    author
  }
}
```
#### Get Book by ID
```graphql
query {
  getBookById(id: 1) {
    id
    title
    author
  }
}
```

### Mutations
#### Add a New Book
```graphql
mutation {
  addBook(title: "Microservices with Spring Boot", author: "Sam Newman") {
    id
    title
    author
  }
}
```
#### Update a Book
```graphql
mutation {
  updateBook(id: 1, title: "Refactoring", author: "Martin Fowler") {
    id
    title
    author
  }
}
```
#### Delete a Book
```graphql
mutation {
  deleteBook(id: 2)
}
```

## Running Tests
```sh
mvn test
```
