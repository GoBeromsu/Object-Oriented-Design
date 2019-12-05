package GUI;

import com.GameMaster;
import com.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.Fight_boss_controller.*;

/**
 * boss나 monster와의 전투를 나타내는 페이지이다.
 */

public class Fight_boss_page extends JFrame {
    public static MainGame_page.PlayerStatusPanel player1_status_panel;
    public static MainGame_page.PlayerStatusPanel player2_status_panel;
    public static JLabel boss_temphealth;
    public int turninboss = 0;

    public static ImageIcon star;

    static {
        try {
            star = new ImageIcon(ImageIO.read(Fight_boss_page.class.getClassLoader().getResourceAsStream("images/star.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JLabel boss_health_0 = new JLabel(star);
    public static JLabel boss_health_1 = new JLabel(star);
    public static JLabel boss_health_2 = new JLabel(star);
    public static JLabel boss_health_3 = new JLabel(star);
    public static JLabel boss_health_4 = new JLabel(star);
    public static JLabel boss_health_5 = new JLabel(star);
    public static JLabel boss_health_6 = new JLabel(star);
    public static JLabel boss_health_7 = new JLabel(star);
    public static JLabel boss_health_8 = new JLabel(star);
    public static JLabel boss_health_9 = new JLabel(star);
    public static JLabel boss_health_10 = new JLabel(star);
    public static JLabel boss_health[] = {boss_health_0, boss_health_1, boss_health_2, boss_health_3, boss_health_4,
            boss_health_5, boss_health_6, boss_health_7, boss_health_8, boss_health_9, boss_health_10};

    public static void main(String[] args) {
        Fight_boss_page frame = new Fight_boss_page();
        frame.setVisible(true);

    }


    public Fight_boss_page() {

        Mainmusic_thread.thread.close();
        Mainmusic_thread music_thread = new Mainmusic_thread(this.getClass().getClassLoader().getResourceAsStream("music/boss_fight.mp3"), true);
        music_thread.start();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 960);
        getContentPane().setLayout(null);


        JPanel BossHealthPanel = new JPanel();
        BossHealthPanel.setBounds(0, 0, 1182, 153);
        getContentPane().add(BossHealthPanel);
        BossHealthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        {
            for (int i = 0; i < 10; i++) {

                BossHealthPanel.add(boss_health[i]);
                boss_health[i].setVisible(true);
            }

        }


        //플레이어들의 스테이터스
        {

            ImageIcon player1_img = null;
            try {
                player1_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1-portrait.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image player1_tempimg = player1_img.getImage();
            Image player1_changedimg = player1_tempimg.getScaledInstance(240, 163, Image.SCALE_SMOOTH);
            JLabel lb_player1 = new JLabel(new ImageIcon(player1_changedimg));
            lb_player1.setBounds(41, 620, 240, 163);
            getContentPane().add(lb_player1);

            ImageIcon player1_name_img = null;
            try {
                player1_name_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1_name.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel player1_name = new JLabel(player1_name_img);
            player1_name.setBounds(41, 780, 240, 61);
            getContentPane().add(player1_name);

            player1_status_panel = new MainGame_page.PlayerStatusPanel(Player.getPlayer(0));
            player1_status_panel.setBounds(290, 670, 318, 225);
            getContentPane().add(player1_status_panel);

            ImageIcon player2_img = null;
            try {
                player2_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player2-portrait.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image player2_tempimg = player2_img.getImage();
            Image player2_changedimg = player2_tempimg.getScaledInstance(240, 163, Image.SCALE_SMOOTH);
            JLabel lb_player2_img = new JLabel(new ImageIcon(player2_changedimg));
            lb_player2_img.setBounds(650, 620, 240, 163);
            getContentPane().add(lb_player2_img);

            JLabel lb_player2_name = null;
            try {
                lb_player2_name = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player2_name.png"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            lb_player2_name.setBounds(650, 780, 240, 61);
            getContentPane().add(lb_player2_name);

            player2_status_panel = new MainGame_page.PlayerStatusPanel(Player.getPlayer(1));
            player2_status_panel.setBounds(864, 670, 318, 225);
            getContentPane().add(player2_status_panel);
        }

        Image img_boss;
        try {
            img_boss = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(GameMaster.current_boss.getType().getActive_path()));
        } catch (IOException e) {
            e.printStackTrace();
            img_boss = null;
        }
        JLabel boss_panel = new JLabel(new ImageIcon(img_boss));
        boss_panel.setBounds(75, 120, 1100, 480);
        getContentPane().add(boss_panel);

        JButton fight = new JButton("startfight");
        getContentPane().add(fight);
        fight.setBounds(120, 100, 200, 50);
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turninboss % 2 == 0) {
                    attackedBossByPlayer();
                    System.out.println(Player.getCurrentPlayer());
                    System.out.println("플레이어가 공격했음");
                    turninboss++;
                } else if (turninboss % 2 == 1) {
                    attackedPlayerByBoss();
                    System.out.println("boss 공격가 공격했음");
                    turninboss++;
                }
                checkWhoWin();
            }
        });


    }

    public static void show_stars() {
        for (int i = 10; i > GameMaster.current_boss.getHealth(); i--) {
            boss_health[i].setVisible(false);
        }

    }
}