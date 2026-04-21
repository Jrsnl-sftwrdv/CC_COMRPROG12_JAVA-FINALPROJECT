public class Subject {

    private int subjectId; 
    private String subjectName; 
    private int units; 
    Subject(int subjectId, String name, int units){

        this.subjectId = subjectId; 
        this.subjectName = name; 
        this.units = units; 
    }

    public int getSubjectId(){
        return subjectId;
    }
    public String getSubjectName(){
        return subjectName; 
    }
    public int getUnits(){
        return units; 
    }

    @Override 
    public String toString(){
        return "Subject Id: " + subjectId +
                "\nSubject Name: " + subjectName +
                "\nUnits: " + units; 
    }
    
}
