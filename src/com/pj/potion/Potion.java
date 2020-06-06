package com.pj.potion;

import com.pj.creature.Creature;
import com.pj.creature.Person;

public abstract class Potion {
    String id;
    String description;
    private int recoveryPoints;

    public abstract void usePotion(Creature currentCreature);

    public Potion() {}

    public Potion(String id, String description, int recoveryPoints) {
        this.id = id;
        this.description = description;
        this.recoveryPoints = recoveryPoints;
    }

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

    public int getRecoveryPoints() {
        return recoveryPoints;
    }

    public void setRecoveryPoints(int recoveryPoints) {
        this.recoveryPoints = recoveryPoints;
    }
}
