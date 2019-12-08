package com;

import GUI.Start_page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.Player.*;

/**
 * 실제 게임마스터처럼 게임의 전체적인 데이터를 가지고 게임 진행의 방향을 결정하는 클래스이다.
 * 초기화, 세팅 페이지들간의 동기화를 위한 메소드, 즉사체크 및 보스 소환조건과 게임 승리 조건 체크,
 * 턴 종료와, 몬스터와 포털 생성 관련 메소드들로 구성되어 있다.
 * @author Se-Ok Jeon
 * @version 1.1
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
                    .money(5)
                    .items(null)
                    .characteristics("test")
                    .items(new ArrayList<ItemType>())
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

    /**
     * setBoss_page에서 선택한 보스를 저장하는 메소드
     * @param selected_boss
     * <br>선택된 보스
     */
    public static void setBoss(Boss selected_boss) {
        current_boss = selected_boss;
    }

    /**
     * 게임 시작 시 플레이어의 스테이터스를 초기화하는 메소드
     * @param combined_stats
     * <br>스테이터스 창에서 설정한 값들의 집합
     */
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

    /**
     * 플레이어의 체력이나 정신력이 0 이하로 떨어졌을 때 즉사체크를 실행하는 메소드
     * @param player
     * <br>체크를 진행할 플레이어
     */
    public static void death(Player player) {
        DialogPanelController.show_dialog("플레이어의 체력 또는 정신력이 0이 되어, 즉사 체크를 시행합니다.");
        Answer answer1 = new Answer("1. 계속", "death");
        DialogPanelController.show_dialog_answer1(answer1);
    }

    /**
     * 즉사 체크 성공 시 플레이어에게 그에 맞는 능력치를 1로 맞추고 위치를 상황에 맞는 병원으로 옮기는 메소드
     * @param player
     * <br>해당 플레이어
     */
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

    /**
     * 턴이 끝났을 때 분기의 방향을 결정하는 메소드
     */
    public static void turnEnd() {
        if (getCurrentPlayer().getHealth() <= 0 || getCurrentPlayer().getMental() <= 0) {
            if (getCurrentPlayer().getStatus() == DEAD) {
                RandomEventAnswer.Win_check(getCurrentPlayer());
            } else
                death(getCurrentPlayer());
        } else
            RandomEventAnswer.Win_check(getCurrentPlayer());
    }

    /**
     * 승리 조건을 확인하는 메소드
     * @return 승리 여부
     */
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

    /**
     * 패배 조건을 확인하는 메소드
     * @return 패배 여부
     */
    public static boolean check_player_status_for_lost() {
        if (players[0].getStatus() == DEAD && players[1].getStatus() == DEAD)
            return true;
        else return false;
    }

    /**
     * 보스 소환 조건을 확인하는 메소드
     * @return 보스 소환 여부
     */
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

    /**
     * 3턴마다 무작위 위치에 포털과 몬스터를 1기씩 배치한다.
     * <br>다만, 플레이어가 위치하고 있는 곳, 상점, 병원, 정신병원, 포털이나 몬스터가 이미 위치하고 있는 곳에는 생성될 수 없다.
     */
    public static void setPortalAndMonsterRandomly() {
        // 몬스터 소환
        while (true) {
            if(CheckBlankSpace1())
            {
                break;
            }

            int tempNum1 = (int) Math.floor(Math.random() * 13);
            int tempNum2 = (int) Math.floor(Math.random() * 5);
            if (isTherePlayer(Map.tiles[tempNum1])) continue;
            if(TileType.HOSPITAL.ordinal() == tempNum1 || TileType.MENTAL_HOSPITAL.ordinal() == tempNum1) continue;

            MonsterType monster = MonsterType.values()[tempNum2];
            Monster tempMon = new Monster(monster);
            if (Map.tiles[tempNum1].getSummoned_monster() == null
                    &&Map.tiles[tempNum1].isSummoned_portal()==false
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.MENTAL_HOSPITAL
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.HOSPITAL
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.STORE)
            {
                Map.tiles[tempNum1].setSummoned_monster(tempMon);
                MainGamePageController.show_monsters();

                break;
            } else continue;
        }
        // 포탈 소환
        while (true) {
            if(CheckBlankSpace2())
            {
                break;
            }
            int tempNum1 = (int) Math.floor(Math.random() * 13);
            if (isTherePlayer(Map.tiles[tempNum1])||Map.tiles[tempNum1].getSummoned_monster()!=null) continue;
            if (Map.tiles[tempNum1].isSummoned_portal() == false
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.MENTAL_HOSPITAL
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.HOSPITAL
                    &&Map.tiles[tempNum1].getTile_type()!=TileType.STORE)
            {
                Map.tiles[tempNum1].setSummoned_portal(true);
                break;
            }
        }
    }

    /**
     * 해당 타일에 플레이어가 이미 위치하고 있는지 확인하는 메소드
     * @param tile
     * <br>해당 타일
     * @return 플레이어 위치 여부
     */
    public static boolean isTherePlayer(Tile tile) {
        if (tile.getTile_type() == Player.getPlayer(0).getPos()
                || Player.getPlayer(1).getPos() == tile.getTile_type()) {
            return true;
        }
        return false;
    }

    /**
     * 맵 전체에 몬스터나 포털이 소환될만한 공간이 있는지 확인하는 메소드
     * @return 소환 가능 여부
     */
    private static boolean CheckBlankSpace1()
    {
        int count=0;
        for(int i=0;i<13;i++)
        {
            if(Map.tiles[i].getSummoned_monster() == null
                    &&Map.tiles[i].isSummoned_portal()==false
                    &&Map.tiles[i].getTile_type()!=TileType.MENTAL_HOSPITAL
                    &&Map.tiles[i].getTile_type()!=TileType.HOSPITAL
                    &&Map.tiles[i].getTile_type()!=TileType.STORE
                    &&!isTherePlayer(Map.tiles[i]))
            {
                count++;
            }
        }
        if(count<2)
            return true;
        else
            return false;
    }
    /**
     * 맵 전체에 포털이 소환될만한 공간이 있는지 확인하는 메소드
     * @return 소환 가능 여부
     */
    private static boolean CheckBlankSpace2()
    {
        int count=0;
        for(int i=0;i<13;i++)
        {
            if(Map.tiles[i].getSummoned_monster() == null
                    &&Map.tiles[i].isSummoned_portal()==false
                    &&Map.tiles[i].getTile_type()!=TileType.MENTAL_HOSPITAL
                    &&Map.tiles[i].getTile_type()!=TileType.HOSPITAL
                    &&Map.tiles[i].getTile_type()!=TileType.STORE
                    &&!isTherePlayer(Map.tiles[i]))
            {
                count++;
            }
        }
        if(count<1)
            return true;
        else
            return false;
    }
}
