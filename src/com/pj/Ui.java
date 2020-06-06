package com.pj;

import com.pj.creature.Creature;
import com.pj.creature.Monster;
import com.pj.creature.Person;
import com.pj.potion.Potion;

public class Ui {
    public void printWelcome(){
        System.out.println("--------------------------------");
        System.out.println("欢迎来到砍怪的世界！");
        System.out.println("这是一个巨无聊的游戏！");
        System.out.println("你是一个叫瓦莉拉的人物！");
        System.out.println("现在你的任务就是把这里的野兽全部杀光，并且你可以去往不同的房间，在不同的房间里可能会有生命药水，你可以捡起并使用来恢复自己的生命值！");
        System.out.println("当你杀光所有野兽后，你就获得了胜利，输入bye退出游戏！！！");
        System.out.println("--------------------------------");
    }
    public void displayStaus(Sense sense){
        System.out.println("--------------------------------");
        System.out.println(sense.getPerson().getDescription()+":"+sense.getPerson().getHpValue());
        System.out.println("现在还活着的怪兽有：");
        for (Monster item:sense.getMonsterSet().getMonsters()
             ) {
            System.out.print(item.getId()+"("+item.getDescription()+")"+":"+item.getHpValue()+";");
        }
        System.out.println();
        System.out.println("--------------------------------");
    }
    public void displayHelpMsg(){
        System.out.println("你有四条命令：chop(chop vampire1 sabre2 tyrannosaurusRex3) go(go 1 2 3.....) bye help");
    }
    public void displayBye(){
        System.out.println("再见！");
    }
    public void displayErrorCmdMsg(){
        System.out.println("你输入的都是非法命令。");
    }
    public void displayDamageMsg(Creature attackCreature,Creature targetCreature){
        System.out.println(attackCreature.getDescription()+"对"+targetCreature.getDescription()+
                "照成"+attackCreature.getCurrentWeapon().getDamagePoints()+"伤害。");
    }
    public static void displayReachableRooms(Person person){
        System.out.println("现在你在" + person.getCurrentRoom().getId()+"("+person.getCurrentRoom().toString()+")");
        System.out.println("出口有：");
        for (String key:person.getCurrentRoom().getReachableRoom().keySet()
             ) {
            System.out.print(key +"(" + person.getCurrentRoom().getReachableRoom().get(key).getDescription()+")"+" ");
        }
        System.out.println();
    }
    public static void printNoRoom(){
        System.out.println("那里没有房间！");
    }
    public void initPosition(){
        System.out.println("现在你在1(大院)");
        System.out.println("出口有：");
        System.out.println("2(竞技场) 3(探险岛) 4(黑石山)");
    }
    public void displayPotion(Potion currentPotion){
        System.out.println("这里有："+currentPotion.getDescription()+currentPotion.getId());
    }
    public void displayDrink(){
        System.out.println("你可以喝药水恢复生命！！！");
        System.out.println("输入命令：drink (drink 122(小型) 123(中型) 124(大型))");
    }
}
