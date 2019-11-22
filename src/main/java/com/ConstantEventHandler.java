package com;

import static com.Map.*;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */

//public class ConstantEventHandler
//{
//    private Map m;
//    private GameMaster gamemaster = GameMaster.getInstance();
//    private RandomEventHandler randomeventhandler;
//
//    ConstantEventHandler(){
//        randomeventhandler = new RandomEventHandler();
//    }
//    /**
//     * 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
//     * @param player_num
//     *        해당 플레이어
//     * @param place_num
//     *        목적지
//     */
//    public void Move(Player player, TileType tile, Map Map)
//    {
//        int valid=m.pathValid(player.pos, tile);
//
//        if(valid==1)
//        {
//            player.pos=tile;
//            CheckEventHere(player, tile, Map);
//        }
//        else if(valid==0)
//        {
//            ShowDialog("이동할 수 없는 곳입니다");
//        }
//    }
//
//    /**
//     * 이동한 장소에 몬스터나 차원문이 있는지 확인하는 메소드.
//     * 확인 결과 몬스터가 있을 경우 전투를 발생시킨다.
//     * 확인 결과 차원문이 있을 경우 차원문 전투를 발생시킨다.
//     * @param place_num
//     *        이동한 장소
//     * @param player_num
//     *        도착한 플레이어
//     */
//    public void CheckEventHere(TileType where, Player player)
//    {
//        Monster monster = Map.getMonsterAt(where)
//
//        if(monster instanceof Monster)
//            GenerateFight(player, monster);
//        if(isPortal(where))
//            PortalClose(player, where);
//    }
//    /**
//     * 해당 장소에 차원문아 존재하는지 확인하는 메소드
//     * @param place_num
//     *        해당 장소
//     * @return int 존재 여부
//     */
//    public boolean isPortal(TileType where)
//    {
//        return Map.getPortalAt(where) ? true : false;
//    }
//    /**
//     * 차원문 전투를 수행하고 전투 성공 시 차원문을 제거하고 차원문 토큰을 추가하는 메소드
//     * @param place_num
//     *        해당 장소
//     * @param player_num 플레이어 식별자
//     *
//     */
//    public void PortalClose(Player player, TileType where)
//    {
//        GenerateFight(player, where);
//        if(gamemaster.getcurr.getHealth() > 0)
//        {
//            getTile(place_num).summoned_portal=0;
//            setToken(getToken()+1);
//        }
//    }
//
//    /**
//     * 일반 전투 화면을 출력하고 승리했을 경우 전리품을 획득하는 메소드
//     * @param player_num
//     *        전투를 수행할 플레이어
//     * @param monster_num
//     *        전투를 수행할 몬스터
//     */
//    public void GenerateFight(Player player, Monster monster)
//    {
////        ShowFightView(player_num, monster_num);
////        if(getPlayer(player_num).getHealth() > 0)
////        getPlayer(player_num).setMoney(getPlayer(player_num).getMoney()+getMonsterResult(monster_num));
//    }
//
//    /**
//     * 보스 전투 화면을 출력하는 메소드
//     */
////    public void GenerateBossFight()
////    {
////        ShowBossFight();
////    }
//
//    /**
//     * 랜덤 이벤트를 발생시키기 위한 메소드
//     * @param player_num
//     *        해당 이벤트를 수행할 플레이어
//     */
//    public void GenerateRandomEvent(Player player)
//    {
//        int ranVal = (int)Math.floor(Math.random()*21);
//        randomeventhandler.RandomEventIndicator(player, ranVal);
//    }
//
//    /**
//     * 이벤트를 통한 특정 장소로의 이동의 경우에 쓰이는 메소드, 이동가능 여부를 확인하지 않음
//     * @param player_num
//     *        이동할 플레이어
//     * @param place_num
//     *        이동 장소
//     */
//    public void Teleport(int player_num, int place_num)
//    {
//        gamemaster.getCurrentPlayer().setPosition(place_num);
//        RenewView();
//    }
//
//    /**
//     * 주사위 값이 필요한 경우에 호출되는 메소드
//     * @return int 주사위 값
//     */
//    public int RollDice()
//    {
//        int diceVal=ViewDice();
//        return diceVal;
//    }
//
//    /**
//     * 플레이어의 체력이나 정신력이 0이 되었을 경우 즉사 여부를 확인하기 위한 메소드.
//     * 즉사 여부를 확인할 때마다 굴릴 수 있는 주사위 수가 줄어든다.
//     * @param player_num
//     *        즉사 여부를 확인할 플레이어
//     * @param death_reason
//     *        사망 이유. 0-체력, 1-정신력
//     */
//    public void Death(int player_num, int death_reason)
//    {
//        int now_live=0;
//        for(int i=0;i<death_count;i++)
//        {
//            if(RollDice()>4)
//           { if(death_reason==1)                                         //체력이 0인 것이 사망 이유
//            getPlayer(player_num).setHealth(getPlayer(player_num).getHealth()+1);
//            else if(death_reason==2)                                    //정신력 0이 이유
//            getPlayer(player_num).setMental(getPlayer(player_num).getMental()+1);
//            now_live=1;
//            death_count--;
//            break;
//           }
//        }
//        if(now_live==0)
//        getPlayer(player_num).setStatus(2);
//
//    }
//
//    /**
//     * 플레이어1,2의 행동치(Energy)가 모두 0이 되었을 때 턴 종료를 위해 실행되는 메소드.
//     * 다음의 순서에 의해 실행된다.
//     * 1. 승리조건 확인-토큰 수가 10보다 크다.
//     * 2. 패배조건 확인-플레이어1,2 모두 스테이터스가 즉사 상태
//     * 3. 보스 소환 조건 확인-필드 위 몬스터 수가 7 이상 또는 차원문이 5개 이상
//     * 4. 몬스터, 차원문 랜덤 생성
//     * 5. 플레이어1,2 행동치 재생
//     */
//    public void TurnEnd()
//    {
//        if(getToken()>9)
//        ViewVictory();
//
//        if(getPlayer(1).getStatus()==2 && getPlayer(2).getStatus()==2)
//        ViewDefeat();
//
//        if(getMonsterCount()>6||getPortalCount()>4)
//        GenerateBossFight();
//
//        RandomGenerateMonster();
//        RandomGeneratePortal();
//
//        getPlayer(1).setEnergy(getPlayer(1).getHealth()/3);
//        getPlayer(2).setEnergy(getPlayer(2).getHealth()/3);
//    }
//
//    // 상점에서 아이템을 고르기 위해 선택지를 클릭 할 때, 이 함수부터 체크하여 구매가능한지 확인한 후 진행한다.
//    public static boolean isAffordable(Player player, Item item) {
//        return player.getMoney() > item.getPrice();
//    }
//    public static int getChange(Player player, Item item) {
//        return player.getMoney() - item.getPrice();
//    }
//    public void sellItem(Item item, Player player) throws RuntimeException {
//        if(!ConstantEventHandler.isAffordable(player, item))
//            throw new RuntimeException("현재 플레이어는 해당 아이템을 구매할 수 없습니다.");
//        ArrayList<Item> player_items = player.getItems();
//        player_items.add(item);
//        player.setMoney(getChange(player, item));
//        player.setItems(player_items);
//    }
//}
public class ConstantEventHandler
{
    void generateRandomEvent(){}
    public void move(Player player, TileType tile)
    {
        boolean valid = pathValid(player, tile);

        if(valid)
        {
            player.setPos(tile);
            CheckEventHere(player, tile);
        }
        else
        {
//            ShowDialog("이동할 수 없는 곳입니다");
        }
    }
    void movebyTeleport(Player player, TileType tile){}
    /**
     * 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
     * @param player
     *        해당 플레이어
     * @param tile
     *        목적지
     */
    public void CheckEventHere(Player player, TileType tile)
    {
        if(Map.getPortalAt(tile))
        {
//            GenerateFight(player);
            if(player.getHealth() > 0)
            {
                GameMaster.token++;                                                            // TODO : 토큰 어디 있는 속성인지 확인 요망
                Map.tiles[tile.ordinal()].setSummoned_portal(false);
            }
        }
        if(Map.getMonsterAt(tile) != null)
        {
//            GenerateFight();
            if(player.getHealth() > 0)
            {
                Map.tiles[tile.ordinal()].setSummoned_monster(null);
            }
        }

        if(tile == TileType.HOSPITAL)
        {
//            Hospital();
        }

        if(tile == TileType.MENTAL_HOSTPITAL)
        {
//            Mospital();
        }

        if(tile == TileType.STORE)
        {
//            Shop();
        }

    }
    void portalClose() {}
    void addItem(Player player, Item item){}
    void deleteItem(Player player, Item item){}
    void addRandomItem(Player player){}
    void hospital(Player player){}
    void mospital(Player player){}
    void generalFight(Monster monster){}
    boolean isAffordable(Player player, Item.ItemType item){return true;}
    int getChange(Player player, Item.ItemType item){return 0;}
    void sellItem(Player player, Item.ItemType item){}
    Item getItem(Item.ItemType item){return null;}
    Item[] getRandomItemList(){return null;}

}