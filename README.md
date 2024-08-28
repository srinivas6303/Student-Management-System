# Student Management System

## Overview
The Student Management System is a simple Java-based application that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a MySQL database.<br> The application demonstrates basic database connectivity and interaction using JDBC.

## Features
- **Add Student**: Add a new student record to the database.
- **View Student**: Retrieve and display a student's details by their ID.
- **View All Students**: Retrieve and display the details of all students.
- **Update Student**: Update an existing student's name.
- **Delete Student**: Remove a student record from the database.

## Prerequisites
- Java Development Kit (JDK) 8 or higher.
- MySQL Database Server.
- MySQL JDBC Driver (mysql-connector-java).

### Database Setup
Ensure MySQL is running.<br>
Create a database named project:<br>
sql<br>
CREATE DATABASE project;
<br>
Create a student table in the project database:<br>
sql<br>
USE project;<br>

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100)
);

### Configure Database Connection
Open the ConnectionManager.java file.<br>
Update the following fields with your MySQL credentials:<br>
java<br>
String url = "jdbc:mysql://localhost:3306/project";<br>
String username = "root";<br>
String password = "your-password";<br>


### Classes and Working
**1. Student**
Fields:
id: An integer representing the student ID.
name: A string representing the student's name.
Methods:
getId(): Returns the student's ID.
setId(int id): Sets the student's ID.
getName(): Returns the student's name.
setName(String name): Sets the student's name.
toString(): Returns a string representation of the student object.
Purpose: This class represents a student entity and encapsulates the student's details.

**2. ConnectionManager**
Fields:
con: A Connection object used to interact with the MySQL database.
scanner: A Scanner object for reading user input.
Constructor:
Initializes the database connection using JDBC.
<br>
Methods:
addStudent(): Adds a new student record to the database by taking the student ID and name as input.
getStudent(): Retrieves and displays the details of a student based on the given ID.
getStudents(): Retrieves and displays the details of all students in the database.
removeStudent(): Removes a student record based on the given ID.
updateStudent(): Updates an existing student's name. If the student ID doesn't exist, it calls the addStudent() method to add a new student.
Purpose: This class manages the connection to the database and performs all CRUD operations on the student records.

**3. Main**
Purpose: This is the entry point of the application. It provides a menu-driven interface for the user to interact with the Student Management System.
Working: The Main class creates an instance of ConnectionManager and presents a menu with options to add, view, update, and delete student records. Based on the user's input, it calls the corresponding methods in the ConnectionManager class.

## Usage
Upon running the application, you'll be prompted with a menu to manage student records:<br>
Add Student: Enter student ID and name to add a new student.<br>
View Student: Enter a student ID to view details of a specific student.<br>
View All Students: Display details of all students in the database.<br>
Update Student: Enter a student ID and new name to update an existing student's details.<br>
Delete Student: Enter a student ID to remove the student from the database.<br>
Exit: Exit the application.
