package com;

import javax.imageio.ImageIO;
import java.awt.*;

/**
 * 보스들의 설정값을 지칭하는 Enumeration
 * @author Chanho Park, Se-Ok Jeon
 */
public enum BossType {
    AZATHOTH("아자투스",10, 10, 10,"images/boss/azatoth.png","images/boss/azatoth.png"),
    CHUTHULU("크툴루",10,3,1,"images/boss/CHUTHULU.png","images/boss/cthulhu.gif"),
    NYARLATHOTEP("니알라토텝",10,2,1,"images/boss/NYARLATHOTEP.png","images/boss/nyala.gif");

    final private String name;
    private int damage;
    private int health;

    /** 공격을 가하거나, 공격을 할 때, 요구되는 주사위 눈의 값 */
    private int requireVal;
    private String boss_imgpath;

    /** 움직이는 보스 파일 경로 */
    private String boss_activepath;
    BossType(String name, int health, int damage, int requireVal,String boss_imgpath,String boss_activepath){
        this.name = name;
        this.health=health;
        this.damage=damage;
        this.requireVal=requireVal;
        this.boss_imgpath = boss_imgpath;
        this.boss_activepath=boss_activepath;
    }

    /**
     * 보스 이름을 반환하는 메소드
     * @return name
     * 보스 이름
     */
    public String getName(){
        return name;
    }
    /**
     * 보스 체력을 반환하는 메소드
     * @return health
     * 보스 체력
     */
    public int getHealth(){
        return health;
    }
    /**
     * 보스 데미지을 반환하는 메소드
     * @return damage
     * 보스 데미지
     */
    public int getDamage(){
        return damage;
    }
    /**
     * 보스 주사위 요구치를 반환하는 메소드
     * @return requireVal
     * 보스 주사위 요구치
     */
    public int getRequireVal(){
        return requireVal;
    }

    /**
     * 보스전에 쓰일 움직이는 보스 파일 경로를 반환하는 메소드
     * @return boss_activepath
     * 움직이는 보스 파일 경로
     */
    public String getActive_path(){return boss_activepath;}

    /**
     * 보스 세팅에 쓰일 파일 경로를 반환하는 메소드
     * @return boss_imgpath
     * 보스 파일 경로
     */
    public String getBoss_imgpath(){return boss_imgpath;}
}
