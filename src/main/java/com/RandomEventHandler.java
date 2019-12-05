package com;

import lombok.Data;

/**
 * 20가지의 랜덤 이벤트를 다루는 클래스
 * 
 * @author Chanho Park
 */

public class RandomEventHandler
{
    /**
     * 이벤트를 진행할 플레이어, 진행할 이벤트 종류를 지정하면 그에 맞는 이벤트를 불러오는 메소드
     *
     * @param player
     *        이벤트를 진행할 플레이어
     * @param event_num
     *        이벤트 종류
     */

    static public void RandomEventIndicator(Player player, int event_num)
    {

        switch(event_num)
        {
            case 0:
            Rev1(player);
            break;
            case 1:
            Rev2(player);
            break;
            case 2:
            Rev3(player);
            break;
            case 3:
            Rev4(player);
            break;
            case 4:
            Rev5(player);
            break;
            case 5:
            Rev6(player);
            break;
            case 6:
            Rev7(player);
            break;
            case 7:
            Rev8(player);
            break;
            case 8:
            Rev9(player);
            break;
            case 9:
            Rev10(player);
            break;
            case 10:
            Rev11(player);
            break;
            case 11:
            Rev12(player);
            break;
            case 12:
            Rev13(player);
            break;
            case 13:
            Rev14(player);
            break;
            case 14:
            Rev15(player);
            break;
            case 15:
            Rev16(player);
            break;
            case 16:
            Rev17(player);
            break;
            case 17:
            Rev18(player);
            break;
            case 18:
            Rev19(player);
            break;
            case 19:
            Rev20(player);
            break;
            case 20:
                Rev21(player);
                break;
        }
    }
    /**
     * 랜덤 이벤트1
     * 당신은 비밀결사의 집회가 오늘 밤 이곳에서 열린다는 것을 들었다.
     * 1. 참가한다.
     * 2. 참가하지 않는다.
     *
     * 1)당신은 집회에 가보기로 했습니다. //Rev1_sub1 메소드 호출
     * 2)위험해보입니다. 그런 곳은 가지 않는 것이 상책입니다. // 아무 일도 일어나지 않음
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev1(Player player)
    {
        String message="당신은 비밀결사의 집회가 오늘 밤 이곳에서 열린다는 것을 들었다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 참가한다.","1_1");
        Answer answer2=new Answer("2. 참가하지 않는다.","1_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트1-서브1
     * "고통은 인간을 계몽시키지." 비밀 결사의 교주가 말한다. "동의하는가?"
     * 1. 동의한다.
     * 2. 동의하지 않는다.
     *
     * 1)"고통을 받아들여라." 교주가 당신에게 낙인을 찍습니다.//체력-2, 정신력+2
     * 2)"때로는 피할 수 없는 고통도 있는 법이지." 교주가 당신에게 저주를 날립니다.//체력-1, 정신력-1
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev1_sub1(Player player)
    {
        String message="\"고통은 인간을 계몽시키지.\" 비밀 결사의 교주가 말한다. \"동의하는가?\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 동의한다.","1_1_1");
        Answer answer2=new Answer("2. 동의하지 않는다.","1_1_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
        /**
     * 랜덤 이벤트2
     * 정체를 알 수 없는 메아리 소리에 마음이 불안해졌습니다.
     * 1. 소리가 닿지 않는 곳으로 숨는다.
     * 2. 소리가 들리는 곳으로 따라간다.
     *
     * 1)민첩 체크-3이상
     * 성공 시 아무 일도 일어나지 않음//소리가 닿지 않는 곳으로 성공적으로 피했습니다.
     * 실패 시 정신력-2//메아리 소리에 정신이 아득해졌습니다.
     * 2)전투 발생-나이트건트//소리를 내는 기괴한 생물체를 발견했습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev2(Player player)
    {
        String message="정체를 알 수 없는 메아리 소리에 마음이 불안해졌습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 소리가 닿지 않는 곳으로 숨는다.","2_1");
        Answer answer2=new Answer("2. 소리가 들리는 곳으로 따라간다.","2_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트3
     * 파이트 클럽의 회원들이 당신에게 비무장 싸움을 제안합니다.
     * 1. 싸운다.
     * 2. 싸우지 않는다.
     *
     * 1)힘 체크-6이상
     * 성공 시 소지금+5//당신은 훌륭하게 적을 꺾었고, 파이트 머니를 얻었습니다.
     * 실패 시 정신력-1, 체력-2//당신은 처참하게 적에게 패배했고, 그들은 당신을 내버려둔채 떠났습니다.
     * 2)아무 일도 일어나지 않음//회원들이 당신에게 겁쟁이라고 욕했지만, 당신은 아랑곳하지 않고 자리를 떠났습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev3(Player player)
    {
        String message="파이트 클럽의 회원들이 당신에게 비무장 싸움을 제안합니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 싸운다.","3_1");
        Answer answer2=new Answer("2. 싸우지 않는다.","3_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
        /**
     * 랜덤 이벤트4
     * 기차역에서 터번을 둘러쓰고 얼굴에서 광기가 느껴지는 한 사람이 내렸습니다.
     * 1. 다가간다.
     * 2. 지켜본다.
     * 3. 자리를 떠난다.
     *
     * 1)주사위 체크-5이상
     * 성공 시 무작위 아이템 1개 획득//그가 망토 속에서 기이한 물건 하나를 꺼내 당신에게 건네줍니다.
     * 실패 시 주사위 체크 값만큼 체력 손실//그는 갑자기 망토 속에서 독을 바른 칼날을 꺼내 당신을 찌릅니다.
     * 2)정신력-1//우연히 그와 눈이 마주치자 당신의 영혼의 일부가 손실된 것처럼 허전해집니다.
     * 3)nothing//불길한 사람입니다. 자리에서 떠납니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev4(Player player)
    {
        String message="기차역에서 터번을 둘러쓰고 얼굴에서 광기가 느껴지는 한 사람이 내렸습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 다가간다.","4_1");
        Answer answer2=new Answer("2. 지켜본다.","4_2");
        Answer answer3=new Answer("3. 자리를 떠난다.","4_3");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
        DialogPanelController.show_dialog_answer3(answer3);
    }
        /**
     * 랜덤 이벤트5
     * 상점 뒤쪽을 어슬렁거리는 중에 뭔가 소음이 들립니다.
     * 1. ?!
     *
     * 1)민첩 체크-3이상,주사위 체크 3이상
     * 성공 시 nothing//당신을 가격하는 몽둥이를 피했습니다.
     * 실패 시 랜덤 장소로 이동&해당 장소에서 랜덤 이벤트 한번 더//당신을 가격하는 몽둥이를 피하지 못했습니다. 눈앞이 캄캄해집니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev5(Player player)
    {
        String message="상점 뒤쪽을 어슬렁거리는 중에 뒤에서 소음이 들립니다. ";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. ?!","5_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트6
     * 기이한 조각상이 있다는 소문을 듣습니다.
     * 1. 조각상을 조사한다.
     * 2. 무시한다.
     *
     * 1)지능 체크-6이상
     * 성공 시 민첩+1//조각상 안에 숨겨져 있던 주문을 해제하는 것을 성공했습니다. 알 수 없는 힘이 온 몸을 휘감습니다.
     * 실패 시 힘-1, 민첩-1//으스스한 공포가 온 몸을 휘감습니다.
     * 2)nothing//불길한 소문입니다. 무시합니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev6(Player player)
    {
        String message="기이한 조각상이 있다는 소문을 듣습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 조각상을 조사한다.","6_1");
        Answer answer2=new Answer("2. 무시한다.","6_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트7
     * 기차역의 화물 적재 플랫폼에서 기이한 문장이 있는 커다란 상자를 발견했습니다.
     * 1. 상자를 열어본다.
     * 2. 떠난다.
     *
     * 1)민첩체크-3이상, 주사위 체크-4이상
     * 성공 시 무작위 아이템 1개 획득//상자를 열고 신비로운 힘이 느껴지는 물건을 얻었습니다.
     * 실패 시 무작위 위치로 이동//상자를 여는 것을 경비원에게 들켰습니다.
     * 2)nothing//호기심이 고양이를 죽이는 법입니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev7(Player player)
    {
        String message="기차역의 화물 적재 플랫폼에서 기이한 문장이 있는 커다란 상자를 발견했습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 상자를 열어본다.","7_1");
        Answer answer2=new Answer("2. 떠난다.","7_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트8
     * 신문사에서 신비한 이야기를 제보받고 있습니다.
     * 1. 제보한다.
     * 2. 제보하지 않는다.
     *
     * 1)토큰 개수 체크-3이상
     * 성공 시 소지금+5//이야기를 제보하고 5$를 받습니다.
     * 실패 시 nothing//할 이야기가 없습니다.
     * 2)nothing//이런 이야기는 사람들에게 알려져서는 안됩니다. 제보하지 않습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev8(Player player)
    {
        String message="신문사에서 신비한 이야기를 제보받고 있습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 제보한다.","8_1");
        Answer answer2=new Answer("2. 제보하지 않는다.","8_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트9
     * "우리 조직에 들어오겠소?" 파이트 클럽의 회원들이 당신을 둘러싸며 묻습니다.
     * 1. 수락한다.
     * 2. 거절한다.
     *
     * 1)소지금 체크-3이상
     * 성공 시 소지금-3, 힘+2//당신은 이제 자랑스러운 파이트 클럽의 회원입니다.
     * 실패 시 힘 체크-3이상
     * 	    성공 시 nothing//충분한 돈이 없습니다.
     * 	    실패 시 체력-3//"돈도 없으면서 허세를 부린건가?" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.
     * 2)힘 체크-3이상
     * 성공 시 nothing//그런 조직에 쓸 시간도, 돈도 없습니다.
     * 실패 시 체력-3//"우리 조직을 무시하다니." 회원들에게 흠씬 맞고 문밖으로 내던져집니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev9(Player player)
    {
        String message="\"우리 조직에 들어오겠소?\" 파이트 클럽의 회원들이 당신을 둘러싸며 묻습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 수락한다.","9_1");
        Answer answer2=new Answer("2. 거절한다.","9_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트10
     * 잘 차려입은 남자가 기차역 플랫폼에 서 있습니다. 그가 당신을 향해 돌아보며 당신의 이름을 부릅니다. 이상하게도 친숙해 보이지만 전에 어디서 만났는지 기억나지 않습니다. 기차가 빠르게 달려오는 기찻길로 그가 갑자기 떨어집니다.
     * 1. 그를 구한다.
     * 2. 기억나지 않는 사람이다. 내버려둔다.
     *
     * 1)민첩 체크-6이상,주사위 체크-4이상
     * 성공 시 힘,민첩,지능 1 증가//그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.
     * 실패 시 주사위 값만큼 정신력 감소//그가 당신의 눈 앞에서 소멸됩니다.
     * 2)nothing//정말 그는 당신이 모르는 사람일까요?
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev10(Player player)
    {
        String message="잘 차려입은 남자가 기차역 플랫폼에 서 있습니다. 그가 당신을 향해 돌아보며 당신의 이름을 부릅니다. 이상하게도 친숙해 보이지만 전에 어디서 만났는지 기억나지 않습니다. 기차가 빠르게 달려오는 기찻길로 그가 갑자기 떨어집니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 그를 구한다.","10_1");
        Answer answer2=new Answer("2. 기억나지 않는 사람이다. 내버려둔다.","10_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트11
     * 한 길거리 가수가 기타를 치며 노래를 부르고 있습니다.
     * 1.'아름다운 음악이야.'
     *
     * 1)정신력+2//그의 연주를 듣고 있으니 마음 한구석이 치유되는 것 같습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev11(Player player)
    {
        String message="한 길거리 가수가 기타를 치며 노래를 부르고 있습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1.\'아름다운 음악이야.\'","11_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트12
     * 한 노인이 당신에게 말을 겁니다. "신비한 물건을 찾고 있나?"
     * 1. "어떻게 아셨죠?"
     * 2. 노인을 무시한다.
     *
     * 1)소지금 체크-3이상
     * 성공 시 소지금-3, 알 하자드의 램프 획득//"거래 고맙네." 노인은 갑자기 사라졌고, 당신은 주머니가 허전해짐과 동시에 손에 정체모를 램프가 들려있는 것을 발견합니다.
     * 실패 시 nothing//"이런..3달러도 없단 말인가?" 노인이 갑자기 사라집니다.
     * 2)정신력-1//"존중할줄 아는 자세가 필요하겠군." 노인이 갑자기 사라지고 당신은 현기증을 느낍니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev12(Player player)
    {
        String message="한 노인이 당신에게 말을 겁니다. \"신비한 물건을 찾고 있나?\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. \"어떻게 아셨죠?\"","12_1");
        Answer answer2=new Answer("2. 노인을 무시한다.","12_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트13
     * 당신은 이 도시가 다른 차원의 존재에 의해서 건설된 것이라는 문서를 보았다.
     * 1. (공포가 당신을 휘감는다.)
     *
     * 1)정신력-1//공포가 당신을 휘감습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev13(Player player)
    {
        String message="당신은 이 도시가 다른 차원의 존재에 의해서 건설된 것이라는 문서를 보았다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. (공포가 당신을 휘감는다.)","13_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트14
     * "앞, 뒤?" 기괴한 차림새의 도박사가 묻는다.
     * 1. 앞.
     * 2. 뒤.
     *
     * 1)민첩 체크-6 이상
     * 성공 시 무작위 아이템 1개 획득//"안타깝네, 뒤..." 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. "지만 참가상품도 있으니까!"
     * 실패 시 소지금-2//"안타깝네, 뒤야."
     * 2)민첩 체크-6 이상
     * 성공 시 무작위 아이템 1개 획득//"안타깝네, 앞..." 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. "이지만 참가상품도 있으니까!"
     * 실패 시 소지금-2//"안타깝네, 앞이야."
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev14(Player player)
    {
        String message="\"앞, 뒤?\" 기괴한 차림새의 도박사가 묻는다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 앞.","14_1");
        Answer answer2=new Answer("2. 뒤.","14_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트15
     * 당신이 사는 아파트의 거주민 중 일부를 잘 보니 당신을 불쾌하게 만드는 물고기와 같은 특징이 있습니다. 경비원이 당신이 어디를 보고 있는지 눈치채고는 끄덕이며 말합니다. "심해에서 건너온 것들이지. 옆에 있을 때 조심하시오."
     * 1. '심해 생물들이라고?'
     *
     * 1)정신력 1 감소//당신은 오싹한 기분을 느낍니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev15(Player player)
    {
        String message="당신이 사는 아파트의 거주민 중 일부를 잘 보니 당신을 불쾌하게 만드는 물고기와 같은 특징이 있습니다. 경비원이 당신이 어디를 보고 있는지 눈치채고는 끄덕이며 말합니다. \"심해에서 건너온 것들이지. 옆에 있을 때 조심하시오.\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. \'심해 생물들이라고?\'","15_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트16
     * 폐가에 있는 오래된 일기를 읽고 무시무시하고 섬뜩한 비밀을 알게 되었습니다.
     * 1. '이런 비밀이.'
     *
     * 1)정신력 1 감소, 토큰 1 증가//정신이 아득해지는 것을 느꼈지만, 단서 또한 얻었습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev16(Player player)
    {
        String message="폐가에 있는 오래된 일기를 읽고 무시무시하고 섬뜩한 비밀을 알게 되었습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. \'이런 비밀이.\'","16_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트17
     * 뉴스 헤드라인:"고대의 유령선이 도시 상공에 나타났다!"
     * 1. (진행)
     *
     * 1)맵의 무작위 위치에 괴물 2개체 추가//유령선이라...철 지난 농담같군요.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev17(Player player)
    {
        String message="뉴스 헤드라인:\"고대의 유령선이 도시 상공에 나타났다!\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. (진행)","17_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트18
     * 검은 정장의 사나이가 당신에게 거래를 제안합니다.
     * 1)거래한다.
     * 2)거래하지 않는다.
     *
     * 1)정신력만큼 주사위 체크-4이상
     * 실패할 때마다 정신력 1 감소
     * 정신력이 0이 되면 즉사 체크 없이 즉사//당신은 검은 정장의 사나이의 안으로 빨려들어가는 것을 느낍니다...
     * 성공 시 토큰 1개, 힘,민첩,지능 1 증가//당신은 이 미친 거래에서 살아남았습니다. 사나이는 당신에게 힘을 주고 떠나갑니다. "다음에 뵙겠습니다."
     * 2)nothing//"안타깝군요. 다음에는 거래에 응해주시길."
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev18(Player player)
    {
        String message="검은 정장의 사나이가 당신에게 거래를 제안합니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 거래한다.","18_1");
        Answer answer2=new Answer("2. 거래하지않는다.","18_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }
    /**
     * 랜덤 이벤트19
     * 뉴스 헤드라인:"빈민가에서 연쇄살인 발생!"
     * 1. (진행)
     *
     * 1)거주지역에 각각 몬스터 1개체씩 추가//이는 사람의 짓이 아닙니다. 괴물이 빈민가에 풀려난 것 같습니다.
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev19(Player player)
    {
        String message="뉴스 헤드라인:\"빈민가에서 연쇄살인 발생!\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. (진행)","19_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트20
     * 바로 전에 당신의 방에 살았던 손님이 급히 서둘러 떠나느라 무언가를 남겨놓았습니다.
     * 1. '쓸만한 물건인걸.'
     *
     * 1)무작위 아이템 1개 획득//써도 괜찮은 물건일까요?
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev20(Player player)
    {
        String message="바로 전에 당신의 방에 살았던 손님이 급히 서둘러 떠나느라 무언가를 남겨놓았습니다.";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. \'쓸만한 물건인걸.\'","20_1");
        DialogPanelController.show_dialog_answer1(answer1);
    }
    /**
     * 랜덤 이벤트21
     * 무언가에 홀린듯한 호텔 지배인이 당신에게 스위트룸 숙박을 제안합니다. "특가로 해드립죠."
     * 1. 제안을 받아들인다.
     * 2. 제안을 거절한다.
     *
     * 1)정신력 체크-6이상, 지능 체크-6이상
     * 성공 시 체력2, 정신력2 증가, 소지금 3 감소//역시나 함정이었지만, 당신의 뛰어난 정신력과 지식이 이를 막았습니다. 이제 뭘하냐고요? 스위트룸을 즐겨야죠.
     * 실패 시 정신력 4 감소, 소지금 3 감소//역시나 함정이었지만, 당신의 처참한 정신력과 낮은 지성은 이를 인지하지도 못하나보군요.
     * 2)nothing//함정에 제 발로 입장하는 바보는 없겠죠?
     * @param player
     *        이벤트를 진행할 플레이어
     */
    static public void Rev21(Player player)
    {
        String message="무언가에 홀린듯한 호텔 지배인이 당신에게 스위트룸 숙박을 제안합니다. \"특가로 해드립죠.\"";
        DialogPanelController.show_dialog(message);
        Answer answer1=new Answer("1. 제안을 받아들인다.","21_1");
        Answer answer2=new Answer("2. 제안을 거절한다.","21_2");
        DialogPanelController.show_dialog_answer1(answer1);
        DialogPanelController.show_dialog_answer2(answer2);
    }

}