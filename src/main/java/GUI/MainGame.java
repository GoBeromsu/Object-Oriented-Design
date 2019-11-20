package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */
public class MainGame extends JFrame {
    Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/OrientedPG/src/images/backgroundImage.jpg").getImage();


    public MainGame() {
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
                MainGame_setstatus temp = new MainGame_setstatus();
                dispose();
                temp.setVisible(true);
            }
        });

        JLabel token = new JLabel("token");
        token.setBounds(692, 36, 160, 45);
        tab.add(token);

        JLabel turn = new JLabel("Turn");
        turn.setBounds(866, 40, 195, 36);
        tab.add(turn);

        JTextPane textPane_8 = new JTextPane();
        textPane_8.setBounds(780, 36, 76, 45);
        tab.add(textPane_8);

        JTextPane textPane_9 = new JTextPane();
        textPane_9.setBounds(938, 36, 123, 45);
        tab.add(textPane_9);


        JButton button_1 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
        button_1.setBorderPainted(false);
        button_1.setFocusPainted(false);
        button_1.setContentAreaFilled(false);
        button_1.setBounds(355, 209, 105, 54);
        getContentPane().add(button_1);


        JPanel Dialog = new JPanel();
        Dialog.setBounds(599, 165, 569, 430);
        getContentPane().add(Dialog);
        Dialog.setLayout(null);


        JButton city_btn_0 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_0.setFocusPainted(false);
        city_btn_0.setContentAreaFilled(false);
        city_btn_0.setBorderPainted(false);
        city_btn_0.setBounds(244, 315, 105, 54);
        getContentPane().add(city_btn_0);

        JButton city_btn_1 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_1.setFocusPainted(false);
        city_btn_1.setContentAreaFilled(false);
        city_btn_1.setBorderPainted(false);
        city_btn_1.setBounds(244, 209, 105, 54);
        getContentPane().add(city_btn_1);

        JButton city_btn_2 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_2.setFocusPainted(false);
        city_btn_2.setContentAreaFilled(false);
        city_btn_2.setBorderPainted(false);
        city_btn_2.setBounds(145, 268, 105, 54);
        getContentPane().add(city_btn_2);

        JButton city_btn_3 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_3.setFocusPainted(false);
        city_btn_3.setContentAreaFilled(false);
        city_btn_3.setBorderPainted(false);
        city_btn_3.setBounds(145, 370, 105, 54);
        getContentPane().add(city_btn_3);


        JButton city_btn_4 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_4.setFocusPainted(false);
        city_btn_4.setContentAreaFilled(false);
        city_btn_4.setBorderPainted(false);
        city_btn_4.setBounds(244, 431, 105, 54);
        getContentPane().add(city_btn_4);

        JButton city_btn_5 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        city_btn_5.setFocusPainted(false);
        city_btn_5.setContentAreaFilled(false);
        city_btn_5.setBorderPainted(false);
        city_btn_5.setBounds(355, 370, 105, 54);
        getContentPane().add(city_btn_5);

        JButton city_btn_6 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_6.setFocusPainted(false);
        city_btn_6.setContentAreaFilled(false);
        city_btn_6.setBorderPainted(false);
        city_btn_6.setBounds(355, 268, 105, 54);
        getContentPane().add(city_btn_6);

        JButton city_btn_7 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_7.setFocusPainted(false);
        city_btn_7.setContentAreaFilled(false);
        city_btn_7.setBorderPainted(false);
        city_btn_7.setBounds(399, 165, 105, 54);
        getContentPane().add(city_btn_7);


        JButton city_btn_8 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_8.setFocusPainted(false);
        city_btn_8.setContentAreaFilled(false);
        city_btn_8.setBorderPainted(false);
        city_btn_8.setBounds(114, 165, 105, 54);
        getContentPane().add(city_btn_8);


        JButton city_btn_9 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_9.setFocusPainted(false);
        city_btn_9.setContentAreaFilled(false);
        city_btn_9.setBorderPainted(false);
        city_btn_9.setBounds(14, 315, 105, 54);
        getContentPane().add(city_btn_9);


        JButton city_btn_10 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_10.setFocusPainted(false);
        city_btn_10.setContentAreaFilled(false);
        city_btn_10.setBorderPainted(false);
        city_btn_10.setBounds(114, 473, 105, 54);
        getContentPane().add(city_btn_10);

        JButton city_btn_11 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_11.setFocusPainted(false);
        city_btn_11.setContentAreaFilled(false);
        city_btn_11.setBorderPainted(false);
        city_btn_11.setBounds(399, 473, 105, 54);
        getContentPane().add(city_btn_11);

        JButton city_btn_12 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_12.setFocusPainted(false);
        city_btn_12.setContentAreaFilled(false);
        city_btn_12.setBorderPainted(false);
        city_btn_12.setBounds(501, 315, 105, 54);
        getContentPane().add(city_btn_12);


        JLabel player1_img = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player_img.png"));
        player1_img.setBounds(61, 84, 62, 18);
		add(player1_img);

        JLabel player1_name = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player1_name.setBounds(61, 151, 62, 18);
		add(player1_name);

        p_simplestat player1 = new p_simplestat();
        JPanel player1_temp = new JPanel();
        player1_temp.setBounds(738, 654, 444, 259);
        getContentPane().add(player1_temp);
        player1_temp.add(player1);

        p_simplestat player2 = new p_simplestat();
        JPanel player2_temp = new JPanel();
        player1_temp.setBounds(738, 654, 444, 259);
        getContentPane().add(player1_temp);
        player1_temp.add(player1);
    }

    public static void main(String[] args) {
        MainGame MainGame = new MainGame();
        MainGame.setVisible(true);
    }

    class p_simplestat extends JPanel {
        p_simplestat() {
            /*
             * 테스트 코드
             * test temp = new test(); JPanel temp1 = new JPanel();
             * temp1.setBounds(0, 183, 394, 741); getContentPane().add(temp1);
             * temp1.add(temp);
             */
            JPanel health_panel = new JPanel();
            JLabel health = new JLabel("체력");
            health.setPreferredSize(new Dimension(40, 30));
            JTextPane health_text = new JTextPane();
            health_text.setPreferredSize(new Dimension(200, 30));


            JPanel mental_panel = new JPanel();
            JLabel mental = new JLabel("정신력");
            mental.setPreferredSize(new Dimension(40, 30));
            JTextPane mental_text = new JTextPane();
            mental_text.setPreferredSize(new Dimension(200, 30));

            JPanel energy_panel = new JPanel();
            JLabel energy = new JLabel("행동치");
            energy.setPreferredSize(new Dimension(40, 30));
            JTextPane energy_text = new JTextPane();
            energy_text.setPreferredSize(new Dimension(200, 30));

            JPanel money_panel = new JPanel();
            JLabel money = new JLabel("money");
            money.setPreferredSize(new Dimension(40, 30));
            JTextArea money_text = new JTextArea();
            money_text.setPreferredSize(new Dimension(200, 30));

            health_panel.add(health);
            health_panel.add(health_text);
            add(health_panel);

            mental_panel.add(mental);
            mental_panel.add(mental_text);
            add(mental_panel);

            energy_panel.add(energy);
            energy_panel.add(energy_text);
            add(energy_panel);
            setLayout(new GridLayout(3, 2, 20, 0));
        }
    }
}
