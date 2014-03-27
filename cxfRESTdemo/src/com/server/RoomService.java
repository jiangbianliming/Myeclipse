package com.server;  

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;  
import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
  












import javax.ws.rs.core.Context;





import org.apache.cxf.jaxrs.ext.MessageContext;

import com.DAO.Person;  
import com.DAO.Room;  
import com.DAO.RoomDAO;  
import com.DAO.Rooms;  
import com.util.QueryStringParser;
  
@Path("/roomservice")  
@Produces("application/json")  
public class RoomService {  
	@Context 
	private MessageContext context;
    @GET  
    @Path("/room/{id}")  
    @Consumes("application/json")  
    public String getRoom(@PathParam("id")String id )  
    {  
    	HttpServletRequest req = context.getHttpServletRequest();
    	 String queryString = (String) req.getQueryString();
    	 QueryStringParser parser = new QueryStringParser();
    	 String callback = parser.parser(queryString).get("callbackparam");
    	 System.out.println(queryString);
    	 //System.out.println("get room by id= "+id);  
////        Room room=RoomDAO.getRoom(id);  
//        room.setId("3");
//        Room room = new Room();
//        Map<String,Person> p = new HashMap<String,Person>();
        Person p1= new Person();
        p1.setName("ssss");
        p1.setSex("x");
//        p.put("sss", p1);
//        room.setPersons(p);
//        System.out.print(room.toString());
        String a = "{\"a\":"+"\"1\"}";
        String s = callback+"(["+a+"])";
        return s;  
    }  
    @GET  
    @Path("/room")  
    @Consumes("application/xml")  
    public Rooms getAllRoom()  
    {  
        System.out.println("get all room");  
        Rooms rooms=RoomDAO.getRooms();  
        return rooms;  
    }  
      
    @POST  
    @Path("/room")  
    @Consumes("application/xml")  
    public void addRoom(Room room)  
    {  
        System.out.println("add room which id is:"+room.getId());  
        RoomDAO.addRoom(room);  
    }  
    @PUT  
    @Path("/room/{id}")  
    @Consumes("application/xml")  
    public void updateRoom(@PathParam("id")String id,Room room)  
    {  
        System.out.println("update room which original id is:"+room.getId());  
        RoomDAO.updateRoom(id,room);  
    }  
    @DELETE  
    @Path("/room/{id}")  
    @Consumes("application/xml")  
    public void deleteRoom(@PathParam("id")String id)  
    {  
        System.out.println("remove room by id= "+id);  
        RoomDAO.deleteRoom(id);  
    }  
    @POST  
    @Path("/room/{id}")  
    @Consumes("application/xml")  
    public void addPerson(@PathParam("id") String id,Person person)  
    {  
        System.out.println("add person who's name is:"+person.getName());  
        RoomDAO.addPerson(id, person);  
    }  
    @DELETE  
    @Path("/room/{id}/{name}")  
    @Consumes("application/xml")  
    public void deletePerson(@PathParam("id")String id,@PathParam("name")String name)  
    {  
        System.out.println("remove person who's name is: "+name);  
        RoomDAO.deletePerson(id, name);  
    }  
}  
