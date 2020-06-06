package com.pj.creature;

import com.pj.potion.Potion;
import com.pj.weapon.Weapon;

public class Monster extends Creature {
    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }
}
