public class Section{

    private int sectionId; 
    private String sectionName; 
    private String subjectName; 
    private String schedule; 
    private int capacity; 
    private int enrolledCount; 

   public Section  (int id, String sectionName, String subjectName, String schedule, int capacity) {
    
    this.sectionId = id; 
    this.sectionName = sectionName; 
    this.subjectName = subjectName; 
    this.schedule = schedule;
    this.capacity = capacity; 
    this.enrolledCount = 0; 

    }
    public int getSectionId(){
        return sectionId; 
    }
    public String getSectionName(){
        return sectionName; 
    }
    public String getSubjectName(){
        return subjectName; 
    }
    public String getSchedule(){
        return schedule; 
    }
    public int getCapacity(){
        return capacity; 
    }
    public int getEnrolledCount(){
        return getEnrolledCount();
    }
    public void plusEnrolled(){
        enrolledCount++; 
    }
    public boolean isFull(){
        return enrolledCount >= capacity; 
    }

    @Override
    public String toString(){
return "Section ID: " + sectionId 
        + "\nSection: " + sectionName + 
        "\nSubject: " + subjectName + 
        "\nSchedule: " + schedule +
        "\nCapacity: " + enrolledCount + "/" + capacity; 
    }
    
}