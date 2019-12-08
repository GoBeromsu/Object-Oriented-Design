package com;

import lombok.Data;

/**
 * 몬스터의 기본 속성들을 정의하는 클래스
 *
 * @author Chanho Park, Se-ok Jeon,Beomsu Ko
 */
@Data
public class Monster {

    private MonsterType monster_type;
    private int health;
    private int requireVal;
    private int damage;
    private int damageType;
    private int monster_result;
    private String imagepath;
    private String imagepath2;

    public Monster(MonsterType monster_type){
        health = monster_type.getInitial_health();
        requireVal = monster_type.getInitial_requireVal();
        damage = monster_type.getInitial_damage();
        damageType = monster_type.getInitial_damageType();
        monster_result = monster_type.getInitial_monster_result();
        imagepath = monster_type.getInintial_imgpath();
        imagepath2=monster_type.getImgpath_for_Fight();
        this.monster_type = monster_type;
    }

}
