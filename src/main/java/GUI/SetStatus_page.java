package GUI;

import com.GameMaster;
import com.MainGamePageController;
import com.Player;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 각각의 플레이어들의 초기 스탯 분배하는 페이지이다.
 */
public class SetStatus_page extends JFrame {

    int distributable_point = 20;
    JLabel lb_distributable_point = new JLabel("You can use  "+ Integer.toString(distributable_point)+"  Point");
    JPanel movetab = new JPanel();
    JButton next = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/next.png"))));
    JButton prev = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/prev.png"))));

    String player_imgpath = "images/player1-portrait.png";
    String player_name_imgpath = "images/player1_name.png";

    ImagePanel imagePanel = new ImagePanel();
    Image status_background = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/backgroundImage.jpg"))).getImage();


    Image status_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/SELECTOR.PNG"))).getImage();

    SetStatus_page() throws IOException {
        getContentPane().add(imagePanel);
        imagePanel.setLayout(null);
        //player 1 , 2  이름 및 이미지 변환
        if (Player.getCurrentPlayer() == Player.getPlayer(1)) {
            player_imgpath = "images/player2-portrait.png";
            player_name_imgpath = "images/player2_name.png";
        }
        setResizable(false);
        setBounds(0, 0, 1200, 960);

        movetab.setBackground(Color.white);

        imagePanel.add(movetab);
        movetab.setLayout(null);
        movetab.setBounds(0, 0, 1182, 146);


        Font distrfont = new Font("distrfont",Font.PLAIN,30);
        lb_distributable_point.setFont(distrfont);


        next.setBounds(935, 32, 180, 70);
        prev.setBounds(78, 32, 180, 70);
        lb_distributable_point.setBounds(450, 32, 400, 70);

        movetab.add(next);
        movetab.add(lb_distributable_point);
        movetab.add(prev);

        JLabel player_name = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(player_name_imgpath))));
        player_name.setBounds(121, 566, 365, 155);
        imagePanel.add(player_name);

        JLabel player_img = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(player_imgpath))));
        player_img.setBounds(128, 216, 358, 356);
        imagePanel.add(player_img);

        perstatus_set status_power = new perstatus_set("images/POWER.PNG");
        statusImagePanel perstatus = new statusImagePanel();

        perstatus.setOpaque(false);
        perstatus.setBounds(592, 206, 590, 82);
        imagePanel.add(perstatus);
        perstatus.add(status_power);

        perstatus_set status_dex = new perstatus_set("images/DEXTERITY.PNG");
        statusImagePanel perstatus_1 = new statusImagePanel();

        perstatus_1.setOpaque(false);
        perstatus_1.setBounds(592, 477, 590, 82);
        imagePanel.add(perstatus_1);
        perstatus_1.add(status_dex);

        perstatus_set status_intelligence = new perstatus_set("images/INTEL.PNG");
        statusImagePanel perstatus_2 = new statusImagePanel();

        perstatus_2.setOpaque(false);
        perstatus_2.setBounds(592, 345, 590, 82);
        imagePanel.add(perstatus_2);
        perstatus_2.add(status_intelligence);

        perstatus_set status_mental = new perstatus_set("images/MENTAL.PNG");
        statusImagePanel perstatus_3 = new statusImagePanel();

        perstatus_3.setOpaque(false);
        perstatus_3.setBounds(592, 602, 590, 82);
        imagePanel.add(perstatus_3);
        perstatus_3.add(status_mental);

        perstatus_set statuts_health = new perstatus_set("images/HEALTH.PNG");
        statusImagePanel perstatus_4 = new statusImagePanel();

        perstatus_4.setOpaque(false);
        perstatus_4.setBounds(592, 728, 590, 82);
        imagePanel.add(perstatus_4);
        perstatus_4.add(statuts_health);



        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] total_value = {
                        status_power.value,
                        status_dex.value,
                        status_intelligence.value,
                        status_mental.value,
                        statuts_health.value
                };
                GameMaster.setInitializePlayerStats(total_value);
                Player.toggleCurrentPlayer();

                if (doesNextPlayerStatusSetted()) {
                    MainGamePageController maingame_page_controller = null;
                    try {
                        maingame_page_controller = new MainGamePageController();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    maingame_page_controller.maingame_page.setVisible(true);
                    dispose();
                } else {
                    JFrame nextPage = null;
                    try {
                        nextPage = new SetStatus_page();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    nextPage.setVisible(true);
                    dispose();
                }
            }
        });

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetBoss_page prev = null;
                try {
                    prev = new SetBoss_page();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                prev.setVisible(true);
                dispose();
            }
        });
    }

    private boolean doesNextPlayerStatusSetted() {
        return Player.getCurrentPlayer().getPower() != null;
    }

    @Getter
    @Setter
    class perstatus_set extends JPanel {
        private int value = 0;

        perstatus_set(String path) throws IOException {
            Font font = new Font("font",Font.ITALIC,25);

            JLabel status_name = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path))));
            JLabel status_value = new JLabel(Integer.toString(value));
            status_value.setFont(font);
            status_value.setForeground(Color.white);

            JButton plus = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/plus-for-status.png"))));
            plus.setOpaque(false);
            plus.setFocusPainted(false);
            plus.setContentAreaFilled(false);
            plus.setBorderPainted(false);

            JButton minus = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/minus-for-status.png"))));
            minus.setOpaque(false);
            minus.setFocusPainted(false);
            minus.setContentAreaFilled(false);
            minus.setBorderPainted(false);



            Image dialog = new ImageIcon("images/plus-for-status.png").getImage();

            plus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (value >= 0 && distributable_point >= 1) {
                        distributable_point--;
                        value++;
                    }
                    status_value.setText(Integer.toString(value));
                    lb_distributable_point.setText("You can use  "+ Integer.toString(distributable_point)+"  Point");
                }
            });
            minus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (value >= 1) {
                        distributable_point++;
                        value--;
                    }
                    status_value.setText(Integer.toString(value));

                    lb_distributable_point.setText("You can use  "+ Integer.toString(distributable_point)+"  Point");
                }
            });
            add(status_name);
            add(status_value);
            add(plus);
            add(minus);
            setOpaque(false);
        }

    }
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(status_background, 0, 0, 1200, 960, this);
        }
    }
    class statusImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(status_img, 0, 0, 590, 80, this);
        }
    }
}
