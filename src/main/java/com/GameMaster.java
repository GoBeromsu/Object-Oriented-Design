package com;

import static com.Player.*;

/**
 * 게임마스터 객체 모델로, 게임의 전체적인 데이터를 가지고 게임 진행의 방향을 결정할 수 있다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
public class GameMaster {
    private final int GAME_WIN = 0;
    private final int GAME_LOST = 1;
    private final int GAME_KEEPGOING = 2;
    private final int PLAYER_HEALTH_DEATH = 3;
    private final int PLAYER_MENTAL_DEATH = 4;
    private final int PLAYER_BOSS_DEATH = 5;

    public static int token = 0;
    public static int turn = 0;

    private ConstantEventHandler constant_event_handler;

    private void initiatePlayers() {
        for(int i = 0; i<2; i++){
            players[i] = Player.builder()
                    .power(10)
                    .dexterity(20)
                    .health(30)
                    .intelligence(40)
                    .mental(50)
                    .characteristics("test")
                    .build();
        }
    }
    public void initiateGame(){
        this.token = 0;
        this.turn = 0;
        initiatePlayers();
    }
    private void initItem(){}
    private void initMap(){}
    private void initMonsters(){}
    public void setBoss(Boss.BossType selected_boss){}
    public boolean hasItem(Item item) {
        return true;
    }
    public boolean checkEnergy(Player player){return true;}
    public void setInitializePlayerStats(int[][] combined_stats){}
    public void death(Player player){}
    private void revive(Player player){}
    private int turnEnd(){return 0;}
    private boolean check_num_of_token_for_win(){return true;}
    private boolean check_player_status_for_lost(){return true;}
    private boolean check_num_of_monsters_portals_for_boss(){return true;}
    public String[] getGeneralDialogues(){return new String[0];}
    public void setPortalGateRandomly(){}
    public void generateBossFight(Boss boss){}
}
