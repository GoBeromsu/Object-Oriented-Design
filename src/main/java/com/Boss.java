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
    private BossType type;
    private int health;
    private int damage;
    private int requireVal;

}
