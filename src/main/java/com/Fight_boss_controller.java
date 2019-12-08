package com;

import GUI.Fight_boss_page;
import GUI.Game_resultPage;
import java.io.IOException;

/**
 * 보스와 전투할 때, 쓰일 데이터 처리에 관한 메소드들로 구성되어 있다.
 * 플레이어 공격 및 업데이트, 보스 공격 및 업데이트, 승패 결정 메소드들이 있다.
 *
 * @author Se-Ok Jeon
 */
public class Fight_boss_controller {
    public static GUI.Fight_boss_page fight_boss_page;

    public Fight_boss_controller() throws IOException {
        fight_boss_page = new Fight_boss_page();
        fight_boss_page.setVisible(true);
    }

    /**
     * 보스가 플레이어를 공격할 때, 보스 객체의 속성값과 주사위 값을 이용해 플레이어의 체력을 업데이트 하는 메소드
     * 죽은 플레이어는 때리지 않는다.
     */
    public static void attackedPlayerByBoss() throws IOException {
        int bonus_val=0;
        if(GameMaster.current_boss.getType()==BossType.CHUTHULU)
        {
            bonus_val=1;
        }
        Player.toggleCurrentPlayer();
        Player player = Player.getCurrentPlayer();
        if(player.getHealth() < 1){
            Player.toggleCurrentPlayer();
            player = Player.getCurrentPlayer();
        }
        int temp2 = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (temp2 > boss.getRequireVal()) {
            player.setHealth(player.getHealth() - boss.getDamage()-bonus_val);
            if (player == Player.getPlayer(0)) {
                Fight_boss_page.player1_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            } else {
                Fight_boss_page.player2_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            }
        }
    }

    /**
     * 플레이어가 몬스터를 공격할 때, 플레이어의 속성과, 주사위 값을 이용해 몬스터의 체력을 업데이트하는 메소드.
     */
    public static void attackedBossByPlayer() throws IOException {

        int dice_value = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (dice_value > boss.getRequireVal()) {

            boss.setHealth(boss.getHealth() - 1);

            Fight_boss_page.show_stars();

        }
    }

    /**
     * 플레이어의 승패에 따라, 관련 창을 띄워주는 메소드
     */
    public static void checkWhoWin() {
        Boss boss = GameMaster.current_boss;
        Game_resultPage result;


            if (Player.getPlayer(0).getHealth() < 1 && Player.getPlayer(1).getHealth() < 1) {
                System.out.println("플레이어 패배");
                fight_boss_page.dispose();
                result = new Game_resultPage("defeat");
                result.setVisible(true);
            } else if (boss.getHealth() < 1) {
                fight_boss_page.dispose();
                result = new Game_resultPage("win");
                result.setVisible(true);
            }
            MainGamePageController.maingame_page.dispose();

    }
}
