package com;

import GUI.Start_page;

import java.io.IOException;
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
    public static int token = 0;
    public static int death_count = 3;
    public static int revive_count = 0;
    public static int turn = 1;
    public static Boss current_boss;

    public static void main(String[] args) throws IOException {
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
                    .items(new ArrayList<ItemType>(Arrays.asList(ItemType.PROBLEM_OF_TIME, ItemType.AMULET_OF_HOUND)))
                    .build();
        }
    }

    public static void initiateGame() {
        initiatePlayers();
        initMap();
        initMonsters();
    }

    private static void initMap() {

        Map.tiles = new Tile[13];
        for (int i = 0; i < 13; i++) {
            Map.tiles[i] = Tile
                    .builder()
                    .summoned_monster(null)
                    .summoned_portal(false)
                    .tile_type(TileType.values()[i])
                    .build();
        }

    }

    private static void initMonsters() {
    }

    public static void setBoss(Boss selected_boss) {
        current_boss = selected_boss;
    }

    public static void setInitializePlayerStats(int[] combined_stats) {
        Player player = getCurrentPlayer();
        player.setPower(combined_stats[0]);
        player.setDexterity(combined_stats[1]);
        player.setIntelligence(combined_stats[2]);
        player.setMental(player.getMental() + combined_stats[3]);
        // 체력, 정신력은 1 + SetStatus_page에서 추가한 포인트로 세팅한다.
        player.setHealth(player.getHealth() + combined_stats[4]);

        if (player.getHealth() > 3) // player의 체력이 3 이상이면 여러번 움직일 수 있다.
            player.setEnergy(player.getHealth() / 3);
        else if (player.getHealth() > 0) // player가 죽지 않았으면 1번 이상 움직일 수 있다.
            player.setEnergy(1); // 최소 값
        else // 플레이어가 죽었으면 움직일 수 없다.
            player.setEnergy(0);
    }

    public static void death(Player player) {
        DialogPanelController.show_dialog("플레이어의 체력 또는 정신력이 0이 되어, 즉사 체크를 시행합니다.");
        Answer answer1 = new Answer("1. 계속", "death");
        DialogPanelController.show_dialog_answer1(answer1);
    }

    public static void revive(Player player) {
        player.setStatus(1);
        if (player.getMental() <= 0) {
            player.setMental(1);
            player.setPos(TileType.MENTAL_HOSPITAL);
        }
        if (player.getHealth() <= 0) {
            player.setHealth(1);
            player.setPos(TileType.HOSPITAL);
        }
    }

    public static void turnEnd() {
        if (getCurrentPlayer().getHealth() <= 0 || getCurrentPlayer().getMental() <= 0) {
            if (getCurrentPlayer().getStatus() == DEAD) {
                RandomEventAnswer.Win_check(getCurrentPlayer());
            } else
                death(getCurrentPlayer());
        } else
            RandomEventAnswer.Win_check(getCurrentPlayer());
    }

    public static boolean check_num_of_token_for_win() {
            if(GameMaster.current_boss.getType()==BossType.NYARLATHOTEP)
            {
                if(token==13)
                    return true;
                else return false;
            }
            else if(token==10)
            {
                return true;
            }
            else
                return false;

    }

    public static boolean check_player_status_for_lost() {
        if (players[0].getStatus() == 2 && players[1].getStatus() == 2)
            return true;
        else return false;
    }

    public static boolean check_num_of_monsters_portals_for_boss() {
        int tempNum = 0;
        int tempNum2 = 0;

        for (int i = 0; i < 13; i++) {
            if (Map.tiles[i].getSummoned_monster() != null)
                tempNum++;
        }
        for (int j = 0; j < 13; j++) {
            if (Map.tiles[j].isSummoned_portal())
                tempNum2++;
        }

        if (tempNum > 6 || tempNum2 > 4)
            return true;
        else return false;
    }

    public static void setPortalAndMonsterRandomly() {
        while (true) {
            int tempNum1 = (int) Math.floor(Math.random() * 13);
            int tempNum2 = (int) Math.floor(Math.random() * 5);
            if (isTherePlayer(Map.tiles[tempNum1])) continue;
            if(TileType.HOSPITAL.ordinal() == tempNum1 || TileType.MENTAL_HOSPITAL.ordinal() == tempNum1) continue;

            MonsterType monster = MonsterType.values()[tempNum2];
            Monster tempMon = new Monster(monster);
            if (Map.tiles[tempNum1].getSummoned_monster() == null&&Map.tiles[tempNum1].isSummoned_portal()==false) {
                Map.tiles[tempNum1].setSummoned_monster(tempMon);
                MainGamePageController.show_monsters();

                break;
            } else continue;
        }
        while (true) {
            int tempNum1 = (int) Math.floor(Math.random() * 13);
            if (isTherePlayer(Map.tiles[tempNum1])||Map.tiles[tempNum1].getSummoned_monster()!=null) continue;
            if (Map.tiles[tempNum1].isSummoned_portal() == false) {
                Map.tiles[tempNum1].setSummoned_portal(true);
                break;
            } else continue;
        }
    }

    private static boolean isTherePlayer(Tile tile) {
        if (tile.getTile_type() == Player.getPlayer(0).getPos()
                || Player.getPlayer(1).getPos() == tile.getTile_type()) {
            return true;
        }
        return false;
    }

}
