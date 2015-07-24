package model;
import java.io.*;

public class Room
{   private int id;
    private Student student;

    public Room(int id)
    {   this.id = id;   }
    
    public boolean isFree()
    {   return student == null; }

    public boolean isUsed()
    {   return !isFree(); }
    
    public boolean isMale()
    {   return (student != null) && (student.isMale());  }

    public boolean isFemale()
    {   return (student != null) && (student.isFemale());  }

    public boolean isUnspecified()
    {   return !(isMale() || isFemale());  }

    public void add(Student student)
    {   this.student = student; }

    public void clear()
    {   student = null; }
        
    public boolean has(String name)
    {   return (student != null) && student.has(name);   }
    
    public int id()
    {   return id;  }
    
    public Student student()
    {   return student; }
}
