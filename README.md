Student Management System
Overview
The Student Management System is a simple Java-based application that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a MySQL database.<br> The application demonstrates basic database connectivity and interaction using JDBC.

Features
Add Student: Add a new student record to the database.<br>
View Student: Retrieve and display a student's details by their ID.<br>
View All Students: Retrieve and display the details of all students.<br>
Update Student: Update an existing student's name.<br>
Delete Student: Remove a student record from the database.<br>
Prerequisites
Java Development Kit (JDK) 8 or higher.<br>
MySQL Database Server.<br>
MySQL JDBC Driver (mysql-connector-java).<br>
Database Setup
Ensure MySQL is running.<br> Create a database named project:<br>

<pre>CREATE DATABASE project;</pre><br>
Create a student table in the project database:<br>

<pre> USE project; CREATE TABLE student ( id INT PRIMARY KEY, name VARCHAR(100) ); </pre>
Configure Database Connection
Open the ConnectionManager.java file.<br> Update the following fields with your MySQL credentials:<br>

<pre> String url = "jdbc:mysql://localhost:3306/project"; String username = "root"; String password = "your-password"; </pre>
Classes and Working
1. Student<br> Fields:<br>

id: An integer representing the student ID.<br>
name: A string representing the student's name.<br> Methods:<br>
getId(): Returns the student's ID.<br>
setId(int id): Sets the student's ID.<br>
getName(): Returns the student's name.<br>
setName(String name): Sets the student's name.<br>
toString(): Returns a string representation of the student object.<br> Purpose: This class represents a student entity and encapsulates the student's details.<br>
2. ConnectionManager<br> Fields:<br>

con: A Connection object used to interact with the MySQL database.<br>
scanner: A Scanner object for reading user input.<br> Constructor:<br> Initializes the database connection using JDBC.<br> Methods:<br>
addStudent(): Adds a new student record to the database by taking the student ID and name as input.<br>
getStudent(): Retrieves and displays the details of a student based on the given ID.<br>
getStudents(): Retrieves and displays the details of all students in the database.<br>
removeStudent(): Removes a student record based on the given ID.<br>
updateStudent(): Updates an existing student's name. If the student ID doesn't exist, it calls the addStudent() method to add a new student.<br> Purpose: This class manages the connection to the database and performs all CRUD operations on the student records.<br>
3. Main<br> Purpose: This is the entry point of the application. It provides a menu-driven interface for the user to interact with the Student Management System.<br> Working: The Main class creates an instance of ConnectionManager and presents a menu with options to add, view, update, and delete student records. Based on the user's input, it calls the corresponding methods in the ConnectionManager class.<br>

Usage
Upon running the application, you'll be prompted with a menu to manage student records:<br>

Add Student: Enter student ID and name to add a new student.<br>
View Student: Enter a student ID to view details of a specific student.<br>
View All Students: Display details of all students in the database.<br>
Update Student: Enter a student ID and new name to update an existing student's details.<br>
Delete Student: Enter a student ID to remove the student from the database.<br>
Exit: Exit the application.<br>
