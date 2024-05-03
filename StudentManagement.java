import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private static int totalStudents = 0;
    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(String name,int id,int age,double grade){
        studentList.add(new Student(name,id,age,grade));
        totalStudents++;
    }
    public static void updateStudent(String newName,int id,int newId,int newAge,double newGrade){
        for (Student student : studentList){
            if(student.getId() == id){
                student.setName(newName);
                student.setId(newId);
                student.setAge(newAge);
                student.setGrade(newGrade);
                break;
            }
        }
    }
    public static Student getStudent(int id){
        for (Student student : studentList){
            if (student.getId() == id){
                return student;
            }
        }
        return  null;
    }
    public static List<Student> getAllStudents(){
        return studentList;
