package com;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 상점 객체 모델, 아이템을 살 때 필요한 각종 함수들이 모여있다. 일종의 핸들러이다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Shop {
    // TODO : 아이템 리스트로 업데이트하고, 상점 다이얼로그 창에 띄워줄 항목들은 어떻게 결정할 지 정해야함.
    private Item item;


}
