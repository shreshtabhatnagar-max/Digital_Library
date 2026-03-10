📚 Digital Library Management System

A Spring Boot based Digital Library Management System that allows administrators to manage books, students, authors, and book transactions efficiently. The application exposes REST APIs for performing library operations such as issuing books, returning books, registering students, and managing book inventory.

This project demonstrates backend development using Java, Spring Boot, and MySQL with a layered architecture.

🚀 Features

📖 Add and manage books

👨‍🎓 Register and manage students

✍️ Manage authors

🔁 Issue and return books

📊 Track book transactions

✅ Custom validation for student age

🗄 Database persistence using JPA & Hibernate

🔗 RESTful API architecture

🏗️ System Architecture

The project follows a Layered Architecture (Controller → Service → Repository → Database) which ensures clean separation of concerns.

Client
  │
  ▼
Controller Layer
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
Database (MySQL)
1️⃣ Controller Layer

Handles HTTP requests and exposes REST APIs.

Example:

BookController

StudentController

TransactionController

Responsibilities:

Accept API requests

Validate request data

Call service layer

2️⃣ Service Layer

Contains business logic of the application.

Example:

BookService

StudentService

TransactionService

Responsibilities:

Implement core business rules

Process data

Coordinate between controller and repository

3️⃣ Repository Layer

Handles database operations using Spring Data JPA.

Example:

BookRepository

AuthorRepository

StudentRepository

TransactionRepository

Responsibilities:

CRUD operations

Database queries

4️⃣ Model Layer

Defines entity classes mapped to database tables.

Entities:

Book

Author

Student

Address

Transaction

Enums:

BookType

StudentStatus

TransactionType

5️⃣ DTO Layer

DTOs are used to transfer data between API and service layer.

Request DTOs

BookCreationRequest

StudentCreationRequest

BookTransactionRequest

Response DTOs

BookCreationResponse

StudentCreationResponse

TransactionResponse

Response

6️⃣ Custom Validation

Custom annotation implemented:

@StudentAgeValidation

Used to validate minimum student age requirement.

Classes:

StudentAgeValidation

ValidAge

🛠️ Tech Stack
Technology	Purpose
Java	Programming Language
Spring Boot	Backend Framework
Spring Web	REST API Development
Spring Data JPA	Database ORM
Hibernate	ORM Implementation
MySQL	Database
Maven	Dependency Management
Lombok	Boilerplate Code Reduction
Validation API	Input Validation
📂 Project Structure
Digital_Library
│
├── controller
│   ├── BookController
│   ├── StudentController
│   └── TransactionController
│
├── service
│   ├── BookService
│   ├── StudentService
│   └── TransactionService
│
├── repository
│   ├── BookRepository
│   ├── AuthorRepository
│   ├── StudentRepository
│   └── TransactionRepository
│
├── model
│   ├── Book
│   ├── Author
│   ├── Student
│   ├── Address
│   └── Transaction
│
├── request
├── response
├── annotation
└── DigitalLibraryApplication
⚙️ Installation & Setup
1️⃣ Clone the repository
git clone https://github.com/yourusername/digital-library.git
2️⃣ Navigate to project
cd digital-library
3️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
4️⃣ Run the application
mvn spring-boot:run
🔗 API Endpoints (Examples)
Student APIs
POST /student/add
GET /student/{id}
Book APIs
POST /book/add
GET /book/{id}
Transaction APIs
POST /transaction/issue
POST /transaction/return
📊 Database Entities Relationship
Author
  │
  ├── Book
        │
        ├── Transaction
              │
              └── Student
🧠 Key Concepts Implemented

REST API Design

Spring Boot Layered Architecture

DTO Pattern

Custom Validation Annotation

JPA Entity Relationships

Exception Handling

Transaction Management

👨‍💻 Author

Shresth Bhatnagar

