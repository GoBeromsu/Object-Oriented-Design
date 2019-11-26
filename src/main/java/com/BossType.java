package com;

public enum BossType {
    AZATHOTH("아자투스",10,10,6),				//아자투스는 소환되는 즉시 패배
    CHUTHULU("크툴루",10,3,5),
    NYARLATHOTEP("니알라토텝",10,2,6);

    final private String name;
    private int health;
    private int power;
    private int requireVal;
    BossType(String name, int health, int power, int requireVal){
        this.name = name;
        this.health=health;
        this.power=power;
        this.requireVal=requireVal;
    }
    public String getName(){
        return name;
    }
    public int getHealth()
    {
    	return health;
    }
    public int getPower(){
    	return power;
    }
    public int getRequireVal()
    {
    	return requireVal;
    }
}
