import java.util.*;

public class Main{

    public static void main(String[] args){
       // Scanner sc = new Scanner(System.in); 
      //  Random rd = new Random(); 

        EnrollmentSystem system = new EnrollmentSystem();


        /* 
        System.out.print("Enter the name of the student: ");
        String inputName = sc.nextLine(); 
        //System.out.print("Generate Student Id: ");
       // int inputId = Integer.parseInt(sc.nextLine().trim()); 
        System.out.print("Enter student section: ");
        String inputSection = sc.nextLine(); 
         int idGenerator = rd.nextInt(1000000); 
         */

    Student s1 = new Student("Jade", 1, "BSIT-1A"); 
    Student s2 = new Student("Mark", 2, "BSIT-1A");
        System.out.println("_____________________________________");
        System.out.println();
       Section sec1 = new Section(101, "1A", "Programming 1", "MON 9-11", 2);

        system.addStudent(s1);
        system.addStudent(s2);
        system.addSection(sec1);

        system.enrollStudent(s1, sec1);
        system.enrollStudent(s2, sec1);
        system.displayEnrollments();


       // sc.close();
    }













}