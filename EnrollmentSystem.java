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

public Student getStudent(String name, String section) {
    for (int i = 0; i < students.size(); i++) {
        Student studentObj = students.get(i);
        if (studentObj.getStudentName().toLowerCase().equals(name.toLowerCase()) && section.equals(studentObj.getStudentSection())) { 
            return studentObj;
        }
    }
    
    return null;
}

public void removeStudent(Student student) {
    students.remove(student);
}

public String validateEnrollment(String studentName, Section section){
    if(section.isFull()){
        return "This section is already full!";
    }

    for(int i = 0; i < enrollments.size(); i++){
        Enrollment e = enrollments.get(i);
        if(e.getStudent().getStudentName().equals(studentName)){
            if(e.getSection().getSectionName().equals(section.getSectionName())
                    || e.getSection().getSchedule().equals(section.getSchedule())){
                return "Student/s cannot have duplicate or overlapped schedule.";
            }
        }
    }

    return null;
}
public String tryEnrollStudent(Student student, Section section){
    if(section.isFull()){
        return "This section is already full!";
    }

    if(isConflict(student, section) || isDuplicate(student, section)){
        return "Student/s cannot have duplicate or overlapped schedule.";
    }

    enrollments.add(new Enrollment(student, section));
    section.plusEnrolled();

    return "Enrollment successful!";
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

public void enrollStudent(Student student, Section section){
    System.out.println(tryEnrollStudent(student, section));
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
