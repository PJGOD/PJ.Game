package com.pj;

import com.pj.creature.Creature;
import com.pj.creature.Monster;
import com.pj.creature.MonsterSet;
import com.pj.creature.Person;
import com.pj.potion.*;
import com.pj.room.Room;
import com.pj.room.RoomSet;
import com.pj.weapon.Weapon;
import com.pj.weapon.WeaponHammer;
import com.pj.weapon.WeaponKnife;
import com.pj.weapon.WeaponSpear;

import java.awt.*;
import java.util.Scanner;

public class Sense {
    private Person person=new Person();
    private Monster vampire=new Monster();
    private Monster sabre=new Monster();
    private Monster tyrannosaurusRex=new Monster();
    private Room compound=new Room();
    private Room arena=new Room();
    private Room adventureIsland=new Room();
    private Room HeiShiMountain=new Room();
    private Room BaiHuaValley=new Room();
    private Potion smallPotion=new Potion() {
        @Override
        public void usePotion(Creature currentCreature) {
            currentCreature.setHpValue(currentCreature.getHpValue()+this.getRecoveryPoints());
        }
    };
    private Potion middlePotion=new Potion() {
        @Override
        public void usePotion(Creature currentCreature) {
            currentCreature.setHpValue(currentCreature.getHpValue()+this.getRecoveryPoints());
        }
    };
    private Potion bigPotion=new Potion() {
        @Override
        public void usePotion(Creature currentCreature) {
            currentCreature.setHpValue(currentCreature.getHpValue()+this.getRecoveryPoints());
        }
    };
    private MonsterSet monsterSet=new MonsterSet();
    private PotionSet potionSet=new PotionSet();

    public PotionSet getPotionSet() {
        return potionSet;
    }

    public void setPotionSet(PotionSet potionSet) {
        this.potionSet = potionSet;
    }

    RoomSet roomSet=new RoomSet();
    Ui ui=new Ui();

    public RoomSet getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(RoomSet roomSet) {
        this.roomSet = roomSet;
    }

    public MonsterSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterSet monsterSet) {
        this.monsterSet = monsterSet;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void initSense(){
        initRooms();
        initMonster();
        initPotion();
        initPerson(roomSet.searchRoomById("1"));
    }

    public void initPerson(Room room){
        person.setId("201900123");
        person.setDescription("瓦莉拉");
        person.setHpValue(500);
        person.setCurrentWeapon(new WeaponHammer("745","风暴之锤",-50));
        person.setCurrentRoom(room);
    }
    public void initMonster(){
        vampire.setId("vampire1");
        vampire.setDescription("吸血鬼");
        vampire.setHpValue(200);
        vampire.setCurrentWeapon(new WeaponKnife("265","钩镰弯刀",-20));

        sabre.setId("sabre2");
        sabre.setDescription("剑齿虎");
        sabre.setHpValue(150);
        sabre.setCurrentWeapon(new WeaponSpear("155","沙漠之矛",-30));

        tyrannosaurusRex.setId("tyrannosaurusRex3");
        tyrannosaurusRex.setDescription("暴龙王");
        tyrannosaurusRex.setHpValue(300);
        tyrannosaurusRex.setCurrentWeapon(new WeaponKnife("554","神秘之刃",-25));

        monsterSet.getMonsters().add(vampire);
        monsterSet.getMonsters().add(sabre);
        monsterSet.getMonsters().add(tyrannosaurusRex);
    }

    public void initRooms(){
        compound.setId("1");
        compound.setDescription("大院");

        arena.setId("2");
        arena.setDescription("竞技场");

        adventureIsland.setId("3");
        adventureIsland.setDescription("探险岛");

        HeiShiMountain.setId("4");
        HeiShiMountain.setDescription("黑石山");

        BaiHuaValley.setId("5");
        BaiHuaValley.setDescription("百花谷");

        compound.addReachableRoom("2",arena);
        compound.addReachableRoom("3",adventureIsland);
        compound.addReachableRoom("4",HeiShiMountain);

        arena.addReachableRoom("1",compound);

        adventureIsland.addReachableRoom("1",compound);

        HeiShiMountain.addReachableRoom("1",compound);
        HeiShiMountain.addReachableRoom("5",BaiHuaValley);

        BaiHuaValley.addReachableRoom("4",HeiShiMountain);

        roomSet.addRoom(compound);
        roomSet.addRoom(arena);
        roomSet.addRoom(adventureIsland);
        roomSet.addRoom(HeiShiMountain);
        roomSet.addRoom(BaiHuaValley);
    }

    public void initPotion(){
        smallPotion.setId("122");
        smallPotion.setDescription("小型药水");
        smallPotion.setRecoveryPoints(20);

        middlePotion.setId("123");
        middlePotion.setDescription("中型药水");
        middlePotion.setRecoveryPoints(30);

        bigPotion.setId("124");
        bigPotion.setDescription("大型药水");
        bigPotion.setRecoveryPoints(40);

        potionSet.getPotions().add(smallPotion);
        potionSet.getPotions().add(middlePotion);
        potionSet.getPotions().add(bigPotion);
    }

    public boolean judgeSuccess(){
        boolean flagPersonSuccess=true;

        if(this.getPerson().getHpValue() <=0){
            flagPersonSuccess=false;
        }
        return flagPersonSuccess;
    }

    public void play()
    {
        ui.printWelcome();
        ui.initPosition();
        ui.displayStaus(this);
        ui.displayHelpMsg();
        Scanner in = new Scanner(System.in);
        while (true){
            String command = in.nextLine();
            String[] cmdLineItems = command.split(" ");

            //chop go by help 相应的处理
            if(cmdLineItems[0].equals("bye"))
            {
                ui.displayBye();
                System.exit(0);
            }else if(cmdLineItems[0].equals("help"))
            {
                ui.displayHelpMsg();
            }else if(cmdLineItems[0].equals("chop")){
                this.getPerson().useArticle(this.getPerson().getCurrentWeapon(),
                        this.getMonsterSet().get(cmdLineItems[1]));
                ui.displayDamageMsg(this.getPerson(),this.getMonsterSet().get(cmdLineItems[1]));
                if (this.getMonsterSet().get(cmdLineItems[1]).getHpValue() <=0){
                    monsterSet.getMonsters().remove(this.getMonsterSet().get(cmdLineItems[1]));
                }
                //妖怪砍人 随机砍人
                for (Monster item:this.getMonsterSet().getMonsters()
                     ) {
                    if(1 == Utils.randomMonsterChop())
                    {
                        item.useArticle(item.getCurrentWeapon(),this.getPerson());
                        ui.displayDamageMsg(item,getPerson());
                    }
                }
            }else if(cmdLineItems[0].equals("go")){
                this.getPerson().go(cmdLineItems[1]);
                for (Potion item:this.getPotionSet().getPotions()
                     ) {
                    if(1 == Utils2.randomPotion())
                    {
                        ui.displayPotion(item);
                        ui.displayDrink();
                    }
                }
            }else if (cmdLineItems[0].equals("drink")){
                if(cmdLineItems[1].equals("122")){
                    this.getPerson().setHpValue(this.getPerson().getHpValue()+20);
                    if(this.getPerson().getHpValue()>=500){
                        this.getPerson().setHpValue(500);
                    }else{
                        this.getPerson().setHpValue(this.getPerson().getHpValue());
                    }
                }else if(cmdLineItems[1].equals("123")){
                    this.getPerson().setHpValue(this.getPerson().getHpValue()+30);
                    if(this.getPerson().getHpValue()>=500){
                        this.getPerson().setHpValue(500);
                    }else{
                        this.getPerson().setHpValue(this.getPerson().getHpValue());
                    }
                }else if(cmdLineItems[1].equals("124")){
                    this.getPerson().setHpValue(this.getPerson().getHpValue()+40);
                    if(this.getPerson().getHpValue()>=500){
                        this.getPerson().setHpValue(500);
                    }else{
                        this.getPerson().setHpValue(this.getPerson().getHpValue());
                    }
                }
            }
            else{
                ui.displayErrorCmdMsg();
                ui.displayHelpMsg();
            }
            ui.displayStaus(this);
            ui.displayHelpMsg();
        }
    }
}
