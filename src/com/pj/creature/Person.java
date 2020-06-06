package com.pj.creature;

import com.pj.Ui;
import com.pj.potion.Potion;
import com.pj.room.Room;
import com.pj.weapon.Weapon;

import java.awt.*;
import java.util.ArrayList;

public class Person extends Creature {
    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void go (String targetRoomId){
        //临时变量
        Room room;
        //1.根据targetRoomId找相应的目标房间
        room= currentRoom.searchReachableRoomById(targetRoomId,currentRoom.getReachableRoom());
        if(room !=null){
            //如果找到了房间，将该Room赋给Person.currentRoom
            this.currentRoom=room;
            //显示人所在的当前房间可到达的房间
            Ui.displayReachableRooms(this);
        }else {
            //如果没有找到房间，显示没有目标房间
            Ui.printNoRoom();
        }
    }

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }
}
