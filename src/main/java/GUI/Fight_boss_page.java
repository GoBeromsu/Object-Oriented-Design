package GUI;

import com.GameMaster;
import com.Mainmusic_thread;
import com.Player;
import com.google.common.io.ByteStreams;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;

import static com.Fight_boss_controller.*;

/**
 * boss와의 전투를 나타내는 페이지이다.
 * @author Beomsu Ko
 */

public class Fight_boss_page extends JFrame {
    public static MainGame_page.PlayerStatusPanel player1_status_panel;
    public static MainGame_page.PlayerStatusPanel player2_status_panel;
    public JLabel lblfight = new JLabel("");
    public static boolean boss_result = false;
    public int turninboss = 0;

    public int count = 0;
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

    public static void main(String[] args) throws IOException {
        Fight_boss_page frame = new Fight_boss_page();
        frame.setVisible(true);

    }


    public Fight_boss_page() throws IOException {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
                Mainmusic_thread.thread.stop();
            }
        });
        getContentPane().setBackground(Color.BLACK);
        lblfight.setForeground(Color.white);
        getContentPane().setBackground(Color.BLACK);
        Mainmusic_thread.thread.close();
        Mainmusic_thread music_thread = new Mainmusic_thread(this.getClass().getClassLoader().getResourceAsStream("music/boss_fight.mp3"), true);
        music_thread.start();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 960);
        getContentPane().setLayout(null);


        JPanel BossHealthPanel = new JPanel();
        BossHealthPanel.setBackground(Color.BLACK);
        BossHealthPanel.setBounds(0, 0, 1182, 153);
        getContentPane().add(BossHealthPanel);
        BossHealthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        {
            for (int i = 0; i < 10; i++) {

                BossHealthPanel.add(boss_health[i]);
                boss_health[i].setVisible(true);
            }

        }

        getContentPane().add(lblfight);
        lblfight.setVisible(true);
        lblfight.setBounds(20, 300, 600, 100);

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
            player1_status_panel.setBackground(Color.BLACK);
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
            player2_status_panel.setBackground(Color.BLACK);
            getContentPane().add(player2_status_panel);
        }

        class ImagePanel extends JPanel{
            Image img_boss;
            ImagePanel(InputStream is){
                try {
                    img_boss = Toolkit.getDefaultToolkit().createImage(ByteStreams.toByteArray(is));
                    MediaTracker mt = new MediaTracker(this);
                    mt.addImage(img_boss, 0);
                    mt.waitForAll();

                } catch (Exception e) {
                    e.printStackTrace();
                    img_boss = null;
                }

            }
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img_boss, 0, 0, this);
            }
        }

        ImagePanel boss_panel = new ImagePanel(this.getClass().getClassLoader().getResourceAsStream(GameMaster.current_boss.getType().getActive_path()));
        boss_panel.setBackground(Color.BLACK);
        boss_panel.setBounds(400, 120, 1200, 480);
        getContentPane().add(boss_panel);


        Image fight_btn = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/fight_start.png"));
        fight_btn.getScaledInstance(300, 300, Image.SCALE_SMOOTH);


        JButton fight = new JButton(new ImageIcon(fight_btn));
        getContentPane().add(fight);
        fight.setForeground(Color.white);
        fight.setBounds(50, 200, 300, 300);
        fight.setFocusPainted(false);
        fight.setContentAreaFilled(false);
        fight.setBorderPainted(false);


        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boss_result == false) {
                    if (turninboss % 2 == 0) {
                        try {
                            attackedBossByPlayer();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        turninboss++;
                    } else if (turninboss % 2 == 1) {
                        try {
                            attackedPlayerByBoss();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        turninboss++;
                    }
                }
                else{
                    if (lblfight.getText() == "플레이어 패배 -----> 클릭해주세요    <-------" || lblfight.getText() == "플레이어 승리 -----> 클릭해주세요    <-------") {
                        checkWhoWin();
                        return;
                    }
                }
                if (Player.getPlayer(0).getHealth() < 1 && Player.getPlayer(1).getHealth() < 1) {
                    fight.setIcon(null);
                    fight.setForeground(Color.white);
                    lblfight.setText("플레이어 패배 -----> 클릭해주세요    <-------");
                    boss_result = true;

                    return;

                } else if (GameMaster.current_boss.getHealth() < 1) {
                    fight.setIcon(null);
                    fight.setForeground(Color.white);
                    lblfight.setText("플레이어 승리 -----> 클릭해주세요    <-------");
                    boss_result = true;
                    return;
                }


            }


        });


    }

    /**
     * boss의 체력을 star로 바꿔준다.
     */
    public static void show_stars() {
        for (int i = 10; i > GameMaster.current_boss.getHealth(); i--) {
            boss_health[i].setVisible(false);
        }

    }
}