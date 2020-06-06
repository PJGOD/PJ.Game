package com.pj.potion;

import com.pj.creature.Monster;

import java.util.ArrayList;

public class PotionSet {
    ArrayList<Potion> potions=new ArrayList<>();

    //根据id(String)来查找对应的Potion对象
    //如果找到了对应的id的Potion，返回相应的对象，如果没有找到就返回空
    public Potion get(String id){
        Potion potion=null;
        for (Potion item:potions
        ) {
            if(true == id.equals(item.getId())){
                potion=item;
                break;
            }
        }
        return potion;
    }

    public PotionSet(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public PotionSet() {
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }
}
