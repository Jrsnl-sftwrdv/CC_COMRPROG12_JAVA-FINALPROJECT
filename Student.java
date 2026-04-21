
public class Student {

   private String studentName; 
   private int studentId; 
   private String studentSection; 

    Student(String name, int id, String section){

        this.studentName = name; 
        this.studentId = id; 
        this.studentSection = section; 
    }

    public String getStudentName() {
        return studentName; 
    }
    public void setStudentName(String studentName){
        studentName = studentName; 
    }
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        studentId = studentId; 
    }
    public String getStudentSection(){
        return studentSection; 
    }
    public void setStudentSection(String studentSection){
        studentSection = studentSection; 
    }


}
