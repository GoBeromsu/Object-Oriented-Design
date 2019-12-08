package com;

import lombok.*;
import java.util.ArrayList;


/**
 * 플레이어 모델로, 플레이어의 현재 위치나, 체력등의 수치를 포함하고 있다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Player{
    static int idx_of_cur_player = 0;
    static public final int MAXIMUM_NUM_OF_PLAYERS = 2;
    /**
     * 게임을 하고 있는 플레이어들의 플레이어 객체들에 관한 배열이다.
     */
    static Player[] players = new Player[MAXIMUM_NUM_OF_PLAYERS];
    static public final int ALIVE = 1;
    static public final int DEAD = 2;

    private TileType pos;
    private int money;
    private int energy;
    @Builder.Default
    private Integer power = null;
    @Builder.Default
    private int health = 1;
    @Builder.Default
    private int mental = 1;
    private int dexterity;
    private int intelligence;
    /**
     * @deprecated 개발 범위 축소로 사용하지 않게 된 속성이다.
     */
    private String characteristics;
    private ArrayList<ItemType> items;
    @Builder.Default
    private int status = ALIVE;

    static public Player getCurrentPlayer(){
        return players[idx_of_cur_player];
    }
    static public Player getPlayer(int idx){return players[idx];}

    /**
     * 현재 플레이어를 다음 플레이어로 변경하기 위한 메소드이다.
     */
    static public void toggleCurrentPlayer(){
        idx_of_cur_player = idx_of_cur_player == 1 ? 0: 1;
    }
    static public int getPlayerIndex(Player to_compare){
        for(int i = 0; i< MAXIMUM_NUM_OF_PLAYERS; i++){
            if(players[i] == to_compare)
                return i;
        }
        return -1;
    }

    public void setHealth(int value){
        this.health = value;
        if(MainGamePageController.maingame_page != null){
            int index = getPlayerIndex(this);
            if(index < 0)
                throw new RuntimeException("no such player here, Problem at Player.setHealth()");
            MainGamePageController.update_status(index, StatusType.HEALTH, this.health);
        }
    }
    public void setPower(int value){
        this.power = value;
        if(MainGamePageController.maingame_page != null){
            int index = getPlayerIndex(this);
            if(index < 0)
                throw new RuntimeException("no such player here, Problem at Player.setPower()");
            MainGamePageController.update_status(index, StatusType.POWER, this.power);
        }
    }
    public void setMental(int value){
        this.mental = value;
        if(MainGamePageController.maingame_page != null){
            int index = getPlayerIndex(this);
            if(index < 0)
                throw new RuntimeException("no such player here, Problem at Player.setMental()");
            MainGamePageController.update_status(index, StatusType.MENTAL, this.mental);
        }
    }
    public void setEnergy(int value){
        this.energy = value;
        if(MainGamePageController.maingame_page != null){
            int index = getPlayerIndex(this);
            if(index < 0)
                throw new RuntimeException("no such player here, Problem at Player.setEnergy()");
            MainGamePageController.update_status(index, StatusType.ENERGY, this.energy);
        }
    }
}
