package com;

import GUI.DialogPanel;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * 메인게임페이지에서 사용될 dialogpanel에 관한 controller이다.
 * 다이얼로그를 쉽게 업데이트 하기 위한 메소드와, clear, 자주 사용되는 다이얼로그를 출력하는 메소드로 구성되어 있다.
 *
 * @author Se-Ok Jeon
 */
@Data
public class DialogPanelController {

    static public DialogPanel dialog_panel;
    static public JLabel lb_just_text;
    static public JButton selectbtn1;
    static public JButton selectbtn2;
    static public JButton selectbtn3;

    public DialogPanelController() throws IOException {
        dialog_panel = new DialogPanel();
        lb_just_text = dialog_panel.getLb_just_text();
        selectbtn1 = dialog_panel.getSelectbtn1();
        selectbtn2 = dialog_panel.getSelectbtn2();
        selectbtn3 = dialog_panel.getSelectbtn3();
        selectbtn1.setHorizontalTextPosition(AbstractButton.CENTER);
        selectbtn1.setVerticalTextPosition(AbstractButton.CENTER);
        selectbtn1.setForeground(Color.white);
        selectbtn2.setHorizontalTextPosition(AbstractButton.CENTER);
        selectbtn2.setVerticalTextPosition(AbstractButton.CENTER);
        selectbtn2.setForeground(Color.white);
        selectbtn3.setHorizontalTextPosition(AbstractButton.CENTER);
        selectbtn3.setVerticalTextPosition(AbstractButton.CENTER);
        selectbtn3.setForeground(Color.white);

        generateGeneralDialogues();

    }

    /**
     * 현재 다이얼로그의 모든 내용을 지우고,
     * 버튼이 새로운 이벤트 리스너를 받아 들일 수 있도록 각 버튼의 listener를 모두 제거하는 메소드이다.
     */
    static public void Clear() {
        lb_just_text.setText("");
        selectbtn1.setText("");
        selectbtn2.setText("");
        selectbtn3.setText("");

        if (selectbtn1.getActionListeners().length > 0)
            selectbtn1.removeActionListener(selectbtn1.getActionListeners()[0]);
        if (selectbtn2.getActionListeners().length > 0)
            selectbtn2.removeActionListener(selectbtn2.getActionListeners()[0]);
        if (selectbtn3.getActionListeners().length > 0)
            selectbtn3.removeActionListener(selectbtn3.getActionListeners()[0]);
    }

    /**
     * 자주 사용되는 다이얼로그를 출력하고 필요한 이벤트 리스너를 붙이는 메소드
     */
    public static void generateGeneralDialogues() {

        Clear();

        StringBuilder sb = new StringBuilder();
        sb.append(Player.idx_of_cur_player + 1);
        sb.append("번째 플레이어 차례입니다.");
        lb_just_text.setText(sb.toString());

        selectbtn1.setText("플레이어 위치 이동");
        selectbtn2.setText("현 위치에서 랜덤 이벤트 발생");
        selectbtn3.setText("이대로 턴 종료");

        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Player.getCurrentPlayer().getEnergy() < 1||Player.getCurrentPlayer().getHealth()<=0||Player.getCurrentPlayer().getMental()<=0) {
                    Clear();
                    DialogPanelController.show_dialog("사용 가능한 행동치가 없습니다.");

                    DialogPanelController.show_dialog_answer1(new Answer("1. 턴 종료", "turnEnd"));
                } else {
                    Clear();
                    show_dialog("원하는 위치를 클릭해 플레이어를 이동시킬 수 있습니다.");
                    Player.getCurrentPlayer().setEnergy(Player.getCurrentPlayer().getEnergy() - 1);
                    MainGamePageController.show_reddot();
                }
            }
        });

        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Player.getCurrentPlayer().getEnergy() < 1||Player.getCurrentPlayer().getHealth()<=0||Player.getCurrentPlayer().getMental()<=0) {
                    Clear();
                    DialogPanelController.show_dialog("사용 가능한 행동치가 없습니다.");
                    DialogPanelController.show_dialog_answer1(new Answer("1. 턴 종료", "turnEnd"));
                } else {
                    Player.getCurrentPlayer().setEnergy(Player.getCurrentPlayer().getEnergy() - 1);
                    Clear();
                    ConstantEventHandler.generateRandomEvent(Player.getCurrentPlayer());
                }
            }
        });
        selectbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
                GameMaster.turnEnd();
            }
        });

        lb_just_text.setVisible(true);
        selectbtn1.setVisible(true);
        selectbtn2.setVisible(true);
        selectbtn3.setVisible(true);
    }

    /**
     * 사망한 플레이어 턴을 건너 뛰기위해 관련 텍스트와 버튼을 출력하는 메소드이다.
     */
    public static void Dead_Player_Dialog() {

        Clear();

        lb_just_text.setText("해당 플레이어는 사망했습니다.");
        selectbtn1.setText("다음 플레이어로");


        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
                RandomEventAnswer.Win_check(Player.getCurrentPlayer());
            }
        });

        lb_just_text.setVisible(true);
        selectbtn1.setVisible(true);
    }
    /**
     * 라벨에 넣을 텍스트를 세팅하는 메소드이다.
     * @param s
     * 라벨에 넣을 문자열
     */
    static public void show_dialog(String s) {
        lb_just_text.setText(s);
        lb_just_text.setVisible(true);

        dialog_panel.revalidate();
        dialog_panel.repaint();
    }

    /**
     * 1번 버튼에 텍스트와, 이벤트 리스너를 붙이는 메소드
     * @param answer
     * Answer 객체로, 버튼에 출력할 문자열과, 이벤트 구별을 위한 이벤트 태그가 존재한다.
     */
    static public void show_dialog_answer1(Answer answer) {
        selectbtn1.setText(answer.getMessage());
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answer.getTag() == "shop") {
                    if (!ConstantEventHandler.isAffordable(Player.getCurrentPlayer(), answer.getItem())) {
                        RandomEventAnswer.Not_Enough_Money();
                    } else {
                        Player.getCurrentPlayer().setMoney(ConstantEventHandler.getChange(Player.getCurrentPlayer(), answer.getItem()));
                        ConstantEventHandler.addItem(Player.getCurrentPlayer(), answer.getItem());
                        ConstantEventHandler.itemlist.set(0, null);
                        RandomEventAnswer.Purchase_Complete();
                    }
                } else {
                    try {
                        RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn1.setVisible(true);
    }

    /**
     * 2번 버튼에 텍스트와, 이벤트 리스너를 붙이는 메소드
     * @param answer
     * Answer 객체로, 버튼에 출력할 문자열과, 이벤트 구별을 위한 이벤트 태그가 존재한다.
     */
    static public void show_dialog_answer2(Answer answer) {
        selectbtn2.setText(answer.getMessage());
        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answer.getTag() == "shop") {
                    if (Player.getCurrentPlayer().getMoney() < answer.getItem().getPrice()) {
                        RandomEventAnswer.Not_Enough_Money();
                    } else {
                        Player.getCurrentPlayer().setMoney(Player.getCurrentPlayer().getMoney() - answer.getItem().getPrice());
                        ConstantEventHandler.addItem(Player.getCurrentPlayer(), answer.getItem());
                        ConstantEventHandler.itemlist.set(1, null);
                        RandomEventAnswer.Purchase_Complete();
                    }
                } else {
                    try {
                        RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn2.setVisible(true);
    }

    /**
     * 1번 버튼에 텍스트와, 이벤트 리스너를 붙이는 메소드
     * @param answer
     * Answer 객체로, 버튼에 출력할 문자열과, 이벤트 구별을 위한 이벤트 태그가 존재한다.
     */
    static public void show_dialog_answer3(Answer answer) {
        selectbtn3.setText(answer.getMessage());
        selectbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answer.getTag() == "shop") {
                    if (Player.getCurrentPlayer().getMoney() < answer.getItem().getPrice()) {
                        RandomEventAnswer.Not_Enough_Money();
                    } else {
                        Player.getCurrentPlayer().setMoney(Player.getCurrentPlayer().getMoney() - answer.getItem().getPrice());
                        ConstantEventHandler.addItem(Player.getCurrentPlayer(), answer.getItem());
                        ConstantEventHandler.itemlist.set(2, null);
                        RandomEventAnswer.Purchase_Complete();
                    }
                } else {
                    try {
                        RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn3.setVisible(true);
    }
}
