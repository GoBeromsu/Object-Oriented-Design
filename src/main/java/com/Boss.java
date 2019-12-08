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
    /** @deprecated 현재 게임 마스터의 current_boss만 사용한다. */
    static private Boss current_boss;
    private BossType type;
    private int health;
    private int damage;

    /** 공격을 가하거나, 공격을 할 때, 요구되는 주사위 눈의 값 */
    private int requireVal;

}
