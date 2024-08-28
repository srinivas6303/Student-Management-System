<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        h1 {
            color: #333;
        }
        h2 {
            color: #555;
        }
        code {
            background-color: #e8e8e8;
            padding: 2px 4px;
            border-radius: 4px;
        }
        pre {
            background-color: #f8f8f8;
            padding: 10px;
            border-radius: 4px;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Management System</h1>
        <h2>Overview</h2>
        <p>
            The Student Management System is a simple Java-based application that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a MySQL database.<br>
            The application demonstrates basic database connectivity and interaction using JDBC.
        </p>

        <h2>Features</h2>
        <ul>
            <li><strong>Add Student</strong>: Add a new student record to the database.</li>
            <li><strong>View Student</strong>: Retrieve and display a student's details by their ID.</li>
            <li><strong>View All Students</strong>: Retrieve and display the details of all students.</li>
            <li><strong>Update Student</strong>: Update an existing student's name.</li>
            <li><strong>Delete Student</strong>: Remove a student record from the database.</li>
        </ul>

        <h2>Prerequisites</h2>
        <ul>
            <li>Java Development Kit (JDK) 8 or higher.</li>
            <li>MySQL Database Server.</li>
            <li>MySQL JDBC Driver (mysql-connector-java).</li>
        </ul>

        <h3>Database Setup</h3>
        <p>
            Ensure MySQL is running.<br>
            Create a database named <code>project</code>:<br>
            <pre>CREATE DATABASE project;</pre>
            Create a student table in the project database:<br>
            <pre>
USE project;

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100)
);
            </pre>
        </p>

        <h3>Configure Database Connection</h3>
        <p>
            Open the <code>ConnectionManager.java</code> file.<br>
            Update the following fields with your MySQL credentials:<br>
            <pre>
String url = "jdbc:mysql://localhost:3306/project";
String username = "root";
String password = "your-password";
            </pre>
        </p>

        <h2>Classes and Working</h2>
        <h3>1. Student</h3>
        <p>
            <strong>Fields:</strong><br>
            <code>id</code>: An integer representing the student ID.<br>
            <code>name</code>: A string representing the student's name.<br>
            <strong>Methods:</strong><br>
            <code>getId()</code>: Returns the student's ID.<br>
            <code>setId(int id)</code>: Sets the student's ID.<br>
            <code>getName()</code>: Returns the student's name.<br>
            <code>setName(String name)</code>: Sets the student's name.<br>
            <code>toString()</code>: Returns a string representation of the student object.<br>
            <strong>Purpose:</strong> This class represents a student entity and encapsulates the student's details.
        </p>

        <h3>2. ConnectionManager</h3>
        <p>
            <strong>Fields:</strong><br>
            <code>con</code>: A Connection object used to interact with the MySQL database.<br>
            <code>scanner</code>: A Scanner object for reading user input.<br>
            <strong>Constructor:</strong><br>
            Initializes the database connection using JDBC.<br>
            <strong>Methods:</strong><br>
            <code>addStudent()</code>: Adds a new student record to the database by taking the student ID and name as input.<br>
            <code>getStudent()</code>: Retrieves and displays the details of a student based on the given ID.<br>
            <code>getStudents()</code>: Retrieves and displays the details of all students in the database.<br>
            <code>removeStudent()</code>: Removes a student record based on the given ID.<br>
            <code>updateStudent()</code>: Updates an existing student's name. If the student ID doesn't exist, it calls the <code>addStudent()</code> method to add a new student.<br>
            <strong>Purpose:</strong> This class manages the connection to the database and performs all CRUD operations on the student records.
        </p>

        <h3>3. Main</h3>
        <p>
            <strong>Purpose:</strong> This is the entry point of the application. It provides a menu-driven interface for the user to interact with the Student Management System.<br>
            <strong>Working:</strong> The <code>Main</code> class creates an instance of <code>ConnectionManager</code> and presents a menu with options to add, view, update, and delete student records. Based on the user's input, it calls the corresponding methods in the <code>ConnectionManager</code> class.
        </p>

        <h2>Usage</h2>
        <p>
            Upon running the application, you'll be prompted with a menu to manage student records:<br>
            <strong>Add Student</strong>: Enter student ID and name to add a new student.<br>
            <strong>View Student</strong>: Enter a student ID to view details of a specific student.<br>
            <strong>View All Students</strong>: Display details of all students in the database.<br>
            <strong>Update Student</strong>: Enter a student ID and new name to update an existing student's details.<br>
            <strong>Delete Student</strong>: Enter a student ID to remove the student from the database.<br>
            <strong>Exit</strong>: Exit the application.
        </p>

        <h2>Contributing</h2>
        <p>Contributions are welcome! Please fork the repository and create a pull request with your changes.</p>

        <h2>License</h2>
        <p>This project is licensed under the MIT License. See the <code>LICENSE</code> file for details.</p>

        <h2>Contact</h2>
        <p>For any questions or suggestions, please contact me at <a href="mailto:your-email@example.com">your-email@example.com</a>.</p>
    </div>
</body>
</html>
