package model;
import java.io.*;
import java.text.*;

public class Student
{   private String name;
    
    public Student(String name)
    {   this.name = name;  }
    
    public boolean has(String name)
    {   return this.name.equals(name);  }
    
    public boolean isMale()
    {   return name.endsWith("o");  }

    public boolean isFemale()
    {   return name.endsWith("a");  }

    public boolean isUnspecified()
    {   return !(isMale() || isFemale());  }
       
   public String name()
   {    return name;    }
}
