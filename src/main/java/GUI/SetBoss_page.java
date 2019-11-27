package GUI;

import com.Boss;
import com.BossType;
import com.GameMaster;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 새로 게임을 생성할 때 보스를 설정하는 페이지이다.
 */
public class SetBoss_page extends JFrame {
    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();


    SetBoss_page() {

        setBounds(0, 0, 1200, 960);
        getContentPane().setLayout(null);

        JPanel movetab = new JPanel();
        JButton next = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\next.png"));
        JButton prev = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\prev.png"));


        movetab.setLayout(null);
        // setstatus페이지로 이동
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SetStatus_page next = new SetStatus_page();
                next.setVisible(true);
                dispose();
            }
        });
        // startpage로 이동
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start_page prev = new Start_page();
                prev.setVisible(true);
                dispose();
            }
        });
        movetab.setBounds(0, 0, 1182, 186);
        next.setBounds(935, 32, 180, 70);
        prev.setBounds(78, 32, 180, 70);

        getContentPane().add(movetab);
        movetab.add(next);
        movetab.add(prev);

        BossPanel Test1 = new BossPanel("src\\main\\java\\GUI\\imgaes\\azatoth.png", BossType.AZATHOTH);
        BossPanel Test2 = new BossPanel("src\\main\\java\\GUI\\imgaes\\azatoth.png", BossType.CHUTHULU);
        BossPanel Test3 = new BossPanel("src\\main\\java\\GUI\\imgaes\\azatoth.png", BossType.NYARLATHOTEP);

        JPanel boss1 = new JPanel();
        boss1.setBounds(0, 183, 394, 741);
        getContentPane().add(boss1);
        boss1.add(Test1);


        JPanel boss2 = new JPanel();
        boss2.setBounds(394, 183, 394, 741);
        getContentPane().add(boss2);
        boss2.add(Test2);

        JPanel boss3 = new JPanel();
        boss3.setBounds(788, 183, 394, 741);
        getContentPane().add(boss3);
        boss3.add(Test3);
    }

    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);

        }
    }

    public static void main(String[] args) {

        SetBoss_page frame = new SetBoss_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class BossPanel extends JPanel {

        public BossPanel(String img_path, BossType bosstype) {
            JButton bossbtn = new JButton(bosstype.getName());
            bossbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameMaster.setBoss(
                            Boss
                                    .builder()
                                    .type(bosstype)
                                    .health(100)
                                    .power(100)
                                    .build()
                    );
                    SetStatus_page next = new SetStatus_page();
                    next.setVisible(true);
                    dispose();
                }
            });
            setLayout(new BorderLayout());
            Image temp = new ImageIcon(img_path).getImage();
            Image temp_2 = temp.getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH);

            ImageIcon real = new ImageIcon(temp_2);

            JLabel bossimg = new JLabel(real);
            JTextArea bosstxt = new JTextArea();

            add(bossimg, BorderLayout.NORTH);
            add(bossbtn, BorderLayout.CENTER);
            add(bosstxt, BorderLayout.SOUTH);

        }

    }
}
