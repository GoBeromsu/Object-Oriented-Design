package com;
import lombok.*;

/**
 * 보스 객체의 모델
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Boss {
    static private Boss current_boss;
    public enum BossType {
        AZATHOTH("아자투스"),
        CHUTHULU("크툴루"),
        NYARLATHOTEP("니알라토텝");

        final private String name;
        BossType(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    private BossType type;
    private int health;
    private int power;
}
