package com;

import GUI.MainGame_page;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 메인게임페이지에서 각종 라벨을 모델과 연계하여 업데이트하고, 상황에 따라 동적으로 라벨을 보여주기 위한 클래스이다.
 *
 * @author Se-Ok Jeon
 */
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

    /**
     * 메인게임페이지에서의 토큰 라벨을 업데이트한다.
     * @param value 메인게임페이지에서 출력되어야 하는 토큰의 수이다.
     */
    public static void update_token(int value) {
        maingame_page.getTab().getToken_text().setText(Integer.toString(value));
    }

    /**
     * 메인게임페이지의 플레이어 스테이터스 값을 업데이트 하는 메소드
     * @param idx 플레이어 구별을 위한 인덱스값
     * @param type 업데이트할 플레이어 스테이터스의 타입
     * @param value 업데이트할 수치 값
     */
    public static void update_status(int idx, StatusType type, int value) {
        // TODO : Need refactoring
        if (idx == 0)
            maingame_page.getPlayer1_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
        else
            maingame_page.getPlayer2_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
    }

    /**
     * 메인게임페이지에서 플레이어가 이동하는 선택지를 클릭하면 이동가능한 위치에 표시를 해주는 메소드이다.
     */
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

    /**
     * 플레이어를 메인게임페이지 맵에 출력하는 메소드로 플레이어의 위치가 변경될때, 맵을 업데이트 하기 위해 사용된다.
     */
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

    /**
     * 메인게임페이지의 맵에서 몬스터가 존재하는 타일에 몬스터를 출력하기 위한 메소드이다.
     */
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

    /**
     * 메인게임페이지의 맵에서 타일에 포탈을 출력하기 위한 메소드로
     * 포탈의 위치를 업데이트하거나 포탈을 제거할 때 사용된다.
     */
    public static void show_portals() {
        for (JLabel lb_portal : portal_array)
            lb_portal.setVisible(false);
        for (TileType tile_type : TileType.values())
            if (Map.getPortalAt(tile_type))
                portal_array[tile_type.ordinal()].setVisible(true);
    }
}
