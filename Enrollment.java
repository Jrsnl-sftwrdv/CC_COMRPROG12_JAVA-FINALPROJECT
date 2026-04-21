public class Enrollment {

    private Student student; 
    private Section section; 

    Enrollment(Student student, Section section){
        this.student = student; 
        this.section = section; 
    }
    public Student getStudent(){
        return student; 
    }
    public Section getSection(){
        return section; 
    }

    @Override
    public String toString(){
        return  student.getStudentName() +
                "->: " + section.getSectionName(); 
    }


    
} 
