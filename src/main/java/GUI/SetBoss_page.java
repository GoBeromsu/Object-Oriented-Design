package GUI;

import com.Boss;
import com.BossType;
import com.GameMaster;
import com.Mainmusic_thread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 새로 게임을 생성할 때 보스를 설정하는 페이지이다.
 * @author Beomsu Ko
 */
public class SetBoss_page extends JFrame {

    ImagePanel panel = new ImagePanel();
    Image boss_background = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/backgroundImage.jpg"))).getImage();

    SetBoss_page() throws IOException {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
                Mainmusic_thread.thread.stop();
            }
        });
        getContentPane().add(panel);
        panel.setLayout(null);
        setResizable(false);
        setBounds(0, 0, 1200, 960);

        JPanel movetab = new JPanel();

        JLabel help_text = new JLabel("Click the boss name you want");
        Font font = new Font("font", Font.ITALIC, 30);
        help_text.setFont(font);
        movetab.add(help_text);

        JButton prev = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/prev.png"))));


        movetab.setLayout(null);

        // startpage로 이동
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start_page prev = null;
                try {
                    prev = new Start_page();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                prev.setVisible(true);
                dispose();
            }
        });
        movetab.setBounds(0, 0, 1182, 186);
        help_text.setBounds(480, 32, 800, 70);
        prev.setBounds(78, 32, 180, 70);


        movetab.add(prev);
        panel.add(movetab);

        String azartoth_win = "강림시 패배";
        String nyarlathotep_win = "토큰 필요량 +3";
        String chuthulu_win = "전투 시 받는 데미지 +1";


        BossPanel Test1 = new BossPanel(BossType.AZATHOTH.getBoss_imgpath(), BossType.AZATHOTH, azartoth_win, "images/AZATOTH-NAME.PNG");
        BossPanel Test2 = new BossPanel(BossType.CHUTHULU.getBoss_imgpath(), BossType.CHUTHULU, chuthulu_win, "images/CTHULHU-NAME.PNG");
        BossPanel Test3 = new BossPanel(BossType.NYARLATHOTEP.getBoss_imgpath(), BossType.NYARLATHOTEP, nyarlathotep_win, "images/NYALA-NAME.PNG");

        JPanel boss1 = new JPanel();
        boss1.setBounds(0, 183, 394, 741);
        boss1.add(Test1);
        panel.add(boss1);

        JPanel boss2 = new JPanel();
        boss2.setBounds(394, 183, 394, 741);
        boss2.add(Test2);
        panel.add(boss2);

        JPanel boss3 = new JPanel();
        boss3.setBounds(788, 183, 394, 741);
        boss3.add(Test3);
        panel.add(boss3);
    }
    /**
     * information about boss
     */
    class BossPanel extends JPanel {

        public BossPanel(String img_path, BossType bosstype, String boss_win, String boss_name_imgpath) throws IOException {

            JLabel boss_name = new JLabel(new ImageIcon(ImageIO.read(SetBoss_page.class.getClassLoader().getResourceAsStream(boss_name_imgpath))));

            boss_name.setPreferredSize(new Dimension(170, 70));
            boss_name.setOpaque(false);

            setLayout(new BorderLayout());

            Image img_boss;
            try {
                img_boss = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(img_path));
            } catch (IOException e) {
                e.printStackTrace();
                img_boss = null;
            }
            Image temp = new ImageIcon(img_boss).getImage();
            Image temp_2 = temp.getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
            ImageIcon real = new ImageIcon(temp_2);

            JButton bossimg = new JButton(real);
            bossimg.setFocusPainted(false);
            bossimg.setContentAreaFilled(false);

            JLabel bosstxt = new JLabel(boss_win);
            bosstxt.setPreferredSize(new Dimension(150, 50));


            bosstxt.setHorizontalAlignment(JTextField.CENTER);

            bossimg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO : boss test code지우고 수정 bosstype과 연동
                    GameMaster.setBoss(
                            Boss
                                    .builder()
                                    .type(bosstype)
                                    .health(bosstype.getHealth())
                                    .damage(bosstype.getDamage())
                                    .requireVal(bosstype.getRequireVal())
                                    .build()
                    );
                    System.out.println(GameMaster.current_boss.getRequireVal());

                    SetStatus_page next = null;
                    try {
                        next = new SetStatus_page();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    next.setVisible(true);
                    dispose();
                }
            });

            add(bossimg, BorderLayout.CENTER);
            add(boss_name, BorderLayout.NORTH);
            add(bosstxt, BorderLayout.SOUTH);

        }

    }
    /**
     * To paint background
     */
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(boss_background, 0, 0, 1200, 960, this);
        }
    }
}
