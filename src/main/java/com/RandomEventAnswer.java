package com;

import GUI.Dice_page;

import GUI.music.Mainmusic_thread;

import GUI.Fight_monster_page;
import com.sun.tools.javac.Main;


import java.util.Timer;
import java.util.TimerTask;

import static com.Player.idx_of_cur_player;

/**
 * RandomEventHandler에 의해 생성된 선택지를 클릭 시 ActionListener에 의해 실행될 각각의 선택지들에 대한 결과를 정리한 클래스
 *
 * @author Chanho Park
 */

public class RandomEventAnswer {
    static boolean swi=false;

    /**
     * 이벤트를 진행할 플레이어와 클릭한 선택지에 해당하는 지칭자로 알맞은 메소드를 호출하는 메소드
     *
     * @param answer <br>       메소드 지칭자를 포함하는 Answer 객체
     * @param player <br>       이벤트를 진행하는 플레이어
     */
    public static void AnswerIndicator(Player player, Answer answer) {
        switch (answer.getTag()) {
            case "1_1":
                Ans1_1(player);
                break;
            case "1_1_1":
                Ans1_1_1(player);
                break;
            case "1_1_2":
                Ans1_1_2(player);
                break;
            case "1_2":
                Ans1_2(player);
                break;
            case "2_1":
                Ans2_1(player);
                break;
            case "2_2":
                Ans2_2(player);
                break;
            case "3_1":
                Ans3_1(player);
                break;
            case "3_2":
                Ans3_2(player);
                break;
            case "4_1":
                Ans4_1(player);
                break;
            case "4_2":
                Ans4_2(player);
                break;
            case "4_3":
                Ans4_3(player);
                break;
            case "5_1":
                Ans5_1(player);
                break;
            case "6_1":
                Ans6_1(player);
                break;
            case "6_2":
                Ans6_2(player);
                break;
            case "7_1":
                Ans7_1(player);
                break;
            case "7_2":
                Ans7_2(player);
                break;
            case "8_1":
                Ans8_1(player);
                break;
            case "8_2":
                Ans8_2(player);
                break;
            case "9_1":
                Ans9_1(player);
                break;
            case "9_2":
                Ans9_2(player);
                break;
            case "10_1":
                Ans10_1(player);
                break;
            case "10_2":
                Ans10_2(player);
                break;
            case "11_1":
                Ans11_1(player);
                break;
            case "12_1":
                Ans12_1(player);
                break;
            case "12_2":
                Ans12_2(player);
                break;
            case "13_1":
                Ans13_1(player);
                break;
            case "14_1":
                Ans14_1(player);
                break;
            case "14_2":
                Ans14_2(player);
                break;
            case "15_1":
                Ans15_1(player);
                break;
            case "16_1":
                Ans16_1(player);
                break;
            case "17_1":
                Ans17_1(player);
                break;
            case "18_1":
                Ans18_1(player);
                break;
            case "18_2":
                Ans18_2(player);
                break;
            case "19_1":
                Ans19_1(player);
                break;
            case "20_1":
                Ans20_1(player);
                break;
            case "21_1":
                Ans21_1(player);
                break;
            case "21_2":
                Ans21_2(player);
                break;
            case "continue":
                ContinueDialog();
                break;
            case "turnEnd":
                TurnEnd();
                break;
            case "5_1_1":
                Ans5_2_Sub1(player);
                break;
            case "5_1_1_1":
                Ans5_2_SubResult(player);
                break;
            case "hospital1":
                hospital_Ans1(player);
                break;
            case "hospital2":
                hospital_Ans2(player);
                break;
            case "mospital1":
                mospital_Ans1(player);
                break;
            case "mospital2":
                mospital_Ans2(player);
                break;
            case "death":
                death_Ans(player);
                break;
            case "win_check":
                Win_check(player);
                break;
            case "win":
                Win_Ans(player);
                break;
            case "defeat":
                Defeat_Ans(player);
                break;
            case "boss_summon":
                Boss_fight();
                break;
            case "re_shop":
                Return_To_Shop();
                break;
            case "attack":
                attackedMonsterByPlayer();// 플레이어가 위치한 타일의 몬스터 혹은 임의로 넣어줘야 할 것 같은데 이건 넣어줘야 할듯
                break;
            case "attacked":
                attackedPlayerByMonster();
                break;
            case "MonsterWin":
                MonsterWin();
                break;
            case "PlayerWinFromMonsterFight":
                PlayerWinFromMonsterFight();
                break;
            case "attack_check1":
                attack_check_for_Player();
                break;
            case "Next_fight":
                next_fight();
                break;
            case "run":
                Run();
                break;
            case "attack_check2":
                attack_check_for_Monster();
                break;

        }
    }


    public static void PlayerWinFromMonsterFight() {
        swi=true;
//        MainGamePageController.maingame_page.dispose();
//        MainGamePageController maingame_page_controller = new MainGamePageController();
//        maingame_page_controller.maingame_page.setVisible(true);
        FightMonsterController.fight_monster_page.dispose();
        Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].setSummoned_monster(null);
        MainGamePageController.show_monsters();
        System.out.println(MainGamePageController.maingame_page.getDialog_panel_controller() instanceof FightDialogPanelController);
        DialogPanelController.Clear();
        DialogPanelController.generateGeneralDialogues();
        Mainmusic_thread.thread.close();
        Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\Main.mp3", true);
        music_thread.start();
        MainGamePageController.maingame_page.revalidate();
        MainGamePageController.maingame_page.repaint();
    }

    public static void MonsterWin() {
        swi=true;
//        MainGamePageController.maingame_page.dispose();
//        MainGamePageController maingame_page_controller = new MainGamePageController();
//        maingame_page_controller.maingame_page.setVisible(true);
        Player.getCurrentPlayer().setStatus(Player.DEAD);
        MainGamePageController.show_players();
        FightMonsterController.fight_monster_page.dispose();
        System.out.println(MainGamePageController.maingame_page.getDialog_panel_controller() instanceof FightDialogPanelController);
        DialogPanelController.Clear();
        DialogPanelController.generateGeneralDialogues();
        Mainmusic_thread.thread.close();
        Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\Main.mp3", true);
        music_thread.start();
        MainGamePageController.maingame_page.revalidate();
        MainGamePageController.maingame_page.repaint();
    }

    public static void attackedPlayerByMonster() {
        FightDialogPanelController.Clear();
        int temp2 = ConstantEventHandler.Dice();
        if (temp2 > FightDialogPanelController.monster.getRequireVal()) {
            FightDialogPanelController.show_dialog(
                    "몬스터가 플레이어에게 "
                            + Integer.toString(FightDialogPanelController.monster.getDamage())
                            + "의 피해를 주었습니다."
            );


            if (FightDialogPanelController.monster.getDamageType() == 1)
            {
              Player.getCurrentPlayer().setHealth(Player.getCurrentPlayer().getHealth() - FightDialogPanelController.monster.getDamage());
              FightMonsterController.fight_monster_page
                        .getPlayer_panel()
                        .getHealth_text()
                        .setText(Integer.toString(Player.getCurrentPlayer().getHealth()));
            }
            else if (FightDialogPanelController.monster.getDamageType() == 2)
            {
                Player.getCurrentPlayer().setMental(Player.getCurrentPlayer().getMental() - FightDialogPanelController.monster.getDamage());
                FightMonsterController.fight_monster_page
                        .getPlayer_panel()
                        .getMental_text()
                        .setText(Integer.toString(Player.getCurrentPlayer().getMental()));}

            FightDialogPanelController.show_dialog_answer1(new Answer("계속","attack_check2"));
        } else {
            FightDialogPanelController.show_dialog("몬스터의 공격을 피했습니다.");
            FightDialogPanelController.show_dialog_answer1(new Answer("플레이어의 공격", "attack"));
        }
    }

    public static void attack_check_for_Monster()
    {
        FightDialogPanelController.Clear();
        if (Player.getCurrentPlayer().getHealth() < 1 || Player.getCurrentPlayer().getMental()<1) {
            FightDialogPanelController.Clear();
            FightDialogPanelController.show_dialog("몬스터에게 패배했습니다.");
            FightDialogPanelController.show_dialog_answer1(new Answer("전투 종료", "MonsterWin"));
        } else
            FightDialogPanelController.show_dialog_answer1(new Answer("몬스터를 공격", "attack"));
    }

    public static void attackedMonsterByPlayer() {
        FightDialogPanelController.Clear();
        int temp = ConstantEventHandler.Dice();
        if (temp > FightMonsterController.monster.getRequireVal()) {
            FightDialogPanelController.show_dialog(
                    "플레이어가 몬스터에게 "
                            + Integer.toString(temp - FightMonsterController.monster.getRequireVal())
                            + "의 피해를 주었습니다."
            );

            FightMonsterController.monster.setHealth(FightMonsterController.monster.getHealth() - (temp - FightMonsterController.monster.getRequireVal()));
            FightMonsterController.fight_monster_page
                    .getMonsterPanel()
                    .getMonster_health_txt()
                    .setText(Integer.toString(FightMonsterController.monster.getHealth()));
            FightDialogPanelController.show_dialog_answer1(new Answer("계속","attack_check1"));
        } else {
            FightDialogPanelController.show_dialog("데미지를 입히지 못했습니다.");
            FightDialogPanelController.show_dialog_answer1(new Answer("몬스터의 공격", "attacked"));
        }

    }

    public static void attack_check_for_Player()
    {
        FightDialogPanelController.Clear();
        if (FightDialogPanelController.monster.getHealth() < 1)
        {
            Player.getCurrentPlayer().setMoney(Player.getCurrentPlayer().getMoney()+FightDialogPanelController.monster.getMonster_result());
            Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].setSummoned_monster(null);

            ConstantEventHandler.fight_remain--;
            if(ConstantEventHandler.fight_remain<=0)        //일반 몬스터 전투 끝
            {
                FightDialogPanelController.show_dialog("적을 물리치고 살아남았습니다.");
                FightDialogPanelController.show_dialog_answer1(new Answer("전투 종료","PlayerWinFromMonsterFight"));
            }
            else            //포털 전투의 첫번째라 아직 전투가 남았을 때
            {
                FightDialogPanelController.show_dialog("적을 물리쳤지만 아직 남은 적이 있습니다. 전투에 대비하십시오!");
                FightDialogPanelController.show_dialog_answer1(new Answer("다음 전투로","Next_fight"));
            }
        } else
        {
            FightDialogPanelController.show_dialog_answer1(new Answer("몬스터가 공격 합니다.", "attacked"));
        }


    }
    public static void next_fight()
    {
        swi=true;
        MainGamePageController.maingame_page.dispose();
        MainGamePageController maingame_page_controller = new MainGamePageController();
        maingame_page_controller.maingame_page.setVisible(true);
        DialogPanelController.generateGeneralDialogues();
        FightMonsterController.fight_monster_page.dispose();
        Mainmusic_thread.thread.close();
        ConstantEventHandler.generateFight(MonsterType.values()[(int) Math.floor(Math.random() * 5)]);
    }

    public static void Ans1_1(Player player)//서브 이벤트 구현에 대한 이야기 필요
    {
        DialogPanelController.Clear();
        String message = "당신은 집회에 가보기로 했습니다.";
        DialogPanelController.show_dialog(message);
        RandomEventHandler rando = new RandomEventHandler();
        DialogPanelController.Clear();
        rando.Rev1_sub1(player);
    }

    public static void Ans1_1_1(Player player) {
        DialogPanelController.Clear();
        String message = "\"고통을 받아들여라.\" 교주가 당신에게 낙인을 찍습니다.";
        DialogPanelController.show_dialog(message);
        int tempHealth = player.getHealth();
        int tempMental = player.getMental();
        player.setHealth(tempHealth - 2);
        player.setMental(tempMental + 2);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans1_1_2(Player player) {
        DialogPanelController.Clear();
        String message = "\"때로는 피할 수 없는 고통도 있는 법이지.\" 교주가 당신에게 저주를 날립니다.";
        DialogPanelController.show_dialog(message);
        int tempHealth = player.getHealth();
        player.setHealth(tempHealth - 1);
        int tempMental = player.getMental();
        player.setMental(tempMental - 1);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans1_2(Player player) {
        DialogPanelController.Clear();
        String message = "위험해보입니다. 그런 곳은 가지 않는 것이 상책입니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans2_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "소리가 닿지 않는 곳으로 성공적으로 피했습니다.";
        String message2 = "메아리 소리에 정신이 아득해졌습니다.";
        if (player.getDexterity() < 3) {
            int tempMental = player.getMental();
            player.setMental(tempMental - 2);
            DialogPanelController.show_dialog(message2);
        } else
            DialogPanelController.show_dialog(message1);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans2_2(Player player) {
        DialogPanelController.Clear();
        String message = "소리를 내는 기괴한 생물체를 발견했습니다.";
        DialogPanelController.show_dialog(message);
        ConstantEventHandler.generateFight(MonsterType.Nightgaunt);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans3_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "당신은 훌륭하게 적을 꺾었고, 파이트 머니를 얻었습니다.";
        String message2 = "당신은 처참하게 적에게 패배했고, 그들은 당신을 내버려둔채 떠났습니다.";
        if (player.getPower() < 6) {
            player.setHealth(player.getHealth() - 2);
            player.setMental(player.getMental() - 1);
            DialogPanelController.show_dialog(message2);
        } else {
            DialogPanelController.show_dialog(message1);
            player.setMoney(player.getMoney() + 5);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans3_2(Player player) {
        DialogPanelController.Clear();
        String message = "회원들이 당신에게 겁쟁이라고 욕했지만, 당신은 아랑곳하지 않고 자리를 떠났습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans4_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "그가 망토 속에서 기이한 물건 하나를 꺼내 당신에게 건네줍니다.";
        String message2 = "그는 갑자기 망토 속에서 독을 바른 칼날을 꺼내 당신을 찌릅니다.";
        int tempDice = ConstantEventHandler.Dice();
        Dice_page test = new Dice_page();
        if (tempDice > 4) {
            DialogPanelController.show_dialog(message1);
            ConstantEventHandler.addRandomItem(player);
        } else {
            DialogPanelController.show_dialog(message2);
            player.setHealth(player.getHealth() - tempDice);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans4_2(Player player) {
        DialogPanelController.Clear();
        player.setMental(player.getMental() - 1);
        String message = "우연히 그와 눈이 마주치자 당신의 영혼의 일부가 손실된 것처럼 허전해집니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans4_3(Player player) {
        DialogPanelController.Clear();
        String message = "불길한 사람입니다. 자리에서 떠납니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans5_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "당신을 가격하는 몽둥이를 피했습니다.";
        String message2 = "당신을 가격하는 몽둥이를 피하지 못했습니다. 눈앞이 캄캄해집니다.";
        int tempDice = ConstantEventHandler.Dice();
        Dice_page test = new Dice_page();
        if (tempDice > 2 && player.getDexterity() > 2) {
            DialogPanelController.show_dialog(message1);
            Answer answer1 = new Answer("1. 계속", "continue");
            Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
            DialogPanelController.show_dialog_answer1(answer1);
            DialogPanelController.show_dialog_answer2(answer2);
        } else {
            DialogPanelController.show_dialog(message2);
            Answer answer1 = new Answer("1. 계속", "5_1_1");
            DialogPanelController.show_dialog_answer1(answer1);
        }


    }

    public static void Ans5_2_Sub1(Player player) {
        DialogPanelController.Clear();
        DialogPanelController.show_dialog("여기가...어디지?");
        Answer answer1 = new Answer("1. 낯선 곳에서의 새로운 사건이 발생합니다.", "5_1_1_1");
        DialogPanelController.show_dialog_answer1(answer1);

    }

    public static void Ans5_2_SubResult(Player player) {
        DialogPanelController.Clear();
        int temp = (int) Math.floor(Math.random() * 13);
        ConstantEventHandler.movebyTeleport(player, TileType.values()[temp]);
        ConstantEventHandler.generateRandomEvent(player);
    }

    public static void Ans6_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "조각상 안에 숨겨져 있던 주문을 해제하는 것을 성공했습니다. 알 수 없는 힘이 온 몸을 휘감습니다.";
        String message2 = "으스스한 공포가 온 몸을 휘감습니다.";
        if (player.getIntelligence() > 5) {
            player.setDexterity(player.getDexterity() + 1);
            DialogPanelController.show_dialog(message1);
        } else {
            player.setPower(player.getPower() - 1);
            player.setDexterity(player.getDexterity() - 1);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans6_2(Player player) {
        DialogPanelController.Clear();
        String message = "불길한 소문입니다. 무시합니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }


    public static void Ans7_1(Player player) {
        // TODO : 디버깅 필요 !! 실패시 플레이어의 위치가 임의로 변경되는데 이 변경이 맵에 반영이 안된다.
        DialogPanelController.Clear();
        String message1 = "상자를 열고 신비로운 힘이 느껴지는 물건을 얻었습니다.";
        String message2 = "상자를 여는 것을 경비원에게 들켰습니다.";
        int tempDice = ConstantEventHandler.Dice();
        Dice_page test = new Dice_page();
        if (player.getDexterity() > 2 && tempDice > 3) {
            ConstantEventHandler.addRandomItem(player);
            DialogPanelController.show_dialog(message1);
        } else {
            int temp = (int) Math.floor(Math.random() * 13);
            ConstantEventHandler.movebyTeleport(player, TileType.values()[temp]);
            MainGamePageController.show_players();
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans7_2(Player player) {
        DialogPanelController.Clear();
        String message = "호기심이 고양이를 죽이는 법입니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans8_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "이야기를 제보하고 5$를 받습니다.";
        String message2 = "할 이야기가 없습니다.";
        if (GameMaster.token > 2) {
            player.setMoney(player.getMoney() + 5);
            DialogPanelController.show_dialog(message1);
        } else {
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans8_2(Player player) {
        DialogPanelController.Clear();
        String message = "이런 이야기는 사람들에게 알려져서는 안됩니다. 제보하지 않습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans9_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "당신은 이제 자랑스러운 파이트 클럽의 회원입니다.";
        String message2 = "충분한 돈이 없습니다.";
        String message3 = "\"돈도 없으면서 허세를 부린건가?\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if (player.getMoney() > 2) {
            player.setMoney(player.getMoney() - 3);
            player.setPower(player.getPower() + 2);
            DialogPanelController.show_dialog(message1);
        } else {
            if (player.getPower() > 2)
                DialogPanelController.show_dialog(message2);
            else {
                player.setHealth(player.getHealth() - 3);
                DialogPanelController.show_dialog(message3);
            }
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans9_2(Player player) {
        DialogPanelController.Clear();
        String message1 = "그런 조직에 쓸 시간도, 돈도 없습니다.";
        String message2 = "\"우리 조직을 무시하다니.\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if (player.getPower() > 2)
            DialogPanelController.show_dialog(message1);
        else {
            player.setHealth(player.getHealth() - 3);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans10_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.";
        String message2 = "그가 당신의 눈 앞에서 소멸됩니다.";
        int tempDice = ConstantEventHandler.Dice();
        Dice_page test = new Dice_page();
        if (player.getDexterity() > 5 && tempDice > 3) {
            player.setPower(player.getPower() + 1);
            player.setDexterity(player.getDexterity() + 1);
            player.setIntelligence(player.getIntelligence() + 1);
            DialogPanelController.show_dialog(message1);
        } else {
            player.setMental(player.getMental() - tempDice);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans10_2(Player player) {
        DialogPanelController.Clear();
        String message = "정말 그는 당신이 모르는 사람일까요?";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans11_1(Player player) {
        DialogPanelController.Clear();
        String message = "그의 연주를 듣고 있으니 마음 한구석이 치유되는 것 같습니다.";
        player.setMental(player.getMental() + 2);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans12_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "\"거래 고맙네.\" 노인은 갑자기 사라졌고, 당신은 주머니가 허전해짐과 동시에 손에 정체모를 램프가 들려있는 것을 발견합니다.";
        String message2 = "\"이런..3달러도 없단 말인가?\" 노인이 갑자기 사라집니다.";
        int tempDice = ConstantEventHandler.Dice();
        Dice_page test = new Dice_page();
        if (player.getMoney() > 2) {
            ConstantEventHandler.addItem(player, ItemType.values()[10]);
            DialogPanelController.show_dialog(message1);
        } else {
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans12_2(Player player) {
        DialogPanelController.Clear();
        String message = "\"존중할줄 아는 자세가 필요하겠군.\" 노인이 갑자기 사라지고 당신은 현기증을 느낍니다.";
        player.setMental(player.getMental() - 1);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans13_1(Player player) {
        DialogPanelController.Clear();
        String message = "공포가 당신을 휘감습니다.";
        player.setMental(player.getMental() - 1);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans14_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "\"안타깝네, 뒤...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"지만 참가상품도 있으니까!\"";
        String message2 = "\"안타깝네, 뒤야.\"";
        if (player.getDexterity() > 5) {
            ConstantEventHandler.addRandomItem(player);
            DialogPanelController.show_dialog(message1);
        } else {
            player.setMoney(player.getMoney() - 2);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans14_2(Player player) {
        DialogPanelController.Clear();
        String message1 = "\"안타깝네, 앞...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"이지만 참가상품도 있으니까!\"";
        String message2 = "\"안타깝네, 앞이야.\"";
        if (player.getDexterity() > 5) {
            ConstantEventHandler.addRandomItem(player);
            DialogPanelController.show_dialog(message1);
        } else {
            player.setMoney(player.getMoney() - 2);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans15_1(Player player) {
        DialogPanelController.Clear();
        String message = "당신은 오싹한 기분을 느낍니다.";
        player.setMental(player.getMental() - 1);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans16_1(Player player) {
        DialogPanelController.Clear();
        String message = "정신이 아득해지는 것을 느꼈지만, 단서 또한 얻었습니다.";
        player.setMental(player.getMental() - 1);
        GameMaster.token++;
        MainGamePageController.update_token(GameMaster.token);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans17_1(Player player) {
        DialogPanelController.Clear();
        String message = "유령선이라...철 지난 농담같군요.";
        int tempPlace = (int) Math.floor(Math.random() * 13);
        int tempPlace2 = (int) Math.floor(Math.random() * 13);
        int tempMon = (int) Math.floor(Math.random() * 5);
        int tempMon2 = (int) Math.floor(Math.random() * 5);
        ConstantEventHandler.CreateMonster(MonsterType.values()[tempMon], TileType.values()[tempPlace]);
        ConstantEventHandler.CreateMonster(MonsterType.values()[tempMon2], TileType.values()[tempPlace2]);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans18_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "당신은 검은 정장의 사나이의 안으로 빨려들어가는 것을 느낍니다...";
        String message2 = "당신은 이 미친 거래에서 살아남았습니다. 사나이는 당신에게 힘을 주고 떠나갑니다. \"다음에 뵙겠습니다.\"";
        int tempNum = player.getMental();
        for (int i = 0; i < tempNum; i++) {
            int tempDice = ConstantEventHandler.Dice();
            Dice_page test = new Dice_page();
            if (tempDice < 4)
                player.setMental(player.getMental() - 1);

            if (player.getMental() == 0) {
                DialogPanelController.show_dialog(message1);
                player.setStatus(2);                                               //Status 2는 즉사 상태. 즉 즉사 체크 없이 즉사 처리함+status 구현 어떻게 되었는지??
                break;
            }
        }
        if (player.getMental() > 0) {
            player.setPower(player.getPower() + 1);
            player.setDexterity(player.getDexterity() + 1);
            player.setMental(player.getMental() + 1);
            DialogPanelController.show_dialog(message2);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans18_2(Player player) {
        DialogPanelController.Clear();
        String message = "\"안타깝군요. 다음에는 거래에 응해주시길.\"";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }


    public static void Ans19_1(Player player) {
        DialogPanelController.Clear();
        String message = "이는 사람의 짓이 아닙니다. 괴물이 빈민가에 풀려난 것 같습니다.";
        for (int i = 0; i < 3; i++) {
            int tempMon = (int) Math.floor(Math.random() * 5);
            int tempPlace = (int) Math.floor(Math.random() * 13);
            ConstantEventHandler.CreateMonster(MonsterType.values()[tempMon], TileType.values()[tempPlace]);
        }

        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }


    public static void Ans20_1(Player player) {
        DialogPanelController.Clear();
        String message = "써도 괜찮은 물건일까요?";
        ConstantEventHandler.addRandomItem(player);
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans21_1(Player player) {
        DialogPanelController.Clear();
        String message1 = "역시나 함정이었지만, 당신의 뛰어난 정신력과 지식이 이를 막았습니다. 이제 뭘하냐고요? 스위트룸을 즐겨야죠.";
        String message2 = "역시나 함정이었지만, 당신의 처참한 정신력과 낮은 지성은 이를 인지하지도 못하나보군요.";
        if (player.getMental() > 5 && player.getIntelligence() > 5) {
            DialogPanelController.show_dialog(message1);
            player.setMental(player.getMental() + 2);
            player.setHealth(player.getHealth() + 2);
            player.setMoney(player.getMoney() - 3);
        } else {
            DialogPanelController.show_dialog(message2);
            player.setMoney(player.getMoney() - 3);
            player.setMental(player.getMental() - 4);
        }
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void Ans21_2(Player player) {
        DialogPanelController.Clear();
        String message = "함정에 제 발로 입장하는 바보는 없겠죠?";
        DialogPanelController.show_dialog(message);

        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void ContinueDialog() {
        if (Player.getCurrentPlayer().getEnergy() < 1) {
            DialogPanelController.Clear();
            String message = "사용 가능한 행동치가 없습니다.";
            DialogPanelController.show_dialog(message);
            Answer answer1 = new Answer("1. 턴 종료", "turnEnd");
            DialogPanelController.show_dialog_answer1(answer1);
        } else {
            DialogPanelController.Clear();
            DialogPanelController.generateGeneralDialogues();
        }
    }

    public static void TurnEnd() {
        DialogPanelController.Clear();
        GameMaster.turnEnd();
    }

    public static void hospital_Ans1(Player player) {
        DialogPanelController.Clear();
        String message = "치료를 받았습니다.";
        DialogPanelController.show_dialog(message);
        player.setHealth(player.getHealth() + 3);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void hospital_Ans2(Player player) {
        DialogPanelController.Clear();
        String message = "병원을 지나칩니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void mospital_Ans1(Player player) {
        DialogPanelController.Clear();
        String message = "치료를 받았습니다.";
        DialogPanelController.show_dialog(message);
        player.setMental(player.getMental() + 3);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void mospital_Ans2(Player player) {
        DialogPanelController.Clear();
        String message = "정신병원은 방문 안 하는게 좋겠죠.";
        DialogPanelController.show_dialog(message);
        Answer answer1 = new Answer("1. 계속", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

    public static void death_Ans(Player player) {
        if (player.getStatus() == 2)
            Win_check(player);

        GameMaster.death_count--;
        if (ConstantEventHandler.Dice() > 5)
            GameMaster.revive(player);

        if (player.getHealth() <= 0 || player.getMental() <= 0) {
            if (GameMaster.death_count > 0) {
                DialogPanelController.Clear();
                DialogPanelController.show_dialog("즉사 체크 실패!");
                Answer answer1 = new Answer("1. 계속", "death");
                DialogPanelController.show_dialog_answer1(answer1);
            } else {
                DialogPanelController.Clear();
                DialogPanelController.show_dialog("죽음을 극복하지 못했습니다.");
                player.setStatus(2);
                GameMaster.death_count = 3 - GameMaster.revive_count;
                Answer answer1 = new Answer("1. 계속", "win_check");
                DialogPanelController.show_dialog_answer1(answer1);
            }
        } else {
            DialogPanelController.Clear();
            DialogPanelController.show_dialog("죽음을 극복했습니다.");
            GameMaster.revive_count++;
            if (GameMaster.revive_count > 3)
                GameMaster.revive_count = 3;
            GameMaster.death_count = 3 - GameMaster.revive_count;
            Answer answer1 = new Answer("1. 계속", "win_check");
            DialogPanelController.show_dialog_answer1(answer1);
        }
    }

    public static void Win_check(Player player) {
        if (GameMaster.check_num_of_token_for_win()) {
            DialogPanelController.Clear();
            DialogPanelController.show_dialog("봉인의 조각들을 모두 모아 고대신이 강림하기 전 막는 것을 성공했습니다!");
            Answer answer1 = new Answer("승리", "win");
            DialogPanelController.show_dialog_answer1(answer1);
        } else {
            DialogPanelController.Clear();
            RandomEventAnswer.Defeat(player);
        }
    }

    public static void Win_Ans(Player player) {
        //승리 화면 출력
    }

    public static void Defeat(Player player) {
        if (GameMaster.check_player_status_for_lost()) {
            DialogPanelController.Clear();
            DialogPanelController.show_dialog("플레이어가 모두 사망했습니다. 고대신은 잠에서 깨어날 것이고, 도시는 파괴될 것입니다.");
            Answer answer1 = new Answer("패배", "defeat");
            DialogPanelController.show_dialog_answer1(answer1);
        } else {
            DialogPanelController.Clear();
            RandomEventAnswer.checkBoss_Summon_condition(player);
        }
    }

    public static void Defeat_Ans(Player player) {
        //패배 화면 출력
    }

    public static void checkBoss_Summon_condition(Player player) {
        if (GameMaster.check_num_of_monsters_portals_for_boss()) {
            DialogPanelController.Clear();
            DialogPanelController.show_dialog("고대신이 잠에서 깨어납니다. 모두 대비하십시오!");
            Answer answer1 = new Answer("고대신과의 최종전", "boss_fight");
            DialogPanelController.show_dialog_answer1(answer1);
        } else {
            DialogPanelController.Clear();
            if (idx_of_cur_player == 1)
                RandomEventAnswer.Next_Turn(player);
            else
                RandomEventAnswer.Next_Player(player);
        }
    }

    public static void Boss_fight() {
        GameMaster.generateBossFight(GameMaster.current_boss);
    }

    public static void Next_Turn(Player player) {
        MainGamePageController.show_players();
        if (GameMaster.turn % 3 == 0) {
            GameMaster.setPortalAndMonsterRandomly();
            MainGamePageController.show_monsters();
            MainGamePageController.show_portals();
        }

        for (int i = 0; i < 2; i++) {
            if (Player.players[i].getStatus() != 2)
                Player.players[i].setEnergy(Player.players[i].getHealth() / 3);
            else
                Player.players[i].setEnergy(0);

            if (Player.players[i].getEnergy() == 0 && Player.players[i].getStatus() != 2)
                Player.players[i].setEnergy(1);
        }
        Player.toggleCurrentPlayer();
        GameMaster.turn++;

        // Update turn value to MainGame_page(view)
        MainGamePageController.maingame_page.getTab().getTurn_text().setText(Integer.toString(GameMaster.turn));

        if (Player.getCurrentPlayer().getStatus() == 2)
            DialogPanelController.Dead_Player_Dialog();
        else
            DialogPanelController.generateGeneralDialogues();
    }

    public static void Next_Player(Player player) {
        MainGamePageController.show_players();
        Player.toggleCurrentPlayer();

        // Update turn value to MainGame_page(view)
        MainGamePageController.maingame_page.getTab().getTurn_text().setText(Integer.toString(GameMaster.turn));

        if (Player.getCurrentPlayer().getStatus() == 2)
            DialogPanelController.Dead_Player_Dialog();
        else
            DialogPanelController.generateGeneralDialogues();
    }

    public static void Not_Enough_Money() {
        DialogPanelController.Clear();
        String message = "돈이 충분하지 않습니다.";
        DialogPanelController.show_dialog(message);

        Answer answer1 = new Answer("1. 다시 상점으로", "re_shop");
        Answer answer2 = new Answer("2. 상점 나가기", "continue");
        Answer answer3 = new Answer("3. 턴 종료", "turnEnd");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
        DialogPanelController.show_dialog_answer3(answer3);

    }

    public static void Purchase_Complete() {
        DialogPanelController.Clear();
        String message = "아이템을 구입했습니다.";
        DialogPanelController.show_dialog(message);

        Answer answer1 = new Answer("1. 상점 나가기", "continue");
        Answer answer2 = new Answer("2. 턴 종료", "turnEnd");
        Answer answer3 = new Answer("3. 계속해서 구매", "re_shop");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
        DialogPanelController.show_dialog_answer3(answer3);
    }

    public static void Return_To_Shop() {
        DialogPanelController.Clear();
        ConstantEventHandler.shop_maintain_switch = true;
        ConstantEventHandler.shop();
    }

    public static void Run()
    {
        String message = "몬스터에게서 도망치는 것이 가능할거라 생각했나요? 죽거나 죽이거나, 둘밖에 없습니다.";
        FightDialogPanelController.show_dialog(message);
    }

    public static void Attack_of_Player()
    {
        if(ConstantEventHandler.Dice()>=FightDialogPanelController.monster.getRequireVal()) //몬스터에게 데미지를 입힘
        {
            int attack_val=ConstantEventHandler.Dice()-FightDialogPanelController.monster.getRequireVal();
            FightDialogPanelController.monster.setHealth(FightDialogPanelController.monster.getHealth()-attack_val);

            FightDialogPanelController.Clear();

            StringBuilder message=new StringBuilder();
            message.append(FightDialogPanelController.monster.getMonster_type().getName());
            message.append("에게 ");
            message.append(attack_val);
            message.append("만큼의 피해를 입혔습니다.");
            FightDialogPanelController.show_dialog(message.toString());
            FightDialogPanelController.show_dialog_answer1(new Answer("계속","fight_check"));

        }
        else
            {
                FightDialogPanelController.show_dialog("적에게 피해를 입히지 못했습니다.");
                FightDialogPanelController.show_dialog_answer1(new Answer("몬스터의 공격","attacked"));
        }
    }

    public static void Fight_check()
    {
        if(FightDialogPanelController.monster.getHealth()<=0)       //데미지를 입혀서 몬스터 사망
        {
            ConstantEventHandler.fight_remain--;
            if(ConstantEventHandler.fight_remain<=0)        //일반 몬스터 전투 끝
            {
                FightDialogPanelController.Clear();
                FightDialogPanelController.show_dialog("적을 물리치고 살아남았습니다.");
                Player.getCurrentPlayer().setMoney(Player.getCurrentPlayer().getMoney()+FightDialogPanelController.monster.getMonster_result());
                FightDialogPanelController.show_dialog_answer1(new Answer("계속","continue"));
                //전투 창 닫기
            }
            else            //포털 전투의 첫번째라 아직 전투가 남았을 때
            {
                FightDialogPanelController.Clear();
                FightDialogPanelController.show_dialog("적을 물리쳤지만 아직 남은 적이 있습니다. 전투에 대비하십시오!");
                Player.getCurrentPlayer().setMoney(Player.getCurrentPlayer().getMoney()+FightDialogPanelController.monster.getMonster_result());
                //전투 창을 닫고 다음 전투로(버튼으로)
                FightDialogPanelController.show_dialog_answer1(new Answer("계속","continue"));
            }
        }
        else    //몬스터가 죽진 않음
        {
            FightDialogPanelController.show_dialog_answer1(new Answer("몬스터의 공격","attacked"));
        }
    }

    public static void Fight_Check_for_Monster()
    {

    }
}
