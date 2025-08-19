# Task Manager Application

This is a simple **Task Manager** application built using **Spring Boot**. The application allows users to manage their tasks effectively, including creating, updating, deleting, and viewing tasks.

---

## 🚀 Getting Started

### Prerequisites

Before setting up the application, ensure you have the following installed:

- **Java 8** or higher
- **Maven**
- **MySQL** (or any compatible MySQL server)
- **IDE** (IntelliJ IDEA, Eclipse, or Visual Studio Code)

---

## Backend Setup

### Navigate to the folder and Configure the database in application.properties located at src/main/resources::

```
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=<your-mysql-username>
spring.datasource.password=<your-mysql-password>
spring.jpa.hibernate.ddl-auto=update
```
### Build and run the backend application:
```
mvn clean install
mvn spring-boot:run
```
### The backend server will start on http://localhost:8080.

## 🧪 Testing the Backend with Postman

You can use **Postman** to test the Task Manager APIs by following these steps:

### Import API Collection
Download the Postman collection file (if available) or manually create requests using the endpoints listed above.
## Task APIs

- **POST** `/tasks/addTask`: Create a new task
- **GET** `/tasks/get/{id}`: Get task by ID
- **GET** `/tasks`: Get all tasks
- **PUT** `/tasks/updateTask`: Update an existing task
- **DELETE** `/tasks/deleteTask/{id}`: Delete a task by ID
  
### An example for testing Create Task:
- **Method**: `POST`
- **URL**: `http://localhost:8080/tasks/addTask`
- **Body** (raw JSON):

```json
{
  "description": "This is a sample task description",
  "title": "Sample Task",
  "status": "Pending",
  "dueDate": "2025-01-31"
}

```


