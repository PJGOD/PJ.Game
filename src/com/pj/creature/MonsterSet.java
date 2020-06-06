package com.pj.creature;

import java.util.ArrayList;

public class MonsterSet {
    private ArrayList<Monster> monsters=new ArrayList<>();

    //根据id(String)来查找对应的MonsterWolf对象
    //如果找到了对应的id的Monster，返回相应的对象，如果没有找到就返回空
    public Monster get(String id){
        Monster monster=null;
        for (Monster item:monsters
             ) {
            if(true == id.equals(item.getId())){
                monster=item;
                break;
            }
        }
        return monster;
    }

    public MonsterSet(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public MonsterSet() {
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
