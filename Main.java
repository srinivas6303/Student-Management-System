import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConnectionManager connectionManager = new ConnectionManager();

        while (true) {
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Add STUDENT");
            System.out.println("2. Remove STUDENT");
            System.out.println("3. View STUDENT");
            System.out.println("4. View STUDENTS");
            System.out.println("5. Update STUDENT");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    connectionManager.addStudent();
                    break;
                case 2:
                    connectionManager.removeStudent();
                    break;
                case 3:
                    connectionManager.getStudent();
                    break;
                case 4:
                    connectionManager.getStudents();
                    break;
                case 5:
                    connectionManager.updateStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // For better readability
        }
    }
}