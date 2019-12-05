package GUI;

import com.ItemType;
import com.MainGamePageController;
import com.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * 게임을 진행하면서 바뀌는 플레이어의 현재 스테이터스와 아이템을 보여주는 페이지이다.
 */

public class MainGamePlayerStatusDetail_page extends JFrame {

    Image img;

    {
        try {
            img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/backgroundImage.jpg"))).getImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static JLabel player_name;
    static JLabel playerimg;


    static ImageIcon player1_nameimg;

    static {
        try {
            player1_nameimg = new ImageIcon(ImageIO.read(MainGamePageController.class.getClassLoader().getResourceAsStream("images/player1_name.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ImageIcon player1_potraitimg;

    static {
        try {
            player1_potraitimg = new ImageIcon(ImageIO.read(MainGamePageController.class.getClassLoader().getResourceAsStream("images/player1-portrait.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ImageIcon player2_nameimg;

    static {
        try {
            player2_nameimg = new ImageIcon(ImageIO.read(MainGamePageController.class.getClassLoader().getResourceAsStream("images/player2_name.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ImageIcon player2_potraitimg;

    static {
        try {
            player2_potraitimg = new ImageIcon(ImageIO.read(MainGamePageController.class.getClassLoader().getResourceAsStream("images/player2-portrait.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    MainGamePlayerStatusDetail_page(Player player) {
        ImagePanel panel = new ImagePanel();
        getContentPane().add(panel);

        Font statusfont = new Font("font", Font.BOLD, 20);


        panel.setLayout(null);
        {

            setBounds(0, 0, 1200, 960);

            JPanel movetab = new JPanel();
            JButton prev = new JButton("prev");

            prev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            panel.add(movetab);
            movetab.setLayout(null);
            movetab.setBounds(0, 0, 1182, 146);
            prev.setBounds(40, 32, 180, 70);
            movetab.add(prev);

            JButton player1 = new JButton("player1");
            player1.setBounds(297, 40, 160, 54);
            movetab.add(player1);
            player1.addActionListener(new BtnPlayerSwapAction(player, 0));

            JButton player2 = new JButton("player2");
            player2.setBounds(494, 40, 144, 54);
            movetab.add(player2);

            player2.addActionListener(new BtnPlayerSwapAction(player, 1));

            JLabel lblMoney = new JLabel("money");
            lblMoney.setBounds(694, 58, 62, 18);
            movetab.add(lblMoney);

            JTextPane money_text = new JTextPane();
            money_text.setBounds(770, 58, 98, 18);
            money_text.setEditable(false);
            money_text.setText(Integer.toString(player.getMoney()));
            movetab.add(money_text);

            JLabel lblPos = new JLabel("위치");
            lblPos.setBounds(892, 58, 62, 18);
            movetab.add(lblPos);

            JTextPane pos_text = new JTextPane();
            pos_text.setBounds(968, 58, 124, 24);
            pos_text.setEditable(false);
            pos_text.setText(player.getPos().getName());
            movetab.add(pos_text);

            JLabel status_power = new JLabel("힘");
            status_power.setForeground(Color.white);
            status_power.setFont(statusfont);
            status_power.setBounds(546, 282, 116, 39);
            panel.add(status_power);

            JTextPane power_text = new JTextPane();
            power_text.setBounds(622, 282, 164, 39);
            power_text.setEditable(false);
            power_text.setText(Integer.toString(player.getPower()));
            panel.add(power_text);

            JLabel status_dex = new JLabel("민첩성");
            status_dex.setFont(statusfont);
            status_dex.setForeground(Color.white);
            status_dex.setBounds(546, 365, 116, 39);
            panel.add(status_dex);

            JTextPane dex_text = new JTextPane();
            dex_text.setBounds(622, 365, 164, 39);
            dex_text.setEditable(false);
            dex_text.setText(Integer.toString(player.getDexterity()));
            panel.add(dex_text);

            JLabel status_intelligence = new JLabel("지능");
            status_intelligence.setFont(statusfont);
            status_intelligence.setForeground(Color.white);
            status_intelligence.setBounds(546, 457, 116, 39);
            panel.add(status_intelligence);

            JTextPane intelligence_text = new JTextPane();
            intelligence_text.setBounds(622, 457, 164, 39);
            intelligence_text.setEditable(false);
            intelligence_text.setText(Integer.toString(player.getIntelligence()));
            panel.add(intelligence_text);

            JLabel status_mental = new JLabel("정신력");
            status_mental.setFont(statusfont);
            status_mental.setForeground(Color.white);
            status_mental.setBounds(546, 544, 116, 39);
            panel.add(status_mental);

            JTextPane mental_text = new JTextPane();
            mental_text.setBounds(622, 544, 164, 39);
            mental_text.setEditable(false);
            mental_text.setText(Integer.toString(player.getMental()));
            panel.add(mental_text);

            JLabel status_health = new JLabel("체력");
            status_health.setFont(statusfont);
            status_health.setForeground(Color.white);
            status_health.setBounds(870, 282, 116, 39);
            panel.add(status_health);

            JTextPane health_text = new JTextPane();
            health_text.setBounds(946, 282, 164, 39);
            health_text.setEditable(false);
            health_text.setText(Integer.toString(player.getHealth()));
            panel.add(health_text);

            JLabel item = new JLabel("Item");
            item.setFont(statusfont);
            item.setForeground(Color.white);
            item.setBounds(870, 365, 240, 39);
            panel.add(item);

            JTextPane item_text = new JTextPane();
            item_text.setBounds(865, 410, 245, 173);
            item_text.setEditable(false);
            ArrayList<ItemType> items = player.getItems();
            StringBuilder item_sb = new StringBuilder();
            for (ItemType cur_item : items) {
                item_sb.append(cur_item.getName() + "\n");
            }
            item_text.setText(item_sb.toString());
            panel.add(item_text);

        }
        // 이미지 패스 분기나누기

        try {
            player_name = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1_name.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        player_name.setBounds(113, 559, 365, 155);
        panel.add(player_name);

        try {
            playerimg = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1-portrait.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playerimg.setBounds(120, 209, 358, 356);
        panel.add(playerimg);

        panel.setVisible(true);
    }

    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);
        }
    }

    class BtnPlayerSwapAction implements ActionListener {
        Player cur_player;
        final int PLAYER_IDX;

        BtnPlayerSwapAction(Player cur_player, int idx) {
            this.cur_player = cur_player;
            PLAYER_IDX = idx;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Player player_to_show = Player.getPlayer(PLAYER_IDX);
            if (cur_player == player_to_show)
                return;

            MainGamePlayerStatusDetail_page temp = new MainGamePlayerStatusDetail_page(player_to_show);
            temp.setVisible(true);
            show_player(player_to_show);
            dispose();
        }
    }

    public static void show_player(Player player) {

        if (player == Player.getPlayer(0)) {
            player_name.setIcon(player1_nameimg);
            playerimg.setIcon(player1_potraitimg);

        } else {
            player_name.setIcon(player2_nameimg);
            playerimg.setIcon(player2_potraitimg);
        }
    }

    public static void main(String[] args) {
        MainGamePlayerStatusDetail_page frame = new MainGamePlayerStatusDetail_page(Player.getPlayer(0));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
