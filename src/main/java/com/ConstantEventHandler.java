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
 * ?��?�� 조건?��?�� 반드?�� ?��?��?��?��?��?�� ?��벤트?��?�� ?��리한 ?��?��?��
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    /** shop() ?���??��?�� ?��?�� �??���?, ?��?��?�� arraylist ?��?��. */
    static ArrayList<ItemType> itemlist=new ArrayList<ItemType>();

    /**
     * shop()�? ?��?��?�� ?�� 구매 ?�� ?��?�� ?��?��?�� 목록?�� 존재?���?�?  ?��면에 출력?�� ?��?��?�� 목록?�� ?��?��?��?�� ?��?��?��?��.
     */
    static boolean shop_maintain_switch=false;

    /** @Deprecated ?���? ?��?��?��?���? �??��?�� ?��?��?*/
    public static int fight_remain=0;

    /**
     * ?��?�� ?��벤트�? 발생?��?��?�� 메소?��
     * @param player
     * ?��?�� ?��벤트�? 진행?�� ?��?��?��?��
     */
    static void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*21);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }

    /**
     * 맵을 ?���??��?�� ?��?��?��?���? ?��?��?��?���? ?�� ?�� ?��?��?��?��?�� 메소?��
     * @param player
     * ?��?�� ?��?��?��?��
     * @param tile
     * 목적�?
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
     * ?��벤트�? ?��?�� ?��?��?��?���? ?��?��?��?�� ?�� ?�� ?��?��?��?��?�� 메소?��
     * <br>?�� ?��벤트�? ?��?�� ?��벤트�? 발생?��?��?��?�� 곳으�? �? 경우?��?�� ?��벤트�? 발생?���? ?��?��?��.
     * @param player
     * ?��?�� ?��?��?��?��
     * @param tile
     * 목적�?
     * @throws IOException
     */
    static void movebyTeleport(Player player, TileType tile) throws IOException {
        player.setPos(tile);
    }
    /**
     * ?��?��?��?���? ???직인 ?��?�� ?���?, ???직일 ?��?��?��?��??? 목적�?�? 받아 ?��벤트 ?���?�? ?��?��?��?�� 메소?��
     * @param player
     *        ?��?�� ?��?��?��?��
     * @param tile
     *        목적�?
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
     * ?��?��?��?��?���? ?��?��?��?�� 추�???���? 그에 ????�� ?��?�� 추�??치�?? ?��?��?��?��?�� 메소?��
     * @param player
     * ?��?�� ?��?��?��?��
     * @param item
     * ?���? ?��?�� ?��?��?��
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
     * ?��?��?��?��?���? 무작?�� ?��?��?��?�� 추�???��?���? ?��?�� 추�??치�?? ?��?��?��?�� 메소?��
     * @param player
     * ?��?�� ?��?��?��?��
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
     * 병원 ?��벤트?�� �??�� 메소?��
     * @param player
     * 병원?�� ?��착한 ?��?��?��?��
     */
    static void hospital(Player player)
    {
        String message="병원?�� ?��착했?��?��?��. 치료받으?��겠습?���??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. 치료?��?��","hospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ?��?��?��","hospital2"));
    }
    /**
     * ?��?��병원 ?��벤트?�� �??�� 메소?��
     * @param player
     * ?��?��병원?�� ?��착한 ?��?��?��?��
     */
    static void mospital(Player player)
    {
        String message="?��?��병원?�� ?��착했?��?��?��. 치료받으?��겠습?���??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. 치료?��?��","mospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ?��?��?��","mospital2"));
    }

    /**
     * ?���? 몬스?�� ?��?�� 창으�? ?��?���?�? ?��?�� 메소?��
     * @param monster
     * ?��?��?�� 몬스?��
     * @throws IOException
     */
    public static void generateFight(MonsterType monster) throws IOException {
        Fight_monster_page fightwithmonster = new Fight_monster_page(new Monster(monster));
    }

    /**
     * 주사?�� 창을 출력?��?�� 메소?��
     * @return Dice.getSavedDice_num()
     * 1~6 중에 무작?���? ?��?��?�� int?��?�� �?
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
     * ?��?�� ?��?��?��?�� ?��?��?��?���? ?���??�� 금액?���? 구매?�� ?�� ?��?���? ?��?��?��?�� 메소?��
     * @param player
     * ?��?��?��?��
     * @param item
     * 구매?��?���? ?��?�� ?��?��?��
     * @return 구매 �??�� ?���?
     */
    static boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }

    /**
     * ?��?��?�� 구매 ?�� 구매 ?�� ?��?��?�� ?��?��?��?��?���? ?��겨주?�� 메소?��
     * @param player
     * ?��?��?��?��
     * @param item
     * 구매?�� ?��?��?��
     * @return 구매 ?�� ?��?��
     */
    static int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }

    /**
     * ?��?��?�� ?��착할 ?��마다 ?��?��?�� 리스?���? 갱신?��?�� 메소?��
     * @return 무작?���? ?��?��?�� ?��?��?�� 리스?��
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
     * 몬스?���? ?��?��?��?�� 메소?��
     * <br>몬스?��?�� 병원, ?��?��, ?��?��병원, ?��?��?��?���? ?��치하�? ?��?�� �?, ?��?��?��?�� 몬스?���? ?���? 존재?��?�� 곳에?�� ?��?��?�� ?�� ?��?��.
     * @param monster
     * ?��?��?�� 몬스?��
     * @param tile
     * 몬스?���? ?��?��?�� ?��?��
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
     * ?��?�� ?��벤트�? 진행?��?��?�� 메소?��
     */
    static void shop()
    {
        String message="?��?��?�� ?��착했?��?��?��. 구매?��?���? ?��?��?���??��?";
        DialogPanelController.show_dialog(message);

        if(!shop_maintain_switch)
        {
            itemlist=getRandomItemList();
        }

        StringBuilder itemInfo1 = new StringBuilder();
        if(itemlist.get(0)!=null){
            itemInfo1.append(itemlist.get(0).getName());
            itemInfo1.append("  ");
            itemInfo1.append("�?�?:");
            itemInfo1.append(itemlist.get(0).getPrice());}


        StringBuilder itemInfo2 = new StringBuilder();
        if(itemlist.get(1)!=null){
        itemInfo2.append(itemlist.get(1).getName());
        itemInfo2.append("  ");
        itemInfo2.append("�?�?:");
        itemInfo2.append(itemlist.get(1).getPrice());}


        StringBuilder itemInfo3 = new StringBuilder();
        if(itemlist.get(2)!=null){
        itemInfo3.append(itemlist.get(2).getName());
        itemInfo3.append("  ");
        itemInfo3.append("�?�?:");
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
            String message3="?��?��?�� 물건?��??? 모두 ?��?��?��?��?��. ?��?�� 번에 방문?��주시�?.";
            DialogPanelController.show_dialog(message3);
            Answer answer1 = new Answer("1. ?��?�� ?���?�?", "continue");
            DialogPanelController.show_dialog_answer1(answer1);
        }
    }
}