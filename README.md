### Introduction

The banking application is designed to simplify banking operations through a RESTful API interface. Developed using Spring Boot, Spring Data JPA (Hibernate), and a MySQL database, it encapsulates the core functionalities of a banking system. This application enables the creation and management of bank accounts, alongside performing transactions such as deposits and withdrawals. Designed with scalability and ease of use in mind, it's an ideal starting point for developers looking to understand the integration of Spring Boot with database operations in a financial context.

### Used Tech Stack and Tools

JAVA
Spring
Spring Boot
Spring Data JPA
Hibernate
MySQL database
Postman
Git
GitHub

### Modules

The application is structured into several key modules:

1. *Account Management:* Handles the creation, fetching, and deletion of bank accounts.
2. *Transaction Processing:* Supports deposit and withdrawal operations, maintaining transaction integrity and balance consistency.
3. *Data Persistence:* Utilizes Spring Data JPA (Hibernate) for ORM capabilities, ensuring efficient data storage and retrieval.
4. *Security:* (If applicable) Implements basic security measures to protect account information and transactions.
5. *Utility Services:* Offers additional services such as account balance inquiries, transaction history, etc.

### Installation and Running Process

1. *Prerequisites:*
- Java JDK 11 or higher
- Maven for project dependency management
- MySQL server for the database

2. *Database Setup:*
- Create a MySQL database named banking_app.
- Update application.properties with the correct database URL, username, and password.

3. *Building the Application:*
- Navigate to the project directory in the terminal.
- Run mvn clean install to build the project.

4. *Running the Application:*
- Execute mvn spring-boot:run to start the application.

### Sample API response On Postman
**POST:** `http://localhost:8080/api/accounts`

- **Request Body**

  ```json
  {
    "Mobile": "85022457580",
    "password": "pass@12"
  }

- **Response:**
    ```json
{
    "id": 6,
    "accountHolderName": "Tauheed",
    "balance": 10000.0
}
  

### Features

- *Creating a Bank Account:* Allows users to create a new bank account with initial details.
- *Fetching Account Details:* Users can retrieve details of their account, including balance and transaction history.
- *Making Deposits/Withdrawals:* Supports transactions to deposit or withdraw funds from an account.
- *Deleting an Account:* Enables the removal of a bank account from the system.
- *Transaction History:* View a log of all transactions associated with an account.

The project contains typical elements of a Maven-based Spring Boot application, including source code in the src directory, Maven wrapper scripts (mvnw, mvnw.cmd), and the project object model file (pom.xml). To accurately generate the UML and ER diagrams, I'll review the source code, focusing on the Java classes and the database interactions.

### Application Architecture Summary

The application likely follows a typical Spring Boot project structure:

- **src/main/java** for the application source code, including:
- *Model classes* representing entities (e.g., Account, Transaction).
- *Repository interfaces* for data access layer abstraction using Spring Data JPA.
- *Service classes* for business logic (e.g., AccountService, TransactionService).
- *Controller classes* for REST API endpoints (e.g., AccountController, TransactionController).

- **src/main/resources** for configuration files, such as:
- **application.properties** for application configuration including database connection settings.

The *Maven configuration* (pom.xml) manages project dependencies, including Spring Boot starters for web, JPA, and MySQL connector.
