package com;

import lombok.Builder;
import lombok.Data;

/**
 * 몬스터의 기본 속성들을 정의하는 클래스
 *
 * @author Chanho Park, Se-ok Jeon
 */
@Data
@Builder
public class Monster
{
//    monsterlist[0].name="나이트건트";monsterlist[0].health=3;monsterlist[0].requireVal=3;monsterlist[0].damage=1;monsterlist[0].damageType=1;monsterlist[0].monsterresult=3;
//    monsterlist[1].name="검은파라오";monsterlist[1].health=1;monsterlist[1].requireVal=6;monsterlist[1].damage=2;monsterlist[1].damageType=2;monsterlist[1].monsterresult=5;
//    monsterlist[2].name="비야키";monsterlist[2].health=2;monsterlist[2].requireVal=2;monsterlist[2].damage=1;monsterlist[2].damageType=1;monsterlist[2].monsterresult=1;
//    monsterlist[3].name="구울";monsterlist[3].health=4;monsterlist[3].requireVal=4;monsterlist[3].damage=2;monsterlist[3].damageType=1;monsterlist[3].monsterresult=4;
//    monsterlist[4].name="옛 것";monsterlist[0].health=5;monsterlist[0].requireVal=4;monsterlist[0].damage=1;monsterlist[0].damageType=2;monsterlist[0].monsterresult=5;

    static private Monster[] monsters;

    public enum MonsterType{
        Nightgaunt("나이트건트"),
        Dark_Paraoh("검은 파라오"),
        Byakhee("비야키"),
        Ghoul("구울"),
        Elder_Thing("옛 것");

        final private String name;
        MonsterType(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    private int health;
    private int requireVal;
    private int damage;
    private int damageType;
    private int monster_result;
    private MonsterType name;

    public void decreaseHealth(int damage_from_player){
        health -= damage_from_player;
    }
}