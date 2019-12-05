package com;

import javax.imageio.ImageIO;
import java.awt.*;

public enum BossType {
    AZATHOTH("아자투스",10, 10, 10,"images/boss/azatoth.png","images/boss/azatoth.png"),
    CHUTHULU("크툴루",10,3,1,"images/boss/CHUTHULU.png","images/boss/cthulhu.gif"),
    NYARLATHOTEP("니알라토텝",10,2,1,"images/boss/NYARLATHOTEP.png","images/boss/nyala.gif");

    final private String name;
    private int damage;
    private int health;
    private int requireVal;
    private String boss_imgpath;
    private String boss_activepath;
    BossType(String name, int health, int damage, int requireVal,String boss_imgpath,String boss_activepath){
        this.name = name;
        this.health=health;
        this.damage=damage;
        this.requireVal=requireVal;
        this.boss_imgpath = boss_imgpath;
        this.boss_activepath=boss_activepath;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public int getRequireVal(){
        return requireVal;
    }
    public String getActive_path(){return boss_activepath;}

    public String getBoss_imgpath(){return boss_imgpath;}
}
