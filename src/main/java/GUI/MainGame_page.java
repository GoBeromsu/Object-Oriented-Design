package GUI;

import com.GameMaster;
import com.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */
public class MainGame_page extends JFrame {
    Image img = new ImageIcon("src/images/backgroundImage.jpg").getImage();


    public static void main(String[] args) {
        MainGame_page MainGame = new MainGame_page();
        MainGame.setVisible(true);
    }

    public MainGame_page() {


        setBounds(100, 100, 1200, 960);
        getContentPane().setLayout(null);

        JPanel tab = new JPanel();
        tab.setBounds(0, 0, 1182, 140);
        getContentPane().add(tab);
        tab.setLayout(null);

        JButton status = new JButton("Status");
        status.setBounds(126, 36, 173, 53);
        tab.add(status);

        status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int FIRST_PLAYER_IDX = 0;
                MainGamePlayerStatusDetail_page temp = new MainGamePlayerStatusDetail_page(Player.getPlayer(FIRST_PLAYER_IDX));
                dispose();
                temp.setVisible(true);
            }
        });

        JLabel token = new JLabel("token");
        token.setBounds(692, 36, 160, 45);
        tab.add(token);

        JTextPane token_text = new JTextPane();
        token_text.setBounds(780, 36, 76, 45);
        token_text.setEditable(false);
        token_text.setText(Integer.toString(GameMaster.token));
        tab.add(token_text);

        JLabel turn = new JLabel("Turn");
        turn.setBounds(866, 40, 195, 36);
        tab.add(turn);

        JTextPane turn_text = new JTextPane();
        turn_text.setBounds(938, 36, 123, 45);
        turn_text.setEditable(false);
        turn_text.setText(Integer.toString(GameMaster.turn));
        tab.add(turn_text);

        DialogPanel dialog_panel = new DialogPanel();
        dialog_panel.setBounds(599, 165, 569, 430);
        getContentPane().add(dialog_panel);
        dialog_panel.setLayout(null);
        {
            JLabel test = new JLabel(new ImageIcon("C:\\Last\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\azatoth.png"));
            getContentPane().add(test);
            test.setBounds(244, 445, 105, 54);

            JButton city_btn_0 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("test");
                }
            });
            city_btn_0.setFocusPainted(false);
            city_btn_0.setContentAreaFilled(false);
            city_btn_0.setBorderPainted(false);
            city_btn_0.setBounds(244, 315, 105, 54);
            getContentPane().add(city_btn_0);

            JButton city_btn_1 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_1.setFocusPainted(false);
            city_btn_1.setContentAreaFilled(false);
            city_btn_1.setBorderPainted(false);
            city_btn_1.setBounds(244, 209, 105, 54);
            getContentPane().add(city_btn_1);

            JButton city_btn_2 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_2.setFocusPainted(false);
            city_btn_2.setContentAreaFilled(false);
            city_btn_2.setBorderPainted(false);
            city_btn_2.setBounds(145, 268, 105, 54);
            getContentPane().add(city_btn_2);

            JButton city_btn_3 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_3.setFocusPainted(false);
            city_btn_3.setContentAreaFilled(false);
            city_btn_3.setBorderPainted(false);
            city_btn_3.setBounds(145, 370, 105, 54);
            getContentPane().add(city_btn_3);


            JButton city_btn_4 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_4.setFocusPainted(false);
            city_btn_4.setContentAreaFilled(false);
            city_btn_4.setBorderPainted(false);
            city_btn_4.setBounds(244, 431, 105, 54);
            getContentPane().add(city_btn_4);

            JButton city_btn_5 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            city_btn_5.setFocusPainted(false);
            city_btn_5.setContentAreaFilled(false);
            city_btn_5.setBorderPainted(false);
            city_btn_5.setBounds(355, 370, 105, 54);
            getContentPane().add(city_btn_5);

            JButton city_btn_6 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_6.setFocusPainted(false);
            city_btn_6.setContentAreaFilled(false);
            city_btn_6.setBorderPainted(false);
            city_btn_6.setBounds(355, 268, 105, 54);
            getContentPane().add(city_btn_6);

            JButton city_btn_7 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_7.setFocusPainted(false);
            city_btn_7.setContentAreaFilled(false);
            city_btn_7.setBorderPainted(false);
            city_btn_7.setBounds(399, 165, 105, 54);
            getContentPane().add(city_btn_7);


            JButton city_btn_8 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_8.setFocusPainted(false);
            city_btn_8.setContentAreaFilled(false);
            city_btn_8.setBorderPainted(false);
            city_btn_8.setBounds(114, 165, 105, 54);
            getContentPane().add(city_btn_8);


            JButton city_btn_9 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_9.setFocusPainted(false);
            city_btn_9.setContentAreaFilled(false);
            city_btn_9.setBorderPainted(false);
            city_btn_9.setBounds(14, 315, 105, 54);
            getContentPane().add(city_btn_9);


            JButton city_btn_10 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_10.setFocusPainted(false);
            city_btn_10.setContentAreaFilled(false);
            city_btn_10.setBorderPainted(false);
            city_btn_10.setBounds(114, 473, 105, 54);
            getContentPane().add(city_btn_10);

            JButton city_btn_11 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_11.setFocusPainted(false);
            city_btn_11.setContentAreaFilled(false);
            city_btn_11.setBorderPainted(false);
            city_btn_11.setBounds(399, 473, 105, 54);
            getContentPane().add(city_btn_11);

            JButton city_btn_12 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_12.setFocusPainted(false);
            city_btn_12.setContentAreaFilled(false);
            city_btn_12.setBorderPainted(false);
            city_btn_12.setBounds(501, 315, 105, 54);
            getContentPane().add(city_btn_12);
        }

        JLabel player1_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
        player1_img.setBounds(650, 620, 240, 163);
        getContentPane().add(player1_img);

        JLabel player1_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player1_name.setBounds(650, 780, 240, 61);
        getContentPane().add(player1_name);

        p_simplestat player1 = new p_simplestat();
        JPanel player1_temp = new JPanel();
        player1_temp.setBounds(290, 670, 318, 225);
        getContentPane().add(player1_temp);
        player1_temp.add(player1);

        JLabel player2_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
        player2_img.setBounds(41, 620, 240, 163);
        getContentPane().add(player2_img);

        JLabel player2_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player2_name.setBounds(41, 780, 240, 61);
        getContentPane().add(player2_name);

        p_simplestat player2 = new p_simplestat();
        JPanel player2_temp = new JPanel();
        player2_temp.setBounds(864, 670, 318, 225);
        getContentPane().add(player2_temp);
        player2_temp.add(player2);


    }


    class p_simplestat extends JPanel {

        p_simplestat() {
            /*
             * 테스트 코드
             * test temp = new test(); JPanel temp1 = new JPanel();
             * temp1.setBounds(0, 183, 394, 741); getContentPane().add(temp1);
             * temp1.add(temp);
             */

            Dimension simplestat_dimension = new Dimension(40, 30);
            JPanel health_panel = new JPanel();
            JLabel health = new JLabel("체력");
            health.setPreferredSize(simplestat_dimension);
            JTextPane health_text = new JTextPane();
            health_text.setText(Integer.toString(Player.getCurrentPlayer().getHealth()));
            health_text.setEditable(false);
            health_text.setPreferredSize(simplestat_dimension);


            JPanel mental_panel = new JPanel();
            JLabel mental = new JLabel("정신력");
            mental.setPreferredSize(new Dimension(40, 30));
            JTextPane mental_text = new JTextPane();
            mental_text.setText(Integer.toString(Player.getCurrentPlayer().getMental()));
            mental_text.setEditable(false);
            mental_text.setPreferredSize(simplestat_dimension);

            JPanel energy_panel = new JPanel();
            JLabel energy = new JLabel("행동치");
            energy.setPreferredSize(new Dimension(40, 30));
            JTextPane energy_text = new JTextPane();
            energy_text.setText(Integer.toString(Player.getCurrentPlayer().getEnergy()));
            energy_text.setEditable(false);
            energy_text.setPreferredSize(simplestat_dimension);

            JPanel money_panel = new JPanel();
            JLabel money = new JLabel("money");
            money.setPreferredSize(new Dimension(40, 30));
            JTextPane money_text = new JTextPane();
            money_text.setText(Integer.toString(Player.getCurrentPlayer().getMoney()));
            money_text.setEditable(false);
            money_text.setPreferredSize(simplestat_dimension);

            Player.toggleCurrentPlayer();

            health_panel.add(health);
            health_panel.add(health_text);
            add(health_panel);

            mental_panel.add(mental);
            mental_panel.add(mental_text);
            add(mental_panel);

            energy_panel.add(energy);
            energy_panel.add(energy_text);
            add(energy_panel);

            money_panel.add(money);
            money_panel.add(money_text);
            add(money_panel);

            setLayout(new GridLayout(4, 2, 20, 0));
        }
    }
}
