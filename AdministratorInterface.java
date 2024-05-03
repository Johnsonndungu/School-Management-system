import java.util.Scanner;
import java.util.InputMismatchException;

// Administrator management class
public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean running = true;
        while (running){
            System.out.println("\nwelcome to Management portal");
            System.out.println("1. Add new student");
            System.out.println("2. Update student information");
            System.out.println("3.View student details");
            System.out.println("4. View all students");
            System.out.println("5.Exit");
            System.out.print("Enter your selection: ");

            try {
                int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection){
                case 1:
                    addNewstudent();
                    break;
                case 2:
                    UpdateStudentInformation();
                    break;
                case 3:
                    Viewstudentdetails();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting .....");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid.Try again");
            }

        } catch (InputMismatchException e){
            System.out.println("Invalid Input.Please enter a number.");
            scanner.nextLine(); // clear the invalid input
            }catch (NumberFormatException e){
                System.out.println("Invalid Character use numerical value.");
                scanner.nextLine(); // clear the invalid input
            }
        }
        scanner.close();
    }
    private static void addNewstudent(){
        try {
            System.out.println("Enter student details: ");
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("ID: ");
            int id = scanner.nextInt();
            System.out.println("Age: ");
            int age = scanner.nextInt();
            System.out.println("Grade: ");
            double grade = scanner.nextDouble();
            StudentManagement.addStudent(name, id, age, grade);
            System.out.println("Student added successfully");
        }catch (NumberFormatException e) {
            System.out.println("Invalid Id or age format use numerical values.");
            scanner.nextLine(); //clear the incorrect user input
        }
    }
    private static void UpdateStudentInformation(){
      try {
          System.out.println("Enter student id to update: ");
          int id = scanner.nextInt();
          scanner.nextLine();
          Student student = StudentManagement.getStudent(id);
          if (student != null) {
              System.out.println("Enter new student details:");
              System.out.println("Name: ");
              String name = scanner.nextLine();
              System.out.println("ID: ");
              int newId = scanner.nextInt();
              System.out.println("Age: ");
              int age = scanner.nextInt();
              System.out.println("Grade: ");
              double grade = scanner.nextDouble();
              StudentManagement.addStudent(name, id, age, grade);
              System.out.println("Student added successfully");
          } else {
              System.out.println("Student not found with ID: " + id);
          }
      }catch (NumberFormatException e) {
          System.out.println("Invalid ID format");
          scanner.nextLine(); // clear the incorrect id
      }
    }
    private static void Viewstudentdetails(){
      try {
          System.out.println("Enter student ID to view: ");
          int id = scanner.nextInt();
          scanner.nextLine();
          Student student = StudentManagement.getStudent(id);
          if (student != null) {
              System.out.println("Student Details:");
              System.out.println(student);
          } else {
              System.out.println("Student not found!");
          }
      }catch (NumberFormatException e) {
          System.out.println("Invalid Id");
          scanner.nextLine();
      }
    }
    private static void viewAllStudents(){
        System.out.println("All students");
        for (Student student : StudentManagement.getAllStudents()){
            System.out.println(student);
        }
    }
}
