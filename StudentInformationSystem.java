import java.util.Scanner;

public class StudentInformationSystem {

    static Scanner sc = new Scanner(System.in);
    static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getInt("Enter choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("\n===== Student Information System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int age;
        do {
            age = getInt("Enter Age: ");
        } while (!ValidationUtils.isValidAge(age));

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine().toUpperCase();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        Student s = new Student(id, name, age, grade, contact);
        manager.addStudent(s);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (manager.getAllStudents().isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("ID        Name            Age   Grade    Contact");
        System.out.println("------------------------------------------------");
        for (Student s : manager.getAllStudents()) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID or Name: ");
        String key = sc.nextLine();

        Student s = manager.findStudent(key);
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Student not found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    static int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number!");
            }
        }
    }
}
