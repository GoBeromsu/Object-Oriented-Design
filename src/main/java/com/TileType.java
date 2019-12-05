package com;

/**
 * 타일타입 enum, 타일을 쉽게 접근하기 위해 사용한다. 인덱스로도 사용하고, 파라미터로도 사용해서 접근성을 용이하게 함.
 *
 * @author Se-Ok Jeon
 * @version 1.0
 */
public enum TileType {
    STORE("상점"),
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    HOSPITAL("병원"),
    H("H"),
    I("I"),
    MENTAL_HOSPITAL("정신병원"),
    J("J");

    final private String name;

    TileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}