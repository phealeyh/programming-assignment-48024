package model;
import java.io.*;
import java.util.*;
public class Tower extends Viewable
{   private LinkedList<Apt> apts = new LinkedList<Apt>(); //core data that needs to be changed
	
    public Tower()
    {   for (int floor = 1; floor <= 10; floor++)
        {   apts.add(new Apt(floor, 1, 1));
            apts.add(new Apt(floor, 2, 3));
            apts.add(new Apt(floor, 3, 2));   }}

    public void add(String name)
    {   add(new Student(name));
        notifyAllViews(); //notify panels
    }
    
    public void add(Student student)
    {   for (Apt apt: apts)
            if (apt.canFit(student))
            {   apt.add(student);
                notifyAllViews(); //notify panels
                break;  }
    }
    
    public void move(String name)
    {   Room room = room(name);
        add(room.student());
        room.clear();   
        notifyAllViews(); //notify panels
    }
            
    private Room room(String name)
    {   for (Apt apt: apts)
        {   Room room = apt.room(name);
            if (room != null)
                return room;    }
        return null;    }
        
    public Apt apt(int id)
    {   for (Apt apt: apts)
            if (apt.matches(id))
                return apt;
        return null;    }
        
   public LinkedList<String> used()
   {    LinkedList<String> used = new LinkedList<String>();
        for (Apt apt: apts)
            if (apt.isUsed())
                used.add("" + apt.id());
        return used;    }
      
   public void attachPanel(View view){
	   attach(view);
   }

}
