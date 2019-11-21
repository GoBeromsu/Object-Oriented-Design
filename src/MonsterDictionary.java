package src;
/**
 * 몬스터 세부 사항들을 정의하는 클래스
 * @author Chanho Park
 */

public class MonsterDictionary
{
    private Monster[] monsterlist=new Monster[5];

    MonsterDictionary()
    {
        monsterlist[0].name="나이트건트";monsterlist[0].health=3;monsterlist[0].requireVal=3;monsterlist[0].damage=1;monsterlist[0].damageType=1;monsterlist[0].monsterresult=3;
        monsterlist[1].name="검은파라오";monsterlist[1].health=1;monsterlist[1].requireVal=6;monsterlist[1].damage=2;monsterlist[1].damageType=2;monsterlist[1].monsterresult=5;
        monsterlist[2].name="비야키";monsterlist[2].health=2;monsterlist[2].requireVal=2;monsterlist[2].damage=1;monsterlist[2].damageType=1;monsterlist[2].monsterresult=1;
        monsterlist[3].name="구울";monsterlist[3].health=4;monsterlist[3].requireVal=4;monsterlist[3].damage=2;monsterlist[3].damageType=1;monsterlist[3].monsterresult=4;
        monsterlist[4].name="옛 것";monsterlist[0].health=5;monsterlist[0].requireVal=4;monsterlist[0].damage=1;monsterlist[0].damageType=2;monsterlist[0].monsterresult=5;
    }
    /**
     * 몬스터 이름을 받아 그에 대응하는 몬스터를 반환하는 메소드
     * @param monster_num
     *        몬스터 번호
     * @return Monster
     *        해당 몬스터
     */
    public Monster getMonster(MonsterType monster)
    {
        return monsterlist[monster.getIndex()];
    }
}