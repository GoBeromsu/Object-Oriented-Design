//package com;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BossTest {
//    public static Boss boss;
//    @BeforeAll
//    public static void makeInstance() throws Exception {
//        boss = Boss
//                .builder()
//                .type(Boss.BossType.NYARLATHOTEP)
//                .power(10)
//                .health(30)
//                .build();
//    }
//
//    @Test
//    void getName(){
//        assertEquals(Boss.BossType.NYARLATHOTEP, boss.getName());
//    }
//
//    @Test
//    void setPower() {
//        assertThrows(RuntimeException.class, ()->{boss.setPower(-1);});
//        assertThrows(RuntimeException.class, ()->{boss.setPower(0x113);});
//    }
//
//    @Test
//    void setHealth() {
//        assertThrows(RuntimeException.class, ()->{boss.setHealth(-1);});
//        assertThrows(RuntimeException.class, ()->{boss.setHealth(0x113);});
//    }
//
//}