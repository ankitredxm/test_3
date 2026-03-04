package src.main.java.com.sms;
import java.util.Scanner;

public class Main {

    private static void printLine() {
        System.out.println("==================================================");
    }

    private static void printTitle(String title) {
        printLine();
        System.out.printf("              %s%n", title);
        printLine();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("  1. Add Student");
        System.out.println("  2. View Students");
        System.out.println("  3. Search Student");
        System.out.println("  4. Delete Student");
        System.out.println("  5. Exit");
        System.out.println();
        printLine();
        System.out.print("  Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            printTitle("STUDENT MANAGEMENT SYSTEM");
            printMenu();

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\n  ❌ Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    printTitle("ADD STUDENT");

                    System.out.print("  Enter ID          : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("  Enter Name        : ");
                    String name = scanner.nextLine();

                    System.out.print("  Enter Age         : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("  Enter Department  : ");
                    String dept = scanner.nextLine();

                    manager.addStudent(new Student(id, name, age, dept));
                    System.out.println("\n  ✅ Student added successfully!");
                    break;

                case 2:
                    printTitle("ALL STUDENTS");
                    manager.viewAllStudents();
                    break;

                case 3:
                    printTitle("SEARCH STUDENT");
                    System.out.print("  Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchStudentById(searchId);
                    break;

                case 4:
                    printTitle("DELETE STUDENT");
                    System.out.print("  Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    System.out.println("\n  🗑️ Delete operation completed.");
                    break;

                case 5:
                    printLine();
                    System.out.println("  👋 Thank you for using the system!");
                    printLine();
                    scanner.close();
                    return;

                default:
                    System.out.println("\n  ❌ Invalid choice! Try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
}