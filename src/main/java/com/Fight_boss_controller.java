package com;

import GUI.Fight_boss_page;
import GUI.Game_resultPage;
import java.io.IOException;

/**
 * ?¬?€ μ»¨νΈλ‘€λ¬?Ό ?κΈ°μ ? λ§€ν?€.
 * λ³΄μ€??? ? ?¬?  ?, ?°?Ό ?°?΄?° μ²λ¦¬? κ΄?? λ©μ??€λ‘? κ΅¬μ±??΄ ??€.
 * ?? ?΄?΄ κ³΅κ²© λ°? ??°?΄?Έ, λ³΄μ€ κ³΅κ²© λ°? ??°?΄?Έ, ?Ή?¨ κ²°μ  λ©μ??€?΄ ??€.
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
     * λ³΄μ€κ°? ?? ?΄?΄λ₯? κ³΅κ²©?  ?, λ³΄μ€ κ°μ²΄? ??±κ°κ³Ό μ£Όμ¬? κ°μ ?΄?©?΄ ?? ?΄?΄? μ²΄λ ₯? ??°?΄?Έ ?? λ©μ?
     * μ£½μ?? ?? ?΄?΄? ?λ¦¬μ?? ???€.
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
     * ?? ?΄?΄κ°? λͺ¬μ€?°λ₯? κ³΅κ²©?  ?, ?? ?΄?΄? ??±κ³?, μ£Όμ¬? κ°μ ?΄?©?΄ λͺ¬μ€?°? μ²΄λ ₯? ??°?΄?Έ?? λ©μ?.
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
     * ?? ?΄?΄? ?Ή?¨? ?°?Ό, κ΄?? ¨ μ°½μ ??μ£Όλ λ©μ?
     */
    public static void checkWhoWin() {
        Boss boss = GameMaster.current_boss;
        Game_resultPage result;

        if (fight_boss_page.boss_result = true) {
            if (Player.getPlayer(0).getHealth() < 1 && Player.getPlayer(1).getHealth() < 1) {
                System.out.println("?? ?΄?΄ ?¨λ°?");
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
}
