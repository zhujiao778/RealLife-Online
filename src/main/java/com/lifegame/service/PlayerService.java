package com.lifegame.service;

import com.lifegame.dto.PlayerStatsVO;

/**
 * 玩家状态服务接口
 */
public interface PlayerService {

    /**
     * 获取玩家整体状态（包含六维属性）
     */
    PlayerStatsVO getPlayerStats();
}
