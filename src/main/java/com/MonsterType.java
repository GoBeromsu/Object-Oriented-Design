package com;

public enum MonsterType {
    Nightgaunt("나이트건트", 3, 3, 1, 1, 3,"images/monster/nightgaunt2.png","images/monster/nightgaunt3.png"),
    Dagon("다곤", 1, 4, 2, 2, 5,"images/monster/dagon2.png","images/monster/dagon3.png"),
    Byakhee("비야키", 2, 2, 1, 1, 1,"images/monster/BYAKEE2.png","images/monster/BYAKEE3.png"),
    Ghoul("구울", 4, 4, 2, 1, 4,"images/monster/ghoul2.png","images/monster/ghoul3.png"),
    Elder_Thing("옛 것", 5, 4, 1, 2, 5,"images/monster/elder_thing.png","images/monster/elder_thing2.png");

    private String name;
    private int initial_health;
    private int initial_requireVal;
    private int initial_damage;
    private int initial_damageType;
    private int initial_monster_result;
    private String inintial_imgpath;
    private String imgpath_for_Fight;

    MonsterType(String name, int health, int requireVal, int damage, int damageType, int monster_result,String imagepath, String imgpath2) {
        this.name = name;
        this.initial_health = health;
        this.initial_requireVal = requireVal;
        this.initial_damage = damage;
        this.initial_damageType = damageType;
        this.initial_monster_result = monster_result;
        this.inintial_imgpath = imagepath;
        this.imgpath_for_Fight=imgpath2;
    }


    public String getName() {
        return name;
    }
    public int getInitial_health() {
        return initial_health;
    }
    public int getInitial_requireVal() {
        return initial_requireVal;
    }

    public int getInitial_damage() {
        return initial_damage;
    }

    public int getInitial_damageType() {
        return initial_damageType;
    }

    public String getImgpath_for_Fight(){return imgpath_for_Fight;}

    public int getInitial_monster_result() {
        return initial_monster_result;
    }
    public String getInintial_imgpath(){return inintial_imgpath;}
}
