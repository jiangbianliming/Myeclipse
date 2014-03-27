package com.server;  
  

  
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.DAO.Person;  
import com.DAO.Room;  
import com.DAO.Rooms;  
  
public class Server {  
  
    public static void main(String[] args) {  
        RoomService service = new RoomService();  
  
        // Service instance  
        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();  
        restServer.setResourceClasses(Room.class,Person.class,Rooms.class);  
        restServer.setServiceBean(service);  
        restServer.setAddress("http://localhost:9999/");  
        restServer.create();  
    }  
} 
