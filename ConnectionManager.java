import java.sql.*;
import java.util.Scanner;

public class ConnectionManager {
    private Connection con;
    private Scanner scanner;

    public ConnectionManager() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "Srinu@4848";
        scanner = new Scanner(System.in);

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void addStudent() {
        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        String sql = "INSERT INTO student(id, name) VALUES(?, ?)";
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        if (id <= 0) {
            System.out.println("Invalid ID. Please enter a positive integer.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.next();

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows > 0 ? "Student added successfully!" : "Failed to add student!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void getStudent() {
        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        String sql = "SELECT * FROM student WHERE id=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("Student Details: " + studentId + " " + name);
            } else {
                System.out.println("Data not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
    }

    public void getStudents() {
        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        String sql = "SELECT * FROM student";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("Student Details: " + id + " " + name);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }

    public void removeStudent() {
        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        String sql = "DELETE FROM student WHERE id=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Student record deleted." : "Student record not found.");
        } catch (SQLException e) {
            System.out.println("Error removing student: " + e.getMessage());
        }
    }

    public void updateStudent() {
        if (con == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }

        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        System.out.print("Enter new name for the student: ");
        String name = scanner.next();

        String sql = "UPDATE student SET name=? WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student record updated.");
            } else {
                System.out.println("Student record not found. Adding new student record...");
                addStudent();
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
}