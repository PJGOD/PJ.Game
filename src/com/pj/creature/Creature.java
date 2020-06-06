package com.pj.creature;

import com.pj.potion.Potion;
import com.pj.weapon.Weapon;

import java.util.ArrayList;

public abstract class Creature {
    private String id;
    private String description;
    private int HpValue;
    private Weapon currentWeapon;

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    private ArrayList<Weapon> weapons=new ArrayList<>();

    public abstract void useArticle(Weapon weapon, Creature targetCreature);

    public Creature(String id, String description, int hpValue, ArrayList<Weapon> weapons) {
        this.id = id;
        this.description = description;
        HpValue = hpValue;
        this.weapons = weapons;
    }

    public Creature() {}

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

    public int getHpValue() {
        return HpValue;
    }

    public void setHpValue(int hpValue) {
        HpValue = hpValue;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
