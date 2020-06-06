package com.pj.weapon;

import com.pj.creature.Creature;
import com.pj.weapon.Weapon;

public class WeaponHammer extends Weapon {

    public WeaponHammer(String id, String description, int damagePoints) {
        super(id,description,damagePoints);
    }

    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHpValue(enemyCreature.getHpValue()+this.getDamagePoints());
    }
}
