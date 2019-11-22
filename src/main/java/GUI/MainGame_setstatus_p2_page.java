package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 게임을 진행하면서 바뀌는 플레이어의 현재 스테이터스와 아이템을 보여주는 페이지이다.
 */

public class MainGame_setstatus_p2_page extends JFrame {
    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/backgroundImage.jpg").getImage();

    MainGame_setstatus_p2_page() {
        getContentPane().setLayout(null);
        setBounds(0, 0, 1200, 960);

        JPanel movetab = new JPanel();
        JButton prev = new JButton("prev");

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainGamePage temp = new MainGamePage();
                temp.setVisible(true);
                dispose();
            }
        });


        getContentPane().add(movetab);
        movetab.setLayout(null);
        movetab.setBounds(0, 0, 1182, 146);
        prev.setBounds(40, 32, 180, 70);
        movetab.add(prev);

        JButton player1 = new JButton("player1");
        player1.setBounds(297, 40, 160, 54);

		player1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MainGame_setstatus_p1_page temp = new MainGame_setstatus_p1_page();
				temp.setVisible(true);
				dispose();
			}
		});

        movetab.add(player1);

        JButton player2 = new JButton("player2");
        player2.setBounds(494, 40, 144, 54);
        movetab.add(player2);

        JLabel lblMoney = new JLabel("money");
        lblMoney.setBounds(694, 58, 62, 18);
        movetab.add(lblMoney);

        JLabel lblToken = new JLabel("token");
        lblToken.setBounds(892, 58, 62, 18);
        movetab.add(lblToken);

        JTextPane money_tesxt = new JTextPane();
        money_tesxt.setBounds(770, 58, 98, 18);
        movetab.add(money_tesxt);

        JTextPane token_text = new JTextPane();
        token_text.setBounds(968, 58, 124, 24);
        movetab.add(token_text);

        JLabel status_power = new JLabel("\uD798");
        status_power.setBounds(546, 282, 116, 39);
        getContentPane().add(status_power);

        JTextPane power_text = new JTextPane();
        power_text.setBounds(622, 282, 164, 39);
        getContentPane().add(power_text);

        JLabel status_dex = new JLabel("\uBBFC\uCCA9");
        status_dex.setBounds(546, 365, 116, 39);
        getContentPane().add(status_dex);

        JTextPane dex_text = new JTextPane();
        dex_text.setBounds(622, 365, 164, 39);
        getContentPane().add(dex_text);

        JLabel status_intelligence = new JLabel("\uC9C0\uB2A5");
        status_intelligence.setBounds(546, 457, 116, 39);
        getContentPane().add(status_intelligence);

        JTextPane intelligence_text = new JTextPane();
        intelligence_text.setBounds(622, 457, 164, 39);
        getContentPane().add(intelligence_text);

        JLabel status_mental = new JLabel("\uC815\uC2E0\uB825");
        status_mental.setBounds(546, 544, 116, 39);
        getContentPane().add(status_mental);

        JTextPane mental_text = new JTextPane();
        mental_text.setBounds(622, 544, 164, 39);
        getContentPane().add(mental_text);

        JLabel status_health = new JLabel("\uCCB4\uB825");
        status_health.setBounds(870, 282, 116, 39);
        getContentPane().add(status_health);

        JTextPane health_text = new JTextPane();
        health_text.setBounds(946, 282, 164, 39);
        getContentPane().add(health_text);

        JLabel item = new JLabel("Item");
        item.setBounds(870, 365, 240, 39);
        getContentPane().add(item);

        JTextPane item_text = new JTextPane();
        item_text.setBounds(865, 410, 245, 173);
        getContentPane().add(item_text);

        JLabel player_name = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player_name.setBounds(113, 559, 365, 155);
        getContentPane().add(player_name);

        JLabel playerimg = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player.png"));
        playerimg.setBounds(120, 209, 358, 356);
        getContentPane().add(playerimg);

    }

    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);
        }
    }

    public static void main(String[] args) {

        MainGame_setstatus_p2_page frame = new MainGame_setstatus_p2_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
