package com.lifegame.controller;

import com.lifegame.common.Result;
import com.lifegame.dto.PlayerStatsVO;
import com.lifegame.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩家状态模块
 */
@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /** 1.1 获取玩家整体状态 */
    @GetMapping("/stats")
    public Result<PlayerStatsVO> getStats() {
        PlayerStatsVO vo = playerService.getPlayerStats();
        return Result.success(vo);
    }
}
