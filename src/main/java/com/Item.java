package com;

import lombok.Builder;
import lombok.Data;

/**
 * 아이템 객체 모델
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Item {
    static private Item[] items;
    enum ItemType {
        a("엑스칼리버"),
        b("네크로노미콘");

        private String name;
        ItemType(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
// TODO : 아래 항목을 위에 ItemType으로 옮겨야 함. 단, index는 ordinal()메소드를 활용하기로 하고 나머지만 옮길 것!

//    itemlist[0].name="엑스칼리버";itemlist[0].p_power=2;itemlist[0].p_dex=1;itemlist[0].p_int=0;itemlist[0].p_health=1;itemlist[0].p_mental=0;
//​
//    itemlist[1].name="네크로노미콘";itemlist[1].p_power=0;itemlist[1].p_dex=0;itemlist[1].p_int=4;itemlist[1].p_health=0;itemlist[1].p_mental=-1;
//​
//    itemlist[2].name="빛나는 부등변다면체";itemlist[2].p_power=1;itemlist[2].p_dex=1;itemlist[2].p_int=1;itemlist[2].p_health=1;itemlist[2].p_mental=1;
//​
//    itemlist[3].name="황금의 벌꿀술";itemlist[3].p_power=2;itemlist[3].p_dex=0;itemlist[3].p_int=0;itemlist[3].p_health=2;itemlist[3].p_mental=0;
//​
//    itemlist[4].name="시간의 문제";itemlist[4].p_power=0;itemlist[4].p_dex=0;itemlist[4].p_int=2;itemlist[4].p_health=0;itemlist[4].p_mental=2;
//​
//    itemlist[5].name="이븐 가지의 분말";itemlist[5].p_power=1;itemlist[5].p_dex=1;itemlist[5].p_int=1;itemlist[5].p_health=0;itemlist[5].p_mental=0;
//​
//    itemlist[6].name="사냥개 부적";itemlist[6].p_power=2;itemlist[6].p_dex=2;itemlist[6].p_int=2;itemlist[6].p_health=-2;itemlist[6].p_mental=-2;
//​
//    itemlist[7].name="지혜의 열쇠";itemlist[7].p_power=0;itemlist[7].p_dex=0;itemlist[7].p_int=3;itemlist[7].p_health=0;itemlist[7].p_mental=0;
//​
//    itemlist[8].name="우주의 감로주";itemlist[8].p_power=1;itemlist[8].p_dex=1;itemlist[8].p_int=0;itemlist[8].p_health=2;itemlist[8].p_mental=0;
//​
//    itemlist[9].name="검은 파라오의 단장";itemlist[9].p_power=0;itemlist[9].p_dex=0;itemlist[9].p_int=0;itemlist[9].p_health=0;itemlist[9].p_mental=1;
//​
//    itemlist[10].name="알 하자드의 램프";itemlist[10].p_power=0;itemlist[10].p_dex=2;itemlist[10].p_int=1;itemlist[10].p_health=0;itemlist[10].p_mental=0;

    private int p_power;
    private int p_dex;
    private int p_int;
    private int p_health;
    private int p_mental;
    private ItemType name;
    private int price;

}
