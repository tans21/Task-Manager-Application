# Task Manager Application

## Introduction

The Task Manager Application is a full-stack solution designed to assist users in managing their tasks efficiently. The project is divided into two main parts: a backend built with Java and Spring Boot, and a frontend developed using React with Vite and Tailwind CSS. The backend provides RESTful endpoints to create, read, update, toggle the completion status, and delete tasks, while the frontend offers an intuitive user interface that communicates with these endpoints using Axios. This application is ideal for those looking for a simple yet effective way to manage everyday to-do lists and track upcoming deadlines.

## Features

- **Task Creation and Management**: Add new tasks with a title and due date, update existing tasks, and remove tasks once completed.
- **Toggle Task Completion**: Quickly mark tasks as complete or incomplete with a simple click.
- **RESTful API Endpoints**: The backend exposes endpoints that allow for creating, retrieving, updating, and deleting tasks, ensuring smooth communication between client and server.
- **Responsive Frontend**: The user interface is built using React together with Tailwind CSS, ensuring a responsive and modern look on all devices.
- **Data Persistence**: Backend data is stored in a PostgreSQL database using Spring Data JPA, ensuring stability and scalability.
- **Validation and Error Handling**: Server-side validation is implemented using Java Bean Validation, ensuring that each task contains a valid title and due date.

## Requirements

### Backend

- **Java**: Version 17 is required.
- **Maven**: Maven is used to build and manage the project dependencies.
- **PostgreSQL**: A PostgreSQL database is needed to store the task data. Configure the connection via the `application.properties` file using appropriate credentials.
- **Spring Boot**: The application is built using Spring Boot 2.6.6 with dependencies such as Spring Data JPA, Spring Web, and Spring Boot Starter Validation.

### Frontend

- **Node.js**: A recent version of Node.js is required.
- **npm or yarn**: Use npm or yarn as the package manager.
- **Vite**: The project uses Vite for fast builds and development.
- **React**: The frontend is built with React to create a dynamic user interface.
- **Tailwind CSS**: Tailwind CSS is used for styling the frontend.

## Installation

### Backend Installation

1. **Clone the Repository**  
   Clone the repository to your local machine:
   ```bash
   git clone https://github.com/tans21/Task-Manager-Application.git
   ```

2. **Configure the Database**  
   Update the `application.properties` file (located in `BACKEND/src/main/resources`) with your PostgreSQL database connection details:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/task_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   ```
   
3. **Build and Run the Application**  
   Navigate to the BACKEND folder and run Maven:
   ```bash
   cd BACKEND
   mvn spring-boot:run
   ```
   This command compiles the project and starts the Spring Boot server on the default port (typically 8080).

### Frontend Installation

1. **Install Dependencies**  
   In a new terminal window, navigate to the FRONTEND folder and install the dependencies:
   ```bash
   cd FRONTEND
   npm install
   ```
   
2. **Run the Frontend**  
   Start the development server using Vite:
   ```bash
   npm run dev
   ```
   The frontend should now be accessible in your browser, and it will automatically make API calls to the backend endpoints.

## Contributing

Contributions to the Task Manager Application are welcomed. If you would like to contribute, please follow these guidelines:

- **Fork the Repository**: Create a fork of the repository and clone it locally.
- **Create a Feature Branch**: Work on a separate branch for each feature or bug fix.
- **Write Clear Code and Tests**: Ensure that your code follows the project’s style guidelines. Include tests for new features or fixes where possible.
- **Submit a Pull Request**: Once your changes are ready, submit a pull request with a clear description of the changes you have made.
- **Feedback and Improvements**: Engage in discussion with other contributors to refine and improve your contribution.

I appreciate your interest in improving the Task Manager Application and welcome any ideas or improvements.

--------------------------------------------------
