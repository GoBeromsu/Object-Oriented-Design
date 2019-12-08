package com;

/**
 * 플레이어의 스테이터스 값 접근에 사용된 enum 객체이다.
 * @author Se-Ok Jeon
 */
public enum StatusType {
    HEALTH("체력"),
    POWER("힘"),
    MENTAL("정신력"),
    ENERGY("행동치");

    final private String name;
    StatusType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
