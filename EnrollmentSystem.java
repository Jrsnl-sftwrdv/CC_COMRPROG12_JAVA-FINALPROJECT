import java.util.*;

public class EnrollmentSystem {

private ArrayList<Student> students = new ArrayList<>(); 
private ArrayList<Section> sections = new ArrayList<>(); 
private ArrayList<Enrollment> enrollments = new ArrayList<>(); 


public void addStudent(Student student){
    students.add(student);  
}

public void addSection(Section section){
    sections.add(section); 
}
public void enrollStudent(Student student, Section section){


    if(section.isFull()){
        System.out.println("This section is already full!");
        return;    
    }

    if(isConflict(student, section)){
        return; 
    }
    if(isDuplicate(student, section)){
        return; 
    }

    enrollments.add(new Enrollment(student, section)); 
    section.plusEnrolled();

    System.out.println("Enrollment successful!");
/* 

   for (int i = 0; i < enrollments.size(); i++) {
    Enrollment e = enrollments.get(i);

    if (e.getStudent().getStudentName().equals(student.getStudentName()) && e.getSection().getSectionName().equals(section.getSectionName()) ) {

        System.out.println("Duplicate detected... Enrollment blocked");
        return;         
    }
}*/

   /* for(int i = 0; i <  enrollments.size(); i++){
        Enrollment e = enrollments.get(i); 

        if(e.getStudent().getStudentName().equals(student.getStudentName()) && e.getSection().getSchedule().equals(section.getSchedule())){

            System.out.println("Cannot enroll due to overlapping schedule!");
            return; 
        }

    }
}
    */ 
}
public void displayEnrollments() {
    for (Enrollment e : enrollments) {
        System.out.println(e);
    }

}
//DUPLICATION DONE 
private boolean isDuplicate(Student student, Section section){

    for(int i = 0; i < enrollments.size(); i++){ 
        Enrollment e = enrollments.get(i); 
        if (e.getStudent().getStudentName().equals(student.getStudentName()) && e.getSection().getSectionName().equals(section.getSectionName())) {
            System.out.println("Duplication detected");
            return true; 
        }
    }
    return false; 
}

//SCHEDULE CONFLICT DONE 
private boolean isConflict(Student student, Section section){

    for(int i = 0; i < enrollments.size(); i++){
        Enrollment e = enrollments.get(i); 
        if(e.getStudent().getStudentName().equals(student.getStudentName()) && e.getSection().getSchedule().equals(section.getSchedule())){

            System.out.println("Schedule cannot overlap!");
            return true; 
        }

    }
    return false; 
}

public Section findSection(String sectionName) {
    for (Section s : sections) {
        if (s.getSectionName().equals(sectionName)) {
            return s;
        }
    }
    return null;
}
private int idCounter = 1;

public int getNextId() {
    return idCounter++;
}


}
