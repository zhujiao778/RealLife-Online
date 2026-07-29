package com.lifegame.service.impl;

import com.lifegame.dto.PomodoroCompleteVO;
import com.lifegame.entity.PlayerStats;
import com.lifegame.mapper.PlayerStatsMapper;
import com.lifegame.service.PomodoroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PomodoroServiceImpl implements PomodoroService {

    /** 番茄钟固定消耗 MP */
    private static final int POMODORO_MP_COST = 10;

    /** 番茄钟固定获得 EXP */
    private static final int POMODORO_EXP_REWARD = 150;

    private final PlayerStatsMapper playerStatsMapper;

    public PomodoroServiceImpl(PlayerStatsMapper playerStatsMapper) {
        this.playerStatsMapper = playerStatsMapper;
    }

    @Override
    @Transactional
    public PomodoroCompleteVO complete(Integer duration) {
        PlayerStats player = playerStatsMapper.selectById(1);
        if (player == null) {
            throw new RuntimeException("玩家数据不存在");
        }

        // 扣除 MP, 不能低于 0
        int newMp = Math.max(player.getMp() - POMODORO_MP_COST, 0);
        player.setMp(newMp);

        // 增加经验
        int newExp = player.getExp() + POMODORO_EXP_REWARD;
        String upgradeMsg = null;

        // 判断升级
        while (newExp >= player.getMaxExp()) {
            newExp -= player.getMaxExp();
            player.setLevel(player.getLevel() + 1);
            player.setMaxExp(player.getMaxExp() + 500);
            upgradeMsg = "恭喜升级到Lv." + player.getLevel();
        }

        player.setExp(newExp);
        playerStatsMapper.updateById(player);

        return new PomodoroCompleteVO(upgradeMsg);
    }
}
