package com;
import java.util.ArrayList;

/**
 * 맵 객체 모델로, 맵의 부분 개념인 타일을 보다 쉽게 접근하는데 사용된다.(일종의 핸들러)
 *
 * @author Se-Ok Jeon
 * @version 1.0
 */
public class Map {
    public static Tile[] tiles;
    static private int[][] path_validating_data = {
            {2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}
    };

    /**
     * 플레이어와 이동하고 싶은 장소를 받아 해당 장소로의 이동가능 여부를 확인하는 메소드
     *
     * @return boolean 이동가능 여부
     */
    public static boolean pathValid(Player player, TileType where) {
        TileType cur_pos = Player.getCurrentPlayer().getPos();
        return path_validating_data[cur_pos.ordinal()][where.ordinal()] == 1;
    }

    public static Monster getMonsterAt(TileType pos) {
        return tiles[pos.ordinal()].getSummoned_monster();
    }

    public static boolean getPortalAt(TileType pos) {
        return tiles[pos.ordinal()].isSummoned_portal();
    }

    public static ArrayList<TileType> getMovableTiles(Player player) {
        ArrayList<TileType> result = new ArrayList<>();
        for (Tile tile : tiles) {
            if (pathValid(player, tile.getTile_type())) {
                result.add(tile.getTile_type());
            }
        }
        return result;
    }

}
