package com;

import GUI.Dice_page;
import GUI.Fight_monster_page;

import static com.GameMaster.isTherePlayer;
import static com.Map.*;

import java.io.IOException;
import java.util.ArrayList;


import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    /** shop() 내부에서 쓰일 변수로, 아이템 arraylist 이다. */
    static ArrayList<ItemType> itemlist=new ArrayList<ItemType>();

    /**
     * shop()를 사용할 때 구매 후 잔여 아이템 목록의 존재여부로  화면에 출력할 아이템 목록을 정하는데 사용된다.
     */
    static boolean shop_maintain_switch=false;

    public static int fight_remain=0;

    /**
     * 랜덤 이벤트를 발생시키는 메소드
     * @param player
     * 랜덤 이벤트를 진행할 플레이어
     */
    static void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*21);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }

    /**
     * 맵을 클릭하여 플레이어가 이동하려고 할 때 이동시키는 메소드
     * @param player
     * 해당 플레이어
     * @param tile
     * 목적지
     * @throws IOException
     */
    static public void move(Player player, TileType tile) throws IOException {
        boolean valid = pathValid(player, tile);

        if(valid)
        {
            player.setPos(tile);
            CheckEventHere(player, tile);
        }
    }

    /**
     *이벤트로 인해 플레이어가 이동해야 할 때 이동시키는 메소드
     * <br>이 이벤트로 인해 이벤트가 발생해야하는 곳으로 갈 경우에는 이벤트가 발생하지 않는다.
     * @param player
     * 해당 플레이어
     * @param tile
     * 목적지
     * @throws IOException
     */
    static void movebyTeleport(Player player, TileType tile) throws IOException {
        player.setPos(tile);
    }
    /**
     * 플레이어가 움직인 이후 호출, 움직일 플레이어와 목적지를 받아 이벤트 여부를 확인하는 메소드
     * @param player
     *        해당 플레이어
     * @param tile
     *        목적지
     */
    static public void CheckEventHere(Player player, TileType tile) throws IOException {
        if(Map.getPortalAt(tile))
        {
            fight_remain=2;
            generateFight(MonsterType.values()[(int) Math.floor(Math.random() * 5)]);

            if(player.getHealth() > 0)
            {
                GameMaster.token++;
                MainGamePageController.update_token(GameMaster.token);
                Map.tiles[tile.ordinal()].setSummoned_portal(false);
                MainGamePageController.show_portals();
            }
        }
        else if(Map.getMonsterAt(tile) != null)
        {
            fight_remain=1;
            ConstantEventHandler.generateFight(Map.getMonsterAt(tile).getMonster_type());
        }
        else if(tile == TileType.HOSPITAL)
        {
            hospital(player);
        }
        else if(tile == TileType.MENTAL_HOSPITAL)
        {
            mospital(player);
        }
        else if(tile == TileType.STORE)
        {
            shop();
        }
        else
        {
            DialogPanelController.Clear();
            DialogPanelController.generateGeneralDialogues();
        }

    }

    /**
     * 플레이어에게 아이템을 추가하고 그에 대한 능력 추가치를 적용시키는 메소드
     * @param player
     * 해당 플레이어
     * @param item
     * 얻게 되는 아이템
     */
    static void addItem(Player player, ItemType item)
    {
        ArrayList<ItemType> tempitems = player.getItems();
        tempitems.add(item);
        player.setItems(tempitems);
        player.setHealth(player.getHealth()+item.getHealth());
        player.setMental(player.getMental()+item.getMental());
        player.setPower(player.getPower()+item.getPower());
        player.setDexterity(player.getDexterity()+item.getDex());
        player.setIntelligence(player.getIntelligence()+item.getInt());
    }

    /**
     * 플레이어에게 무작위 아이템을 추가시키고 능력 추가치를 적용하는 메소드
     * @param player
     * 해당 플레이어
     */
    static void addRandomItem(Player player)
    {
        int tempRand=(int)Math.floor(Math.random()*15);
        ArrayList<ItemType> tempitems=player.getItems();
        tempitems.add(ItemType.values()[tempRand]);
        player.setItems(tempitems);
        player.setHealth(player.getHealth()+ItemType.values()[tempRand].getHealth());
        player.setMental(player.getMental()+ItemType.values()[tempRand].getMental());
        player.setPower(player.getPower()+ItemType.values()[tempRand].getPower());
        player.setDexterity(player.getDexterity()+ItemType.values()[tempRand].getDex());
        player.setIntelligence(player.getIntelligence()+ItemType.values()[tempRand].getInt());
    }


    /**
     * 병원 이벤트에 관한 메소드
     * @param player
     * 병원에 도착한 플레이어
     */
    static void hospital(Player player)
    {
        String message="병원에 도착했습니다. 치료받으시겠습니까?";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. 치료한다","hospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. 떠난다","hospital2"));
    }
    /**
     * 정신병원 이벤트에 관한 메소드
     * @param player
     * 정신병원에 도착한 플레이어
     */
    static void mospital(Player player)
    {
        String message="정신병원에 도착했습니다. 치료받으시겠습니까?";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. 치료한다","mospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. 떠난다","mospital2"));
    }

    /**
     * 일반 몬스터 전투 창으로 넘어가게 하는 메소드
     * @param monster
     * 전투할 몬스터
     * @throws IOException
     */
    public static void generateFight(MonsterType monster) throws IOException {
        Fight_monster_page fightwithmonster = new Fight_monster_page(new Monster(monster));
    }

    /**
     * 주사위 창을 출력하는 메소드
     * @return Dice.getSavedDice_num()
     * 1~6 중에 무작위로 선택된 int형의 값
     */
    public static int  Dice(){
        Dice_page Dice = new Dice_page();
        Dice.setVisible(true);

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Dice.dispose();
            }
        },1*1*1000);
        return Dice.getSavedDice_num();
    }

    /**
     * 해당 아이템이 플레이어가 소지한 금액으로 구매할 수 있는지 확인하는 메소드
     * @param player
     * 플레이어
     * @param item
     * 구매하려고 하는 아이템
     * @return 구매 가능 여부
     */
    static boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }

    /**
     * 아이템 구매 시 구매 후 잔액을 플레이어에게 넘겨주는 메소드
     * @param player
     * 플레이어
     * @param item
     * 구매한 아이템
     * @return 구매 후 잔액
     */
    static int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }

    /**
     * 상점에 도착할 때마다 아이템 리스트를 갱신하는 메소드
     * @return 무작위로 선정된 아이템 리스트
     */
    static ArrayList<ItemType> getRandomItemList()
    {
        ArrayList<ItemType> tempitemlist = new ArrayList<ItemType>();
        int old_temp1=18;
        int old_temp2=18;
        while(true)
        {
            int tempRand=(int)Math.floor(Math.random()*15);

            if(tempRand!=old_temp1&&tempRand!=old_temp2)
                tempitemlist.add(ItemType.values()[tempRand]);

            old_temp1=tempRand;
            old_temp2=old_temp1;

            if(tempitemlist.size()==3)
                break;
        }
        return tempitemlist;
    }

    /**
     * 몬스터를 생성하는 메소드
     * <br>몬스터는 병원, 상점, 정신병원, 플레이어가 위치하고 있는 곳, 포털이나 몬스터가 이미 존재하는 곳에는 생성될 수 없다.
     * @param monster
     * 생성될 몬스터
     * @param tile
     * 몬스터가 생성될 장소
     */
    static void CreateMonster(MonsterType monster, TileType tile)
    {
        if(isTherePlayer(Map.tiles[tile.ordinal()])
                &&Map.tiles[tile.ordinal()].getSummoned_monster() == null
                &&Map.tiles[tile.ordinal()].isSummoned_portal()==false
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.MENTAL_HOSPITAL
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.HOSPITAL
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.STORE)
        {
            Monster tempMon=new Monster(monster);
            Map.tiles[tile.ordinal()].setSummoned_monster(tempMon);
        }
    }

    /**
     * 상점 이벤트를 진행시키는 메소드
     */
    static void shop()
    {
        String message="상점에 도착했습니다. 구매하실게 있으신가요?";
        DialogPanelController.show_dialog(message);

        if(!shop_maintain_switch)
        {
            itemlist=getRandomItemList();
        }

        StringBuilder itemInfo1 = new StringBuilder();
        if(itemlist.get(0)!=null){
            itemInfo1.append(itemlist.get(0).getName());
            itemInfo1.append("  ");
            itemInfo1.append("가격");
            itemInfo1.append(itemlist.get(0).getPrice());}


        StringBuilder itemInfo2 = new StringBuilder();
        if(itemlist.get(1)!=null){
        itemInfo2.append(itemlist.get(1).getName());
        itemInfo2.append("  ");
        itemInfo2.append("가격");
        itemInfo2.append(itemlist.get(1).getPrice());}


        StringBuilder itemInfo3 = new StringBuilder();
        if(itemlist.get(2)!=null){
        itemInfo3.append(itemlist.get(2).getName());
        itemInfo3.append("  ");
        itemInfo3.append("가격");
        itemInfo3.append(itemlist.get(2).getPrice());}

        shop_maintain_switch=false;

        Answer item1 = new Answer(itemlist.get(0), itemInfo1.toString(), "shop");
        Answer item2 = new Answer(itemlist.get(1), itemInfo2.toString(), "shop");
        Answer item3 = new Answer(itemlist.get(2), itemInfo3.toString(), "shop");
        if(itemlist.get(0)!=null)
        DialogPanelController.show_dialog_answer1(item1);
        if(itemlist.get(1)!=null)
        DialogPanelController.show_dialog_answer2(item2);
        if(itemlist.get(2)!=null)
        DialogPanelController.show_dialog_answer3(item3);

        if(itemlist.get(0)==null&&itemlist.get(1)==null&&itemlist.get(2)==null)
        {
            DialogPanelController.Clear();
            String message3="오늘의 물건들은 모두 팔렸습니다. 다음 번에 방문해주시길.";
            DialogPanelController.show_dialog(message3);
            Answer answer1 = new Answer("1. 상점 나가기", "continue");
            DialogPanelController.show_dialog_answer1(answer1);
        }
    }
}