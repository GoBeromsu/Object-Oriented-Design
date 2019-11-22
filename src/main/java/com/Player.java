package com;

import lombok.*;

import java.util.ArrayList;



/**
 * 플레이어 객체 모델
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Player{
    static private int idx_of_cur_player = 0;
    static private final int MAXIMUM_NUM_OF_PLAYERS = 2;
    static Player[] players = new Player[MAXIMUM_NUM_OF_PLAYERS];

    private TileType pos;
    private int money;
    private int energy;
    private int power;
    private int health;
    private int mental;
    private int dexterity;
    private int intelligence;
    private String characteristics;
    private ArrayList<Item> items;

    public void decreaseEnergy() {
        energy--;
    }
    static public Player getCurrentPlayer(){
        return players[idx_of_cur_player];
    }
}
