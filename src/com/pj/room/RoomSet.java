package com.pj.room;

import java.util.ArrayList;

public class RoomSet {
    //定义ArrayList集合对象（集合元素类型为Room类）rooms，存放所有的房间数据
    ArrayList<Room> rooms=new ArrayList<>();
    //该方法将一个Room对象room加到rooms
    public void addRoom(Room room){
        rooms.add(room);
    }
    // 在房间集合中搜索房间id为roomId的房间。在本项目中，用在为Person设置初始房间
    public Room searchRoomById (String roomId){
        Room room=null;
        for (Room item:rooms
             ) {
            if (item.getId().equals(roomId)){
                room=item;
                break;
            }
        }
        return room;
    }
}
