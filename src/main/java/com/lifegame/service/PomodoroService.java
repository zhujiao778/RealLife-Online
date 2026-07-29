package com.lifegame.service;

import com.lifegame.dto.PomodoroCompleteVO;

/**
 * 番茄钟服务接口
 */
public interface PomodoroService {

    /**
     * 完成一次番茄钟: 扣除玩家 10 MP, 增加 150 EXP, 判断升级
     */
    PomodoroCompleteVO complete(Integer duration);
}
