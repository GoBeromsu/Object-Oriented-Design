package com;

import lombok.*;

/**
 * 선택지들을 이벤트와 연결하고, 선택지 안 텍스트를 가지고 있는 객체를 정의하는 클래스
 * @author Chanho Park
 */
@Getter
@Setter
public class Answer{
    private String message;
    private String tag;
    private ItemType item=null;

    /**
     * 선택지가 이벤트와 연관있는 경우의 생성자
     * @param message
     * 버튼에 출력될 메시지
     * @param tag
     * 실행하게 될 이벤트에 맞는 태그
     */
    Answer(String message, String tag)
    {
        this.message=message;
        this.tag=tag;
    }

    /**
     * 선택지가 아이템 구매와 연관있는 경우의 생성자
     * @param item
     * 구매할 아이템
     * @param message
     * 버튼에 출력될 메시지
     * @param tag
     * 상점관련 선택지라는 것을 지칭하는 태그
     */
    Answer(ItemType item, String message, String tag)
    {
        this.message=message;
        this.item=item;
        this.tag=tag;
    }
}