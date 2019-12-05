package com;

import GUI.MainGame_page;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainGamePageController {
    static public MainGame_page maingame_page;
    static public JButton[] dot_array;
    static public JLabel[] player1_array;
    static public JLabel[] player2_array;
    static public JLabel[] monster_array;
    static public JLabel[] portal_array;

    public MainGamePageController() throws IOException {
        maingame_page = new MainGame_page();
        dot_array = maingame_page.getBtn_reddot_array();
        player1_array = maingame_page.getLb_player1_array();
        player2_array = maingame_page.getLb_player2_array();
        monster_array = maingame_page.getMonster_array();
        portal_array = maingame_page.getPortal_array();
        show_players();
        show_monsters();
        show_portals();
        maingame_page.setVisible(true);
    }

    public static void update_token(int value) {
        maingame_page.getTab().getToken_text().setText(Integer.toString(value));
    }

    public static void update_status(int idx, StatusType type, int value) {
        // TODO : Need refactoring
        if (idx == 0)
            maingame_page.getPlayer1_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
        else
            maingame_page.getPlayer2_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
    }

    public static void show_reddot() {
        ArrayList<TileType> movable_tiles = Map.getMovableTiles(Player.getCurrentPlayer());
        for (TileType movable_tile : movable_tiles) {
            dot_array[movable_tile.ordinal()].setVisible(true);
            dot_array[movable_tile.ordinal()].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked " + movable_tile.ordinal());
                    try {
                        ConstantEventHandler.move(Player.getCurrentPlayer(), movable_tile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    // 모든 빨간 점을 보이지 않게 만들기
                    for (JButton reddot : dot_array) {
                        reddot.setVisible(false);
                    }
                    show_players();
                }
            });
        }
    }

    public static void show_players() {
        for (JLabel label : player2_array) {
            label.setVisible(false);
        }
        for (JLabel label : player1_array) {
            label.setVisible(false);
        }
        if (Player.getPlayer(0).getHealth() > 0 && Player.getPlayer(0).getMental() > 0)
            player1_array[Player.getPlayer(0).getPos().ordinal()].setVisible(true);
        if (Player.getPlayer(1).getHealth() > 0 && Player.getPlayer(1).getMental() > 0)
            player2_array[Player.getPlayer(1).getPos().ordinal()].setVisible(true);
    }

    public static void show_monsters() {
        for (JLabel lb_monster : monster_array)
            lb_monster.setVisible(false);
        for (TileType tile_type : TileType.values()) {
            Monster monster = Map.getMonsterAt(tile_type);
            if (monster != null) {
                Image img_monster;
                try {
                    img_monster = ImageIO.read(MainGamePageController.class.getClassLoader().getResourceAsStream(monster.getImagepath()));
                } catch (IOException e) {
                    img_monster = null;
                    e.printStackTrace();
                }
                monster_array[tile_type.ordinal()].setIcon(new ImageIcon(img_monster));
                monster_array[tile_type.ordinal()].setVisible(true);
            }
        }
    }

    public static void show_portals() {
        for (JLabel lb_portal : portal_array)
            lb_portal.setVisible(false);
        for (TileType tile_type : TileType.values())
            if (Map.getPortalAt(tile_type))
                portal_array[tile_type.ordinal()].setVisible(true);
    }
}
