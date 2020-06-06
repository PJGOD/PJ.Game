package com.pj.room;

import java.util.HashMap;

public class Room {
    private String id;
    private String description;
    //reachableRooms是一个集合，存放该房间能够到达的所有房间。结构为<房间id，房间>
    private HashMap<String, Room> reachableRooms=new HashMap<>();

    public Room(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Room(String id) {
    }

    //将房间添加到房间集合
    public void addReachableRoom(String roomId,Room room){
        reachableRooms.put(roomId,room);
    }
    public Room searchReachableRoomById(String targetRoomId, HashMap<String,Room> reachableRoom){
        Room room=null;
        if(true == reachableRooms.containsKey(targetRoomId))
        {
            room=reachableRooms.get(targetRoomId);
        }
        return room;
    }

    @Override
    public String toString()
    {
        return this.description;
    }

    public Room() {}
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Room> getReachableRoom() {
        return reachableRooms;
    }

    public void setReachableRoom(HashMap<String, Room> reachableRoom) {
        this.reachableRooms = reachableRoom;
    }
}
