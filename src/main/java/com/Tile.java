package com;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

/**
 * 타일 객체 모델, 각 타일은 자신의 소환된 몬스터나 차원문, 내부 이벤트를 관리한다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Tile {
    @Builder.Default
    private boolean summoned_portal=false;
    @Builder.Default
    private Monster summoned_monster=null;
    private final TileType tile_type;
}
