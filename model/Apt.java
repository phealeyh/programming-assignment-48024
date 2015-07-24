package model;

import java.io.*;
import java.util.*;

public class Apt
{   private int id;
    private LinkedList<Room> rooms = new LinkedList<Room>();
	private LinkedList<View> views;

    public Apt(int floor, int room, int size)
    {   id = floor * 100 + room;
        for (int number = 1; number <= size; number++)
            rooms.add(new Room(number));    }

    public boolean canFit(Student student)
    {   return !isFull() && matches(student); }
            
    private boolean isFull()
    {   for (Room room: rooms)
            if (room.isFree())
                return false;
        return true;  }
        
    private boolean matches(Student student)
    {   return isEmpty()
            || (student.isMale() && isMale())
            || (student.isFemale() && isFemale()); }

    public boolean isEmpty()
    {   for (Room room: rooms)
            if (room.isUsed())
                return false;
        return true;  }
    
    private boolean isMale()
    {   for (Room room: rooms)
            if (room.isMale())
                return true;
        return false;   }
    
    private boolean isFemale()
    {   for (Room room: rooms)
            if (room.isFemale())
                return true;
        return false;   }
        
    public void add(Student student)
    {   for (Room room: rooms)
            if (room.isFree())
            {   room.add(student);
                break;   }}
        
    private boolean isUnspecified()
    {   return !(isMale() || isFemale());  }
    
    public boolean matches(int id)
    {   return this.id == id;   }
    
    public Room room(String name)
    {   for (Room room: rooms)
            if (room.has(name))
                return room;
        return null;    }
        
    public boolean isUsed()
    {   for (Room room: rooms)
            if (room.isUsed())
                return true;
        return false;   }
        
    public Room room(int index)
    {   return rooms.get(index);    }
        
    public int size()
    {   return rooms.size();    }
        
    public LinkedList<Room> rooms()
    {   return rooms;   }
        
    public int id()
    {   return id;  }
    
}
