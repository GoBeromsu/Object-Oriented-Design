//package com;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GameMasterTest {
//    public static GameMaster gamemaster;
//    public static Player cur_player;
//
//    @BeforeEach
//    void setUp() {
//        gamemaster = GameMaster
//                .builder()
//                .build();
//        gamemaster.initiateGame();
//        cur_player = gamemaster.getCurrentPlayer();
//    }
//
//    @Test
//    void test_moveTo(){
//
//        // moveTo() method should return where current player is.
//        assertEquals(
//                TileType.C,
//                gamemaster.moveTo(
//                        cur_player,
//                        TileType.C
//                )
//        );
//
//        // after moveTo() method, player should be position used at moveTo().
//        assertEquals(cur_player.getPos(), TileType.C);
//    }
//
//
//}