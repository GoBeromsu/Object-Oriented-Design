//package com;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ShopTest {
//    Item item;
//    GameMaster gamemaster;
//    Player cur_player;
//    Shop shop;
//    @BeforeEach
//    void setUp() {
//        item = Item
//                .builder()
//                .price(100)
//                .build();
//
//        gamemaster = GameMaster
//                .builder()
//                .build();
//        gamemaster.initiateGame();
//        cur_player = gamemaster.getCurrentPlayer();
//
//        shop = Shop
//                .builder()
//                .build();
//    }
//
//    @Test
//    void test_isAffordable(){
//        assertEquals(
//                cur_player.getMoney() > item.getPrice(),
//                Shop.isAffordable(cur_player, item)
//                );
//    }
//
//    @Test
//    void test_sellItem(){
//        int realchange = Shop.getChange(cur_player, item);
//        shop.sellItem(item, cur_player);
//        assertTrue(cur_player.getMoney() >= 0); // isAffordable이 잘 적용 되었는지
//        assertEquals(realchange, cur_player.getMoney());
//        assertTrue(cur_player.hasItem(item));
//    }
//}