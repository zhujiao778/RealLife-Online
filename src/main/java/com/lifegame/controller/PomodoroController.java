package com.lifegame.controller;

import com.lifegame.common.Result;
import com.lifegame.dto.PomodoroCompleteDTO;
import com.lifegame.dto.PomodoroCompleteVO;
import com.lifegame.service.PomodoroService;
import org.springframework.web.bind.annotation.*;

/**
 * 番茄钟模块
 */
@RestController
@RequestMapping("/api")
public class PomodoroController {

    private final PomodoroService pomodoroService;

    public PomodoroController(PomodoroService pomodoroService) {
        this.pomodoroService = pomodoroService;
    }

    /** 4.3 专注打坐完成（番茄钟结算）—— 扣除 MP, 增加 EXP, 判断升级 */
    @PostMapping("/pomodoro/complete")
    public Result<PomodoroCompleteVO> complete(@RequestBody PomodoroCompleteDTO dto) {
        PomodoroCompleteVO vo = pomodoroService.complete(dto.getDuration());
        return Result.success(vo);
    }
}
