package GUI;
import com.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Dialog 창, map 등, 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 * @author Se-Ok Jeon Beomsu Ko
 */

@Getter
@Setter
public class MainGame_page extends JFrame {
    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/backgroundImage.jpg"))).getImage();

    DialogPanelController dialog_panel_controller;
    Image img_MAIN  = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/backgroundImage.jpg"))).getImage();
    //몬스터랑 포탈 출력가능하게 만들기
    MainGameTabPanel tab;
    ImageIcon city_img_icon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/stage.png")));
    JButton city_btn_array[];
    ImageIcon reddot_img_icon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/reddot.png")));
    JButton btn_reddot_array[];
    ImageIcon player1_Icon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1_img.png")));
    JLabel lb_player1_array[];
    ImageIcon player2_Icon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player2_img.png")));
    JLabel lb_player2_array[];

    JLabel lb_player1;
    JLabel player1_name;
    PlayerStatusPanel player1_status_panel;
    JLabel lb_player2_img;
    JLabel lb_player2_name;
    PlayerStatusPanel player2_status_panel;

    ImageIcon portal_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/portal.png")));
    JLabel portal_img_0 = new JLabel(portal_img);
    JLabel portal_img_1 = new JLabel(portal_img);
    JLabel portal_img_2 = new JLabel(portal_img);
    JLabel portal_img_3 = new JLabel(portal_img);
    JLabel portal_img_4 = new JLabel(portal_img);
    JLabel portal_img_5 = new JLabel(portal_img);
    JLabel portal_img_6 = new JLabel(portal_img);
    JLabel portal_img_7 = new JLabel(portal_img);
    JLabel portal_img_8 = new JLabel(portal_img);
    JLabel portal_img_9 = new JLabel(portal_img);
    JLabel portal_img_10 = new JLabel(portal_img);
    JLabel portal_img_11 = new JLabel(portal_img);
    JLabel portal_img_12 = new JLabel(portal_img);
    JLabel portal_array[] = {portal_img_0, portal_img_1, portal_img_2, portal_img_3, portal_img_4, portal_img_5,
            portal_img_6, portal_img_7, portal_img_8, portal_img_9, portal_img_10, portal_img_11, portal_img_12};

    JLabel monster_img_0 = new JLabel("");
    JLabel monster_img_1 = new JLabel("");
    JLabel monster_img_2 = new JLabel("");
    JLabel monster_img_3 = new JLabel("");
    JLabel monster_img_4 = new JLabel("");
    JLabel monster_img_5 = new JLabel("");
    JLabel monster_img_6 = new JLabel("");
    JLabel monster_img_7 = new JLabel("");
    JLabel monster_img_8 = new JLabel("");
    JLabel monster_img_9 = new JLabel("");
    JLabel monster_img_10 = new JLabel("");
    JLabel monster_img_11 = new JLabel("");
    JLabel monster_img_12 = new JLabel("");
    JLabel monster_array[] = {monster_img_0, monster_img_1, monster_img_2, monster_img_3, monster_img_4, monster_img_5,
            monster_img_6, monster_img_7, monster_img_8, monster_img_9, monster_img_10, monster_img_11, monster_img_12};


    @Getter
    @Setter
    public class MainGameTabPanel extends JPanel {
        Font tabFont = new Font("tabfont",Font.PLAIN,20);

        JButton status = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/STATUS.PNG"))));

        JLabel token = new JLabel("token");

        JTextPane token_text = new JTextPane();
        JLabel turn = new JLabel("Turn");
        JTextPane turn_text = new JTextPane();

        MainGameTabPanel() throws IOException {
            status.setBounds(126, 36, 173, 53);
            status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final int FIRST_PLAYER_IDX = 0;
                    MainGamePlayerStatusDetail_page temp = null;
                    try {
                        temp = new MainGamePlayerStatusDetail_page(Player.getPlayer(FIRST_PLAYER_IDX));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    temp.setVisible(true);
                }
            });

            token.setFont(tabFont);
            turn.setFont(tabFont);

            token.setBounds(692, 40, 160, 45);
            token_text.setBounds(780, 40, 76, 30);
            token_text.setEditable(false);
            token_text.setText(Integer.toString(GameMaster.token));
            turn.setBounds(866, 40, 195, 36);
            turn_text.setBounds(938, 40, 123, 30);
            turn_text.setEditable(false);
            turn_text.setText(Integer.toString(GameMaster.turn));

            this.add(status);
            this.add(token);
            this.add(token_text);
            this.add(turn);
            this.add(turn_text);
        }

    }

    @Getter
    @Setter
    public static class PlayerStatusPanel extends JPanel {
        @Getter
        @Setter

        public class Status_Components extends JPanel {
            JLabel lb_attribute_name;

            JTextPane attribute_textpane;
            Image dialog;

            {
                try {
                    dialog = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/DIALOG-PANEL.PNG"))).getImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Status_Components(Player player, Dimension player_status_dimension, String attribute_name) {

                Font lb_attributfont = new Font("attributfont",Font.BOLD,20);

                lb_attribute_name = new JLabel(attribute_name);

                lb_attribute_name.setFont(lb_attributfont);

                lb_attribute_name.setForeground(Color.white);
                lb_attribute_name.setPreferredSize(player_status_dimension);

                attribute_textpane = new JTextPane();
                String text_data = null;

                switch (attribute_name) {
                    case "체력":
                        text_data = Integer.toString(player.getHealth());
                        break;
                    case "힘":
                        text_data = Integer.toString(player.getPower());
                        break;
                    case "정신력":
                        text_data = Integer.toString(player.getMental());
                        break;
                    case "행동치":
                        text_data = Integer.toString(player.getEnergy());
                        break;
                }
                attribute_textpane.setText(text_data);
                attribute_textpane.setEditable(false);
                attribute_textpane.setPreferredSize(player_status_dimension);

                this.add(lb_attribute_name);
                this.add(attribute_textpane);
                setOpaque(false);
            }
        }
        Status_Components[] status_details;
        PlayerStatusPanel(Player player) {
            Dimension player_status_dimension = new Dimension(70, 30);
            status_details = new Status_Components[4];
            for (StatusType status_type : StatusType.values()) {
                status_details[status_type.ordinal()] = new Status_Components(player, player_status_dimension, status_type.getName());
                this.add(status_details[status_type.ordinal()]);
            }
            setLayout(new GridLayout(4, 2, 20, 0));

        }

    }

    public MainGame_page() throws IOException {
        // 상단바
        {
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
            setBounds(100, 100, 1200, 960);


            tab = new MainGameTabPanel();
            tab.setBounds(0, 0, 1182, 140);
            tab.setLayout(null);
            tab.setOpaque(false);
            panel.add(tab);

            dialog_panel_controller = new DialogPanelController();
            JPanel dialog_panel = dialog_panel_controller.dialog_panel;
            dialog_panel.setBounds(599, 165, 569, 430);
            dialog_panel.setLayout(null);
            dialog_panel.setOpaque(false);
            panel.add(dialog_panel);
        }
        // red dot 버튼
        {
            btn_reddot_array = new JButton[13];
            for (int i = 0; i < 13; i++) {
                btn_reddot_array[i] = new JButton(reddot_img_icon);
                btn_reddot_array[i].setVisible(false);
                btn_reddot_array[i].setFocusPainted(false);
                btn_reddot_array[i].setContentAreaFilled(false);
                btn_reddot_array[i].setBorderPainted(false);
                panel.add(btn_reddot_array[i]);
            }
            btn_reddot_array[0].setBounds(244, 315, 105, 54);
            btn_reddot_array[1].setBounds(244, 209, 105, 54);
            btn_reddot_array[2].setBounds(145, 268, 105, 54);
            btn_reddot_array[3].setBounds(145, 370, 105, 54);
            btn_reddot_array[4].setBounds(244, 431, 105, 54);
            btn_reddot_array[5].setBounds(355, 370, 105, 54);
            btn_reddot_array[6].setBounds(355, 268, 105, 54);
            btn_reddot_array[7].setBounds(399, 165, 105, 54);
            btn_reddot_array[8].setBounds(114, 165, 105, 54);
            btn_reddot_array[9].setBounds(14, 315, 105, 54);
            btn_reddot_array[10].setBounds(114, 473, 105, 54);
            btn_reddot_array[11].setBounds(399, 473, 105, 54);
            btn_reddot_array[12].setBounds(501, 315, 105, 54);
        }

        // 몬스터 이미지
        {
            for (JLabel monster_img : monster_array) {
                monster_img.setVisible(false);
                panel.add(monster_img);
            }
            new monster_imglocation(monster_array);
        }
        // 포탈 이미지
        {
            for (JLabel portal_img : portal_array) {
                portal_img.setVisible(false);
                panel.add(portal_img);
            }
            new portal_imglocation(portal_array);
        }
        // player1 이미지
        {
            lb_player1_array = new JLabel[13];
            for (int i = 0; i < 13; i++) {
                lb_player1_array[i] = new JLabel(player1_Icon);
                panel.add(lb_player1_array[i]);
            }
            new player1_imglocation(lb_player1_array);

        }
        // player2 이미지
        {
            lb_player2_array = new JLabel[13];
            for (int i = 0; i < 13; i++) {
                lb_player2_array[i] = new JLabel(player2_Icon);
                panel.add(lb_player2_array[i]);
            }
            new player2_imglocation(lb_player2_array);

        }
        // 타일 버튼
        {
            city_btn_array = new JButton[13];
            for (int i = 0; i < 13; i++) {
                city_btn_array[i] = new JButton(city_img_icon);
                city_btn_array[i].setVisible(true);
                city_btn_array[i].setFocusPainted(false);
                city_btn_array[i].setContentAreaFilled(false);
                city_btn_array[i].setBorderPainted(false);
                panel.add(city_btn_array[i]);
            }
            try {
                city_btn_array[TileType.HOSPITAL.ordinal()] = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/hospital.png"))));
                city_btn_array[TileType.HOSPITAL.ordinal()].setFocusPainted(false);
                city_btn_array[TileType.HOSPITAL.ordinal()].setContentAreaFilled(false);
                city_btn_array[TileType.HOSPITAL.ordinal()].setBorderPainted(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(city_btn_array[TileType.HOSPITAL.ordinal()]);
            try {
                city_btn_array[TileType.STORE.ordinal()] = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/store.png"))));
                city_btn_array[TileType.STORE.ordinal()].setFocusPainted(false);
                city_btn_array[TileType.STORE.ordinal()].setContentAreaFilled(false);
                city_btn_array[TileType.STORE.ordinal()].setBorderPainted(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(city_btn_array[TileType.STORE.ordinal()]);
            try {
                city_btn_array[TileType.MENTAL_HOSPITAL.ordinal()] = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/mospital.png"))));
                city_btn_array[TileType.MENTAL_HOSPITAL.ordinal()].setFocusPainted(false);
                city_btn_array[TileType.MENTAL_HOSPITAL.ordinal()].setContentAreaFilled(false);
                city_btn_array[TileType.MENTAL_HOSPITAL.ordinal()].setBorderPainted(false);

            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(city_btn_array[TileType.MENTAL_HOSPITAL.ordinal()]);
            new city_btn_imglocation(city_btn_array);
        }
        // 플레이어들의 스탯 요약
        {


            ImageIcon player1_img = null;
            try {
                player1_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1-portrait.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image player1_tempimg = player1_img.getImage();
            Image player1_changedimg = player1_tempimg.getScaledInstance(240,163,Image.SCALE_SMOOTH);
            lb_player1 = new JLabel(new ImageIcon(player1_changedimg));
            lb_player1.setBounds(41, 620, 240, 163);
            panel.add(lb_player1);

            ImageIcon player1_name_img = null;
            try {
                player1_name_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player1_name.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            player1_name = new JLabel(player1_name_img);
            player1_name.setBounds(41, 780, 240, 61);
            panel.add(player1_name);

            player1_status_panel = new PlayerStatusPanel(Player.getPlayer(0));
            player1_status_panel.setBounds(200, 620, 318, 225);
            player1_status_panel.setOpaque(false);
            panel.add(player1_status_panel);

            ImageIcon player2_img = null;
            try {
                player2_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player2-portrait.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image player2_tempimg = player2_img.getImage();
            Image player2_changedimg = player2_tempimg.getScaledInstance(240,163,Image.SCALE_SMOOTH);
            lb_player2_img = new JLabel(new ImageIcon(player2_changedimg));
            lb_player2_img.setBounds(650, 620, 240, 163);
            panel.add(lb_player2_img);

            try {
                lb_player2_name = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/player2_name.png"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            lb_player2_name.setBounds(650, 780, 240, 61);

            panel.add(lb_player2_name);

            player2_status_panel = new PlayerStatusPanel(Player.getPlayer(1));
            player2_status_panel.setBounds(820, 620, 318, 225);
            player2_status_panel.setOpaque(false);
            panel.add(player2_status_panel);
        }
    }

    class monster_imglocation extends JLabel {
        monster_imglocation(JLabel[] monster_array) {
            for (JLabel monster_img : monster_array) {
                monster_img.setVisible(false);
            }

            monster_array[0].setBounds(270, 315, 40, 50);
            monster_array[1].setBounds(270, 209, 40, 50);
            monster_array[2].setBounds(170, 268, 40, 50);
            monster_array[3].setBounds(170, 370, 40, 50);
            monster_array[4].setBounds(269, 431, 40, 50);
            monster_array[5].setBounds(380, 370, 40, 50);
            monster_array[6].setBounds(380, 268, 40, 50);
            monster_array[7].setBounds(424, 165, 40, 50);
            monster_array[8].setBounds(139, 165, 40, 50);
            monster_array[9].setBounds(39, 315, 40, 50);
            monster_array[10].setBounds(139, 473, 40, 50);
            monster_array[11].setBounds(425, 473, 80, 54);
            monster_array[12].setBounds(530, 315, 80, 54);

        }
    }

    class portal_imglocation extends JLabel {
        portal_imglocation(JLabel[] portal_array) {
            portal_array[0].setBounds(284, 315, 40, 50);
            portal_array[1].setBounds(284, 209, 40, 50);
            portal_array[2].setBounds(185, 268, 40, 50);
            portal_array[3].setBounds(185, 370, 40, 50);
            portal_array[4].setBounds(284, 431, 40, 50);
            portal_array[5].setBounds(395, 370, 40, 50);
            portal_array[6].setBounds(395, 268, 40, 50);
            portal_array[7].setBounds(440, 165, 40, 50);
            portal_array[8].setBounds(154, 165, 40, 50);
            portal_array[9].setBounds(57, 318, 40, 50);
            portal_array[10].setBounds(154, 473, 40, 50);
            portal_array[11].setBounds(439, 473, 40, 50);
            portal_array[12].setBounds(541, 315, 40, 50);
        }
    }

    class player1_imglocation extends JLabel {
        player1_imglocation(JLabel[] lb_player1_array) {
            lb_player1_array[0].setBounds(284, 315, 40, 50);
            lb_player1_array[1].setBounds(284, 209, 40, 50);
            lb_player1_array[2].setBounds(185, 268, 40, 50);
            lb_player1_array[3].setBounds(185, 370, 40, 50);
            lb_player1_array[4].setBounds(284, 431, 40, 50);
            lb_player1_array[5].setBounds(395, 370, 40, 50);
            lb_player1_array[6].setBounds(395, 268, 40, 50);
            lb_player1_array[7].setBounds(440, 165, 40, 50);
            lb_player1_array[8].setBounds(154, 165, 40, 50);
            lb_player1_array[9].setBounds(57, 318, 40, 50);
            lb_player1_array[10].setBounds(154, 473, 40, 50);
            lb_player1_array[11].setBounds(439, 473, 40, 50);
            lb_player1_array[12].setBounds(541, 315, 40, 50);

        }
    }

    class player2_imglocation extends JLabel {
        player2_imglocation(JLabel[] lb_player2_array) {
            lb_player2_array[0].setBounds(264, 315, 40, 50);
            lb_player2_array[1].setBounds(264, 209, 40, 50);
            lb_player2_array[2].setBounds(165, 268, 40, 50);
            lb_player2_array[3].setBounds(165, 370, 40, 50);
            lb_player2_array[4].setBounds(264, 431, 40, 50);
            lb_player2_array[5].setBounds(375, 370, 40, 50);
            lb_player2_array[6].setBounds(375, 268, 40, 50);
            lb_player2_array[7].setBounds(419, 165, 40, 50);
            lb_player2_array[8].setBounds(134, 165, 40, 50);
            lb_player2_array[9].setBounds(34, 315, 40, 50);
            lb_player2_array[10].setBounds(134, 473, 40, 50);
            lb_player2_array[11].setBounds(400, 473, 80, 54);
            lb_player2_array[12].setBounds(502, 315, 80, 54);
        }
    }

    class city_btn_imglocation extends JButton {
        city_btn_imglocation(JButton[] city_btn_array) {
            city_btn_array[0].setBounds(244, 315, 105, 54);
            city_btn_array[1].setBounds(244, 209, 105, 54);
            city_btn_array[2].setBounds(145, 268, 105, 54);
            city_btn_array[3].setBounds(145, 370, 105, 54);
            city_btn_array[4].setBounds(244, 431, 105, 54);
            city_btn_array[5].setBounds(355, 370, 105, 54);
            city_btn_array[6].setBounds(355, 268, 105, 54);
            city_btn_array[7].setBounds(399, 165, 105, 54);
            city_btn_array[8].setBounds(114, 165, 105, 54);
            city_btn_array[9].setBounds(14, 315, 105, 54);
            city_btn_array[10].setBounds(114, 473, 105, 54);
            city_btn_array[11].setBounds(399, 473, 105, 54);
            city_btn_array[12].setBounds(501, 315, 105, 54);
        }
    }
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img_MAIN, 0, 0, 1200, 960, this);
        }
    }
}