package com;

import GUI.Start_page;

import java.util.ArrayList;
import java.util.Arrays;

import static com.Player.*;

/**
 * 게임마스터 객체 모델로, 게임의 전체적인 데이터를 가지고 게임 진행의 방향을 결정할 수 있다.
 *
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
    public static Boss current_boss;

    private ConstantEventHandler constant_event_handler;

    public static void main(String[] args) {
        Start_page.Start_pageView();
    }

    private static void initiatePlayers() {
        for (int i = 0; i < 2; i++) {
            players[i] = Player
                    .builder()
                    .pos(TileType.A)
                    .money(100)
                    .items(null)
                    .characteristics("test")
                    .items(new ArrayList<ItemType>(Arrays.asList(ItemType.PROBLEM_OF_TIME, ItemType.AMULETOFHOWARD)))
                    .build();
        }
    }

    public static void initiateGame() {
        token = 0;
        turn = 0;
        initiatePlayers();
        initMap();
        initMonsters();
    }

    private static void initItem() {
//        Player.items
    }

    private static void initMap() {
    }

    private static void initMonsters() {
    }

    public static void setBoss(Boss selected_boss) {
        // 테스트 코드 TODO : 실제 보스는 객체로 적절한 스탯으로 생성해야 함. enum이 될 순 없다. health가 변경가능해야 하므로
        current_boss = selected_boss;
    }

    public static boolean hasItem(ItemType item) {
        return getCurrentPlayer().getItems().indexOf(item) == -1 ? true : false;
    }
// 플레이어의 현재 에너지가 0인지 아닌지 체크
    // 0이면 false 아니면 true
    public static boolean checkEnergy(Player player) {
        return getCurrentPlayer().getEnergy() != 0 ? true:false;
    }

    public static void setInitializePlayerStats(int[] combined_stats) {
        Player player = getCurrentPlayer();
        player.setPower(combined_stats[0]);
        player.setDexterity(combined_stats[1]);
        player.setIntelligence(combined_stats[2]);
        player.setMental(combined_stats[3]);
        // 체력만 기존 체력 + SetStatus_page에서 추가한 포인트로 세팅한다.
        player.setHealth(player.getHealth() + combined_stats[4]);

        if (player.getHealth() > 3) // player의 체력이 3 이상이면 여러번 움직일 수 있다.
            player.setEnergy(player.getHealth() / 3);
        else if (player.getHealth() > 0) // player가 죽지 않았으면 1번 이상 움직일 수 있다.
            player.setEnergy(1); // 최소 값
        else // 플레이어가 죽었으면 움직일 수 없다.
            player.setEnergy(0);
    }

    public static void death(Player player) {
    }

    private static void revive(Player player) {
    }

    private static int turnEnd() {
        return 0;
    }

    private static boolean check_num_of_token_for_win() {
        return true;
    }

    private static boolean check_player_status_for_lost() {
        return true;
    }

    private static boolean check_num_of_monsters_portals_for_boss() {
        return true;
    }

    public static String[] getGeneralDialogues() {
        return new String[0];
    }

    public static void setPortalGateRandomly() {
    }

    public static void generateBossFight(Boss boss) {
    }
}
