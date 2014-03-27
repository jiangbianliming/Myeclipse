package com.DAO;

import java.util.Map;  

import javax.xml.bind.annotation.XmlRootElement;  
@XmlRootElement(name="rooms")  
public class Rooms {  
    Map<String,Room> rooms;  
    public Rooms()  
    {  
        rooms=RoomDAO.getMapOfRooms();  
    }  
    public Map<String, Room> getRooms() {  
        return rooms;  
    }  
    public void setRooms(Map<String, Room> rooms) {  
        this.rooms = rooms;  
    }  
}  
